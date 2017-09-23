// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;


public class ColorizerGrass
{

    public ColorizerGrass()
    {
    }

    public static void func_28181_a(int ai[])
    {
        grassBuffer = ai;
    }

    public static void func_28181_b(int ai[])
    {
        grassBufferNext = ai;
    }
    public static final double lerp(double d, int d1, int d2)
    {
        return d1 + d * (d2 - d1);
    }
    public static int getGrassColor(double d, double d1)
    {
        d1 *= d;
        int x = (int)((1.0D - d) * 255D);
        int y = (int)((1.0D - d1) * 255D);
        int index = (y << 8) | x;
        int index2 = (y << 8) | x;
        if(index > grassBuffer.length - 1) index = grassBuffer.length - 1;
        if(index2 > grassBufferNext.length - 1) index2 = grassBufferNext.length - 1;
        int i = ((grassBuffer[index] >> 24) & 0xff);
        int j = ((grassBuffer[index] >> 16) & 0xff);
        int k = ((grassBuffer[index] >> 8) & 0xff);
        int l = ((grassBuffer[index]) & 0xff);
        int i1 = ((grassBufferNext[index2] >> 24) & 0xff);
        int j1 = ((grassBufferNext[index2] >> 16) & 0xff);
        int k1 = ((grassBufferNext[index2] >> 8) & 0xff);
        int l1 = ((grassBufferNext[index2]) & 0xff);
        int i2 = (int)lerp((double)avg, i, i1)&0xff;
        int j2 = (int)lerp((double)avg, j, j1)&0xff;
        int k2 = (int)lerp((double)avg, k, k1)&0xff;
        int l2 = (int)lerp((double)avg, l, l1)&0xff;
        return i2 << 24 | j2 << 16 | k2 << 8 | l2;
    }

    private static int grassBuffer[] = new int[0x10000];
    private static int grassBufferNext[] = new int[0x10000];
    public static float avg = 0f;
}
