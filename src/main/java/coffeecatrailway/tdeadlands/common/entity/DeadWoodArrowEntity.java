package coffeecatrailway.tdeadlands.common.entity;

import coffeecatrailway.tdeadlands.registry.DeadEntities;
import coffeecatrailway.tdeadlands.registry.DeadItems;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.network.IPacket;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

/**
 * @author CoffeeCatRailway
 * Created: 23/08/2020
 */
public class DeadWoodArrowEntity extends ArrowEntity
{
    public DeadWoodArrowEntity(EntityType<? extends ArrowEntity> type, World world)
    {
        super(type, world);
    }

    public DeadWoodArrowEntity(World world, double x, double y, double z)
    {
        super(DeadEntities.DEAD_WOOD_ARROW.get(), world);
        this.setPosition(x, y, z);
    }

    public DeadWoodArrowEntity(World world, LivingEntity shooter)
    {
        this(world, shooter.getPosX(), shooter.getPosYEye() - .1d, shooter.getPosZ());
        this.setShooter(shooter);
        if (shooter instanceof PlayerEntity)
            this.pickupStatus = AbstractArrowEntity.PickupStatus.ALLOWED;
    }

    @Override
    protected ItemStack getArrowStack()
    {
        return new ItemStack(DeadItems.DEAD_WOOD_ARROW.get());
    }

    @Override
    public IPacket<?> createSpawnPacket()
    {
        return NetworkHooks.getEntitySpawningPacket(this);
    }
}
