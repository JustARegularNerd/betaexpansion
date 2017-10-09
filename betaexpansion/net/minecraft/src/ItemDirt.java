// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            ItemBlock

public class ItemDirt extends ItemBlock
{

    public ItemDirt(int i)
    {
        super(i);
        setMaxDamage(0);
        setHasSubtypes(true);
    }

	public int getIconFromDamage(int i)
    {
		return Block.dirt.getBlockTextureFromSideAndMetadata(2, i);
    }
	
    public int getPlacedBlockMetadata(int i)
    {
        return i;
    }    
}
