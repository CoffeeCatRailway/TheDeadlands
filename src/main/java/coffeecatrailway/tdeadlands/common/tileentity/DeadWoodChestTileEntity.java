package coffeecatrailway.tdeadlands.common.tileentity;

import coffeecatrailway.tdeadlands.registry.DeadTileEntities;
import net.minecraft.tileentity.ChestTileEntity;
import net.minecraft.tileentity.TileEntityType;

/**
 * @author CoffeeCatRailway
 * Created: 6/09/2020
 */
public class DeadWoodChestTileEntity extends ChestTileEntity
{
    public DeadWoodChestTileEntity(TileEntityType<DeadWoodChestTileEntity> typeIn)
    {
        super(typeIn);
    }

    public DeadWoodChestTileEntity()
    {
        super(DeadTileEntities.DEAD_WOOD_CHEST.get());
    }
}
