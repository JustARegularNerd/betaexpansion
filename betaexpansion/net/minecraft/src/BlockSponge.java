// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            Block, Material, World

public class BlockSponge extends Block
{

    protected BlockSponge(int i)
    {
        super(i, Material.sponge);
        blockIndexInTexture = 48;
    }

    public void onBlockPlacedBy(World world, int i, int j, int k, EntityLiving entityliving)
    {
    	activate(world, i, j, k);
    }
    
    public void activate(World world, int i, int j, int k)
    {
        byte byte0 = 5;
        int particles = 4;
        int count = 0;
        for(int l = i - byte0; l <= i + byte0; l++)
        {
            for(int i1 = j - byte0; i1 <= j + byte0; i1++)
            {
                for(int j1 = k - byte0; j1 <= k + byte0; j1++)
                {
                    if(world.getBlockMaterial(l, i1, j1) == Material.water && (Math.abs(l-i) + Math.abs(i1 - j) + Math.abs(j1-k) < byte0))
                    {
                    	count++;
                    	for(int x = 0; x < particles; x++)
                    	{
                    		world.spawnParticle("splash", l + r.nextFloat(), i1 + 0.5f, j1 + r.nextFloat(), 0.0D, 0.0D, 0.0D);
                    		world.spawnParticle("bubble", l + r.nextFloat(), i1 + 0.5f, j1 + r.nextFloat(), 0.0D, 0.0D, 0.0D);
                    	}
                    	world.setBlockWithNotify(l, i1, j1, 0);
                    }
                }

            }

        }
        if(count > 0)
        {
        	world.setBlock(i, j, k, BEBlocks.wetSponge.blockID);
        }
    }
    
    Random r = new Random();
}
