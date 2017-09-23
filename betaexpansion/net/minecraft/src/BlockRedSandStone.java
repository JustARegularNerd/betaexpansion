package net.minecraft.src;


public class BlockRedSandStone extends Block
{

    public BlockRedSandStone(int i, int j)
    {
        super(i, j, Material.rock);
    }

    public int getBlockTextureFromSide(int i)
    {
        if(i == 1)
        {
            return blockIndexInTexture - 16;
        }
        if(i == 0)
        {
            return blockIndexInTexture + 16;
        } else
        {
            return blockIndexInTexture;
        }
    }
    
    public int getRenderBlockPass()
    {
        return 2;
    }
}
