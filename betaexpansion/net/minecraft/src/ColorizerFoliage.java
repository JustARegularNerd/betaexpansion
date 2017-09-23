// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;


public class ColorizerFoliage
{

    public ColorizerFoliage()
    {
    }

    public static void func_28152_a(int ai[])
    {
        foliageBuffer = ai;
    }

    public static void func_28152_b(int ai[])
    {
        foliageBufferNext = ai;
    }
    public static final double lerp(double d, int d1, int d2)
    {
        return d1 + d * (d2 - d1);
    }
    public static int getFoliageColor(double d, double d1)
    {
        d1 *= d;
        int x = (int)((1.0D - d) * 255D);
        int y = (int)((1.0D - d1) * 255D);
        int index = (y << 8) | x;
        int index2 = (y << 8) | x;
        if(index > foliageBuffer.length - 1) index = foliageBuffer.length - 1;
        if(index2 > foliageBufferNext.length - 1) index2 = foliageBufferNext.length - 1;
        int i = ((foliageBuffer[index] >> 24) & 0xff);
        int j = ((foliageBuffer[index] >> 16) & 0xff);
        int k = ((foliageBuffer[index] >> 8) & 0xff);
        int l = ((foliageBuffer[index]) & 0xff);
        int i1 = ((foliageBufferNext[index2] >> 24) & 0xff);
        int j1 = ((foliageBufferNext[index2] >> 16) & 0xff);
        int k1 = ((foliageBufferNext[index2] >> 8) & 0xff);
        int l1 = ((foliageBufferNext[index2]) & 0xff);
        int i2 = (int)lerp((double)avg, i, i1)&0xff;
        int j2 = (int)lerp((double)avg, j, j1)&0xff;
        int k2 = (int)lerp((double)avg, k, k1)&0xff;
        int l2 = (int)lerp((double)avg, l, l1)&0xff;
        return i2 << 24 | j2 << 16 | k2 << 8 | l2;
    }
    public static int getFoliageColorPine()
    {
        return 0x619961;
    }

    public static int getFoliageColorBirch()
    {
        return 0x80a755;
    }

    public static int func_31073_c()
    {
        return 0x48b518;
    }

    private static int foliageBuffer[] = new int[0x10000];
    private static int foliageBufferNext[] = new int[0x10000];
    public static float avg = 0f;
}
