package coffeecatrailway.tdeadlands.registry;

import coffeecatrailway.tdeadlands.TheDeadlands;
import com.sun.org.apache.regexp.internal.RE;
import net.minecraft.item.Item;
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
    public static final RegistryObject<Item> DEAD_WOOD_AXE = REGISTER.register("dead_wood_axe", () -> new Item(new Item.Properties().group(TheDeadlands.GROUP_ALL).maxStackSize(1)));
    public static final RegistryObject<Item> DEAD_WOOD_PICKAXE = REGISTER.register("dead_wood_pickaxe", () -> new Item(new Item.Properties().group(TheDeadlands.GROUP_ALL).maxStackSize(1)));
    public static final RegistryObject<Item> DEAD_WOOD_SHOVEL = REGISTER.register("dead_wood_shovel", () -> new Item(new Item.Properties().group(TheDeadlands.GROUP_ALL).maxStackSize(1)));
    public static final RegistryObject<Item> DEAD_WOOD_SWORD = REGISTER.register("dead_wood_sword", () -> new Item(new Item.Properties().group(TheDeadlands.GROUP_ALL).maxStackSize(1)));
    public static final RegistryObject<Item> DEAD_WOOD_BOW = REGISTER.register("dead_wood_bow", () -> new Item(new Item.Properties().group(TheDeadlands.GROUP_ALL).maxStackSize(1)));

    public static final RegistryObject<Item> COLD_STONE_AXE = REGISTER.register("cold_stone_axe", () -> new Item(new Item.Properties().group(TheDeadlands.GROUP_ALL).maxStackSize(1)));
    public static final RegistryObject<Item> COLD_STONE_PICKAXE = REGISTER.register("cold_stone_pickaxe", () -> new Item(new Item.Properties().group(TheDeadlands.GROUP_ALL).maxStackSize(1)));
    public static final RegistryObject<Item> COLD_STONE_SHOVEL = REGISTER.register("cold_stone_shovel", () -> new Item(new Item.Properties().group(TheDeadlands.GROUP_ALL).maxStackSize(1)));
    public static final RegistryObject<Item> COLD_STONE_SWORD = REGISTER.register("cold_stone_sword", () -> new Item(new Item.Properties().group(TheDeadlands.GROUP_ALL).maxStackSize(1)));

    public static final RegistryObject<Item> COLD_BRONZE_AXE = REGISTER.register("cold_bronze_axe", () -> new Item(new Item.Properties().group(TheDeadlands.GROUP_ALL).maxStackSize(1)));
    public static final RegistryObject<Item> COLD_BRONZE_PICKAXE = REGISTER.register("cold_bronze_pickaxe", () -> new Item(new Item.Properties().group(TheDeadlands.GROUP_ALL).maxStackSize(1)));
    public static final RegistryObject<Item> COLD_BRONZE_SHOVEL = REGISTER.register("cold_bronze_shovel", () -> new Item(new Item.Properties().group(TheDeadlands.GROUP_ALL).maxStackSize(1)));
    public static final RegistryObject<Item> COLD_BRONZE_SWORD = REGISTER.register("cold_bronze_sword", () -> new Item(new Item.Properties().group(TheDeadlands.GROUP_ALL).maxStackSize(1)));

    public static final RegistryObject<Item> HEAT_HAMMER = REGISTER.register("heat_hammer", () -> new Item(new Item.Properties().group(TheDeadlands.GROUP_ALL).maxStackSize(1)));
    public static final RegistryObject<Item> HEAT_PICKAXE = REGISTER.register("heat_pickaxe", () -> new Item(new Item.Properties().group(TheDeadlands.GROUP_ALL).maxStackSize(1)));

    public static final RegistryObject<Item> MAIDENS_DAGGER = REGISTER.register("maidens_dagger", () -> new Item(new Item.Properties().group(TheDeadlands.GROUP_ALL).maxStackSize(1)));
    public static final RegistryObject<Item> TALL_KIGHT_BLADE = REGISTER.register("tall_knight_blade", () -> new Item(new Item.Properties().group(TheDeadlands.GROUP_ALL).maxStackSize(1)));

    //Misc
    public static final RegistryObject<Item> DEAD_WOOD_TORCH = REGISTER.register("dead_wood_torch", () -> new Item(new Item.Properties().group(TheDeadlands.GROUP_ALL)));
    public static final RegistryObject<Item> FIRE_STARTER = REGISTER.register("fire_starter", () -> new Item(new Item.Properties().group(TheDeadlands.GROUP_ALL).maxStackSize(1)));

    public static final RegistryObject<Item> WARP_RUNE = REGISTER.register("warp_rune", () -> new Item(new Item.Properties().group(TheDeadlands.GROUP_ALL).maxStackSize(1)));
    public static final RegistryObject<Item> UNDEAD_TALISMAN = REGISTER.register("undead_talisman", () -> new Item(new Item.Properties().group(TheDeadlands.GROUP_ALL).maxStackSize(1)));

    public static void load(IEventBus bus) {
        LOGGER.info("Items loaded");
        REGISTER.register(bus);
    }
}
