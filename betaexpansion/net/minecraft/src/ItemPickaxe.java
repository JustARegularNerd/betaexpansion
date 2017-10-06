// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            ItemTool, Block, EnumToolMaterial, Material

public class ItemPickaxe extends ItemTool
{

    protected ItemPickaxe(int i, EnumToolMaterial enumtoolmaterial)
    {
        super(i, 2, enumtoolmaterial, blocksEffectiveAgainst, materialsEffectiveAgainst);
    }

    public boolean canHarvestBlock(Block block, int i)
    {
        if(block == Block.obsidian)
        {
            return toolMaterial.getHarvestLevel() == 3;
        }
        if(block == Block.blockDiamond || block == Block.oreDiamond)
        {
            return toolMaterial.getHarvestLevel() >= 2;
        }
        if(block == Block.blockGold || block == Block.oreGold)
        {
            return toolMaterial.getHarvestLevel() >= 2;
        }
        if(block == Block.blockSteel || block == Block.oreIron)
        {
            return toolMaterial.getHarvestLevel() >= 1;
        }
        if(block == Block.blockLapis || block == Block.oreLapis)
        {
            return toolMaterial.getHarvestLevel() >= 1;
        }
        if(block == Block.oreRedstone || block == Block.oreRedstoneGlowing)
        {
            return toolMaterial.getHarvestLevel() >= 2;
        }
        if(block.getBlockMaterial(i) == Material.rock)
        {
            return true;
        }
        return block.getBlockMaterial(i) == Material.iron;
    }

    private static Block blocksEffectiveAgainst[];
    private static Material materialsEffectiveAgainst[];
    static 
    {
    	blocksEffectiveAgainst = (new Block[] {
    		Block.cobblestone, Block.stairDouble, Block.stairSingle, Block.stone, Block.sandStone, Block.cobblestoneMossy, Block.oreIron, Block.blockSteel, Block.oreCoal, Block.blockGold, 
    		Block.oreGold, Block.oreDiamond, Block.blockDiamond, Block.ice, Block.netherrack, Block.oreLapis, Block.blockLapis, Block.stoneOvenActive, Block.stoneOvenIdle,
    		Block.brick, Block.dispenser, Block.stairCompactCobblestone, Block.mobSpawner, Block.oreRedstone, Block.oreRedstoneGlowing, Block.doorSteel, Block.pressurePlateStone,
    		Block.rail, Block.railDetector, Block.railPowered, BEBlocks.sandstoneBrick, BEBlocks.redSandstone, BEBlocks.stoneBrick, BEBlocks.brickStairs, BEBlocks.stoneBrickStairs,
    	});
    	materialsEffectiveAgainst = (new Material[] {
    		Material.rock, Material.iron	
    	});
    }
}
