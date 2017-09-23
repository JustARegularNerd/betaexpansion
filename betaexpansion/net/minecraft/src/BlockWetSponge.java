package net.minecraft.src;

public class BlockWetSponge extends Block 
{
    protected BlockWetSponge(int i, int j)
    {
        super(i, j, Material.sponge);
    }
    
    public boolean blockActivated(World world, int i, int j, int k, EntityPlayer entityplayer)
    {
    	int waterLevels = 0;
    	int availableSides = 0;
    	int j1 = world.getBlockId(i-1, j, k);
    	int j2 = world.getBlockId(i+1, j, k);
    	int j3 = world.getBlockId(i, j, k-1);
    	int j4 = world.getBlockId(i, j, k+1);
    	boolean f1 = j1 == 0 || !world.getBlockMaterial(i-1, j, k).getIsSolid();
    	boolean f2 = j2 == 0 || !world.getBlockMaterial(i+1, j, k).getIsSolid();
    	boolean f3 = j3 == 0 || !world.getBlockMaterial(i, j, k-1).getIsSolid();
    	boolean f4 = j4 == 0 || !world.getBlockMaterial(i, j, k+1).getIsSolid();
    	availableSides = (f1?1:0)+(f2?1:0)+(f3?1:0)+(f4?1:0);
    	switch(availableSides)
    	{
    	case 0: return false;
    	case 1: waterLevels = 0; break;
    	case 2: waterLevels = 2; break;
    	case 3: waterLevels = 4; break;
    	case 4: waterLevels = 6; break;
    	}
    	if(f1)
    	{
    		if(Block.blocksList[j1] != null)
    		{
    			Block.blocksList[j1].dropBlockAsItem(world, i-1, j, k, world.getBlockMetadata(i-1, j, k));
    		}
    		world.setBlockAndMetadataWithNotify(i - 1, j, k, Block.waterMoving.blockID, waterLevels);
    	}
    	if(f2)
    	{
    		if(Block.blocksList[j2] != null)
    		{
    			Block.blocksList[j2].dropBlockAsItem(world, i+1, j, k, world.getBlockMetadata(i+1, j, k));
    		}
    		world.setBlockAndMetadataWithNotify(i + 1, j, k, Block.waterMoving.blockID, waterLevels);
    	}
    	if(f3)
    	{
    		if(Block.blocksList[j3] != null)
    		{
        		Block.blocksList[j3].dropBlockAsItem(world, i, j, k-1, world.getBlockMetadata(i, j, k-1));
    		}
    		world.setBlockAndMetadataWithNotify(i, j, k - 1, Block.waterMoving.blockID, waterLevels);
    	}
    	if(f4)
    	{
    		if(Block.blocksList[j4] != null)
    		{
    			Block.blocksList[j4].dropBlockAsItem(world, i, j, k+1, world.getBlockMetadata(i, j, k+1));
    		}
    		world.setBlockAndMetadataWithNotify(i, j, k + 1, Block.waterMoving.blockID, waterLevels);
    	}
    	world.setBlock(i, j, k, Block.sponge.blockID);
    	return true;
    }
    
    public int getRenderBlockPass()
    {
    	return 2;
    }
}
