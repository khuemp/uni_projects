import sys
import subprocess
import shlex
from os import path

def get_test_sources(testPath, prefix="./"):
  return [testPath, prefix + "/src/turn.s", prefix + "/src/view.s", prefix + "/src/check.s"]

def dump_test_sources(testPath):
    return " ".join(get_test_sources(testPath))

def runMars(marsPath, sources, stderr=None):
    return runForOutput(marsPath + " ae1 me nc sm 1000000 " + (" ".join(sources)), stderr=stderr)

def runForOutput(cmdText,stderr=None):
    #print("CMD: {}".format(cmdText))
    cmd = shlex.split(cmdText)
    try:
        return 0, subprocess.check_output(cmd, stderr=stderr)
    except subprocess.CalledProcessError as err:
        return err.returncode, err.output

def runTest(testPath, dumpReference=False, prefix="./", marsPath="./mars"):
   sources = get_test_sources(testPath, prefix)
   refPath=testPath[0:-2] + ".ref"
   retCode, output = runMars(marsPath, sources, open("stderr.log", "w"))
   with open("stdout.log", "wb") as outStream:
      outStream.write(output)

   if retCode == 0:
      diffRet, diffOut = runForOutput("diff --strip-trailing-cr -w -q {} stdout.log".format(refPath))
      if diffRet == 0:
         print("success")
         return True
      else:
          print("failed: result differs")
          if dumpReference:
              print("Was:\n\"{}\n\"\nExpected:\n\"\n{}\n\"\n".format(open("stdout.log", 'r').read(), open(refPath, 'r').read()))
          return False

   elif retCode == 126:
      print("error: runtime failure, error message was:")
      print(open("stderr.log", "r").read())
   elif retCode == 127:
      print("error: assembler failed, error message was:")
      print(open("stderr.log", "r").read())
   else:
      print("error: mars terminated with value '{}', error message was:".format(retCode))
      print(open("stderr.log", "r").read())
   return False
