package coffeecatrailway.tdeadlands.common.entity;

import net.minecraft.entity.Entity;
import net.minecraft.network.IPacket;
import net.minecraftforge.fml.network.NetworkHooks;

/**
 * @author CoffeeCatRailway
 * Created: 7/09/2020
 */
public interface ICreateSpawnPacket<E extends Entity>
{
    default IPacket<?> createSpawnPacket() {
        return NetworkHooks.getEntitySpawningPacket((E) this);
    }
}
