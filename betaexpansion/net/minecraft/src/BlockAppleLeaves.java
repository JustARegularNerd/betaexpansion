package net.minecraft.src;

import java.util.Random;

public class BlockAppleLeaves extends BlockLeaves 
{

	protected BlockAppleLeaves(int i, int j) {
		super(i, j);
		this.blockIndexInTexture = j;
		this.setStepSound(Block.soundGrassFootstep);
	}
	
    public int getRenderColor(int i)
    {
        return ColorizerFoliage.func_31073_c();
    }
    
	public boolean blockActivated(World world, int i, int j, int k,
			EntityPlayer entityplayer) {
		world.setBlockWithNotify(i, j, k, Block.leaves.blockID);
		if(!world.multiplayerWorld)
		{
			int amt = 1;
			if(world.worldInfo.getSeason() == 2 && world.rand.nextInt(2) == 0)
			{
				amt += 1 + world.rand.nextInt(1);
			}
			for(int i1 = 0; i1 < amt; i1++)
			{
				world.entityJoinedWorld(new EntityItem(world, i, j, k, new ItemStack(
						Item.appleRed, 1)));
			}
		}
		return true;
	}

    public void setGraphicsLevel(boolean flag)
    {
        graphicsLevel = flag;
        blockIndexInTexture = baseIndexInPNG + (flag ? 0 : 1);
    }
    
    public int idDropped(int i, Random random)
    {
        return BEBlocks.appleSapling.blockID;
    }

    public int quantityDropped(Random random)
    {
        return random.nextInt(10) != 0 ? 0 : 1;
    }
    
	public int colorMultiplier(IBlockAccess iblockaccess, int i, int j, int k) {
		iblockaccess.getWorldChunkManager().func_4069_a(i, k, 1, 1);
		double d = iblockaccess.getWorldChunkManager().temperature[0];
		double d1 = iblockaccess.getWorldChunkManager().humidity[0];
		return ColorizerFoliage.getFoliageColor(d, d1);
	}
	
    public void harvestBlock(World world, EntityPlayer entityplayer, int i, int j, int k, int l)
    {
        if(!world.multiplayerWorld && entityplayer.getCurrentEquippedItem() != null && entityplayer.getCurrentEquippedItem().itemID == Item.shears.shiftedIndex)
        {
            entityplayer.addStat(StatList.mineBlockStatArray[blockID], 1);
            dropBlockAsItem_do(world, i, j, k, new ItemStack(BEBlocks.appleLeaves.blockID, 1, 0));
        } else
        {
            super.harvestBlock(world, entityplayer, i, j, k, l);
        }
    }
    
    public int getRenderPass(World world, int i, int j)
    {
    	if(world.worldInfo.getSeason() != 3)
    	{
            blockIndexInTexture = baseIndexInPNG + 16;
    	}else
    	{
            blockIndexInTexture = baseIndexInPNG;	
    	}
    	return 2;
    }
}