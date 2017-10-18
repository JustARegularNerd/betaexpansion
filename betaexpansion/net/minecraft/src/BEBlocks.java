package net.minecraft.src;

public class BEBlocks {
	public static Block[] origBlocksList;
	public static Block stoneBrick;
	public static Block sandstoneBrick;
	public static Block appleLeaves;
	public static Block appleSapling;
	public static Block redSand;
	public static Block redSandstone;
	public static Block launcherBase;
	public static Block launcherExtension;
	public static Block ropeLadder;
	public static Block wetSponge;
	public static Block brickStairs;
	public static Block stoneBrickStairs;
	public static Block cryingObsidianIdle;
	public static Block cryingObsidianActive;
	public static Block berryBush;
	public static Block blockPie;
	public static Block pumpkinLampIdle;
	public static Block pumpkinLampActive;
	public static Block table;
	public static void init()
	{
        brickStairs = (new BlockStairs(111, Block.brick)).setBlockName("brickStairs").disableNeighborNotifyOnMetadataChange();
		table = (new BlockTable(119, Block.planks.blockIndexInTexture)).setHardness(2.0F).setResistance(5F).setStepSound(Block.soundWoodFootstep).setBlockName("table");
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
        cryingObsidianIdle = (new BlockCryingObsidian(113, 84, false)).setHardness(10F).setResistance(2000F).setStepSound(Block.soundStoneFootstep).setBlockName("cryingObsidian");
        cryingObsidianActive = (new BlockCryingObsidian(114, 84, true)).setHardness(10F).setResistance(2000F).setLightValue(0.8F).setStepSound(Block.soundStoneFootstep).setBlockName("cryingObsidian");
        berryBush = (new BlockBerryBush(115, 7)).setHardness(0.0F).setStepSound(Block.soundGrassFootstep).setBlockName("berryBush");
        blockPie = (new BlockPie(116, 64)).setHardness(0.5F).setStepSound(Block.soundClothFootstep).setBlockName("blockPie").disableStats().disableNeighborNotifyOnMetadataChange();
        pumpkinLampIdle = (new BlockPumpkinLamp(117, false)).setHardness(1.0F).setStepSound(Block.soundWoodFootstep).setBlockName("pumpkinLampIdle").disableNeighborNotifyOnMetadataChange();
        pumpkinLampActive = (new BlockPumpkinLamp(118, true)).setHardness(1.0F).setStepSound(Block.soundWoodFootstep).setBlockName("pumpkinLampActive").disableNeighborNotifyOnMetadataChange();

        Item.itemsList[stoneBrick.blockID] = (new ItemStoneBrick(stoneBrick.blockID - 256));
        Item.itemsList[sandstoneBrick.blockID] = (new ItemStoneBrick(sandstoneBrick.blockID - 256));
        Item.itemsList[appleSapling.blockID] = (new ItemAppleSapling(appleSapling.blockID - 256));
        Item.itemsList[launcherBase.blockID] = (new ItemPiston(launcherBase.blockID - 256));
        Item.itemsList[blockPie.blockID] = (new ItemPie(blockPie.blockID - 256)).setItemName("pie");
        Item.itemsList[Block.grass.blockID] = (new ItemGrass(Block.grass.blockID - 256));
        Item.itemsList[Block.dirt.blockID] = (new ItemDirt(Block.dirt.blockID - 256));
        Item.itemsList[table.blockID] = (new ItemTable(table.blockID - 256));

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
		ModLoader.AddLocalization("tile.table.planks.name", "Wooden Table");
		ModLoader.AddLocalization("tile.table.log.name", "Log Table");
		ModLoader.AddLocalization("tile.table.cobblestone.name", "Cobblestone Table");
		ModLoader.AddLocalization("tile.table.stone.name", "Stone Table");
		ModLoader.AddLocalization("blockPie.blue.name", "Blueberry Pie");
		ModLoader.AddLocalization("blockPie.red.name", "Raspberry Pie");
		ModLoader.AddLocalization("tile.blockPie.blue.name", "Blueberry Pie");
		ModLoader.AddLocalization("tile.blockPie.red.name", "Raspberry Pie");
		ModLoader.AddLocalization("item.blockPie.blue.name", "Blueberry Pie");
		ModLoader.AddLocalization("item.blockPie.red.name", "Raspberry Pie");
	}
}
