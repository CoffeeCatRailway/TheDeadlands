package coffeecatrailway.tdeadlands.registry;

import coffeecatrailway.tdeadlands.TheDeadlands;
import net.minecraft.item.ItemModelsProperties;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.apache.logging.log4j.Logger;

/**
 * @author CoffeeCatRailway
 * Created: 23/08/2020
 */
@OnlyIn(Dist.CLIENT)
public class DeadItemModelProperties
{
    private static final Logger LOGGER = TheDeadlands.getLogger("Item-Model-Properties");

    static
    {
        ItemModelsProperties.registerProperty(DeadItems.DEAD_WOOD_BOW.get(), new ResourceLocation("pull"), (stack, world, entity) -> {
            if (entity == null)
                return 0f;
            else
                return entity.getActiveItemStack() != stack ? 0f : (float) (stack.getUseDuration() - entity.getItemInUseCount()) / 20f;
        });
        ItemModelsProperties.registerProperty(DeadItems.DEAD_WOOD_BOW.get(), new ResourceLocation("pulling"), (stack, world, entity) -> entity != null && entity.isHandActive() && entity.getActiveItemStack() == stack ? 1f : 0f);
    }

    public static void load()
    {
        LOGGER.info("Loaded");
    }
}
