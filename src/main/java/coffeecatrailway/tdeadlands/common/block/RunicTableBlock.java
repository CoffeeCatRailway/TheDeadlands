package coffeecatrailway.tdeadlands.common.block;

import coffeecatrailway.tdeadlands.common.tileentity.RunicTableTileEntity;
import io.github.ocelot.sonar.common.block.BaseBlock;
import io.github.ocelot.sonar.common.util.VoxelShapeHelper;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.state.StateContainer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.ToolType;

import javax.annotation.Nullable;

/**
 * @author CoffeeCatRailway
 * Created: 19/09/2020
 */
public class RunicTableBlock extends BaseBlock
{
    private static final VoxelShape SHAPE = new VoxelShapeHelper.Builder().append(Block.makeCuboidShape(1f, 1f, 1f, 15f, 10f, 15f),
            Block.makeCuboidShape(0f, 0f, 0f, 3f, 11f, 3f),
            Block.makeCuboidShape(13f, 0f, 0f, 16f, 11f, 3f),
            Block.makeCuboidShape(13f, 0f, 13f, 16f, 11f, 16f),
            Block.makeCuboidShape(0f, 0f, 13f, 3f, 11f, 16f)).build();

    public RunicTableBlock(Properties properties)
    {
        super(properties);
        this.setDefaultState(this.getStateContainer().getBaseState().with(WATERLOGGED, false).with(HORIZONTAL_FACING, Direction.NORTH));
    }

    @Override
    public boolean isToolEffective(BlockState state, ToolType tool)
    {
        return tool == ToolType.PICKAXE;
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader world, BlockPos pos, ISelectionContext context)
    {
        return SHAPE;
    }

    @Override
    public boolean hasTileEntity(BlockState state)
    {
        return true;
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world)
    {
        return new RunicTableTileEntity();
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder)
    {
        builder.add(WATERLOGGED, HORIZONTAL_FACING);
    }
}
