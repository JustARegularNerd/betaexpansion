// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            Block, BlockRail, ModLoader, Tessellator, 
//            IBlockAccess, BlockBed, ModelBed, BlockRedstoneRepeater, 
//            BlockPistonBase, BlockPistonExtension, Vec3D, BlockFire, 
//            BlockRedstoneWire, EntityRenderer, Material, BlockFluid, 
//            MathHelper, World, BlockDoor

public class RenderBlocks
{

    public RenderBlocks(IBlockAccess iblockaccess)
    {
        this();
        mc = ModLoader.getMinecraftInstance();
        blockAccess = iblockaccess;
    }

    public RenderBlocks()
    {
        blockAccess = null;
        overrideBlockTexture = 0;
        flipTexture = false;
        renderAllFaces = false;
        field_31088_b = false;
        eastFaceRotation = 0;
        westFaceRotation = 0;
        southFaceRotation = 0;
        northFaceRotation = 0;
        topFaceRotation = 0;
        bottomFaceRotation = 0;
        enableAO = false;
        aoLightValueXNeg = 0.0F;
        aoLightValueYNeg = 0.0F;
        aoLightValueZNeg = 0.0F;
        aoLightValueXPos = 0.0F;
        aoLightValueYPos = 0.0F;
        aoLightValueZPos = 0.0F;
        field_22377_m = 0.0F;
        field_22376_n = 0.0F;
        field_22375_o = 0.0F;
        field_22374_p = 0.0F;
        field_22373_q = 0.0F;
        field_22372_r = 0.0F;
        field_22371_s = 0.0F;
        field_22370_t = 0.0F;
        field_22369_u = 0.0F;
        field_22368_v = 0.0F;
        field_22367_w = 0.0F;
        field_22366_x = 0.0F;
        field_22365_y = 0.0F;
        field_22364_z = 0.0F;
        field_22362_A = 0.0F;
        field_22360_B = 0.0F;
        field_22358_C = 0.0F;
        field_22356_D = 0.0F;
        field_22354_E = 0.0F;
        field_22353_F = 0.0F;
        colorRedTopLeft = 0.0F;
        colorRedBottomLeft = 0.0F;
        colorRedBottomRight = 0.0F;
        colorRedTopRight = 0.0F;
        colorGreenTopLeft = 0.0F;
        colorGreenBottomLeft = 0.0F;
        colorGreenBottomRight = 0.0F;
        colorGreenTopRight = 0.0F;
        colorBlueTopLeft = 0.0F;
        colorBlueBottomLeft = 0.0F;
        colorBlueBottomRight = 0.0F;
        colorBlueTopRight = 0.0F;
        field_22339_T = false;
        field_22338_U = false;
        field_22337_V = false;
        field_22336_W = false;
        field_22335_X = false;
        field_22334_Y = false;
        field_22333_Z = false;
        field_22363_aa = false;
        field_22361_ab = false;
        field_22359_ac = false;
        field_22357_ad = false;
        field_22355_ae = false;
        overrideBlockTexture = -1;
        flipTexture = false;
        renderAllFaces = false;
        field_31088_b = true;
        eastFaceRotation = 0;
        westFaceRotation = 0;
        southFaceRotation = 0;
        northFaceRotation = 0;
        topFaceRotation = 0;
        bottomFaceRotation = 0;
        field_22352_G = 1;
        mc = ModLoader.getMinecraftInstance();
    }

    public void renderBlockUsingTexture(Block block, int i, int j, int k, int l)
    {
        overrideBlockTexture = l;
        renderBlockByRenderType(block, i, j, k);
        overrideBlockTexture = -1;
    }

    public void renderBlockWithAllFaces(Block block, int i, int j, int k)
    {
        renderAllFaces = true;
        renderBlockByRenderType(block, i, j, k);
        renderAllFaces = false;
    }

    public boolean renderBlockByRenderType(Block block, int i, int j, int k)
    {
        int l = block.getRenderType();
        block.setBlockBoundsBasedOnState(blockAccess, i, j, k);
        switch(l)
        {
        case 0: return renderStandardBlock(block, i, j, k);
        
        case 4: return renderBlockFluids(block, i, j, k);
        
        case 13: return renderBlockCactus(block, i, j, k);
        
        case 1: return renderBlockReed(block, i, j, k);
        
        case 6: return renderBlockCrops(block, i, j, k);
        
        case 2: return renderBlockTorch(block, i, j, k);
        
        case 3: return renderBlockFire(block, i, j, k);
        
        case 5: return renderBlockRedstoneWire(block, i, j, k);
        
        case 8: return renderBlockLadder(block, i, j, k);
        
        case 7: return renderBlockDoor(block, i, j, k);
        
        case 9: return renderBlockMinecartTrack((BlockRail)block, i, j, k);
        
        case 10: return renderBlockStairs(block, i, j, k);
        
        case 11: return renderBlockFence((BlockFence)block, i, j, k);
        
        case 12: return renderBlockLever(block, i, j, k);
        
        case 14: return renderBlockBed(block, i, j, k);
        
        case 15: return renderBlockRepeater(block, i, j, k);
        
        case 16: return renderBlockPistonBase(block, i, j, k, false);
        
        case 17: return renderBlockPistonExtension(block, i, j, k, true, false);
        
        case 18: return renderBlockPistonExtension(block, i, j, k, true, true);
        
        case 19: return renderBlockTable(block, i, j, k);

        default: return ModLoader.RenderWorldBlock(this, blockAccess, i, j, k, block, l);
        }
    }
    
    public boolean renderBlockTable(Block block, int i, int j, int k)
    {
    	int l = blockAccess.getBlockMetadata(i, j, k);
    	boolean f = blockAccess.getBlockId(i+1, j, k) == BEBlocks.table.blockID && (blockAccess.getBlockMetadata(i+1, j, k) / 8 == l / 8);
    	boolean f1 = blockAccess.getBlockId(i-1, j, k) == BEBlocks.table.blockID && (blockAccess.getBlockMetadata(i-1, j, k) / 8 == l / 8);
    	boolean f2 = blockAccess.getBlockId(i, j, k+1) == BEBlocks.table.blockID && (blockAccess.getBlockMetadata(i, j, k+1) / 8 == l / 8);
    	boolean f3 = blockAccess.getBlockId(i, j, k-1) == BEBlocks.table.blockID && (blockAccess.getBlockMetadata(i, j, k-1) / 8 == l / 8);
    	if(l > 7)
    	{
    		if(!(f1 || f3))
    		{
    			block.setBlockBounds(0.0625F, 0F, 0.0625F, 0.1875F, 0.625F, 0.1875F);
    			renderStandardBlock(block, i, j, k);
    		}
    		if(!(f || f3))
    		{
    			block.setBlockBounds(0.8125F, 0F, 0.0625F, 0.9375F, 0.625F, 0.1875F);
    			renderStandardBlock(block, i, j, k);
    		}
    		if(!(f1 || f2))
    		{
    			block.setBlockBounds(0.0625F, 0F, 0.8125F, 0.1875F, 0.625F, 0.9375F);
    			renderStandardBlock(block, i, j, k);
    		}
    		if(!(f || f2))
    		{
    			block.setBlockBounds(0.8125F, 0F, 0.8125F, 0.9375F, 0.625F, 0.9375F);
    			renderStandardBlock(block, i, j, k);
    		}
    		block.setBlockBounds(0F, 0.625F, 0F, 1F, 0.75F, 1F);
    		renderStandardBlock(block, i, j, k);
    	}else
    	{
    		if(!(f1 || f3))
    		{
    			block.setBlockBounds(0F, 0F, 0F, 0.125F, 0.875F, 0.125F);
    			renderStandardBlock(block, i, j, k);
    		}
    		if(!(f || f3))
    		{
    			block.setBlockBounds(0.875F, 0F, 0F, 1F, 0.875F, 0.125F);
    			renderStandardBlock(block, i, j, k);
    		}
    		if(!(f1 || f2))
    		{
    			block.setBlockBounds(0F, 0F, 0.875F, 0.125F, 0.875F, 1F);
    			renderStandardBlock(block, i, j, k);
    		}
    		if(!(f || f2))
    		{
    			block.setBlockBounds(0.875F, 0F, 0.875F, 1F, 0.875F, 1F);
    			renderStandardBlock(block, i, j, k);
    		}
    		block.setBlockBounds(0F, 0.875F, 0F, 1F, 1F, 1F);
    		renderStandardBlock(block, i, j, k);
    	}
    	block.setBlockBounds(0F, 0F, 0F, 1F, 1F, 1F);
        return true;
    }
    
    public boolean renderBlockBed(Block block, int i, int j, int k)
    {
        Tessellator tessellator = Tessellator.instance;
        int l = blockAccess.getBlockMetadata(i, j, k);
        int i1 = BlockBed.getDirectionFromMetadata(l);
        boolean flag = BlockBed.isBlockFootOfBed(l);
        float f4 = topFaceBrightness;
        float f5 = topFaceBrightness;
        float f6 = topFaceBrightness;
        float f7 = bottomFaceBrightness;
        float f8 = eastWestFaceBrightness;
        float f9 = northSouthFaceBrightness;
        float f10 = bottomFaceBrightness;
        float f11 = eastWestFaceBrightness;
        float f12 = northSouthFaceBrightness;
        float f13 = bottomFaceBrightness;
        float f14 = eastWestFaceBrightness;
        float f15 = northSouthFaceBrightness;
        int n0 = block.getRenderBrightness(blockAccess, i, j, k);
        int n1 = block.getRenderBrightness(blockAccess, i, j + 1, k);
        tessellator.setBrightness(n0);
        tessellator.setColorOpaque_F(f7, f10, f13);
        int j1 = block.getBlockTexture(blockAccess, i, j, k, 0);
        int k1 = (j1 & 0xf) << 4;
        int l1 = j1 & 0xf0;
        double d = (float)k1 / 256F;
        double d1 = ((double)(k1 + 16)) / 256D;
        double d2 = (float)l1 / 256F;
        double d3 = ((double)(l1 + 16)) / 256D;
        double d4 = (double)i + block.minX;
        double d5 = (double)i + block.maxX;
        double d6 = (double)j + block.minY + 0.1875D;
        double d7 = (double)k + block.minZ;
        double d8 = (double)k + block.maxZ;
        tessellator.addVertexWithUV(d4, d6, d8, d, d3);
        tessellator.addVertexWithUV(d4, d6, d7, d, d2);
        tessellator.addVertexWithUV(d5, d6, d7, d1, d2);
        tessellator.addVertexWithUV(d5, d6, d8, d1, d3);
        tessellator.setBrightness(n1);
        tessellator.setColorOpaque_F(f4, f5, f6);
        k1 = block.getBlockTexture(blockAccess, i, j, k, 1);
        l1 = (k1 & 0xf) << 4;
        d = k1 & 0xf0;
        double d9 = (float)l1 / 256F;
        double d10 = ((double)(l1 + 16)) / 256D;
        double d11 = (float)d / 256F;
        double d12 = ((d + 16D)) / 256D;
        double d13 = d9;
        double d14 = d10;
        double d15 = d11;
        double d16 = d11;
        double d17 = d9;
        double d18 = d10;
        double d19 = d12;
        double d20 = d12;
        if(i1 == 0)
        {
            d14 = d9;
            d15 = d12;
            d17 = d10;
            d20 = d11;
        } else
        if(i1 == 2)
        {
            d13 = d10;
            d16 = d12;
            d18 = d9;
            d19 = d11;
        } else
        if(i1 == 3)
        {
            d13 = d10;
            d16 = d12;
            d18 = d9;
            d19 = d11;
            d14 = d9;
            d15 = d12;
            d17 = d10;
            d20 = d11;
        }
        double d21 = (double)i + block.minX;
        double d22 = (double)i + block.maxX;
        double d23 = (double)j + block.maxY;
        double d24 = (double)k + block.minZ;
        double d25 = (double)k + block.maxZ;
        tessellator.addVertexWithUV(d22, d23, d25, d17, d19);
        tessellator.addVertexWithUV(d22, d23, d24, d13, d15);
        tessellator.addVertexWithUV(d21, d23, d24, d14, d16);
        tessellator.addVertexWithUV(d21, d23, d25, d18, d20);
        float f17 = ModelBed.field_22280_a[i1];
        if(flag)
        {
            f17 = ModelBed.field_22280_a[ModelBed.field_22279_b[i1]];
        }
        k1 = 4;
        switch(i1)
        {
        case 0: // '\0'
            k1 = 5;
            break;

        case 3: // '\003'
            k1 = 2;
            break;

        case 1: // '\001'
            k1 = 3;
            break;
        }
        if(f17 != 2.0F && (renderAllFaces || block.shouldSideBeRendered(blockAccess, i, j, k - 1, 2)))
        {
            tessellator.setBrightness(block.minZ <= 0.0D ? block.getRenderBrightness(blockAccess, i, j, k - 1) : n0);
            tessellator.setColorOpaque_F(f8, f11, f14);
            flipTexture = k1 == 2;
            renderEastFace(block, i, j, k, block.getBlockTexture(blockAccess, i, j, k, 2));
        }
        if(f17 != 3F && (renderAllFaces || block.shouldSideBeRendered(blockAccess, i, j, k + 1, 3)))
        {
            tessellator.setBrightness(block.maxZ >= 1.0D ? block.getRenderBrightness(blockAccess, i, j, k + 1) : n0);
            tessellator.setColorOpaque_F(f8, f11, f14);
            flipTexture = k1 == 3;
            renderWestFace(block, i, j, k, block.getBlockTexture(blockAccess, i, j, k, 3));
        }
        if(f17 != 4F && (renderAllFaces || block.shouldSideBeRendered(blockAccess, i - 1, j, k, 4)))
        {
            tessellator.setBrightness(block.minZ <= 0.0D ? block.getRenderBrightness(blockAccess, i - 1, j, k) : n0);
            tessellator.setColorOpaque_F(f9, f12, f15);
            flipTexture = k1 == 4;
            renderNorthFace(block, i, j, k, block.getBlockTexture(blockAccess, i, j, k, 4));
        }
        if(f17 != 5F && (renderAllFaces || block.shouldSideBeRendered(blockAccess, i + 1, j, k, 5)))
        {
            tessellator.setBrightness(block.maxZ >= 1.0D ? block.getRenderBrightness(blockAccess, i + 1, j, k) : n0);
            tessellator.setColorOpaque_F(f9, f12, f15);
            flipTexture = k1 == 5;
            renderSouthFace(block, i, j, k, block.getBlockTexture(blockAccess, i, j, k, 5));
        }
        flipTexture = false;
        return true;
    }

    public boolean renderBlockTorch(Block block, int i, int j, int k)
    {
        int l = blockAccess.getBlockMetadata(i, j, k);
        Tessellator tessellator = Tessellator.instance;
        tessellator.setBrightness(Block.lightValue[block.blockID] == 0 ? block.getRenderBrightness(blockAccess, i, j, k) : (15 << 20 | 15 << 4));
        tessellator.setColorOpaque_F(1, 1, 1);
        double d = 0.40000000596046448D;
        double d1 = 0.5D - d;
        double d2 = 0.20000000298023224D;
        if(l == 1)
        {
            renderTorchAtAngle(block, (double)i - d1, (double)j + d2, k, -d, 0.0D, false);
        } else
        if(l == 2)
        {
            renderTorchAtAngle(block, (double)i + d1, (double)j + d2, k, d, 0.0D, false);
        } else
        if(l == 3)
        {
            renderTorchAtAngle(block, i, (double)j + d2, (double)k - d1, 0.0D, -d, false);
        } else
        if(l == 4)
        {
            renderTorchAtAngle(block, i, (double)j + d2, (double)k + d1, 0.0D, d, false);
        } else
        {
            renderTorchAtAngle(block, i, j, k, 0.0D, 0.0D, false);
        }
        return true;
    }

    public boolean renderBlockRepeater(Block block, int i, int j, int k)
    {
        int l = blockAccess.getBlockMetadata(i, j, k);
        int i1 = l & 3;
        int j1 = (l & 0xc) >> 2;
        renderStandardBlock(block, i, j, k);
        Tessellator tessellator = Tessellator.instance;
        tessellator.setBrightness((15 << 20 | 15 << 4));
        float f = block.getBlockBrightness(blockAccess, i, j, k);
        if(Block.lightValue[block.blockID] > 0)
        {
            f = (f + 1.0F) * 0.5F;
        }
        tessellator.setColorOpaque_F(f, f, f);
        double d = -0.1875D;
        double d1 = 0.0D;
        double d2 = 0.0D;
        double d3 = 0.0D;
        double d4 = 0.0D;
        switch(i1)
        {
        case 0: // '\0'
            d4 = -0.3125D;
            d2 = BlockRedstoneRepeater.field_22024_a[j1];
            break;

        case 2: // '\002'
            d4 = 0.3125D;
            d2 = -BlockRedstoneRepeater.field_22024_a[j1];
            break;

        case 3: // '\003'
            d3 = -0.3125D;
            d1 = BlockRedstoneRepeater.field_22024_a[j1];
            break;

        case 1: // '\001'
            d3 = 0.3125D;
            d1 = -BlockRedstoneRepeater.field_22024_a[j1];
            break;
        }
        renderTorchAtAngle(block, (double)i + d1, (double)j + d, (double)k + d2, 0.0D, 0.0D, false);
        renderTorchAtAngle(block, (double)i + d3, (double)j + d, (double)k + d4, 0.0D, 0.0D, false);
        int k1 = block.getBlockTextureFromSide(1);
        int l1 = (k1 & 0xf) << 4;
        int i2 = k1 & 0xf0;
        double d5 = (float)l1 / 256F;
        double d6 = ((float)l1 + 15.999F) / 256F;
        double d7 = (float)i2 / 256F;
        double d8 = ((float)i2 + 15.999F) / 256F;
        float f1 = 0.125F;
        float f2 = i + 1;
        float f3 = i + 1;
        float f4 = i + 0;
        float f5 = i + 0;
        float f6 = k + 0;
        float f7 = k + 1;
        float f8 = k + 1;
        float f9 = k + 0;
        float f10 = (float)j + f1;
        if(i1 == 2)
        {
            f2 = f3 = i + 0;
            f4 = f5 = i + 1;
            f6 = f9 = k + 1;
            f7 = f8 = k + 0;
        } else
        if(i1 == 3)
        {
            f2 = f5 = i + 0;
            f3 = f4 = i + 1;
            f6 = f7 = k + 0;
            f8 = f9 = k + 1;
        } else
        if(i1 == 1)
        {
            f2 = f5 = i + 1;
            f3 = f4 = i + 0;
            f6 = f7 = k + 1;
            f8 = f9 = k + 0;
        }
        tessellator.addVertexWithUV(f5, f10, f9, d5, d7);
        tessellator.addVertexWithUV(f4, f10, f8, d5, d8);
        tessellator.addVertexWithUV(f3, f10, f7, d6, d8);
        tessellator.addVertexWithUV(f2, f10, f6, d6, d7);
        return true;
    }

    public void func_31078_d(Block block, int i, int j, int k)
    {
        renderAllFaces = true;
        renderBlockPistonBase(block, i, j, k, true);
        renderAllFaces = false;
    }

