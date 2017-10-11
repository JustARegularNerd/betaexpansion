// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            ItemBlock

public class ItemTable extends ItemBlock
{

    public ItemTable(int i)
    {
        super(i);
        setMaxDamage(0);
        setHasSubtypes(true);
    }
    
	public int getIconFromDamage(int i)
    {
		return BEBlocks.table.getBlockTextureFromSideAndMetadata(0, i);
    }
	
    public int getPlacedBlockMetadata(int i)
    {
        return i;
    }    
    
    public String getItemNameIS(ItemStack itemstack)
    {
        return (new StringBuilder()).append(super.getItemName()).append(".").append(BlockTable.tableTypes[itemstack.getItemDamage()%8]).toString();
    }
}
