package coffeecatrailway.tdeadlands.common.tileentity;

import coffeecatrailway.tdeadlands.registry.DeadTileEntities;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;

/**
 * @author CoffeeCatRailway
 * Created: 20/09/2020
 */
public class RunicTableTileEntity extends TileEntity
{
    public RunicTableTileEntity(TileEntityType<RunicTableTileEntity> tileEntityTypeIn)
    {
        super(tileEntityTypeIn);
    }

    public RunicTableTileEntity()
    {
        super(DeadTileEntities.RUNIC_TABLE.get());
    }
}
