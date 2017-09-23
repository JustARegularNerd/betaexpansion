package net.minecraft.src;

public class BlockRedSand extends BlockSand{
	public BlockRedSand(int i, int j)
	{
		super(i, j);
	}
	
	public int getRenderBlockPass()
	{
		return 2;
	}
}
