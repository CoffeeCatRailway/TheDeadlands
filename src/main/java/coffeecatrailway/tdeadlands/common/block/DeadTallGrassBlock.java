package coffeecatrailway.tdeadlands.common.block;

import coffeecatrailway.tdeadlands.registry.DeadBlocks;
import net.minecraft.block.*;
import net.minecraft.entity.IShearable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.IForgeShearable;

import java.util.Random;

/**
 * @author CoffeeCatRailway
 * Created: 17/09/2020
 */
public class DeadTallGrassBlock extends BushBlock implements IGrowable, IForgeShearable
{
    private static final VoxelShape SHAPE = Block.makeCuboidShape(2d, 0d, 2d, 14d, 13d, 14d);

    public DeadTallGrassBlock(Properties properties)
    {
        super(properties);
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader world, BlockPos pos, ISelectionContext context)
    {
        return SHAPE;
    }

    @Override
    public boolean canGrow(IBlockReader world, BlockPos pos, BlockState state, boolean isClient)
    {
        return true;
    }

    @Override
    public boolean canUseBonemeal(World world, Random rand, BlockPos pos, BlockState state)
    {
        return true;
    }

    @Override
    public void grow(ServerWorld world, Random rand, BlockPos pos, BlockState state) {
        if (DeadBlocks.COLD_TALL_GRASS.get().getDefaultState().isValidPosition(world, pos) && world.isAirBlock(pos.up()))
            DeadBlocks.COLD_TALL_GRASS.get().placeAt(world, pos, 2);
    }

    @Override
    public Block.OffsetType getOffsetType() {
        return Block.OffsetType.XYZ;
    }

    @Override
    public boolean isValidPosition(BlockState state, IWorldReader world, BlockPos pos) {
        BlockState downState = world.getBlockState(pos.down());
        return DeadBlocks.isSoil(downState) || downState.getBlock() == Blocks.FARMLAND;
    }
}
