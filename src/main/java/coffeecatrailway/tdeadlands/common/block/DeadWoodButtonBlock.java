package coffeecatrailway.tdeadlands.common.block;

import net.minecraft.block.BlockState;
import net.minecraft.block.WoodButtonBlock;
import net.minecraftforge.common.ToolType;

/**
 * @author CoffeeCatRailway
 * Created: 24/09/2020
 */
public class DeadWoodButtonBlock extends WoodButtonBlock
{
    public DeadWoodButtonBlock(Properties properties)
    {
        super(properties);
    }

    @Override
    public boolean isToolEffective(BlockState state, ToolType tool)
    {
        return tool == ToolType.AXE;
    }
}
