package coffeecatrailway.tdeadlands;

import coffeecatrailway.tdeadlands.client.entity.render.DeadWoodArrowRenderer;
import coffeecatrailway.tdeadlands.registry.DeadBlocks;
import coffeecatrailway.tdeadlands.registry.DeadEntities;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.client.renderer.color.BlockColors;
import net.minecraft.client.renderer.color.ItemColors;
import net.minecraft.item.BlockItem;
import net.minecraft.item.DyeColor;
import net.minecraft.world.biome.BiomeColors;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import org.apache.logging.log4j.Logger;

/**
 * @author CoffeeCatRailway
 * Created: 22/08/2020
 */
@OnlyIn(Dist.CLIENT)
public class ClientEvents {

    private static final Logger LOGGER = TheDeadlands.getLogger("Client Events");

    public static void blockColors() {
        BlockColors blocks = Minecraft.getInstance().getBlockColors();
        blocks.register((state, world, pos, tintindex) -> world != null && pos != null ? BiomeColors.getGrassColor(world, pos) : DyeColor.WHITE.getColorValue(),
                DeadBlocks.GRASS_BLOCK.get());// TODO: Check if the world is the right dimension

        LOGGER.info("Block colors");
    }

    public static void itemColors() {
        ItemColors itemColors = Minecraft.getInstance().getItemColors();
        BlockColors blockColors = Minecraft.getInstance().getBlockColors();

        itemColors.register((stack, tintindex) -> blockColors.getColor(((BlockItem) stack.getItem()).getBlock().getDefaultState(), null, null, tintindex),
                DeadBlocks.GRASS_BLOCK.get());

        LOGGER.info("Item colors");
    }

    public static void renderLayers() {
        RenderType cutoutMipped = RenderType.getCutoutMipped();

        RenderTypeLookup.setRenderLayer(DeadBlocks.DEAD_WOOD_DOOR.get(), cutoutMipped);
        RenderTypeLookup.setRenderLayer(DeadBlocks.DEAD_WOOD_CRAFTING_TABLE.get(), cutoutMipped);
        RenderTypeLookup.setRenderLayer(DeadBlocks.DEAD_WOOD_TORCH.get(), cutoutMipped);
        RenderTypeLookup.setRenderLayer(DeadBlocks.WALL_DEAD_WOOD_TORCH.get(), cutoutMipped);

        RenderTypeLookup.setRenderLayer(DeadBlocks.GRASS_BLOCK.get(), cutoutMipped);

        RenderTypeLookup.setRenderLayer(DeadBlocks.WARP_RUNE.get(), cutoutMipped);

        LOGGER.info("Block render layers");
    }

    public static void entityRenderers() {
        RenderingRegistry.registerEntityRenderingHandler(DeadEntities.DEAD_WOOD_ARROW.get(), DeadWoodArrowRenderer::new);

        LOGGER.info("Entity renderers");
    }
}
