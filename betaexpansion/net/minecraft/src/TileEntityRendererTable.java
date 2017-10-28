// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            TileEntitySpecialRenderer, Block, TileEntityPiston, Tessellator, 
//            RenderHelper, RenderBlocks, BlockPistonBase, BlockPistonExtension, 
//            World, TileEntity

public class TileEntityRendererTable extends TileEntitySpecialRenderer
{

    public TileEntityRendererTable()
    {
    	mc = ModLoader.getMinecraftInstance();
    }

    public void renderTileEntityAt(TileEntity tileentity, double d, double d1, double d2, 
            float f)
    {
    	Tessellator tessellator = Tessellator.instance;
    	int l = ((TileEntityTable)tileentity).worldObj.getBlockMetadata(((TileEntityTable)tileentity).xCoord, ((TileEntityTable)tileentity).yCoord, ((TileEntityTable)tileentity).zCoord);
        for(int i = 0; i < 9; i++)
        {
        	ItemStack itemstack = ((TileEntityTable)tileentity).getStackInSlot(i);
        	if(itemstack != null && itemstack.itemID != 0)
        	{
        		GL11.glPushMatrix();
        		GL11.glTranslatef((i%3)/3F, 0F, (i/3)/3F);
        		mc.entityRenderer.itemRenderer.doRenderItem_noEntity(itemstack, d+(1/6D), d1+(l<8?1D:0.75D)+0.125D, d2+(1/6D), 1.0F);
        		GL11.glPopMatrix();
        	}
        }
    }

    private Minecraft mc;
}
