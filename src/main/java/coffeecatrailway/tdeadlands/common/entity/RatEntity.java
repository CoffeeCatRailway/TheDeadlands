package coffeecatrailway.tdeadlands.common.entity;

import coffeecatrailway.tdeadlands.common.entity.ai.goal.FindChestWithFoodGoal;
import coffeecatrailway.tdeadlands.integration.registrate.DeadTags;
import coffeecatrailway.tdeadlands.registry.DeadEntities;
import coffeecatrailway.tdeadlands.registry.DeadItems;
import net.minecraft.block.BlockState;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.pathfinding.GroundPathNavigator;
import net.minecraft.pathfinding.PathNavigator;
import net.minecraft.tileentity.LockableLootTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;

import javax.annotation.Nullable;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author CoffeeCatRailway
 * Created: 27/08/2020
 */
public class RatEntity extends AnimalEntity implements ICreateSpawnPacket<RatEntity>
{
    public RatEntity(EntityType<? extends RatEntity> type, World world)
    {
        super(type, world);
    }

    @Override
    protected void registerGoals()
    {
        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1d, true));
        this.goalSelector.addGoal(1, new AvoidEntityGoal<>(this, OwlEntity.class, 12f, .75d, 1d));
        this.goalSelector.addGoal(2, new FindChestWithFoodGoal(this));
        this.goalSelector.addGoal(2, new WaterAvoidingRandomWalkingGoal(this, .6d));
        this.goalSelector.addGoal(3, new LookAtGoal(this, PlayerEntity.class, 2f));
        this.goalSelector.addGoal(3, new LookRandomlyGoal(this));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this).setCallsForHelp());
    }

    public static AttributeModifierMap.MutableAttribute registerAttributeMap()
    {
        return MobEntity.func_233666_p_().createMutableAttribute(Attributes.MAX_HEALTH, 10f)
                .createMutableAttribute(Attributes.MOVEMENT_SPEED, .3f)
                .createMutableAttribute(Attributes.ATTACK_DAMAGE, 1f);
    }

    @Override
    protected PathNavigator createNavigator(World world)
    {
        GroundPathNavigator navigator = new GroundPathNavigator(this, world);
        navigator.getNodeProcessor().setCanEnterDoors(true);
        return navigator;
    }

    @Override
    protected void playStepSound(BlockPos pos, BlockState block)
    {
        this.playSound(SoundEvents.ENTITY_CHICKEN_STEP, .15f, 1f);
    }

    @Nullable
    @Override
    public AgeableEntity func_241840_a(ServerWorld world, AgeableEntity entity)
    {
        return DeadEntities.RAT.get().create(world);
    }
}
