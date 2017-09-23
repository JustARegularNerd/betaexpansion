package net.minecraft.src;

public class ItemBerry extends ItemFood
{
    public ItemBerry(int i, int j)
    {
        super(i, j, false);
    }
    
    public int getIconFromDamage(int i)
    {
        return i == 0 ? iconIndex : iconIndex + 16;
    }

    public String getItemNameIS(ItemStack itemstack)
    {
        return getItemName() + "." + (itemstack.getItemDamage() == 0 ? "blue" : "red");
    }
}
