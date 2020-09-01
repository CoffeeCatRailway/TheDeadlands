package coffeecatrailway.tdeadlands.registry;

import coffeecatrailway.tdeadlands.TheDeadlands;
import coffeecatrailway.tdeadlands.common.entity.DeadWoodArrowEntity;
import coffeecatrailway.tdeadlands.common.entity.RatEntity;
import io.github.ocelot.common.item.SpawnEggItemBase;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import org.apache.logging.log4j.Logger;

import javax.annotation.Nullable;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Supplier;

/**
 * @author CoffeeCatRailway
 * Created: 23/08/2020
 */
public class DeadEntities {

    private static final Logger LOGGER = TheDeadlands.getLogger("Entities");
    protected static final DeferredRegister<EntityType<?>> REGISTER = DeferredRegister.create(ForgeRegistries.ENTITIES, TheDeadlands.MOD_ID);

    public static final Set<Runnable> ATTRIBUTE_MAPS = new HashSet<>();

    // Misc
    public static final RegistryObject<EntityType<DeadWoodArrowEntity>> DEAD_WOOD_ARROW = register("dead_wood_arrow", EntityType.Builder.<DeadWoodArrowEntity>create(DeadWoodArrowEntity::new, EntityClassification.MISC).size(0.5F, 0.5F).func_233606_a_(4).func_233608_b_(20));

    // Creatures
    public static final RegistryObject<EntityType<RatEntity>> RAT = register("rat", EntityType.Builder.<RatEntity>create(RatEntity::new, EntityClassification.MONSTER).size(.8f, .5f).func_233606_a_(10), RatEntity::registerAttributeMap);
    public static final RegistryObject<SpawnEggItemBase<RatEntity>> RAT_SPAWN_EGG = DeadItems.REGISTER.register("rat_spawn_egg", () -> new SpawnEggItemBase<>(RAT, 0xe1e1e1, 0xc29ba7, false, new Item.Properties().group(TheDeadlands.GROUP_ALL)));

    private static <T extends Entity> RegistryObject<EntityType<T>> register(String id, EntityType.Builder<T> builder) {
        return REGISTER.register(id, () -> builder.build(id));
    }

    private static <T extends LivingEntity> RegistryObject<EntityType<T>> register(String id, EntityType.Builder<T> builder, @Nullable Supplier<AttributeModifierMap.MutableAttribute> attributeMap) {
        RegistryObject<EntityType<T>> obj = REGISTER.register(id, () -> builder.build(id));
        if (attributeMap != null)
            ATTRIBUTE_MAPS.add(() -> GlobalEntityTypeAttributes.put(obj.get(), attributeMap.get().create()));
        return obj;
    }

    public static void load(IEventBus bus) {
        LOGGER.info("Loaded");
        REGISTER.register(bus);
    }
}