    public boolean renderBlockPistonBase(Block block, int i, int j, int k, boolean flag)
    {
        int l = blockAccess.getBlockMetadata(i, j, k);
        boolean flag1 = flag || (l & 8) != 0;
        int i1 = BlockPistonBase.func_31044_d(l);
        if(flag1)
        {
            switch(i1)
            {
            case 0: // '\0'
                eastFaceRotation = 3;
                westFaceRotation = 3;
                southFaceRotation = 3;
                northFaceRotation = 3;
                block.setBlockBounds(0.0F, 0.25F, 0.0F, 1.0F, 1.0F, 1.0F);
                break;

            case 1: // '\001'
                block.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.75F, 1.0F);
                break;

            case 2: // '\002'
                southFaceRotation = 1;
                northFaceRotation = 2;
                block.setBlockBounds(0.0F, 0.0F, 0.25F, 1.0F, 1.0F, 1.0F);
                break;

            case 3: // '\003'
                southFaceRotation = 2;
                northFaceRotation = 1;
                topFaceRotation = 3;
                bottomFaceRotation = 3;
                block.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.75F);
                break;

            case 4: // '\004'
                eastFaceRotation = 1;
                westFaceRotation = 2;
                topFaceRotation = 2;
                bottomFaceRotation = 1;
                block.setBlockBounds(0.25F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
                break;

            case 5: // '\005'
                eastFaceRotation = 2;
                westFaceRotation = 1;
                topFaceRotation = 1;
                bottomFaceRotation = 2;
                block.setBlockBounds(0.0F, 0.0F, 0.0F, 0.75F, 1.0F, 1.0F);
                break;
            }
            renderStandardBlock(block, i, j, k);
            eastFaceRotation = 0;
            westFaceRotation = 0;
            southFaceRotation = 0;
            northFaceRotation = 0;
            topFaceRotation = 0;
            bottomFaceRotation = 0;
            block.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
        } else
        {
            switch(i1)
            {
            case 0: // '\0'
                eastFaceRotation = 3;
                westFaceRotation = 3;
                southFaceRotation = 3;
                northFaceRotation = 3;
                break;

            case 2: // '\002'
                southFaceRotation = 1;
                northFaceRotation = 2;
                break;

            case 3: // '\003'
                southFaceRotation = 2;
                northFaceRotation = 1;
                topFaceRotation = 3;
                bottomFaceRotation = 3;
                break;

            case 4: // '\004'
                eastFaceRotation = 1;
                westFaceRotation = 2;
                topFaceRotation = 2;
                bottomFaceRotation = 1;
                break;

            case 5: // '\005'
                eastFaceRotation = 2;
                westFaceRotation = 1;
                topFaceRotation = 1;
                bottomFaceRotation = 2;
                break;
            }
            renderStandardBlock(block, i, j, k);
            eastFaceRotation = 0;
            westFaceRotation = 0;
            southFaceRotation = 0;
            northFaceRotation = 0;
            topFaceRotation = 0;
            bottomFaceRotation = 0;
        }
        return true;
    }
    
    public void setTextureOrientation(boolean flag, int i)
    {
    	if(flag && i > 2)
    	{
        	i /= 3;
        	flipEastTexture = i == 2;
        	flipBottomTexture = i >= 1;
        	flipSouthTexture = i == 1;
    		switch(i)
    		{
    		case 0: // '\0'
    			eastFaceRotation = 3;
    			westFaceRotation = 3;
    			southFaceRotation = 3;
    			northFaceRotation = 3;
    			break;

    		case 1: // '\003'
    			southFaceRotation = 1;
    			northFaceRotation = 1;
    			topFaceRotation = 3;
    			bottomFaceRotation = 3;
    			break;

    		case 2: // '\005'
    			eastFaceRotation = 1;
    			westFaceRotation = 1;
    			topFaceRotation = 1;
    			bottomFaceRotation = 1;
    			break;
    		}
    	}else
    	{
    		flipEastTexture = false;
    		flipBottomTexture = false;
    		flipSouthTexture = false;
    		eastFaceRotation = 0;
    		westFaceRotation = 0;
    		southFaceRotation = 0;
    		northFaceRotation = 0;
    		topFaceRotation = 0;
    		bottomFaceRotation = 0;
    	}
    }

    public void func_31076_a(double d, double d1, double d2, double d3, double d4, double d5, float f, double d6, int i1)
    {
        int i = 108;
        if(overrideBlockTexture >= 0)
        {
            i = overrideBlockTexture;
        }
        int j = (i & 0xf) << 4;
        int k = i & 0xf0;
        Tessellator tessellator = Tessellator.instance;
        double d7 = (float)(j + 0) / 256F;
        double d8 = (float)(k + 0) / 256F;
        double d9 = (((double)j + d6)) / 256D;
        double d10 = ((double)((float)k + 4F)) / 256D;
        tessellator.setBrightness(i1);
        tessellator.setColorOpaque_F(f, f, f);
        tessellator.addVertexWithUV(d, d3, d4, d9, d8);
        tessellator.addVertexWithUV(d, d2, d4, d7, d8);
        tessellator.addVertexWithUV(d1, d2, d5, d7, d10);
        tessellator.addVertexWithUV(d1, d3, d5, d9, d10);
    }

    public void func_31081_b(double d, double d1, double d2, double d3, double d4, double d5, float f, double d6, int i1)
    {
        int i = 108;
        if(overrideBlockTexture >= 0)
        {
            i = overrideBlockTexture;
        }
        int j = (i & 0xf) << 4;
        int k = i & 0xf0;
        Tessellator tessellator = Tessellator.instance;
        double d7 = (float)(j + 0) / 256F;
        double d8 = (float)(k + 0) / 256F;
        double d9 = (((double)j + d6) - 0.01D) / 256D;
        double d10 = ((double)((float)k + 4F) - 0.01D) / 256D;
        tessellator.setBrightness(i1);
        tessellator.setColorOpaque_F(f, f, f);
        tessellator.addVertexWithUV(d, d2, d5, d9, d8);
        tessellator.addVertexWithUV(d, d2, d4, d7, d8);
        tessellator.addVertexWithUV(d1, d3, d4, d7, d10);
        tessellator.addVertexWithUV(d1, d3, d5, d9, d10);
    }

    public void func_31077_c(double d, double d1, double d2, double d3, double d4, double d5, float f, double d6, int i1)
    {
        int i = 108;
        if(overrideBlockTexture >= 0)
        {
            i = overrideBlockTexture;
        }
        int j = (i & 0xf) << 4;
        int k = i & 0xf0;
        Tessellator tessellator = Tessellator.instance;
        double d7 = (float)(j + 0) / 256F;
        double d8 = (float)(k + 0) / 256F;
        double d9 = (((double)j + d6) - 0.01D) / 256D;
        double d10 = ((double)((float)k + 4F) - 0.01D) / 256D;
        tessellator.setBrightness(i1);
        tessellator.setColorOpaque_F(f, f, f);
        tessellator.addVertexWithUV(d1, d2, d4, d9, d8);
        tessellator.addVertexWithUV(d, d2, d4, d7, d8);
        tessellator.addVertexWithUV(d, d3, d5, d7, d10);
        tessellator.addVertexWithUV(d1, d3, d5, d9, d10);
    }

    public void func_31079_a(Block block, int i, int j, int k, boolean flag, boolean launcher)
    {
        renderAllFaces = true;
        renderBlockPistonExtension(block, i, j, k, flag, launcher);
        renderAllFaces = false;
    }

    public boolean renderBlockPistonExtension(Block block, int i, int j, int k, boolean flag, boolean launcher)
    {
        Tessellator tessellator = Tessellator.instance;
        int l = blockAccess.getBlockMetadata(i, j, k);
        int i1 = BlockPistonExtension.func_31050_c(l);
        int n0 = block.getRenderBrightness(blockAccess, i, j, k);
        float f1 = flag ? 1.0F : 0.5F;
        double d = flag ? 16D : 8D;
        switch(i1)
        {
        case 0: // '\0'
            eastFaceRotation = 3;
            westFaceRotation = 3;
            southFaceRotation = 3;
            northFaceRotation = 3;
            block.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.25F, 1.0F);
            renderStandardBlock(block, i, j, k);
            if(launcher)
            {
            	overrideBlockTexture = BEBlocks.launcherExtension.blockIndexInTexture + 1;
            	func_31076_a((float)i + 0.5625F, (float)i + 0.8125F, (float)j + 0.25F, (float)j + 0.25F + f1, (float)k + 0.8125F, (float)k + 0.8125F, 0.8F, d, n0);
            	func_31076_a((float)i + 0.8125F, (float)i + 0.5625F, (float)j + 0.25F, (float)j + 0.25F + f1, (float)k + 0.5625F, (float)k + 0.5625F, 0.8F, d, n0);
            	func_31076_a((float)i + 0.5625F, (float)i + 0.5625F, (float)j + 0.25F, (float)j + 0.25F + f1, (float)k + 0.5625F, (float)k + 0.8125F, 0.6F, d, n0);
            	func_31076_a((float)i + 0.8125F, (float)i + 0.8125F, (float)j + 0.25F, (float)j + 0.25F + f1, (float)k + 0.8125F, (float)k + 0.5625F, 0.6F, d, n0);

            	func_31076_a((float)i + 0.1875F, (float)i + 0.4375F, (float)j + 0.25F, (float)j + 0.25F + f1, (float)k + 0.8125F, (float)k + 0.8125F, 0.8F, d, n0);
            	func_31076_a((float)i + 0.4375F, (float)i + 0.1875F, (float)j + 0.25F, (float)j + 0.25F + f1, (float)k + 0.5625F, (float)k + 0.5625F, 0.8F, d, n0);
            	func_31076_a((float)i + 0.1875F, (float)i + 0.1875F, (float)j + 0.25F, (float)j + 0.25F + f1, (float)k + 0.5625F, (float)k + 0.8125F, 0.6F, d, n0);
            	func_31076_a((float)i + 0.4375F, (float)i + 0.4375F, (float)j + 0.25F, (float)j + 0.25F + f1, (float)k + 0.8125F, (float)k + 0.5625F, 0.6F, d, n0);

            	func_31076_a((float)i + 0.1875F, (float)i + 0.4375F, (float)j + 0.25F, (float)j + 0.25F + f1, (float)k + 0.4375F, (float)k + 0.4375F, 0.8F, d, n0);
            	func_31076_a((float)i + 0.4375F, (float)i + 0.1875F, (float)j + 0.25F, (float)j + 0.25F + f1, (float)k + 0.1875F, (float)k + 0.1875F, 0.8F, d, n0);
            	func_31076_a((float)i + 0.1875F, (float)i + 0.1875F, (float)j + 0.25F, (float)j + 0.25F + f1, (float)k + 0.1875F, (float)k + 0.4375F, 0.6F, d, n0);
            	func_31076_a((float)i + 0.4375F, (float)i + 0.4375F, (float)j + 0.25F, (float)j + 0.25F + f1, (float)k + 0.4375F, (float)k + 0.1875F, 0.6F, d, n0);

            	func_31076_a((float)i + 0.5625F, (float)i + 0.8125F, (float)j + 0.25F, (float)j + 0.25F + f1, (float)k + 0.4375F, (float)k + 0.4375F, 0.8F, d, n0);
            	func_31076_a((float)i + 0.8125F, (float)i + 0.5625F, (float)j + 0.25F, (float)j + 0.25F + f1, (float)k + 0.1875F, (float)k + 0.1875F, 0.8F, d, n0);
            	func_31076_a((float)i + 0.5625F, (float)i + 0.5625F, (float)j + 0.25F, (float)j + 0.25F + f1, (float)k + 0.1875F, (float)k + 0.4375F, 0.6F, d, n0);
            	func_31076_a((float)i + 0.8125F, (float)i + 0.8125F, (float)j + 0.25F, (float)j + 0.25F + f1, (float)k + 0.4375F, (float)k + 0.1875F, 0.6F, d, n0);
            	overrideBlockTexture = -1;
            }else
            {
                func_31076_a((float)i + 0.375F, (float)i + 0.625F, (float)j + 0.25F, (float)j + 0.25F + f1, (float)k + 0.625F, (float)k + 0.625F, 0.8F, d, n0);
                func_31076_a((float)i + 0.625F, (float)i + 0.375F, (float)j + 0.25F, (float)j + 0.25F + f1, (float)k + 0.375F, (float)k + 0.375F, 0.8F, d, n0);
                func_31076_a((float)i + 0.375F, (float)i + 0.375F, (float)j + 0.25F, (float)j + 0.25F + f1, (float)k + 0.375F, (float)k + 0.625F, 0.6F, d, n0);
                func_31076_a((float)i + 0.625F, (float)i + 0.625F, (float)j + 0.25F, (float)j + 0.25F + f1, (float)k + 0.625F, (float)k + 0.375F, 0.6F, d, n0);
            }
            break;

        case 1: // '\001'
            block.setBlockBounds(0.0F, 0.75F, 0.0F, 1.0F, 1.0F, 1.0F);
            renderStandardBlock(block, i, j, k);
            if(launcher)
            {
            	overrideBlockTexture = BEBlocks.launcherExtension.blockIndexInTexture + 1;
            	func_31076_a((float)i + 0.5625F, (float)i + 0.8125F, (((float)j - 0.25F) + 1.0F) - f1, ((float)j - 0.25F) + 1.0F, (float)k + 0.8125F, (float)k + 0.8125F, 0.8F, d, n0);
            	func_31076_a((float)i + 0.8125F, (float)i + 0.5625F, (((float)j - 0.25F) + 1.0F) - f1, ((float)j - 0.25F) + 1.0F, (float)k + 0.5625F, (float)k + 0.5625F, 0.8F, d, n0);
            	func_31076_a((float)i + 0.5625F, (float)i + 0.5625F, (((float)j - 0.25F) + 1.0F) - f1, ((float)j - 0.25F) + 1.0F, (float)k + 0.5625F, (float)k + 0.8125F, 0.6F, d, n0);
            	func_31076_a((float)i + 0.8125F, (float)i + 0.8125F, (((float)j - 0.25F) + 1.0F) - f1, ((float)j - 0.25F) + 1.0F, (float)k + 0.8125F, (float)k + 0.5625F, 0.6F, d, n0);

            	func_31076_a((float)i + 0.1875F, (float)i + 0.4375F, (((float)j - 0.25F) + 1.0F) - f1, ((float)j - 0.25F) + 1.0F, (float)k + 0.8125F, (float)k + 0.8125F, 0.8F, d, n0);
            	func_31076_a((float)i + 0.4375F, (float)i + 0.1875F, (((float)j - 0.25F) + 1.0F) - f1, ((float)j - 0.25F) + 1.0F, (float)k + 0.5625F, (float)k + 0.5625F, 0.8F, d, n0);
            	func_31076_a((float)i + 0.1875F, (float)i + 0.1875F, (((float)j - 0.25F) + 1.0F) - f1, ((float)j - 0.25F) + 1.0F, (float)k + 0.5625F, (float)k + 0.8125F, 0.6F, d, n0);
            	func_31076_a((float)i + 0.4375F, (float)i + 0.4375F, (((float)j - 0.25F) + 1.0F) - f1, ((float)j - 0.25F) + 1.0F, (float)k + 0.8125F, (float)k + 0.5625F, 0.6F, d, n0);

            	func_31076_a((float)i + 0.1875F, (float)i + 0.4375F, (((float)j - 0.25F) + 1.0F) - f1, ((float)j - 0.25F) + 1.0F, (float)k + 0.4375F, (float)k + 0.4375F, 0.8F, d, n0);
            	func_31076_a((float)i + 0.4375F, (float)i + 0.1875F, (((float)j - 0.25F) + 1.0F) - f1, ((float)j - 0.25F) + 1.0F, (float)k + 0.1875F, (float)k + 0.1875F, 0.8F, d, n0);
            	func_31076_a((float)i + 0.1875F, (float)i + 0.1875F, (((float)j - 0.25F) + 1.0F) - f1, ((float)j - 0.25F) + 1.0F, (float)k + 0.1875F, (float)k + 0.4375F, 0.6F, d, n0);
            	func_31076_a((float)i + 0.4375F, (float)i + 0.4375F, (((float)j - 0.25F) + 1.0F) - f1, ((float)j - 0.25F) + 1.0F, (float)k + 0.4375F, (float)k + 0.1875F, 0.6F, d, n0);

            	func_31076_a((float)i + 0.5625F, (float)i + 0.8125F, (((float)j - 0.25F) + 1.0F) - f1, ((float)j - 0.25F) + 1.0F, (float)k + 0.4375F, (float)k + 0.4375F, 0.8F, d, n0);
            	func_31076_a((float)i + 0.8125F, (float)i + 0.5625F, (((float)j - 0.25F) + 1.0F) - f1, ((float)j - 0.25F) + 1.0F, (float)k + 0.1875F, (float)k + 0.1875F, 0.8F, d, n0);
            	func_31076_a((float)i + 0.5625F, (float)i + 0.5625F, (((float)j - 0.25F) + 1.0F) - f1, ((float)j - 0.25F) + 1.0F, (float)k + 0.1875F, (float)k + 0.4375F, 0.6F, d, n0);
            	func_31076_a((float)i + 0.8125F, (float)i + 0.8125F, (((float)j - 0.25F) + 1.0F) - f1, ((float)j - 0.25F) + 1.0F, (float)k + 0.4375F, (float)k + 0.1875F, 0.6F, d, n0);
            	overrideBlockTexture = -1;
            }else
            {
                func_31076_a((float)i + 0.375F, (float)i + 0.625F, (((float)j - 0.25F) + 1.0F) - f1, ((float)j - 0.25F) + 1.0F, (float)k + 0.625F, (float)k + 0.625F, 0.8F, d, n0);
                func_31076_a((float)i + 0.625F, (float)i + 0.375F, (((float)j - 0.25F) + 1.0F) - f1, ((float)j - 0.25F) + 1.0F, (float)k + 0.375F, (float)k + 0.375F, 0.8F, d, n0);
                func_31076_a((float)i + 0.375F, (float)i + 0.375F, (((float)j - 0.25F) + 1.0F) - f1, ((float)j - 0.25F) + 1.0F, (float)k + 0.375F, (float)k + 0.625F, 0.6F, d, n0);
                func_31076_a((float)i + 0.625F, (float)i + 0.625F, (((float)j - 0.25F) + 1.0F) - f1, ((float)j - 0.25F) + 1.0F, (float)k + 0.625F, (float)k + 0.375F, 0.6F, d, n0);
            }
            break;

        case 2: // '\002'
            southFaceRotation = 1;
            northFaceRotation = 2;
            block.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.25F);
            renderStandardBlock(block, i, j, k);
            if(launcher)
            {
            	overrideBlockTexture = BEBlocks.launcherExtension.blockIndexInTexture + 1;
            	tessellator.setTranslationF(0.1875f, 0.1875f, 0f);
            	func_31081_b((float)i + 0.375F, (float)i + 0.375F, (float)j + 0.625F, (float)j + 0.375F, (float)k + 0.25F, (float)k + 0.25F + f1, 0.6F, d, n0);
            	func_31081_b((float)i + 0.625F, (float)i + 0.625F, (float)j + 0.375F, (float)j + 0.625F, (float)k + 0.25F, (float)k + 0.25F + f1, 0.6F, d, n0);
            	func_31081_b((float)i + 0.375F, (float)i + 0.625F, (float)j + 0.375F, (float)j + 0.375F, (float)k + 0.25F, (float)k + 0.25F + f1, 0.5F, d, n0);
            	func_31081_b((float)i + 0.625F, (float)i + 0.375F, (float)j + 0.625F, (float)j + 0.625F, (float)k + 0.25F, (float)k + 0.25F + f1, 1.0F, d, n0);
            	tessellator.setTranslationF(-0.1875f, -0.1875f, 0f);
            	tessellator.setTranslationF(0.1875f, -0.1875f, 0f);
            	func_31081_b((float)i + 0.375F, (float)i + 0.375F, (float)j + 0.625F, (float)j + 0.375F, (float)k + 0.25F, (float)k + 0.25F + f1, 0.6F, d, n0);
            	func_31081_b((float)i + 0.625F, (float)i + 0.625F, (float)j + 0.375F, (float)j + 0.625F, (float)k + 0.25F, (float)k + 0.25F + f1, 0.6F, d, n0);
            	func_31081_b((float)i + 0.375F, (float)i + 0.625F, (float)j + 0.375F, (float)j + 0.375F, (float)k + 0.25F, (float)k + 0.25F + f1, 0.5F, d, n0);
            	func_31081_b((float)i + 0.625F, (float)i + 0.375F, (float)j + 0.625F, (float)j + 0.625F, (float)k + 0.25F, (float)k + 0.25F + f1, 1.0F, d, n0);
            	tessellator.setTranslationF(-0.1875f, 0.1875f, 0f);
            	tessellator.setTranslationF(-0.1875f, 0.1875f, 0f);
            	func_31081_b((float)i + 0.375F, (float)i + 0.375F, (float)j + 0.625F, (float)j + 0.375F, (float)k + 0.25F, (float)k + 0.25F + f1, 0.6F, d, n0);
            	func_31081_b((float)i + 0.625F, (float)i + 0.625F, (float)j + 0.375F, (float)j + 0.625F, (float)k + 0.25F, (float)k + 0.25F + f1, 0.6F, d, n0);
            	func_31081_b((float)i + 0.375F, (float)i + 0.625F, (float)j + 0.375F, (float)j + 0.375F, (float)k + 0.25F, (float)k + 0.25F + f1, 0.5F, d, n0);
            	func_31081_b((float)i + 0.625F, (float)i + 0.375F, (float)j + 0.625F, (float)j + 0.625F, (float)k + 0.25F, (float)k + 0.25F + f1, 1.0F, d, n0);
            	tessellator.setTranslationF(0.1875f, -0.1875f, 0f);
            	tessellator.setTranslationF(-0.1875f, -0.1875f, 0f);
            	func_31081_b((float)i + 0.375F, (float)i + 0.375F, (float)j + 0.625F, (float)j + 0.375F, (float)k + 0.25F, (float)k + 0.25F + f1, 0.6F, d, n0);
            	func_31081_b((float)i + 0.625F, (float)i + 0.625F, (float)j + 0.375F, (float)j + 0.625F, (float)k + 0.25F, (float)k + 0.25F + f1, 0.6F, d, n0);
            	func_31081_b((float)i + 0.375F, (float)i + 0.625F, (float)j + 0.375F, (float)j + 0.375F, (float)k + 0.25F, (float)k + 0.25F + f1, 0.5F, d, n0);
            	func_31081_b((float)i + 0.625F, (float)i + 0.375F, (float)j + 0.625F, (float)j + 0.625F, (float)k + 0.25F, (float)k + 0.25F + f1, 1.0F, d, n0);
            	tessellator.setTranslationF(0.1875f, 0.1875f, 0f);
            	overrideBlockTexture = -1;
            }else
            {
            	func_31081_b((float)i + 0.375F, (float)i + 0.375F, (float)j + 0.625F, (float)j + 0.375F, (float)k + 0.25F, (float)k + 0.25F + f1, 0.6F, d, n0);
            	func_31081_b((float)i + 0.625F, (float)i + 0.625F, (float)j + 0.375F, (float)j + 0.625F, (float)k + 0.25F, (float)k + 0.25F + f1, 0.6F, d, n0);
            	func_31081_b((float)i + 0.375F, (float)i + 0.625F, (float)j + 0.375F, (float)j + 0.375F, (float)k + 0.25F, (float)k + 0.25F + f1, 0.5F, d, n0);
            	func_31081_b((float)i + 0.625F, (float)i + 0.375F, (float)j + 0.625F, (float)j + 0.625F, (float)k + 0.25F, (float)k + 0.25F + f1, 1.0F, d, n0);
            }
            break;

        case 3: // '\003'
            southFaceRotation = 2;
            northFaceRotation = 1;
            topFaceRotation = 3;
            bottomFaceRotation = 3;
            block.setBlockBounds(0.0F, 0.0F, 0.75F, 1.0F, 1.0F, 1.0F);
            renderStandardBlock(block, i, j, k);
            if(launcher)
            {
            	overrideBlockTexture = BEBlocks.launcherExtension.blockIndexInTexture + 1;
            	tessellator.setTranslationF(0.1875f, 0.1875f, 0f);
                func_31081_b((float)i + 0.375F, (float)i + 0.375F, (float)j + 0.625F, (float)j + 0.375F, (((float)k - 0.25F) + 1.0F) - f1, ((float)k - 0.25F) + 1.0F, 0.6F, d, n0);
                func_31081_b((float)i + 0.625F, (float)i + 0.625F, (float)j + 0.375F, (float)j + 0.625F, (((float)k - 0.25F) + 1.0F) - f1, ((float)k - 0.25F) + 1.0F, 0.6F, d, n0);
                func_31081_b((float)i + 0.375F, (float)i + 0.625F, (float)j + 0.375F, (float)j + 0.375F, (((float)k - 0.25F) + 1.0F) - f1, ((float)k - 0.25F) + 1.0F, 0.5F, d, n0);
                func_31081_b((float)i + 0.625F, (float)i + 0.375F, (float)j + 0.625F, (float)j + 0.625F, (((float)k - 0.25F) + 1.0F) - f1, ((float)k - 0.25F) + 1.0F, 1.0F, d, n0);
            	tessellator.setTranslationF(-0.1875f, -0.1875f, 0f);
            	tessellator.setTranslationF(0.1875f, -0.1875f, 0f);
                func_31081_b((float)i + 0.375F, (float)i + 0.375F, (float)j + 0.625F, (float)j + 0.375F, (((float)k - 0.25F) + 1.0F) - f1, ((float)k - 0.25F) + 1.0F, 0.6F, d, n0);
                func_31081_b((float)i + 0.625F, (float)i + 0.625F, (float)j + 0.375F, (float)j + 0.625F, (((float)k - 0.25F) + 1.0F) - f1, ((float)k - 0.25F) + 1.0F, 0.6F, d, n0);
                func_31081_b((float)i + 0.375F, (float)i + 0.625F, (float)j + 0.375F, (float)j + 0.375F, (((float)k - 0.25F) + 1.0F) - f1, ((float)k - 0.25F) + 1.0F, 0.5F, d, n0);
                func_31081_b((float)i + 0.625F, (float)i + 0.375F, (float)j + 0.625F, (float)j + 0.625F, (((float)k - 0.25F) + 1.0F) - f1, ((float)k - 0.25F) + 1.0F, 1.0F, d, n0);
            	tessellator.setTranslationF(-0.1875f, 0.1875f, 0f);
            	tessellator.setTranslationF(-0.1875f, 0.1875f, 0f);
                func_31081_b((float)i + 0.375F, (float)i + 0.375F, (float)j + 0.625F, (float)j + 0.375F, (((float)k - 0.25F) + 1.0F) - f1, ((float)k - 0.25F) + 1.0F, 0.6F, d, n0);
                func_31081_b((float)i + 0.625F, (float)i + 0.625F, (float)j + 0.375F, (float)j + 0.625F, (((float)k - 0.25F) + 1.0F) - f1, ((float)k - 0.25F) + 1.0F, 0.6F, d, n0);
                func_31081_b((float)i + 0.375F, (float)i + 0.625F, (float)j + 0.375F, (float)j + 0.375F, (((float)k - 0.25F) + 1.0F) - f1, ((float)k - 0.25F) + 1.0F, 0.5F, d, n0);
                func_31081_b((float)i + 0.625F, (float)i + 0.375F, (float)j + 0.625F, (float)j + 0.625F, (((float)k - 0.25F) + 1.0F) - f1, ((float)k - 0.25F) + 1.0F, 1.0F, d, n0);
            	tessellator.setTranslationF(0.1875f, -0.1875f, 0f);
            	tessellator.setTranslationF(-0.1875f, -0.1875f, 0f);
                func_31081_b((float)i + 0.375F, (float)i + 0.375F, (float)j + 0.625F, (float)j + 0.375F, (((float)k - 0.25F) + 1.0F) - f1, ((float)k - 0.25F) + 1.0F, 0.6F, d, n0);
                func_31081_b((float)i + 0.625F, (float)i + 0.625F, (float)j + 0.375F, (float)j + 0.625F, (((float)k - 0.25F) + 1.0F) - f1, ((float)k - 0.25F) + 1.0F, 0.6F, d, n0);
                func_31081_b((float)i + 0.375F, (float)i + 0.625F, (float)j + 0.375F, (float)j + 0.375F, (((float)k - 0.25F) + 1.0F) - f1, ((float)k - 0.25F) + 1.0F, 0.5F, d, n0);
                func_31081_b((float)i + 0.625F, (float)i + 0.375F, (float)j + 0.625F, (float)j + 0.625F, (((float)k - 0.25F) + 1.0F) - f1, ((float)k - 0.25F) + 1.0F, 1.0F, d, n0);
            	tessellator.setTranslationF(0.1875f, 0.1875f, 0f);
            	overrideBlockTexture = -1;
            }else
            {
                func_31081_b((float)i + 0.375F, (float)i + 0.375F, (float)j + 0.625F, (float)j + 0.375F, (((float)k - 0.25F) + 1.0F) - f1, ((float)k - 0.25F) + 1.0F, 0.6F, d, n0);
                func_31081_b((float)i + 0.625F, (float)i + 0.625F, (float)j + 0.375F, (float)j + 0.625F, (((float)k - 0.25F) + 1.0F) - f1, ((float)k - 0.25F) + 1.0F, 0.6F, d, n0);
                func_31081_b((float)i + 0.375F, (float)i + 0.625F, (float)j + 0.375F, (float)j + 0.375F, (((float)k - 0.25F) + 1.0F) - f1, ((float)k - 0.25F) + 1.0F, 0.5F, d, n0);
                func_31081_b((float)i + 0.625F, (float)i + 0.375F, (float)j + 0.625F, (float)j + 0.625F, (((float)k - 0.25F) + 1.0F) - f1, ((float)k - 0.25F) + 1.0F, 1.0F, d, n0);
            }
            break;

        case 4: // '\004'
            eastFaceRotation = 1;
            westFaceRotation = 2;
            topFaceRotation = 2;
            bottomFaceRotation = 1;
            block.setBlockBounds(0.0F, 0.0F, 0.0F, 0.25F, 1.0F, 1.0F);
            renderStandardBlock(block, i, j, k);
            if(launcher)
            {
            	overrideBlockTexture = BEBlocks.launcherExtension.blockIndexInTexture + 1;
            	tessellator.setTranslationF(0f, 0.1875f, 0.1875f);
                func_31077_c((float)i + 0.25F, (float)i + 0.25F + f1, (float)j + 0.375F, (float)j + 0.375F, (float)k + 0.625F, (float)k + 0.375F, 0.5F, d, n0);
                func_31077_c((float)i + 0.25F, (float)i + 0.25F + f1, (float)j + 0.625F, (float)j + 0.625F, (float)k + 0.375F, (float)k + 0.625F, 1.0F, d, n0);
                func_31077_c((float)i + 0.25F, (float)i + 0.25F + f1, (float)j + 0.375F, (float)j + 0.625F, (float)k + 0.375F, (float)k + 0.375F, 0.6F, d, n0);
                func_31077_c((float)i + 0.25F, (float)i + 0.25F + f1, (float)j + 0.625F, (float)j + 0.375F, (float)k + 0.625F, (float)k + 0.625F, 0.6F, d, n0);
            	tessellator.setTranslationF(0f, -0.1875f, -0.1875f);
            	tessellator.setTranslationF(0f, 0.1875f, -0.1875f);
                func_31077_c((float)i + 0.25F, (float)i + 0.25F + f1, (float)j + 0.375F, (float)j + 0.375F, (float)k + 0.625F, (float)k + 0.375F, 0.5F, d, n0);
                func_31077_c((float)i + 0.25F, (float)i + 0.25F + f1, (float)j + 0.625F, (float)j + 0.625F, (float)k + 0.375F, (float)k + 0.625F, 1.0F, d, n0);
                func_31077_c((float)i + 0.25F, (float)i + 0.25F + f1, (float)j + 0.375F, (float)j + 0.625F, (float)k + 0.375F, (float)k + 0.375F, 0.6F, d, n0);
                func_31077_c((float)i + 0.25F, (float)i + 0.25F + f1, (float)j + 0.625F, (float)j + 0.375F, (float)k + 0.625F, (float)k + 0.625F, 0.6F, d, n0);
            	tessellator.setTranslationF(0f, -0.1875f, 0.1875f);
            	tessellator.setTranslationF(0f, -0.1875f, 0.1875f);
                func_31077_c((float)i + 0.25F, (float)i + 0.25F + f1, (float)j + 0.375F, (float)j + 0.375F, (float)k + 0.625F, (float)k + 0.375F, 0.5F, d, n0);
                func_31077_c((float)i + 0.25F, (float)i + 0.25F + f1, (float)j + 0.625F, (float)j + 0.625F, (float)k + 0.375F, (float)k + 0.625F, 1.0F, d, n0);
                func_31077_c((float)i + 0.25F, (float)i + 0.25F + f1, (float)j + 0.375F, (float)j + 0.625F, (float)k + 0.375F, (float)k + 0.375F, 0.6F, d, n0);
                func_31077_c((float)i + 0.25F, (float)i + 0.25F + f1, (float)j + 0.625F, (float)j + 0.375F, (float)k + 0.625F, (float)k + 0.625F, 0.6F, d, n0);
            	tessellator.setTranslationF(0f, 0.1875f, -0.1875f);
            	tessellator.setTranslationF(0f, -0.1875f, -0.1875f);
                func_31077_c((float)i + 0.25F, (float)i + 0.25F + f1, (float)j + 0.375F, (float)j + 0.375F, (float)k + 0.625F, (float)k + 0.375F, 0.5F, d, n0);
                func_31077_c((float)i + 0.25F, (float)i + 0.25F + f1, (float)j + 0.625F, (float)j + 0.625F, (float)k + 0.375F, (float)k + 0.625F, 1.0F, d, n0);
                func_31077_c((float)i + 0.25F, (float)i + 0.25F + f1, (float)j + 0.375F, (float)j + 0.625F, (float)k + 0.375F, (float)k + 0.375F, 0.6F, d, n0);
                func_31077_c((float)i + 0.25F, (float)i + 0.25F + f1, (float)j + 0.625F, (float)j + 0.375F, (float)k + 0.625F, (float)k + 0.625F, 0.6F, d, n0);
            	tessellator.setTranslationF(0f, 0.1875f, 0.1875f);
            	overrideBlockTexture = -1;
            }else
            {
                func_31077_c((float)i + 0.25F, (float)i + 0.25F + f1, (float)j + 0.375F, (float)j + 0.375F, (float)k + 0.625F, (float)k + 0.375F, 0.5F, d, n0);
                func_31077_c((float)i + 0.25F, (float)i + 0.25F + f1, (float)j + 0.625F, (float)j + 0.625F, (float)k + 0.375F, (float)k + 0.625F, 1.0F, d, n0);
                func_31077_c((float)i + 0.25F, (float)i + 0.25F + f1, (float)j + 0.375F, (float)j + 0.625F, (float)k + 0.375F, (float)k + 0.375F, 0.6F, d, n0);
                func_31077_c((float)i + 0.25F, (float)i + 0.25F + f1, (float)j + 0.625F, (float)j + 0.375F, (float)k + 0.625F, (float)k + 0.625F, 0.6F, d, n0);
            }
            break;

        case 5: // '\005'
            eastFaceRotation = 2;
            westFaceRotation = 1;
            topFaceRotation = 1;
            bottomFaceRotation = 2;
            block.setBlockBounds(0.75F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
            renderStandardBlock(block, i, j, k);
            if(launcher)
            {
            	overrideBlockTexture = BEBlocks.launcherExtension.blockIndexInTexture + 1;
            	tessellator.setTranslationF(0f, 0.1875f, 0.1875f);
                func_31077_c((((float)i - 0.25F) + 1.0F) - f1, ((float)i - 0.25F) + 1.0F, (float)j + 0.375F, (float)j + 0.375F, (float)k + 0.625F, (float)k + 0.375F, 0.5F, d, n0);
                func_31077_c((((float)i - 0.25F) + 1.0F) - f1, ((float)i - 0.25F) + 1.0F, (float)j + 0.625F, (float)j + 0.625F, (float)k + 0.375F, (float)k + 0.625F, 1.0F, d, n0);
                func_31077_c((((float)i - 0.25F) + 1.0F) - f1, ((float)i - 0.25F) + 1.0F, (float)j + 0.375F, (float)j + 0.625F, (float)k + 0.375F, (float)k + 0.375F, 0.6F, d, n0);
                func_31077_c((((float)i - 0.25F) + 1.0F) - f1, ((float)i - 0.25F) + 1.0F, (float)j + 0.625F, (float)j + 0.375F, (float)k + 0.625F, (float)k + 0.625F, 0.6F, d, n0);
            	tessellator.setTranslationF(0f, -0.1875f, -0.1875f);
            	tessellator.setTranslationF(0f, 0.1875f, -0.1875f);
                func_31077_c((((float)i - 0.25F) + 1.0F) - f1, ((float)i - 0.25F) + 1.0F, (float)j + 0.375F, (float)j + 0.375F, (float)k + 0.625F, (float)k + 0.375F, 0.5F, d, n0);
                func_31077_c((((float)i - 0.25F) + 1.0F) - f1, ((float)i - 0.25F) + 1.0F, (float)j + 0.625F, (float)j + 0.625F, (float)k + 0.375F, (float)k + 0.625F, 1.0F, d, n0);
                func_31077_c((((float)i - 0.25F) + 1.0F) - f1, ((float)i - 0.25F) + 1.0F, (float)j + 0.375F, (float)j + 0.625F, (float)k + 0.375F, (float)k + 0.375F, 0.6F, d, n0);
                func_31077_c((((float)i - 0.25F) + 1.0F) - f1, ((float)i - 0.25F) + 1.0F, (float)j + 0.625F, (float)j + 0.375F, (float)k + 0.625F, (float)k + 0.625F, 0.6F, d, n0);
            	tessellator.setTranslationF(0f, -0.1875f, 0.1875f);
            	tessellator.setTranslationF(0f, -0.1875f, 0.1875f);
                func_31077_c((((float)i - 0.25F) + 1.0F) - f1, ((float)i - 0.25F) + 1.0F, (float)j + 0.375F, (float)j + 0.375F, (float)k + 0.625F, (float)k + 0.375F, 0.5F, d, n0);
                func_31077_c((((float)i - 0.25F) + 1.0F) - f1, ((float)i - 0.25F) + 1.0F, (float)j + 0.625F, (float)j + 0.625F, (float)k + 0.375F, (float)k + 0.625F, 1.0F, d, n0);
                func_31077_c((((float)i - 0.25F) + 1.0F) - f1, ((float)i - 0.25F) + 1.0F, (float)j + 0.375F, (float)j + 0.625F, (float)k + 0.375F, (float)k + 0.375F, 0.6F, d, n0);
                func_31077_c((((float)i - 0.25F) + 1.0F) - f1, ((float)i - 0.25F) + 1.0F, (float)j + 0.625F, (float)j + 0.375F, (float)k + 0.625F, (float)k + 0.625F, 0.6F, d, n0);
            	tessellator.setTranslationF(0f, 0.1875f, -0.1875f);
            	tessellator.setTranslationF(0f, -0.1875f, -0.1875f);
                func_31077_c((((float)i - 0.25F) + 1.0F) - f1, ((float)i - 0.25F) + 1.0F, (float)j + 0.375F, (float)j + 0.375F, (float)k + 0.625F, (float)k + 0.375F, 0.5F, d, n0);
                func_31077_c((((float)i - 0.25F) + 1.0F) - f1, ((float)i - 0.25F) + 1.0F, (float)j + 0.625F, (float)j + 0.625F, (float)k + 0.375F, (float)k + 0.625F, 1.0F, d, n0);
                func_31077_c((((float)i - 0.25F) + 1.0F) - f1, ((float)i - 0.25F) + 1.0F, (float)j + 0.375F, (float)j + 0.625F, (float)k + 0.375F, (float)k + 0.375F, 0.6F, d, n0);
                func_31077_c((((float)i - 0.25F) + 1.0F) - f1, ((float)i - 0.25F) + 1.0F, (float)j + 0.625F, (float)j + 0.375F, (float)k + 0.625F, (float)k + 0.625F, 0.6F, d, n0);
            	tessellator.setTranslationF(0f, 0.1875f, 0.1875f);
            	overrideBlockTexture = -1;
            }else
            {
                func_31077_c((((float)i - 0.25F) + 1.0F) - f1, ((float)i - 0.25F) + 1.0F, (float)j + 0.375F, (float)j + 0.375F, (float)k + 0.625F, (float)k + 0.375F, 0.5F, d, n0);
                func_31077_c((((float)i - 0.25F) + 1.0F) - f1, ((float)i - 0.25F) + 1.0F, (float)j + 0.625F, (float)j + 0.625F, (float)k + 0.375F, (float)k + 0.625F, 1.0F, d, n0);
                func_31077_c((((float)i - 0.25F) + 1.0F) - f1, ((float)i - 0.25F) + 1.0F, (float)j + 0.375F, (float)j + 0.625F, (float)k + 0.375F, (float)k + 0.375F, 0.6F, d, n0);
                func_31077_c((((float)i - 0.25F) + 1.0F) - f1, ((float)i - 0.25F) + 1.0F, (float)j + 0.625F, (float)j + 0.375F, (float)k + 0.625F, (float)k + 0.625F, 0.6F, d, n0);
            }
            break;
        }
        eastFaceRotation = 0;
        westFaceRotation = 0;
        southFaceRotation = 0;
        northFaceRotation = 0;
        topFaceRotation = 0;
        bottomFaceRotation = 0;
        block.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
        return true;
    }

    public boolean renderBlockLever(Block block, int i, int j, int k)
    {
        int l = blockAccess.getBlockMetadata(i, j, k);
        int i1 = l & 7;
        boolean flag = (l & 8) > 0;
        Tessellator tessellator = Tessellator.instance;
        boolean flag1 = overrideBlockTexture >= 0;
        if(!flag1)
        {
            overrideBlockTexture = Block.cobblestone.blockIndexInTexture;
        }
        float f = 0.25F;
        float f1 = 0.1875F;
        float f2 = 0.1875F;
        if(i1 == 5)
        {
            block.setBlockBounds(0.5F - f1, 0.0F, 0.5F - f, 0.5F + f1, f2, 0.5F + f);
        } else
        if(i1 == 6)
        {
            block.setBlockBounds(0.5F - f, 0.0F, 0.5F - f1, 0.5F + f, f2, 0.5F + f1);
        } else
        if(i1 == 4)
        {
            block.setBlockBounds(0.5F - f1, 0.5F - f, 1.0F - f2, 0.5F + f1, 0.5F + f, 1.0F);
        } else
        if(i1 == 3)
        {
            block.setBlockBounds(0.5F - f1, 0.5F - f, 0.0F, 0.5F + f1, 0.5F + f, f2);
        } else
        if(i1 == 2)
        {
            block.setBlockBounds(1.0F - f2, 0.5F - f, 0.5F - f1, 1.0F, 0.5F + f, 0.5F + f1);
        } else
        if(i1 == 1)
        {
            block.setBlockBounds(0.0F, 0.5F - f, 0.5F - f1, f2, 0.5F + f, 0.5F + f1);
        }
        renderStandardBlock(block, i, j, k);
        if(!flag1)
        {
            overrideBlockTexture = -1;
        }
        tessellator.setBrightness(block.getRenderBrightness(blockAccess, i, j, k));
        float f3 = 1.0F;
        if(Block.lightValue[block.blockID] > 0)
        {
            f3 = 1.0F;
        }
        tessellator.setColorOpaque_F(f3, f3, f3);
        int j1 = block.getBlockTextureFromSide(0);
        if(overrideBlockTexture >= 0)
        {
            j1 = overrideBlockTexture;
        }
        int k1 = (j1 & 0xf) << 4;
        int l1 = j1 & 0xf0;
        float f4 = (float)k1 / 256F;
        float f5 = ((float)k1 + 16F) / 256F;
        float f6 = (float)l1 / 256F;
        float f7 = ((float)l1 + 16F) / 256F;
        Vec3D avec3d[] = new Vec3D[8];
        float f8 = 0.0625F;
        float f9 = 0.0625F;
        float f10 = 0.625F;
        avec3d[0] = Vec3D.createVector(-f8, 0.0D, -f9);
        avec3d[1] = Vec3D.createVector(f8, 0.0D, -f9);
        avec3d[2] = Vec3D.createVector(f8, 0.0D, f9);
        avec3d[3] = Vec3D.createVector(-f8, 0.0D, f9);
        avec3d[4] = Vec3D.createVector(-f8, f10, -f9);
        avec3d[5] = Vec3D.createVector(f8, f10, -f9);
        avec3d[6] = Vec3D.createVector(f8, f10, f9);
        avec3d[7] = Vec3D.createVector(-f8, f10, f9);
        for(int i2 = 0; i2 < 8; i2++)
        {
            if(flag)
            {
                avec3d[i2].zCoord -= 0.0625D;
                avec3d[i2].rotateAroundX(0.6981317F);
            } else
            {
                avec3d[i2].zCoord += 0.0625D;
                avec3d[i2].rotateAroundX(-0.6981317F);
            }
            if(i1 == 6)
            {
                avec3d[i2].rotateAroundY(1.570796F);
            }
            if(i1 < 5)
            {
                avec3d[i2].yCoord -= 0.375D;
                avec3d[i2].rotateAroundX(1.570796F);
                if(i1 == 4)
                {
                    avec3d[i2].rotateAroundY(0.0F);
                }
                if(i1 == 3)
                {
                    avec3d[i2].rotateAroundY(3.141593F);
                }
                if(i1 == 2)
                {
                    avec3d[i2].rotateAroundY(1.570796F);
                }
                if(i1 == 1)
                {
                    avec3d[i2].rotateAroundY(-1.570796F);
                }
                avec3d[i2].xCoord += (double)i + 0.5D;
                avec3d[i2].yCoord += (float)j + 0.5F;
                avec3d[i2].zCoord += (double)k + 0.5D;
            } else
            {
                avec3d[i2].xCoord += (double)i + 0.5D;
                avec3d[i2].yCoord += (float)j + 0.125F;
                avec3d[i2].zCoord += (double)k + 0.5D;
            }
        }

        Vec3D vec3d = null;
        Vec3D vec3d1 = null;
        Vec3D vec3d2 = null;
        Vec3D vec3d3 = null;
        for(int j2 = 0; j2 < 6; j2++)
        {
            if(j2 == 0)
            {
                f4 = (float)(k1 + 7) / 256F;
                f5 = (float)(k1 + 9) / 256F;
                f6 = (float)(l1 + 6) / 256F;
                f7 = (float)(l1 + 8) / 256F;
            } else
            if(j2 == 2)
            {
                f4 = (float)(k1 + 7) / 256F;
                f5 = (float)(k1 + 9) / 256F;
                f6 = (float)(l1 + 6) / 256F;
                f7 = (float)(l1 + 16) / 256F;
            }
            if(j2 == 0)
            {
                vec3d = avec3d[0];
                vec3d1 = avec3d[1];
                vec3d2 = avec3d[2];
                vec3d3 = avec3d[3];
            } else
            if(j2 == 1)
            {
                vec3d = avec3d[7];
                vec3d1 = avec3d[6];
                vec3d2 = avec3d[5];
                vec3d3 = avec3d[4];
            } else
            if(j2 == 2)
            {
                vec3d = avec3d[1];
                vec3d1 = avec3d[0];
                vec3d2 = avec3d[4];
                vec3d3 = avec3d[5];
            } else
            if(j2 == 3)
            {
                vec3d = avec3d[2];
                vec3d1 = avec3d[1];
                vec3d2 = avec3d[5];
                vec3d3 = avec3d[6];
            } else
            if(j2 == 4)
            {
                vec3d = avec3d[3];
                vec3d1 = avec3d[2];
                vec3d2 = avec3d[6];
                vec3d3 = avec3d[7];
            } else
            if(j2 == 5)
            {
                vec3d = avec3d[0];
                vec3d1 = avec3d[3];
                vec3d2 = avec3d[7];
                vec3d3 = avec3d[4];
            }
            tessellator.addVertexWithUV(vec3d.xCoord, vec3d.yCoord, vec3d.zCoord, f4, f7);
            tessellator.addVertexWithUV(vec3d1.xCoord, vec3d1.yCoord, vec3d1.zCoord, f5, f7);
            tessellator.addVertexWithUV(vec3d2.xCoord, vec3d2.yCoord, vec3d2.zCoord, f5, f6);
            tessellator.addVertexWithUV(vec3d3.xCoord, vec3d3.yCoord, vec3d3.zCoord, f4, f6);
        }

        return true;
    }

    public boolean renderBlockFire(Block block, int i, int j, int k)
    {
        Tessellator tessellator = Tessellator.instance;
        int l = block.getBlockTextureFromSide(0);
        if(overrideBlockTexture >= 0)
        {
            l = overrideBlockTexture;
        }
        float f = 1.0F;
        tessellator.setBrightness(block.getRenderBrightness(blockAccess, i, j, k));
        tessellator.setColorOpaque_F(f, f, f);
        int i1 = (l & 0xf) << 4;
        int j1 = l & 0xf0;
        double d = (float)i1 / 256F;
        double d2 = ((float)i1 + 15.99F) / 256F;
        double d4 = (float)j1 / 256F;
        double d6 = ((float)j1 + 15.99F) / 256F;
        float f1 = 1.4F;
        if(blockAccess.isBlockNormalCube(i, j - 1, k) || Block.fire.canBlockCatchFire(blockAccess, i, j - 1, k))
        {
            double d8 = (double)i + 0.5D + 0.20000000000000001D;
            double d9 = ((double)i + 0.5D) - 0.20000000000000001D;
            double d12 = (double)k + 0.5D + 0.20000000000000001D;
            double d14 = ((double)k + 0.5D) - 0.20000000000000001D;
            double d16 = ((double)i + 0.5D) - 0.29999999999999999D;
            double d18 = (double)i + 0.5D + 0.29999999999999999D;
            double d20 = ((double)k + 0.5D) - 0.29999999999999999D;
            double d22 = (double)k + 0.5D + 0.29999999999999999D;
            tessellator.addVertexWithUV(d16, (float)j + f1, k + 1, d2, d4);
            tessellator.addVertexWithUV(d8, j + 0, k + 1, d2, d6);
            tessellator.addVertexWithUV(d8, j + 0, k + 0, d, d6);
            tessellator.addVertexWithUV(d16, (float)j + f1, k + 0, d, d4);

            tessellator.addVertexWithUV(d18, (float)j + f1, k + 0, d2, d4);
            tessellator.addVertexWithUV(d9, j + 0, k + 0, d2, d6);
            tessellator.addVertexWithUV(d9, j + 0, k + 1, d, d6);
            tessellator.addVertexWithUV(d18, (float)j + f1, k + 1, d, d4);

            d = (float)i1 / 256F;
            d2 = ((float)i1 + 15.99F) / 256F;
            d4 = (float)(j1 + 16) / 256F;
            d6 = ((float)j1 + 15.99F + 16F) / 256F;
            tessellator.addVertexWithUV(i + 1, (float)j + f1, d22, d2, d4);
            tessellator.addVertexWithUV(i + 1, j + 0, d14, d2, d6);
            tessellator.addVertexWithUV(i + 0, j + 0, d14, d, d6);
            tessellator.addVertexWithUV(i + 0, (float)j + f1, d22, d, d4);

            tessellator.addVertexWithUV(i + 0, (float)j + f1, d20, d2, d4);
            tessellator.addVertexWithUV(i + 0, j + 0, d12, d2, d6);
            tessellator.addVertexWithUV(i + 1, j + 0, d12, d, d6);
            tessellator.addVertexWithUV(i + 1, (float)j + f1, d20, d, d4);

            d8 = ((double)i + 0.5D) - 0.5D;
            d9 = (double)i + 0.5D + 0.5D;
            d12 = ((double)k + 0.5D) - 0.5D;
            d14 = (double)k + 0.5D + 0.5D;
            d16 = ((double)i + 0.5D) - 0.40000000000000002D;
            d18 = (double)i + 0.5D + 0.40000000000000002D;
            d20 = ((double)k + 0.5D) - 0.40000000000000002D;
            d22 = (double)k + 0.5D + 0.40000000000000002D;
            tessellator.addVertexWithUV(d16, (float)j + f1, k + 0, d, d4);
            tessellator.addVertexWithUV(d8, j + 0, k + 0, d, d6);
            tessellator.addVertexWithUV(d8, j + 0, k + 1, d2, d6);
            tessellator.addVertexWithUV(d16, (float)j + f1, k + 1, d2, d4);

            tessellator.addVertexWithUV(d18, (float)j + f1, k + 1, d, d4);
            tessellator.addVertexWithUV(d9, j + 0, k + 1, d, d6);
            tessellator.addVertexWithUV(d9, j + 0, k + 0, d2, d6);
            tessellator.addVertexWithUV(d18, (float)j + f1, k + 0, d2, d4);

            d = (float)i1 / 256F;
            d2 = ((float)i1 + 15.99F) / 256F;
            d4 = (float)j1 / 256F;
            d6 = ((float)j1 + 15.99F) / 256F;
            tessellator.addVertexWithUV(i + 0, (float)j + f1, d22, d, d4);
            tessellator.addVertexWithUV(i + 0, j + 0, d14, d, d6);
            tessellator.addVertexWithUV(i + 1, j + 0, d14, d2, d6);
            tessellator.addVertexWithUV(i + 1, (float)j + f1, d22, d2, d4);

            tessellator.addVertexWithUV(i + 1, (float)j + f1, d20, d, d4);
            tessellator.addVertexWithUV(i + 1, j + 0, d12, d, d6);
            tessellator.addVertexWithUV(i + 0, j + 0, d12, d2, d6);
            tessellator.addVertexWithUV(i + 0, (float)j + f1, d20, d2, d4);

        } else
        {
            float f3 = 0.2F;
            float f4 = 0.0625F;
            if((i + j + k & 1) == 1)
            {
                d = (float)i1 / 256F;
                d2 = ((float)i1 + 15.99F) / 256F;
                d4 = (float)(j1 + 16) / 256F;
                d6 = ((float)j1 + 15.99F + 16F) / 256F;
            }
            if((i / 2 + j / 2 + k / 2 & 1) == 1)
            {
                double d10 = d2;
                d2 = d;
                d = d10;
            }
            if(Block.fire.canBlockCatchFire(blockAccess, i - 1, j, k))
            {
                tessellator.addVertexWithUV((float)i + f3, (float)j + f1 + f4, k + 1, d2, d4);
                tessellator.addVertexWithUV(i + 0, (float)(j + 0) + f4, k + 1, d2, d6);
                tessellator.addVertexWithUV(i + 0, (float)(j + 0) + f4, k + 0, d, d6);
                tessellator.addVertexWithUV((float)i + f3, (float)j + f1 + f4, k + 0, d, d4);

                tessellator.addVertexWithUV((float)i + f3, (float)j + f1 + f4, k + 0, d, d4);
                tessellator.addVertexWithUV(i + 0, (float)(j + 0) + f4, k + 0, d, d6);
                tessellator.addVertexWithUV(i + 0, (float)(j + 0) + f4, k + 1, d2, d6);
                tessellator.addVertexWithUV((float)i + f3, (float)j + f1 + f4, k + 1, d2, d4);

            }
            if(Block.fire.canBlockCatchFire(blockAccess, i + 1, j, k))
            {
                tessellator.addVertexWithUV((float)(i + 1) - f3, (float)j + f1 + f4, k + 0, d, d4);
                tessellator.addVertexWithUV((i + 1) - 0, (float)(j + 0) + f4, k + 0, d, d6);
                tessellator.addVertexWithUV((i + 1) - 0, (float)(j + 0) + f4, k + 1, d2, d6);
                tessellator.addVertexWithUV((float)(i + 1) - f3, (float)j + f1 + f4, k + 1, d2, d4);

                tessellator.addVertexWithUV((float)(i + 1) - f3, (float)j + f1 + f4, k + 1, d2, d4);
                tessellator.addVertexWithUV((i + 1) - 0, (float)(j + 0) + f4, k + 1, d2, d6);
                tessellator.addVertexWithUV((i + 1) - 0, (float)(j + 0) + f4, k + 0, d, d6);
                tessellator.addVertexWithUV((float)(i + 1) - f3, (float)j + f1 + f4, k + 0, d, d4);

            }
            if(Block.fire.canBlockCatchFire(blockAccess, i, j, k - 1))
            {
                tessellator.addVertexWithUV(i + 0, (float)j + f1 + f4, (float)k + f3, d2, d4);
                tessellator.addVertexWithUV(i + 0, (float)(j + 0) + f4, k + 0, d2, d6);
                tessellator.addVertexWithUV(i + 1, (float)(j + 0) + f4, k + 0, d, d6);
                tessellator.addVertexWithUV(i + 1, (float)j + f1 + f4, (float)k + f3, d, d4);

                tessellator.addVertexWithUV(i + 1, (float)j + f1 + f4, (float)k + f3, d, d4);
                tessellator.addVertexWithUV(i + 1, (float)(j + 0) + f4, k + 0, d, d6);
                tessellator.addVertexWithUV(i + 0, (float)(j + 0) + f4, k + 0, d2, d6);
                tessellator.addVertexWithUV(i + 0, (float)j + f1 + f4, (float)k + f3, d2, d4);

            }
            if(Block.fire.canBlockCatchFire(blockAccess, i, j, k + 1))
            {
                tessellator.addVertexWithUV(i + 1, (float)j + f1 + f4, (float)(k + 1) - f3, d, d4);
                tessellator.addVertexWithUV(i + 1, (float)(j + 0) + f4, (k + 1) - 0, d, d6);
                tessellator.addVertexWithUV(i + 0, (float)(j + 0) + f4, (k + 1) - 0, d2, d6);
                tessellator.addVertexWithUV(i + 0, (float)j + f1 + f4, (float)(k + 1) - f3, d2, d4);

                tessellator.addVertexWithUV(i + 0, (float)j + f1 + f4, (float)(k + 1) - f3, d2, d4);
                tessellator.addVertexWithUV(i + 0, (float)(j + 0) + f4, (k + 1) - 0, d2, d6);
                tessellator.addVertexWithUV(i + 1, (float)(j + 0) + f4, (k + 1) - 0, d, d6);
                tessellator.addVertexWithUV(i + 1, (float)j + f1 + f4, (float)(k + 1) - f3, d, d4);

            }
            if(Block.fire.canBlockCatchFire(blockAccess, i, j + 1, k))
            {
                double d11 = (double)i + 0.5D + 0.5D;
                double d13 = ((double)i + 0.5D) - 0.5D;
                double d15 = (double)k + 0.5D + 0.5D;
                double d17 = ((double)k + 0.5D) - 0.5D;
                double d19 = ((double)i + 0.5D) - 0.5D;
                double d21 = (double)i + 0.5D + 0.5D;
                double d23 = ((double)k + 0.5D) - 0.5D;
                double d24 = (double)k + 0.5D + 0.5D;
                double d1 = (float)i1 / 256F;
                double d3 = ((float)i1 + 15.99F) / 256F;
                double d5 = (float)j1 / 256F;
                double d7 = ((float)j1 + 15.99F) / 256F;
                j++;
                float f2 = -0.2F;
                if((i + j + k & 1) == 0)
                {
                    tessellator.addVertexWithUV(d19, (float)j + f2, k + 0, d3, d5);
                    tessellator.addVertexWithUV(d11, j + 0, k + 0, d3, d7);
                    tessellator.addVertexWithUV(d11, j + 0, k + 1, d1, d7);
                    tessellator.addVertexWithUV(d19, (float)j + f2, k + 1, d1, d5);

                    d1 = (float)i1 / 256F;
                    d3 = ((float)i1 + 15.99F) / 256F;
                    d5 = (float)(j1 + 16) / 256F;
                    d7 = ((float)j1 + 15.99F + 16F) / 256F;
                    tessellator.addVertexWithUV(d21, (float)j + f2, k + 1, d3, d5);
                    tessellator.addVertexWithUV(d13, j + 0, k + 1, d3, d7);
                    tessellator.addVertexWithUV(d13, j + 0, k + 0, d1, d7);
                    tessellator.addVertexWithUV(d21, (float)j + f2, k + 0, d1, d5);

                } else
                {
                    tessellator.addVertexWithUV(i + 0, (float)j + f2, d24, d3, d5);
                    tessellator.addVertexWithUV(i + 0, j + 0, d17, d3, d7);
                    tessellator.addVertexWithUV(i + 1, j + 0, d17, d1, d7);
                    tessellator.addVertexWithUV(i + 1, (float)j + f2, d24, d1, d5);

                    d1 = (float)i1 / 256F;
                    d3 = ((float)i1 + 15.99F) / 256F;
                    d5 = (float)(j1 + 16) / 256F;
                    d7 = ((float)j1 + 15.99F + 16F) / 256F;
                    tessellator.addVertexWithUV(i + 1, (float)j + f2, d23, d3, d5);
                    tessellator.addVertexWithUV(i + 1, j + 0, d15, d3, d7);
                    tessellator.addVertexWithUV(i + 0, j + 0, d15, d1, d7);
                    tessellator.addVertexWithUV(i + 0, (float)j + f2, d23, d1, d5);

                }
            }
        }
        return true;
    }

    public static void setRedstoneColors(float af[][])
    {
        if(af.length != 16)
        {
            throw new IllegalArgumentException("Must be 16 colors.");
        }
        for(int i = 0; i < af.length; i++)
        {
            if(af[i].length != 3)
            {
                throw new IllegalArgumentException("Must be 3 channels in a color.");
            }
        }

        redstoneColors = af;
    }

    public boolean renderBlockRedstoneWire(Block block, int i, int j, int k)
    {
        Tessellator tessellator = Tessellator.instance;
        int l = blockAccess.getBlockMetadata(i, j, k);
        int i1 = block.getBlockTextureFromSideAndMetadata(1, l);
        if(overrideBlockTexture >= 0)
        {
            i1 = overrideBlockTexture;
        }
        float f = 1.0F;
        tessellator.setBrightness(block.getRenderBrightness(blockAccess, i, j, k));
        float af[] = redstoneColors[l];
        float f1 = af[0];
        float f2 = af[1];
        float f3 = af[2];
        tessellator.setColorOpaque_F(f * f1, f * f2, f * f3);
        int j1 = (i1 & 0xf) << 4;
        int k1 = i1 & 0xf0;
        double d = (float)j1 / 256F;
        double d1 = ((float)j1 + 16F) / 256F;
        double d2 = (float)k1 / 256F;
        double d3 = ((float)k1 + 16F) / 256F;
        boolean flag = BlockRedstoneWire.isPowerProviderOrWire(blockAccess, i - 1, j, k, 1) || !blockAccess.isBlockNormalCube(i - 1, j, k) && BlockRedstoneWire.isPowerProviderOrWire(blockAccess, i - 1, j - 1, k, -1);
        boolean flag1 = BlockRedstoneWire.isPowerProviderOrWire(blockAccess, i + 1, j, k, 3) || !blockAccess.isBlockNormalCube(i + 1, j, k) && BlockRedstoneWire.isPowerProviderOrWire(blockAccess, i + 1, j - 1, k, -1);
        boolean flag2 = BlockRedstoneWire.isPowerProviderOrWire(blockAccess, i, j, k - 1, 2) || !blockAccess.isBlockNormalCube(i, j, k - 1) && BlockRedstoneWire.isPowerProviderOrWire(blockAccess, i, j - 1, k - 1, -1);
        boolean flag3 = BlockRedstoneWire.isPowerProviderOrWire(blockAccess, i, j, k + 1, 0) || !blockAccess.isBlockNormalCube(i, j, k + 1) && BlockRedstoneWire.isPowerProviderOrWire(blockAccess, i, j - 1, k + 1, -1);
        if(!blockAccess.isBlockNormalCube(i, j + 1, k))
        {
            if(blockAccess.isBlockNormalCube(i - 1, j, k) && BlockRedstoneWire.isPowerProviderOrWire(blockAccess, i - 1, j + 1, k, -1))
            {
                flag = true;
            }
            if(blockAccess.isBlockNormalCube(i + 1, j, k) && BlockRedstoneWire.isPowerProviderOrWire(blockAccess, i + 1, j + 1, k, -1))
            {
                flag1 = true;
            }
            if(blockAccess.isBlockNormalCube(i, j, k - 1) && BlockRedstoneWire.isPowerProviderOrWire(blockAccess, i, j + 1, k - 1, -1))
            {
                flag2 = true;
            }
            if(blockAccess.isBlockNormalCube(i, j, k + 1) && BlockRedstoneWire.isPowerProviderOrWire(blockAccess, i, j + 1, k + 1, -1))
            {
                flag3 = true;
            }
        }
        float f4 = i + 0;
        float f5 = i + 1;
        float f6 = k + 0;
        float f7 = k + 1;
        byte byte0 = 0;
        if((flag || flag1) && !flag2 && !flag3)
        {
            byte0 = 1;
        }
        if((flag2 || flag3) && !flag1 && !flag)
        {
            byte0 = 2;
        }
        if(byte0 != 0)
        {
            d = (float)(j1 + 16) / 256F;
            d1 = ((float)(j1 + 16) + 16F) / 256F;
            d2 = (float)k1 / 256F;
            d3 = ((float)k1 + 16F) / 256F;
        }
        if(byte0 == 0)
        {
            if(flag1 || flag2 || flag3 || flag)
            {
                if(!flag)
                {
                    f4 += 0.3125F;
                }
                if(!flag)
                {
                    d += 0.01953125D;
                }
                if(!flag1)
                {
                    f5 -= 0.3125F;
                }
                if(!flag1)
                {
                    d1 -= 0.01953125D;
                }
                if(!flag2)
                {
                    f6 += 0.3125F;
                }
                if(!flag2)
                {
                    d2 += 0.01953125D;
                }
                if(!flag3)
                {
                    f7 -= 0.3125F;
                }
                if(!flag3)
                {
                    d3 -= 0.01953125D;
                }
            }
            tessellator.addVertexWithUV(f5, (float)j + 0.015625F, f7, d1, d3);
            tessellator.addVertexWithUV(f5, (float)j + 0.015625F, f6, d1, d2);
            tessellator.addVertexWithUV(f4, (float)j + 0.015625F, f6, d, d2);
            tessellator.addVertexWithUV(f4, (float)j + 0.015625F, f7, d, d3);
            tessellator.setColorOpaque_F(f, f, f);
            tessellator.addVertexWithUV(f5, (float)j + 0.015625F, f7, d1, d3 + 0.0625D);
            tessellator.addVertexWithUV(f5, (float)j + 0.015625F, f6, d1, d2 + 0.0625D);
            tessellator.addVertexWithUV(f4, (float)j + 0.015625F, f6, d, d2 + 0.0625D);
            tessellator.addVertexWithUV(f4, (float)j + 0.015625F, f7, d, d3 + 0.0625D);
        } else
        if(byte0 == 1)
        {
            tessellator.addVertexWithUV(f5, (float)j + 0.015625F, f7, d1, d3);
            tessellator.addVertexWithUV(f5, (float)j + 0.015625F, f6, d1, d2);
            tessellator.addVertexWithUV(f4, (float)j + 0.015625F, f6, d, d2);
            tessellator.addVertexWithUV(f4, (float)j + 0.015625F, f7, d, d3);
            tessellator.setColorOpaque_F(f, f, f);
            tessellator.addVertexWithUV(f5, (float)j + 0.015625F, f7, d1, d3 + 0.0625D);
            tessellator.addVertexWithUV(f5, (float)j + 0.015625F, f6, d1, d2 + 0.0625D);
            tessellator.addVertexWithUV(f4, (float)j + 0.015625F, f6, d, d2 + 0.0625D);
            tessellator.addVertexWithUV(f4, (float)j + 0.015625F, f7, d, d3 + 0.0625D);
        } else
        if(byte0 == 2)
        {
            tessellator.addVertexWithUV(f5, (float)j + 0.015625F, f7, d1, d3);
            tessellator.addVertexWithUV(f5, (float)j + 0.015625F, f6, d, d3);
            tessellator.addVertexWithUV(f4, (float)j + 0.015625F, f6, d, d2);
            tessellator.addVertexWithUV(f4, (float)j + 0.015625F, f7, d1, d2);
            tessellator.setColorOpaque_F(f, f, f);
            tessellator.addVertexWithUV(f5, (float)j + 0.015625F, f7, d1, d3 + 0.0625D);
            tessellator.addVertexWithUV(f5, (float)j + 0.015625F, f6, d, d3 + 0.0625D);
            tessellator.addVertexWithUV(f4, (float)j + 0.015625F, f6, d, d2 + 0.0625D);
            tessellator.addVertexWithUV(f4, (float)j + 0.015625F, f7, d1, d2 + 0.0625D);
        }
        if(!blockAccess.isBlockNormalCube(i, j + 1, k))
        {
            double d4 = (float)(j1 + 16) / 256F;
            double d5 = ((float)(j1 + 16) + 16F) / 256F;
            double d6 = (float)k1 / 256F;
            double d7 = ((float)k1 + 16F) / 256F;
            if(blockAccess.isBlockNormalCube(i - 1, j, k) && blockAccess.getBlockId(i - 1, j + 1, k) == Block.redstoneWire.blockID)
            {
                tessellator.setColorOpaque_F(f * f1, f * f2, f * f3);
                tessellator.addVertexWithUV((float)i + 0.015625F, (float)(j + 1) + 0.021875F, k + 1, d5, d6);
                tessellator.addVertexWithUV((float)i + 0.015625F, j + 0, k + 1, d4, d6);
                tessellator.addVertexWithUV((float)i + 0.015625F, j + 0, k + 0, d4, d7);
                tessellator.addVertexWithUV((float)i + 0.015625F, (float)(j + 1) + 0.021875F, k + 0, d5, d7);
                tessellator.setColorOpaque_F(f, f, f);
                tessellator.addVertexWithUV((float)i + 0.015625F, (float)(j + 1) + 0.021875F, k + 1, d5, d6 + 0.0625D);
                tessellator.addVertexWithUV((float)i + 0.015625F, j + 0, k + 1, d4, d6 + 0.0625D);
                tessellator.addVertexWithUV((float)i + 0.015625F, j + 0, k + 0, d4, d7 + 0.0625D);
                tessellator.addVertexWithUV((float)i + 0.015625F, (float)(j + 1) + 0.021875F, k + 0, d5, d7 + 0.0625D);
            }
            if(blockAccess.isBlockNormalCube(i + 1, j, k) && blockAccess.getBlockId(i + 1, j + 1, k) == Block.redstoneWire.blockID)
            {
                tessellator.setColorOpaque_F(f * f1, f * f2, f * f3);
                tessellator.addVertexWithUV((float)(i + 1) - 0.015625F, j + 0, k + 1, d4, d7);
                tessellator.addVertexWithUV((float)(i + 1) - 0.015625F, (float)(j + 1) + 0.021875F, k + 1, d5, d7);
                tessellator.addVertexWithUV((float)(i + 1) - 0.015625F, (float)(j + 1) + 0.021875F, k + 0, d5, d6);
                tessellator.addVertexWithUV((float)(i + 1) - 0.015625F, j + 0, k + 0, d4, d6);
                tessellator.setColorOpaque_F(f, f, f);
                tessellator.addVertexWithUV((float)(i + 1) - 0.015625F, j + 0, k + 1, d4, d7 + 0.0625D);
                tessellator.addVertexWithUV((float)(i + 1) - 0.015625F, (float)(j + 1) + 0.021875F, k + 1, d5, d7 + 0.0625D);
                tessellator.addVertexWithUV((float)(i + 1) - 0.015625F, (float)(j + 1) + 0.021875F, k + 0, d5, d6 + 0.0625D);
                tessellator.addVertexWithUV((float)(i + 1) - 0.015625F, j + 0, k + 0, d4, d6 + 0.0625D);
            }
            if(blockAccess.isBlockNormalCube(i, j, k - 1) && blockAccess.getBlockId(i, j + 1, k - 1) == Block.redstoneWire.blockID)
            {
                tessellator.setColorOpaque_F(f * f1, f * f2, f * f3);
                tessellator.addVertexWithUV(i + 1, j + 0, (float)k + 0.015625F, d4, d7);
                tessellator.addVertexWithUV(i + 1, (float)(j + 1) + 0.021875F, (float)k + 0.015625F, d5, d7);
                tessellator.addVertexWithUV(i + 0, (float)(j + 1) + 0.021875F, (float)k + 0.015625F, d5, d6);
                tessellator.addVertexWithUV(i + 0, j + 0, (float)k + 0.015625F, d4, d6);
                tessellator.setColorOpaque_F(f, f, f);
                tessellator.addVertexWithUV(i + 1, j + 0, (float)k + 0.015625F, d4, d7 + 0.0625D);
                tessellator.addVertexWithUV(i + 1, (float)(j + 1) + 0.021875F, (float)k + 0.015625F, d5, d7 + 0.0625D);
                tessellator.addVertexWithUV(i + 0, (float)(j + 1) + 0.021875F, (float)k + 0.015625F, d5, d6 + 0.0625D);
                tessellator.addVertexWithUV(i + 0, j + 0, (float)k + 0.015625F, d4, d6 + 0.0625D);
            }
            if(blockAccess.isBlockNormalCube(i, j, k + 1) && blockAccess.getBlockId(i, j + 1, k + 1) == Block.redstoneWire.blockID)
            {
                tessellator.setColorOpaque_F(f * f1, f * f2, f * f3);
                tessellator.addVertexWithUV(i + 1, (float)(j + 1) + 0.021875F, (float)(k + 1) - 0.015625F, d5, d6);
                tessellator.addVertexWithUV(i + 1, j + 0, (float)(k + 1) - 0.015625F, d4, d6);
                tessellator.addVertexWithUV(i + 0, j + 0, (float)(k + 1) - 0.015625F, d4, d7);
                tessellator.addVertexWithUV(i + 0, (float)(j + 1) + 0.021875F, (float)(k + 1) - 0.015625F, d5, d7);
                tessellator.setColorOpaque_F(f, f, f);
                tessellator.addVertexWithUV(i + 1, (float)(j + 1) + 0.021875F, (float)(k + 1) - 0.015625F, d5, d6 + 0.0625D);
                tessellator.addVertexWithUV(i + 1, j + 0, (float)(k + 1) - 0.015625F, d4, d6 + 0.0625D);
                tessellator.addVertexWithUV(i + 0, j + 0, (float)(k + 1) - 0.015625F, d4, d7 + 0.0625D);
                tessellator.addVertexWithUV(i + 0, (float)(j + 1) + 0.021875F, (float)(k + 1) - 0.015625F, d5, d7 + 0.0625D);
            }
        }
        return true;
    }

    public boolean renderBlockMinecartTrack(BlockRail blockrail, int i, int j, int k)
    {
        Tessellator tessellator = Tessellator.instance;
        int l = blockAccess.getBlockMetadata(i, j, k);
        int i1 = blockrail.getBlockTextureFromSideAndMetadata(0, l);
        if(overrideBlockTexture >= 0)
        {
            i1 = overrideBlockTexture;
        }
        if(blockrail.getIsPowered())
        {
            l &= 7;
        }
        float f = 1.0F;
        tessellator.setBrightness(blockrail.getRenderBrightness(blockAccess, i, j, k));
        tessellator.setColorOpaque_F(f, f, f);
        int j1 = (i1 & 0xf) << 4;
        int k1 = i1 & 0xf0;
        double d = (float)j1 / 256F;
        double d1 = ((float)j1 + 16F) / 256F;
        double d2 = (float)k1 / 256F;
        double d3 = ((float)k1 + 16F) / 256F;
        float f1 = 0.0625F;
        float f2 = i + 1;
        float f3 = i + 1;
        float f4 = i + 0;
        float f5 = i + 0;
        float f6 = k + 0;
        float f7 = k + 1;
        float f8 = k + 1;
        float f9 = k + 0;
        float f10 = (float)j + f1;
        float f11 = (float)j + f1;
        float f12 = (float)j + f1;
        float f13 = (float)j + f1;
        if(l == 1 || l == 2 || l == 3 || l == 7)
        {
            f2 = f5 = i + 1;
            f3 = f4 = i + 0;
            f6 = f7 = k + 1;
            f8 = f9 = k + 0;
        } else
        if(l == 8)
        {
            f2 = f3 = i + 0;
            f4 = f5 = i + 1;
            f6 = f9 = k + 1;
            f7 = f8 = k + 0;
        } else
        if(l == 9)
        {
            f2 = f5 = i + 0;
            f3 = f4 = i + 1;
            f6 = f7 = k + 0;
            f8 = f9 = k + 1;
        }
        if(l == 2 || l == 4)
        {
            f10++;
            f13++;
        } else
        if(l == 3 || l == 5)
        {
            f11++;
            f12++;
        }
        tessellator.addVertexWithUV(f2, f10, f6, d1, d2);
        tessellator.addVertexWithUV(f3, f11, f7, d1, d3);
        tessellator.addVertexWithUV(f4, f12, f8, d, d3);
        tessellator.addVertexWithUV(f5, f13, f9, d, d2);

        tessellator.addVertexWithUV(f5, f13, f9, d, d2);
        tessellator.addVertexWithUV(f4, f12, f8, d, d3);
        tessellator.addVertexWithUV(f3, f11, f7, d1, d3);
        tessellator.addVertexWithUV(f2, f10, f6, d1, d2);
        return true;
    }

    public boolean renderBlockLadder(Block block, int i, int j, int k)
    {
        Tessellator tessellator = Tessellator.instance;
        int l = block.getBlockTextureFromSide(0);
        if(overrideBlockTexture >= 0)
        {
            l = overrideBlockTexture;
        }
        float f = 1.0F;
        tessellator.setBrightness(block.getRenderBrightness(blockAccess, i, j, k));
        tessellator.setColorOpaque_F(f, f, f);
        int i1 = (l & 0xf) << 4;
        int j1 = l & 0xf0;
        double d = (float)i1 / 256F;
        double d1 = ((float)i1 + 16F) / 256F;
        double d2 = (float)j1 / 256F;
        double d3 = ((float)j1 + 16F) / 256F;
        int k1 = blockAccess.getBlockMetadata(i, j, k) & 7;
        float f1 = 0.0F;
        float f2 = 0.05F;
        if(k1 == 5)
        {
            tessellator.addVertexWithUV((float)i + f2, (float)(j + 1) + f1, (float)(k + 1) + f1, d, d2);
            tessellator.addVertexWithUV((float)i + f2, (float)(j + 0) - f1, (float)(k + 1) + f1, d, d3);
            tessellator.addVertexWithUV((float)i + f2, (float)(j + 0) - f1, (float)(k + 0) - f1, d1, d3);
            tessellator.addVertexWithUV((float)i + f2, (float)(j + 1) + f1, (float)(k + 0) - f1, d1, d2);
        }
        if(k1 == 4)
        {
            tessellator.addVertexWithUV((float)(i + 1) - f2, (float)(j + 0) - f1, (float)(k + 1) + f1, d1, d3);
            tessellator.addVertexWithUV((float)(i + 1) - f2, (float)(j + 1) + f1, (float)(k + 1) + f1, d1, d2);
            tessellator.addVertexWithUV((float)(i + 1) - f2, (float)(j + 1) + f1, (float)(k + 0) - f1, d, d2);
            tessellator.addVertexWithUV((float)(i + 1) - f2, (float)(j + 0) - f1, (float)(k + 0) - f1, d, d3);
        }
        if(k1 == 3)
        {
            tessellator.addVertexWithUV((float)(i + 1) + f1, (float)(j + 0) - f1, (float)k + f2, d1, d3);
            tessellator.addVertexWithUV((float)(i + 1) + f1, (float)(j + 1) + f1, (float)k + f2, d1, d2);
            tessellator.addVertexWithUV((float)(i + 0) - f1, (float)(j + 1) + f1, (float)k + f2, d, d2);
            tessellator.addVertexWithUV((float)(i + 0) - f1, (float)(j + 0) - f1, (float)k + f2, d, d3);
        }
        if(k1 == 2)
        {
            tessellator.addVertexWithUV((float)(i + 1) + f1, (float)(j + 1) + f1, (float)(k + 1) - f2, d, d2);
            tessellator.addVertexWithUV((float)(i + 1) + f1, (float)(j + 0) - f1, (float)(k + 1) - f2, d, d3);
            tessellator.addVertexWithUV((float)(i + 0) - f1, (float)(j + 0) - f1, (float)(k + 1) - f2, d1, d3);
            tessellator.addVertexWithUV((float)(i + 0) - f1, (float)(j + 1) + f1, (float)(k + 1) - f2, d1, d2);
        }
        if(block instanceof BlockRopeLadder)
        {
            if(k1 == 5)
            {
                tessellator.addVertexWithUV((float)i + f2, (float)(j + 0) - f1, (float)(k + 1) + f1, d, d3);
                tessellator.addVertexWithUV((float)i + f2, (float)(j + 1) + f1, (float)(k + 1) + f1, d, d2);
                tessellator.addVertexWithUV((float)i + f2, (float)(j + 1) + f1, (float)(k + 0) - f1, d1, d2);
                tessellator.addVertexWithUV((float)i + f2, (float)(j + 0) - f1, (float)(k + 0) - f1, d1, d3);
            }
            if(k1 == 4)
            {
                tessellator.addVertexWithUV((float)(i + 1) - f2, (float)(j + 1) + f1, (float)(k + 1) + f1, d1, d2);
                tessellator.addVertexWithUV((float)(i + 1) - f2, (float)(j + 0) - f1, (float)(k + 1) + f1, d1, d3);
                tessellator.addVertexWithUV((float)(i + 1) - f2, (float)(j + 0) - f1, (float)(k + 0) - f1, d, d3);
                tessellator.addVertexWithUV((float)(i + 1) - f2, (float)(j + 1) + f1, (float)(k + 0) - f1, d, d2);
            }
            if(k1 == 3)
            {
                tessellator.addVertexWithUV((float)(i + 1) + f1, (float)(j + 1) + f1, (float)k + f2, d1, d2);
                tessellator.addVertexWithUV((float)(i + 1) + f1, (float)(j + 0) - f1, (float)k + f2, d1, d3);
                tessellator.addVertexWithUV((float)(i + 0) - f1, (float)(j + 0) - f1, (float)k + f2, d, d3);
                tessellator.addVertexWithUV((float)(i + 0) - f1, (float)(j + 1) + f1, (float)k + f2, d, d2);
            }
            if(k1 == 2)
            {
                tessellator.addVertexWithUV((float)(i + 1) + f1, (float)(j + 0) - f1, (float)(k + 1) - f2, d, d3);
                tessellator.addVertexWithUV((float)(i + 1) + f1, (float)(j + 1) + f1, (float)(k + 1) - f2, d, d2);
                tessellator.addVertexWithUV((float)(i + 0) - f1, (float)(j + 1) + f1, (float)(k + 1) - f2, d1, d2);
                tessellator.addVertexWithUV((float)(i + 0) - f1, (float)(j + 0) - f1, (float)(k + 1) - f2, d1, d3);
            }
        }
        return true;
    }

    public boolean renderBlockReed(Block block, int i, int j, int k)
    {
        Tessellator tessellator = Tessellator.instance;
        int i1 = block.getRenderBrightness(blockAccess, i, j, k);
        int l = block.colorMultiplier(blockAccess, i, j, k);
        float f1 = (float)(l >> 16 & 0xff) / 255F;
        float f2 = (float)(l >> 8 & 0xff) / 255F;
        float f3 = (float)(l & 0xff) / 255F;
        if(EntityRenderer.anaglyphEnabled)
        {
            float f4 = (f1 * 30F + f2 * 59F + f3 * 11F) / 100F;
            float f5 = (f1 * 30F + f2 * 70F) / 100F;
            float f6 = (f1 * 30F + f3 * 70F) / 100F;
            f1 = f4;
            f2 = f5;
            f3 = f6;
        }
        tessellator.setBrightness(i1);
        tessellator.setColorOpaque_F(f1, f2, f3);
        double d = i;
        double d1 = j;
        double d2 = k;
        if(block == Block.tallGrass || block == BEBlocks.berryBush)
        {
            long l1 = (long)(i * 0x2fc20f) ^ (long)k * 0x6ebfff5L ^ (long)j;
            l1 = l1 * l1 * 0x285b825L + l1 * 11L;
            d += ((double)((float)(l1 >> 16 & 15L) / 15F) - 0.5D) * 0.5D;
            d1 += ((double)((float)(l1 >> 20 & 15L) / 15F) - 1.0D) * 0.20000000000000001D;
            d2 += ((double)((float)(l1 >> 24 & 15L) / 15F) - 0.5D) * 0.5D;
        }
        renderCrossedSquares(block, blockAccess.getBlockMetadata(i, j, k), d, d1, d2, false);
        return true;
    }

    public boolean renderBlockCrops(Block block, int i, int j, int k)
    {
        Tessellator tessellator = Tessellator.instance;
        int i1 = block.getRenderBrightness(blockAccess, i, j, k);
        tessellator.setBrightness(i1);
        renderBlockCrops_do(block, blockAccess.getBlockMetadata(i, j, k), i, (double)j - 0.0625D, k, false);
        return true;
    }

    public void renderTorchAtAngle(Block block, double d, double d1, double d2, 
            double d3, double d4, boolean flag)
    {
        Tessellator tessellator = Tessellator.instance;
        int i = block.getBlockTextureFromSide(0);
        if(overrideBlockTexture >= 0)
        {
            i = overrideBlockTexture;
        }
        int j = (i & 0xf) << 4;
        int k = i & 0xf0;
        float f = (float)j / 256F;
        float f1 = ((float)j + 15.999F) / 256F;
        float f2 = (float)k / 256F;
        float f3 = ((float)k + 15.999F) / 256F;
        double d5 = (double)f + 0.02734375D;
        double d6 = (double)f2 + 0.0234375D;
        double d7 = (double)f + 0.03515625D;
        double d8 = (double)f2 + 0.03125D;
        d += 0.5D;
        d2 += 0.5D;
        double d9 = d - 0.5D;
        double d10 = d + 0.5D;
        double d11 = d2 - 0.5D;
        double d12 = d2 + 0.5D;
        double d13 = 0.0625D;
        double d14 = 0.625D;
        tessellator.addVertexWithUV((d + d3 * (1.0D - d14)) - d13, d1 + d14, (d2 + d4 * (1.0D - d14)) - d13, d5, d6);
        tessellator.addVertexWithUV((d + d3 * (1.0D - d14)) - d13, d1 + d14, d2 + d4 * (1.0D - d14) + d13, d5, d8);
        tessellator.addVertexWithUV(d + d3 * (1.0D - d14) + d13, d1 + d14, d2 + d4 * (1.0D - d14) + d13, d7, d8);
        tessellator.addVertexWithUV(d + d3 * (1.0D - d14) + d13, d1 + d14, (d2 + d4 * (1.0D - d14)) - d13, d7, d6);
        tessellator.addVertexWithUV(d - d13, d1 + 1.0D, d11, f, f2);
        tessellator.addVertexWithUV((d - d13) + d3, d1 + 0.0D, d11 + d4, f, f3);
        tessellator.addVertexWithUV((d - d13) + d3, d1 + 0.0D, d12 + d4, f1, f3);
        tessellator.addVertexWithUV(d - d13, d1 + 1.0D, d12, f1, f2);
        tessellator.addVertexWithUV(d + d13, d1 + 1.0D, d12, f, f2);
        tessellator.addVertexWithUV(d + d3 + d13, d1 + 0.0D, d12 + d4, f, f3);
        tessellator.addVertexWithUV(d + d3 + d13, d1 + 0.0D, d11 + d4, f1, f3);
        tessellator.addVertexWithUV(d + d13, d1 + 1.0D, d11, f1, f2);
        tessellator.addVertexWithUV(d9, d1 + 1.0D, d2 + d13, f, f2);
        tessellator.addVertexWithUV(d9 + d3, d1 + 0.0D, d2 + d13 + d4, f, f3);
        tessellator.addVertexWithUV(d10 + d3, d1 + 0.0D, d2 + d13 + d4, f1, f3);
        tessellator.addVertexWithUV(d10, d1 + 1.0D, d2 + d13, f1, f2);
        tessellator.addVertexWithUV(d10, d1 + 1.0D, d2 - d13, f, f2);
        tessellator.addVertexWithUV(d10 + d3, d1 + 0.0D, (d2 - d13) + d4, f, f3);
        tessellator.addVertexWithUV(d9 + d3, d1 + 0.0D, (d2 - d13) + d4, f1, f3);
        tessellator.addVertexWithUV(d9, d1 + 1.0D, d2 - d13, f1, f2);
        tessellator.addVertexWithUV(d + d3 + d13, d1, d11 + d4, f, f3);
        tessellator.addVertexWithUV(d + d3 + d13, d1, d12 + d4, f1, f3);
        tessellator.addVertexWithUV((d - d13) + d3, d1, d12 + d4, f1, f3);
        tessellator.addVertexWithUV((d - d13) + d3, d1, d11 + d4, f, f3);
    }

    public void renderCrossedSquares(Block block, int i, double d, double d1, double d2, boolean flag)
    {
        Tessellator tessellator = Tessellator.instance;
        int j = block.getBlockTextureFromSideAndMetadata(0, i);
        if(overrideBlockTexture >= 0)
        {
            j = overrideBlockTexture;
        }
        int k = (j & 0xf) << 4;
        int l = j & 0xf0;
        double d3 = (float)k / 256F;
        double d4 = ((float)k + 16F) / 256F;
        double d5 = (float)l / 256F;
        double d6 = ((float)l + 16F) / 256F;
        double d7 = (d + 0.5D) - 0.44999998807907104D;
        double d8 = d + 0.5D + 0.44999998807907104D;
        double d9 = (d2 + 0.5D) - 0.44999998807907104D;
        double d10 = d2 + 0.5D + 0.44999998807907104D;
        tessellator.addVertexWithUV(d7, d1 + 1.0D, d9, d3, d5);
        tessellator.addVertexWithUV(d7, d1 + 0.0D, d9, d3, d6);
        tessellator.addVertexWithUV(d8, d1 + 0.0D, d10, d4, d6);
        tessellator.addVertexWithUV(d8, d1 + 1.0D, d10, d4, d5);
        tessellator.addVertexWithUV(d8, d1 + 1.0D, d10, d3, d5);
        tessellator.addVertexWithUV(d8, d1 + 0.0D, d10, d3, d6);
        tessellator.addVertexWithUV(d7, d1 + 0.0D, d9, d4, d6);
        tessellator.addVertexWithUV(d7, d1 + 1.0D, d9, d4, d5);
        tessellator.addVertexWithUV(d7, d1 + 1.0D, d10, d3, d5);
        tessellator.addVertexWithUV(d7, d1 + 0.0D, d10, d3, d6);
        tessellator.addVertexWithUV(d8, d1 + 0.0D, d9, d4, d6);
        tessellator.addVertexWithUV(d8, d1 + 1.0D, d9, d4, d5);
        tessellator.addVertexWithUV(d8, d1 + 1.0D, d9, d3, d5);
        tessellator.addVertexWithUV(d8, d1 + 0.0D, d9, d3, d6);
        tessellator.addVertexWithUV(d7, d1 + 0.0D, d10, d4, d6);
        tessellator.addVertexWithUV(d7, d1 + 1.0D, d10, d4, d5);
    }

    public void renderBlockCrops_do(Block block, int i, double d, double d1, double d2, boolean flag)
    {
        Tessellator tessellator = Tessellator.instance;
        int j = block.getBlockTextureFromSideAndMetadata(0, i);
        if(overrideBlockTexture >= 0)
        {
            j = overrideBlockTexture;
        }
        int k = (j & 0xf) << 4;
        int l = j & 0xf0;
        double d3 = (float)k / 256F;
        double d4 = ((float)k + 16F) / 256F;
        double d5 = (float)l / 256F;
        double d6 = ((float)l + 16F) / 256F;
        double d7 = (d + 0.5D) - 0.25D;
        double d8 = d + 0.5D + 0.25D;
        double d9 = (d2 + 0.5D) - 0.5D;
        double d10 = d2 + 0.5D + 0.5D;
        tessellator.addVertexWithUV(d7, d1 + 1.0D, d9, d3, d5);
        tessellator.addVertexWithUV(d7, d1 + 0.0D, d9, d3, d6);
        tessellator.addVertexWithUV(d7, d1 + 0.0D, d10, d4, d6);
        tessellator.addVertexWithUV(d7, d1 + 1.0D, d10, d4, d5);
        tessellator.addVertexWithUV(d7, d1 + 1.0D, d10, d3, d5);
        tessellator.addVertexWithUV(d7, d1 + 0.0D, d10, d3, d6);
        tessellator.addVertexWithUV(d7, d1 + 0.0D, d9, d4, d6);
        tessellator.addVertexWithUV(d7, d1 + 1.0D, d9, d4, d5);
        tessellator.addVertexWithUV(d8, d1 + 1.0D, d10, d3, d5);
        tessellator.addVertexWithUV(d8, d1 + 0.0D, d10, d3, d6);
        tessellator.addVertexWithUV(d8, d1 + 0.0D, d9, d4, d6);
        tessellator.addVertexWithUV(d8, d1 + 1.0D, d9, d4, d5);
        tessellator.addVertexWithUV(d8, d1 + 1.0D, d9, d3, d5);
        tessellator.addVertexWithUV(d8, d1 + 0.0D, d9, d3, d6);
        tessellator.addVertexWithUV(d8, d1 + 0.0D, d10, d4, d6);
        tessellator.addVertexWithUV(d8, d1 + 1.0D, d10, d4, d5);
        d7 = (d + 0.5D) - 0.5D;
        d8 = d + 0.5D + 0.5D;
        d9 = (d2 + 0.5D) - 0.25D;
        d10 = d2 + 0.5D + 0.25D;
        tessellator.addVertexWithUV(d7, d1 + 1.0D, d9, d3, d5);
        tessellator.addVertexWithUV(d7, d1 + 0.0D, d9, d3, d6);
        tessellator.addVertexWithUV(d8, d1 + 0.0D, d9, d4, d6);
        tessellator.addVertexWithUV(d8, d1 + 1.0D, d9, d4, d5);
        tessellator.addVertexWithUV(d8, d1 + 1.0D, d9, d3, d5);
        tessellator.addVertexWithUV(d8, d1 + 0.0D, d9, d3, d6);
        tessellator.addVertexWithUV(d7, d1 + 0.0D, d9, d4, d6);
        tessellator.addVertexWithUV(d7, d1 + 1.0D, d9, d4, d5);
        tessellator.addVertexWithUV(d8, d1 + 1.0D, d10, d3, d5);
        tessellator.addVertexWithUV(d8, d1 + 0.0D, d10, d3, d6);
        tessellator.addVertexWithUV(d7, d1 + 0.0D, d10, d4, d6);
        tessellator.addVertexWithUV(d7, d1 + 1.0D, d10, d4, d5);
        tessellator.addVertexWithUV(d7, d1 + 1.0D, d10, d3, d5);
        tessellator.addVertexWithUV(d7, d1 + 0.0D, d10, d3, d6);
        tessellator.addVertexWithUV(d8, d1 + 0.0D, d10, d4, d6);
        tessellator.addVertexWithUV(d8, d1 + 1.0D, d10, d4, d5);
    }

    public boolean renderBlockFluids(Block block, int i, int j, int k)
    {
    	float texOffset = (Integer)mc.renderEngine.textureSizeIdMap.get(mc.renderEngine.getTexture("/terrain.png"))/16;
        Tessellator tessellator = Tessellator.instance;
        int l = block.colorMultiplier(blockAccess, i, j, k);
        float f = (float)(l >> 16 & 0xff) / 255F;
        float f1 = (float)(l >> 8 & 0xff) / 255F;
        float f2 = (float)(l & 0xff) / 255F;
        if((block == Block.waterMoving || block == Block.waterStill) && mc.theWorld.worldInfo.getSeason() != -1)
        {
            Chunk chunk = mc.theWorld.getChunkFromBlockCoords(i, k);
            int l1 = waterColors[mc.theWorld.worldInfo.getSeason()];
            int l3 = waterColors[(mc.theWorld.worldInfo.getSeason()+1)%4];
            float f3 = (float)(l1 >> 16 & 0xff) / 255F;
            float f4 = (float)(l1 >> 8 & 0xff) / 255F;
            float f5 = (float)(l1 & 0xff) / 255F;
            float f6 = (float)(l3 >> 16 & 0xff) / 255F;
            float f7 = (float)(l3 >> 8 & 0xff) / 255F;
            float f8 = (float)(l3 & 0xff) / 255F;
            f3  = mod_BetaExpansion.lerp(avg, f3, f6);
            f4  = mod_BetaExpansion.lerp(avg, f4, f7);
            f5  = mod_BetaExpansion.lerp(avg, f5, f8);
            float l2 = ((float)chunk.getSavedLightValue(EnumSkyBlock.Sky, i & 0xf, j, k & 0xf)/15F) * 1.7f - 0.7f;
            f  = mod_BetaExpansion.lerp(l2, f, f3);
            f1  = mod_BetaExpansion.lerp(l2, f1, f4);
            f2  = mod_BetaExpansion.lerp(l2, f2, f5);
        }
        boolean flag = block.shouldSideBeRendered(blockAccess, i, j + 1, k, 1);
        boolean flag1 = block.shouldSideBeRendered(blockAccess, i, j - 1, k, 0);
        boolean aflag[] = new boolean[4];
        aflag[0] = block.shouldSideBeRendered(blockAccess, i, j, k - 1, 2);
        aflag[1] = block.shouldSideBeRendered(blockAccess, i, j, k + 1, 3);
        aflag[2] = block.shouldSideBeRendered(blockAccess, i - 1, j, k, 4);
        aflag[3] = block.shouldSideBeRendered(blockAccess, i + 1, j, k, 5);
        if(!flag && !flag1 && !aflag[0] && !aflag[1] && !aflag[2] && !aflag[3])
        {
            return false;
        }
        boolean flag2 = false;
        float f3 = 0.5F;
        float f4 = 1.0F;
        float f5 = 0.8F;
        float f6 = 0.6F;
        double d = 0.0D;
        double d1 = 1.0D;
        Material material = block.blockMaterial;
        int i1 = blockAccess.getBlockMetadata(i, j, k);
        float f7 = getFluidHeight(i, j, k, material);
        float f8 = getFluidHeight(i, j, k + 1, material);
        float f9 = getFluidHeight(i + 1, j, k + 1, material);
        float f10 = getFluidHeight(i + 1, j, k, material);
        float x = 1;
        if(!((block == Block.waterStill && (mc.renderEngine.waterTexture == null || mc.renderEngine.waterTexture.isCustom)) || 
        	 (block == Block.waterMoving && (mc.renderEngine.waterFlowTexture == null || mc.renderEngine.waterFlowTexture.isCustom)) ||
        	 (block == Block.lavaStill && (mc.renderEngine.lavaTexture == null || mc.renderEngine.lavaTexture.isCustom)) ||
        	 (block == Block.lavaMoving && (mc.renderEngine.lavaFlowTexture == null || mc.renderEngine.lavaFlowTexture.isCustom))))
        {
        	x = (texOffset/16);
        }
        if(renderAllFaces || flag)
        {
            flag2 = true;
            int j1 = block.getBlockTextureFromSideAndMetadata(1, i1);
            float f12 = (float)BlockFluid.func_293_a(blockAccess, i, j, k, material);
            if(f12 > -999F)
            {
                j1 = block.getBlockTextureFromSideAndMetadata(2, i1);
            }
            int i2 = (j1 & 0xf) << 4;
            int k2 = j1 & 0xf0;
            double d2 = ((double)i2 + 8D) / 256D;
            double d3 = ((double)k2 + 8D) / 256D;
            d2 = ((double)i2 + (8F/x)) / 256D;
            d3 = ((double)k2 + (8F/x)) / 256D;
            if(f12 < -999F)
            {
                f12 = 0.0F;
            } else
            {
                d2 = (float)(i2 + (16F/x)) / 256F;
                d3 = (float)(k2 + (16F/x)) / 256F;
            }
            float f14 = (MathHelper.sin(f12) * (8F/x)) / 256F;
            float f16 = (MathHelper.cos(f12) * (8F/x)) / 256F;
            int n0 = block.getRenderBrightness(blockAccess, i, j + 1, k);
            tessellator.setBrightness(n0);
            tessellator.setColorOpaque_F(f4 * f, f4 * f1, f4 * f2);
            tessellator.addVertexWithUV(i + 0, (float)j + f7, k + 0, d2 - (double)f16 - (double)f14, (d3 - (double)f16) + (double)f14);
            tessellator.addVertexWithUV(i + 0, (float)j + f8, k + 1, (d2 - (double)f16) + (double)f14, d3 + (double)f16 + (double)f14);
            tessellator.addVertexWithUV(i + 1, (float)j + f9, k + 1, d2 + (double)f16 + (double)f14, (d3 + (double)f16) - (double)f14);
            tessellator.addVertexWithUV(i + 1, (float)j + f10, k + 0, (d2 + (double)f16) - (double)f14, d3 - (double)f16 - (double)f14);
        }
        if(renderAllFaces || flag1)
        {
            int n0 = block.getRenderBrightness(blockAccess, i, j - 1, k);
            tessellator.setBrightness(n0);
            tessellator.setColorOpaque_F(f3, f3, f3);
            renderBottomFace(block, i, j, k, block.getBlockTextureFromSide(0));
            flag2 = true;
        }
        for(int k1 = 0; k1 < 4; k1++)
        {
            int l1 = i;
            int j2 = j;
            int l2 = k;
            if(k1 == 0)
            {
                l2--;
            }
            if(k1 == 1)
            {
                l2++;
            }
            if(k1 == 2)
            {
                l1--;
            }
            if(k1 == 3)
            {
                l1++;
            }
            int i3 = block.getBlockTextureFromSideAndMetadata(k1 + 2, i1);
            int j3 = (i3 & 0xf) << 4;
            int k3 = i3 & 0xf0;
            if(renderAllFaces || aflag[k1])
            {
                float f13;
                float f15;
                float f17;
                float f19;
                float f20;
                float f21;
                if(k1 == 0)
                {
                    f13 = f7;
                    f15 = f10;
                    f17 = i;
                    f20 = i + 1;
                    f19 = k;
                    f21 = k;
                } else
                if(k1 == 1)
                {
                    f13 = f9;
                    f15 = f8;
                    f17 = i + 1;
                    f20 = i;
                    f19 = k + 1;
                    f21 = k + 1;
                } else
                if(k1 == 2)
                {
                    f13 = f8;
                    f15 = f7;
                    f17 = i;
                    f20 = i;
                    f19 = k + 1;
                    f21 = k;
                } else
                {
                    f13 = f10;
                    f15 = f9;
                    f17 = i + 1;
                    f20 = i + 1;
                    f19 = k;
                    f21 = k + 1;
                }
                flag2 = true;
                double d4 = (float)(j3) / 256F;
                double d5 = (double)(j3 + (16F/x)) / 256D;
                double d6 = ((float)(k3) +(1.0F - f13) * (16F/x)) / 256F;
                double d7 = ((float)(k3) +(1.0F - f15) * (16F/x)) / 256F;
                double d8 = (double)(k3 + (16F/x)) / 256D;
                tessellator.setBrightness(block.getRenderBrightness(blockAccess, l1, j2, l2));
                float f22 = 1.0F;
                if(k1 < 2)
                {
                    f22 *= f5;
                } else
                {
                    f22 *= f6;
                }
                tessellator.setColorOpaque_F(f4 * f22 * f, f4 * f22 * f1, f4 * f22 * f2);
                tessellator.addVertexWithUV(f17, (float)j + f13, f19, d4, d6);
                tessellator.addVertexWithUV(f20, (float)j + f15, f21, d5, d7);
                tessellator.addVertexWithUV(f20, j + 0, f21, d5, d8);
                tessellator.addVertexWithUV(f17, j + 0, f19, d4, d8);
            }
        }

        block.minY = d;
        block.maxY = d1;
        return flag2;
    }

    public float getFluidHeight(int i, int j, int k, Material material)
    {
        int l = 0;
        float f = 0.0F;
        for(int i1 = 0; i1 < 4; i1++)
        {
            int j1 = i - (i1 & 1);
            int k1 = j;
            int l1 = k - (i1 >> 1 & 1);
            if(blockAccess.getBlockMaterial(j1, k1 + 1, l1) == material)
            {
                return 1.0F;
            }
            Material material1 = blockAccess.getBlockMaterial(j1, k1, l1);
            if(material1 == material)
            {
                int i2 = blockAccess.getBlockMetadata(j1, k1, l1);
                if(i2 >= 8 || i2 == 0)
                {
                    f += BlockFluid.getPercentAir(i2) * 10F;
                    l += 10;
                }
                f += BlockFluid.getPercentAir(i2);
                l++;
            } else
            if(!material1.isSolid())
            {
                f++;
                l++;
            }
        }

        return 1.0F - f / (float)l;
    }

    public void renderBlockFallingSand(Block block, World world, int i, int j, int k)
    {
        float f = 0.5F;
        float f1 = 1.0F;
        float f2 = 0.8F;
        float f3 = 0.6F;
        Tessellator tessellator = Tessellator.instance;
        tessellator.startDrawingQuads();
        tessellator.setBrightness(block.getRenderBrightness(world, i, j, k));
        tessellator.setColorOpaque_F(f, f, f);
        renderBottomFace(block, -0.5D, -0.5D, -0.5D, block.getBlockTextureFromSide(0));
        tessellator.setColorOpaque_F(f1, f1, f1);
        renderTopFace(block, -0.5D, -0.5D, -0.5D, block.getBlockTextureFromSide(1));
        tessellator.setColorOpaque_F(f2, f2, f2);
        renderEastFace(block, -0.5D, -0.5D, -0.5D, block.getBlockTextureFromSide(2));
        renderWestFace(block, -0.5D, -0.5D, -0.5D, block.getBlockTextureFromSide(3));
        tessellator.setColorOpaque_F(f3, f3, f3);
        renderNorthFace(block, -0.5D, -0.5D, -0.5D, block.getBlockTextureFromSide(4));
        renderSouthFace(block, -0.5D, -0.5D, -0.5D, block.getBlockTextureFromSide(5));
        tessellator.draw();
    }

    public boolean renderStandardBlock(Block block, int i, int j, int k)
    {
        int l = block.colorMultiplier(blockAccess, i, j, k);
        float f = (float)(l >> 16 & 0xff) / 255F;
        float f1 = (float)(l >> 8 & 0xff) / 255F;
        float f2 = (float)(l & 0xff) / 255F;
        if(EntityRenderer.anaglyphEnabled)
        {
            float f3 = (f * 30F + f1 * 59F + f2 * 11F) / 100F;
            float f4 = (f * 30F + f1 * 70F) / 100F;
            float f5 = (f * 30F + f2 * 70F) / 100F;
            f = f3;
            f1 = f4;
            f2 = f5;
        }
    	if(block == Block.wood)
    	{
    		setTextureOrientation(true,blockAccess.getBlockMetadata(i, j, k));
    	}
        if(Minecraft.isAmbientOcclusionEnabled() && Block.lightValue[block.blockID] == 0)
        {
            return renderStandardBlockWithAmbientOcclusion(block, i, j, k, f, f1, f2);
        } else
        {
            return renderStandardBlockWithColorMultiplier(block, i, j, k, f, f1, f2);
        }
    }
    
    public boolean renderStandardBlockWithAmbientOcclusion(Block block, int i, int j, int k, float f, float f1, float f2)
    {
        enableAO = true;
        boolean flag = false;
        boolean flag1 = true;
        boolean flag2 = true;
        boolean flag3 = true;
        boolean flag4 = true;
        boolean flag5 = true;
        boolean flag6 = true;
        aoLightValueXNeg = block.getAOBrightness(blockAccess, i - 1, j, k);
        aoLightValueYNeg = block.getAOBrightness(blockAccess, i, j - 1, k);
        aoLightValueZNeg = block.getAOBrightness(blockAccess, i, j, k - 1);
        aoLightValueXPos = block.getAOBrightness(blockAccess, i + 1, j, k);
        aoLightValueYPos = block.getAOBrightness(blockAccess, i, j + 1, k);
        aoLightValueZPos = block.getAOBrightness(blockAccess, i, j, k + 1);
        int n0 = block.getRenderBrightness(blockAccess, i - 1, j, k);
        int n1 = block.getRenderBrightness(blockAccess, i, j - 1, k);
        int n2 = block.getRenderBrightness(blockAccess, i, j, k - 1);
        int n3 = block.getRenderBrightness(blockAccess, i + 1, j, k);
        int n4 = block.getRenderBrightness(blockAccess, i, j + 1, k);
        int n5 = block.getRenderBrightness(blockAccess, i, j, k + 1);
        field_22338_U = mod_BetaExpansion.canBlockGrass[blockAccess.getBlockId(i + 1, j + 1, k)];
        field_22359_ac = mod_BetaExpansion.canBlockGrass[blockAccess.getBlockId(i + 1, j - 1, k)];
        field_22334_Y = mod_BetaExpansion.canBlockGrass[blockAccess.getBlockId(i + 1, j, k + 1)];
        field_22363_aa = mod_BetaExpansion.canBlockGrass[blockAccess.getBlockId(i + 1, j, k - 1)];
        field_22337_V = mod_BetaExpansion.canBlockGrass[blockAccess.getBlockId(i - 1, j + 1, k)];
        field_22357_ad = mod_BetaExpansion.canBlockGrass[blockAccess.getBlockId(i - 1, j - 1, k)];
        field_22335_X = mod_BetaExpansion.canBlockGrass[blockAccess.getBlockId(i - 1, j, k - 1)];
        field_22333_Z = mod_BetaExpansion.canBlockGrass[blockAccess.getBlockId(i - 1, j, k + 1)];
        field_22336_W = mod_BetaExpansion.canBlockGrass[blockAccess.getBlockId(i, j + 1, k + 1)];
        field_22339_T = mod_BetaExpansion.canBlockGrass[blockAccess.getBlockId(i, j + 1, k - 1)];
        field_22355_ae = mod_BetaExpansion.canBlockGrass[blockAccess.getBlockId(i, j - 1, k + 1)];
        field_22361_ab = mod_BetaExpansion.canBlockGrass[blockAccess.getBlockId(i, j - 1, k - 1)];
        if(block.blockIndexInTexture == 3)
        {
            flag1 = flag3 = flag4 = flag5 = flag6 = false;
        }
        if(overrideBlockTexture >= 0)
        {
            flag1 = flag3 = flag4 = flag5 = flag6 = false;
        }
        if(renderAllFaces || block.shouldSideBeRendered(blockAccess, i, j - 1, k, 0))
        {
            float f7;
            float f13;
            float f19;
            float f25;
            if(field_22352_G > 0)
            {
                j--;
                field_22376_n = block.getAOBrightness(blockAccess, i - 1, j, k);
                field_22374_p = block.getAOBrightness(blockAccess, i, j, k - 1);
                field_22373_q = block.getAOBrightness(blockAccess, i, j, k + 1);
                field_22371_s = block.getAOBrightness(blockAccess, i + 1, j, k);
                field_35935_Q = block.getRenderBrightness(blockAccess, i - 1, j, k);
                field_35937_S = block.getRenderBrightness(blockAccess, i, j, k - 1);
                field_35932_T = block.getRenderBrightness(blockAccess, i, j, k + 1);
                field_35934_V = block.getRenderBrightness(blockAccess, i + 1, j, k);
                if(field_22361_ab || field_22357_ad)
                {
                    field_22377_m = block.getAOBrightness(blockAccess, i - 1, j, k - 1);;
                    field_35936_P = block.getRenderBrightness(blockAccess, i - 1, j, k - 1);
                } else
                {
                    field_22377_m = field_22376_n;
                    field_35936_P = field_35935_Q;
                }
                if(field_22355_ae || field_22357_ad)
                {
                    field_22375_o = block.getAOBrightness(blockAccess, i - 1, j, k + 1);;
                    field_35938_R = block.getRenderBrightness(blockAccess, i - 1, j, k + 1);
                } else
                {
                    field_22375_o = field_22376_n;
                    field_35938_R = field_35935_Q;
                }
                if(field_22361_ab || field_22359_ac)
                {
                    field_22372_r = block.getAOBrightness(blockAccess, i + 1, j, k - 1);;
                    field_35931_U = block.getRenderBrightness(blockAccess, i + 1, j, k - 1);
                } else
                {
                    field_22372_r = field_22371_s;
                    field_35931_U = field_35934_V;
                }
                if(field_22355_ae || field_22359_ac)
                {
                    field_22370_t = block.getAOBrightness(blockAccess, i + 1, j, k + 1);;
                    field_35933_W = block.getRenderBrightness(blockAccess, i + 1, j, k + 1);
                } else
                {
                    field_22370_t = field_22371_s;
                    field_35933_W = field_35934_V;
                }
                j++;
                f7 = (field_22375_o + field_22376_n + field_22373_q + aoLightValueYNeg) / 4F;
                f25 = (field_22373_q + aoLightValueYNeg + field_22370_t + field_22371_s) / 4F;
                f19 = (aoLightValueYNeg + field_22374_p + field_22371_s + field_22372_r) / 4F;
                f13 = (field_22376_n + field_22377_m + aoLightValueYNeg + field_22374_p) / 4F;
                brightnessTopLeft = aoAverage(field_35938_R, field_35935_Q, field_35932_T, n1);
                brightnessTopRight = aoAverage(field_35932_T, field_35933_W, field_35934_V, n1);
                brightnessBottomRight = aoAverage(field_35937_S, field_35934_V, field_35931_U, n1);
                brightnessBottomLeft = aoAverage(field_35935_Q, field_35936_P, field_35937_S, n1);
            } else
            {
                f7 = f13 = f19 = f25 = aoLightValueYNeg;
            }
            setAOValues((flag1 ? f : 1.0F) * bottomFaceBrightness, (flag1 ? f1 : 1.0F) * bottomFaceBrightness, (flag1 ? f2 : 1.0F) * bottomFaceBrightness, f7, f13, f19, f25);
            renderBottomFace(block, i, j, k, block.getBlockTexture(blockAccess, i, j, k, 0));
            if(block == BEBlocks.appleLeaves)
            {
                setAOValues(bottomFaceBrightness, bottomFaceBrightness, bottomFaceBrightness, f7, f13, f19, f25);
                renderBottomFace(block, i, j, k, 37);
            }
            flag = true;
        }
        if(renderAllFaces || block.shouldSideBeRendered(blockAccess, i, j + 1, k, 1))
        {
            float f8;
            float f14;
            float f20;
            float f26;
            if(field_22352_G > 0)
            {
                j++;
                field_22368_v = block.getAOBrightness(blockAccess, i - 1, j, k);;
                field_22364_z = block.getAOBrightness(blockAccess, i + 1, j, k);;
                field_22366_x = block.getAOBrightness(blockAccess, i, j, k - 1);;
                field_22362_A = block.getAOBrightness(blockAccess, i, j, k + 1);;
                field_35939_Y = block.getRenderBrightness(blockAccess, i - 1, j, k);
                field_35949_ac = block.getRenderBrightness(blockAccess, i + 1, j, k);
                field_35951_aa = block.getRenderBrightness(blockAccess, i, j, k - 1);
                field_35950_ad = block.getRenderBrightness(blockAccess, i, j, k + 1);
                if(field_22339_T || field_22337_V)
                {
                    field_22369_u = block.getAOBrightness(blockAccess, i - 1, j, k - 1);;
                    field_35940_X = block.getRenderBrightness(blockAccess, i - 1, j, k - 1);
                } else
                {
                    field_22369_u = field_22368_v;
                    field_35940_X = field_35939_Y;
                }
                if(field_22339_T || field_22338_U)
                {
                    field_22365_y = block.getAOBrightness(blockAccess, i + 1, j, k - 1);;
                    field_35952_ab = block.getRenderBrightness(blockAccess, i + 1, j, k - 1);
                } else
                {
                    field_22365_y = field_22364_z;
                    field_35952_ab = field_35949_ac;
                }
                if(field_22336_W || field_22337_V)
                {
                    field_22367_w = block.getAOBrightness(blockAccess, i - 1, j, k + 1);;
                    field_35941_Z = block.getRenderBrightness(blockAccess, i - 1, j, k + 1);
                } else
                {
                    field_22367_w = field_22368_v;
                    field_35941_Z = field_35939_Y;
                }
                if(field_22336_W || field_22338_U)
                {
                    field_22360_B = block.getAOBrightness(blockAccess, i + 1, j, k + 1);;
                    field_35955_ae = block.getRenderBrightness(blockAccess, i + 1, j, k + 1);
                } else
                {
                    field_22360_B = field_22364_z;
                    field_35955_ae = field_35949_ac;
                }
                j--;
                f26 = (field_22367_w + field_22368_v + field_22362_A + aoLightValueYPos) / 4F;
                f8 = (field_22362_A + aoLightValueYPos + field_22360_B + field_22364_z) / 4F;
                f14 = (aoLightValueYPos + field_22366_x + field_22364_z + field_22365_y) / 4F;
                f20 = (field_22368_v + field_22369_u + aoLightValueYPos + field_22366_x) / 4F;
                brightnessTopRight = aoAverage(field_35941_Z, field_35939_Y, field_35950_ad, n4);
                brightnessTopLeft = aoAverage(field_35950_ad, field_35955_ae, field_35949_ac, n4);
                brightnessBottomLeft = aoAverage(field_35951_aa, field_35949_ac, field_35952_ab, n4);
                brightnessBottomRight = aoAverage(field_35939_Y, field_35940_X, field_35951_aa, n4);
            } else
            {
                f8 = f14 = f20 = f26 = aoLightValueYPos;
            }
            setAOValues(flag2 ? f : topFaceBrightness, flag2 ? f1 : topFaceBrightness, flag2 ? f2 : topFaceBrightness, f8, f14, f20, f26);
            int l = block.getBlockTexture(blockAccess, i, j, k, 1);
            renderTopFace(block, i, j, k, l);
            if(block == BEBlocks.appleLeaves)
            {
                setAOValues(topFaceBrightness, topFaceBrightness, topFaceBrightness, f8, f14, f20, f26);
                renderTopFace(block, i, j, k, 37);
            }
            flag = true;
        }
        if(renderAllFaces || block.shouldSideBeRendered(blockAccess, i, j, k - 1, 2))
        {
            float f9;
            float f15;
            float f21;
            float f27;
            if(field_22352_G > 0)
            {
                k--;
                field_22358_C = block.getAOBrightness(blockAccess, i - 1, j, k);
                field_22374_p = block.getAOBrightness(blockAccess, i, j - 1, k);
                field_22366_x = block.getAOBrightness(blockAccess, i, j + 1, k);
                field_22356_D = block.getAOBrightness(blockAccess, i + 1, j, k);
                field_35956_af = block.getRenderBrightness(blockAccess, i - 1, j, k);
                field_35937_S = block.getRenderBrightness(blockAccess, i, j - 1, k);
                field_35951_aa = block.getRenderBrightness(blockAccess, i, j + 1, k);
                field_35953_ag = block.getRenderBrightness(blockAccess, i + 1, j, k);
                if(field_22335_X || field_22361_ab)
                {
                    field_22377_m = block.getAOBrightness(blockAccess, i - 1, j - 1, k);
                    field_35936_P = block.getRenderBrightness(blockAccess, i - 1, j - 1, k);
                } else
                {
                    field_22377_m = field_22358_C;
                    field_35936_P = field_35956_af;
                }
                if(field_22335_X || field_22339_T)
                {
                    field_22369_u = block.getAOBrightness(blockAccess, i - 1, j + 1, k);
                    field_35940_X = block.getRenderBrightness(blockAccess, i - 1, j + 1, k);
                } else
                {
                    field_22369_u = field_22358_C;
                    field_35940_X = field_35956_af;
                }
                if(field_22363_aa || field_22361_ab)
                {
                    field_22372_r = block.getAOBrightness(blockAccess, i + 1, j - 1, k);
                    field_35931_U = block.getRenderBrightness(blockAccess, i + 1, j - 1, k);
                } else
                {
                    field_22372_r = field_22356_D;
                    field_35931_U = field_35953_ag;
                }
                if(field_22363_aa || field_22339_T)
                {
                    field_22365_y = block.getAOBrightness(blockAccess, i + 1, j + 1, k);
                    field_35952_ab = block.getRenderBrightness(blockAccess, i + 1, j + 1, k);
                } else
                {
                    field_22365_y = field_22356_D;
                    field_35952_ab = field_35953_ag;
                }
                k++;
                f9 = (field_22358_C + field_22369_u + aoLightValueZNeg + field_22366_x) / 4F;
                f15 = (aoLightValueZNeg + field_22366_x + field_22356_D + field_22365_y) / 4F;
                f21 = (field_22374_p + aoLightValueZNeg + field_22372_r + field_22356_D) / 4F;
                f27 = (field_22377_m + field_22358_C + field_22374_p + aoLightValueZNeg) / 4F;
                brightnessTopLeft = aoAverage(field_35956_af, field_35940_X, field_35951_aa, n2);
                brightnessBottomLeft = aoAverage(field_35951_aa, field_35953_ag, field_35952_ab, n2);
                brightnessBottomRight = aoAverage(field_35937_S, field_35931_U, field_35953_ag, n2);
                brightnessTopRight = aoAverage(field_35936_P, field_35956_af, field_35937_S, n2);
            } else
            {
                f9 = f15 = f21 = f27 = aoLightValueZNeg;
            }
            setAOValues((flag3 ? f : 1.0F) * eastWestFaceBrightness, (flag3 ? f1 : 1.0F) * eastWestFaceBrightness, (flag3 ? f2 : 1.0F) * eastWestFaceBrightness, f9, f15, f21, f27);
            int i1 = block.getBlockTexture(blockAccess, i, j, k, 2);
            if(grassSide && block == Block.grass)
            {
            	if(((BlockGrass)block).isBlockSideSnowy(blockAccess, i, j, k) && blockAccess.getBlockId(i, j, k-1) == Block.snow.blockID)
            	{
            		if(i1 != 68)
            		{
            			i1 = 55;
            		}else
            		{
            			i1 = 66;
            		}
            	}else
            		if(((BlockGrass)block).isBlockSideGrass(blockAccess, i, j, k) && blockAccess.getBlockId(i, j-1, k-1) == Block.grass.blockID)
            		{
                    	aoMultRGB(f, f1, f2);
            			if(i1 != 3)
            			{
            				i1 = 38;
            			}else
            			{
            				i1 = 0;
            			}
            		}
            }
            renderEastFace(block, i, j, k, i1);
            if(block == Block.grass && (fancyGrass || cfgGrassFix) && (i1 != 38 && i1 != 0) && ((BlockGrass)block).isBlockSideGrass(blockAccess, i, j, k) && overrideBlockTexture < 0)
            {
            	aoMultRGB(f, f1, f2);
                renderEastFace(block, i, j, k, i1 == 3 ? 38 : 39 + blockAccess.getBlockMetadata(i, j, k));
            }
            if(block == BEBlocks.appleLeaves)
            {
                setAOValues(eastWestFaceBrightness, eastWestFaceBrightness, eastWestFaceBrightness, f9, f15, f21, f27);
                renderEastFace(block, i, j, k, 37);
            }
            flag = true;
        }
        if(renderAllFaces || block.shouldSideBeRendered(blockAccess, i, j, k + 1, 3))
        {
            float f10;
            float f16;
            float f22;
            float f28;
            if(field_22352_G > 0)
            {
                k++;
                field_22354_E = block.getAOBrightness(blockAccess, i - 1, j, k);
                field_22353_F = block.getAOBrightness(blockAccess, i + 1, j, k);
                field_22373_q = block.getAOBrightness(blockAccess, i, j - 1, k);
                field_22362_A = block.getAOBrightness(blockAccess, i, j + 1, k);
                field_35954_ah = block.getRenderBrightness(blockAccess, i - 1, j, k);
                field_35945_ai = block.getRenderBrightness(blockAccess, i + 1, j, k);
                field_35932_T = block.getRenderBrightness(blockAccess, i, j - 1, k);
                field_35950_ad = block.getRenderBrightness(blockAccess, i, j + 1, k);
                if(field_22333_Z || field_22355_ae)
                {
                    field_22375_o = block.getAOBrightness(blockAccess, i - 1, j - 1, k);
                    field_35938_R = block.getRenderBrightness(blockAccess, i - 1, j - 1, k);
                } else
                {
                    field_22375_o = field_22354_E;
                    field_35938_R = field_35954_ah;
                }
                if(field_22333_Z || field_22336_W)
                {
                    field_22367_w = block.getAOBrightness(blockAccess, i - 1, j + 1, k);
                    field_35941_Z = block.getRenderBrightness(blockAccess, i - 1, j + 1, k);
                } else
                {
                    field_22367_w = field_22354_E;
                    field_35941_Z = field_35954_ah;
                }
                if(field_22334_Y || field_22355_ae)
                {
                    field_22370_t = block.getAOBrightness(blockAccess, i + 1, j - 1, k);
                    field_35933_W = block.getRenderBrightness(blockAccess, i + 1, j - 1, k);
                } else
                {
                    field_22370_t = field_22353_F;
                    field_35933_W = field_35945_ai;
                }
                if(field_22334_Y || field_22336_W)
                {
                    field_22360_B = block.getAOBrightness(blockAccess, i + 1, j + 1, k);
                    field_35955_ae = block.getRenderBrightness(blockAccess, i + 1, j + 1, k);
                } else
                {
                    field_22360_B = field_22353_F;
                    field_35955_ae = field_35945_ai;
                }
                k--;
                f10 = (field_22354_E + field_22367_w + aoLightValueZPos + field_22362_A) / 4F;
                f28 = (aoLightValueZPos + field_22362_A + field_22353_F + field_22360_B) / 4F;
                f22 = (field_22373_q + aoLightValueZPos + field_22370_t + field_22353_F) / 4F;
                f16 = (field_22375_o + field_22354_E + field_22373_q + aoLightValueZPos) / 4F;
                brightnessTopLeft = aoAverage(field_35954_ah, field_35941_Z, field_35950_ad, n5);
                brightnessTopRight = aoAverage(field_35950_ad, field_35945_ai, field_35955_ae, n5);
                brightnessBottomRight = aoAverage(field_35932_T, field_35933_W, field_35945_ai, n5);
                brightnessBottomLeft = aoAverage(field_35938_R, field_35954_ah, field_35932_T, n5);
            } else
            {
                f10 = f16 = f22 = f28 = aoLightValueZPos;
            }
            setAOValues((flag4 ? f : 1.0F) * eastWestFaceBrightness, (flag4 ? f1 : 1.0F) * eastWestFaceBrightness, (flag4 ? f2 : 1.0F) * eastWestFaceBrightness, f10, f16, f22, f28);
            int j1 = block.getBlockTexture(blockAccess, i, j, k, 3);
            if(grassSide && block == Block.grass)
            {
            	if(((BlockGrass)block).isBlockSideSnowy(blockAccess, i, j, k) && blockAccess.getBlockId(i, j, k+1) == Block.snow.blockID)
            	{
            		if(j1 != 68)
            		{
            			j1 = 55;
            		}else
            		{
            			j1 = 66;
            		}
            	}else
            		if(((BlockGrass)block).isBlockSideGrass(blockAccess, i, j, k) && blockAccess.getBlockId(i, j-1, k+1) == Block.grass.blockID)
            		{
                    	aoMultRGB(f, f1, f2);
            			if(j1 != 3)
            			{
            				j1 = 38;
            			}else
            			{
            				j1 = 0;
            			}
            		}
            }
            renderWestFace(block, i, j, k, j1);
            if(block == Block.grass && (fancyGrass || cfgGrassFix) && (j1 != 38 && j1 != 0) && ((BlockGrass)block).isBlockSideGrass(blockAccess, i, j, k) && overrideBlockTexture < 0)
            {
            	aoMultRGB(f, f1, f2);
                renderWestFace(block, i, j, k, j1 == 3 ? 38 : 39 + blockAccess.getBlockMetadata(i, j, k));
            }
            if(block == BEBlocks.appleLeaves)
            {
                setAOValues(eastWestFaceBrightness, eastWestFaceBrightness, eastWestFaceBrightness, f10, f16, f22, f28);
                renderWestFace(block, i, j, k, 37);
            }
            flag = true;
        }
        if(renderAllFaces || block.shouldSideBeRendered(blockAccess, i - 1, j, k, 4))
        {
            float f11;
            float f17;
            float f23;
            float f29;
            if(field_22352_G > 0)
            {
                i--;
                field_22376_n = block.getAOBrightness(blockAccess, i, j - 1, k);;
                field_22358_C = block.getAOBrightness(blockAccess, i, j, k - 1);;
                field_22354_E = block.getAOBrightness(blockAccess, i, j, k + 1);;
                field_22368_v = block.getAOBrightness(blockAccess, i, j + 1, k);;
                field_35935_Q = block.getRenderBrightness(blockAccess, i, j - 1, k);
                field_35956_af = block.getRenderBrightness(blockAccess, i, j, k - 1);
                field_35954_ah = block.getRenderBrightness(blockAccess, i, j, k + 1);
                field_35939_Y = block.getRenderBrightness(blockAccess, i, j + 1, k);
                if(field_22335_X || field_22357_ad)
                {
                    field_22377_m = block.getAOBrightness(blockAccess, i, j - 1, k - 1);;
                    field_35936_P = block.getRenderBrightness(blockAccess, i, j - 1, k - 1);
                } else
                {
                    field_22377_m = field_22358_C;
                    field_35936_P = field_35956_af;
                }
                if(field_22333_Z || field_22357_ad)
                {
                    field_22375_o = block.getAOBrightness(blockAccess, i, j - 1, k + 1);;
                    field_35938_R = block.getRenderBrightness(blockAccess, i, j - 1, k + 1);
                } else
                {
                    field_22375_o = field_22354_E;
                    field_35938_R = field_35954_ah;
                }
                if(field_22335_X || field_22337_V)
                {
                    field_22369_u = block.getAOBrightness(blockAccess, i, j + 1, k - 1);;
                    field_35940_X = block.getRenderBrightness(blockAccess, i, j + 1, k - 1);
                } else
                {
                    field_22369_u = field_22358_C;
                    field_35940_X = field_35956_af;
                }
                if(field_22333_Z || field_22337_V)
                {
                    field_22367_w = block.getAOBrightness(blockAccess, i, j + 1, k + 1);;
                    field_35941_Z = block.getRenderBrightness(blockAccess, i, j + 1, k + 1);
                } else
                {
                    field_22367_w = field_22354_E;
                    field_35941_Z = field_35954_ah;
                }
                i++;
                f29 = (field_22376_n + field_22375_o + aoLightValueXNeg + field_22354_E) / 4F;
                f11 = (aoLightValueXNeg + field_22354_E + field_22368_v + field_22367_w) / 4F;
                f17 = (field_22358_C + aoLightValueXNeg + field_22369_u + field_22368_v) / 4F;
                f23 = (field_22377_m + field_22376_n + field_22358_C + aoLightValueXNeg) / 4F;
                brightnessTopRight = aoAverage(field_35935_Q, field_35938_R, field_35954_ah, n0);
                brightnessTopLeft = aoAverage(field_35954_ah, field_35939_Y, field_35941_Z, n0);
                brightnessBottomLeft = aoAverage(field_35956_af, field_35940_X, field_35939_Y, n0);
                brightnessBottomRight = aoAverage(field_35936_P, field_35935_Q, field_35956_af, n0);
            } else
            {
                f11 = f17 = f23 = f29 = aoLightValueXNeg;
            }
            setAOValues((flag5 ? f : 1.0F) * northSouthFaceBrightness, (flag5 ? f1 : 1.0F) * northSouthFaceBrightness, (flag5 ? f2 : 1.0F) * northSouthFaceBrightness, f11, f17, f23, f29);
            int k1 = block.getBlockTexture(blockAccess, i, j, k, 4);
            
            if(grassSide && block == Block.grass)
            {
            	if(((BlockGrass)block).isBlockSideSnowy(blockAccess, i, j, k) && blockAccess.getBlockId(i-1, j, k) == Block.snow.blockID)
            	{
            		if(k1 != 68)
            		{
            			k1 = 55;
            		}else
            		{
            			k1 = 66;
            		}
            	}else
            		if(((BlockGrass)block).isBlockSideGrass(blockAccess, i, j, k) && blockAccess.getBlockId(i-1, j-1, k) == Block.grass.blockID)
            		{
                    	aoMultRGB(f, f1, f2);
            			if(k1 != 3)
            			{
            				k1 = 38;
            			}else
            			{
            				k1 = 0;
            			}
            		}
            }
            renderNorthFace(block, i, j, k, k1);
            if(block == Block.grass && (fancyGrass || cfgGrassFix) && (k1 != 38 && k1 != 0) && ((BlockGrass)block).isBlockSideGrass(blockAccess, i, j, k) && overrideBlockTexture < 0)
            {
            	aoMultRGB(f, f1, f2);
                renderNorthFace(block, i, j, k, k1 == 3 ? 38 : 39 + blockAccess.getBlockMetadata(i, j, k));
            }
            if(block == BEBlocks.appleLeaves)
            {
                setAOValues(northSouthFaceBrightness, northSouthFaceBrightness, northSouthFaceBrightness, f11, f17, f23, f29);
                renderNorthFace(block, i, j, k, 37);
            }
            flag = true;
        }
        if(renderAllFaces || block.shouldSideBeRendered(blockAccess, i + 1, j, k, 5))
        {
            float f12;
            float f18;
            float f24;
            float f30;
            if(field_22352_G > 0)
            {
                i++;
                field_22371_s = block.getAOBrightness(blockAccess, i, j - 1, k);;
                field_22356_D = block.getAOBrightness(blockAccess, i, j, k - 1);;
                field_22353_F = block.getAOBrightness(blockAccess, i, j, k + 1);;
                field_22364_z = block.getAOBrightness(blockAccess, i, j + 1, k);;
                field_35934_V = block.getRenderBrightness(blockAccess, i, j - 1, k);
                field_35953_ag = block.getRenderBrightness(blockAccess, i, j, k - 1);
                field_35945_ai = block.getRenderBrightness(blockAccess, i, j, k + 1);
                field_35949_ac = block.getRenderBrightness(blockAccess, i, j + 1, k);
                if(field_22359_ac || field_22363_aa)
                {
                    field_22372_r = block.getAOBrightness(blockAccess, i, j - 1, k - 1);;
                    field_35931_U = block.getRenderBrightness(blockAccess, i, j - 1, k - 1);
                } else
                {
                    field_22372_r = field_22356_D;
                    field_35931_U = field_35953_ag;
                }
                if(field_22359_ac || field_22334_Y)
                {
                    field_22370_t = block.getAOBrightness(blockAccess, i, j - 1, k + 1);;
                    field_35933_W = block.getRenderBrightness(blockAccess, i, j - 1, k + 1);
                } else
                {
                    field_22370_t = field_22353_F;
                    field_35933_W = field_35945_ai;
                }
                if(field_22338_U || field_22363_aa)
                {
                    field_22365_y = block.getAOBrightness(blockAccess, i, j + 1, k - 1);;
                    field_35952_ab = block.getRenderBrightness(blockAccess, i, j + 1, k - 1);
                } else
                {
                    field_22365_y = field_22356_D;
                    field_35952_ab = field_35953_ag;
                }
                if(field_22338_U || field_22334_Y)
                {
                    field_22360_B = block.getAOBrightness(blockAccess, i, j + 1, k + 1);;
                    field_35955_ae = block.getRenderBrightness(blockAccess, i, j + 1, k + 1);
                } else
                {
                    field_22360_B = field_22353_F;
                    field_35955_ae = field_35945_ai;
                }
                i--;
                f12 = (field_22371_s + field_22370_t + aoLightValueXPos + field_22353_F) / 4F;
                f30 = (aoLightValueXPos + field_22353_F + field_22364_z + field_22360_B) / 4F;
                f24 = (field_22356_D + aoLightValueXPos + field_22365_y + field_22364_z) / 4F;
                f18 = (field_22372_r + field_22371_s + field_22356_D + aoLightValueXPos) / 4F;
                brightnessTopLeft = aoAverage(field_35934_V, field_35933_W, field_35945_ai, n3);
                brightnessTopRight = aoAverage(field_35945_ai, field_35949_ac, field_35955_ae, n3);
                brightnessBottomRight = aoAverage(field_35953_ag, field_35952_ab, field_35949_ac, n3);
                brightnessBottomLeft = aoAverage(field_35931_U, field_35934_V, field_35953_ag, n3);
            } else
            {
                f12 = f18 = f24 = f30 = aoLightValueXPos;
            }
            setAOValues((flag6 ? f : 1.0F) * northSouthFaceBrightness, (flag6 ? f1 : 1.0F) * northSouthFaceBrightness, (flag6 ? f2 : 1.0F) * northSouthFaceBrightness, f12, f18, f24, f30);
            int l1 = block.getBlockTexture(blockAccess, i, j, k, 5);
            if(grassSide && block == Block.grass)
            {
            	if(((BlockGrass)block).isBlockSideSnowy(blockAccess, i, j, k) && blockAccess.getBlockId(i+1, j, k) == Block.snow.blockID)
            	{
            		if(l1 != 68)
            		{
            			l1 = 55;
            		}else
            		{
            			l1 = 66;
            		}
            	}else
            		if(((BlockGrass)block).isBlockSideGrass(blockAccess, i, j, k) && blockAccess.getBlockId(i+1, j-1, k) == Block.grass.blockID)
            		{
                    	aoMultRGB(f, f1, f2);
            			if(l1 != 3)
            			{
            				l1 = 38;
            			}else
            			{
            				l1 = 0;
            			}
            		}
            }
            renderSouthFace(block, i, j, k, l1);
            if(block == Block.grass && (fancyGrass || cfgGrassFix) && (l1 != 38 && l1 != 0) && ((BlockGrass)block).isBlockSideGrass(blockAccess, i, j, k) && overrideBlockTexture < 0)
            {
            	aoMultRGB(f, f1, f2);
                renderSouthFace(block, i, j, k, l1 == 3 ? 38 : 39 + blockAccess.getBlockMetadata(i, j, k));
            }
            if(block == BEBlocks.appleLeaves)
            {
                setAOValues(northSouthFaceBrightness, northSouthFaceBrightness, northSouthFaceBrightness, f12, f18, f24, f30);
                renderSouthFace(block, i, j, k, 37);
            }
            flag = true;
        }
        enableAO = false;
    	if(block == Block.wood)
    	{
    		setTextureOrientation(false,0);
    	}
        return flag;
    }

    private int aoAverage(int i, int j, int k, int l)
    {
        if(i == 0)
        {
            i = l;
        }
        if(j == 0)
        {
            j = l;
        }
        if(k == 0)
        {
            k = l;
        }
        return i + j + k + l >> 2 & 0xff00ff;
    }
    
    private void setAOValues(float f, float f1, float f2, float m, float m1, float m2, float m3)
    {
        colorRedTopLeft = colorRedBottomLeft = colorRedBottomRight = colorRedTopRight = f;
        colorGreenTopLeft = colorGreenBottomLeft = colorGreenBottomRight = colorGreenTopRight = f1;
        colorBlueTopLeft = colorBlueBottomLeft = colorBlueBottomRight = colorBlueTopRight = f2;
        colorRedTopLeft *= m;
        colorGreenTopLeft *= m;
        colorBlueTopLeft *= m;
        colorRedBottomLeft *= m1;
        colorGreenBottomLeft *= m1;
        colorBlueBottomLeft *= m1;
        colorRedBottomRight *= m2;
        colorGreenBottomRight *= m2;
        colorBlueBottomRight *= m2;
        colorRedTopRight *= m3;
        colorGreenTopRight *= m3;
        colorBlueTopRight *= m3;
    }
     
    private void aoMultRGB(float f, float f1, float f2)
    {
        colorRedTopLeft *= f;
        colorRedBottomLeft *= f;
        colorRedBottomRight *= f;
        colorRedTopRight *= f;
        colorGreenTopLeft *= f1;
        colorGreenBottomLeft *= f1;
        colorGreenBottomRight *= f1;
        colorGreenTopRight *= f1;
        colorBlueTopLeft *= f2;
        colorBlueBottomLeft *= f2;
        colorBlueBottomRight *= f2;
        colorBlueTopRight *= f2;
    }
    
    public boolean renderStandardBlockWithColorMultiplier(Block block, int i, int j, int k, float f, float f1, float f2)
    {
        enableAO = false;
        Tessellator tessellator = Tessellator.instance;
        boolean flag = false;
        float f3 = 0.5F;
        float f4 = 1.0F;
        float f5 = 0.8F;
        float f6 = 0.6F;
        float f7 = f4 * f;
        float f8 = f4 * f1;
        float f9 = f4 * f2;
        if(block == BEBlocks.appleLeaves)
        {
            f7 = f4;
            f8 = f4;
            f9 = f4;
        }
        float f10 = f3;
        float f11 = f5;
        float f12 = f6;
        float f13 = f3;
        float f14 = f5;
        float f15 = f6;
        float f16 = f3;
        float f17 = f5;
        float f18 = f6;
        if(block != Block.grass && block != BEBlocks.appleLeaves)
        {
            f10 *= f;
            f11 *= f;
            f12 *= f;
            f13 *= f1;
            f14 *= f1;
            f15 *= f1;
            f16 *= f2;
            f17 *= f2;
            f18 *= f2;
        }
        int n0 = block.getRenderBrightness(blockAccess, i, j, k);
        if(renderAllFaces || block.shouldSideBeRendered(blockAccess, i, j - 1, k, 0))
        {
            int n1 = block.getRenderBrightness(blockAccess, i, j - 1, k);
            tessellator.setBrightness(n1);
            tessellator.setColorOpaque_F(f10, f13, f16);
            if(block == BEBlocks.appleLeaves)
            {
                tessellator.setColorOpaque_F(f10 * f, f13 * f1, f16 * f2);
            }
            renderBottomFace(block, i, j, k, block.getBlockTexture(blockAccess, i, j, k, 0));
            if(block == BEBlocks.appleLeaves)
            {
                tessellator.setColorOpaque_F(f10, f13, f16);
                renderBottomFace(block, i, j, k, 37);
            }
            flag = true;
        }
        if(renderAllFaces || block.shouldSideBeRendered(blockAccess, i, j + 1, k, 1))
        {
        	int n2 = block.getRenderBrightness(blockAccess, i, j + 1, k);
        	tessellator.setBrightness(block.maxY >= 1.0D ? n2 : n0);
            tessellator.setColorOpaque_F(f7, f8, f9);
            if(block == BEBlocks.appleLeaves)
            {
                tessellator.setColorOpaque_F(f7 * f, f8 * f1, f9 * f2);
            }
            renderTopFace(block, i, j, k, block.getBlockTexture(blockAccess, i, j, k, 1));
            if(block == BEBlocks.appleLeaves)
            {
                tessellator.setColorOpaque_F(f7, f8, f9);
                renderTopFace(block, i, j, k, 37);
            }
            flag = true;
        }
        if(renderAllFaces || block.shouldSideBeRendered(blockAccess, i, j, k - 1, 2))
        {
        	int n3 = block.getRenderBrightness(blockAccess, i, j, k - 1);
        	tessellator.setBrightness(block.minZ <= 0.0D ? n3 : n0);
            tessellator.setColorOpaque_F(f11, f14, f17);
            int l = block.getBlockTexture(blockAccess, i, j, k, 2);
            if(block == BEBlocks.appleLeaves)
            {
                tessellator.setColorOpaque_F(f11 * f, f14 * f1, f17 * f2);
            }
            if(grassSide && block == Block.grass)
            {
            	if(((BlockGrass)block).isBlockSideSnowy(blockAccess, i, j, k) && blockAccess.getBlockId(i, j, k-1) == Block.snow.blockID)
            	{
            		if(l != 68)
            		{
            			l = 55;
            		}else
            		{
            			l = 66;
            		}
            	}else
            	if(((BlockGrass)block).isBlockSideGrass(blockAccess, i, j, k) && blockAccess.getBlockId(i, j-1, k-1) == Block.grass.blockID)
            	{
        			if(l != 3)
        			{
        				l = 38;
        			}else
        			{
        				l = 0;
        			}
                    tessellator.setColorOpaque_F(f11 * f, f14 * f1, f17 * f2);
            	}
            }
            renderEastFace(block, i, j, k, l);
            if(block == Block.grass && (fancyGrass || cfgGrassFix) && (l != 38 && l != 0) && ((BlockGrass)block).isBlockSideGrass(blockAccess, i, j, k) && overrideBlockTexture < 0)
            {
                tessellator.setColorOpaque_F(f11 * f, f14 * f1, f17 * f2);
                renderEastFace(block, i, j, k, l == 3 ? 38 : 39 + blockAccess.getBlockMetadata(i, j, k));
            }
            if(block == BEBlocks.appleLeaves)
            {
                tessellator.setColorOpaque_F(f11, f14, f17);
                renderEastFace(block, i, j, k, 37);
            }
            flag = true;
        }
        if(renderAllFaces || block.shouldSideBeRendered(blockAccess, i, j, k + 1, 3))
        {
        	int n4 = block.getRenderBrightness(blockAccess, i, j, k + 1);
        	tessellator.setBrightness(block.maxZ >= 1.0D ? n4 : n0);
            tessellator.setColorOpaque_F(f11, f14, f17);
            int i1 = block.getBlockTexture(blockAccess, i, j, k, 3);
            if(block == BEBlocks.appleLeaves)
            {
                tessellator.setColorOpaque_F(f11 * f, f14 * f1, f17 * f2);
            }
            if(grassSide && block == Block.grass)
            {
            	if(((BlockGrass)block).isBlockSideSnowy(blockAccess, i, j, k) && blockAccess.getBlockId(i, j, k+1) == Block.snow.blockID)
            	{
            		if(i1 != 68)
            		{
            			i1 = 55;
            		}else
            		{
            			i1 = 66;
            		}
            	}else
            	if(((BlockGrass)block).isBlockSideGrass(blockAccess, i, j, k) && blockAccess.getBlockId(i, j-1, k+1) == Block.grass.blockID)
            	{
        			if(i1 != 3)
        			{
        				i1 = 38;
        			}else
        			{
        				i1 = 0;
        			}
                    tessellator.setColorOpaque_F(f11 * f, f14 * f1, f17 * f2);
            	}
            }
            renderWestFace(block, i, j, k, i1);
            if(block == Block.grass && (fancyGrass || cfgGrassFix) && (i1 != 38 && i1 != 0) && ((BlockGrass)block).isBlockSideGrass(blockAccess, i, j, k) && overrideBlockTexture < 0)
            {
                tessellator.setColorOpaque_F(f11 * f, f14 * f1, f17 * f2);
                renderWestFace(block, i, j, k, i1 == 3 ? 38 : 39 + blockAccess.getBlockMetadata(i, j, k));
            }
            if(block == BEBlocks.appleLeaves)
            {
                tessellator.setColorOpaque_F(f11, f14, f17);
                renderWestFace(block, i, j, k, 37);
            }
            flag = true;
        }
        if(renderAllFaces || block.shouldSideBeRendered(blockAccess, i - 1, j, k, 4))
        {
        	int n5 = block.getRenderBrightness(blockAccess, i - 1, j, k);
        	tessellator.setBrightness(block.minX <= 0.0D ? n5 : n0);
            tessellator.setColorOpaque_F(f12, f15, f18);
            int j1 = block.getBlockTexture(blockAccess, i, j, k, 4);
            if(block == BEBlocks.appleLeaves)
            {
                tessellator.setColorOpaque_F(f12 * f, f15 * f1, f18 * f2);
            }
            if(grassSide && block == Block.grass)
            {
            	if(((BlockGrass)block).isBlockSideSnowy(blockAccess, i, j, k) && blockAccess.getBlockId(i - 1, j, k) == Block.snow.blockID)
            	{
            		if(j1 != 68)
            		{
            			j1 = 55;
            		}else
            		{
            			j1 = 66;
            		}
            	}else
            	if(((BlockGrass)block).isBlockSideGrass(blockAccess, i, j, k) && blockAccess.getBlockId(i - 1, j-1, k) == Block.grass.blockID)
            	{
        			if(j1 != 3)
        			{
        				j1 = 38;
        			}else
        			{
        				j1 = 0;
        			}
                    tessellator.setColorOpaque_F(f12 * f, f15 * f1, f18 * f2);
            	}
            }
            renderNorthFace(block, i, j, k, j1);
            if(block == Block.grass && (fancyGrass || cfgGrassFix) && (j1 != 38 && j1 != 0) && ((BlockGrass)block).isBlockSideGrass(blockAccess, i, j, k) && overrideBlockTexture < 0)
            {
                tessellator.setColorOpaque_F(f12 * f, f15 * f1, f18 * f2);
                renderNorthFace(block, i, j, k, j1 == 3 ? 38 : 39 + blockAccess.getBlockMetadata(i, j, k));
            }
            if(block == BEBlocks.appleLeaves)
            {
                tessellator.setColorOpaque_F(f12, f15, f18);
                renderNorthFace(block, i, j, k, 37);
            }
            flag = true;
        }
        if(renderAllFaces || block.shouldSideBeRendered(blockAccess, i + 1, j, k, 5))
        {
        	int n6 = block.getRenderBrightness(blockAccess, i + 1, j, k);
        	tessellator.setBrightness(block.maxX >= 1.0D ? n6 : n0);
            tessellator.setColorOpaque_F(f12, f15, f18);
            int k1 = block.getBlockTexture(blockAccess, i, j, k, 5);
            if(block == BEBlocks.appleLeaves)
            {
                tessellator.setColorOpaque_F(f12 * f, f15 * f1, f18 * f2);
            }
            if(grassSide && block == Block.grass)
            {
            	if(((BlockGrass)block).isBlockSideSnowy(blockAccess, i, j, k) && blockAccess.getBlockId(i + 1, j, k) == Block.snow.blockID)
            	{
            		if(k1 != 68)
            		{
            			k1 = 55;
            		}else
            		{
            			k1 = 66;
            		}
            	}else
            	if(((BlockGrass)block).isBlockSideGrass(blockAccess, i, j, k) && blockAccess.getBlockId(i + 1, j-1, k) == Block.grass.blockID)
            	{
        			if(k1 != 3)
        			{
        				k1 = 38;
        			}else
        			{
        				k1 = 0;
        			}
                    tessellator.setColorOpaque_F(f12 * f, f15 * f1, f18 * f2);
            	}
            }
            renderSouthFace(block, i, j, k, k1);
            if(block == Block.grass && (fancyGrass || cfgGrassFix) && (k1 != 38 && k1 != 0) && ((BlockGrass)block).isBlockSideGrass(blockAccess, i, j, k) && overrideBlockTexture < 0)
            {
                tessellator.setColorOpaque_F(f12 * f, f15 * f1, f18 * f2);
                renderSouthFace(block, i, j, k, k1 == 3 ? 38 : 39 + blockAccess.getBlockMetadata(i, j, k));
            }
            if(block == BEBlocks.appleLeaves)
            {
                tessellator.setColorOpaque_F(f12, f15, f18);
                renderSouthFace(block, i, j, k, 37);
            }
            flag = true;
        }
        return flag;
    }

    public boolean renderBlockCactus(Block block, int i, int j, int k)
    {
        int l = block.colorMultiplier(blockAccess, i, j, k);
        float f = (float)(l >> 16 & 0xff) / 255F;
        float f1 = (float)(l >> 8 & 0xff) / 255F;
        float f2 = (float)(l & 0xff) / 255F;
        if(EntityRenderer.anaglyphEnabled)
        {
            float f3 = (f * 30F + f1 * 59F + f2 * 11F) / 100F;
            float f4 = (f * 30F + f1 * 70F) / 100F;
            float f5 = (f * 30F + f2 * 70F) / 100F;
            f = f3;
            f1 = f4;
            f2 = f5;
        }
        return func_1230_b(block, i, j, k, f, f1, f2);
    }

    public boolean func_1230_b(Block block, int i, int j, int k, float f, float f1, float f2)
    {
        Tessellator tessellator = Tessellator.instance;
        boolean flag = false;
        float f3 = 0.5F;
        float f4 = 1.0F;
        float f5 = 0.8F;
        float f6 = 0.6F;
        float f7 = f3 * f;
        float f8 = f4 * f;
        float f9 = f5 * f;
        float f10 = f6 * f;
        float f11 = f3 * f1;
        float f12 = f4 * f1;
        float f13 = f5 * f1;
        float f14 = f6 * f1;
        float f15 = f3 * f2;
        float f16 = f4 * f2;
        float f17 = f5 * f2;
        float f18 = f6 * f2;
        float f19 = 0.0625F;
        int l = block.getRenderBrightness(blockAccess, i, j, k);
        if(renderAllFaces || block.shouldSideBeRendered(blockAccess, i, j - 1, k, 0))
        {
            tessellator.setBrightness(block.minY <= 0.0D ? block.getRenderBrightness(blockAccess, i, j - 1, k) : l);
            tessellator.setColorOpaque_F(f7, f11, f15);
            renderBottomFace(block, i, j, k, block.getBlockTexture(blockAccess, i, j, k, 0));
            flag = true;
        }
        if(renderAllFaces || block.shouldSideBeRendered(blockAccess, i, j + 1, k, 1))
        {
            tessellator.setBrightness(block.maxY >= 1.0D ? block.getRenderBrightness(blockAccess, i, j + 1, k) : l);
            tessellator.setColorOpaque_F(f8, f12, f16);
            renderTopFace(block, i, j, k, block.getBlockTexture(blockAccess, i, j, k, 1));
            flag = true;
        }
        if(renderAllFaces || block.shouldSideBeRendered(blockAccess, i, j, k - 1, 2))
        {
            tessellator.setBrightness(block.minZ <= 0.0D ? block.getRenderBrightness(blockAccess, i, j, k - 1) : l);
            tessellator.setColorOpaque_F(f9, f13, f17);
            tessellator.setTranslationF(0.0F, 0.0F, f19);
            renderEastFace(block, i, j, k, block.getBlockTexture(blockAccess, i, j, k, 2));
            tessellator.setTranslationF(0.0F, 0.0F, -f19);
            flag = true;
        }
        if(renderAllFaces || block.shouldSideBeRendered(blockAccess, i, j, k + 1, 3))
        {
            tessellator.setBrightness(block.maxZ >= 1.0D ? block.getRenderBrightness(blockAccess, i, j, k + 1) : l);
            tessellator.setColorOpaque_F(f9, f13, f17);
            tessellator.setTranslationF(0.0F, 0.0F, -f19);
            renderWestFace(block, i, j, k, block.getBlockTexture(blockAccess, i, j, k, 3));
            tessellator.setTranslationF(0.0F, 0.0F, f19);
            flag = true;
        }
        if(renderAllFaces || block.shouldSideBeRendered(blockAccess, i - 1, j, k, 4))
        {
            tessellator.setBrightness(block.minX <= 0.0D ? block.getRenderBrightness(blockAccess, i - 1, j, k) : l);
            tessellator.setColorOpaque_F(f10, f14, f18);
            tessellator.setTranslationF(f19, 0.0F, 0.0F);
            renderNorthFace(block, i, j, k, block.getBlockTexture(blockAccess, i, j, k, 4));
            tessellator.setTranslationF(-f19, 0.0F, 0.0F);
            flag = true;
        }
        if(renderAllFaces || block.shouldSideBeRendered(blockAccess, i + 1, j, k, 5))
        {
            tessellator.setBrightness(block.maxX >= 1.0D ? block.getRenderBrightness(blockAccess, i + 1, j, k) : l);
            tessellator.setColorOpaque_F(f10, f14, f18);
            tessellator.setTranslationF(-f19, 0.0F, 0.0F);
            renderSouthFace(block, i, j, k, block.getBlockTexture(blockAccess, i, j, k, 5));
            tessellator.setTranslationF(f19, 0.0F, 0.0F);
            flag = true;
        }
        return flag;
    }

    public boolean renderBlockFence(BlockFence block, int i, int j, int k)
    {
        boolean flag = false;
        float f = 0.375F;
        float f1 = 0.625F;
        block.setBlockBounds(f, 0.0F, f, f1, 1.0F, f1);
        renderStandardBlock(block, i, j, k);
        flag = true;
        boolean flag1 = false;
        boolean flag2 = false;
        if(block.canConnectFenceTo(blockAccess, i - 1, j, k) || block.canConnectFenceTo(blockAccess, i + 1, j, k))
        {
            flag1 = true;
        }
        if(block.canConnectFenceTo(blockAccess, i, j, k - 1) || block.canConnectFenceTo(blockAccess, i, j, k + 1))
        {
            flag2 = true;
        }
        boolean flag3 = block.canConnectFenceTo(blockAccess, i - 1, j, k);
        boolean flag4 = block.canConnectFenceTo(blockAccess, i + 1, j, k);
        boolean flag5 = block.canConnectFenceTo(blockAccess, i, j, k - 1);
        boolean flag6 = block.canConnectFenceTo(blockAccess, i, j, k + 1);
        if(!flag1 && !flag2)
        {
            flag1 = true;
        }
        f = 0.4375F;
        f1 = 0.5625F;
        float f2 = 0.75F;
        float f3 = 0.9375F;
        float f4 = flag3 ? 0.0F : f;
        float f5 = flag4 ? 1.0F : f1;
        float f6 = flag5 ? 0.0F : f;
        float f7 = flag6 ? 1.0F : f1;
        if(flag1)
        {
            block.setBlockBounds(f4, f2, f, f5, f3, f1);
            renderStandardBlock(block, i, j, k);
            flag = true;
        }
        if(flag2)
        {
            block.setBlockBounds(f, f2, f6, f1, f3, f7);
            renderStandardBlock(block, i, j, k);
            flag = true;
        }
        f2 = 0.375F;
        f3 = 0.5625F;
        if(flag1)
        {
            block.setBlockBounds(f4, f2, f, f5, f3, f1);
            renderStandardBlock(block, i, j, k);
            flag = true;
        }
        if(flag2)
        {
            block.setBlockBounds(f, f2, f6, f1, f3, f7);
            renderStandardBlock(block, i, j, k);
            flag = true;
        }
        block.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
        return flag;
    }

    public boolean renderBlockStairs(Block block, int i, int j, int k)
    {
        boolean flag = false;
        int l = blockAccess.getBlockMetadata(i, j, k);
        if(l == 0)
        {
            block.setBlockBounds(0.0F, 0.0F, 0.0F, 0.5F, 0.5F, 1.0F);
            renderStandardBlock(block, i, j, k);
            block.setBlockBounds(0.5F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
            renderStandardBlock(block, i, j, k);
            flag = true;
        } else
        if(l == 1)
        {
            block.setBlockBounds(0.0F, 0.0F, 0.0F, 0.5F, 1.0F, 1.0F);
            renderStandardBlock(block, i, j, k);
            block.setBlockBounds(0.5F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
            renderStandardBlock(block, i, j, k);
            flag = true;
        } else
        if(l == 2)
        {
            block.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 0.5F);
            renderStandardBlock(block, i, j, k);
            block.setBlockBounds(0.0F, 0.0F, 0.5F, 1.0F, 1.0F, 1.0F);
            renderStandardBlock(block, i, j, k);
            flag = true;
        } else
        if(l == 3)
        {
            block.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.5F);
            renderStandardBlock(block, i, j, k);
            block.setBlockBounds(0.0F, 0.0F, 0.5F, 1.0F, 0.5F, 1.0F);
            renderStandardBlock(block, i, j, k);
            flag = true;
        }else
        if(l == 4)
        {
            block.setBlockBounds(0.0F, 0.5F, 0.0F, 0.5F, 1.0F, 1.0F);
            renderStandardBlock(block, i, j, k);
            block.setBlockBounds(0.5F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
            renderStandardBlock(block, i, j, k);
            flag = true;
        } else
        if(l == 5)
        {
            block.setBlockBounds(0.0F, 0.0F, 0.0F, 0.5F, 1.0F, 1.0F);
            renderStandardBlock(block, i, j, k);
            block.setBlockBounds(0.5F, 0.5F, 0.0F, 1.0F, 1.0F, 1.0F);
            renderStandardBlock(block, i, j, k);
            flag = true;
        } else
        if(l == 6)
        {
            block.setBlockBounds(0.0F, 0.5F, 0.0F, 1.0F, 1.0F, 0.5F);
            renderStandardBlock(block, i, j, k);
            block.setBlockBounds(0.0F, 0.0F, 0.5F, 1.0F, 1.0F, 1.0F);
            renderStandardBlock(block, i, j, k);
            flag = true;
        } else
        if(l == 7)
        {
            block.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.5F);
            renderStandardBlock(block, i, j, k);
            block.setBlockBounds(0.0F, 0.5F, 0.5F, 1.0F, 1.0F, 1.0F);
            renderStandardBlock(block, i, j, k);
            flag = true;
        }
        block.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
        return flag;
    }

    public boolean renderBlockDoor(Block block, int i, int j, int k)
    {
        Tessellator tessellator = Tessellator.instance;
        boolean flag = false;
        float f = bottomFaceBrightness;
        float f1 = topFaceBrightness;
        float f2 = eastWestFaceBrightness;
        float f3 = northSouthFaceBrightness;
        int l = block.getRenderBrightness(blockAccess, i, j, k);
        tessellator.setBrightness(block.minY <= 0.0D ? block.getRenderBrightness(blockAccess, i, j - 1, k) : l);
        tessellator.setColorOpaque_F(f, f, f);
        renderBottomFace(block, i, j, k, block.getBlockTexture(blockAccess, i, j, k, 0));
        flag = true;
        tessellator.setBrightness(block.maxY >= 1.0D ? block.getRenderBrightness(blockAccess, i, j + 1, k) : l);
        tessellator.setColorOpaque_F(f1, f1, f1);
        renderTopFace(block, i, j, k, block.getBlockTexture(blockAccess, i, j, k, 1));
        flag = true;
        tessellator.setBrightness(block.minZ <= 0.0D ? block.getRenderBrightness(blockAccess, i, j, k - 1) : l);
        tessellator.setColorOpaque_F(f2, f2, f2);
        int i1 = block.getBlockTexture(blockAccess, i, j, k, 2);
        if(i1 < 0)
        {
            flipTexture = true;
            i1 = -i1;
        }
        renderEastFace(block, i, j, k, i1);
        flag = true;
        flipTexture = false;
        tessellator.setBrightness(block.maxZ >= 1.0D ? block.getRenderBrightness(blockAccess, i, j, k + 1) : l);
        tessellator.setColorOpaque_F(f2, f2, f2);
        i1 = block.getBlockTexture(blockAccess, i, j, k, 3);
        if(i1 < 0)
        {
            flipTexture = true;
            i1 = -i1;
        }
        renderWestFace(block, i, j, k, i1);
        flag = true;
        flipTexture = false;
        tessellator.setBrightness(block.minX <= 0.0D ? block.getRenderBrightness(blockAccess, i - 1, j, k) : l);
        tessellator.setColorOpaque_F(f3, f3, f3);
        i1 = block.getBlockTexture(blockAccess, i, j, k, 4);
        if(i1 < 0)
        {
            flipTexture = true;
            i1 = -i1;
        }
        renderNorthFace(block, i, j, k, i1);
        flag = true;
        flipTexture = false;
        tessellator.setBrightness(block.maxX >= 1.0D ? block.getRenderBrightness(blockAccess, i + 1, j, k) : l);
        tessellator.setColorOpaque_F(f3, f3, f3);
        i1 = block.getBlockTexture(blockAccess, i, j, k, 5);
        if(i1 < 0)
        {
            flipTexture = true;
            i1 = -i1;
        }
        renderSouthFace(block, i, j, k, i1);
        flag = true;
        flipTexture = false;
        return flag;
    }

    public void renderBottomFace(Block block, double d, double d1, double d2, 
            int i)
    {
        Tessellator tessellator = Tessellator.instance;
        if(overrideBlockTexture >= 0)
        {
            i = overrideBlockTexture;
        }
        int j = (i & 0xf) << 4;
        int k = i & 0xf0;
        double d3 = ((double)j + block.minX * 16D) / 256D;
        double d4 = ((double)j + block.maxX * 16D) / 256D;
        double d5 = ((double)k + block.minZ * 16D) / 256D;
        double d6 = ((double)k + block.maxZ * 16D) / 256D;
        if(block.minX < 0.0D || block.maxX > 1.0D)
        {
            d3 = ((float)j + 0.0F) / 256F;
            d4 = ((float)j + 16F) / 256F;
        }
        if(block.minZ < 0.0D || block.maxZ > 1.0D)
        {
            d5 = ((float)k + 0.0F) / 256F;
            d6 = ((float)k + 16F) / 256F;
        }
        double d7 = d4;
        double d8 = d3;
        double d9 = d5;
        double d10 = d6;
        if(bottomFaceRotation == 2)
        {
            d3 = ((double)j + block.minZ * 16D) / 256D;
            d5 = ((double)(k + 16) - block.maxX * 16D) / 256D;
            d4 = ((double)j + block.maxZ * 16D) / 256D;
            d6 = ((double)(k + 16) - block.minX * 16D) / 256D;
            d7 = d4;
            d8 = d3;
            d9 = d5;
            d10 = d6;
            d7 = d3;
            d8 = d4;
            d5 = d6;
            d6 = d9;
        } else
        if(bottomFaceRotation == 1)
        {
            d3 = ((double)(j + 16) - block.maxZ * 16D) / 256D;
            d5 = ((double)k + block.minX * 16D) / 256D;
            d4 = ((double)(j + 16) - block.minZ * 16D) / 256D;
            d6 = ((double)k + block.maxX * 16D) / 256D;
            d7 = d4;
            d8 = d3;
            d9 = d5;
            d10 = d6;
            d3 = d7;
            d4 = d8;
            d9 = d6;
            d10 = d5;
        } else
        if(bottomFaceRotation == 3)
        {
            d3 = ((double)(j + 16) - block.minX * 16D) / 256D;
            d4 = ((double)(j + 16) - block.maxX * 16D) / 256D;
            d5 = ((double)(k + 16) - block.minZ * 16D) / 256D;
            d6 = ((double)(k + 16) - block.maxZ * 16D) / 256D;
            d7 = d4;
            d8 = d3;
            d9 = d5;
            d10 = d6;
        }
        double minX = d + block.minX;
        double maxX = d + block.maxX;
        double minY = d1 + block.minY;
        double minZ = d2 + block.minZ;
        double maxZ = d2 + block.maxZ;
        if(flipBottomTexture)
        {
        	if(bottomFaceRotation == 3)
        	{
        		double x = d3;
        		d3 = d4;
        		d4 = x;
        		d7 = d4;
        		d8 = d3;
        	}else
        	{
            	double x = d5;
                d5 = d6;
                d6 = x;
                d10 = d5;
                d9 = d6;
        	}
        }
        if(enableAO)
        {
        	tessellator.setColorOpaque_F(colorRedTopLeft, colorGreenTopLeft, colorBlueTopLeft);
            tessellator.setBrightness(brightnessTopLeft);
        	tessellator.addVertexWithUV(minX, minY, maxZ, d8, d10);
        	tessellator.setColorOpaque_F(colorRedBottomLeft, colorGreenBottomLeft, colorBlueBottomLeft);
            tessellator.setBrightness(brightnessBottomLeft);
        	tessellator.addVertexWithUV(minX, minY, minZ, d3, d5);
        	tessellator.setColorOpaque_F(colorRedBottomRight, colorGreenBottomRight, colorBlueBottomRight);
            tessellator.setBrightness(brightnessBottomRight);
        	tessellator.addVertexWithUV(maxX, minY, minZ, d7, d9);
        	tessellator.setColorOpaque_F(colorRedTopRight, colorGreenTopRight, colorBlueTopRight);
            tessellator.setBrightness(brightnessTopRight);
        	tessellator.addVertexWithUV(maxX, minY, maxZ, d4, d6);
        } else
        {
            tessellator.addVertexWithUV(minX, minY, maxZ, d8, d10);
            tessellator.addVertexWithUV(minX, minY, minZ, d3, d5);
            tessellator.addVertexWithUV(maxX, minY, minZ, d7, d9);
            tessellator.addVertexWithUV(maxX, minY, maxZ, d4, d6);
        }
    }

    public void renderTopFace(Block block, double d, double d1, double d2, 
            int i)
    {
        Tessellator tessellator = Tessellator.instance;
        if(overrideBlockTexture >= 0)
        {
            i = overrideBlockTexture;
        }
        int j = (i & 0xf) << 4;
        int k = i & 0xf0;
        double d3 = ((double)j + block.minX * 16D) / 256D;
        double d4 = (((double)j + block.maxX * 16D)) / 256D;
        double d5 = ((double)k + block.minZ * 16D) / 256D;
        double d6 = (((double)k + block.maxZ * 16D)) / 256D;
        if(block.minX < 0.0D || block.maxX > 1.0D)
        {
            d3 = ((float)j + 0.0F) / 256F;
            d4 = ((float)j + 16F) / 256F;
        }
        if(block.minZ < 0.0D || block.maxZ > 1.0D)
        {
            d5 = ((float)k + 0.0F) / 256F;
            d6 = ((float)k + 16F) / 256F;
        }
        double d7 = d4;
        double d8 = d3;
        double d9 = d5;
        double d10 = d6;
        if(topFaceRotation == 1)
        {
            d3 = ((double)j + block.minZ * 16D) / 256D;
            d5 = ((double)(k + 16) - block.maxX * 16D) / 256D;
            d4 = ((double)j + block.maxZ * 16D) / 256D;
            d6 = ((double)(k + 16) - block.minX * 16D) / 256D;
            d7 = d4;
            d8 = d3;
            d9 = d5;
            d10 = d6;
            d7 = d3;
            d8 = d4;
            d5 = d6;
            d6 = d9;
        } else
        if(topFaceRotation == 2)
        {
            d3 = ((double)(j + 16) - block.maxZ * 16D) / 256D;
            d5 = ((double)k + block.minX * 16D) / 256D;
            d4 = ((double)(j + 16) - block.minZ * 16D) / 256D;
            d6 = ((double)k + block.maxX * 16D) / 256D;
            d7 = d4;
            d8 = d3;
            d9 = d5;
            d10 = d6;
            d3 = d7;
            d4 = d8;
            d9 = d6;
            d10 = d5;
        } else
        if(topFaceRotation == 3)
        {
            d3 = ((double)(j + 16) - block.minX * 16D) / 256D;
            d4 = ((double)(j + 16) - block.maxX * 16D) / 256D;
            d5 = ((double)(k + 16) - block.minZ * 16D) / 256D;
            d6 = ((double)(k + 16) - block.maxZ * 16D) / 256D;
            d7 = d4;
            d8 = d3;
            d9 = d5;
            d10 = d6;
        }
        double minX = d + block.minX;
        double minZ = d2 + block.minZ;
        double maxX = d + block.maxX;
        double maxY = d1 + block.maxY;
        double maxZ = d2 + block.maxZ;
        if(enableAO)
        {
        	tessellator.setColorOpaque_F(colorRedTopLeft, colorGreenTopLeft, colorBlueTopLeft);
            tessellator.setBrightness(brightnessTopLeft);
        	tessellator.addVertexWithUV(maxX, maxY, maxZ, d4, d6);
        	tessellator.setColorOpaque_F(colorRedBottomLeft, colorGreenBottomLeft, colorBlueBottomLeft);
            tessellator.setBrightness(brightnessBottomLeft);
        	tessellator.addVertexWithUV(maxX, maxY, minZ, d7, d9);
        	tessellator.setColorOpaque_F(colorRedBottomRight, colorGreenBottomRight, colorBlueBottomRight);
            tessellator.setBrightness(brightnessBottomRight);
        	tessellator.addVertexWithUV(minX, maxY, minZ, d3, d5);
        	tessellator.setColorOpaque_F(colorRedTopRight, colorGreenTopRight, colorBlueTopRight);
            tessellator.setBrightness(brightnessTopRight);
        	tessellator.addVertexWithUV(minX, maxY, maxZ, d8, d10);
        } else
        {
            tessellator.addVertexWithUV(maxX, maxY, maxZ, d4, d6);
            tessellator.addVertexWithUV(maxX, maxY, minZ, d7, d9);
            tessellator.addVertexWithUV(minX, maxY, minZ, d3, d5);
            tessellator.addVertexWithUV(minX, maxY, maxZ, d8, d10);
        }
    }

    public void renderEastFace(Block block, double d, double d1, double d2, 
            int i)
    {
        Tessellator tessellator = Tessellator.instance;
        if(overrideBlockTexture >= 0)
        {
            i = overrideBlockTexture;
        }
        int j = (i & 0xf) << 4;
        int k = i & 0xf0;
        double d3 = ((double)j + block.minX * 16D) / 256D;
        double d4 = ((double)j + block.maxX * 16D) / 256D;
        double d5 = ((double)(k + 16) - block.maxY * 16D) / 256D;
        double d6 = ((double)(k + 16) - block.minY * 16D) / 256D;
        if(flipTexture)
        {
            double d7 = d3;
            d3 = d4;
            d4 = d7;
        }
        if(block.minX < 0.0D || block.maxX > 1.0D)
        {
            d3 = ((float)j + 0.0F) / 256F;
            d4 = ((float)j + 16F) / 256F;
        }
        if(block.minY < 0.0D || block.maxY > 1.0D)
        {
            d5 = ((float)k + 0.0F) / 256F;
            d6 = ((float)k + 16F) / 256F;
        }
        double d8 = d4;
        double d9 = d3;
        double d10 = d5;
        double d11 = d6;
        if(eastFaceRotation == 2)
        {
            d3 = ((double)j + block.minY * 16D) / 256D;
            d5 = ((double)(k + 16) - block.minX * 16D) / 256D;
            d4 = ((double)j + block.maxY * 16D) / 256D;
            d6 = ((double)(k + 16) - block.maxX * 16D) / 256D;
            d8 = d4;
            d9 = d3;
            d10 = d5;
            d11 = d6;
            d8 = d3;
            d9 = d4;
            d5 = d6;
            d6 = d10;
        } else
        if(eastFaceRotation == 1)
        {
            d3 = ((double)(j + 16) - block.maxY * 16D) / 256D;
            d5 = ((double)k + block.maxX * 16D) / 256D;
            d4 = ((double)(j + 16) - block.minY * 16D) / 256D;
            d6 = ((double)k + block.minX * 16D) / 256D;
            d8 = d4;
            d9 = d3;
            d10 = d5;
            d11 = d6;
            d3 = d8;
            d4 = d9;
            d10 = d6;
            d11 = d5;
        } else
        if(eastFaceRotation == 3)
        {
            d3 = ((double)(j + 16) - block.minX * 16D) / 256D;
            d4 = ((double)(j + 16) - block.maxX * 16D) / 256D;
            d5 = ((double)k + block.maxY * 16D) / 256D;
            d6 = ((double)k + block.minY * 16D) / 256D;
            d8 = d4;
            d9 = d3;
            d10 = d5;
            d11 = d6;
        }
        if(flipEastTexture)
        {
        	double d7 = d5;
            d5 = d6;
            d6 = d7;
            d10 = d6;
            d11 = d5;
        }
        double d12 = d + block.minX;
        double d13 = d + block.maxX;
        double d14 = d1 + block.minY;
        double d15 = d1 + block.maxY;
        double d16 = d2 + block.minZ;
        if(enableAO)
        {
        	tessellator.setColorOpaque_F(colorRedTopLeft, colorGreenTopLeft, colorBlueTopLeft);
            tessellator.setBrightness(brightnessTopLeft);
        	tessellator.addVertexWithUV(d12, d15, d16, d8, d10);
        	tessellator.setColorOpaque_F(colorRedBottomLeft, colorGreenBottomLeft, colorBlueBottomLeft);
            tessellator.setBrightness(brightnessBottomLeft);
        	tessellator.addVertexWithUV(d13, d15, d16, d3, d5);
        	tessellator.setColorOpaque_F(colorRedBottomRight, colorGreenBottomRight, colorBlueBottomRight);
            tessellator.setBrightness(brightnessBottomRight);
        	tessellator.addVertexWithUV(d13, d14, d16, d9, d11);
        	tessellator.setColorOpaque_F(colorRedTopRight, colorGreenTopRight, colorBlueTopRight);
            tessellator.setBrightness(brightnessTopRight);
        	tessellator.addVertexWithUV(d12, d14, d16, d4, d6);
        } else
        {
            tessellator.addVertexWithUV(d12, d15, d16, d8, d10);
            tessellator.addVertexWithUV(d13, d15, d16, d3, d5);
            tessellator.addVertexWithUV(d13, d14, d16, d9, d11);
            tessellator.addVertexWithUV(d12, d14, d16, d4, d6);
        }
    }

    public void renderWestFace(Block block, double d, double d1, double d2, 
            int i)
    {
        Tessellator tessellator = Tessellator.instance;
        if(overrideBlockTexture >= 0)
        {
            i = overrideBlockTexture;
        }
        int j = (i & 0xf) << 4;
        int k = i & 0xf0;
        double d3 = ((double)j + block.minX * 16D) / 256D;
        double d4 = ((double)j + block.maxX * 16D) / 256D;
        double d5 = ((double)(k + 16) - block.maxY * 16D) / 256D;
        double d6 = ((double)(k + 16) - block.minY * 16D) / 256D;
        if(flipTexture)
        {
            double d7 = d3;
            d3 = d4;
            d4 = d7;
        }
        if(block.minX < 0.0D || block.maxX > 1.0D)
        {
            d3 = ((float)j + 0.0F) / 256F;
            d4 = ((float)j + 16F) / 256F;
        }
        if(block.minY < 0.0D || block.maxY > 1.0D)
        {
            d5 = ((float)k + 0.0F) / 256F;
            d6 = ((float)k + 16F) / 256F;
        }
        double d8 = d4;
        double d9 = d3;
        double d10 = d5;
        double d11 = d6;
        if(westFaceRotation == 1)
        {
            d3 = ((double)j + block.minY * 16D) / 256D;
            d6 = ((double)(k + 16) - block.minX * 16D) / 256D;
            d4 = ((double)j + block.maxY * 16D) / 256D;
            d5 = ((double)(k + 16) - block.maxX * 16D) / 256D;
            d8 = d4;
            d9 = d3;
            d10 = d5;
            d11 = d6;
            d8 = d3;
            d9 = d4;
            d5 = d6;
            d6 = d10;
        } else
        if(westFaceRotation == 2)
        {
            d3 = ((double)(j + 16) - block.maxY * 16D) / 256D;
            d5 = ((double)k + block.minX * 16D) / 256D;
            d4 = ((double)(j + 16) - block.minY * 16D) / 256D;
            d6 = ((double)k + block.maxX * 16D) / 256D;
            d8 = d4;
            d9 = d3;
            d10 = d5;
            d11 = d6;
            d3 = d8;
            d4 = d9;
            d10 = d6;
            d11 = d5;
        } else
        if(westFaceRotation == 3)
        {
            d3 = ((double)(j + 16) - block.minX * 16D) / 256D;
            d4 = ((double)(j + 16) - block.maxX * 16D) / 256D;
            d5 = ((double)k + block.maxY * 16D) / 256D;
            d6 = ((double)k + block.minY * 16D) / 256D;
            d8 = d4;
            d9 = d3;
            d10 = d5;
            d11 = d6;
        }
        double d12 = d + block.minX;
        double d13 = d + block.maxX;
        double d14 = d1 + block.minY;
        double d15 = d1 + block.maxY;
        double d16 = d2 + block.maxZ;
        if(enableAO)
        {
        	tessellator.setColorOpaque_F(colorRedTopLeft, colorGreenTopLeft, colorBlueTopLeft);
            tessellator.setBrightness(brightnessTopLeft);
        	tessellator.addVertexWithUV(d12, d15, d16, d3, d5);
        	tessellator.setColorOpaque_F(colorRedBottomLeft, colorGreenBottomLeft, colorBlueBottomLeft);
            tessellator.setBrightness(brightnessBottomLeft);
        	tessellator.addVertexWithUV(d12, d14, d16, d9, d11);
        	tessellator.setColorOpaque_F(colorRedBottomRight, colorGreenBottomRight, colorBlueBottomRight);
            tessellator.setBrightness(brightnessBottomRight);
        	tessellator.addVertexWithUV(d13, d14, d16, d4, d6);
        	tessellator.setColorOpaque_F(colorRedTopRight, colorGreenTopRight, colorBlueTopRight);
            tessellator.setBrightness(brightnessTopRight);
        	tessellator.addVertexWithUV(d13, d15, d16, d8, d10);
        } else
        {
            tessellator.addVertexWithUV(d12, d15, d16, d3, d5);
            tessellator.addVertexWithUV(d12, d14, d16, d9, d11);
            tessellator.addVertexWithUV(d13, d14, d16, d4, d6);
            tessellator.addVertexWithUV(d13, d15, d16, d8, d10);
        }
    }

    public void renderNorthFace(Block block, double d, double d1, double d2, 
            int i)
    {
        Tessellator tessellator = Tessellator.instance;
        if(overrideBlockTexture >= 0)
        {
            i = overrideBlockTexture;
        }
        int j = (i & 0xf) << 4;
        int k = i & 0xf0;
        double d3 = ((double)j + block.minZ * 16D) / 256D;
        double d4 = ((double)j + block.maxZ * 16D) / 256D;
        double d5 = ((double)(k + 16) - block.maxY * 16D) / 256D;
        double d6 = ((double)(k + 16) - block.minY * 16D) / 256D;
        if(flipTexture)
        {
            double d7 = d3;
            d3 = d4;
            d4 = d7;
        }
        if(block.minZ < 0.0D || block.maxZ > 1.0D)
        {
            d3 = ((float)j + 0.0F) / 256F;
            d4 = ((float)j + 16F) / 256F;
        }
        if(block.minY < 0.0D || block.maxY > 1.0D)
        {
            d5 = ((float)k + 0.0F) / 256F;
            d6 = ((float)k + 16F) / 256F;
        }
        double d8 = d4;
        double d9 = d3;
        double d10 = d5;
        double d11 = d6;
        if(northFaceRotation == 1)
        {
            d3 = ((double)j + block.minY * 16D) / 256D;
            d5 = ((double)(k + 16) - block.maxZ * 16D) / 256D;
            d4 = ((double)j + block.maxY * 16D) / 256D;
            d6 = ((double)(k + 16) - block.minZ * 16D) / 256D;
            d8 = d4;
            d9 = d3;
            d10 = d5;
            d11 = d6;
            d8 = d3;
            d9 = d4;
            d5 = d6;
            d6 = d10;
        } else
        if(northFaceRotation == 2)
        {
            d3 = ((double)(j + 16) - block.maxY * 16D) / 256D;
            d5 = ((double)k + block.minZ * 16D) / 256D;
            d4 = ((double)(j + 16) - block.minY * 16D) / 256D;
            d6 = ((double)k + block.maxZ * 16D) / 256D;
            d8 = d4;
            d9 = d3;
            d10 = d5;
            d11 = d6;
            d3 = d8;
            d4 = d9;
            d10 = d6;
            d11 = d5;
        } else
        if(northFaceRotation == 3)
        {
            d3 = ((double)(j + 16) - block.minZ * 16D) / 256D;
            d4 = ((double)(j + 16) - block.maxZ * 16D) / 256D;
            d5 = ((double)k + block.maxY * 16D) / 256D;
            d6 = ((double)k + block.minY * 16D) / 256D;
            d8 = d4;
            d9 = d3;
            d10 = d5;
            d11 = d6;
        }
        double d12 = d + block.minX;
        double d13 = d1 + block.minY;
        double d14 = d1 + block.maxY;
        double d15 = d2 + block.minZ;
        double d16 = d2 + block.maxZ;
        if(enableAO)
        {
        	tessellator.setColorOpaque_F(colorRedTopLeft, colorGreenTopLeft, colorBlueTopLeft);
            tessellator.setBrightness(brightnessTopLeft);
        	tessellator.addVertexWithUV(d12, d14, d16, d8, d10);
        	tessellator.setColorOpaque_F(colorRedBottomLeft, colorGreenBottomLeft, colorBlueBottomLeft);
            tessellator.setBrightness(brightnessBottomLeft);
        	tessellator.addVertexWithUV(d12, d14, d15, d3, d5);
        	tessellator.setColorOpaque_F(colorRedBottomRight, colorGreenBottomRight, colorBlueBottomRight);
            tessellator.setBrightness(brightnessBottomRight);
        	tessellator.addVertexWithUV(d12, d13, d15, d9, d11);    
        	tessellator.setColorOpaque_F(colorRedTopRight, colorGreenTopRight, colorBlueTopRight);
            tessellator.setBrightness(brightnessTopRight);
        	tessellator.addVertexWithUV(d12, d13, d16, d4, d6);
        } else
        {
            tessellator.addVertexWithUV(d12, d14, d16, d8, d10);
            tessellator.addVertexWithUV(d12, d14, d15, d3, d5);
            tessellator.addVertexWithUV(d12, d13, d15, d9, d11);
            tessellator.addVertexWithUV(d12, d13, d16, d4, d6);
        }
    }

    public void renderSouthFace(Block block, double d, double d1, double d2, 
            int i)
    {
        Tessellator tessellator = Tessellator.instance;
        if(overrideBlockTexture >= 0)
        {
            i = overrideBlockTexture;
        }
        int j = (i & 0xf) << 4;
        int k = i & 0xf0;
        double d3 = ((double)j + block.minZ * 16D) / 256D;
        double d4 = ((double)j + block.maxZ * 16D) / 256D;
        double d5 = ((double)(k + 16) - block.maxY * 16D) / 256D;
        double d6 = ((double)(k + 16) - block.minY * 16D) / 256D;
        if(flipTexture)
        {
            double d7 = d3;
            d3 = d4;
            d4 = d7;
        }
        if(block.minZ < 0.0D || block.maxZ > 1.0D)
        {
            d3 = ((float)j + 0.0F) / 256F;
            d4 = ((float)j + 16F) / 256F;
        }
        if(block.minY < 0.0D || block.maxY > 1.0D)
        {
            d5 = ((float)k + 0.0F) / 256F;
            d6 = ((float)k + 16F) / 256F;
        }
        double d8 = d4;
        double d9 = d3;
        double d10 = d5;
        double d11 = d6;
        if(southFaceRotation == 2)
        {
            d3 = ((double)j + block.minY * 16D) / 256D;
            d5 = ((double)(k + 16) - block.minZ * 16D) / 256D;
            d4 = ((double)j + block.maxY * 16D) / 256D;
            d6 = ((double)(k + 16) - block.maxZ * 16D) / 256D;
            d8 = d4;
            d9 = d3;
            d10 = d5;
            d11 = d6;
            d8 = d3;
            d9 = d4;
            d5 = d6;
            d6 = d10;
        } else
        if(southFaceRotation == 1)
        {
            d3 = ((double)(j + 16) - block.maxY * 16D) / 256D;
            d5 = ((double)k + block.maxZ * 16D) / 256D;
            d4 = ((double)(j + 16) - block.minY * 16D) / 256D;
            d6 = ((double)k + block.minZ * 16D) / 256D;
            d8 = d4;
            d9 = d3;
            d10 = d5;
            d11 = d6;
            d3 = d8;
            d4 = d9;
            d10 = d6;
            d11 = d5;
        } else
        if(southFaceRotation == 3)
        {
            d3 = ((double)(j + 16) - block.minZ * 16D) / 256D;
            d4 = ((double)(j + 16) - block.maxZ * 16D) / 256D;
            d5 = ((double)k + block.maxY * 16D) / 256D;
            d6 = ((double)k + block.minY * 16D) / 256D;
            d8 = d4;
            d9 = d3;
            d10 = d5;
            d11 = d6;
        }
        if(flipSouthTexture)
        {
        	double x = d5;
        	d5 = d6;
        	d6 = x;
        	d10 = d6;
        	d11 = d5;
        }
        double d12 = d + block.maxX;
        double d13 = d1 + block.minY;
        double d14 = d1 + block.maxY;
        double d15 = d2 + block.minZ;
        double d16 = d2 + block.maxZ;
        if(enableAO)
        {     
        	tessellator.setColorOpaque_F(colorRedTopLeft, colorGreenTopLeft, colorBlueTopLeft);
            tessellator.setBrightness(brightnessTopLeft);
        	tessellator.addVertexWithUV(d12, d13, d16, d9, d11);
        	tessellator.setColorOpaque_F(colorRedBottomLeft, colorGreenBottomLeft, colorBlueBottomLeft);
            tessellator.setBrightness(brightnessBottomLeft);
        	tessellator.addVertexWithUV(d12, d13, d15, d4, d6);
        	tessellator.setColorOpaque_F(colorRedBottomRight, colorGreenBottomRight, colorBlueBottomRight);
            tessellator.setBrightness(brightnessBottomRight);
        	tessellator.addVertexWithUV(d12, d14, d15, d8, d10);
        	tessellator.setColorOpaque_F(colorRedTopRight, colorGreenTopRight, colorBlueTopRight);
            tessellator.setBrightness(brightnessTopRight);
        	tessellator.addVertexWithUV(d12, d14, d16, d3, d5);
        } else
        {
            tessellator.addVertexWithUV(d12, d13, d16, d9, d11);
            tessellator.addVertexWithUV(d12, d13, d15, d4, d6);
            tessellator.addVertexWithUV(d12, d14, d15, d8, d10);
            tessellator.addVertexWithUV(d12, d14, d16, d3, d5);
        }
    }

    public void renderBlockOnInventory(Block block, int i, float f)
    {
        Tessellator tessellator = Tessellator.instance;
        if(field_31088_b)
        {
            int j = block.getRenderColor(i);
            float f1 = (float)(j >> 16 & 0xff) / 255F;
            float f3 = (float)(j >> 8 & 0xff) / 255F;
            float f5 = (float)(j & 0xff) / 255F;
            GL11.glColor4f(f1 * f, f3 * f, f5 * f, 1.0F);
        }
        int k = block.getRenderType();
        if(block.blockID == 2)
        {
        	int l = ColorizerGrass.getGrassColor(0.75D, 0.75D);
            float f1 = (float)(l >> 16 & 0xff) / 255F;
            float f3 = (float)(l >> 8 & 0xff) / 255F;
            float f5 = (float)(l & 0xff) / 255F;
            GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
            tessellator.startDrawingQuads();
            tessellator.setNormal(0.0F, -1F, 0.0F);
            renderBottomFace(block, 0.0D, 0.0D, 0.0D, 2);
            tessellator.draw();
            tessellator.startDrawingQuads();
            tessellator.setNormal(0.0F, 0.0F, -1F);
            renderEastFace(block, 0.0D, 0.0D, 0.0D, 3);
            tessellator.draw();
            tessellator.startDrawingQuads();
            tessellator.setNormal(0.0F, 0.0F, 1.0F);
            renderWestFace(block, 0.0D, 0.0D, 0.0D, 3);
            tessellator.draw();
            tessellator.startDrawingQuads();
            tessellator.setNormal(-1F, 0.0F, 0.0F);
            renderNorthFace(block, 0.0D, 0.0D, 0.0D, 3);
            tessellator.draw();
            tessellator.startDrawingQuads();
            tessellator.setNormal(1.0F, 0.0F, 0.0F);
            renderSouthFace(block, 0.0D, 0.0D, 0.0D, 3);
            tessellator.draw();
            GL11.glColor4f(f1 * f, f3 * f, f5 * f, 1.0F);
            tessellator.startDrawingQuads();
            tessellator.setNormal(0.0F, 1.0F, 0.0F);
            renderTopFace(block, 0.0D, 0.0D, 0.0D, 0);
            tessellator.draw();
            tessellator.startDrawingQuads();
            tessellator.setNormal(0.0F, 0.0F, -1F);
            renderEastFace(block, 0.0D, 0.0D, 0.0D, 38);
            tessellator.draw();
            tessellator.startDrawingQuads();
            tessellator.setNormal(0.0F, 0.0F, 1.0F);
            renderWestFace(block, 0.0D, 0.0D, 0.0D, 38);
            tessellator.draw();
            tessellator.startDrawingQuads();
            tessellator.setNormal(-1F, 0.0F, 0.0F);
            renderNorthFace(block, 0.0D, 0.0D, 0.0D, 38);
            tessellator.draw();
            tessellator.startDrawingQuads();
            tessellator.setNormal(1.0F, 0.0F, 0.0F);
            renderSouthFace(block, 0.0D, 0.0D, 0.0D, 38);
            tessellator.draw();
            GL11.glColor4f(f,f, f, 1.0F);
            GL11.glTranslatef(0.5F, 0.5F, 0.5F);
        }else
        if(k == 0 || k == 16)
        {
            if(k == 16)
            {
                i = 1;
            }
            block.setBlockBoundsForItemRender();
            GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
            tessellator.startDrawingQuads();
            tessellator.setNormal(0.0F, -1F, 0.0F);
            renderBottomFace(block, 0.0D, 0.0D, 0.0D, block.getBlockTextureFromSideAndMetadata(0, i));
            tessellator.draw();
            tessellator.startDrawingQuads();
            tessellator.setNormal(0.0F, 1.0F, 0.0F);
            renderTopFace(block, 0.0D, 0.0D, 0.0D, block.getBlockTextureFromSideAndMetadata(1, i));
            tessellator.draw();
            tessellator.startDrawingQuads();
            tessellator.setNormal(0.0F, 0.0F, -1F);
            renderEastFace(block, 0.0D, 0.0D, 0.0D, block.getBlockTextureFromSideAndMetadata(2, i));
            tessellator.draw();
            tessellator.startDrawingQuads();
            tessellator.setNormal(0.0F, 0.0F, 1.0F);
            renderWestFace(block, 0.0D, 0.0D, 0.0D, block.getBlockTextureFromSideAndMetadata(3, i));
            tessellator.draw();
            tessellator.startDrawingQuads();
            tessellator.setNormal(-1F, 0.0F, 0.0F);
            renderNorthFace(block, 0.0D, 0.0D, 0.0D, block.getBlockTextureFromSideAndMetadata(4, i));
            tessellator.draw();
            tessellator.startDrawingQuads();
            tessellator.setNormal(1.0F, 0.0F, 0.0F);
            renderSouthFace(block, 0.0D, 0.0D, 0.0D, block.getBlockTextureFromSideAndMetadata(5, i));
            tessellator.draw();
            if(block.blockID == 140)
            {
                GL11.glColor4f(f, f, f, 1.0F);
                tessellator.startDrawingQuads();
                tessellator.setNormal(0.0F, -1F, 0.0F);
                renderBottomFace(block, 0.0D, 0.0D, 0.0D, 37);
                tessellator.draw();
                tessellator.startDrawingQuads();
                tessellator.setNormal(0.0F, 1.0F, 0.0F);
                renderTopFace(block, 0.0D, 0.0D, 0.0D, 37);
                tessellator.draw();
                tessellator.startDrawingQuads();
                tessellator.setNormal(0.0F, 0.0F, -1F);
                renderEastFace(block, 0.0D, 0.0D, 0.0D, 37);
                tessellator.draw();
                tessellator.startDrawingQuads();
                tessellator.setNormal(0.0F, 0.0F, 1.0F);
                renderWestFace(block, 0.0D, 0.0D, 0.0D, 37);
                tessellator.draw();
                tessellator.startDrawingQuads();
                tessellator.setNormal(-1F, 0.0F, 0.0F);
                renderNorthFace(block, 0.0D, 0.0D, 0.0D, 37);
                tessellator.draw();
                tessellator.startDrawingQuads();
                tessellator.setNormal(1.0F, 0.0F, 0.0F);
                renderSouthFace(block, 0.0D, 0.0D, 0.0D, 37);
                tessellator.draw();
            }
            GL11.glTranslatef(0.5F, 0.5F, 0.5F);
        } else
        if(k == 1)
        {
            tessellator.startDrawingQuads();
            tessellator.setNormal(0.0F, -1F, 0.0F);
            renderCrossedSquares(block, i, -0.5D, -0.5D, -0.5D, false);
            tessellator.draw();
        } else
        if(k == 13)
        {
            block.setBlockBoundsForItemRender();
            GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
            float f2 = 0.0625F;
            tessellator.startDrawingQuads();
            tessellator.setNormal(0.0F, -1F, 0.0F);
            renderBottomFace(block, 0.0D, 0.0D, 0.0D, block.getBlockTextureFromSide(0));
            tessellator.draw();
            tessellator.startDrawingQuads();
            tessellator.setNormal(0.0F, 1.0F, 0.0F);
            renderTopFace(block, 0.0D, 0.0D, 0.0D, block.getBlockTextureFromSide(1));
            tessellator.draw();
            tessellator.startDrawingQuads();
            tessellator.setNormal(0.0F, 0.0F, -1F);
            tessellator.setTranslationF(0.0F, 0.0F, f2);
            renderEastFace(block, 0.0D, 0.0D, 0.0D, block.getBlockTextureFromSide(2));
            tessellator.setTranslationF(0.0F, 0.0F, -f2);
            tessellator.draw();
            tessellator.startDrawingQuads();
            tessellator.setNormal(0.0F, 0.0F, 1.0F);
            tessellator.setTranslationF(0.0F, 0.0F, -f2);
            renderWestFace(block, 0.0D, 0.0D, 0.0D, block.getBlockTextureFromSide(3));
            tessellator.setTranslationF(0.0F, 0.0F, f2);
            tessellator.draw();
            tessellator.startDrawingQuads();
            tessellator.setNormal(-1F, 0.0F, 0.0F);
            tessellator.setTranslationF(f2, 0.0F, 0.0F);
            renderNorthFace(block, 0.0D, 0.0D, 0.0D, block.getBlockTextureFromSide(4));
            tessellator.setTranslationF(-f2, 0.0F, 0.0F);
            tessellator.draw();
            tessellator.startDrawingQuads();
            tessellator.setNormal(1.0F, 0.0F, 0.0F);
            tessellator.setTranslationF(-f2, 0.0F, 0.0F);
            renderSouthFace(block, 0.0D, 0.0D, 0.0D, block.getBlockTextureFromSide(5));
            tessellator.setTranslationF(f2, 0.0F, 0.0F);
            tessellator.draw();
            GL11.glTranslatef(0.5F, 0.5F, 0.5F);
        } else
        if(k == 6)
        {
            tessellator.startDrawingQuads();
            tessellator.setNormal(0.0F, -1F, 0.0F);
            renderBlockCrops_do(block, i, -0.5D, -0.5D, -0.5D, false);
            tessellator.draw();
        } else
        if(k == 2)
        {
            tessellator.startDrawingQuads();
            tessellator.setNormal(0.0F, -1F, 0.0F);
            renderTorchAtAngle(block, -0.5D, -0.5D, -0.5D, 0.0D, 0.0D, false);
            tessellator.draw();
        } else
        if(k == 10)
        {
            GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
            for(int l = 0; l < 2; l++)
            {
                if(l == 0)
                {
                    block.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.5F);
                }
                if(l == 1)
                {
                    block.setBlockBounds(0.0F, 0.0F, 0.5F, 1.0F, 0.5F, 1.0F);
                }
                tessellator.startDrawingQuads();
                tessellator.setNormal(0.0F, -1F, 0.0F);
                renderBottomFace(block, 0.0D, 0.0D, 0.0D, block.getBlockTextureFromSide(0));
                tessellator.draw();
                tessellator.startDrawingQuads();
                tessellator.setNormal(0.0F, 1.0F, 0.0F);
                renderTopFace(block, 0.0D, 0.0D, 0.0D, block.getBlockTextureFromSide(1));
                tessellator.draw();
                tessellator.startDrawingQuads();
                tessellator.setNormal(0.0F, 0.0F, -1F);
                renderEastFace(block, 0.0D, 0.0D, 0.0D, block.getBlockTextureFromSide(2));
                tessellator.draw();
                tessellator.startDrawingQuads();
                tessellator.setNormal(0.0F, 0.0F, 1.0F);
                renderWestFace(block, 0.0D, 0.0D, 0.0D, block.getBlockTextureFromSide(3));
                tessellator.draw();
                tessellator.startDrawingQuads();
                tessellator.setNormal(-1F, 0.0F, 0.0F);
                renderNorthFace(block, 0.0D, 0.0D, 0.0D, block.getBlockTextureFromSide(4));
                tessellator.draw();
                tessellator.startDrawingQuads();
                tessellator.setNormal(1.0F, 0.0F, 0.0F);
                renderSouthFace(block, 0.0D, 0.0D, 0.0D, block.getBlockTextureFromSide(5));
                tessellator.draw();
            }
            GL11.glTranslatef(0.5F, 0.5F, 0.5F);

        } else
        if(k == 11)
        {
            GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
            for(int i1 = 0; i1 < 4; i1++)
            {
                float f4 = 0.125F;
                if(i1 == 0)
                {
                    block.setBlockBounds(0.5F - f4, 0.0F, 0.0F, 0.5F + f4, 1.0F, f4 * 2.0F);
                }
                if(i1 == 1)
                {
                    block.setBlockBounds(0.5F - f4, 0.0F, 1.0F - f4 * 2.0F, 0.5F + f4, 1.0F, 1.0F);
                }
                f4 = 0.0625F;
                if(i1 == 2)
                {
                    block.setBlockBounds(0.5F - f4, 1.0F - f4 * 3F, -f4 * 2.0F, 0.5F + f4, 1.0F - f4, 1.0F + f4 * 2.0F);
                }
                if(i1 == 3)
                {
                    block.setBlockBounds(0.5F - f4, 0.5F - f4 * 3F, -f4 * 2.0F, 0.5F + f4, 0.5F - f4, 1.0F + f4 * 2.0F);
                }
                tessellator.startDrawingQuads();
                tessellator.setNormal(0.0F, -1F, 0.0F);
                renderBottomFace(block, 0.0D, 0.0D, 0.0D, block.getBlockTextureFromSide(0));
                tessellator.draw();
                tessellator.startDrawingQuads();
                tessellator.setNormal(0.0F, 1.0F, 0.0F);
                renderTopFace(block, 0.0D, 0.0D, 0.0D, block.getBlockTextureFromSide(1));
                tessellator.draw();
                tessellator.startDrawingQuads();
                tessellator.setNormal(0.0F, 0.0F, -1F);
                renderEastFace(block, 0.0D, 0.0D, 0.0D, block.getBlockTextureFromSide(2));
                tessellator.draw();
                tessellator.startDrawingQuads();
                tessellator.setNormal(0.0F, 0.0F, 1.0F);
                renderWestFace(block, 0.0D, 0.0D, 0.0D, block.getBlockTextureFromSide(3));
                tessellator.draw();
                tessellator.startDrawingQuads();
                tessellator.setNormal(-1F, 0.0F, 0.0F);
                renderNorthFace(block, 0.0D, 0.0D, 0.0D, block.getBlockTextureFromSide(4));
                tessellator.draw();
                tessellator.startDrawingQuads();
                tessellator.setNormal(1.0F, 0.0F, 0.0F);
                renderSouthFace(block, 0.0D, 0.0D, 0.0D, block.getBlockTextureFromSide(5));
                tessellator.draw();
            }
            GL11.glTranslatef(0.5F, 0.5F, 0.5F);

            block.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
        } else
        if(k == 19)
        {
            GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
            for(int i1 = 0; i1 < 5; i1++)
            {
            	if(i > 7)
            	{
            		if(i1 == 0)
            		{
            			block.setBlockBounds(0.0625F, 0F, 0.0625F, 0.1875F, 0.625F, 0.1875F);
            		}
            		if(i1 == 1)
            		{
            			block.setBlockBounds(0.8125F, 0F, 0.0625F, 0.9375F, 0.625F, 0.1875F);
            		}
            		if(i1 == 2)
            		{
            			block.setBlockBounds(0.0625F, 0F, 0.8125F, 0.1875F, 0.625F, 0.9375F);
            		}
            		if(i1 == 3)
            		{
            			block.setBlockBounds(0.8125F, 0F, 0.8125F, 0.9375F, 0.625F, 0.9375F);
            		}
            		if(i1 == 4)
            		{
            			block.setBlockBounds(0F, 0.625F, 0F, 1F, 0.75F, 1F);
            		}
            	}else
            	{
            		if(i1 == 0)
            		{
                		block.setBlockBounds(0F, 0F, 0F, 0.125F, 0.875F, 0.125F);
            		}
            		if(i1 == 1)
            		{
                		block.setBlockBounds(0.875F, 0F, 0F, 1F, 0.875F, 0.125F);
            		}
            		if(i1 == 2)
            		{
                		block.setBlockBounds(0F, 0F, 0.875F, 0.125F, 0.875F, 1F);
            		}
            		if(i1 == 3)
            		{
                		block.setBlockBounds(0.875F, 0F, 0.875F, 1F, 0.875F, 1F);
            		}
            		if(i1 == 4)
            		{
                		block.setBlockBounds(0F, 0.875F, 0F, 1F, 1F, 1F);
            		}
            	}
                tessellator.startDrawingQuads();
                tessellator.setNormal(0.0F, -1F, 0.0F);
                renderBottomFace(block, 0.0D, 0.0D, 0.0D, block.getBlockTextureFromSideAndMetadata(0, i));
                tessellator.setNormal(0.0F, 1.0F, 0.0F);
                renderTopFace(block, 0.0D, 0.0D, 0.0D, block.getBlockTextureFromSideAndMetadata(1, i));
                tessellator.setNormal(0.0F, 0.0F, -1F);
                renderEastFace(block, 0.0D, 0.0D, 0.0D, block.getBlockTextureFromSideAndMetadata(2, i));
                tessellator.setNormal(0.0F, 0.0F, 1.0F);
                renderWestFace(block, 0.0D, 0.0D, 0.0D, block.getBlockTextureFromSideAndMetadata(3, i));
                tessellator.setNormal(-1F, 0.0F, 0.0F);
                renderNorthFace(block, 0.0D, 0.0D, 0.0D, block.getBlockTextureFromSideAndMetadata(4, i));
                tessellator.setNormal(1.0F, 0.0F, 0.0F);
                renderSouthFace(block, 0.0D, 0.0D, 0.0D, block.getBlockTextureFromSideAndMetadata(5, i));
                tessellator.draw();
            }
    		block.setBlockBounds(0F, 0F, 0F, 1F, 1F, 1F);
            GL11.glTranslatef(0.5F, 0.5F, 0.5F);
        }else
        {
            ModLoader.RenderInvBlock(this, block, i, k);
        }
    }

    public static boolean renderItemIn3d(int i)
    {
    	switch(i)
    	{
    	case 0: return true;
    	case 13: return true;
    	case 10: return true;
    	case 11: return true;
    	case 19: return true;
    	default: return ModLoader.RenderBlockIsItemFull3D(i);
    	}
    }
    
    public static float bottomFaceBrightness = 0.5F;
    public static float topFaceBrightness = 1.0F;
    public static float eastWestFaceBrightness = 0.8F;
    public static float northSouthFaceBrightness = 0.6F;
    public IBlockAccess blockAccess;
    public int overrideBlockTexture;
    public boolean flipTexture;
    public boolean flipEastTexture;
    public boolean flipBottomTexture;
    public boolean flipSouthTexture;
    public boolean renderAllFaces;
    public static boolean fancyGrass = true;
    public static boolean cfgGrassFix = true;
    public boolean field_31088_b;
    public int eastFaceRotation;
    public int westFaceRotation;
    public int southFaceRotation;
    public int northFaceRotation;
    public int topFaceRotation;
    public int bottomFaceRotation;
    public boolean enableAO;
    public float aoLightValueXNeg;
    public float aoLightValueYNeg;
    public float aoLightValueZNeg;
    public float aoLightValueXPos;
    public float aoLightValueYPos;
    public float aoLightValueZPos;
    public float field_22377_m;
    public float field_22376_n;
    public float field_22375_o;
    public float field_22374_p;
    public float field_22373_q;
    public float field_22372_r;
    public float field_22371_s;
    public float field_22370_t;
    public float field_22369_u;
    public float field_22368_v;
    public float field_22367_w;
    public float field_22366_x;
    public float field_22365_y;
    public float field_22364_z;
    public float field_22362_A;
    public float field_22360_B;
    public float field_22358_C;
    public float field_22356_D;
    public float field_22354_E;
    public float field_22353_F;
    public int field_22352_G;
    public float colorRedTopLeft;
    public float colorRedBottomLeft;
    public float colorRedBottomRight;
    public float colorRedTopRight;
    public float colorGreenTopLeft;
    public float colorGreenBottomLeft;
    public float colorGreenBottomRight;
    public float colorGreenTopRight;
    public float colorBlueTopLeft;
    public float colorBlueBottomLeft;
    public float colorBlueBottomRight;
    public float colorBlueTopRight;
    public boolean field_22339_T;
    public boolean field_22338_U;
    public boolean field_22337_V;
    public boolean field_22336_W;
    public boolean field_22335_X;
    public boolean field_22334_Y;
    public boolean field_22333_Z;
    public boolean field_22363_aa;
    public boolean field_22361_ab;
    public boolean field_22359_ac;
    public boolean field_22357_ad;
    public boolean field_22355_ae;
    private int field_35936_P;
    private int field_35935_Q;
    private int field_35938_R;
    private int field_35937_S;
    private int field_35932_T;
    private int field_35931_U;
    private int field_35934_V;
    private int field_35933_W;
    private int field_35940_X;
    private int field_35939_Y;
    private int field_35941_Z;
    private int field_35951_aa;
    private int field_35952_ab;
    private int field_35949_ac;
    private int field_35950_ad;
    private int field_35955_ae;
    private int field_35956_af;
    private int field_35953_ag;
    private int field_35954_ah;
    private int field_35945_ai;
    private int brightnessTopLeft;
    private int brightnessBottomLeft;
    private int brightnessBottomRight;
    private int brightnessTopRight;
    public static float redstoneColors[][];
    static 
    {
        redstoneColors = new float[16][];
        for(int i = 0; i < redstoneColors.length; i++)
        {
            float f = (float)i / 15F;
            float f1 = f * 0.6F + 0.4F;
            if(i == 0)
            {
                f = 0.0F;
            }
            float f2 = f * f * 0.7F - 0.5F;
            float f3 = f * f * 0.6F - 0.7F;
            if(f2 < 0.0F)
            {
                f2 = 0.0F;
            }
            if(f3 < 0.0F)
            {
                f3 = 0.0F;
            }
            redstoneColors[i] = (new float[] {
                f1, f2, f3
            });
        }

    }
    private static int waterColors[] = new int[] {
    		0xcbcbcb, 0xffffff, 0xb0c0aa, 0xffffaa
    };
    public static float avg;
    private Minecraft mc;
    public static boolean fancyAO = false;
    public static boolean grassSide = true;
}
