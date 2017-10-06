// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            ItemTool, Block, EnumToolMaterial

public class ItemSpade extends ItemTool
{

    public ItemSpade(int i, EnumToolMaterial enumtoolmaterial)
    {
        super(i, 1, enumtoolmaterial, blocksEffectiveAgainst, materialsEffectiveAgainst);
    }

    public boolean canHarvestBlock(Block block, int i)
    {
        if(block == Block.snow)
        {
            return true;
        }
        return block == Block.blockSnow;
    }

    private static Block blocksEffectiveAgainst[];
    private static Material materialsEffectiveAgainst[];

    static 
    {
    	blocksEffectiveAgainst = (new Block[] {
    		Block.grass, Block.dirt, Block.sand, Block.gravel, Block.snow, Block.blockSnow, Block.blockClay, Block.tilledField, Block.slowSand, BEBlocks.redSand
    	});
    	materialsEffectiveAgainst = (new Material[] {
    		Material.grassMaterial, Material.ground, Material.clay, Material.sand, Material.snow, Material.builtSnow	
    	});
    }
}
