// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            Item, ItemStack, EntityPlayer, World

public class ItemFood extends Item
{

    public ItemFood(int i, int j, boolean flag)
    {
        super(i);
        healAmount = j;
        isWolfsFavoriteMeat = flag;
    }

    public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer)
    {
    	if(entityplayer.health < 20 && world.getWorldTime()-time >= cooldown)
    	{
    		time = world.getWorldTime();
    		itemstack.stackSize--;
    		entityplayer.heal(healAmount);
    	}
        return itemstack;
    }
    
    public int getHealAmount()
    {
        return healAmount;
    }

    public boolean getIsWolfsFavoriteMeat()
    {
        return isWolfsFavoriteMeat;
    }
    
    public int cooldown = 10;
    private static long time = 0;
    private int healAmount;
    private boolean isWolfsFavoriteMeat;
}
