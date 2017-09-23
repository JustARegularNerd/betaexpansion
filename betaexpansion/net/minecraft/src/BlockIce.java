// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            BlockBreakable, Material, World, Block, 
//            EnumSkyBlock, IBlockAccess, EntityPlayer

public class BlockIce extends BlockBreakable
{

    public BlockIce(int i, int j)
    {
        super(i, j, Material.ice, false);
        slipperiness = 0.98F;
        setTickOnLoad(true);
    }

    public int getRenderBlockPass()
    {
        return 1;
    }

    public boolean shouldSideBeRendered(IBlockAccess iblockaccess, int i, int j, int k, int l)
    {
        return super.shouldSideBeRendered(iblockaccess, i, j, k, 1 - l);
    }

    public void harvestBlock(World world, EntityPlayer entityplayer, int i, int j, int k, int l)
    {
        super.harvestBlock(world, entityplayer, i, j, k, l);
        Material material = world.getBlockMaterial(i, j - 1, k);
        if(material.getIsSolid() || material.getIsLiquid())
        {
            world.setBlockWithNotify(i, j, k, Block.waterMoving.blockID);
        }
    }

    public int quantityDropped(Random random)
    {
        return 0;
    }

    public void updateTick(World world, int i, int j, int k, Random random)
    {
    	int meltChance = 256;
    	if((world.getBlockMaterial(i + 1, j, k) == Material.water || world.getBlockMaterial(i - 1, j, k) == Material.water || 
            world.getBlockMaterial(i, j, k + 1) == Material.water || world.getBlockMaterial(i, j, k - 1) == Material.water))
    	{
    		meltChance = 8;
    	}
    	BiomeGenBase biomegenbase = world.getWorldChunkManager().getBiomeGenAt(i, k);
        if(random.nextInt(meltChance) == 0 && world.getSavedLightValue(EnumSkyBlock.Sky, i, j, k) > 11 - Block.lightOpacity[blockID] && 
        		!((biomegenbase.getEnableSnow() || (biomegenbase.canSpawnLightningBolt() && world.worldInfo.getSeason() == 3))))
        {
            dropBlockAsItem(world, i, j, k, world.getBlockMetadata(i, j, k));
            world.setBlockWithNotify(i, j, k, Block.waterStill.blockID);
        }
    }

    public int getMobilityFlag()
    {
        return 0;
    }
}
