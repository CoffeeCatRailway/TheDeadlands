package coffeecatrailway.tdeadlands.common.block;

import net.minecraft.block.BlockState;
import net.minecraft.block.PressurePlateBlock;
import net.minecraftforge.common.ToolType;

/**
 * @author CoffeeCatRailway
 * Created: 24/09/2020
 */
public class DeadPressurePlateBlock extends PressurePlateBlock
{
    private final boolean isStone;

    public DeadPressurePlateBlock(Sensitivity sensitivity, Properties properties, boolean isStone)
    {
        super(sensitivity, properties);
        this.isStone = isStone;
    }

    @Override
    public boolean isToolEffective(BlockState state, ToolType tool)
    {
        return tool == (this.isStone ? ToolType.PICKAXE : ToolType.AXE);
    }
}
