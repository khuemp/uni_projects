bitsadmin.exe /TRANSFER "Download Z3" "https://github.com/Z3Prover/z3/releases/download/z3-4.8.6/z3-4.8.6-x64-win.zip" %TEMP%\z3.zip

tar -xvf %TEMP%\z3.zip
del %TEMP%\z3.zip

copy z3-4.8.6-x64-win\bin\libz3.dll %~dp0..\libs\
copy z3-4.8.6-x64-win\bin\libz3java.dll %~dp0..\libs\
rmdir /s /q z3-4.8.6-x64-win
