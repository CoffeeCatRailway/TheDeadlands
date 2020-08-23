package coffeecatrailway.tdeadlands.registry;

import coffeecatrailway.tdeadlands.TheDeadlands;
import net.minecraft.item.*;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import org.apache.logging.log4j.Logger;

/**
 * @author CoffeeCatRailway
 * Created: 21/08/2020
 */
public class DeadItems {

    private static final Logger LOGGER = TheDeadlands.getLogger("Items");
    protected static final DeferredRegister<Item> REGISTER = DeferredRegister.create(ForgeRegistries.ITEMS, TheDeadlands.MOD_ID);

    //Materials
    public static final RegistryObject<Item> DEAD_WOOD_STICK = REGISTER.register("dead_wood_stick", () -> new Item(new Item.Properties().group(TheDeadlands.GROUP_ALL)));

    public static final RegistryObject<Item> COPPER_CLUMP = REGISTER.register("copper_clump", () -> new Item(new Item.Properties().group(TheDeadlands.GROUP_ALL)));

    public static final RegistryObject<Item> FROST_BRONZE = REGISTER.register("frost_bronze", () -> new Item(new Item.Properties().group(TheDeadlands.GROUP_ALL)));
    public static final RegistryObject<Item> FROST_COPPER = REGISTER.register("frost_copper", () -> new Item(new Item.Properties().group(TheDeadlands.GROUP_ALL)));
    public static final RegistryObject<Item> FROST_METAL_CLUMP = REGISTER.register("frost_metal_clump", () -> new Item(new Item.Properties().group(TheDeadlands.GROUP_ALL)));

    public static final RegistryObject<Item> HEAT_STONE = REGISTER.register("heat_stone", () -> new Item(new Item.Properties().group(TheDeadlands.GROUP_ALL)));

    //Tools
    public static final RegistryObject<AxeItem> DEAD_WOOD_AXE = REGISTER.register("dead_wood_axe", () -> new AxeItem(ItemTier.WOOD, 6f, -3.2f, new Item.Properties().group(TheDeadlands.GROUP_ALL).maxStackSize(1)));
    public static final RegistryObject<PickaxeItem> DEAD_WOOD_PICKAXE = REGISTER.register("dead_wood_pickaxe", () -> new PickaxeItem(ItemTier.WOOD, 1, -2.8f, new Item.Properties().group(TheDeadlands.GROUP_ALL).maxStackSize(1)));
    public static final RegistryObject<ShovelItem> DEAD_WOOD_SHOVEL = REGISTER.register("dead_wood_shovel", () -> new ShovelItem(ItemTier.WOOD, 1.5f, -3f, new Item.Properties().group(TheDeadlands.GROUP_ALL).maxStackSize(1)));
    public static final RegistryObject<SwordItem> DEAD_WOOD_SWORD = REGISTER.register("dead_wood_sword", () -> new SwordItem(ItemTier.WOOD, 3, -2.4f, new Item.Properties().group(TheDeadlands.GROUP_ALL).maxStackSize(1)));
    public static final RegistryObject<HoeItem> DEAD_WOOD_HOE = REGISTER.register("dead_wood_hoe", () -> new HoeItem(ItemTier.WOOD, 0, -3f, new Item.Properties().group(TheDeadlands.GROUP_ALL).maxStackSize(1)));
    public static final RegistryObject<BowItem> DEAD_WOOD_BOW = REGISTER.register("dead_wood_bow", () -> new BowItem(new Item.Properties().maxDamage(384).group(TheDeadlands.GROUP_ALL)));

    public static final RegistryObject<AxeItem> COLDSTONE_AXE = REGISTER.register("coldstone_axe", () -> new AxeItem(ItemTier.IRON, 6f, -3.1f, new Item.Properties().group(TheDeadlands.GROUP_ALL).maxStackSize(1)));
    public static final RegistryObject<PickaxeItem> COLDSTONE_PICKAXE = REGISTER.register("coldstone_pickaxe", () -> new PickaxeItem(ItemTier.IRON, 1, -2.8f, new Item.Properties().group(TheDeadlands.GROUP_ALL).maxStackSize(1)));
    public static final RegistryObject<ShovelItem> COLDSTONE_SHOVEL = REGISTER.register("coldstone_shovel", () -> new ShovelItem(ItemTier.IRON, 1.5f, -3f, new Item.Properties().group(TheDeadlands.GROUP_ALL).maxStackSize(1)));
    public static final RegistryObject<SwordItem> COLDSTONE_SWORD = REGISTER.register("coldstone_sword", () -> new SwordItem(ItemTier.IRON, 3, -2.4f, new Item.Properties().group(TheDeadlands.GROUP_ALL).maxStackSize(1)));
    public static final RegistryObject<HoeItem> COLDSTONE_HOE = REGISTER.register("coldstone_hoe", () -> new HoeItem(ItemTier.IRON, -2, -1f, new Item.Properties().group(TheDeadlands.GROUP_ALL).maxStackSize(1)));

