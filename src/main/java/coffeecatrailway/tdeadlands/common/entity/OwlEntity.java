package coffeecatrailway.tdeadlands.common.entity;

import coffeecatrailway.tdeadlands.integration.registrate.DeadTags;
import coffeecatrailway.tdeadlands.registry.DeadEntities;
import coffeecatrailway.tdeadlands.registry.DeadSounds;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.controller.FlyingMovementController;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.IFlyingAnimal;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.pathfinding.FlyingPathNavigator;
import net.minecraft.pathfinding.PathNavigator;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.ForgeEventFactory;

import javax.annotation.Nullable;

/**
 * @author CoffeeCatRailway
 * Created: 7/09/2020
 */
public class OwlEntity extends TameableEntity implements IFlyingAnimal, ICreateSpawnPacket<OwlEntity>
{
    public float wingFlap;
    public float wingFlapSpeed;
    public float prevWingFlap;
    public float prevWingFlapSpeed;
    private float flapping = 1f;

    private boolean partyParrot;
    private BlockPos jukeboxPosition;

    public OwlEntity(EntityType<? extends OwlEntity> type, World worldIn)
    {
        super(type, worldIn);
        this.moveController = new FlyingMovementController(this, 10, false);
        this.setPathPriority(PathNodeType.DANGER_FIRE, -1.0F);
        this.setPathPriority(PathNodeType.DAMAGE_FIRE, -1.0F);
    }

    @Override
    public ILivingEntityData onInitialSpawn(IServerWorld world, DifficultyInstance difficulty, SpawnReason reason, @Nullable ILivingEntityData spawnData, @Nullable CompoundNBT dataTag)
    {
        if (spawnData == null)
            spawnData = new AgeableData(false);
        return super.onInitialSpawn(world, difficulty, reason, spawnData, dataTag);
    }

    @Override
    protected void registerGoals()
    {
        this.goalSelector.addGoal(0, new PanicGoal(this, 1.25d));
        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(1, new LookAtGoal(this, PlayerEntity.class, 8f));
        this.goalSelector.addGoal(2, new SitGoal(this));
        this.goalSelector.addGoal(2, new FollowOwnerGoal(this, 1d, 5f, 1f, true));
        this.goalSelector.addGoal(2, new WaterAvoidingRandomFlyingGoal(this, 1d));
        this.goalSelector.addGoal(3, new FollowMobGoal(this, 1d, 3f, 7f));
    }

    public static AttributeModifierMap.MutableAttribute registerAttributeMap()
    {
        return MobEntity.func_233666_p_().createMutableAttribute(Attributes.MAX_HEALTH, 6f)
                .createMutableAttribute(Attributes.FLYING_SPEED, .5f)
                .createMutableAttribute(Attributes.MOVEMENT_SPEED, .2f);
    }

