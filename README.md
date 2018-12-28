# Setup

First off, you need to create a folder called mcp. Put the MCP files for beta 1.7.3 into this folder. Set up MCP in that folder as you would normally, but don't run any scripts. Make sure the minecraft.jar you use has ModLoader installed.
   
Once that is done, run setup.sh. This will apply some changes to MCP and run the decompile script. After that, run patch.sh to apply the BetaExpansion code to code in the src directory. 

For code editors, Eclipse is supported and the eclipse folder that mcp uses will work fine. Other editors should work too, just make sure you add the assets folder to the classpath. 




Running "extract.sh" will copy modified source files into the betaexpansion folder, replacing any source files already present.

Scripts from MCP can also be used.

# JustARegularNerd's Plans

I intend on changing a few recipes and porting this mod to ModLoaderMp.
