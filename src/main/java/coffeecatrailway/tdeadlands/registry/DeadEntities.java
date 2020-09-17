package coffeecatrailway.tdeadlands.registry;

import coffeecatrailway.tdeadlands.TheDeadlands;
import coffeecatrailway.tdeadlands.common.entity.DeadWoodArrowEntity;
import coffeecatrailway.tdeadlands.common.entity.OwlEntity;
import coffeecatrailway.tdeadlands.common.entity.RatEntity;
import com.tterrag.registrate.util.LazySpawnEggItem;
import com.tterrag.registrate.util.entry.RegistryEntry;
import com.tterrag.registrate.util.nullness.NonNullBiConsumer;
import net.minecraft.advancements.criterion.EntityFlagsPredicate;
import net.minecraft.advancements.criterion.EntityPredicate;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.item.ItemGroup;
import net.minecraft.loot.*;
import net.minecraft.loot.conditions.EntityHasProperty;
import net.minecraft.loot.functions.SetCount;
import net.minecraft.loot.functions.Smelt;
import net.minecraft.util.ResourceLocation;
import org.apache.logging.log4j.Logger;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Supplier;

import static coffeecatrailway.tdeadlands.TheDeadlands.REGISTRATE;

/**
 * @author CoffeeCatRailway
 * Created: 23/08/2020
 */
public class DeadEntities
{
    private static final Logger LOGGER = TheDeadlands.getLogger("Entities");
    private static final EntityPredicate.Builder ON_FIRE = EntityPredicate.Builder.create().flags(EntityFlagsPredicate.Builder.create().onFire(true).build());

    public static final Set<Runnable> ATTRIBUTE_MAPS = new HashSet<>();

    // Misc
    public static final RegistryEntry<EntityType<DeadWoodArrowEntity>> DEAD_WOOD_ARROW = REGISTRATE.<DeadWoodArrowEntity>entity("dead_wood_arrow", DeadWoodArrowEntity::new, EntityClassification.MISC)
            .properties(builder -> builder.size(0.5F, 0.5F).func_233606_a_(4).func_233608_b_(20)).loot(NonNullBiConsumer.noop()).register();

    // Creatures
    public static final RegistryEntry<EntityType<RatEntity>> RAT = REGISTRATE.<RatEntity>entity("rat", RatEntity::new, EntityClassification.AMBIENT)
            .properties(builder -> builder.size(.8f, .5f).func_233606_a_(10))
            .loot((tables, rat) -> tables.registerLootTable(rat, LootTable.builder()
                    .addLootPool(LootPool.builder().rolls(new RandomValueRange(1))
                            .addEntry(ItemLootEntry.builder(DeadItems.DEAD_RAT.get())
                                    .acceptFunction(SetCount.builder(new RandomValueRange(1)))
                                    .acceptFunction(Smelt.func_215953_b().acceptCondition(EntityHasProperty.builder(LootContext.EntityTarget.THIS, ON_FIRE))))))).register();

    public static final RegistryEntry<EntityType<OwlEntity>> OWL = REGISTRATE.<OwlEntity>entity("owl", OwlEntity::new, EntityClassification.CREATURE)
            .properties(builder -> builder.size(0.5F, 0.9F).func_233606_a_(8))
            .loot((tables, rat) -> tables.registerLootTable(rat, LootTable.builder()
                    .addLootPool(LootPool.builder().rolls(new RandomValueRange(1))
                            .addEntry(ItemLootEntry.builder(DeadItems.OWL_FEATHER.get())
                                    .acceptFunction(SetCount.builder(new RandomValueRange(1, 3))))))).register();

    public static final RegistryEntry<EntityType<MuskOxEntity>> MUSK_OX = REGISTRATE.<MuskOxEntity>entity("musk_ox", MuskOxEntity::new, EntityClassification.CREATURE)
            .properties(builder -> builder.size(1f, 1.5f).setTrackingRange(8))
            .loot((tables, rat) -> tables.registerLootTable(rat, LootTable.builder()
                    .addLootPool(LootPool.builder().rolls(new RandomValueRange(1))
                            .addEntry(ItemLootEntry.builder(DeadItems.MUSKOX_FUR.get())
                                    .acceptFunction(SetCount.builder(new RandomValueRange(1, 3)))))
            .addLootPool(LootPool.builder().rolls(new RandomValueRange(1))
                    .addEntry(ItemLootEntry.builder(DeadItems.MUSKOX.get())
                            .acceptFunction(SetCount.builder(new RandomValueRange(1)))
                            .acceptFunction(Smelt.func_215953_b().acceptCondition(EntityHasProperty.builder(LootContext.EntityTarget.THIS, ON_FIRE))))))).register();

    static
    {
        registerAttributeMap(RAT, RatEntity::registerAttributeMap);
        registerSpawnEgg("rat", RAT, 0xe1e1e1, 0xc29ba7);

        registerAttributeMap(OWL, OwlEntity::registerAttributeMap);
        registerSpawnEgg("owl", OWL, 0xdbdbdb, 0x2d2f39);

        registerAttributeMap(MUSK_OX, MuskOxEntity::registerAttributeMap);
        registerSpawnEgg("musk_ox", MUSK_OX, 0x2e2724, 0xe4e1d9);
    }

    private static <T extends LivingEntity> void registerAttributeMap(Supplier<EntityType<T>> entity, Supplier<AttributeModifierMap.MutableAttribute> attributeMap)
    {
        ATTRIBUTE_MAPS.add(() -> GlobalEntityTypeAttributes.put(entity.get(), attributeMap.get().create()));
    }

    private static <T extends LivingEntity> RegistryEntry<LazySpawnEggItem<T>> registerSpawnEgg(String id, RegistryEntry<EntityType<T>> entity, int primaryColor, int secondaryColor)
    {
        RegistryEntry<LazySpawnEggItem<T>> egg = REGISTRATE.item(id + "_spawn_egg", prop -> new LazySpawnEggItem<>(entity, primaryColor, secondaryColor, prop)).group(() -> ItemGroup.MISC)
                .model((ctx, provider) -> provider.withExistingParent(ctx.getName(), new ResourceLocation("item/template_spawn_egg"))).register();
        SPAWN_EGGS.add(egg);
        return egg;
    }

    public static void load()
    {
        LOGGER.info("Loaded");
    }
}
