package net.minecraft.src;

import java.util.HashMap;

public class mod_BetaExpansion extends BaseMod
{
	public mod_BetaExpansion()
	{
		origBlocksList = BEBlocks.origBlocksList;
		origItemsList = BEItems.origItemsList;
		BERecipes.init();
		ModLoader.AddLocalization("key.attack", "Attack");
		ModLoader.AddLocalization("key.use", "Use Item");
		ModLoader.AddLocalization("key.pickItem", "Pick Item");
		ModLoader.AddLocalization("key.hotbar.1", "Hotbar Slot 1");
		ModLoader.AddLocalization("key.hotbar.2", "Hotbar Slot 2");
		ModLoader.AddLocalization("key.hotbar.3", "Hotbar Slot 3");
		ModLoader.AddLocalization("key.hotbar.4", "Hotbar Slot 4");
		ModLoader.AddLocalization("key.hotbar.5", "Hotbar Slot 5");
		ModLoader.AddLocalization("key.hotbar.6", "Hotbar Slot 6");
		ModLoader.AddLocalization("key.hotbar.7", "Hotbar Slot 7");
		ModLoader.AddLocalization("key.hotbar.8", "Hotbar Slot 8");
		ModLoader.AddLocalization("key.hotbar.9", "Hotbar Slot 9");
		ModLoader.AddLocalization("key.screenshot", "Screenshot");
		ModLoader.AddLocalization("key.toggleGui", "Toggle GUI");
		ModLoader.AddLocalization("key.debug", "Debug");
		ModLoader.AddLocalization("key.fullscreen", "Fullscreen");
		ModLoader.AddLocalization("key.smoothCamera", "Smooth Camera");
		ModLoader.AddLocalization("key.togglePerspective", "Third Person View");

		
		canBlockGrass = Block.canBlockGrass.clone();
		canBlockGrass[Block.waterMoving.blockID] = true;
		canBlockGrass[Block.waterStill.blockID] = true;
		canBlockGrass[Block.lavaMoving.blockID] = true;
		canBlockGrass[Block.lavaStill.blockID] = true;
	}
	
	public String Version()
	{
		return version;
	}
	
    public static final float lerp(float d, float d1, float d2)
    {
        return d1 + d * (d2 - d1);
    }
	
    public static boolean debugMode = false;
	public static Block[] origBlocksList;
	public static Item[] origItemsList;
	public static final String[] grassTextures = new String[] 
			{"/betaexpansion/misc/gc_spring.png","/misc/grasscolor.png","/betaexpansion/misc/gc_autumn.png","/betaexpansion/misc/gc_winter.png"};
	public static final String[] foliageTextures = new String[] 
			{"/betaexpansion/misc/fc_spring.png","/misc/foliagecolor.png","/betaexpansion/misc/fc_autumn.png","/betaexpansion/misc/fc_winter.png"};
	public static final HashMap<BiomeGenBase, Integer> maxSnow = new HashMap<BiomeGenBase, Integer>();
	public static final float[] cropMultiplier = new float[] {1.2f, 1.0f, 0.8f, 0.4f}; 
	public static final float[][] saturation = new float[][] {{1.1f,1.1f,0.9f},{1.0f,1.0f,1.0f},{0.9f,0.9f,0.8f},{0.8f,0.8f,0.6f}};
	static
	{
		maxSnow.put(BiomeGenBase.rainforest, 1);
		maxSnow.put(BiomeGenBase.swampland, 2);
		maxSnow.put(BiomeGenBase.seasonalForest, 3);
		maxSnow.put(BiomeGenBase.forest, 2);
		maxSnow.put(BiomeGenBase.savanna, 1);
		maxSnow.put(BiomeGenBase.shrubland, 2);
		maxSnow.put(BiomeGenBase.taiga, 6);
		maxSnow.put(BiomeGenBase.desert, 1);
		maxSnow.put(BiomeGenBase.plains, 2);
		maxSnow.put(BiomeGenBase.iceDesert, 6);
		maxSnow.put(BiomeGenBase.tundra, 6);
		maxSnow.put(BiomeGenBase.hell, 0);
		maxSnow.put(BiomeGenBase.sky, 7);
	}
	public static boolean[] canBlockGrass;
	public static String version = "2.2";
	public static int protocolVersion = 2;
}
