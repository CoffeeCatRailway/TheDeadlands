package coffeecatrailway.tdeadlands.common.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraftforge.common.ToolType;

/**
 * @author CoffeeCatRailway
 * Created: 24/09/2020
 */
public class PickaxeableBlock extends Block
{
    public PickaxeableBlock(Properties properties)
    {
        super(properties);
    }

    @Override
    public boolean isToolEffective(BlockState state, ToolType tool)
    {
        return tool == ToolType.PICKAXE;
    }
}
