// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL13;

// Referenced classes of package net.minecraft.src:
//            RenderBlocks, MapItemRenderer, ItemStack, Block, 
//            RenderEngine, EntityLiving, Tessellator, EntityPlayer, 
//            RenderHelper, MathHelper, World, Item, 
//            ItemMap, EntityPlayerSP, RenderManager, RenderPlayer, 
//            Material, BlockFire, InventoryPlayer

public class ItemRenderer
{

    public ItemRenderer(Minecraft minecraft)
    {
        itemToRender = null;
        equippedProgress = 0.0F;
        prevEquippedProgress = 0.0F;
        renderBlocksInstance = new RenderBlocks();
        field_20099_f = -1;
        mc = minecraft;
        field_28131_f = new MapItemRenderer(minecraft.fontRenderer, minecraft.gameSettings, minecraft.renderEngine);
    }

    public void doRenderItem_noEntity(ItemStack itemstack, double d, double d1, double d2, 
            float f)
    {
        GL11.glPushMatrix();
        GL11.glTranslatef((float)d, (float)d1, (float)d2);
        GL11.glEnable(32826 /*GL_RESCALE_NORMAL_EXT*/);
        if(itemstack.itemID < 256 && RenderBlocks.renderItemIn3d(Block.blocksList[itemstack.itemID].getRenderType()))
        {
            mc.renderEngine.bindTexture(BETextureHelper.getTextureFromIdAndMetadata(itemstack.itemID, itemstack.getItemDamage()));
            float f4 = 0.25F;
            GL11.glScalef(f4, f4, f4);
            GL11.glPushMatrix();
            renderBlocksInstance.renderBlockOnInventory(Block.blocksList[itemstack.itemID], itemstack.getItemDamage(), f);
            GL11.glPopMatrix();
        } else
        {
            GL11.glScalef(0.3F, 0.3F, 0.3F);
            int i = itemstack.getIconIndex();
            mc.renderEngine.bindTexture(BETextureHelper.getTextureFromIdAndMetadata(itemstack.itemID, itemstack.getItemDamage()));
            Tessellator tessellator = Tessellator.instance;
            float f6 = (float)((i % 16) * 16 + 0) / 256F;
            float f8 = (float)((i % 16) * 16 + 16) / 256F;
            float f10 = (float)((i / 16) * 16 + 0) / 256F;
            float f11 = (float)((i / 16) * 16 + 16) / 256F;
            float f12 = 1.0F;
            float f13 = 0.5F;
            float f14 = 0.4F;
            GL11.glPushMatrix();
            GL11.glRotatef(180F - RenderManager.instance.playerViewY, 0.0F, 1.0F, 0.0F);
            tessellator.startDrawingQuads();
            tessellator.setNormal(0.0F, 1.0F, 0.0F);
            tessellator.addVertexWithUV(0.0F - f13, 0.0F - f14, 0.0D, f6, f11);
            tessellator.addVertexWithUV(f12 - f13, 0.0F - f14, 0.0D, f8, f11);
            tessellator.addVertexWithUV(f12 - f13, 1.0F - f14, 0.0D, f8, f10);
            tessellator.addVertexWithUV(0.0F - f13, 1.0F - f14, 0.0D, f6, f10);
            tessellator.draw();
            GL11.glPopMatrix();

        }
        GL11.glDisable(32826 /*GL_RESCALE_NORMAL_EXT*/);
        GL11.glPopMatrix();
    }
    
