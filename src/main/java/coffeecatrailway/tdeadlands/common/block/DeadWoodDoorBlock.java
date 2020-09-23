package coffeecatrailway.tdeadlands.common.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.DoorBlock;
import net.minecraftforge.common.ToolType;

/**
 * @author CoffeeCatRailway
 * Created: 24/09/2020
 */
public class DeadWoodDoorBlock extends DoorBlock
{
    public DeadWoodDoorBlock(Properties properties)
    {
        super(properties);
    }

    @Override
    public boolean isToolEffective(BlockState state, ToolType tool)
    {
        return tool == ToolType.AXE;
    }
}
