package coffeecatrailway.tdeadlands.common.block;

import coffeecatrailway.tdeadlands.registry.DeadBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.DoublePlantBlock;
import net.minecraft.state.properties.DoubleBlockHalf;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;

/**
 * @author CoffeeCatRailway
 * Created: 17/09/2020
 */
public class DeadDoubleGrassBlock extends DoublePlantBlock
{
    public DeadDoubleGrassBlock(Properties properties)
    {
        super(properties);
    }

    @Override
    public boolean isValidPosition(BlockState state, IWorldReader world, BlockPos pos)
    {
        BlockState downState = world.getBlockState(pos.down());
        Block downBlock = downState.getBlock();
        return DeadBlocks.isSoil(downState) || downBlock == Blocks.FARMLAND || (downBlock == this && downState.get(HALF) == DoubleBlockHalf.LOWER);
    }

    @Override
    public int getFlammability(BlockState state, IBlockReader world, BlockPos pos, Direction face)
    {
        return 100;
    }

    @Override
    public int getFireSpreadSpeed(BlockState state, IBlockReader world, BlockPos pos, Direction face)
    {
        return 60;
    }
}