    public void renderItem(EntityLiving entityliving, ItemStack itemstack)
    {
        GL11.glPushMatrix();
        if(itemstack.itemID < 256 && RenderBlocks.renderItemIn3d(Block.blocksList[itemstack.itemID].getRenderType()))
        {
        	GL11.glBindTexture(3553 /*GL_TEXTURE_2D*/, BETextureHelper.getTextureFromIdAndMetadata(itemstack.itemID, itemstack.getItemDamage()));
            renderBlocksInstance.renderBlockOnInventory(Block.blocksList[itemstack.itemID], itemstack.getItemDamage(), 1.0F);
        } else
        {
        	double size;
            if(itemstack.itemID < 96)
            {
                GL11.glBindTexture(3553 /*GL_TEXTURE_2D*/, mc.renderEngine.getTexture("/terrain.png"));
                size = (Integer)mc.renderEngine.textureSizeIdMap.get(mc.renderEngine.getTexture("/terrain.png"))/16D;
            } else
            {
            	GL11.glBindTexture(3553 /*GL_TEXTURE_2D*/, BETextureHelper.getTextureFromIdAndMetadata(itemstack.itemID, itemstack.getItemDamage()));
                size = (Integer)mc.renderEngine.textureSizeIdMap.get(BETextureHelper.getTextureFromIdAndMetadata(itemstack.itemID, itemstack.getItemDamage()))/16D;
            }
            double sideOffset = 1.0F/(float)(32*size);
            Tessellator tessellator = Tessellator.instance;
            int i = entityliving.getItemIcon(itemstack);
            
            double f = ((double)((i % 16) * 16) + 0.0D) / 256D;
            double f1 = ((double)((i % 16) * 16) + 16) / 256D;
            double f2 = ((double)((i / 16) * 16) + 0.0D) / 256D;
            double f3 = ((double)((i / 16) * 16) + 16) / 256D;
            float f4 = 1.0F;
            float f5 = 0.0F;
            float f6 = 0.3F;
            GL11.glEnable(32826 /*GL_RESCALE_NORMAL_EXT*/);
            GL11.glTranslatef(-f5, -f6, 0.0F);
            float f7 = 1.5F;
            GL11.glScalef(f7, f7, f7);
            GL11.glRotatef(50F, 0.0F, 1.0F, 0.0F);
            GL11.glRotatef(335F, 0.0F, 0.0F, 1.0F);
            GL11.glTranslatef(-0.9375F, -0.0625F, 0.0F);
            double f8 = 0.0625F;
            double x1 = 1/size;
            tessellator.startDrawingQuads();
            tessellator.setNormal(0.0F, 0.0F, 1.0F);
            tessellator.addVertexWithUV(0.0D, 0.0D, 0.0D, f1, f3);
            tessellator.addVertexWithUV(f4, 0.0D, 0.0D, f, f3);
            tessellator.addVertexWithUV(f4, 1.0D, 0.0D, f, f2);
            tessellator.addVertexWithUV(0.0D, 1.0D, 0.0D, f1, f2);
            tessellator.draw();
            tessellator.startDrawingQuads();
            tessellator.setNormal(0.0F, 0.0F, -1F);
            tessellator.addVertexWithUV(0.0D, 1.0D, 0.0F - f8, f1, f2);
            tessellator.addVertexWithUV(f4, 1.0D, 0.0F - f8, f, f2);
            tessellator.addVertexWithUV(f4, 0.0D, 0.0F - f8, f, f3);
            tessellator.addVertexWithUV(0.0D, 0.0D, 0.0F - f8, f1, f3);
            tessellator.draw();
            tessellator.startDrawingQuads();
            tessellator.setNormal(-1F, 0.0F, 0.0F);
            for(int j = 0; j < size; j++)
            {
            	double f9 = (double)j / size;
                double f13 = (f1 + (f - f1) * f9) - sideOffset;
                double f17 = f4 * f9;
                tessellator.addVertexWithUV(f17, 0.0D, 0.0F - f8, f13, f3);
                tessellator.addVertexWithUV(f17, 0.0D, 0.0D, f13, f3);
                tessellator.addVertexWithUV(f17, 1.0D, 0.0D, f13, f2);
                tessellator.addVertexWithUV(f17, 1.0D, 0.0F - f8, f13, f2);
            }

            tessellator.draw();
            tessellator.startDrawingQuads();
            tessellator.setNormal(1.0F, 0.0F, 0.0F);
            for(int k = 0; k < size; k++)
            {
            	double f10 = (double)k / size;
                double f14 = (f1 + (f - f1) * f10) - sideOffset;
                double f18 = f4 * f10 + x1;
                tessellator.addVertexWithUV(f18, 1.0D, 0.0F - f8, f14, f2);
                tessellator.addVertexWithUV(f18, 1.0D, 0.0D, f14, f2);
                tessellator.addVertexWithUV(f18, 0.0D, 0.0D, f14, f3);
                tessellator.addVertexWithUV(f18, 0.0D, 0.0F - f8, f14, f3);
            }

            tessellator.draw();
            tessellator.startDrawingQuads();
            tessellator.setNormal(0.0F, 1.0F, 0.0F);
            for(int l = 0; l < size; l++)
            {
            	double f11 = (double)l / size;
                double f15 = (f3 + (f2 - f3) * f11) - sideOffset;
                double f19 = f4 * f11 + x1;
                tessellator.addVertexWithUV(0.0D, f19, 0.0D, f1, f15);
                tessellator.addVertexWithUV(f4, f19, 0.0D, f, f15);
                tessellator.addVertexWithUV(f4, f19, 0.0F - f8, f, f15);
                tessellator.addVertexWithUV(0.0D, f19, 0.0F - f8, f1, f15);
            }

            tessellator.draw();
            tessellator.startDrawingQuads();
            tessellator.setNormal(0.0F, -1F, 0.0F);
            for(int i1 = 0; i1 < size; i1++)
            {
            	double f12 = (double)i1 / size;
                double f16 = (f3 + (f2 - f3) * f12) - sideOffset;
                double f20 = f4 * f12;
                tessellator.addVertexWithUV(f4, f20, 0.0D, f, f16);
                tessellator.addVertexWithUV(0.0D, f20, 0.0D, f1, f16);
                tessellator.addVertexWithUV(0.0D, f20, 0.0F - f8, f1, f16);
                tessellator.addVertexWithUV(f4, f20, 0.0F - f8, f, f16);
            }

            tessellator.draw();
            GL11.glDisable(32826 /*GL_RESCALE_NORMAL_EXT*/);
        }
        GL11.glPopMatrix();
    }

