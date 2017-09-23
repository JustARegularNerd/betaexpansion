// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            ItemBlock, Block

public class ItemPieSlice extends ItemFood
{

    public ItemPieSlice(int i, int j)
    {
        super(i,j,false);
        setMaxDamage(0);
        setHasSubtypes(true);
        cooldown = 20;
    }

    public int getIconFromDamage(int i)
    {
        return i > 0 ? iconIndex + 16 : iconIndex;
    }
    
    public boolean onItemUse(ItemStack itemstack, EntityPlayer entityplayer, World world, int i, int j, int k, int l)
    {
    	if(!entityplayer.isSneaking())
    	{
    		return false;
    	}
    	i += sideX[l];
    	j += sideY[l];
    	k += sideZ[l];
        if(itemstack.stackSize == 0)
        {
            return false;
        }
        int l1 = world.getBlockId(i, j, k);
        int i1 = world.getBlockMetadata(i, j, k);
        if(world.canBlockBePlacedAt(BEBlocks.blockPie.blockID, i, j, k, false, l))
        {
            Block block = Block.blocksList[BEBlocks.blockPie.blockID];
            if(world.setBlockWithNotify(i, j, k, BEBlocks.blockPie.blockID))
            {
                Block.blocksList[BEBlocks.blockPie.blockID].onBlockPlaced(world, i, j, k, l);
                Block.blocksList[BEBlocks.blockPie.blockID].onBlockPlacedBy(world, i, j, k, entityplayer);
                world.playSoundEffect((float)i + 0.5F, (float)j + 0.5F, (float)k + 0.5F, block.stepSound.func_1145_d(), (block.stepSound.getVolume() + 1.0F) / 2.0F, block.stepSound.getPitch() * 0.8F);
                itemstack.stackSize--;
            }
        }else if(l1 == BEBlocks.blockPie.blockID && i1 % 6 > 0 && 1-(i1/6) == itemstack.getItemDamage())
        {
            Block block = Block.blocksList[BEBlocks.blockPie.blockID];
            world.setBlockMetadataWithNotify(i, j, k, i1 - 1); 
            world.playSoundEffect((float)i + 0.5F, (float)j + 0.5F, (float)k + 0.5F, block.stepSound.func_1145_d(), (block.stepSound.getVolume() + 1.0F) / 2.0F, block.stepSound.getPitch() * 0.8F);
            itemstack.stackSize--;
        }
        return true;
    }
    
    private static int[] sideX = new int[]{
    		0,0,0,0,-1,1
    };
    private static int[] sideY = new int[]{
    		-1,1,0,0,0,0
    };
    private static int[] sideZ = new int[]{
    		0,0,-1,1,0,0
    };
}