    public static final RegistryObject<DeadWoodBow> DEAD_WOOD_BOW = REGISTER.register("dead_wood_bow", () -> new DeadWoodBow(new Item.Properties().maxDamage(384).group(TheDeadlands.GROUP_ALL)));
    public static final RegistryObject<ArrowItem> DEAD_WOOD_ARROW = REGISTER.register("dead_wood_arrow", () -> new ArrowItem((new Item.Properties()).group(TheDeadlands.GROUP_ALL)));

    public static final RegistryObject<AxeItem> COLD_BRONZE_AXE = REGISTER.register("cold_bronze_axe", () -> new AxeItem(ItemTier.IRON, 6f, -3.1f, new Item.Properties().group(TheDeadlands.GROUP_ALL).maxStackSize(1)));
    public static final RegistryObject<PickaxeItem> COLD_BRONZE_PICKAXE = REGISTER.register("cold_bronze_pickaxe", () -> new PickaxeItem(ItemTier.IRON, 1, -2.8f, new Item.Properties().group(TheDeadlands.GROUP_ALL).maxStackSize(1)));
    public static final RegistryObject<ShovelItem> COLD_BRONZE_SHOVEL = REGISTER.register("cold_bronze_shovel", () -> new ShovelItem(ItemTier.IRON, 1.5f, -3f, new Item.Properties().group(TheDeadlands.GROUP_ALL).maxStackSize(1)));
    public static final RegistryObject<SwordItem> COLD_BRONZE_SWORD = REGISTER.register("cold_bronze_sword", () -> new SwordItem(ItemTier.IRON, 3, -2.4f, new Item.Properties().group(TheDeadlands.GROUP_ALL).maxStackSize(1)));
    public static final RegistryObject<HoeItem> COLD_BRONZE_HOE = REGISTER.register("cold_bronze_hoe", () -> new HoeItem(ItemTier.IRON, -2, -1f, new Item.Properties().group(TheDeadlands.GROUP_ALL).maxStackSize(1)));

    public static final RegistryObject<SwordItem> HEAT_HAMMER = REGISTER.register("heat_hammer", () -> new SwordItem(ItemTier.IRON, 3, -2.4f, new Item.Properties().group(TheDeadlands.GROUP_ALL).maxStackSize(1)));
    public static final RegistryObject<PickaxeItem> HEAT_PICKAXE = REGISTER.register("heat_pickaxe", () -> new PickaxeItem(ItemTier.IRON, 1, -2.8f, new Item.Properties().group(TheDeadlands.GROUP_ALL).maxStackSize(1)));

    public static final RegistryObject<SwordItem> MAIDENS_DAGGER = REGISTER.register("maidens_dagger", () -> new SwordItem(ItemTier.IRON, 3, -2.4f, new Item.Properties().group(TheDeadlands.GROUP_ALL).maxStackSize(1)));
    public static final RegistryObject<SwordItem> TALL_KIGHT_BLADE = REGISTER.register("tall_knight_blade", () -> new SwordItem(ItemTier.IRON, 3, -2.4f, new Item.Properties().group(TheDeadlands.GROUP_ALL).maxStackSize(1)));

    //Misc
    public static final RegistryObject<Item> DEAD_WOOD_TORCH = REGISTER.register("dead_wood_torch", () -> new Item(new Item.Properties().group(TheDeadlands.GROUP_ALL)));
    public static final RegistryObject<Item> FIRE_STARTER = REGISTER.register("fire_starter", () -> new Item(new Item.Properties().group(TheDeadlands.GROUP_ALL).maxStackSize(1)));

    public static final RegistryObject<Item> UNDEAD_TALISMAN = REGISTER.register("undead_talisman", () -> new Item(new Item.Properties().group(TheDeadlands.GROUP_ALL).maxStackSize(1)));

    public static void load(IEventBus bus) {
        LOGGER.info("Items loaded");
        REGISTER.register(bus);
    }
}
