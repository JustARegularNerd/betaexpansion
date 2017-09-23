// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            ICamera, ClippingHelperImpl, ClippingHelper, AxisAlignedBB

public class Frustrum
    implements ICamera
{

    public Frustrum()
    {
        clippingHelper = ClippingHelperImpl.getInstance();
    }

    public void setPosition(double d, double d1, double d2)
    {
        xPos = d;
        yPos = d1;
        zPos = d2;
    }

    public boolean isBoundingBoxInFrustum(AxisAlignedBB aabb, boolean flag)
    {
        return clippingHelper.isBoxInFrustum(aabb.minX - xPos, aabb.minY - yPos, aabb.minZ - zPos, aabb.maxX - xPos, aabb.maxY - yPos, aabb.maxZ - zPos, flag);
    }
    
    private ClippingHelper clippingHelper;
    private double xPos;
    private double yPos;
    private double zPos;
}
