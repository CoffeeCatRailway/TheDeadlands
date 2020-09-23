package coffeecatrailway.tdeadlands.common.block;

import io.github.ocelot.common.BaseBlock;
import io.github.ocelot.common.VoxelShapeHelper;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.IWaterLoggable;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.function.Supplier;

/**
 * @author CoffeeCatRailway
 * Created: 24/08/2020
 */
public class CoffinBlock extends BaseBlock implements IWaterLoggable
{
    public static final BooleanProperty OPEN = BlockStateProperties.OPEN;
    public static final EnumProperty<CoffinPart> PART = EnumProperty.create("part", CoffinPart.class);

    private static final VoxelShape[] SHAPES = generateShapes();

    public CoffinBlock(Properties properties)
    {
        super(properties);
        this.setDefaultState(this.getStateContainer().getBaseState().with(OPEN, false).with(PART, CoffinPart.BACK).with(WATERLOGGED, false).with(HORIZONTAL_FACING, Direction.NORTH));
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader world, BlockPos pos, ISelectionContext context)
    {
        return SHAPES[state.get(HORIZONTAL_FACING).getHorizontalIndex() + (state.get(PART) == CoffinPart.FRONT ? 4 : 0) + (state.get(OPEN) ? 8 : 0)];
    }

    private Direction getDirectionToOther(CoffinPart part, Direction direction)
    {
        return part == CoffinPart.BACK ? direction : direction.getOpposite();
    }

    @Override
    public BlockState updatePostPlacement(BlockState state, Direction facing, BlockState facingState, IWorld world, BlockPos pos, BlockPos facingPos)
    {
        if (facing == getDirectionToOther(state.get(PART), state.get(HORIZONTAL_FACING)))
        {
            if (facingState.isIn(this) && facingState.get(PART) != state.get(PART))
                return state.with(OPEN, facingState.get(OPEN));
            else
                return Blocks.AIR.getDefaultState();
        }
        return super.updatePostPlacement(state, facing, facingState, world, pos, facingPos);
    }

    @Override
    public void onBlockHarvested(World world, BlockPos pos, BlockState state, PlayerEntity player)
    {
        CoffinPart part = state.get(PART);
        BlockPos offset = pos.offset(getDirectionToOther(part, state.get(HORIZONTAL_FACING)));
        BlockState other = world.getBlockState(offset);
        if (other.getBlock() == this && part != CoffinPart.BACK)
        {
            world.setBlockState(offset, Blocks.AIR.getDefaultState(), 35);
            world.playEvent(player, 2001, offset, Block.getStateId(other));
            if (!world.isRemote && !player.isCreative())
                spawnDrops(other, world, offset, null, player, player.getHeldItemMainhand());
        }
        super.onBlockHarvested(world, pos, state, player);
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder)
    {
        builder.add(OPEN, PART, WATERLOGGED, HORIZONTAL_FACING);
    }

    @Override
    public boolean isValidPosition(BlockState state, IWorldReader world, BlockPos pos)
    {
        CoffinPart part = state.get(PART);
        if (part == CoffinPart.BACK)
            return true;
        BlockState other = world.getBlockState(pos.offset(getDirectionToOther(part, state.get(HORIZONTAL_FACING)).getOpposite()));
        return other.getBlock() == this && other.get(PART) == CoffinPart.BACK;
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context)
    {
        Direction dir = context.getPlacementHorizontalFacing();
        BlockPos pos = context.getPos();
        BlockPos offset = pos.offset(dir);
        return context.getWorld().getBlockState(offset).isReplaceable(context) ? super.getStateForPlacement(context).with(HORIZONTAL_FACING, dir).with(OPEN, false) : null;
    }

    @Override
    public void onBlockPlacedBy(World world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack stack)
    {
        super.onBlockPlacedBy(world, pos, state, placer, stack);
        if (!world.isRemote)
        {
            BlockPos offset = pos.offset(state.get(HORIZONTAL_FACING));
            world.setBlockState(offset, state.with(PART, CoffinPart.FRONT).with(WATERLOGGED, world.getFluidState(offset).getFluid() == Fluids.WATER), 3);
            world.func_230547_a_(pos, Blocks.AIR);
            state.updateNeighbours(world, pos, 3);
        }
    }

    private static VoxelShape[] generateShapes()
    {
        VoxelShape base = new VoxelShapeHelper.Builder().append(
                Block.makeCuboidShape(0d, 0d, 0d, 16d, 1d, 16d),
                Block.makeCuboidShape(1d, 1d, 0d, 15d, 2d, 15d),
                Block.makeCuboidShape(2d, 2d, 0d, 14d, 14d, 14d)
        ).build();
        Supplier<VoxelShapeHelper.Builder> closed = () -> new VoxelShapeHelper.Builder().append(
                base,
                Block.makeCuboidShape(1d, 14d, 0d, 15d, 15d, 15d),
                Block.makeCuboidShape(2d, 15d, 0d, 14d, 16d, 14d)
        );
        Supplier<VoxelShapeHelper.Builder> open = () -> new VoxelShapeHelper.Builder().append(VoxelShapes.combine(base, Block.makeCuboidShape(3d, 2d, 0d, 13d, 14d, 12d), IBooleanFunction.ONLY_FIRST));

        VoxelShape[] shapes = new VoxelShape[4 * 2 * 2];
        Direction[] horizontal = {Direction.NORTH, Direction.SOUTH, Direction.EAST, Direction.WEST};
        for (Direction dir : horizontal)
        {
            shapes[dir.getHorizontalIndex()] = closed.get().rotate(dir.getOpposite()).build();
            shapes[dir.getHorizontalIndex() + 4] = closed.get().rotate(dir).build();

            shapes[dir.getHorizontalIndex() + 8] = open.get().rotate(dir.getOpposite()).build();
            shapes[dir.getHorizontalIndex() + 8 + 4] = open.get().rotate(dir).build();
        }
        return shapes;
    }
}
