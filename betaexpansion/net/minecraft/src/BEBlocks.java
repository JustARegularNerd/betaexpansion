package net.minecraft.src;

public class BEBlocks {
	public static Block[] origBlocksList;
	public static final Block stoneBrick;
	public static final Block sandstoneBrick;
	public static final Block appleLeaves;
	public static final Block appleSapling;
	public static final Block redSand;
	public static final Block redSandstone;
	public static final Block launcherBase;
	public static final Block launcherExtension;
	public static final Block ropeLadder;
	public static final Block wetSponge;
	public static final Block brickStairs;
	public static final Block stoneBrickStairs;
	public static final Block cryingObsidianIdle;
	public static final Block cryingObsidianActive;
	public static final Block berryBush;
	public static final Block blockPie;
	public static final Block pumpkinLampIdle;
	public static final Block pumpkinLampActive;
	static
	{
        brickStairs = (new BlockStairs(111, Block.brick)).setBlockName("brickStairs").disableNeighborNotifyOnMetadataChange();
		origBlocksList = Block.blocksList.clone();
		stoneBrick = (new BlockStoneBricks(100, 0)).setHardness(1.5F).setResistance(10F).setStepSound(Block.soundStoneFootstep).setBlockName("stoneBrick");
		appleLeaves = (new BlockAppleLeaves(140, 52)).setHardness(0.2F).setLightOpacity(1).setStepSound(Block.soundGrassFootstep).setBlockName("appleLeaves").disableStats().disableNeighborNotifyOnMetadataChange();
		appleSapling = (new BlockAppleSapling(141, 36)).setHardness(0.0F).setStepSound(Block.soundGrassFootstep).setBlockName("appleSapling").disableNeighborNotifyOnMetadataChange();
		redSand = (new BlockRedSand(104, 51)).setHardness(0.5F).setStepSound(Block.soundSandFootstep).setBlockName("redSand");
		redSandstone = (new BlockRedSandStone(105, 19)).setStepSound(Block.soundStoneFootstep).setHardness(0.8F).setBlockName("redSandstone");
		sandstoneBrick = (new BlockSandStoneBricks(106, 1)).setStepSound(Block.soundStoneFootstep).setHardness(0.8F).setBlockName("sandstoneBrick");
		launcherBase = (new BlockLauncherBase(107, 4, false)).setBlockName("launcherBase").disableNeighborNotifyOnMetadataChange();
        launcherExtension = (BlockLauncherExtension)(new BlockLauncherExtension(108, 4)).setBlockName("launcherExtension").disableNeighborNotifyOnMetadataChange();
        ropeLadder = (new BlockRopeLadder(109, 6)).setHardness(0.4F).setStepSound(Block.soundWoodFootstep).setBlockName("ropeLadder").disableNeighborNotifyOnMetadataChange();
        wetSponge = (new BlockWetSponge(110, 22)).setHardness(0.6F).setStepSound(Block.soundGrassFootstep).setBlockName("wetSponge");
        stoneBrickStairs = (new BlockStairs(112, stoneBrick)).setBlockName("stoneBrickStairs").disableNeighborNotifyOnMetadataChange();
        cryingObsidianIdle = (new BlockCryingObsidian(113, 38, false)).setHardness(10F).setResistance(2000F).setStepSound(Block.soundStoneFootstep).setBlockName("cryingObsidian");
        cryingObsidianActive = (new BlockCryingObsidian(114, 38, true)).setHardness(10F).setResistance(2000F).setLightValue(0.8F).setStepSound(Block.soundStoneFootstep).setBlockName("cryingObsidian");
        berryBush = (new BlockBerryBush(115, 7)).setHardness(0.0F).setStepSound(Block.soundGrassFootstep).setBlockName("berryBush");
        blockPie = (new BlockPie(116, 64)).setHardness(0.5F).setStepSound(Block.soundClothFootstep).setBlockName("blockPie").disableStats().disableNeighborNotifyOnMetadataChange();
        pumpkinLampIdle = (new BlockPumpkinLamp(117, false)).setHardness(1.0F).setStepSound(Block.soundWoodFootstep).setBlockName("pumpkinLampIdle").disableNeighborNotifyOnMetadataChange();
        pumpkinLampActive = (new BlockPumpkinLamp(118, true)).setHardness(1.0F).setStepSound(Block.soundWoodFootstep).setBlockName("pumpkinLampActive").disableNeighborNotifyOnMetadataChange();

        Item.itemsList[stoneBrick.blockID] = (new ItemStoneBrick(stoneBrick.blockID - 256));
        Item.itemsList[sandstoneBrick.blockID] = (new ItemStoneBrick(sandstoneBrick.blockID - 256));
        Item.itemsList[appleSapling.blockID] = (new ItemAppleSapling(appleSapling.blockID - 256));
        Item.itemsList[launcherBase.blockID] = (new ItemPiston(launcherBase.blockID - 256));
        Item.itemsList[blockPie.blockID] = (new ItemPie(blockPie.blockID - 256)).setItemName("pie");

        for(int i = 0; i < 256; i++)
        {
            if(Block.blocksList[i] != null && Item.itemsList[i] == null)
            {
                Item.itemsList[i] = new ItemBlock(i - 256);
            }
        }
		ModLoader.AddName(stoneBrick, "Stone Bricks");
		ModLoader.AddName(appleLeaves, "Apple Leaves");
		ModLoader.AddName(appleSapling, "Apple Sapling");
		ModLoader.AddName(redSand, "Red Sand");
		ModLoader.AddName(redSandstone, "Red Sandstone");
		ModLoader.AddName(sandstoneBrick, "Sandstone Bricks");
		ModLoader.AddName(launcherBase, "Launcher");
		ModLoader.AddName(ropeLadder, "Rope Ladder");
		ModLoader.AddName(wetSponge, "Wet Sponge");
		ModLoader.AddName(brickStairs, "Brick Stairs");
		ModLoader.AddName(stoneBrickStairs, "Stone Brick Stairs");
		ModLoader.AddName(cryingObsidianIdle, "Crying Obsidian");
		ModLoader.AddName(cryingObsidianActive, "Crying Obsidian");
		ModLoader.AddName(pumpkinLampIdle, "Pumpkin Lamp");
		ModLoader.AddName(pumpkinLampActive, "Pumpkin Lamp");
		ModLoader.AddName(blockPie, "Pie");
		ModLoader.AddLocalization("tile.stoneSlab.stoneBrick.name", "Stone Brick Slab");
		ModLoader.AddLocalization("tile.stoneSlab.brick.name", "Brick Slab");
		ModLoader.AddLocalization("blockPie.blue.name", "Blueberry Pie");
		ModLoader.AddLocalization("blockPie.red.name", "Raspberry Pie");
		ModLoader.AddLocalization("tile.blockPie.blue.name", "Blueberry Pie");
		ModLoader.AddLocalization("tile.blockPie.red.name", "Raspberry Pie");
		ModLoader.AddLocalization("item.blockPie.blue.name", "Blueberry Pie");
		ModLoader.AddLocalization("item.blockPie.red.name", "Raspberry Pie");
	}
}
