package net.minecraft.src;

import java.util.ArrayList;

public class BlockLauncherExtension extends BlockPistonExtension {
    public BlockLauncherExtension(int i, int j)
    {
        super(i, j);
    }
    public int getRenderType()
    {
        return 18;
    }
    public int getBlockTextureFromSideAndMetadata(int i, int j)
    {
        int k = func_31050_c(j);
        if(i == k)
        {
            if((j & 8) != 0)
            {
                return blockIndexInTexture - 1;
            } else
            {
                return blockIndexInTexture;
            }
        }
        return i != PistonBlockTextures.field_31057_a[k] ? blockIndexInTexture + 1 : blockIndexInTexture;
    }

    public void getCollidingBoundingBoxes_do(World world, int i, int j, int k, AxisAlignedBB axisalignedbb, ArrayList arraylist)
    {
        AxisAlignedBB axisalignedbb1 = getCollisionBoundingBoxFromPool(world, i, j, k);
        if(axisalignedbb1 != null && axisalignedbb.intersectsWith(axisalignedbb1))
        {
            arraylist.add(axisalignedbb1);
        }
    }
    
    public void getCollidingBoundingBoxes(World world, int i, int j, int k, AxisAlignedBB axisalignedbb, ArrayList arraylist)
    {
        int l = world.getBlockMetadata(i, j, k);
        switch(func_31050_c(l))
        {
        case 0: // '\0'
            setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.25F, 1.0F);
            getCollidingBoundingBoxes_do(world, i, j, k, axisalignedbb, arraylist);
            setBlockBounds(0.1875F, 0.25F, 0.1875F, 0.8125F, 1.0F, 0.8125F);
            getCollidingBoundingBoxes_do(world, i, j, k, axisalignedbb, arraylist);
            break;

        case 1: // '\001'
            setBlockBounds(0.0F, 0.75F, 0.0F, 1.0F, 1.0F, 1.0F);
            getCollidingBoundingBoxes_do(world, i, j, k, axisalignedbb, arraylist);
            setBlockBounds(0.1875F, 0.0F, 0.1875F, 0.8125F, 0.75F, 0.8125F);
            getCollidingBoundingBoxes_do(world, i, j, k, axisalignedbb, arraylist);
            break;

        case 2: // '\002'
            setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.25F);
            getCollidingBoundingBoxes_do(world, i, j, k, axisalignedbb, arraylist);
            setBlockBounds(0.25F, 0.1875F, 0.25F, 0.75F, 0.8125F, 1.0F);
            getCollidingBoundingBoxes_do(world, i, j, k, axisalignedbb, arraylist);
            break;

        case 3: // '\003'
            setBlockBounds(0.0F, 0.0F, 0.75F, 1.0F, 1.0F, 1.0F);
            getCollidingBoundingBoxes_do(world, i, j, k, axisalignedbb, arraylist);
            setBlockBounds(0.25F, 0.1875F, 0.0F, 0.75F, 0.8125F, 0.75F);
            getCollidingBoundingBoxes_do(world, i, j, k, axisalignedbb, arraylist);
            break;

        case 4: // '\004'
            setBlockBounds(0.0F, 0.0F, 0.0F, 0.25F, 1.0F, 1.0F);
            getCollidingBoundingBoxes_do(world, i, j, k, axisalignedbb, arraylist);
            setBlockBounds(0.1875F, 0.25F, 0.25F, 0.8125F, 0.75F, 1.0F);
            getCollidingBoundingBoxes_do(world, i, j, k, axisalignedbb, arraylist);
            break;

        case 5: // '\005'
            setBlockBounds(0.75F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
            getCollidingBoundingBoxes_do(world, i, j, k, axisalignedbb, arraylist);
            setBlockBounds(0.0F, 0.1875F, 0.25F, 0.75F, 0.8125F, 0.75F);
            getCollidingBoundingBoxes_do(world, i, j, k, axisalignedbb, arraylist);
            break;
        }
        setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
    }

    public int getRenderBlockPass()
    {
    	return 2;
    }
}
