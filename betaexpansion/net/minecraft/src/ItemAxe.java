// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            ItemTool, Block, EnumToolMaterial

public class ItemAxe extends ItemTool
{

    protected ItemAxe(int i, EnumToolMaterial enumtoolmaterial)
    {
        super(i, 3, enumtoolmaterial, blocksEffectiveAgainst, materialsEffectiveAgainst);
    }

    public static Block blocksEffectiveAgainst[];
    public static Material materialsEffectiveAgainst[];

    static 
    {
    	blocksEffectiveAgainst = (new Block[] {
    		Block.planks, Block.bookShelf, Block.wood, Block.chest, Block.trapdoor, Block.doorWood, Block.workbench, Block.fence, Block.jukebox, Block.stairCompactPlanks,
    		Block.pumpkin, Block.signPost, Block.signWall, Block.musicBlock, Block.pressurePlatePlanks, Block.pumpkinLantern, BEBlocks.pumpkinLampActive, BEBlocks.pumpkinLampIdle,
    		BEBlocks.table
    	});
    	materialsEffectiveAgainst = (new Material[] {
    		Material.wood, Material.pumpkin	
    	});
    }
}
