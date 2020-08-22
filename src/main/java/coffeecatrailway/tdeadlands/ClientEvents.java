package coffeecatrailway.tdeadlands;

import coffeecatrailway.tdeadlands.registry.DeadBlocks;
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

        RenderTypeLookup.setRenderLayer(DeadBlocks.DEAD_WOOD_CRAFTING_TABLE.get(), cutoutMipped);
        RenderTypeLookup.setRenderLayer(DeadBlocks.GRASS_BLOCK.get(), cutoutMipped);

        LOGGER.info("Block render layers");
    }
}