    public void renderItemInFirstPerson(float f)
    {
        float f1 = prevEquippedProgress + (equippedProgress - prevEquippedProgress) * f;
        EntityPlayer entityplayersp = mc.thePlayer;
        float f2 = ((EntityPlayer) (entityplayersp)).prevRotationPitch + (((EntityPlayer) (entityplayersp)).rotationPitch - ((EntityPlayer) (entityplayersp)).prevRotationPitch) * f;
        GL11.glPushMatrix();
        GL11.glRotatef(f2, 1.0F, 0.0F, 0.0F);
        GL11.glRotatef(((EntityPlayer) (entityplayersp)).prevRotationYaw + (((EntityPlayer) (entityplayersp)).rotationYaw - ((EntityPlayer) (entityplayersp)).prevRotationYaw) * f, 0.0F, 1.0F, 0.0F);
        RenderHelper.enableStandardItemLighting();
        GL11.glPopMatrix();
        if (entityplayersp instanceof EntityPlayerSP)
        {
            EntityPlayerSP entityplayersp1 = (EntityPlayerSP)entityplayersp;
            float x2 = entityplayersp1.prevRenderArmPitch + (entityplayersp1.renderArmPitch - entityplayersp1.prevRenderArmPitch) * f;
            float x4 = entityplayersp1.prevRenderArmYaw + (entityplayersp1.renderArmYaw - entityplayersp1.prevRenderArmYaw) * f;
            GL11.glRotatef((((EntityPlayer)(entityplayersp)).rotationPitch - x2) * 0.1F, 1.0F, 0.0F, 0.0F);
            GL11.glRotatef((((EntityPlayer)(entityplayersp)).rotationYaw - x4) * 0.1F, 0.0F, 1.0F, 0.0F);
        }
        ItemStack itemstack = itemToRender;
        int i1 = mc.theWorld.getRenderBrightness(MathHelper.floor_double(((EntityPlayer) (entityplayersp)).posX), MathHelper.floor_double(((EntityPlayer) (entityplayersp)).posY), MathHelper.floor_double(((EntityPlayer) (entityplayersp)).posZ), 0);
        int k = i1 % 0x10000;
        int l = i1 / 0x10000;
        GL13.glMultiTexCoord2f(33985 /*GL_TEXTURE1_ARB*/, (float)k / 1.0F, (float)l / 1.0F);
        if(itemstack != null)
        {
            int i = Item.itemsList[itemstack.itemID].getColorFromDamage(itemstack.getItemDamage());
            float f7 = (float)(i >> 16 & 0xff) / 255F;
            float f11 = (float)(i >> 8 & 0xff) / 255F;
            float f15 = (float)(i & 0xff) / 255F;
            GL11.glColor4f(f7, f11, f15, 1.0F);
        } else
        {
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        }
        if(itemstack != null && itemstack.itemID == Item.mapItem.shiftedIndex)
        {
            GL11.glPushMatrix();
            float f4 = 0.8F;
            float f8 = entityplayersp.getSwingProgress(f);
            float f12 = MathHelper.sin(f8 * 3.141593F);
            float f16 = MathHelper.sin(MathHelper.sqrt_float(f8) * 3.141593F);
            GL11.glTranslatef(-f16 * 0.4F, MathHelper.sin(MathHelper.sqrt_float(f8) * 3.141593F * 2.0F) * 0.2F, -f12 * 0.2F);
            f8 = (1.0F - f2 / 45F) + 0.1F;
            if(f8 < 0.0F)
            {
                f8 = 0.0F;
            }
            if(f8 > 1.0F)
            {
                f8 = 1.0F;
            }
            f8 = -MathHelper.cos(f8 * 3.141593F) * 0.5F + 0.5F;
            GL11.glTranslatef(0.0F, (0.0F * f4 - (1.0F - f1) * 1.2F - f8 * 0.5F) + 0.04F, -0.9F * f4);
            GL11.glRotatef(90F, 0.0F, 1.0F, 0.0F);
            GL11.glRotatef(f8 * -85F, 0.0F, 0.0F, 1.0F);
            GL11.glEnable(32826 /*GL_RESCALE_NORMAL_EXT*/);
            GL11.glBindTexture(3553 /*GL_TEXTURE_2D*/, mc.renderEngine.getTextureForDownloadableImage(mc.thePlayer.skinUrl, mc.thePlayer.getEntityTexture()));
            for(f12 = 0; f12 < 2; f12++)
            {
                f16 = f12 * 2 - 1;
                GL11.glPushMatrix();
                GL11.glTranslatef(-0F, -0.6F, 1.1F * (float)f16);
                GL11.glRotatef(-45 * f16, 1.0F, 0.0F, 0.0F);
                GL11.glRotatef(-90F, 0.0F, 0.0F, 1.0F);
                GL11.glRotatef(59F, 0.0F, 0.0F, 1.0F);
                GL11.glRotatef(-65 * f16, 0.0F, 1.0F, 0.0F);
                Render render1 = RenderManager.instance.getEntityRenderObject(mc.thePlayer);
                RenderPlayer renderplayer1 = (RenderPlayer)render1;
                float f20 = 1.0F;
                GL11.glScalef(f20, f20, f20);
                renderplayer1.drawFirstPersonHand(mc.thePlayer);
                GL11.glPopMatrix();
            }

            f12 = entityplayersp.getSwingProgress(f);
            f16 = MathHelper.sin(f12 * f12 * 3.141593F);
            float f19 = MathHelper.sin(MathHelper.sqrt_float(f12) * 3.141593F);
            GL11.glRotatef(-f16 * 20F, 0.0F, 1.0F, 0.0F);
            GL11.glRotatef(-f19 * 20F, 0.0F, 0.0F, 1.0F);
            GL11.glRotatef(-f19 * 80F, 1.0F, 0.0F, 0.0F);
            f12 = 0.38F;
            GL11.glScalef(f12, f12, f12);
            GL11.glRotatef(90F, 0.0F, 1.0F, 0.0F);
            GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
            GL11.glTranslatef(-1F, -1F, 0.0F);
            f16 = 0.015625F;
            GL11.glScalef(f16, f16, f16);
            mc.renderEngine.bindTexture(mc.renderEngine.getTexture("/misc/mapbg.png"));
            Tessellator tessellator = Tessellator.instance;
            GL11.glNormal3f(0.0F, 0.0F, -1F);
            tessellator.startDrawingQuads();
            byte byte0 = 7;
            tessellator.addVertexWithUV(0 - byte0, 128 + byte0, 0.0D, 0.0D, 1.0D);
            tessellator.addVertexWithUV(128 + byte0, 128 + byte0, 0.0D, 1.0D, 1.0D);
            tessellator.addVertexWithUV(128 + byte0, 0 - byte0, 0.0D, 1.0D, 0.0D);
            tessellator.addVertexWithUV(0 - byte0, 0 - byte0, 0.0D, 0.0D, 0.0D);
            tessellator.draw();
            MapData mapdata = Item.mapItem.func_28012_a(itemstack, mc.theWorld);
            field_28131_f.func_28157_a(mc.thePlayer, mc.renderEngine, mapdata);
            GL11.glPopMatrix();
        } else
        if(itemstack != null)
        {
            GL11.glPushMatrix();
            float f5 = 0.8F;
            float f9 = entityplayersp.getSwingProgress(f);
            float f13 = MathHelper.sin(f9 * 3.141593F);
            float f17 = MathHelper.sin(MathHelper.sqrt_float(f9) * 3.141593F);
            GL11.glTranslatef(-f17 * 0.4F, MathHelper.sin(MathHelper.sqrt_float(f9) * 3.141593F * 2.0F) * 0.2F, -f13 * 0.2F);
            GL11.glTranslatef(0.7F * f5, -0.65F * f5 - (1.0F - f1) * 0.6F, -0.9F * f5);
            GL11.glRotatef(45F, 0.0F, 1.0F, 0.0F);
            GL11.glEnable(32826 /*GL_RESCALE_NORMAL_EXT*/);
            f9 = entityplayersp.getSwingProgress(f);
            f13 = MathHelper.sin(f9 * f9 * 3.141593F);
            f17 = MathHelper.sin(MathHelper.sqrt_float(f9) * 3.141593F);
            GL11.glRotatef(-f13 * 20F, 0.0F, 1.0F, 0.0F);
            GL11.glRotatef(-f17 * 20F, 0.0F, 0.0F, 1.0F);
            GL11.glRotatef(-f17 * 80F, 1.0F, 0.0F, 0.0F);
            f9 = 0.4F;
            GL11.glScalef(f9, f9, f9);
            if(itemstack.getItem().shouldRotateAroundWhenRendering())
            {
                GL11.glRotatef(180F, 0.0F, 1.0F, 0.0F);
            }
            renderItem(entityplayersp, itemstack);
            GL11.glPopMatrix();
        } else
        {
            GL11.glPushMatrix();
            float f6 = 0.8F;
            float f10 = entityplayersp.getSwingProgress(f);
            float f14 = MathHelper.sin(f10 * 3.141593F);
            float f18 = MathHelper.sin(MathHelper.sqrt_float(f10) * 3.141593F);
            GL11.glTranslatef(-f18 * 0.3F, MathHelper.sin(MathHelper.sqrt_float(f10) * 3.141593F * 2.0F) * 0.4F, -f14 * 0.4F);
            GL11.glTranslatef(0.8F * f6, -0.75F * f6 - (1.0F - f1) * 0.6F, -0.9F * f6);
            GL11.glRotatef(45F, 0.0F, 1.0F, 0.0F);
            GL11.glEnable(32826 /*GL_RESCALE_NORMAL_EXT*/);
            f10 = entityplayersp.getSwingProgress(f);
            f14 = MathHelper.sin(f10 * f10 * 3.141593F);
            f18 = MathHelper.sin(MathHelper.sqrt_float(f10) * 3.141593F);
            GL11.glRotatef(f18 * 70F, 0.0F, 1.0F, 0.0F);
            GL11.glRotatef(-f14 * 20F, 0.0F, 0.0F, 1.0F);
            GL11.glBindTexture(3553 /*GL_TEXTURE_2D*/, mc.renderEngine.getTextureForDownloadableImage(mc.thePlayer.skinUrl, mc.thePlayer.getEntityTexture()));
            GL11.glTranslatef(-1F, 3.6F, 3.5F);
            GL11.glRotatef(120F, 0.0F, 0.0F, 1.0F);
            GL11.glRotatef(200F, 1.0F, 0.0F, 0.0F);
            GL11.glRotatef(-135F, 0.0F, 1.0F, 0.0F);
            GL11.glScalef(1.0F, 1.0F, 1.0F);
            GL11.glTranslatef(5.6F, 0.0F, 0.0F);
            Render render = RenderManager.instance.getEntityRenderObject(mc.thePlayer);
            RenderPlayer renderplayer = (RenderPlayer)render;
            f18 = 1.0F;
            GL11.glScalef(f18, f18, f18);
            renderplayer.drawFirstPersonHand(mc.thePlayer);
            GL11.glPopMatrix();
        }
        GL11.glDisable(32826 /*GL_RESCALE_NORMAL_EXT*/);
        RenderHelper.disableStandardItemLighting();
    }

