// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            Block, Material

public class BlockStoneBricks extends Block
{

    public BlockStoneBricks(int i, int j)
    {
        super(i, j, Material.rock);
    }

    public int idDropped(int i, Random random)
    {
        return BEBlocks.stoneBrick.blockID;
    }
    
    public int getBlockTextureFromSideAndMetadata(int i, int j)
    {
    	if(i == 6)
    	{
    		return blockIndexInTexture;
    	}
        return blockIndexInTexture + (j & 3)*16;
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
