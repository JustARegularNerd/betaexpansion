package net.minecraft.src;

import java.util.ArrayList;
import java.util.Random;

public class BlockTable extends BlockContainer
{
	public BlockTable(int i, int j)
	{
		super(i,j,Material.wood);
		rand = new Random();
	}
	
    public Block getBlockProperties(int i)
    {
    	i %= 8;
    	if(i > 0 && i < 4)
    	{
    		return Block.wood;
    	}
    	if(i == 4)
    	{
    		return Block.cobblestone;
    	}
    	if(i == 5)
    	{
    		return Block.stairDouble;
    	}
    	return Block.planks;
    }
    
    protected TileEntity getBlockEntity()
    {
        return new TileEntityTable();
    }
    
    public boolean blockActivated(World world, int i, int j, int k, EntityPlayer entityplayer)
    {
        if(world.multiplayerWorld)
        {
            return true;
        } else
        {
        	TileEntityTable table = (TileEntityTable)world.getBlockTileEntity(i, j, k);
            entityplayer.displayGUITable(table);
            return true;
        }
    }
    
    public void onBlockRemoval(World world, int i, int j, int k)
    {
        TileEntityTable tileentitytable = (TileEntityTable)world.getBlockTileEntity(i, j, k);
        for(int l = 0; l < tileentitytable.getSizeInventory(); l++)
        {
            ItemStack itemstack = tileentitytable.getStackInSlot(l);
            if(itemstack != null)
            {
                float f = rand.nextFloat() * 0.8F + 0.1F;
                float f1 = rand.nextFloat() * 0.8F + 0.1F;
                float f2 = rand.nextFloat() * 0.8F + 0.1F;
                while(itemstack.stackSize > 0) 
                {
                    int i1 = rand.nextInt(21) + 10;
                    if(i1 > itemstack.stackSize)
                    {
                        i1 = itemstack.stackSize;
                    }
                    itemstack.stackSize -= i1;
                    EntityItem entityitem = new EntityItem(world, (float)i + f, (float)j + f1, (float)k + f2, new ItemStack(itemstack.itemID, i1, itemstack.getItemDamage()));
                    float f3 = 0.05F;
                    entityitem.motionX = (float)rand.nextGaussian() * f3;
                    entityitem.motionY = (float)rand.nextGaussian() * f3 + 0.2F;
                    entityitem.motionZ = (float)rand.nextGaussian() * f3;
                    world.entityJoinedWorld(entityitem);
                }
            }
        }

        super.onBlockRemoval(world, i, j, k);
    }
    
    public void setBlockBoundsBasedOnState(IBlockAccess iblockaccess, int i, int j, int k)
    {
    	int l = iblockaccess.getBlockMetadata(i, j, k);
    	if(l > 7)
    	{
            setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.75F, 1.0F);
    	}else
    	{
            setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
    	}
    }
    
    public void getCollidingBoundingBoxes(World world, int i, int j, int k, AxisAlignedBB axisalignedbb, ArrayList arraylist)
    {
    	int l = world.getBlockMetadata(i, j, k);
    	boolean f = world.getBlockId(i+1, j, k) == blockID && (world.getBlockMetadata(i+1, j, k) / 8 == l / 8);
    	boolean f1 = world.getBlockId(i-1, j, k) == blockID && (world.getBlockMetadata(i-1, j, k) / 8 == l / 8);
    	boolean f2 = world.getBlockId(i, j, k+1) == blockID && (world.getBlockMetadata(i, j, k+1) / 8 == l / 8);
    	boolean f3 = world.getBlockId(i, j, k-1) == blockID && (world.getBlockMetadata(i, j, k-1) / 8 == l / 8);
    	if(l > 7)
    	{
    		if(!(f1 || f3))
    		{
        		setBlockBounds(0.0625F, 0F, 0.0625F, 0.1875F, 0.625F, 0.1875F);
        		super.getCollidingBoundingBoxes(world, i, j, k, axisalignedbb, arraylist);
    		}
    		if(!(f || f3))
    		{
        		setBlockBounds(0.8125F, 0F, 0.0625F, 0.9375F, 0.625F, 0.1875F);
        		super.getCollidingBoundingBoxes(world, i, j, k, axisalignedbb, arraylist);
    		}
    		if(!(f1 || f2))
    		{
        		setBlockBounds(0.0625F, 0F, 0.8125F, 0.1875F, 0.625F, 0.9375F);
        		super.getCollidingBoundingBoxes(world, i, j, k, axisalignedbb, arraylist);
    		}
    		if(!(f || f2))
    		{
        		setBlockBounds(0.8125F, 0F, 0.8125F, 0.9375F, 0.625F, 0.9375F);
        		super.getCollidingBoundingBoxes(world, i, j, k, axisalignedbb, arraylist);
    		}
    		setBlockBounds(0F, 0.625F, 0F, 1F, 0.75F, 1F);
    		super.getCollidingBoundingBoxes(world, i, j, k, axisalignedbb, arraylist);
    	}else
    	{
    		if(!(f1 || f3))
    		{
    			setBlockBounds(0F, 0F, 0F, 0.125F, 0.875F, 0.125F);
        		super.getCollidingBoundingBoxes(world, i, j, k, axisalignedbb, arraylist);
    		}
    		if(!(f || f3))
    		{
    			setBlockBounds(0.875F, 0F, 0F, 1F, 0.875F, 0.125F);
        		super.getCollidingBoundingBoxes(world, i, j, k, axisalignedbb, arraylist);
    		}
    		if(!(f1 || f2))
    		{
    			setBlockBounds(0F, 0F, 0.875F, 0.125F, 0.875F, 1F);
        		super.getCollidingBoundingBoxes(world, i, j, k, axisalignedbb, arraylist);
    		}
    		if(!(f || f2))
    		{
    			setBlockBounds(0.875F, 0F, 0.875F, 1F, 0.875F, 1F);
        		super.getCollidingBoundingBoxes(world, i, j, k, axisalignedbb, arraylist);
    		}
    		setBlockBounds(0F, 0.875F, 0F, 1F, 1F, 1F);
    		super.getCollidingBoundingBoxes(world, i, j, k, axisalignedbb, arraylist);
    	}
    	setBlockBoundsBasedOnState(world, i, j, k);
    }
    
    public int getBlockTextureFromSideAndMetadata(int i, int j)
    {
    	j %= 8;
    	if(j > 0 && j < 4)
    	{
    		return Block.wood.getBlockTextureFromSideAndMetadata(i, j-1);
    	}
    	if(j == 4)
    	{
    		return Block.cobblestone.blockIndexInTexture;
    	}
    	if(j == 5)
    	{
    		return Block.stairSingle.blockIndexInTexture;
    	}
    	return Block.planks.blockIndexInTexture;
    }
    
    public int getRenderType()
    {
        return 19;
    }
    
    public boolean renderAsNormalBlock()
    {
        return false;
    }
    
    public boolean isOpaqueCube()
    {
        return false;
    }
    
    protected int damageDropped(int i)
    {
        return i;
    }
    
    public static String[] tableTypes = new String[]{
    		"planks", "log", "log", "log", "cobblestone", "stone"
    };
    private Random rand;
}