    public void renderOverlays(float f)
    {
        GL11.glDisable(3008 /*GL_ALPHA_TEST*/);
        if(mc.thePlayer.isBurning())
        {
            int i = mc.renderEngine.getTexture("/terrain.png");
            GL11.glBindTexture(3553 /*GL_TEXTURE_2D*/, i);
            renderFireInFirstPerson(f);
        }
        if(mc.thePlayer.isEntityInsideOpaqueBlock())
        {
            int j = MathHelper.floor_double(mc.thePlayer.posX);
            int l = MathHelper.floor_double(mc.thePlayer.posY);
            int i1 = MathHelper.floor_double(mc.thePlayer.posZ);
            int j1 = mc.renderEngine.getTexture("/terrain.png");
            GL11.glBindTexture(3553 /*GL_TEXTURE_2D*/, j1);
            int k1 = mc.theWorld.getBlockId(j, l, i1);
            if(mc.theWorld.isBlockNormalCube(j, l, i1))
            {
                renderInsideOfBlock(f, Block.blocksList[k1].getBlockTextureFromSide(2));
            } else
            {
                for(int l1 = 0; l1 < 8; l1++)
                {
                    float f1 = ((float)((l1 >> 0) % 2) - 0.5F) * mc.thePlayer.width * 0.9F;
                    float f2 = ((float)((l1 >> 1) % 2) - 0.5F) * mc.thePlayer.height * 0.2F;
                    float f3 = ((float)((l1 >> 2) % 2) - 0.5F) * mc.thePlayer.width * 0.9F;
                    int i2 = MathHelper.floor_float((float)j + f1);
                    int j2 = MathHelper.floor_float((float)l + f2);
                    int k2 = MathHelper.floor_float((float)i1 + f3);
                    if(mc.theWorld.isBlockNormalCube(i2, j2, k2))
                    {
                        k1 = mc.theWorld.getBlockId(i2, j2, k2);
                    }
                }

            }
            if(Block.blocksList[k1] != null)
            {
                renderInsideOfBlock(f, Block.blocksList[k1].getBlockTextureFromSide(2));
            }
        }
        if(mc.thePlayer.isInsideOfMaterial(Material.water))
        {
            int k = mc.renderEngine.getTexture("/misc/water.png");
            GL11.glBindTexture(3553 /*GL_TEXTURE_2D*/, k);
            renderWarpedTextureOverlay(f);
        }
        GL11.glEnable(3008 /*GL_ALPHA_TEST*/);
    }

