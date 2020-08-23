package coffeecatrailway.tdeadlands.registry;

import coffeecatrailway.tdeadlands.TheDeadlands;
import coffeecatrailway.tdeadlands.common.entity.DeadWoodArrowEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import org.apache.logging.log4j.Logger;

/**
 * @author CoffeeCatRailway
 * Created: 23/08/2020
 */
public class DeadEntities {

    private static final Logger LOGGER = TheDeadlands.getLogger("Entities");
    protected static final DeferredRegister<EntityType<?>> REGISTER = DeferredRegister.create(ForgeRegistries.ENTITIES, TheDeadlands.MOD_ID);

    public static final RegistryObject<EntityType<DeadWoodArrowEntity>> DEAD_WOOD_ARROW = register("dead_wood_arrow", EntityType.Builder.<DeadWoodArrowEntity>create(DeadWoodArrowEntity::new, EntityClassification.MISC).size(0.5F, 0.5F).func_233606_a_(4).func_233608_b_(20));

    private static <T extends Entity> RegistryObject<EntityType<T>> register(String id, EntityType.Builder<T> builder) {
        return REGISTER.register(id, () -> builder.build(id));
    }

    public static void load(IEventBus bus) {
        LOGGER.info("Loaded");
        REGISTER.register(bus);
    }
}
