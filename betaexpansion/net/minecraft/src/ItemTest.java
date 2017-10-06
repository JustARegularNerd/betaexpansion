package net.minecraft.src;

public class ItemTest extends ItemBlock
{
    public ItemTest(int i)
    {
        super(i);
        setMaxDamage(0);
        setHasSubtypes(true);
    }
	
    public int getPlacedBlockMetadata(int i)
    {
        return i;
    }
}
