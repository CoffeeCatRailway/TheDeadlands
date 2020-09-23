package coffeecatrailway.tdeadlands.common.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

import javax.annotation.Nullable;
import java.util.function.Supplier;

/**
 * @author CoffeeCatRailway
 * Created: 23/09/2020
 */
public class DeadLogBlock extends RotatedPillarBlock
{
    private final Supplier<DeadLogBlock> strippedLog;

    public DeadLogBlock(Properties properties, Supplier<DeadLogBlock> strippedLog)
    {
        super(properties);
        this.strippedLog = strippedLog;
    }

    @Override
    public boolean isToolEffective(BlockState state, ToolType tool)
    {
        return tool == ToolType.AXE;
    }

    @Nullable
    @Override
    public BlockState getToolModifiedState(BlockState state, World world, BlockPos pos, PlayerEntity player, ItemStack stack, ToolType toolType)
    {
        return toolType == ToolType.AXE && strippedLog.get() != null ? strippedLog.get().getDefaultState() : super.getToolModifiedState(state, world, pos, player, stack, toolType);
    }

    @Override
    public boolean isFlammable(BlockState state, IBlockReader world, BlockPos pos, Direction face)
    {
        return true;
    }

    @Override
    public int getFlammability(BlockState state, IBlockReader world, BlockPos pos, Direction face)
    {
        return 5;
    }

    @Override
    public int getFireSpreadSpeed(BlockState state, IBlockReader world, BlockPos pos, Direction face)
    {
        return 5;
    }
}
