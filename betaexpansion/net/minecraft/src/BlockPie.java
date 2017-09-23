package net.minecraft.src;

public class BlockPie extends BlockCake {

	protected BlockPie(int i, int j) {
		super(i, j);
	}

    public int getBlockTextureFromSideAndMetadata(int i, int j)
    {
    	int l = blockIndexInTexture;
    	if(j > 5)
    	{
    		l+=16;
    	}
        if(i == 1)
        {
            return l;
        }
        if(i == 0)
        {
            return l + 3;
        }
        if(j % 6 > 0 && i == 4)
        {
            return l + 2;
        } else
        {
            return l + 1;
        }
    }
    
    public void setBlockBoundsBasedOnState(IBlockAccess iblockaccess, int i, int j, int k)
    {
        int l = iblockaccess.getBlockMetadata(i, j, k) % 6;
        float f = 0.0625F;
        float f1 = (float)(1 + l * 2) / 16F;
        float f2 = 0.5F;
        setBlockBounds(f1, 0.0F, f, 1.0F - f, f2, 1.0F - f);
    }

    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int i, int j, int k)
    {
        int l = world.getBlockMetadata(i, j, k) % 6;
        float f = 0.0625F;
        float f1 = (float)(1 + l * 2) / 16F;
        float f2 = 0.5F;
        return AxisAlignedBB.getBoundingBoxFromPool((float)i + f1, j, (float)k + f, (float)(i + 1) - f, ((float)j + f2) - f, (float)(k + 1) - f);
    }

    public AxisAlignedBB getSelectedBoundingBoxFromPool(World world, int i, int j, int k)
    {
        int l = world.getBlockMetadata(i, j, k) % 6;
        float f = 0.0625F;
        float f1 = (float)(1 + l * 2) / 16F;
        float f2 = 0.5F;
        return AxisAlignedBB.getBoundingBoxFromPool((float)i + f1, j, (float)k + f, (float)(i + 1) - f, (float)j + f2, (float)(k + 1) - f);
    }
    
    public void onBlockPlacedBy(World world, int i, int j, int k, EntityLiving entityliving)
    {
    	ItemStack itemstack = ((EntityPlayer)entityliving).getCurrentEquippedItem();
    	if(itemstack != null && itemstack.itemID == BEItems.pieSlice.shiftedIndex)
    	{
    		world.setBlockMetadataWithNotify(i, j, k, itemstack.getItemDamage() > 0 ? 5 : 11);
    	}
    }
    
    public boolean blockActivated(World world, int i, int j, int k, EntityPlayer entityplayer)
    {
        int l = world.getBlockMetadata(i, j, k);
        ItemStack itemstack = entityplayer.getCurrentEquippedItem();
        boolean flag = entityplayer.isSneaking() && itemstack != null;
        boolean flag2 = true;
    	if(flag2 && flag && itemstack.itemID == BEItems.pieSlice.shiftedIndex)
    	{
    		if(l % 6 == 0)
    		{
    			flag2 = false;
    		}else
    		if(itemstack.getItemDamage() != 1-(l/6))
    		{
    			flag2 = false;
    		}else
    		{
    			world.setBlockMetadataWithNotify(i, j, k, l-1);
    			world.playSoundEffect((float)i + 0.5F, (float)j + 0.5F, (float)k + 0.5F, stepSound.func_1145_d(), (stepSound.getVolume() + 1.0F) / 2.0F, stepSound.getPitch() * 0.8F);
    			itemstack.stackSize--;
    		}
    	}else if(flag2 && flag && itemstack.getItem() instanceof ItemSword)
    	{
    		removeSlice(world,i,j,k,l);
    	}else if(flag2 && !entityplayer.isSneaking())
    	{
            eatCakeSlice(world, i, j, k, entityplayer);
    	}
    	if(entityplayer.isSneaking() && ((itemstack != null && itemstack.itemID != BEItems.pieSlice.shiftedIndex && itemstack.itemID != BEBlocks.blockPie.blockID 
    			&& !(itemstack.getItem() instanceof ItemSword)) || itemstack == null))
    	{
    		return false;
    	}
        return true;
    }
    
    private void eatCakeSlice(World world, int i, int j, int k, EntityPlayer entityplayer)
    {
        if(entityplayer.health < 20)
        {
            entityplayer.heal(10);
            int l = world.getBlockMetadata(i, j, k);
            if(l % 6 == 5)
            {
                world.setBlockWithNotify(i, j, k, 0);
            } else
            {
                world.setBlockMetadataWithNotify(i, j, k, l+1);
                world.markBlockAsNeedsUpdate(i, j, k);
            }
        }
    }
    
    private void removeSlice(World world, int i, int j, int k, int l)
    {
		if(l % 6 == 5)
		{
			world.setBlockWithNotify(i, j, k, 0);
		}else
		{
			world.setBlockMetadataWithNotify(i, j, k, l+1);
		}
        float f = 0.7F;
        double d = (double)(world.rand.nextFloat() * f) + (double)(1.0F - f) * 0.5D;
        double d1 = (double)(world.rand.nextFloat() * f) + (double)(1.0F - f) * 0.5D;
        double d2 = (double)(world.rand.nextFloat() * f) + (double)(1.0F - f) * 0.5D;
        EntityItem entityitem = new EntityItem(world, (double)i + d, (double)j + d1, (double)k + d2, new ItemStack(BEItems.pieSlice.shiftedIndex, 1, 1-(l/6)));
        entityitem.delayBeforeCanPickup = 10;
        world.entityJoinedWorld(entityitem);
    }
    
    public void onBlockClicked(World world, int i, int j, int k, EntityPlayer entityplayer)
    {
        int l = world.getBlockMetadata(i, j, k);
        ItemStack itemstack = entityplayer.getCurrentEquippedItem();
    	if(entityplayer.isSneaking() && itemstack != null && itemstack.getItem() instanceof ItemSword)
    	{
    		removeSlice(world,i,j,k,l);
    	}else
    	{
            eatCakeSlice(world, i, j, k, entityplayer);
    	}
    }
    
    public int getRenderBlockPass()
    {
    	return 2;
    }
}
