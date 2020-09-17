package coffeecatrailway.tdeadlands.common.entity;

import coffeecatrailway.tdeadlands.common.entity.ai.goal.TemptGoalTag;
import coffeecatrailway.tdeadlands.registry.DeadEntities;
import net.minecraft.block.BlockState;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.Tags;

import javax.annotation.Nullable;

/**
 * @author CoffeeCatRailway
 * Created: 12/09/2020
 */
public class MuskOxEntity extends AnimalEntity implements ICreateSpawnPacket<MuskOxEntity>
{
    public MuskOxEntity(EntityType<? extends MuskOxEntity> type, World worldIn)
    {
        super(type, worldIn);
    }

    public static AttributeModifierMap.MutableAttribute registerAttributeMap()
    {
        return MobEntity.func_233666_p_().createMutableAttribute(Attributes.MAX_HEALTH, 10f)
                .createMutableAttribute(Attributes.MOVEMENT_SPEED, .2f);
    }

    @Override
    protected void registerGoals()
    {
        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(1, new PanicGoal(this, 1.25f));
        this.goalSelector.addGoal(3, new BreedGoal(this, 1f));
        this.goalSelector.addGoal(4, new TemptGoalTag(this, 1.2f, false, () -> Tags.Items.CROPS_WHEAT)); // TODO Add grass strands
        this.goalSelector.addGoal(5, new FollowParentGoal(this, 1.1f));
        this.goalSelector.addGoal(6, new WaterAvoidingRandomWalkingGoal(this, 1f));
        this.goalSelector.addGoal(7, new LookAtGoal(this, PlayerEntity.class, 6f));
        this.goalSelector.addGoal(8, new LookRandomlyGoal(this));
    }

    @Override
    protected SoundEvent getAmbientSound()
    {
        return SoundEvents.ENTITY_COW_AMBIENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSource)
    {
        return SoundEvents.ENTITY_COW_HURT;
    }

    @Override
    protected SoundEvent getDeathSound()
    {
        return SoundEvents.ENTITY_COW_DEATH;
    }

    @Override
    protected void playStepSound(BlockPos pos, BlockState blockIn)
    {
        this.playSound(SoundEvents.ENTITY_COW_STEP, .15f, 1f);
    }

    @Override
    protected float getSoundVolume()
    {
        return .4f;
    }

    @Override
    public ActionResultType func_230254_b_(PlayerEntity player, Hand hand)
    {
        ItemStack stack = player.getHeldItem(hand);
        if (stack.getItem() == Items.BUCKET && !this.isChild())
        {
            player.playSound(SoundEvents.ENTITY_COW_MILK, 1f, 1f);
            ItemStack milkStack = DrinkHelper.fill(stack, player, Items.MILK_BUCKET.getDefaultInstance());
            player.setHeldItem(hand, milkStack);
            return ActionResultType.func_233537_a_(this.world.isRemote);
        } else
        {
            return super.func_230254_b_(player, hand);
        }
    }

    @Nullable
    @Override
    public AgeableEntity func_241840_a(ServerWorld world, AgeableEntity entity)
    {
        return DeadEntities.MUSK_OX.get().create(world);
    }

    @Override
    protected float getStandingEyeHeight(Pose pose, EntitySize size)
    {
        return this.isChild() ? .5f : 1f;
    }
}
