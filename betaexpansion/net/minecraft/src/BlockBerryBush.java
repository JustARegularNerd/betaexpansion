package net.minecraft.src;

import java.util.Random;

public class BlockBerryBush extends BlockFlower {
    protected BlockBerryBush(int i, int j)
    {
        super(i, j);
        float f = 0.4F;
        setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, 0.8F, 0.5F + f);
    }
    
    public int getBlockTextureFromSideAndMetadata(int i, int j)
    {
        return blockIndexInTexture + (j < 3 ? j * 16 : 0);
    }
    
    public int getRenderBlockPass()
    {
    	return 2;
    }
    
    public boolean blockActivated(World world, int i, int j, int k, EntityPlayer entityplayer)
    {
    	int l = world.getBlockMetadata(i, j, k);
    	if(l > 0 && l < 3)
    	{
            float f = 0.7F;
            double d;
            double d1;
            double d2;
            for(int i1 = 0; i1 < 1 + world.rand.nextInt(3); i1++)
            {
            	d = (double)(world.rand.nextFloat() * f) + (double)(1.0F - f) * 0.5D;
            	d1 = (double)(world.rand.nextFloat() * f) + (double)(1.0F - f) * 0.5D;
            	d2 = (double)(world.rand.nextFloat() * f) + (double)(1.0F - f) * 0.5D;
            	EntityItem entityitem = new EntityItem(world, (double)i + d, (double)j + d1, (double)k + d2, new ItemStack(BEItems.berry.shiftedIndex, 1, l-1));
            	entityitem.delayBeforeCanPickup = 10;
            	world.entityJoinedWorld(entityitem);
                world.setBlockAndMetadataWithNotify(i, j, k, BEBlocks.berryBush.blockID, 0);
            }
            return true;
    	}
    	return false;
    }
    
    public int idDropped(int i, Random random)
    {
        return -1;
    }
}
