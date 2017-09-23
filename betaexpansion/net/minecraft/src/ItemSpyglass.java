package net.minecraft.src;

public class ItemSpyglass extends Item {

	protected ItemSpyglass(int i) {
        super(i);
		maxStackSize = 1;
	}
	
    public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer)
    {
        EntityRenderer.zoom ^= true;
    	stackUsed = entityplayer.inventory.getStackInSlot(entityplayer.inventory.currentItem);
    	slotUsed = entityplayer.inventory.currentItem;
    	return itemstack;
    }
    
    public static ItemStack stackUsed;
    public static int slotUsed;
}