package net.minecraft.src;

import java.util.Random;

public class BlockPumpkinLamp extends Block
{
    private final boolean isPowered;

    public BlockPumpkinLamp(int i, boolean flag)
    {
        super(i, 54, Material.pumpkin);
        isPowered = flag;

        if (flag)
        {
            setLightValue(1.0F);
        }
    }
    
    public int getBlockTextureFromSideAndMetadata(int i, int j)
    {
        if(i == 1)
        {
            return blockIndexInTexture;
        }
        if(i == 0)
        {
            return blockIndexInTexture;
        }
        int k = blockIndexInTexture + 1 + 16;
        if(isPowered)
        {
            k++;
        }
        if(j == 2 && i == 2)
        {
            return k;
        }
        if(j == 3 && i == 5)
        {
            return k;
        }
        if(j == 0 && i == 3)
        {
            return k;
        }
        if(j == 1 && i == 4)
        {
            return k;
        } else
        {
            return blockIndexInTexture + 16;
        }
    }
    
    public void onBlockAdded(World world, int i, int j, int k)
    {
        if (!world.multiplayerWorld)
        {
            if (isPowered && !world.isBlockIndirectlyGettingPowered(i, j, k))
            {
                world.scheduleBlockUpdate(i, j, k, blockID, 4);
            }
            else if (!isPowered && world.isBlockIndirectlyGettingPowered(i, j, k))
            {
                world.setBlockAndMetadataWithNotify(i, j, k, BEBlocks.pumpkinLampActive.blockID, world.getBlockMetadata(i, j, k));
            }
        }
    }

    public void onNeighborBlockChange(World world, int i, int j, int k, int l)
    {
        if (!world.multiplayerWorld)
        {
            if (isPowered && !world.isBlockIndirectlyGettingPowered(i, j, k))
            {
                world.scheduleBlockUpdate(i, j, k, blockID, 4);
            }
            else if (!isPowered && world.isBlockIndirectlyGettingPowered(i, j, k))
            {
                world.setBlockAndMetadataWithNotify(i, j, k, BEBlocks.pumpkinLampActive.blockID, world.getBlockMetadata(i, j, k));
            }
        }
    }

    public void updateTick(World world, int i, int j, int k, Random random)
    {
        if (!world.multiplayerWorld && isPowered && !world.isBlockIndirectlyGettingPowered(i, j, k))
        {
            world.setBlockAndMetadataWithNotify(i, j, k, BEBlocks.pumpkinLampIdle.blockID, world.getBlockMetadata(i, j, k));
        }
    }

    public void onBlockPlacedBy(World world, int i, int j, int k, EntityLiving entityliving)
    {
        int l = MathHelper.floor_double((double)((entityliving.rotationYaw * 4F) / 360F) + 2.5D) & 3;
        world.setBlockMetadataWithNotify(i, j, k, l);
    }
    
    public int idDropped(int i, Random random)
    {
        return BEBlocks.pumpkinLampIdle.blockID;
    }
    
    public int getRenderBlockPass()
    {
    	return 2;
    }
}
