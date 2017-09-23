package net.minecraft.src;

import java.util.Random;

public class BlockAppleSapling extends BlockSapling {

	protected BlockAppleSapling(int i, int j) {
		super(i, j);
	}

	public void growTree(World world, int i, int j, int k, Random random) {
		int l = world.getBlockMetadata(i, j, k);
		world.setBlock(i, j, k, 0);
		Object obj = null;
		obj = new WorldGenApple();
		if (!((WorldGenerator) (obj)).generate(world, random, i, j, k)) {
			world.setBlockAndMetadata(i, j, k, BEBlocks.appleSapling.blockID, l);
		}
	}
	
    public int getRenderBlockPass()
    {
        return 2;
    }
}