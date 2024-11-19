import argparse


from timeout_error import TimeoutError


VERBOSE = False

class colors:
    FAIL = "\033[91m" # red
    TIMEOUT = "\033[93m" # orange
    PASS = "\033[92m" # green
    OK = "\033[94m" # bright blue
    BOLD = "\033[1m"
    UNDERLINE = "\033[4m"
    HEADER = f"{OK}{BOLD}" # bright blue + bold
    FRAME = f"{UNDERLINE}\033[53m" # underline + overline
    END = "\033[0m" # end color

def get_argparser():
    argparser = argparse.ArgumentParser()
    argparser.add_argument('-f', '--filter', type=str, metavar='<regex>', help='only execute tests matching this regex')
    argparser.add_argument('-l', '--list', action='store_true', help='only list tests, don\'t execute')
    argparser.add_argument('-nc', '--no-color', action='store_true', help='disable colored output')
    return argparser

def run_tests(args, all_tests):

    num_passed = 0
    
    color = True
    
    if args.no_color:
        color = False
    
    for t in all_tests:
        try:
            print ('\n')

            if color:
                print (f"{colors.HEADER}Running test {t.get_name()} {colors.END}")
            else:
                print ('Running test', t.get_name())

            msg = t.run_test(color=color)

            if msg is None:
                if color:
                    print(f"{colors.PASS}PASS{colors.END}")
                else:
                    print("PASS")

                num_passed += 1
            else:
                if color:
                    print(f"{colors.FAIL}FAIL:{colors.END} {msg}")
                else:
                    print(f"FAIL: {msg}")

        except TimeoutError:
            if color:
                print(f"{colors.TIMEOUT}FAIL: time out{colors.END}")
            else:
                print("FAIL: time out")


    if color:
        print(f"\n{colors.FRAME}{colors.HEADER}Passed {num_passed} out of {len(all_tests)} tests.{colors.END}")
    else:
        print ('Passed {:d} out of {:d} tests.'.format(num_passed, len(all_tests)))

