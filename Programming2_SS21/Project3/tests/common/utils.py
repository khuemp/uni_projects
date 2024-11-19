import math
import re
import signal
import string
import sys
try:
    import numpy
    import scipy.stats
except:
    sys.exit('Cannot import scipy/numpy.\n'
             'Please install it using:\n'
             'sudo pacman -Sy python3-scipy glibc valgrind')
import subprocess
import threading


class TestFailure(Exception):
    def __init__(self, msg):
        self.msg = msg


def run(sut, args, cwd, timeout=1, verbose=False, debug=False, capt_out=True):
    call_args = [sut] + args

    out = subprocess.PIPE if capt_out else subprocess.DEVNULL

    proc = subprocess.Popen(call_args, stdout=out,
                            stderr=subprocess.STDOUT, cwd=cwd,
                            universal_newlines=True)
    res = {'out': '', 'status': -1}

    def reader():
        try:
            l = []
            sum_len = 0
            while True:
                s = proc.stdout.read(4096)
                if len(s) == 0:
                    break
                if sum_len > 10*1024*1024:
                    proc.terminate()
                else:
                    l.append(s)
                sum_len += len(s)
            if sum_len > 10*1024*1024:
                raise TestFailure('Program output exceeds limit of 10MB')
            output = ''.join(l)
            res['out'] = ''.join((c if c in string.printable else
                                  '\\x{:02x}'.format(ord(c)) for c in output))
            res['status'] = proc.wait()
        except Exception as e:
            res['error'] = e

    thread = threading.Thread(target=reader)
    thread.start()
    thread.join(timeout)
    if proc.poll() is None:
        proc.terminate()
        thread.join(2)
        if proc.poll() is None:
            proc.kill()
            thread.join()
        if 'error' not in res:
            raise TestFailure('Timeout ({} seconds) expired!'.format(timeout))

    if 'error' in res:
        raise res['error']

    return res['status'], res['out']


def parse_ranks(out, print_all=False, strs=None):
    res = {}
    for l in out.splitlines():
        if print_all:
            print(l)

        wds = l.split(None, 3)

        score = -1
        try:
            if len(wds) == 2:
                score = float(wds[1])
        except ValueError:
            pass

        if score < 0:
            raise TestFailure('Unexpected line of illegal format in output: {}'
                              .format(l))

        if wds[0] in res:
            raise TestFailure('Unexpectedly seeing score for node {} again'
                              .format(wds[0]))

        res[wds[0]] = score
        if strs is not None:
            strs[wds[0]] = wds[1]

    return res


def expect_scores(retcode, out, scores, delta=0.0, verbose=False, debug=False):
    expect_retcode(retcode, 0, out, verbose, debug)

    strs = {}
    res = parse_ranks(out, strs=strs)

    if len(res) != len(scores):
        raise TestFailure('Expecting to get scores for {} nodes, got {}'
                          .format(len(scores), len(res)))

    for n in scores:
        score = scores[n]
        if n not in res:
            raise TestFailure('No score for expected node: {}'.format(n))
        if math.isnan(res[n]):
            raise TestFailure('Returned NaN for node: {}'.format(n))
        diff = abs(res[n]-score)

        if diff > delta:
            raise TestFailure('Mismatch of score for node {}: Expecting {}, '
                              'got {} (allowed deviation: {}, got: {})'.
                              format(n, score, strs[n], delta, diff))


def expect_scoresum1(retcode, out, delta=1e-9, verbose=False, debug=False):
    expect_retcode(retcode, 0, out, verbose, debug)

    score_sum = 0
    for l in out.splitlines():
        wds = l.split(None, 3)

        score = -1
        try:
            if len(wds) == 2:
                score = float(wds[1])
        except ValueError:
            pass

        if score < 0:
            raise TestFailure('Unexpected line of illegal format in output: {}'
                              .format(l))

        score_sum += score

    diff = abs(1.0-score_sum)
    if diff > delta:
        raise TestFailure('Mismatch of score sum: Expecting 1.0 (+/- {}), '
                          'got {} (delta: {})'.format(delta, score_sum, diff))


def translate_retcode(retcode):
    s = '{}'.format(retcode)
    if (retcode == -signal.SIGSEGV):
        s += ' (SIGSEGV)'
    elif (retcode == -signal.SIGABRT):
        s += ' (SIGABRT)'
    elif (retcode == -signal.SIGTERM):
        s += ' (SIGTERM)'
    elif (retcode == -signal.SIGINT):
        s += ' (SIGINT)'
    elif (retcode == -signal.SIGILL):
        s += ' (SIGILL)'
    elif (retcode == -signal.SIGKILL):
        s += ' (SIGKILL)'
    elif (retcode == -signal.SIGBUS):
        s += ' (SIGBUS)'
    elif (retcode == -signal.SIGFPE):
        s += ' (SIGFPE)'
    return s


def expect_retcode(retcode, expectedret, out=None, verbose=False, debug=False):
    if retcode != -1 and retcode != expectedret:
        if verbose and out is not None:
            print('Program output:\n{}'.format(out))
        raise TestFailure('Wrong return code: expected {}, got {}'
                          .format(expectedret, translate_retcode(retcode)))

    if expectedret == -1 and retcode == 0:
        if verbose and out is not None:
            print('Program output:\n{}'.format(out))
        raise TestFailure('Expected a non-zero return code, got 0')


