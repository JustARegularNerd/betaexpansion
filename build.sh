#!/bin/bash
# recompile and reobfuscate source files,
# then bundle them into a zip archive

source config.sh

printf "betaexpansion build script $VERSION\n"
printf "\n"

read -p "enter version string > " VERSION_STR
ARCHIVE_NAME="$ARCHIVE_NAME""$VERSION_STR".zip

if [ -d "$BUILD_DIR"/"$VERSION_STR" ]; then
	printf "build directory already exists, aborting\n"
	exit 1
fi

cd "$MCP_DIR"
sh recompile.sh > /dev/null
printf "reobfuscating\n"
sh reobfuscate.sh > /dev/null 2>&1
cd ..

printf "packing archive\n"
mkdir -p "$BUILD_DIR"/"$VERSION_STR"
cd "$BUILD_DIR"/"$VERSION_STR"
mkdir files
cp -r ../../reobf/minecraft/* files
cp -r ../../assets/* files
zip -r "$ARCHIVE_NAME" * > /dev/null
rm -r files
printf "done.\n"
