package coffeecatrailway.tdeadlands;

import coffeecatrailway.tdeadlands.client.entity.renderer.DeadWoodArrowRenderer;
import coffeecatrailway.tdeadlands.client.entity.renderer.MuskOxRenderer;
import coffeecatrailway.tdeadlands.client.entity.renderer.OwlRenderer;
import coffeecatrailway.tdeadlands.client.entity.renderer.RatRenderer;
import coffeecatrailway.tdeadlands.registry.DeadEntities;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.color.ItemColors;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import org.apache.logging.log4j.Logger;

/**
 * @author CoffeeCatRailway
 * Created: 22/08/2020
 */
@OnlyIn(Dist.CLIENT)
public class ClientEvents
{
    private static final Logger LOGGER = TheDeadlands.getLogger("Client-Events");

    public static void itemColors()
    {
        ItemColors itemColors = Minecraft.getInstance().getItemColors();
        DeadEntities.SPAWN_EGGS.forEach(egg -> itemColors.register((stack, tintindex) -> egg.get().getColor(tintindex), egg.get()));

        LOGGER.info("Item colors");
    }

    public static void entityRenderers()
    {
        RenderingRegistry.registerEntityRenderingHandler(DeadEntities.DEAD_WOOD_ARROW.get(), DeadWoodArrowRenderer::new);

        RenderingRegistry.registerEntityRenderingHandler(DeadEntities.RAT.get(), RatRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(DeadEntities.OWL.get(), OwlRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(DeadEntities.MUSK_OX.get(), MuskOxRenderer::new);

        LOGGER.info("Entity renderers");
    }
}
