package coffeecatrailway.tdeadlands.common.entity;

import coffeecatrailway.tdeadlands.integration.DeadTags;
import coffeecatrailway.tdeadlands.registry.DeadEntities;
import coffeecatrailway.tdeadlands.registry.DeadItems;
import net.minecraft.block.BlockState;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.IPacket;
import net.minecraft.tileentity.ChestTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.fml.network.NetworkHooks;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;

import javax.annotation.Nullable;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author CoffeeCatRailway
 * Created: 27/08/2020
 */
public class RatEntity extends AnimalEntity {

    public RatEntity(EntityType<? extends RatEntity> type, World world) {
        super(type, world);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1d, true));
        this.goalSelector.addGoal(2, new RatEntity.FindChestWithFoodGoal());
        this.goalSelector.addGoal(2, new WaterAvoidingRandomWalkingGoal(this, .6d));
        this.goalSelector.addGoal(3, new LookAtGoal(this, PlayerEntity.class, 2f));
        this.goalSelector.addGoal(3, new LookRandomlyGoal(this));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this).setCallsForHelp());
    }

    @Nullable
    @Override
    public LivingEntity getAttackTarget() {
        return super.getAttackTarget();
    }

    public static AttributeModifierMap.MutableAttribute registerAttributeMap() {
        return MobEntity.func_233666_p_().createMutableAttribute(Attributes.MAX_HEALTH, 10f).createMutableAttribute(Attributes.MOVEMENT_SPEED, .3f).createMutableAttribute(Attributes.ATTACK_DAMAGE, 1f);
    }

    @Override
    protected void playStepSound(BlockPos pos, BlockState block) {
        this.playSound(SoundEvents.ENTITY_CHICKEN_STEP, .15f, 1f);
    }

    @Nullable
    @Override
    public AgeableEntity func_241840_a(ServerWorld world, AgeableEntity entity) {
        return DeadEntities.RAT.get().create(world);
    }

    @Override
    public IPacket<?> createSpawnPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

    public class FindChestWithFoodGoal extends MoveToBlockGoal {

        private int ticker;

        public FindChestWithFoodGoal() {
            super(RatEntity.this, 1.2f, 12);
        }

        @Override
        public boolean shouldContinueExecuting() {
            return super.shouldContinueExecuting();
        }

        @Override
        public double getTargetDistanceSq() {
            return 2d;
        }

        @Override
        public boolean shouldMove() {
            return this.timeoutCounter % 100 == 0;
        }

        @Override
        public boolean shouldExecute() {
            return !RatEntity.this.isAggressive() && super.shouldExecute();
        }

        @Override
        public void startExecuting() {
            this.ticker = 0;
            super.startExecuting();
        }

        @Override
        public void tick() {
            if (this.getIsAboveDestination()) {
                if (this.ticker >= 40)
                    this.eatFoodInChest(RatEntity.this.world, RatEntity.this);
                else
                    this.ticker++;
            } else if (!this.getIsAboveDestination() && RatEntity.this.rand.nextFloat() < .05f)
                RatEntity.this.playSound(SoundEvents.ENTITY_FOX_SNIFF, 1f, 1f);

            super.tick();
        }

        private void eatFoodInChest(World world, RatEntity rat) {
            if (net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(world, rat)) {
                LazyOptional<IItemHandler> chestCap = this.getChest(world, this.destinationBlock);
                chestCap.ifPresent(handler -> {
                    for (int i = 0; i < handler.getSlots(); i++) {
                        if (rat.rand.nextFloat() < .05f) {
                            ItemStack stack = handler.getStackInSlot(i);
                            Item item = stack.getItem();
                            if (!DeadTags.Items.RAT_IGNORE.contains(item)) {
                                if (!stack.isEmpty() && item.isFood()) {
                                    int count = stack.getCount();
                                    handler.extractItem(i, count, false);
                                    handler.insertItem(i, new ItemStack(DeadItems.RAT_DROPPINGS.get(), count), false);

                                    rat.heal(item.getFood().getHealing());
                                    world.playSound(null, rat.getPosX(), rat.getPosY(), rat.getPosZ(), rat.getEatSound(stack), SoundCategory.NEUTRAL, .5f, 1f + (world.rand.nextFloat() - world.rand.nextFloat()) * .4f);
                                    rat.applyFoodEffects(stack, world, rat);
                                }
                            }
                        }
                    }
                });
            }
        }

        private LazyOptional<IItemHandler> getChest(IWorldReader world, BlockPos pos) {
            BlockState state = world.getBlockState(pos);
            if (state.isIn(DeadTags.Blocks.RAT_SEARCH) && !state.isIn(Tags.Blocks.CHESTS_ENDER)) {
                if (state.hasTileEntity()) {
                    TileEntity tile = world.getTileEntity(pos);
                    if (tile instanceof ChestTileEntity) {
                        return tile.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY);
                    }
                }
            }
            return LazyOptional.empty();
        }

        @Override
        protected boolean shouldMoveTo(IWorldReader world, BlockPos pos) {
            LazyOptional<IItemHandler> chestCap = this.getChest(world, pos);
            AtomicBoolean foodFlag = new AtomicBoolean(false);

            chestCap.ifPresent(handler -> {
                for (int i = 0; i < handler.getSlots(); i++) {
                    ItemStack stack = handler.getStackInSlot(i);
                    Item item = stack.getItem();
                    if (!DeadTags.Items.RAT_IGNORE.contains(item)) {
                        if (!stack.isEmpty() && item.isFood()) {
                            foodFlag.set(true);
                            break;
                        }
                    }
                }
            });
            return foodFlag.get();
        }
    }
}
