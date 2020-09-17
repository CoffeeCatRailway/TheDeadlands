package coffeecatrailway.tdeadlands.common.entity.ai.goal;

import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.ai.goal.TemptGoal;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tags.ITag;

import java.util.function.Supplier;

/**
 * @author CoffeeCatRailway
 * Created: 15/09/2020
 */
public class TemptGoalTag extends TemptGoal
{
    private final Supplier<ITag.INamedTag<Item>> tempItems;

    public TemptGoalTag(CreatureEntity creatureIn, double speedIn, Supplier<ITag.INamedTag<Item>> temptItems, boolean scaredByPlayerMovementIn)
    {
        super(creatureIn, speedIn, null, scaredByPlayerMovementIn);
        this.tempItems = temptItems;
    }

    public TemptGoalTag(CreatureEntity creatureIn, double speedIn, boolean scaredByPlayerMovementIn, Supplier<ITag.INamedTag<Item>> temptItems)
    {
        super(creatureIn, speedIn, scaredByPlayerMovementIn, null);
        this.tempItems = temptItems;
    }

    @Override
    protected boolean isTempting(ItemStack stack)
    {
        return this.tempItems.get().contains(stack.getItem());
    }
}
