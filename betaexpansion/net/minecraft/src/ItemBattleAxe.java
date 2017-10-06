// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            ItemTool, Block, EnumToolMaterial

public class ItemBattleAxe extends ItemTool
{

    protected ItemBattleAxe(int i, EnumToolMaterial enumtoolmaterial)
    {
        super(i, 3, enumtoolmaterial, ItemAxe.blocksEffectiveAgainst, ItemAxe.materialsEffectiveAgainst);
        setMaxDamage((int)(enumtoolmaterial.getMaxUses()*1.5F));
    }

    public boolean hitEntity(ItemStack itemstack, EntityLiving entityliving, EntityLiving entityliving1)
    {
        itemstack.damageItem(1, entityliving1);
        return true;
    }
}