def expect_stats(retcode, out, name, nodes, edges, min_in, max_in, min_out,
                 max_out, verbose=False, debug=False):
    expect_retcode(retcode, 0, out, verbose, debug)

    lines = out.splitlines()

    if len(lines) != 5:
        raise TestFailure('Unexpected number of lines in statistics output: '
                          'expecting 5, got {}'.format(len(lines)))

    m = re.match('(.*):', lines[0])
    if m is None:
        raise TestFailure('Unexpected line \'{}\' while expecting the '
                          'identifier line'.format(lines[0]))

    c_name = m.group(1)
    if c_name != name:
        raise TestFailure('Name in stats not matching: expecting \'{}\', '
                          'got \'{}\''.format(name, c_name))

    m = re.match('- num nodes: (\d+)', lines[1])
    if m is None:
        raise TestFailure('Unexpected line \'{}\' while expecting num nodes '
                          'line'.format(lines[1]))
    c_nnodes = int(m.group(1))
    if c_nnodes != nodes:
        raise TestFailure('Unexpected number of nodes in stats: '
                          'expected {}, got {}'.format(nodes, c_nnodes))

    m = re.match('- num edges: (\d+)', lines[2])
    if m is None:
        raise TestFailure('Unexpected line \'{}\' while expecting num edges '
                          'line'.format(lines[2]))
    c_nedges = int(m.group(1))
    if c_nedges != edges:
        raise TestFailure('Unexpected number of edges in stats: expected {}, '
                          'got {}'.format(edges, c_nedges))

    m = re.match('- indegree: (\d+)-(\d+)', lines[3])
    if m is None:
        raise TestFailure('Unexpected line \'{}\' while expecting indegree line'
                          .format(lines[3]))
    c_min_in = int(m.group(1))
    if c_min_in != min_in:
        raise TestFailure('Unexpected minimum in-degree in stats: expected {}, '
                          'got {}'.format(min_in, c_min_in))
    c_max_in = int(m.group(2))
    if c_max_in != max_in:
        raise TestFailure('Unexpected maximum in-degree in stats: expected {}, '
                          'got {}'.format(max_in, c_max_in))

    m = re.match('- outdegree: (\d+)-(\d+)', lines[4])
    if m is None:
        raise TestFailure('Unexpected line \'{}\' while expecting outdegree '
                          'line'.format(lines[4]))
    c_min_out = int(m.group(1))
    if c_min_out != min_out:
        raise TestFailure('Unexpected minimum out-degree in stats: '
                          'expected {}, got {}'.format(min_out, c_min_out))
    c_max_out = int(m.group(2))
    if c_max_out != max_out:
        raise TestFailure('Unexpected maximum out-degree in stats: '
                          'expected {}, got {}'.format(max_out, c_max_out))


def test_distribution(sut, args, cwd, ref_measures,
                      timeout=2, p_min=0.001, verbose=False, debug=False):
    ranks = {i: [] for i in ref_measures}

    min_num_runs = min([len(m) for m in ref_measures.values()])
    max_num_runs = max([len(m) for m in ref_measures.values()])
    if min_num_runs != max_num_runs:
        raise AssertionError('number of reference values must be the same for '
                             'all nodes ({} != {})'.format(
                                 min_num_runs, max_num_runs))
    num_runs = 1000

    if debug:
        print('Executing {} runs...'.format(num_runs))

    for nr in range(num_runs):
        try:
            retcode, out = run(sut, args, cwd, 10, verbose, debug)
        except TestFailure as e:
            raise TestFailure('Error in run {}: {}'.format(nr, e.msg))

        if retcode != 0:
            raise TestFailure('Run {} failed with return code {}'.format(
                nr, translate_retcode(retcode)))

        try:
            res = parse_ranks(out)
        except TestFailure as e:
            raise TestFailure('Run {} produced illegal output: {}'.format(
                nr, e.msg))

        if len(res) != len(ranks):
            raise TestFailure('In run {}: Expecting to get scores for {} '
                              'nodes, got {}'.format(nr, len(ranks), len(res)))

        for node, rank in res.items():
            if node not in ref_measures:
                raise TestFailure('In run {}: Unknown node: {}'
                                  .format(nr, node))
            ranks[node].append(rank)

    error = None
    for node in sorted(ref_measures):
        ref = ref_measures[node]
        stud = ranks[node]
        ref_mean = numpy.mean(ref)
        ref_var = numpy.var(ref)
        stud_mean = numpy.mean(stud)
        stud_var = numpy.var(stud)

        p = scipy.stats.ks_2samp(ref, stud)[1]
        if debug:
            print('Node {}:\n  Ref:  {} +- {}\n  Stud: {} +- {}\n' \
                  '  p:    {} (must be >= {})' \
                  .format(node, ref_mean, ref_var, stud_mean, stud_var, p,
                          p_min))
        if p < p_min:
            msg = 'Statistical distribution does not match for node {}.\n' \
                '  Expected mean {}, variance {}; got mean {}, variance {}.\n' \
                '  K-S test says p={}, which is less than the required {}.' \
                .format(node, ref_mean, ref_var, stud_mean, stud_var, p,
                        p_min)
            if error is None:
                error = msg
            if debug:
                print(msg)

    if error is not None:
        raise TestFailure(error)
