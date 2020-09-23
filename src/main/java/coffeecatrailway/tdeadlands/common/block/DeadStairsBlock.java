package coffeecatrailway.tdeadlands.common.block;

import net.minecraft.block.BlockState;
import net.minecraft.block.StairsBlock;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.ToolType;

import java.util.function.Supplier;

/**
 * @author CoffeeCatRailway
 * Created: 23/09/2020
 */
public class DeadStairsBlock extends StairsBlock
{
    private final boolean isFlammable;

    public DeadStairsBlock(Supplier<BlockState> state, Properties properties, boolean isFlammable)
    {
        super(state, properties);
        this.isFlammable = isFlammable;
    }

    @Override
    public boolean isToolEffective(BlockState state, ToolType tool)
    {
        return tool == (this.isFlammable ? ToolType.AXE : ToolType.PICKAXE);
    }

    @Override
    public boolean isFlammable(BlockState state, IBlockReader world, BlockPos pos, Direction face)
    {
        return this.isFlammable;
    }

    @Override
    public int getFlammability(BlockState state, IBlockReader world, BlockPos pos, Direction face)
    {
        return this.isFlammable ? 20 : 0;
    }

    @Override
    public int getFireSpreadSpeed(BlockState state, IBlockReader world, BlockPos pos, Direction face)
    {
        return this.isFlammable ? 5 : 0;
    }
}