    @Override
    protected PathNavigator createNavigator(World world)
    {
        FlyingPathNavigator navigator = new FlyingPathNavigator(this, world);
        navigator.setCanOpenDoors(false);
        navigator.setCanSwim(true);
        navigator.setCanEnterDoors(true);
        return navigator;
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void setPartying(BlockPos pos, boolean isPartying) {
        this.jukeboxPosition = pos;
        this.partyParrot = isPartying;
    }

    @OnlyIn(Dist.CLIENT)
    public boolean isPartying() {
        return this.partyParrot;
    }

    @Override
    public void livingTick()
    {
        if (this.jukeboxPosition == null || !this.jukeboxPosition.withinDistance(this.getPositionVec(), 3.46d) || !this.world.getBlockState(this.jukeboxPosition).isIn(Blocks.JUKEBOX)) {
            this.partyParrot = false;
            this.jukeboxPosition = null;
        }
        super.livingTick();
        this.calculateFlapping();
    }

    private void calculateFlapping() {
        this.prevWingFlap = this.wingFlap;
        this.prevWingFlapSpeed = this.wingFlapSpeed;
        this.wingFlapSpeed = (float) ((double) this.wingFlapSpeed + (double) (!this.onGround && !this.isPassenger() ? 4 : -1) * .3d);
        this.wingFlapSpeed = MathHelper.clamp(this.wingFlapSpeed, 0f, 1f);
        if (!this.onGround && this.flapping < 1f)
            this.flapping = 1f;

        this.flapping = (float) ((double) this.flapping * .9d);
        Vector3d vector3d = this.getMotion();
        if (!this.onGround && vector3d.y < 0d)
            this.setMotion(vector3d.mul(1d, .6d, 1d));

        this.wingFlap += this.flapping * 2f;
    }

    @Override
    public ActionResultType func_230254_b_(PlayerEntity player, Hand hand)
    {
        ItemStack stack = player.getHeldItem(hand);
        if (!this.isTamed() && DeadTags.Items.OWL_TAME.contains(stack.getItem()))
        {
            if (!player.abilities.isCreativeMode)
                stack.shrink(1);

            if (!this.isSilent()) // TODO: Custom sound
                this.world.playSound(null, this.getPosX(), this.getPosY(), this.getPosZ(), SoundEvents.ENTITY_PARROT_EAT, this.getSoundCategory(), 1f, 1f + (this.rand.nextFloat() - this.rand.nextFloat()) * .2f);

            if (!this.world.isRemote)
            {
                if (this.rand.nextInt(10) == 0 && !ForgeEventFactory.onAnimalTame(this, player))
                {
                    this.setTamedBy(player);
                    this.world.setEntityState(this, (byte) 7);
                } else
                {
                    this.world.setEntityState(this, (byte) 6);
                }
            }

            return ActionResultType.func_233537_a_(this.world.isRemote);
        } else if (DeadTags.Items.OWL_DEADLY.contains(stack.getItem()))
        {
            if (!player.abilities.isCreativeMode)
                stack.shrink(1);

            this.addPotionEffect(new EffectInstance(Effects.POISON, 900));
            if (player.isCreative() || !this.isInvulnerable())
                this.attackEntityFrom(DamageSource.causePlayerDamage(player), Float.MAX_VALUE);

            return ActionResultType.func_233537_a_(this.world.isRemote);
        } else if (!this.isFlying() && this.isTamed() && this.isOwner(player))
        {
            if (!this.world.isRemote)
                this.func_233687_w_(!this.func_233685_eM_());

            return ActionResultType.func_233537_a_(this.world.isRemote);
        } else
        {
            return super.func_230254_b_(player, hand);
        }
    }

    @Override
    public boolean isBreedingItem(ItemStack stack)
    {
        return false;
    }

    @Override
    public boolean onLivingFall(float distance, float damageMultiplier)
    {
        return false;
    }

    @Override
    protected void updateFallState(double y, boolean onGroundIn, BlockState state, BlockPos pos)
    {
    }

    @Override
    public boolean canMateWith(AnimalEntity otherAnimal)
    {
        return false;
    }

    @Nullable
    @Override
    public AgeableEntity func_241840_a(ServerWorld world, AgeableEntity entity)
    {
        return DeadEntities.OWL.get().create(world);
    }

    @Override
    public boolean attackEntityAsMob(Entity entity)
    {
        return entity.attackEntityFrom(DamageSource.causeMobDamage(this), 3f);
    }

    @Override
    public void playAmbientSound()
    {
        float volume = this.world.isDaytime() ? this.getSoundVolume() / 2f : this.getSoundVolume();
        this.playSound(DeadSounds.OWL.get(), volume, this.getSoundPitch());
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSource)
    {
        return DeadSounds.OWL_HURT.get();
    }

    @Override
    protected SoundEvent getDeathSound() // TODO: Custom sound
    {
        return SoundEvents.ENTITY_PARROT_DEATH;
    }

    @Override
    protected void playStepSound(BlockPos pos, BlockState blockIn)
    {
        this.playSound(SoundEvents.ENTITY_PARROT_STEP, .15f, 1f);
    }

    @Override
    protected float playFlySound(float volume)
    {
        this.playSound(SoundEvents.ENTITY_PARROT_FLY, .15f, 1f);
        return volume + this.wingFlapSpeed / 2f;
    }

    @Override
    protected boolean makeFlySound()
    {
        return true;
    }

    @Override
    protected float getSoundPitch()
    {
        return (this.rand.nextFloat() - this.rand.nextFloat()) * .2f + 1f;
    }

    @Override
    public SoundCategory getSoundCategory()
    {
        return SoundCategory.NEUTRAL;
    }

    @Override
    public boolean canBePushed()
    {
        return true;
    }

    @Override
    protected void collideWithEntity(Entity entityIn)
    {
        if (!(entityIn instanceof PlayerEntity))
        {
            super.collideWithEntity(entityIn);
        }
    }

    @Override
    public boolean attackEntityFrom(DamageSource source, float amount)
    {
        if (this.isInvulnerableTo(source))
        {
            return false;
        } else
        {
            this.func_233687_w_(false);
            return super.attackEntityFrom(source, amount);
        }
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public Vector3d func_241205_ce_()
    {
        return new Vector3d(0d, .5f * this.getEyeHeight(), this.getWidth() * .4f);
    }

    public boolean isFlying()
    {
        return !this.onGround;
    }
}
