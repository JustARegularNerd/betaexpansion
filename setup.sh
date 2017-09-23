#!/bin/bash
# set up MCP

source config.sh

cp -r mcp-changes/* mcp
cd "$MCP_DIR"
sh decompile.sh
ln -nsf "$MCP_DIR/src" "../src"
ln -nsf "$MCP_DIR/reobf" "../reobf"
cd "eclipse/Client"
ln -nsf "../../../assets" "assets"
printf "\n"
printf "MCP setup complete, ready to patch.\n"
