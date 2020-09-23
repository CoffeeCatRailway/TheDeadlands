package coffeecatrailway.tdeadlands.common.block;

import coffeecatrailway.tdeadlands.common.inventory.container.DeadWoodWorkbenchContainer;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.CraftingTableBlock;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.inventory.container.SimpleNamedContainerProvider;
import net.minecraft.util.Direction;
import net.minecraft.util.IWorldPosCallable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

/**
 * @author CoffeeCatRailway
 * Created: 21/08/2020
 */
public class DeadWoodCraftingTableBlock extends CraftingTableBlock
{
    private static final ITextComponent CONTAINER_NAME = new TranslationTextComponent("container.crafting");

    public DeadWoodCraftingTableBlock(AbstractBlock.Properties properties)
    {
        super(properties);
    }

    public INamedContainerProvider getContainer(BlockState state, World worldIn, BlockPos pos)
    {
        return new SimpleNamedContainerProvider((id, inventory, player) -> new DeadWoodWorkbenchContainer(id, inventory, IWorldPosCallable.of(worldIn, pos)), CONTAINER_NAME);
    }

    @Override
    public boolean isToolEffective(BlockState state, ToolType tool)
    {
        return tool == ToolType.AXE;
    }

    @Override
    public boolean isFlammable(BlockState state, IBlockReader world, BlockPos pos, Direction face)
    {
        return true;
    }

    @Override
    public int getFlammability(BlockState state, IBlockReader world, BlockPos pos, Direction face)
    {
        return 20;
    }

    @Override
    public int getFireSpreadSpeed(BlockState state, IBlockReader world, BlockPos pos, Direction face)
    {
        return 5;
    }
}