    private void renderInsideOfBlock(float f, int i)
    {
        Tessellator tessellator = Tessellator.instance;
        float f1 = 0.1F;
        GL11.glColor4f(f1, f1, f1, 0.5F);
        GL11.glPushMatrix();
        float f2 = -1F;
        float f3 = 1.0F;
        float f4 = -1F;
        float f5 = 1.0F;
        float f6 = -0.5F;
        float f7 = 0.0078125F;
        float f8 = (float)(i % 16) / 256F - f7;
        float f9 = ((float)(i % 16) + 15.99F) / 256F + f7;
        float f10 = (float)(i / 16) / 256F - f7;
        float f11 = ((float)(i / 16) + 15.99F) / 256F + f7;
        tessellator.startDrawingQuads();
        tessellator.addVertexWithUV(f2, f4, f6, f9, f11);
        tessellator.addVertexWithUV(f3, f4, f6, f8, f11);
        tessellator.addVertexWithUV(f3, f5, f6, f8, f10);
        tessellator.addVertexWithUV(f2, f5, f6, f9, f10);
        tessellator.draw();
        GL11.glPopMatrix();
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
    }

    private void renderWarpedTextureOverlay(float f)
    {
        Tessellator tessellator = Tessellator.instance;
        float f1 = mc.thePlayer.getEntityBrightness(f);
        GL11.glColor4f(f1, f1, f1, 0.5F);
        GL11.glEnable(3042 /*GL_BLEND*/);
        GL11.glBlendFunc(770, 771);
        GL11.glPushMatrix();
        float f2 = 4F;
        float f3 = -1F;
        float f4 = 1.0F;
        float f5 = -1F;
        float f6 = 1.0F;
        float f7 = -0.5F;
        float f8 = -mc.thePlayer.rotationYaw / 64F;
        float f9 = mc.thePlayer.rotationPitch / 64F;
        tessellator.startDrawingQuads();
        tessellator.addVertexWithUV(f3, f5, f7, f2 + f8, f2 + f9);
        tessellator.addVertexWithUV(f4, f5, f7, 0.0F + f8, f2 + f9);
        tessellator.addVertexWithUV(f4, f6, f7, 0.0F + f8, 0.0F + f9);
        tessellator.addVertexWithUV(f3, f6, f7, f2 + f8, 0.0F + f9);
        tessellator.draw();
        GL11.glPopMatrix();
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glDisable(3042 /*GL_BLEND*/);
    }

