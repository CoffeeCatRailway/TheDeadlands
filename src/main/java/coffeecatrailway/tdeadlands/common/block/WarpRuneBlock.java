package coffeecatrailway.tdeadlands.common.block;

import io.github.ocelot.common.BaseBlock;
import io.github.ocelot.common.VoxelShapeHelper;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.IWaterLoggable;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.state.properties.DoubleBlockHalf;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;

import javax.annotation.Nullable;

/**
 * @author CoffeeCatRailway
 * Created: 23/08/2020
 */
public class WarpRuneBlock extends BaseBlock implements IWaterLoggable {

    public static final BooleanProperty POWERED = BlockStateProperties.POWERED;
    public static final EnumProperty<DoubleBlockHalf> HALF = BlockStateProperties.DOUBLE_BLOCK_HALF;

    private static final VoxelShape LOWER = new VoxelShapeHelper.Builder().append(
            Block.makeCuboidShape(2d, 0d, 2d, 14d, 13d, 14d),
            Block.makeCuboidShape(4d, 13d, 4d, 12d, 16d, 12d)
    ).build();
    private static final VoxelShape UPPER = new VoxelShapeHelper.Builder().append(
            Block.makeCuboidShape(4d, 0d, 4d, 12d, 8d, 12d),
            Block.makeCuboidShape(6d, 8d, 6d, 10d, 16d, 10d)
    ).build();

    public WarpRuneBlock(Properties properties) {
        super(properties);
        this.setDefaultState(this.stateContainer.getBaseState().with(POWERED, false).with(HALF, DoubleBlockHalf.LOWER).with(WATERLOGGED, false));
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader world, BlockPos pos, ISelectionContext context) {
        return state.get(HALF) == DoubleBlockHalf.LOWER ? LOWER : UPPER;
    }

    @Override
    public BlockState updatePostPlacement(BlockState state, Direction facing, BlockState facingState, IWorld world, BlockPos pos, BlockPos facingPos) {
        DoubleBlockHalf half = state.get(HALF);
        if (facing.getAxis() != Direction.Axis.Y || (half == DoubleBlockHalf.LOWER) != (facing == Direction.UP) || (facingState.getBlock() == this) && (facingState.get(HALF) != half))
            if (half != DoubleBlockHalf.LOWER || facing != Direction.DOWN || state.isValidPosition(world, pos))
                return state;
        return Blocks.AIR.getDefaultState();
    }

    @Override
    public void onBlockHarvested(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        DoubleBlockHalf half = state.get(HALF);
        BlockPos offset = half == DoubleBlockHalf.LOWER ? pos.up() : pos.down();
        BlockState other = world.getBlockState(offset);
        if (other.getBlock() == this && other.get(HALF) != half) {
            world.setBlockState(offset, Blocks.AIR.getDefaultState(), 35);
            world.playEvent(player, 2001, offset, Block.getStateId(other));
            if (!world.isRemote && !player.isCreative())
                spawnDrops(other, world, offset, null, player, player.getHeldItemMainhand());
        }
        super.onBlockHarvested(world, pos, state, player);
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(POWERED, HALF, WATERLOGGED);
    }

    @Override
    public boolean isValidPosition(BlockState state, IWorldReader world, BlockPos pos) {
        if (state.get(HALF) == DoubleBlockHalf.LOWER)
            return true;
        BlockState below = world.getBlockState(pos.down());
        return below.getBlock() == this && below.get(HALF) == DoubleBlockHalf.LOWER;
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        BlockPos pos = context.getPos();
        if (pos.getY() < context.getWorld().getHeight() - 1)
            if (context.getWorld().getBlockState(pos.up()).isReplaceable(context))
                return super.getStateForPlacement(context).with(POWERED, false);
        return null;
    }

    @Override
    public void onBlockPlacedBy(World world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack stack) {
        world.setBlockState(pos.up(), state.with(HALF, DoubleBlockHalf.UPPER));
    }
}
