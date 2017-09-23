// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            ModelBase, ModelRenderer, MathHelper

public class ModelPlayer extends ModelBiped
{

    public ModelPlayer()
    {
        this(0.0F);
    }

    public ModelPlayer(float f)
    {
        this(f, 0.0F);
    }
    
    public void setPlayer(EntityPlayer entityplayer)
    {
    	thePlayer = entityplayer;
    }
    
    public void updateStatus()
    {
    	isLoaded = thePlayer != null && ((ImageBufferDownload)RenderGlobal.players.get(thePlayer.username)) != null 
    			&& ((ImageBufferDownload)RenderGlobal.players.get(thePlayer.username)).loaded;
    }
    
    public boolean isOld()
    {
    	return (((ImageBufferDownload)RenderGlobal.players.get(thePlayer.username)) == null && RenderEngine.skinResX != RenderEngine.skinResY) || (((ImageBufferDownload)RenderGlobal.players.get(thePlayer.username)) != null 
    			&& ((ImageBufferDownload)RenderGlobal.players.get(thePlayer.username)).isOld);
    }

    public ModelPlayer(float f, float f1)
    {
        field_1279_h = false;
        field_1278_i = false;
        isSneak = false;
        bipedCloak = new ModelRenderer(0, 0, true);
        bipedCloak.addBox(-5F, 0.0F, -1F, 10, 16, 1, f);
        bipedEars = new ModelRenderer(24, 0, true);
        bipedEars.addBox(-3F, -6F, -1F, 6, 6, 1, f);
        bipedHead = new ModelRenderer(0, 0, true);
        bipedHead.addBox(-4F, -8F, -4F, 8, 8, 8, f);
        bipedHead.setRotationPoint(0.0F, 0.0F + f1, 0.0F);
        bipedHeadwear = new ModelRenderer(32, 0, true);
        bipedHeadwear.addBox(-4F, -8F, -4F, 8, 8, 8, f + 0.5F);
        bipedHeadwear.setRotationPoint(0.0F, 0.0F + f1, 0.0F);
        bipedBody = new ModelRenderer(16, 16, true);
        bipedBody.addBox(-4F, 0.0F, -2F, 8, 12, 4, f);
        bipedBody.setRotationPoint(0.0F, 0.0F + f1, 0.0F);
        bipedRightArm = new ModelRenderer(40, 16, true);
        bipedRightArm.addBox(-3F, -2F, -2F, 4, 12, 4, f);
        bipedRightArm.setRotationPoint(-5F, 2.0F + f1, 0.0F);
        bipedRightArm_old = new ModelRenderer(40, 16);
        bipedRightArm_old.addBox(-3F, -2F, -2F, 4, 12, 4, f);
        bipedRightArm_old.setRotationPoint(-5F, 2.0F + f1, 0.0F);
    	bipedLeftArm = new ModelRenderer(32, 48, true);
        bipedLeftArm.addBox(-1F, -2F, -2F, 4, 12, 4, f);
        bipedLeftArm.setRotationPoint(5F, 2.0F + f1, 0.0F);
        bipedRightLeg = new ModelRenderer(0, 16, true);
        bipedRightLeg.addBox(-2F, 0.0F, -2F, 4, 12, 4, f);
        bipedRightLeg.setRotationPoint(-2F, 12F + f1, 0.0F);
    	bipedLeftLeg = new ModelRenderer(16, 48, true);
        bipedLeftLeg.addBox(-2F, 0.0F, -2F, 4, 12, 4, f);
        bipedLeftLeg.setRotationPoint(2.0F, 12F + f1, 0.0F);
        bipedLeftLeg_old = new ModelRenderer(0, 16, true);
        bipedLeftLeg_old.mirror = true;
        bipedLeftLeg_old.addBox(-2F, 0.0F, -2F, 4, 12, 4, f);
        bipedLeftLeg_old.setRotationPoint(2.0F, 12F + f1, 0.0F);
        bipedLeftArm_old = new ModelRenderer(40, 16, true);
        bipedLeftArm_old.mirror = true;
        bipedLeftArm_old.addBox(-1F, -2F, -2F, 4, 12, 4, f);
        bipedLeftArm_old.setRotationPoint(5F, 2.0F + f1, 0.0F);
        bipedRightArm2 = new ModelRenderer(40, 32, true);
        bipedRightArm2.addBox(-3F, -2F, -2F, 4, 12, 4, f + 0.25f);
        bipedRightArm2.setRotationPoint(-5F, 2.0F + f1, 0.0F);
        bipedLeftArm2 = new ModelRenderer(48, 48, true);
        bipedLeftArm2.addBox(-1F, -2F, -2F, 4, 12, 4, f + 0.25f);
        bipedLeftArm2.setRotationPoint(5F, 2.0F + f1, 0.0F);
        bipedRightLeg2 = new ModelRenderer(0, 32, true);
        bipedRightLeg2.addBox(-2F, 0.0F, -2F, 4, 12, 4, f + 0.25f);
        bipedRightLeg2.setRotationPoint(-2F, 12F + f1, 0.0F);
        bipedLeftLeg2 = new ModelRenderer(0, 48, true);
        bipedLeftLeg2.addBox(-2F, 0.0F, -2F, 4, 12, 4, f + 0.25f);
        bipedLeftLeg2.setRotationPoint(2.0F, 12F + f1, 0.0F);
        bipedBody2 = new ModelRenderer(16, 32, true);
        bipedBody2.addBox(-4F, 0.0F, -2F, 8, 12, 4, f + 0.25f);
        bipedBody2.setRotationPoint(0.0F, 0.0F + f1, 0.0F);
    }

