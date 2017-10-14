package net.minecraft.src;
import net.minecraft.client.Minecraft;

public class BETextureHelper {
	private static Minecraft mc = ModLoader.getMinecraftInstance();
	public static String block_path = "/betaexpansion/be_blocks.png";
	public static String item_path = "/betaexpansion/be_items.png";
	
	public static int getTextureFromIdAndMetadata(int i, int j)
	{
		if(i < 256)
		{
			if(BEBlocks.origBlocksList[i] == null || Block.blocksList[i].getRenderPass(mc.theWorld, i, j) == 2 ||
					Block.blocksList[i].getRenderBlockPass() == 2)
			{
				return mc.renderEngine.getTexture(block_path);
			}else
			{
				return mc.renderEngine.getTexture("/terrain.png");
			}
		}else
		{
        	if(mod_BetaExpansion.origItemsList[i] == null)
        	{
				return mc.renderEngine.getTexture(item_path);
        	}else
        	{
				return mc.renderEngine.getTexture("/gui/items.png");
        	}
		}
	}
	
	public static String getTextureName(int i, int j)
	{
		getTextureFromIdAndMetadata(i,j);
		if(i < 256)
		{
			if(BEBlocks.origBlocksList[i] == null || Block.blocksList[i].getRenderPass(mc.theWorld, i, j) == 2 ||
					Block.blocksList[i].getRenderBlockPass() == 2)
			{
				return block_path;
			}else
			{
				return "/terrain.png";
			}
		}else
		{
        	if(mod_BetaExpansion.origItemsList[i] == null)
        	{
				return item_path;
        	}else
        	{
				return "/gui/items.png";
        	}
		}
	}
}
