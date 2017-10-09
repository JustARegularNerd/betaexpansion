// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import java.util.ArrayList;
import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            Block, World, EntityLiving, MathHelper, 
//            IBlockAccess, AxisAlignedBB, EntityPlayer, Entity, 
//            Vec3D

public class BlockStairs extends Block
{

    protected BlockStairs(int i, Block block)
    {
        super(i, block.blockIndexInTexture, block.blockMaterial);
        modelBlock = block;
        setHardness(block.blockHardness);
        setResistance(block.blockResistance / 3F);
        setStepSound(block.stepSound);
        setLightOpacity(255);
    }

    public void setBlockBoundsBasedOnState(IBlockAccess iblockaccess, int i, int j, int k)
    {
        setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
    }
    
    /*public void setBlockBoundsBasedOnState(IBlockAccess iblockaccess, int i, int j, int k)
    {
        int l = iblockaccess.getBlockMetadata(i, j, k);
    	if(f)
    	{
    		if(l > 3)
    		{
        		setBlockBounds(0.0F, 0.5F, 0.0F, 1.0F, 1.0F, 1.0F);
    		}else
    		{
    			setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
    		}
    	}else
    	if(f1)
    	{
    		setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
    	}else
    	{
            if(l == 0)
            {
                setBlockBounds(0.5F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
            } else
            if(l == 1)
            {
                setBlockBounds(0.0F, 0.0F, 0.0F, 0.5F, 1.0F, 1.0F);
            } else
            if(l == 2)
            {
                setBlockBounds(0.0F, 0.0F, 0.5F, 1.0F, 1.0F, 1.0F);
            } else
            if(l == 3)
            {
                setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.5F);
            }else
            if(l == 4)
            {
                setBlockBounds(0.5F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
            } else
            if(l == 5)
            {
                setBlockBounds(0.0F, 0.0F, 0.0F, 0.5F, 1.0F, 1.0F);
            } else
            if(l == 6)
            {
                setBlockBounds(0.0F, 0.0F, 0.5F, 1.0F, 1.0F, 1.0F);
            } else
            if(l == 7)
            {
                setBlockBounds(0.0F, 0.5F, 0.5F, 1.0F, 1.0F, 1.0F);
            }
    	}
    }*/

    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int i, int j, int k)
    {
        return super.getCollisionBoundingBoxFromPool(world, i, j, k);
    }

    public boolean isOpaqueCube()
    {
        return false;
    }

    public boolean renderAsNormalBlock()
    {
        return false;
    }

    public int getRenderType()
    {
        return 10;
    }

    public boolean shouldSideBeRendered(IBlockAccess iblockaccess, int i, int j, int k, int l)
    {
        return super.shouldSideBeRendered(iblockaccess, i, j, k, l);
    }

    public void getCollidingBoundingBoxes(World world, int i, int j, int k, AxisAlignedBB axisalignedbb, ArrayList arraylist)
    {
        int l = world.getBlockMetadata(i, j, k);
        if(l == 0)
        {
            setBlockBounds(0.0F, 0.0F, 0.0F, 0.5F, 0.5F, 1.0F);
            super.getCollidingBoundingBoxes(world, i, j, k, axisalignedbb, arraylist);
            setBlockBounds(0.5F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
            super.getCollidingBoundingBoxes(world, i, j, k, axisalignedbb, arraylist);
        } else
        if(l == 1)
        {
            setBlockBounds(0.0F, 0.0F, 0.0F, 0.5F, 1.0F, 1.0F);
            super.getCollidingBoundingBoxes(world, i, j, k, axisalignedbb, arraylist);
            setBlockBounds(0.5F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
            super.getCollidingBoundingBoxes(world, i, j, k, axisalignedbb, arraylist);
        } else
        if(l == 2)
        {
            setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 0.5F);
            super.getCollidingBoundingBoxes(world, i, j, k, axisalignedbb, arraylist);
            setBlockBounds(0.0F, 0.0F, 0.5F, 1.0F, 1.0F, 1.0F);
            super.getCollidingBoundingBoxes(world, i, j, k, axisalignedbb, arraylist);
        } else
        if(l == 3)
        {
            setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.5F);
            super.getCollidingBoundingBoxes(world, i, j, k, axisalignedbb, arraylist);
            setBlockBounds(0.0F, 0.0F, 0.5F, 1.0F, 0.5F, 1.0F);
            super.getCollidingBoundingBoxes(world, i, j, k, axisalignedbb, arraylist);
        }else
        if(l == 4)
        {
            setBlockBounds(0.0F, 0.5F, 0.0F, 0.5F, 1.0F, 1.0F);
            super.getCollidingBoundingBoxes(world, i, j, k, axisalignedbb, arraylist);
            setBlockBounds(0.5F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
            super.getCollidingBoundingBoxes(world, i, j, k, axisalignedbb, arraylist);
        } else
        if(l == 5)
        {
            setBlockBounds(0.0F, 0.0F, 0.0F, 0.5F, 1.0F, 1.0F);
            super.getCollidingBoundingBoxes(world, i, j, k, axisalignedbb, arraylist);
            setBlockBounds(0.5F, 0.5F, 0.0F, 1.0F, 1.0F, 1.0F);
            super.getCollidingBoundingBoxes(world, i, j, k, axisalignedbb, arraylist);
        } else
        if(l == 6)
        {
            setBlockBounds(0.0F, 0.5F, 0.0F, 1.0F, 1.0F, 0.5F);
            super.getCollidingBoundingBoxes(world, i, j, k, axisalignedbb, arraylist);
            setBlockBounds(0.0F, 0.0F, 0.5F, 1.0F, 1.0F, 1.0F);
            super.getCollidingBoundingBoxes(world, i, j, k, axisalignedbb, arraylist);
        } else
        if(l == 7)
        {
            setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.5F);
            super.getCollidingBoundingBoxes(world, i, j, k, axisalignedbb, arraylist);
            setBlockBounds(0.0F, 0.5F, 0.5F, 1.0F, 1.0F, 1.0F);
            super.getCollidingBoundingBoxes(world, i, j, k, axisalignedbb, arraylist);
        }
        setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
    }

    public void randomDisplayTick(World world, int i, int j, int k, Random random)
    {
        modelBlock.randomDisplayTick(world, i, j, k, random);
    }

    public void onBlockClicked(World world, int i, int j, int k, EntityPlayer entityplayer)
    {
        modelBlock.onBlockClicked(world, i, j, k, entityplayer);
    }

    public float getBlockBrightness(IBlockAccess iblockaccess, int i, int j, int k)
    {
        return modelBlock.getBlockBrightness(iblockaccess, i, j, k);
    }

    public float getExplosionResistance(Entity entity, int i)
    {
        return modelBlock.getExplosionResistance(entity, i);
    }

    public int getRenderBlockPass()
    {
        return modelBlock.getRenderBlockPass();
    }

    public int quantityDropped(Random random)
    {
        return modelBlock.quantityDropped(random);
    }

    public int getBlockTextureFromSideAndMetadata(int i, int j)
    {
    	if(modelBlock.blockID == BEBlocks.stoneBrick.blockID) i = 6;
        return modelBlock.getBlockTextureFromSideAndMetadata(i, j);
    }

    public int getBlockTextureFromSide(int i)
    {
    	if(modelBlock.blockID == BEBlocks.stoneBrick.blockID) i = 6;
        return modelBlock.getBlockTextureFromSide(i);
    }

    public int getBlockTexture(IBlockAccess iblockaccess, int i, int j, int k, int l)
    {
    	if(modelBlock.blockID == BEBlocks.stoneBrick.blockID) l = 6;
        return modelBlock.getBlockTexture(iblockaccess, i, j, k, l);
    }

    public int tickRate()
    {
        return modelBlock.tickRate();
    }

    public AxisAlignedBB getSelectedBoundingBoxFromPool(World world, int i, int j, int k)
    {
        return modelBlock.getSelectedBoundingBoxFromPool(world, i, j, k);
    }

    public void velocityToAddToEntity(World world, int i, int j, int k, Entity entity, Vec3D vec3d)
    {
        modelBlock.velocityToAddToEntity(world, i, j, k, entity, vec3d);
    }

    public boolean isCollidable()
    {
        return modelBlock.isCollidable();
    }

    public boolean canCollideCheck(int i, boolean flag)
    {
        return modelBlock.canCollideCheck(i, flag);
    }

    public boolean canPlaceBlockAt(World world, int i, int j, int k)
    {
        return modelBlock.canPlaceBlockAt(world, i, j, k);
    }

    public void onBlockAdded(World world, int i, int j, int k)
    {
        onNeighborBlockChange(world, i, j, k, 0);
        modelBlock.onBlockAdded(world, i, j, k);
    }

    public void onEntityWalking(World world, int i, int j, int k, Entity entity)
    {
        modelBlock.onEntityWalking(world, i, j, k, entity);
    }

    public void updateTick(World world, int i, int j, int k, Random random)
    {
        modelBlock.updateTick(world, i, j, k, random);
    }

    public boolean blockActivated(World world, int i, int j, int k, EntityPlayer entityplayer)
    {
        return modelBlock.blockActivated(world, i, j, k, entityplayer);
    }

    public void onBlockDestroyedByExplosion(World world, int i, int j, int k)
    {
        modelBlock.onBlockDestroyedByExplosion(world, i, j, k);
    }

    public void onBlockPlacedBy(World world, int i, int j, int k, EntityLiving entityliving)
    {
    	double a = ModLoader.getMinecraftInstance().objectMouseOver.hitVec.yCoord - j;
        int l = MathHelper.floor_double((double)((entityliving.rotationYaw * 4F) / 360F) + 0.5D) & 3;
        if(l == 0)
        {
        	if(a > 0.5F)
        	{
        		world.setBlockMetadataWithNotify(i, j, k, 6);
        	}else
        	{
        		world.setBlockMetadataWithNotify(i, j, k, 2);
        	}
        }
        if(l == 1)
        {
        	if(a > 0.5F)
        	{
        		world.setBlockMetadataWithNotify(i, j, k, 5);
        	}else
        	{
        		world.setBlockMetadataWithNotify(i, j, k, 1);
        	}
        }
        if(l == 2)
        {
        	if(a > 0.5F)
        	{
        		world.setBlockMetadataWithNotify(i, j, k, 7);
        	}else
        	{
        		world.setBlockMetadataWithNotify(i, j, k, 3);
        	}
        }
        if(l == 3)
        {
        	if(a > 0.5F)
        	{
        		world.setBlockMetadataWithNotify(i, j, k, 4);
        	}else
        	{
        		world.setBlockMetadataWithNotify(i, j, k, 0);
        	}
        }
    }
    
    /*public MovingObjectPosition collisionRayTrace(World world, int i, int j, int k, Vec3D vec3d, Vec3D vec3d1)
    {
        f = true;
        f1 = false;
        MovingObjectPosition p = super.collisionRayTrace(world, i, j, k, vec3d, vec3d1);
        f = false;
        f1 = false;
        MovingObjectPosition p1 = super.collisionRayTrace(world, i, j, k, vec3d, vec3d1);
        f1 = true;
    	if(p == null)
    	{
    		return p1;
    	}
    	if(p1 == null)
    	{
    		return p;
    	}
    	return p;
    }
    private boolean f = false;
    private boolean f1 = true;*/
    private Block modelBlock;
}