    public void render(float f, float f1, float f2, float f3, float f4, float f5)
    {
    	if(!isLoaded && RenderEngine.skinResX != RenderEngine.skinResY)
    	{
    		super.field_1278_i = field_1278_i;
    		super.field_1279_h = field_1279_h;
    		super.isSneak = isSneak;
    		super.isRiding = isRiding;
    		super.onGround = onGround;
    		super.render(f, f1, f2, f3, f4, f5);
    		return;
    	}
        setRotationAngles(f, f1, f2, f3, f4, f5);
        bipedHead.render(f5);
        bipedBody.render(f5);
        bipedRightArm.render(f5);
        bipedRightLeg.render(f5);
        if(isOld())
        {
        	bipedLeftArm_old.render(f5);
        	bipedLeftLeg_old.render(f5);
        }else
        {
            bipedLeftArm.render(f5);
        	bipedLeftLeg.render(f5);
        }
        renderExtra(f5);
    }
    
    public void renderExtra(float f5)
    {
    	if(!isLocal)
    	{
        	bipedHeadwear.render(f5);
        	bipedBody2.render(f5);
        	bipedRightArm2.render(f5);
        	bipedLeftArm2.render(f5);
        	bipedRightLeg2.render(f5);
        	bipedLeftLeg2.render(f5);
        	return;
    	}
        if(GameSettings.modelPart_hat)
        {
        	bipedHeadwear.render(f5);
        }
        if(!isLoaded && RenderEngine.skinResX != RenderEngine.skinResY)
        {
        	return;
        }
        if(GameSettings.modelPart_jacket)
        {
        	bipedBody2.render(f5);
        }
        if(GameSettings.modelPart_right_sleeve)
        {
        	bipedRightArm2.render(f5);
        }
        if(GameSettings.modelPart_left_sleeve)
        {
        	bipedLeftArm2.render(f5);
        }
        if(GameSettings.modelPart_right_pants_leg)
        {
        	bipedRightLeg2.render(f5);
        }
        if(GameSettings.modelPart_left_pants_leg)
        {
        	bipedLeftLeg2.render(f5);
        }
    }
    
    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5)
    {
    	super.setRotationAngles(f, f1, f2, f3, f4, f5);
        bipedHead.rotateAngleY = f3 / 57.29578F;
        bipedHead.rotateAngleX = f4 / 57.29578F;
        bipedHeadwear.rotateAngleY = bipedHead.rotateAngleY;
        bipedHeadwear.rotateAngleX = bipedHead.rotateAngleX;
        bipedRightArm.rotateAngleX = MathHelper.cos(f * 0.6662F + 3.141593F) * 2.0F * f1 * 0.5F;
        bipedLeftArm.rotateAngleX = MathHelper.cos(f * 0.6662F) * 2.0F * f1 * 0.5F;
        bipedRightArm.rotateAngleZ = 0.0F;
        bipedLeftArm.rotateAngleZ = 0.0F;
        bipedRightLeg.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
        bipedLeftLeg.rotateAngleX = MathHelper.cos(f * 0.6662F + 3.141593F) * 1.4F * f1;
        bipedRightLeg.rotateAngleY = 0.0F;
        bipedLeftLeg.rotateAngleY = 0.0F;
        if(isRiding)
        {
            bipedRightArm.rotateAngleX += -0.6283185F;
            bipedLeftArm.rotateAngleX += -0.6283185F;
            bipedRightLeg.rotateAngleX = -1.256637F;
            bipedLeftLeg.rotateAngleX = -1.256637F;
            bipedRightLeg.rotateAngleY = 0.3141593F;
            bipedLeftLeg.rotateAngleY = -0.3141593F;
        }
        if(field_1279_h)
        {
            bipedLeftArm.rotateAngleX = bipedLeftArm.rotateAngleX * 0.5F - 0.3141593F;
        }
        if(field_1278_i)
        {
            bipedRightArm.rotateAngleX = bipedRightArm.rotateAngleX * 0.5F - 0.3141593F;
        }
        bipedRightArm.rotateAngleY = 0.0F;
        bipedLeftArm.rotateAngleY = 0.0F;
        if(onGround > -9990F)
        {
            float f6 = onGround;
            bipedBody.rotateAngleY = MathHelper.sin(MathHelper.sqrt_float(f6) * 3.141593F * 2.0F) * 0.2F;
            bipedRightArm.rotationPointZ = MathHelper.sin(bipedBody.rotateAngleY) * 5F;
            bipedRightArm.rotationPointX = -MathHelper.cos(bipedBody.rotateAngleY) * 5F;
            bipedLeftArm.rotationPointZ = -MathHelper.sin(bipedBody.rotateAngleY) * 5F;
            bipedLeftArm.rotationPointX = MathHelper.cos(bipedBody.rotateAngleY) * 5F;
            bipedRightArm.rotateAngleY += bipedBody.rotateAngleY;
            bipedLeftArm.rotateAngleY += bipedBody.rotateAngleY;
            bipedLeftArm.rotateAngleX += bipedBody.rotateAngleY;
            f6 = 1.0F - onGround;
            f6 *= f6;
            f6 *= f6;
            f6 = 1.0F - f6;
            float f7 = MathHelper.sin(f6 * 3.141593F);
            float f8 = MathHelper.sin(onGround * 3.141593F) * -(bipedHead.rotateAngleX - 0.7F) * 0.75F;
            bipedRightArm.rotateAngleX -= (double)f7 * 1.2D + (double)f8;
            bipedRightArm.rotateAngleY += bipedBody.rotateAngleY * 2.0F;
            bipedRightArm.rotateAngleZ = MathHelper.sin(onGround * 3.141593F) * -0.4F;
        }
        if(isSneak)
        {
            bipedBody.rotateAngleX = 0.5F;
            bipedRightLeg.rotateAngleX -= 0.0F;
            bipedLeftLeg.rotateAngleX -= 0.0F;
            bipedRightArm.rotateAngleX += 0.4F;
            bipedLeftArm.rotateAngleX += 0.4F;
            bipedRightLeg.rotationPointZ = 4F;
            bipedLeftLeg.rotationPointZ = 4F;
            bipedRightLeg.rotationPointY = 9F;
            bipedLeftLeg.rotationPointY = 9F;
            bipedHead.rotationPointY = 1.0F;
        } else
        {
            bipedBody.rotateAngleX = 0.0F;
            bipedRightLeg.rotationPointZ = 0.0F;
            bipedLeftLeg.rotationPointZ = 0.0F;
            bipedRightLeg.rotationPointY = 12F;
            bipedLeftLeg.rotationPointY = 12F;
            bipedHead.rotationPointY = 0.0F;
        }
        bipedRightArm.rotateAngleZ += MathHelper.cos(f2 * 0.09F) * 0.05F + 0.05F;
        bipedLeftArm.rotateAngleZ -= MathHelper.cos(f2 * 0.09F) * 0.05F + 0.05F;
        bipedRightArm.rotateAngleX += MathHelper.sin(f2 * 0.067F) * 0.05F;
        bipedLeftArm.rotateAngleX -= MathHelper.sin(f2 * 0.067F) * 0.05F;
        bipedRightArm2.rotateAngleX = bipedRightArm.rotateAngleX;
        bipedLeftArm2.rotateAngleX = bipedLeftArm.rotateAngleX;
        bipedRightArm2.rotateAngleY = bipedRightArm.rotateAngleY;
        bipedLeftArm2.rotateAngleY = bipedLeftArm.rotateAngleY;
        bipedRightArm2.rotateAngleZ = bipedRightArm.rotateAngleZ;
        bipedLeftArm2.rotateAngleZ = bipedLeftArm.rotateAngleZ;
        bipedRightLeg2.rotateAngleX = bipedRightLeg.rotateAngleX;
        bipedLeftLeg2.rotateAngleX = bipedLeftLeg.rotateAngleX;
        bipedRightLeg2.rotateAngleY = bipedRightLeg.rotateAngleY;
        bipedLeftLeg2.rotateAngleY = bipedLeftLeg.rotateAngleY;
        bipedRightLeg2.rotateAngleZ = bipedRightLeg.rotateAngleZ;
        bipedLeftLeg2.rotateAngleZ = bipedLeftLeg.rotateAngleZ;
        bipedRightArm2.rotationPointX = bipedRightArm.rotationPointX;
        bipedLeftArm2.rotationPointX = bipedLeftArm.rotationPointX;
        bipedRightArm2.rotationPointY = bipedRightArm.rotationPointY;
        bipedLeftArm2.rotationPointY = bipedLeftArm.rotationPointY;
        bipedRightArm2.rotationPointZ = bipedRightArm.rotationPointZ;
        bipedLeftArm2.rotationPointZ = bipedLeftArm.rotationPointZ;
        bipedRightLeg2.rotationPointX = bipedRightLeg.rotationPointX;
        bipedLeftLeg2.rotationPointX = bipedLeftLeg.rotationPointX;
        bipedRightLeg2.rotationPointY = bipedRightLeg.rotationPointY;
        bipedLeftLeg2.rotationPointY = bipedLeftLeg.rotationPointY;
        bipedRightLeg2.rotationPointZ = bipedRightLeg.rotationPointZ;
        bipedLeftLeg2.rotationPointZ = bipedLeftLeg.rotationPointZ;
        bipedBody2.rotateAngleX = bipedBody.rotateAngleX;
        bipedBody2.rotateAngleY = bipedBody.rotateAngleY;
        bipedBody2.rotateAngleZ = bipedBody.rotateAngleZ;
        bipedLeftLeg_old.rotationPointX = bipedLeftLeg.rotationPointX;
        bipedLeftLeg_old.rotationPointY = bipedLeftLeg.rotationPointY;
        bipedLeftLeg_old.rotationPointZ = bipedLeftLeg.rotationPointZ;
        bipedLeftLeg_old.rotateAngleX = bipedLeftLeg.rotateAngleX;
        bipedLeftLeg_old.rotateAngleY = bipedLeftLeg.rotateAngleY;
        bipedLeftLeg_old.rotateAngleZ = bipedLeftLeg.rotateAngleZ;
        bipedLeftArm_old.rotationPointX = bipedLeftArm.rotationPointX;
        bipedLeftArm_old.rotationPointY = bipedLeftArm.rotationPointY;
        bipedLeftArm_old.rotationPointZ = bipedLeftArm.rotationPointZ;
        bipedLeftArm_old.rotateAngleX = bipedLeftArm.rotateAngleX;
        bipedLeftArm_old.rotateAngleY = bipedLeftArm.rotateAngleY;
        bipedLeftArm_old.rotateAngleZ = bipedLeftArm.rotateAngleZ;
        
    }

    public void renderEars(float f)
    {
        bipedEars.rotateAngleY = bipedHead.rotateAngleY;
        bipedEars.rotateAngleX = bipedHead.rotateAngleX;
        bipedEars.rotationPointX = 0.0F;
        bipedEars.rotationPointY = 0.0F;
        bipedEars.render(f);
    }

    public void renderCloak(float f)
    {
    	if(!isLoaded && RenderEngine.skinResX != RenderEngine.skinResY)
    	{
    		super.renderCloak(f);
    		return;
    	}
    	if(!isLocal)
    	{
        	bipedCloak.render(f);
        	return;
    	}
        if(GameSettings.modelPart_cape)
        {
        	bipedCloak.render(f);
        }
    }

    public ModelRenderer bipedHead;
    public ModelRenderer bipedHeadwear;
    public ModelRenderer bipedBody;
    public ModelRenderer bipedRightArm;
    public ModelRenderer bipedLeftArm;
    public ModelRenderer bipedRightLeg;
    public ModelRenderer bipedLeftLeg;
    public ModelRenderer bipedLeftLeg_old;
    public ModelRenderer bipedLeftArm_old;
    public ModelRenderer bipedRightArm_old;
    public ModelRenderer bipedEars;
    public ModelRenderer bipedCloak;
    public ModelRenderer bipedBody2;
    public ModelRenderer bipedRightArm2;
    public ModelRenderer bipedLeftArm2;
    public ModelRenderer bipedRightLeg2;
    public ModelRenderer bipedLeftLeg2;
    public boolean isLocal = true;
    public boolean isLoaded = false;
    public boolean field_1279_h;
    public boolean field_1278_i;
    public boolean isSneak;
    public EntityPlayer thePlayer;
}