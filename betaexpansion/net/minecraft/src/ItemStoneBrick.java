// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            ItemBlock

public class ItemStoneBrick extends ItemBlock
{

    public ItemStoneBrick(int i)
    {
        super(i);
        setMaxDamage(0);
        setHasSubtypes(true);
    }

	public int getIconFromDamage(int i)
    {
		if(shiftedIndex == 100)
		{
			return BEBlocks.stoneBrick.getBlockTextureFromSideAndMetadata(2, i);
		}else
		{
			return BEBlocks.sandstoneBrick.getBlockTextureFromSideAndMetadata(2, i);
		}
    }
	
    public int getPlacedBlockMetadata(int i)
    {
        return i;
    }    
}
