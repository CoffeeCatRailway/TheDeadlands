package coffeecatrailway.tdeadlands.common.block;

import coffeecatrailway.tdeadlands.common.tileentity.DeadWoodChestTileEntity;
import coffeecatrailway.tdeadlands.registry.DeadTileEntities;
import net.minecraft.block.ChestBlock;
import net.minecraft.stats.Stat;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.IBlockReader;

/**
 * @author CoffeeCatRailway
 * Created: 6/09/2020
 */
public class DeadWoodChestBlock extends ChestBlock
{
    public DeadWoodChestBlock(Properties builder)
    {
        super(builder, DeadTileEntities.DEAD_WOOD_CHEST::get);
    }

    @Override
    public TileEntity createNewTileEntity(IBlockReader world)
    {
        return new DeadWoodChestTileEntity();
    }

    @Override
    protected Stat<ResourceLocation> getOpenStat()
    {
        return super.getOpenStat();
    }
}
