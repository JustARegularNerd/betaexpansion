// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            ItemBlock, Block, BlockStep, ItemStack

public class ItemSlab extends ItemBlock
{

    public ItemSlab(int i)
    {
        super(i);
        setMaxDamage(0);
        setHasSubtypes(true);
    }

    public int getIconFromDamage(int i)
    {
        return Block.stairSingle.getBlockTextureFromSideAndMetadata(2, i);
    }

    public int getPlacedBlockMetadata(int i)
    {
        return i;
    }

    public String getItemNameIS(ItemStack itemstack)
    {
        return (new StringBuilder()).append(super.getItemName()).append(".").append(BlockStep.field_22037_a[itemstack.getItemDamage()]).toString();
    }

    public boolean onItemUse(ItemStack itemstack, EntityPlayer entityplayer, World world, int i, int j, int k, int l)
    {
    	boolean flag = false;
    	boolean flag2 = false;
        if(world.getBlockId(i, j, k) == Block.snow.blockID)
        {
            l = 0;
        }
    	int l1 = world.getBlockMetadata(i+sideX[l], j+sideY[l], k+sideZ[l]);
    	int l2 = itemstack.getItemDamage();
        int l3 = world.getBlockId(i, j, k);
        int j1 = world.getBlockMetadata(i, j, k);
        if(l == 1 && l3 == Block.stairSingle.blockID && j1 % 6 == l2 && j1 < 6)
        {
            world.setBlockAndMetadataWithNotify(i, j, k, Block.stairDouble.blockID, j1 % 6);
            flag2 = flag =  true;
        }else
        if(l == 0 && l3 == Block.stairSingle.blockID && j1 % 6 == l2 && j1 > 5)
        {
        	world.setBlockAndMetadataWithNotify(i, j, k, Block.stairDouble.blockID, j1 % 6);
        	flag2 = flag =  true;
        }else
        if(world.getBlockId(i+sideX[l], j+sideY[l], k+sideZ[l]) == Block.stairSingle.blockID && l1 % 6 == l2 && l3 != Block.stairSingle.blockID)
        {
        	world.setBlockAndMetadataWithNotify(i+sideX[l], j+sideY[l], k+sideZ[l], Block.stairDouble.blockID, l1 % 6);
        	flag2 = flag =  true;
        }else
        {
        	flag =  super.onItemUse(itemstack, entityplayer, world, i, j, k, l);
        }
        if(flag2)
        {
            world.playSoundEffect((float)i + 0.5F, (float)j + 0.5F, (float)k + 0.5F, Block.stairDouble.stepSound.func_1145_d(), (Block.stairDouble.stepSound.getVolume() + 1.0F) / 2.0F, Block.stairDouble.stepSound.getPitch() * 0.8F);
            itemstack.stackSize--;
        }
        return flag;
    }
    
    private static int sideX[] = new int[]{
    		0, 0, 0, 0, -1, 1
    };
    private static int sideY[] = new int[]{
    		-1, 1, 0, 0, 0, 0
    };
    private static int sideZ[] = new int[]{
    		0, 0, -1, 1, 0, 0
    };
}
