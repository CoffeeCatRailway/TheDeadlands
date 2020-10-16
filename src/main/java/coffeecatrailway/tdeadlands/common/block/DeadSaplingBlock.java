package coffeecatrailway.tdeadlands.common.block;

import coffeecatrailway.tdeadlands.registry.DeadBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.IGrowable;
import net.minecraft.block.SaplingBlock;
import net.minecraft.block.trees.Tree;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.server.ServerWorld;

import java.util.Random;

/**
 * @author CoffeeCatRailway
 * Created: 14/10/2020
 */
public class DeadSaplingBlock extends SaplingBlock implements IGrowable
{
    public DeadSaplingBlock(Tree tree, Properties properties)
    {
        super(tree, properties);
    }

    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random)
    {
        if (!world.isAreaLoaded(pos, 1))
            return; // Forge: prevent loading unloaded chunks when checking neighbor's light
        if (world.getLight(pos.up()) >= 9 && random.nextInt(7) == 0)
        {
            this.placeTree(world, pos, state, random);
        }
    }

    @Override
    public boolean isValidPosition(BlockState state, IWorldReader world, BlockPos pos)
    {
        BlockState downState = world.getBlockState(pos.down());
        return DeadBlocks.isSoil(downState) || downState.getBlock() == Blocks.FARMLAND;
    }
}
