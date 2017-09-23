// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            BlockStone, Block

public class BlockCryingObsidian extends BlockStone
{

    public BlockCryingObsidian(int i, int j, boolean flag)
    {
        super(i, j);
    	isActivated = flag;
    }
    
    public void onNeighborBlockChange(World world, int i, int j, int k, int l)
    {
        if(isActivated)
        {
        	if(!(world.getBlockId(i, j+1, k) == blockID || world.getBlockId(i, j-1, k) == blockID))
        	{
        		world.setBlockWithNotify(i, j, k, BEBlocks.cryingObsidianIdle.blockID);
        	}else
        	if(world.getBlockId(i, j-1, k) == blockID && !(world.isBlockOpaqueCube(i, j-2, k) || world.isBlockNormalCube(i, j-2, k)))
        	{
        		world.setBlockWithNotify(i, j, k, BEBlocks.cryingObsidianIdle.blockID);
        	}else
        	if(!(world.isBlockOpaqueCube(i, j-1, k) || world.isBlockNormalCube(i, j-1, k)))
        	{
        		world.setBlockWithNotify(i, j, k, BEBlocks.cryingObsidianIdle.blockID);
        	}
        }else
        {
        	super.onNeighborBlockChange(world, i, j, k, l);
        }
    }
    
    public void onBlockPlaced(World world, int i, int j, int k, int l)
    {
        if(isActivated && !(world.getBlockId(i, j+1, k) == blockID || world.getBlockId(i, j-1, k) == blockID))
    	{
            world.setBlockWithNotify(i, j, k, BEBlocks.cryingObsidianIdle.blockID);
    	}
    }
    
    public boolean blockActivated(World world, int i, int j, int k, EntityPlayer entityplayer)
    {
    	if(isActivated || world.difficultySetting != 3)
    	{
    		return false;
    	}
    	if(world.getBlockId(i, j-1, k) == blockID && !(world.isBlockOpaqueCube(i, j-2, k) || world.isBlockNormalCube(i, j-2, k)))
    	{
    		return false;
    	}else
    	if(!(world.isBlockOpaqueCube(i, j-1, k) || world.isBlockNormalCube(i, j-1, k)))
    	{
    		return false;
    	}
    	int l = ModLoader.getMinecraftInstance().objectMouseOver.sideHit;
    	if(l == 0)
    	{
    		return false;
    	}
    	boolean f = world.getBlockId(i, j-1, k) == blockID;
    	boolean f1 = world.getBlockId(i, j+1, k) == blockID;
    	ChunkCoordinates c = entityplayer.getPlayerSpawnCoordinate();
    	if(f || f1)
    	{
			if(c != null && world.getBlockId(c.x, c.y, c.z) == 114)
			{
				world.setBlockWithNotify(c.x, c.y, c.z, 113);
				world.setBlockWithNotify(c.x, c.y+1, c.z, 113);
			}
			world.setBlockWithNotify(i, j, k, 114);
			if(f1)
			{
				world.setBlockAndMetadataWithNotify(i, j+1, k, 114, l);
				entityplayer.setPlayerSpawnCoordinate(new ChunkCoordinates(i, j, k));
			}else
			if(f)
			{
				entityplayer.setPlayerSpawnCoordinate(new ChunkCoordinates(i, j-1, k));
				world.setBlockAndMetadataWithNotify(i, j-1, k, 114, l);
			}
			entityplayer.addChatMessage('\247'+"7Spawn set.");
    		return true;
    	}
    	return false;
    }
    
    public static ChunkCoordinates getNearestEmptyChunkCoordinates(World world, int i, int j, int k, int l)
    {
        int i1 = world.getBlockMetadata(i, j, k);
        for(int k1 = 0; k1 <= 1; k1++)
        {
            int l1 = i+sideX[i1];
            int i2 = k+sideZ[i1];
            int j2 = l1 + 2;
            int k2 = i2 + 2;
            for(int l2 = l1; l2 <= j2; l2++)
            {
                for(int i3 = i2; i3 <= k2; i3++)
                {
                    if(!world.isBlockNormalCube(l2, j - 1, i3) || !world.isAirBlock(l2, j, i3) || !world.isAirBlock(l2, j + 1, i3))
                    {
                        continue;
                    }
                    if(l > 0)
                    {
                        l--;
                    } else
                    {
                        return new ChunkCoordinates(l2, j, i3);
                    }
                }

            }

        }

        return null;
    }
    
    public int quantityDropped(Random random)
    {
        return 1;
    }

    public int idDropped(int i, Random random)
    {
        return BEBlocks.cryingObsidianIdle.blockID;
    }
    
    public int getRenderBlockPass()
    {
    	return 2;
    }
    
    public void randomDisplayTick(World world, int i, int j, int k, Random random)
    {
    	if(!isActivated)
    	{
    		return;
    	}
        double d = 0.0625D;
        for(int l = 0; l < 6; l++)
        {
            double d1 = (float)i + random.nextFloat();
            double d2 = (float)j + random.nextFloat();
            double d3 = (float)k + random.nextFloat();
            if(l == 0 && !world.isBlockOpaqueCube(i, j + 1, k))
            {
                d2 = (double)(j + 1) + d;
            }
            if(l == 1 && !world.isBlockOpaqueCube(i, j - 1, k))
            {
                d2 = (double)(j + 0) - d;
            }
            if(l == 2 && !world.isBlockOpaqueCube(i, j, k + 1))
            {
                d3 = (double)(k + 1) + d;
            }
            if(l == 3 && !world.isBlockOpaqueCube(i, j, k - 1))
            {
                d3 = (double)(k + 0) - d;
            }
            if(l == 4 && !world.isBlockOpaqueCube(i + 1, j, k))
            {
                d1 = (double)(i + 1) + d;
            }
            if(l == 5 && !world.isBlockOpaqueCube(i - 1, j, k))
            {
                d1 = (double)(i + 0) - d;
            }
            if(d1 < (double)i || d1 > (double)(i + 1) || d2 < 0.0D || d2 > (double)(j + 1) || d3 < (double)k || d3 > (double)(k + 1))
            {
            	if(random.nextInt(4) == 0)
            	{
                    if (random.nextInt(3) != 0){
                    	world.spawnParticle("reddust", d1, d2, d3, 32f / 255f, 26f / 255f, 51f / 255f);
                    } else{
                    	world.spawnParticle("reddust", d1, d2, d3, 12f / 26f, 53f / 255f, 136f / 255f);
                    }    
            	}   
            }
        }
    }
    private static int sideY[] = new int[]{
    		-1, 1, 0, 0, 0, 0
    };
    private static int sideX[] = new int[]{
    		0, 0, 0, 0, -1, 1
    };
    private static int sideZ[] = new int[]{
    		0, 0, -1, 1, 0, 0
    };    
    public boolean isActivated;
}
