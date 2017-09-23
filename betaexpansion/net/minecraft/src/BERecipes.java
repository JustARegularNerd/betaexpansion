package net.minecraft.src;

public class BERecipes {
	public static void init()
	{
        ModLoader.AddRecipe(new ItemStack(BEBlocks.stoneBrick), new Object[] {
                "##", "##", Character.valueOf('#'), Block.stone
            });
        ModLoader.AddRecipe(new ItemStack(BEBlocks.stoneBrick,1,2), new Object[] {
                "##", "##", Character.valueOf('#'), new ItemStack(BEBlocks.stoneBrick,1,0)
            });
        ModLoader.AddRecipe(new ItemStack(BEBlocks.stoneBrick,1,1), new Object[] {
                "#", "#", Character.valueOf('#'), new ItemStack(BEBlocks.stoneBrick,1,0)
            });
        ModLoader.AddRecipe(new ItemStack(BEBlocks.stoneBrick,1,3), new Object[] {
                "#X", "X#", Character.valueOf('#'), new ItemStack(BEBlocks.stoneBrick,1,0),
                Character.valueOf('X'), Block.stone
            });
        ModLoader.AddRecipe(new ItemStack(BEBlocks.sandstoneBrick), new Object[] {
                "##", "##", Character.valueOf('#'), Block.sandStone
            });
        ModLoader.AddRecipe(new ItemStack(BEBlocks.sandstoneBrick,1,2), new Object[] {
                "##", "##", Character.valueOf('#'), new ItemStack(BEBlocks.sandstoneBrick,1,0)
            });
        ModLoader.AddRecipe(new ItemStack(BEBlocks.sandstoneBrick,1,1), new Object[] {
                "#", "#", Character.valueOf('#'), new ItemStack(BEBlocks.sandstoneBrick,1,0)
            });
        ModLoader.AddRecipe(new ItemStack(BEBlocks.sandstoneBrick,1,3), new Object[] {
                "#X", "X#", Character.valueOf('#'), new ItemStack(BEBlocks.sandstoneBrick,1,0),
                Character.valueOf('X'), Block.sandStone
            });
        ModLoader.AddRecipe(new ItemStack(BEBlocks.sandstoneBrick, 1, 4), new Object[] {
                "##", "##", Character.valueOf('#'), BEBlocks.redSandstone
            });
        ModLoader.AddRecipe(new ItemStack(BEBlocks.sandstoneBrick,1,6), new Object[] {
                "##", "##", Character.valueOf('#'), new ItemStack(BEBlocks.sandstoneBrick,1,4)
            });
        ModLoader.AddRecipe(new ItemStack(BEBlocks.sandstoneBrick,1,5), new Object[] {
                "#", "#", Character.valueOf('#'), new ItemStack(BEBlocks.sandstoneBrick,1,4)
            });
        ModLoader.AddRecipe(new ItemStack(BEBlocks.sandstoneBrick,1,7), new Object[] {
                "#X", "X#", Character.valueOf('#'), new ItemStack(BEBlocks.sandstoneBrick,1,4),
                Character.valueOf('X'), BEBlocks.redSandstone
            });
        ModLoader.AddRecipe(new ItemStack(BEBlocks.redSandstone), new Object[] {
                "##", "##", Character.valueOf('#'), BEBlocks.redSand
            });
        ModLoader.AddRecipe(new ItemStack(BEBlocks.launcherBase), new Object[] {
                "PPP", "#$#", "#R#", Character.valueOf('#'), Item.ingotIron, Character.valueOf('$'), Item.ingotGold,
                Character.valueOf('R'), Item.redstoneRepeater, Character.valueOf('P'), Block.pistonBase
            });
        ModLoader.AddRecipe(new ItemStack(BEBlocks.ropeLadder, 2), new Object[] {
                "# #", "#X#", "# #", Character.valueOf('#'), Item.silk, Character.valueOf('X'), Item.stick
            });
        ModLoader.AddRecipe(new ItemStack(BEBlocks.brickStairs, 4), new Object[] {
                "#  ", "## ", "###", Character.valueOf('#'), Block.brick
            });
        ModLoader.AddRecipe(new ItemStack(BEBlocks.stoneBrickStairs, 4), new Object[] {
                "#  ", "## ", "###", Character.valueOf('#'), new ItemStack(BEBlocks.stoneBrick, 1)
            });
        ModLoader.AddRecipe(new ItemStack(Block.stairSingle, 3, 4), new Object[] {
                "###", Character.valueOf('#'), Block.brick
            });
        ModLoader.AddRecipe(new ItemStack(Block.stairSingle, 3, 5), new Object[] {
                "###", Character.valueOf('#'), new ItemStack(BEBlocks.stoneBrick, 1)
            });
        ModLoader.AddRecipe(new ItemStack(BEItems.spyGlass), new Object[] {
                "IGI", "W W", "IGI", Character.valueOf('I'), Item.ingotIron, Character.valueOf('G'), Block.glass, Character.valueOf('W'), Block.planks
            });
        ModLoader.AddRecipe(new ItemStack(BEBlocks.cryingObsidianIdle), new Object[] {
                " # ", "#X#", " # ", Character.valueOf('#'), Block.obsidian, Character.valueOf('X'), Block.blockLapis
            });
        ModLoader.AddShapelessRecipe(new ItemStack(BEItems.pieSlice.shiftedIndex,1, 0), new Object[] {
                Item.sugar, Item.wheat, Item.egg, new ItemStack(BEItems.berry,1, 0)
            });
        ModLoader.AddShapelessRecipe(new ItemStack(BEItems.pieSlice.shiftedIndex,1, 1), new Object[] {
                Item.sugar, Item.wheat, Item.egg, new ItemStack(BEItems.berry,1, 1)
            });
        ModLoader.AddRecipe(new ItemStack(BEBlocks.blockPie, 1, 6), new Object[] {
                "###", "###", Character.valueOf('#'), new ItemStack(BEItems.pieSlice, 1, 0)
            });
        ModLoader.AddRecipe(new ItemStack(BEBlocks.blockPie, 1, 0), new Object[] {
                "###", "###", Character.valueOf('#'), new ItemStack(BEItems.pieSlice, 1, 1)
            });
        ModLoader.AddRecipe(new ItemStack(BEBlocks.pumpkinLampIdle, 1), new Object[] {
                "A", "B", Character.valueOf('A'), new ItemStack(Block.pumpkin, 1), Character.valueOf('B'), Block.torchRedstoneActive
            });
        ModLoader.AddRecipe(new ItemStack(BEItems.battleAxeWood, 1), new Object[] {
                "###", "#X#", " X ", Character.valueOf('#'), new ItemStack(Block.planks, 1), Character.valueOf('X'), Item.stick
            });
        ModLoader.AddRecipe(new ItemStack(BEItems.battleAxeStone, 1), new Object[] {
                "###", "#X#", " X ", Character.valueOf('#'), new ItemStack(Block.cobblestone, 1), Character.valueOf('X'), Item.stick
            });
        ModLoader.AddRecipe(new ItemStack(BEItems.battleAxeIron, 1), new Object[] {
                "###", "#X#", " X ", Character.valueOf('#'), new ItemStack(Item.ingotIron, 1), Character.valueOf('X'), Item.stick
            });
        ModLoader.AddRecipe(new ItemStack(BEItems.battleAxeGold, 1), new Object[] {
                "###", "#X#", " X ", Character.valueOf('#'), new ItemStack(Item.ingotGold, 1), Character.valueOf('X'), Item.stick
            });
        ModLoader.AddRecipe(new ItemStack(BEItems.battleAxeDiamond, 1), new Object[] {
                "###", "#X#", " X ", Character.valueOf('#'), new ItemStack(Item.diamond, 1), Character.valueOf('X'), Item.stick
            });
	}
}
