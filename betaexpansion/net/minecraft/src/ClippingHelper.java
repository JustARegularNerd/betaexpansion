// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;


public class ClippingHelper
{

    public ClippingHelper()
    {
        frustum = new float[16][16];
        projectionMatrix = new float[16];
        modelviewMatrix = new float[16];
        clippingMatrix = new float[16];
    }

    public boolean isBoxInFrustum(double d, double d1, double d2, double d3, double d4, double d5, boolean flag)
    {
    	if(flag)
    	{
            for(int i = 0; i < 6; i++)
            {
                if(i < 4)
                {
                	if( frustum[i][0] * d + frustum[i][1] * d1 + frustum[i][2] * d2 + frustum[i][3] <= 0.0D || 
                			frustum[i][0] * d3 + frustum[i][1] * d1 + frustum[i][2] * d2 + frustum[i][3] <= 0.0D || 
                			frustum[i][0] * d + frustum[i][1] * d4 + frustum[i][2] * d2 + frustum[i][3] <= 0.0D || 
                			frustum[i][0] * d3 + frustum[i][1] * d4 + frustum[i][2] * d2 + frustum[i][3] <= 0.0D || 
                			frustum[i][0] * d + frustum[i][1] * d1 + frustum[i][2] * d5 + frustum[i][3] <= 0.0D || 
                			frustum[i][0] * d3 + frustum[i][1] * d1 + frustum[i][2] * d5 + frustum[i][3] <= 0.0D || 
                			frustum[i][0] * d + frustum[i][1] * d4 + frustum[i][2] * d5 + frustum[i][3] <= 0.0D || 
                			frustum[i][0] * d3 + frustum[i][1] * d4 + frustum[i][2] * d5 + frustum[i][3] <= 0.0D )
                	{
                		return false;
                	}
                    continue;
                }
                if( frustum[i][0] * d + frustum[i][1] * d1 + frustum[i][2] * d2 + frustum[i][3] <= 0.0D && 
                		frustum[i][0] * d3 + frustum[i][1] * d1 + frustum[i][2] * d2 + frustum[i][3] <= 0.0D && 
                		frustum[i][0] * d + frustum[i][1] * d4 + frustum[i][2] * d2 + frustum[i][3] <= 0.0D && 
                		frustum[i][0] * d3 + frustum[i][1] * d4 + frustum[i][2] * d2 + frustum[i][3] <= 0.0D && 
                		frustum[i][0] * d + frustum[i][1] * d1 + frustum[i][2] * d5 + frustum[i][3] <= 0.0D && 
                		frustum[i][0] * d3 + frustum[i][1] * d1 + frustum[i][2] * d5 + frustum[i][3] <= 0.0D && 
                		frustum[i][0] * d + frustum[i][1] * d4 + frustum[i][2] * d5 + frustum[i][3] <= 0.0D && 
                		frustum[i][0] * d3 + frustum[i][1] * d4 + frustum[i][2] * d5 + frustum[i][3] <= 0.0D )
                {
                	return false;
                }
            }

            return true;
    	}else
    	{
    		for(int i = 0; i < 6; i++)
    		{
    			if((double)frustum[i][0] * d + (double)frustum[i][1] * d1 + (double)frustum[i][2] * d2 + (double)frustum[i][3] <= 0.0D && (double)frustum[i][0] * d3 + (double)frustum[i][1] * d1 + (double)frustum[i][2] * d2 + (double)frustum[i][3] <= 0.0D && (double)frustum[i][0] * d + (double)frustum[i][1] * d4 + (double)frustum[i][2] * d2 + (double)frustum[i][3] <= 0.0D && (double)frustum[i][0] * d3 + (double)frustum[i][1] * d4 + (double)frustum[i][2] * d2 + (double)frustum[i][3] <= 0.0D && (double)frustum[i][0] * d + (double)frustum[i][1] * d1 + (double)frustum[i][2] * d5 + (double)frustum[i][3] <= 0.0D && (double)frustum[i][0] * d3 + (double)frustum[i][1] * d1 + (double)frustum[i][2] * d5 + (double)frustum[i][3] <= 0.0D && (double)frustum[i][0] * d + (double)frustum[i][1] * d4 + (double)frustum[i][2] * d5 + (double)frustum[i][3] <= 0.0D && (double)frustum[i][0] * d3 + (double)frustum[i][1] * d4 + (double)frustum[i][2] * d5 + (double)frustum[i][3] <= 0.0D)
    			{
    				return false;
    			}
    		}
    	}
        return true;
    }
    
    public float frustum[][];
    public float projectionMatrix[];
    public float modelviewMatrix[];
    public float clippingMatrix[];
}
