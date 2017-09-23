package net.minecraft.src;

public class BlockLauncherBase extends BlockPistonBase{

	public BlockLauncherBase(int i, int j, boolean flag) {
		super(i, j, flag);
	}
	
	public int getRenderBlockPass()
	{
		return 2;
	}
	
    public int getBlockTextureFromSideAndMetadata(int i, int j)
    {
        int k = func_31044_d(j);
        if(k > 5)
        {
            return blockIndexInTexture;
        }
        if(i == k)
        {
            if(isPowered(j) || minX > 0.0D || minY > 0.0D || minZ > 0.0D || maxX < 1.0D || maxY < 1.0D || maxZ < 1.0D)
            {
                return 21;
            } else
            {
                return blockIndexInTexture;
            }
        }
        return i != PistonBlockTextures.field_31057_a[k] ? 5 : 20;
    }
}
