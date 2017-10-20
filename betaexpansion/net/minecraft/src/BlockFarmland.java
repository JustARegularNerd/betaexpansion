// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            Block, Material, AxisAlignedBB, World, 
//            Entity

public class BlockFarmland extends Block
{

    protected BlockFarmland(int i, int j)
    {
        super(i, Material.ground);
        blockIndexInTexture = (j == 0) ? 87 : (10 + j);
        setTickOnLoad(true);
        setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.9375F, 1.0F);
        setLightOpacity(255);
        type = j;
    }

    public int getRenderPass(World world, int i, int j)
    {
    	if(type > 0 && type < 4)
    	{
    		return 2;
    	}else
    	{
    		return 0;
    	}
    }
    
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int i, int j, int k)
    {
        return AxisAlignedBB.getBoundingBoxFromPool(i + 0, j + 0, k + 0, i + 1, j + 1, k + 1);
    }

    public boolean isOpaqueCube()
    {
        return false;
    }

    public boolean renderAsNormalBlock()
    {
        return false;
    }

    public int getBlockTextureFromSideAndMetadata(int i, int j)
    {
    	if(type == 0)
    	{
    		if(i == 1 && j > 0)
    		{
    			return blockIndexInTexture - 1;
    		}
    		if(i == 1)
    		{
    			return blockIndexInTexture;
    		} else
    		{
    			return 2;
    		}
    	}
        if(i == 1 && j > 0)
        {
            return blockIndexInTexture + 16;
        }
        if(i == 1)
        {
            return blockIndexInTexture;
        } else
        {
        	return 7 + type;
        }
    }

    public void updateTick(World world, int i, int j, int k, Random random)
    {
        if(random.nextInt(5) == 0)
        {
            if(isWaterNearby(world, i, j, k) || world.canBlockBeRainedOn(i, j + 1, k))
            {
                world.setBlockMetadataWithNotify(i, j, k, 7);
            } else
            {
                int l = world.getBlockMetadata(i, j, k);
                if(l > 0)
                {
                    world.setBlockMetadataWithNotify(i, j, k, l - 1);
                } else
                if(!isCropsNearby(world, i, j, k))
                {
                    world.setBlockAndMetadataWithNotify(i, j, k, Block.dirt.blockID, type);
                }
            }
        }
    }

    public void onEntityWalking(World world, int i, int j, int k, Entity entity)
    {
        if(world.rand.nextInt(4) == 0)
        {
            world.setBlockAndMetadataWithNotify(i, j, k, Block.dirt.blockID, type);
        }
    }

    private boolean isCropsNearby(World world, int i, int j, int k)
    {
        int l = 0;
        for(int i1 = i - l; i1 <= i + l; i1++)
        {
            for(int j1 = k - l; j1 <= k + l; j1++)
            {
                if(world.getBlockId(i1, j + 1, j1) == Block.crops.blockID)
                {
                    return true;
                }
            }

        }

        return false;
    }

    private boolean isWaterNearby(World world, int i, int j, int k)
    {
        for(int l = i - 4; l <= i + 4; l++)
        {
            for(int i1 = j; i1 <= j + 1; i1++)
            {
                for(int j1 = k - 4; j1 <= k + 4; j1++)
                {
                    if(world.getBlockMaterial(l, i1, j1) == Material.water)
                    {
                        return true;
                    }
                }

            }

        }

        return false;
    }

    public void onNeighborBlockChange(World world, int i, int j, int k, int l)
    {
        super.onNeighborBlockChange(world, i, j, k, l);
        Material material = world.getBlockMaterial(i, j + 1, k);
        if(material.isSolid())
        {
            world.setBlockAndMetadataWithNotify(i, j, k, Block.dirt.blockID, type);
        }
    }

    public int idDropped(int i, Random random)
    {
        return Block.dirt.idDropped(0, random);
    }
    
    protected int damageDropped(int i)
    {
        return type < 4 ? type : 0;
    }
    
    private int type;
}
