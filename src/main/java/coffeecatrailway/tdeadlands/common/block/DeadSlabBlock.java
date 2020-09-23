package coffeecatrailway.tdeadlands.common.block;

import net.minecraft.block.BlockState;
import net.minecraft.block.SlabBlock;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.ToolType;

/**
 * @author CoffeeCatRailway
 * Created: 23/09/2020
 */
public class DeadSlabBlock extends SlabBlock
{
    private final boolean isFlammable;

    public DeadSlabBlock(Properties properties, boolean isFlammable)
    {
        super(properties);
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
