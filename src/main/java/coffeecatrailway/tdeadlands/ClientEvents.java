package coffeecatrailway.tdeadlands;

import coffeecatrailway.tdeadlands.registry.DeadBlocks;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.apache.logging.log4j.Logger;

/**
 * @author CoffeeCatRailway
 * Created: 22/08/2020
 */
@OnlyIn(Dist.CLIENT)
public class ClientEvents {

    private static final Logger LOGGER = TheDeadlands.getLogger("Client Events");

    public static void renderLayers() {
        RenderType cutoutMipped = RenderType.getCutoutMipped();

        RenderTypeLookup.setRenderLayer(DeadBlocks.DEAD_WOOD_CRAFTING_TABLE.get(), cutoutMipped);

        LOGGER.info("Block render layers");
    }
