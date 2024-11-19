#! /bin/bash
SCRIPT_DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" &> /dev/null && pwd )"
BASE=$SCRIPT_DIR/..

set -e

# Check if the libs are already installed
if [ -f "$BASE/libs/libz3.so" ] && [ -f "$BASE/libs/libz3java.so" ]
then
	while true;
	do
		echo "Shared libraries are already present, do you wish to reinstall them? (y/n)"
		read answer

		case $answer in
			[Yy]* ) break;;
			[Nn]* ) exit;;
			* ) echo "Answer with 'y' or 'n'"
		esac
	done
fi

# Download the archive
echo "Downloading Z3."

if command -v curl --version &> /dev/null
then
	curl -L https://github.com/Z3Prover/z3/archive/refs/tags/z3-4.8.6.tar.gz -o z3-4.8.6.tar.gz
elif command -v wget --version &> /dev/null
then
	wget -q --show-progress https://github.com/Z3Prover/z3/archive/refs/tags/z3-4.8.6.tar.gz
else
	echo "Could not find curl or wget"
	exit 1
fi

# Unzip archive
tar -zxf z3-4.8.6.tar.gz
rm z3-4.8.6.tar.gz

# Build the source code
echo "Building source. This may take a while..."

cd z3-z3-4.8.6
python3 scripts/mk_make.py --java &> "$SCRIPT_DIR/log.txt"
cd build

# Be creative to find the number of processors in a cross-platform way.
# python must be installed anyway, otherwise we cant compile.
make -j $(python3 -c 'import multiprocessing as mp; print(int(mp.cpu_count() * 1.5))') &> "$SCRIPT_DIR/log.txt"

echo "Build successful."

# Copy the built shared libs to libs folder
echo "Installing shared libraries into libs/ folder."
cp libz3.so "$BASE/libs/"
cp libz3java.so "$BASE/libs/"

# Remove the source code
echo "Removing Z3 source."
cd "$BASE"
rm -rf z3-z3-4.8.6

# Remove log
rm "$SCRIPT_DIR/log.txt"

echo "Installation complete."

# Full installation is not necessary for the project
#sudo make install