    private void renderFireInFirstPerson(float f)
    {
    	float x = 16/(((Integer)mc.renderEngine.textureSizeIdMap.get(mc.renderEngine.getTexture("/terrain.png"))/16F)/16);
        Tessellator tessellator = Tessellator.instance;
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 0.9F);
        GL11.glEnable(3042 /*GL_BLEND*/);
        GL11.glBlendFunc(770, 771);
        float f1 = 1.0F;
        for(int i = 0; i < 2; i++)
        {
            GL11.glPushMatrix();
            int j = Block.fire.blockIndexInTexture + i * 16;
            int k = (j & 0xf) << 4;
            int l = j & 0xf0;
            float f2 = (float)k / 256F;
            float f3 = ((float)k + x) / 256F;
            float f4 = (float)l / 256F;
            float f5 = ((float)l + x) / 256F;
            float f6 = (0.0F - f1) / 2.0F;
            float f7 = f6 + f1;
            float f8 = 0.0F - f1 / 2.0F;
            float f9 = f8 + f1;
            float f10 = -0.5F;
            GL11.glTranslatef((float)(-(i * 2 - 1)) * 0.24F, -0.3F, 0.0F);
            GL11.glRotatef((float)(i * 2 - 1) * 10F, 0.0F, 1.0F, 0.0F);
            tessellator.startDrawingQuads();
            tessellator.addVertexWithUV(f6, f8, f10, f3, f5);
            tessellator.addVertexWithUV(f7, f8, f10, f2, f5);
            tessellator.addVertexWithUV(f7, f9, f10, f2, f4);
            tessellator.addVertexWithUV(f6, f9, f10, f3, f4);
            tessellator.draw();
            GL11.glPopMatrix();
        }

        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glDisable(3042 /*GL_BLEND*/);
    }

    public void updateEquippedItem()
    {
        prevEquippedProgress = equippedProgress;
        EntityPlayerSP entityplayersp = mc.thePlayer;
        ItemStack itemstack = ((EntityPlayer) (entityplayersp)).inventory.getCurrentItem();
        ItemStack itemstack1 = itemstack;
        boolean flag = field_20099_f == ((EntityPlayer) (entityplayersp)).inventory.currentItem && itemstack1 == itemToRender;
        if(itemToRender == null && itemstack1 == null)
        {
            flag = true;
        }
        if(itemstack1 != null && itemToRender != null && itemstack1 != itemToRender && itemstack1.itemID == itemToRender.itemID && itemstack1.getItemDamage() == itemToRender.getItemDamage())
        {
            itemToRender = itemstack1;
            flag = true;
        }
        float f = 0.4F;
        float f1 = flag ? 1.0F : 0.0F;
        float f2 = f1 - equippedProgress;
        if(f2 < -f)
        {
            f2 = -f;
        }
        if(f2 > f)
        {
            f2 = f;
        }
        equippedProgress += f2;
        if(equippedProgress < 0.1F)
        {
            itemToRender = itemstack1;
            field_20099_f = ((EntityPlayer) (entityplayersp)).inventory.currentItem;
        }
    }

    public void func_9449_b()
    {
        equippedProgress = 0.0F;
    }

    public void func_9450_c()
    {
        equippedProgress = 0.0F;
    }

    private Minecraft mc;
    private ItemStack itemToRender;
    private float equippedProgress;
    private float prevEquippedProgress;
    private RenderBlocks renderBlocksInstance;
    private MapItemRenderer field_28131_f;
    private int field_20099_f;
}
