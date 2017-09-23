// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            ItemBlock, Block

public class ItemPie extends ItemBlock
{

    public ItemPie(int i)
    {
        super(i);
        setMaxDamage(0);
        setHasSubtypes(true);
    }

    public int getIconFromDamage(int i)
    {
        return BEBlocks.blockPie.getBlockTextureFromSideAndMetadata(2, i);
    }
    
    public String getItemNameIS(ItemStack itemstack)
    {
    	return getItemName() + "." + (itemstack.getItemDamage() > 5 ? "blue" : "red");
    }
    
    public int getPlacedBlockMetadata(int i)
    {
        return i;
    }
}
