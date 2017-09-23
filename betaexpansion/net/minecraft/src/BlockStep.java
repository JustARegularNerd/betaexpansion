// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import java.util.ArrayList;
import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            Block, Material, World, IBlockAccess

public class BlockStep extends Block
implements ITexInfo
{

    public BlockStep(int i, boolean flag)
    {
        super(i, 6, Material.rock);
        blockType = flag;
        if(!flag)
        {
            setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
        }else
        {
        	opaqueCubeLookup[i] = true;
        }
        setLightOpacity(255);
    }

    public void setBlockBoundsBasedOnState(IBlockAccess iblockaccess, int i, int j, int k)
    {
    	int l = iblockaccess.getBlockMetadata(i, j, k);
    	if(blockType)
    	{
            setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
    	}else
    	{
    		if(l > 5)
    		{
                setBlockBounds(0.0F, 0.5F, 0.0F, 1.0F, 1.0F, 1.0F);
    		}else
    		{
                setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
    		}
    	}
    }
    
    public void setBlockBoundsForItemRender()
    {
        setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, blockType?1.0F:0.5F, 1.0F);
    }
    
    public void onBlockAdded(World world, int i, int j, int k)
    {
    	double a = 0;
    	if(ModLoader.getMinecraftInstance().objectMouseOver != null)
    	{
    		a = ModLoader.getMinecraftInstance().objectMouseOver.hitVec.yCoord - j;
    	}
    	if(a > 0.5F && world.getBlockId(i, j, k) == Block.stairSingle.blockID)
    	{
    		world.setBlockMetadataWithNotify(i, j, k, world.getBlockMetadata(i, j, k) + 6);
    	}
    }
    
    public void getCollidingBoundingBoxes(World world, int i, int j, int k, AxisAlignedBB axisalignedbb, ArrayList arraylist)
    {
        setBlockBoundsBasedOnState(world, i, j, k);
        super.getCollidingBoundingBoxes(world, i, j, k, axisalignedbb, arraylist);
    }
    
    public int getBlockTextureFromSideAndMetadata(int i, int j)
    {
    	j %= 6;
        if(j == 0)
        {
            return i > 1 ? 5 : 6;
        }
        if(j == 1)
        {
            if(i == 0)
            {
                return 208;
            }
            return i != 1 ? 192 : 176;
        }
        if(j == 2)
        {
            return 4;
        }
        if(j == 3)
        {
        	return 16;
        }
        if(j == 4)
        {
        	return Block.brick.blockIndexInTexture;
        }
        if(j == 5)
        {
        	return BEBlocks.stoneBrick.blockIndexInTexture;
        }
        return 6;
    }

    public int getBlockTextureFromSide(int i)
    {
        return getBlockTextureFromSideAndMetadata(i, 0);
    }

    public boolean isOpaqueCube()
    {
        return blockType;
    }

    public int idDropped(int i, Random random)
    {
        return Block.stairSingle.blockID;
    }

    public int quantityDropped(Random random)
    {
        return !blockType ? 1 : 2;
    }

    protected int damageDropped(int i)
    {
        return i % 6;
    }

    public boolean renderAsNormalBlock()
    {
        return blockType;
    }

    public boolean shouldSideBeRendered(IBlockAccess iblockaccess, int i, int j, int k, int l)
    {
        if(this != Block.stairSingle)
        {
            super.shouldSideBeRendered(iblockaccess, i, j, k, l);
        }
        if(l == 1)
        {
            return true;
        }
        if(iblockaccess.getBlockId(i, j, k) == blockID && l != 0)
        {
        	int l1 = iblockaccess.getBlockMetadata(i, j, k);
        	int l3 = iblockaccess.getBlockMetadata(i+sideX[l], j, k+sideZ[l]);
        	if((l1 > 5 && l3 < 6) || (l1 < 6 && l3 > 5))
        	{
        		return true;
        	}
        }
        if(!super.shouldSideBeRendered(iblockaccess, i, j, k, l))
        {
            return false;
        }
        if(l == 0)
        {
            return true;
        } else
        {
            return iblockaccess.getBlockId(i, j, k) != blockID;
        }
    }

    public int getRenderPass(World world, int i, int j)
    {
    	if((i == 44 || i == 43) && j%6 == 5)
    	{
    		return 2;
    	}
    	return 0;
    }
    public static final String field_22037_a[] = {
        "stone", "sand", "wood", "cobble", "brick", "stoneBrick"
    };
    private boolean blockType;
    private static int sideX[] = new int[]{
    		0, 0, 0, 0, 1, -1
    };
    private static int sideZ[] = new int[]{
    		0, 0, 1, -1, 0, 0
    };
}
