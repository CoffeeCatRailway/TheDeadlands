package coffeecatrailway.tdeadlands.registry;

import coffeecatrailway.tdeadlands.TheDeadlands;
import coffeecatrailway.tdeadlands.client.tileentity.renderer.DeadWoodChestTileEntityRenderer;
import coffeecatrailway.tdeadlands.common.tileentity.DeadWoodChestTileEntity;
import com.tterrag.registrate.util.entry.RegistryEntry;
import com.tterrag.registrate.util.nullness.NonNullFunction;
import net.minecraft.tileentity.TileEntityType;
import org.apache.logging.log4j.Logger;

import static coffeecatrailway.tdeadlands.TheDeadlands.REGISTRATE;

/**
 * @author CoffeeCatRailway
 * Created: 6/09/2020
 */
public class DeadTileEntities
{
    private static final Logger LOGGER = TheDeadlands.getLogger("TileEntities");

    public static final RegistryEntry<TileEntityType<DeadWoodChestTileEntity>> DEAD_WOOD_CHEST = REGISTRATE.tileEntity("dead_wood_chest", (NonNullFunction<TileEntityType<DeadWoodChestTileEntity>, DeadWoodChestTileEntity>) DeadWoodChestTileEntity::new)
            .validBlock(DeadBlocks.DEAD_WOOD_CHEST).renderer(() -> DeadWoodChestTileEntityRenderer::new).register();

    public static void load()
    {
        LOGGER.info("Loaded");
    }
}
