package coffeecatrailway.tdeadlands.registry;

import coffeecatrailway.tdeadlands.TheDeadlands;
import coffeecatrailway.tdeadlands.common.world.gen.feature.DeadWoodTreeFeature;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import org.apache.logging.log4j.Logger;

/**
 * @author CoffeeCatRailway
 * Created: 16/10/2020
 */
public class DeadWorldGen
{
    private static final Logger LOGGER = TheDeadlands.getLogger("Features");
    private static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, TheDeadlands.MOD_ID);

    public static final RegistryObject<Feature<BaseTreeFeatureConfig>> TREE = FEATURES.register("dead_wood_tree", () -> new DeadWoodTreeFeature(BaseTreeFeatureConfig.CODEC));

    public static void load(IEventBus bus)
    {
        LOGGER.info("Features loaded");
        FEATURES.register(bus);
    }
}
