// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            Block, Material

public class BlockDirt extends Block
{

    protected BlockDirt(int i, int j)
    {
        super(i, j, Material.ground);
    }
    
    public int getRenderPass(World world, int i, int j)
    {
    	if(j > 0 && j < 4)
    	{
    		return 2;
    	}else
    	{
    		return 0;
    	}
    }
    
    protected int damageDropped(int i)
    {
        return i < 4 ? i : 0;
    }
    
    public int getBlockTextureFromSideAndMetadata(int i, int j)
    {
    	if(j == 0)
    	{
    		return blockIndexInTexture;
    	}else
    	{
    		return 7 + j;
    	}
    }
}
