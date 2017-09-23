// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            Block, Material

public class BlockSandStoneBricks extends Block
{

    public BlockSandStoneBricks(int i, int j)
    {
        super(i, j, Material.rock);
    }

    public int idDropped(int i, Random random)
    {
        return BEBlocks.sandstoneBrick.blockID;
    }
    
    public int getBlockTextureFromSideAndMetadata(int i, int j)
    {
        return (j < 4 ? blockIndexInTexture : blockIndexInTexture + 1) + ((j%4)*16);
    }
    
    protected int damageDropped(int i)
    {
        return i;
    }
    
    public int getRenderBlockPass()
    {
        return 2;
    }
}
