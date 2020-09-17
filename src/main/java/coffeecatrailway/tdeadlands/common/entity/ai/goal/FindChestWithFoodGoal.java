package coffeecatrailway.tdeadlands.common.entity.ai.goal;

import coffeecatrailway.tdeadlands.common.entity.RatEntity;
import coffeecatrailway.tdeadlands.integration.registrate.DeadTags;
import coffeecatrailway.tdeadlands.registry.DeadItems;
import net.minecraft.block.BlockState;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.goal.MoveToBlockGoal;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.LockableLootTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author CoffeeCatRailway
 * Created: 15/09/2020
 */
public class FindChestWithFoodGoal extends MoveToBlockGoal
{

    private int ticker;

    public FindChestWithFoodGoal(CreatureEntity entity)
    {
        super(entity, 1.2f, 12);
    }

    @Override
    public boolean shouldContinueExecuting()
    {
        return super.shouldContinueExecuting();
    }

    @Override
    public double getTargetDistanceSq()
    {
        return 2d;
    }

    @Override
    public boolean shouldMove()
    {
        return this.timeoutCounter % 100 == 0;
    }

    @Override
    public boolean shouldExecute()
    {
        return !this.creature.isAggressive() && super.shouldExecute();
    }

    @Override
    public void startExecuting()
    {
        this.ticker = 0;
        super.startExecuting();
    }

    @Override
    public void tick()
    {
        if (this.getIsAboveDestination())
        {
            if (this.ticker >= 40)
                this.eatFoodInChest(this.creature.world, this.creature);
            else
                this.ticker++;
        } else if (!this.getIsAboveDestination() && this.creature.world.rand.nextFloat() < .05f)
            this.creature.playSound(SoundEvents.ENTITY_FOX_SNIFF, 1f, 1f);

        super.tick();
    }

    private void eatFoodInChest(World world, CreatureEntity entity)
    {
        if (ForgeEventFactory.getMobGriefingEvent(world, entity))
        {
            LazyOptional<IItemHandler> chestCap = this.getChest(world, this.destinationBlock);
            chestCap.ifPresent(handler -> {
                for (int i = 0; i < handler.getSlots(); i++)
                {
                    if (world.rand.nextFloat() < .05f)
                    {
                        ItemStack stack = handler.getStackInSlot(i);
                        Item item = stack.getItem();
                        if (!DeadTags.Items.RAT_IGNORE.contains(item))
                        {
                            if (!stack.isEmpty() && item.isFood())
                            {
                                int count = stack.getCount();
                                handler.extractItem(i, count, false);
                                handler.insertItem(i, new ItemStack(DeadItems.RAT_DROPPINGS.get(), count), false);

                                entity.heal(item.getFood().getHealing());
                                world.playSound(null, entity.getPosX(), entity.getPosY(), entity.getPosZ(), entity.getEatSound(stack), SoundCategory.NEUTRAL, .5f, 1f + (world.rand.nextFloat() - world.rand.nextFloat()) * .4f);
                                entity.applyFoodEffects(stack, world, entity);
                            }
                        }
                    }
                }
            });
        }
    }

    private LazyOptional<IItemHandler> getChest(IWorldReader world, BlockPos pos)
    {
        BlockState state = world.getBlockState(pos);
        if (state.isIn(DeadTags.Blocks.RAT_SEARCH) && !state.isIn(Tags.Blocks.CHESTS_ENDER))
        {
            if (state.hasTileEntity())
            {
                TileEntity tile = world.getTileEntity(pos);
                if (tile instanceof LockableLootTileEntity && tile.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY).isPresent())
                {
                    return tile.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY);
                }
            }
        }
        return LazyOptional.empty();
    }

    @Override
    protected boolean shouldMoveTo(IWorldReader world, BlockPos pos)
    {
        LazyOptional<IItemHandler> chestCap = this.getChest(world, pos);
        AtomicBoolean foodFlag = new AtomicBoolean(false);

        chestCap.ifPresent(handler -> {
            for (int i = 0; i < handler.getSlots(); i++)
            {
                ItemStack stack = handler.getStackInSlot(i);
                Item item = stack.getItem();
                if (!DeadTags.Items.RAT_IGNORE.contains(item))
                {
                    if (!stack.isEmpty() && item.isFood())
                    {
                        foodFlag.set(true);
                        break;
                    }
                }
            }
        });
        return foodFlag.get();
    }
}
