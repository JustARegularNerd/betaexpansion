package net.minecraft.src;

public class BlockRopeLadder extends BlockLadder{
	public BlockRopeLadder(int i, int j)
	{
		super(i, j);
	}
	
	public int getRenderBlockPass()
	{
		return 2;
	}
	
    public boolean blockActivated(World world, int i, int j, int k, EntityPlayer entityplayer)
    {
    	int x = world.getBlockMetadata(i, j, k);
    	ItemStack itemstack = entityplayer.getCurrentEquippedItem();
    	int y = j;
    	if(itemstack != null && itemstack.itemID == blockID)
    	{
    		while(true)
    		{
				j--;
				int i1 = world.getBlockId(i, j, k);
				if(entityplayer.isSneaking())
				{
			    	if(world.multiplayerWorld)
			    	{
			    		return true;
			    	}
	    			if(i1 == blockID && (world.getBlockMetadata(i, j, k) & 7) != (x & 7))
	    			{
	    				world.setBlockWithNotify(i, j+1, k, 0);
	    				dropBlockAsItem(world, i, y, k, world.getBlockMetadata(i, j, k));
	    				return true;
	    			}else
	    			if(i1 == blockID)
	    			{
	    				continue;
	    			}else
	    			if(i1 != blockID)
	    			{
	    				world.setBlockWithNotify(i, j+1, k, 0);
	    	            dropBlockAsItem(world, i, y, k, world.getBlockMetadata(i, j, k));
	    				return true;
	    			}else
	    			{
	    				return true;
	    			}
				}else
				{
					if(i1 == 0)
					{
						world.setBlockAndMetadataWithNotify(i, j, k, blockID, x & 7);
						itemstack.stackSize--;
						return true;
					}else
					if(i1 == blockID && (world.getBlockMetadata(i, j, k) & 7) != (x & 7))
					{
						return true;
					}else
					if(i1 == blockID)
					{
						continue;
					}else
					{
						return true;
					}
				}
    		}
    	}else
    	{
    		return true;
    	}
    }
    
    public void onNeighborBlockChange(World world, int i, int j, int k, int l)
    {
    	if(world.multiplayerWorld)
    	{
    		return;
    	}
        int i1 = world.getBlockMetadata(i, j, k);
        boolean flag = false;
        if(i1 < 8)
        {
            flag = world.getBlockId(i, j+1, k) == blockID;
        }else
        {
            if(i1 == 10 && world.isBlockNormalCube(i, j, k + 1))
            {
                flag = true;
            }
            if(i1 == 11 && world.isBlockNormalCube(i, j, k - 1))
            {
                flag = true;
            }
            if(i1 == 12 && world.isBlockNormalCube(i + 1, j, k))
            {
                flag = true;
            }
            if(i1 == 13 && world.isBlockNormalCube(i - 1, j, k))
            {
                flag = true;
            }
        }
        if(!flag)
        {
            dropBlockAsItem(world, i, j, k, i1);
            world.setBlockWithNotify(i, j, k, 0);
        }
    }

    public void onBlockPlaced(World world, int i, int j, int k, int l)
    {
        int i1 = world.getBlockMetadata(i, j, k);
        int l1 = world.getBlockId(i, j+1, k);
        int i2 = world.getBlockMetadata(i, j+1, k);
        if((i1 == 0 || l == 2) && world.isBlockNormalCube(i, j, k + 1))
        {
            i1 = 2;
        }
        if((i1 == 0 || l == 3) && world.isBlockNormalCube(i, j, k - 1))
        {
            i1 = 3;
        }
        if((i1 == 0 || l == 4) && world.isBlockNormalCube(i + 1, j, k))
        {
            i1 = 4;
        }
        if((i1 == 0 || l == 5) && world.isBlockNormalCube(i - 1, j, k))
        {
            i1 = 5;
        }
        
        if(l1 == blockID && (i1 & 7) == (i2 & 7))
        {
        	world.setBlockMetadata(i, j, k, i1);
        }else
        {
        	world.setBlockMetadata(i, j, k, i1 + 8);
        }
        while(true)
        {
        	j--;
        	int i3 = world.getBlockMetadata(i,j,k);
        	int j2 = world.getBlockId(i,j,k);
        	if(j2 == blockID && (i3 & 7) != (i1 & 7))
        	{
        		break;
        	}
        	if(j2 == blockID && (i3 & 7) == i1 && i3 >= 8)
        	{
        		world.setBlockMetadata(i, j, k, i1 & 7);
        	}else
        	if(j2 != blockID)
        	{
        		break;
        	}
        }
    }
    
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int i, int j, int k)
    {
        int l = world.getBlockMetadata(i, j, k) & 7;
        float f = 0.125F;
        if(l == 2)
        {
            setBlockBounds(0.0F, 0.0F, 1.0F - f, 1.0F, 1.0F, 1.0F);
        }
        if(l == 3)
        {
            setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, f);
        }
        if(l == 4)
        {
            setBlockBounds(1.0F - f, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
        }
        if(l == 5)
        {
            setBlockBounds(0.0F, 0.0F, 0.0F, f, 1.0F, 1.0F);
        }
        return super.getCollisionBoundingBoxFromPool(world, i, j, k);
    }

    public AxisAlignedBB getSelectedBoundingBoxFromPool(World world, int i, int j, int k)
    {
        int l = world.getBlockMetadata(i, j, k) & 7;
        float f = 0.125F;
        if(l == 2)
        {
            setBlockBounds(0.0F, 0.0F, 1.0F - f, 1.0F, 1.0F, 1.0F);
        }
        if(l == 3)
        {
            setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, f);
        }
        if(l == 4)
        {
            setBlockBounds(1.0F - f, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
        }
        if(l == 5)
        {
            setBlockBounds(0.0F, 0.0F, 0.0F, f, 1.0F, 1.0F);
        }
        return super.getSelectedBoundingBoxFromPool(world, i, j, k);
    }
}
