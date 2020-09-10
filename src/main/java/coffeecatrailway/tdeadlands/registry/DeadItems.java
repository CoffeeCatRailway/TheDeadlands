package coffeecatrailway.tdeadlands.registry;

import coffeecatrailway.tdeadlands.TheDeadlands;
import coffeecatrailway.tdeadlands.common.item.DeadWoodBow;
import coffeecatrailway.tdeadlands.common.item.FrostCopperClumpItem;
import coffeecatrailway.tdeadlands.integration.registrate.DeadTags;
import com.tterrag.registrate.providers.DataGenContext;
import com.tterrag.registrate.providers.RegistrateRecipeProvider;
import com.tterrag.registrate.util.DataIngredient;
import com.tterrag.registrate.util.entry.RegistryEntry;
import com.tterrag.registrate.util.nullness.NonNullBiConsumer;
import net.minecraft.data.ShapedRecipeBuilder;
import net.minecraft.data.ShapelessRecipeBuilder;
import net.minecraft.item.*;
import net.minecraft.tags.ITag;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.IItemProvider;
import net.minecraftforge.common.Tags;
import org.apache.logging.log4j.Logger;

import java.util.function.Supplier;

import static coffeecatrailway.tdeadlands.TheDeadlands.REGISTRATE;

/**
 * @author CoffeeCatRailway
 * Created: 21/08/2020
 */
public class DeadItems
{
    private static final Logger LOGGER = TheDeadlands.getLogger("Items");

    //Materials
    public static final RegistryEntry<Item> DEAD_WOOD_STICK = REGISTRATE.item("dead_wood_stick", Item::new).model((ctx, provider) -> provider.handheld(ctx::getEntry))
            .recipe((ctx, provider) -> ShapedRecipeBuilder.shapedRecipe(ctx.getEntry(), 4).key('p', DeadBlocks.DEAD_PLANKS.get()).patternLine("p").patternLine("p")
                    .addCriterion("has_planks", RegistrateRecipeProvider.hasItem(DeadBlocks.DEAD_PLANKS.get())).build(provider))
            .tag(Tags.Items.RODS_WOODEN).register();

    public static final RegistryEntry<Item> OWL_FEATHER = REGISTRATE.item("owl_feather", Item::new).model((ctx, provider) -> provider.generated(ctx::getEntry))
            .recipe(NonNullBiConsumer.noop()).tag(Tags.Items.FEATHERS).register();
    public static final RegistryEntry<Item> CLOTH_STRING = REGISTRATE.item("cloth_string", Item::new).model((ctx, provider) -> provider.generated(ctx::getEntry))
            .recipe(NonNullBiConsumer.noop()).tag(Tags.Items.STRING).register();

    public static final RegistryEntry<Item> MUSKOX_FUR = REGISTRATE.item("muskox_fur", Item::new).model((ctx, provider) -> provider.generated(ctx::getEntry))
            .recipe(NonNullBiConsumer.noop()).tag(Tags.Items.LEATHER).register();

    public static final RegistryEntry<Item> COPPER_CLUMP = REGISTRATE.item("copper_clump", Item::new).model((ctx, provider) -> provider.generated(ctx::getEntry))
            .recipe((ctx, provider) -> provider.smeltingAndBlasting(DataIngredient.items(DeadBlocks.COPPER_ORE), ctx::getEntry, .7f)).register();

    public static final RegistryEntry<Item> FROST_METAL_CLUMP = REGISTRATE.item("frost_metal_clump", Item::new).model((ctx, provider) -> provider.generated(ctx::getEntry))
            .recipe((ctx, provider) -> provider.smeltingAndBlasting(DataIngredient.items(DeadBlocks.FROST_METAL_ORE), ctx::getEntry, .85f)).register();

    public static final RegistryEntry<FrostCopperClumpItem> FROST_COPPER_CLUMP = REGISTRATE.item("frost_copper_clump", FrostCopperClumpItem::new).properties(Item.Properties::isBurnable)
            .recipe((ctx, provider) -> ShapelessRecipeBuilder.shapelessRecipe(ctx.getEntry()).addIngredient(COPPER_CLUMP.get()).addIngredient(FROST_METAL_CLUMP.get())
                    .addCriterion("has_copper", RegistrateRecipeProvider.hasItem(COPPER_CLUMP.get()))
                    .addCriterion("has_frost_metal", RegistrateRecipeProvider.hasItem(FROST_METAL_CLUMP.get())).build(provider))
            .model((ctx, provider) -> provider.generated(ctx::getEntry)).register();
    public static final RegistryEntry<Item> FROST_BRONZE_INGOT = REGISTRATE.item("frost_bronze_ingot", Item::new).properties(Item.Properties::isBurnable)
            .model((ctx, provider) -> provider.generated(ctx::getEntry)).register();

    public static final RegistryEntry<Item> HEAT_STONE = REGISTRATE.item("heat_stone", Item::new).model((ctx, provider) -> provider.generated(ctx::getEntry))
            .recipe((ctx, provider) -> provider.smeltingAndBlasting(DataIngredient.items(DeadBlocks.HEATSTONE_ORE), ctx::getEntry, 1f)).register();

    public static final RegistryEntry<Item> MUMMY_PALM = REGISTRATE.item("mummy_palm", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::getEntry)).register();

    public static final RegistryEntry<Item> SEVERED_HEAD = REGISTRATE.item("severed_head", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::getEntry)).register();

    public static final RegistryEntry<Item> SPINE = REGISTRATE.item("spine", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::getEntry)).register();

    public static final RegistryEntry<Item> WORN_PAPER = REGISTRATE.item("worn_paper", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::getEntry)).register();

    //Tools
    public static final RegistryEntry<AxeItem> DEAD_WOOD_AXE = REGISTRATE.item("dead_wood_axe", prop -> new AxeItem(ItemTier.WOOD, 6f, -2.88f, prop))
            .properties(prop -> prop.maxStackSize(1)).model((ctx, provider) -> provider.handheld(ctx::getEntry)).recipe(axeRecipe(DeadBlocks.DEAD_PLANKS)).register();
    public static final RegistryEntry<PickaxeItem> DEAD_WOOD_PICKAXE = REGISTRATE.item("dead_wood_pickaxe", prop -> new PickaxeItem(ItemTier.WOOD, 1, -2.52f, prop))
            .properties(prop -> prop.maxStackSize(1)).model((ctx, provider) -> provider.handheld(ctx::getEntry)).recipe(pickaxeRecipe(DeadBlocks.DEAD_PLANKS)).register();
    public static final RegistryEntry<ShovelItem> DEAD_WOOD_SHOVEL = REGISTRATE.item("dead_wood_shovel", prop -> new ShovelItem(ItemTier.WOOD, 1.5f, -2.7f, prop))
            .properties(prop -> prop.maxStackSize(1)).model((ctx, provider) -> provider.handheld(ctx::getEntry)).recipe(shovelRecipe(DeadBlocks.DEAD_PLANKS)).register();
    public static final RegistryEntry<SwordItem> DEAD_WOOD_SWORD = REGISTRATE.item("dead_wood_sword", prop -> new SwordItem(ItemTier.WOOD, 3, -2.16f, prop))
            .properties(prop -> prop.maxStackSize(1)).model((ctx, provider) -> provider.handheld(ctx::getEntry)).recipe(swordRecipe(DeadBlocks.DEAD_PLANKS)).register();
    public static final RegistryEntry<HoeItem> DEAD_WOOD_HOE = REGISTRATE.item("dead_wood_hoe", prop -> new HoeItem(ItemTier.WOOD, 0, -2.7f, prop))
            .properties(prop -> prop.maxStackSize(1)).model((ctx, provider) -> provider.handheld(ctx::getEntry)).recipe(hoeRecipe(DeadBlocks.DEAD_PLANKS)).register();

    public static final RegistryEntry<DeadWoodBow> DEAD_WOOD_BOW = REGISTRATE.item("dead_wood_bow", DeadWoodBow::new).properties(prop -> prop.maxDamage(384))
            .model(NonNullBiConsumer.noop()).recipe((ctx, provider) -> ShapedRecipeBuilder.shapedRecipe(ctx.getEntry())
                    .key('t', DEAD_WOOD_STICK.get()).key('s', CLOTH_STRING.get()).patternLine(" ts").patternLine("t s").patternLine(" ts")
                    .addCriterion("has_string", RegistrateRecipeProvider.hasItem(DEAD_WOOD_STICK.get())).build(provider)).register();
    public static final RegistryEntry<ArrowItem> DEAD_WOOD_ARROW = REGISTRATE.item("dead_wood_arrow", ArrowItem::new).model((ctx, provider) -> provider.generated(ctx::getEntry))
            .tag(ItemTags.ARROWS).recipe((ctx, provider) -> ShapedRecipeBuilder.shapedRecipe(ctx.getEntry())
                    .key('f', SPINE.get()).key('s', DEAD_WOOD_STICK.get()).key('o', OWL_FEATHER.get())
                    .patternLine("f").patternLine("s").patternLine("o")
                    .addCriterion("has_string", RegistrateRecipeProvider.hasItem(DEAD_WOOD_STICK.get()))
                    .addCriterion("has_feather", RegistrateRecipeProvider.hasItem(OWL_FEATHER.get())).build(provider)).register();

    public static final RegistryEntry<AxeItem> COLDSTONE_AXE = REGISTRATE.item("coldstone_axe", prop -> new AxeItem(ItemTier.STONE, 7f, -3.2f, prop))
            .properties(prop -> prop.maxStackSize(1)).model((ctx, provider) -> provider.handheld(ctx::getEntry)).recipe(axeRecipe(DeadTags.Items.COLDSTONE)).register();
    public static final RegistryEntry<PickaxeItem> COLDSTONE_PICKAXE = REGISTRATE.item("coldstone_pickaxe", prop -> new PickaxeItem(ItemTier.STONE, 1, -2.8f, prop))
            .properties(prop -> prop.maxStackSize(1)).model((ctx, provider) -> provider.handheld(ctx::getEntry)).recipe(pickaxeRecipe(DeadTags.Items.COLDSTONE)).register();
    public static final RegistryEntry<ShovelItem> COLDSTONE_SHOVEL = REGISTRATE.item("coldstone_shovel", prop -> new ShovelItem(ItemTier.STONE, 1.5f, -3f, prop))
            .properties(prop -> prop.maxStackSize(1)).model((ctx, provider) -> provider.handheld(ctx::getEntry)).recipe(shovelRecipe(DeadTags.Items.COLDSTONE)).register();
    public static final RegistryEntry<SwordItem> COLDSTONE_SWORD = REGISTRATE.item("coldstone_sword", prop -> new SwordItem(ItemTier.STONE, 3, -2.4f, prop))
            .properties(prop -> prop.maxStackSize(1)).model((ctx, provider) -> provider.handheld(ctx::getEntry)).recipe(swordRecipe(DeadTags.Items.COLDSTONE)).register();
    public static final RegistryEntry<HoeItem> COLDSTONE_HOE = REGISTRATE.item("coldstone_hoe", prop -> new HoeItem(ItemTier.STONE, -1, -2f, prop))
            .properties(prop -> prop.maxStackSize(1)).model((ctx, provider) -> provider.handheld(ctx::getEntry)).recipe(hoeRecipe(DeadTags.Items.COLDSTONE)).register();

    public static final RegistryEntry<AxeItem> FROST_BRONZE_AXE = REGISTRATE.item("frost_bronze_axe", prop -> new AxeItem(ItemTier.IRON, 6f, -3.1f, prop))
            .properties(prop -> prop.maxStackSize(1)).model((ctx, provider) -> provider.handheld(ctx::getEntry)).recipe(axeRecipe(FROST_BRONZE_INGOT)).register();
    public static final RegistryEntry<PickaxeItem> FROST_BRONZE_PICKAXE = REGISTRATE.item("frost_bronze_pickaxe", prop -> new PickaxeItem(ItemTier.IRON, 1, -2.8f, prop))
            .properties(prop -> prop.maxStackSize(1)).model((ctx, provider) -> provider.handheld(ctx::getEntry)).recipe(pickaxeRecipe(FROST_BRONZE_INGOT)).register();
    public static final RegistryEntry<ShovelItem> FROST_BRONZE_SHOVEL = REGISTRATE.item("frost_bronze_shovel", prop -> new ShovelItem(ItemTier.IRON, 1.5f, -3f, prop))
            .properties(prop -> prop.maxStackSize(1)).model((ctx, provider) -> provider.handheld(ctx::getEntry)).recipe(shovelRecipe(FROST_BRONZE_INGOT)).register();
    public static final RegistryEntry<SwordItem> FROST_BRONZE_SWORD = REGISTRATE.item("frost_bronze_sword", prop -> new SwordItem(ItemTier.IRON, 3, -2.4f, prop))
            .properties(prop -> prop.maxStackSize(1)).model((ctx, provider) -> provider.handheld(ctx::getEntry)).recipe(swordRecipe(FROST_BRONZE_INGOT)).register();
    public static final RegistryEntry<HoeItem> FROST_BRONZE_HOE = REGISTRATE.item("frost_bronze_hoe", prop -> new HoeItem(ItemTier.IRON, -2, -1f, prop))
            .properties(prop -> prop.maxStackSize(1)).model((ctx, provider) -> provider.handheld(ctx::getEntry)).recipe(hoeRecipe(FROST_BRONZE_INGOT)).register();

    public static final RegistryEntry<SwordItem> HEAT_HAMMER = REGISTRATE.item("heat_hammer", prop -> new SwordItem(ItemTier.DIAMOND, 3, -2.4f, prop))
            .properties(prop -> prop.maxStackSize(1)).model((ctx, provider) -> provider.handheld(ctx::getEntry)).recipe(NonNullBiConsumer.noop()).register();
    public static final RegistryEntry<PickaxeItem> HEAT_PICKAXE = REGISTRATE.item("heat_pickaxe", prop -> new PickaxeItem(ItemTier.DIAMOND, 1, -2.8f, prop))
            .properties(prop -> prop.maxStackSize(1)).model((ctx, provider) -> provider.handheld(ctx::getEntry)).recipe(NonNullBiConsumer.noop()).register();

    public static final RegistryEntry<SwordItem> MAIDENS_DAGGER = REGISTRATE.item("maidens_dagger", prop -> new SwordItem(ItemTier.IRON, 3, -2.16f, prop))
            .properties(prop -> prop.maxStackSize(1)).model((ctx, provider) -> provider.handheld(ctx::getEntry)).recipe(NonNullBiConsumer.noop()).register();

    public static final RegistryEntry<SwordItem> TALL_KNIGHT_BLADE = REGISTRATE.item("tall_knight_blade", prop -> new SwordItem(ItemTier.DIAMOND, 3, -2.5f, prop))
            .properties(prop -> prop.maxStackSize(1)).model((ctx, provider) -> provider.handheld(ctx::getEntry)).recipe(NonNullBiConsumer.noop()).register();
    public static final RegistryEntry<Item> TALL_KNIGHT_STAFF = REGISTRATE.item("tall_knight_staff", Item::new)
            .properties(prop -> prop.maxStackSize(1)).model((ctx, provider) -> provider.handheld(ctx::getEntry)).recipe(NonNullBiConsumer.noop()).register();

    public static final RegistryEntry<Item> FIRE_STARTER = REGISTRATE.item("fire_starter", Item::new).properties(prop -> prop.maxStackSize(1))
            .model((ctx, provider) -> provider.generated(ctx::getEntry)).recipe((ctx, provider) -> ShapelessRecipeBuilder.shapelessRecipe(ctx.getEntry())
                    .addIngredient(DEAD_WOOD_STICK.get()).addIngredient(DEAD_WOOD_STICK.get()).addCriterion("has_stick", RegistrateRecipeProvider.hasItem(DEAD_WOOD_STICK.get()))
                    .build(provider)).register();

    //Misc
    public static final RegistryEntry<Item> UNDEAD_TALISMAN = REGISTRATE.item("undead_talisman", Item::new).properties(prop -> prop.maxStackSize(1))
            .model(NonNullBiConsumer.noop()).recipe(NonNullBiConsumer.noop()).register();

    //Food
    public static final RegistryEntry<Item> RAT_DROPPINGS = REGISTRATE.item("rat_droppings", Item::new).properties(prop -> prop.food(DeadFoods.RAT_DROPPINGS_FOOD))
            .tag(DeadTags.Items.RAT_IGNORE).model((ctx, provider) -> provider.generated(ctx::getEntry)).register();

    public static final RegistryEntry<Item> DEAD_RAT = REGISTRATE.item("dead_rat", Item::new).properties(prop -> prop.food(DeadFoods.DEAD_RAT))
            .tag(DeadTags.Items.RAT_IGNORE, DeadTags.Items.OWL_TAME).model((ctx, provider) -> provider.generated(ctx::getEntry)).register();
    public static final RegistryEntry<Item> COOKED_RAT = REGISTRATE.item("cooked_rat", Item::new).properties(prop -> prop.food(DeadFoods.COOKED_RAT))
            .recipe((ctx, provider) -> {
                provider.smelting(DataIngredient.items(DEAD_RAT), ctx::getEntry, .35f, 200);
                provider.smoking(DataIngredient.items(DEAD_RAT), ctx::getEntry, .35f, 100);
                provider.campfire(DataIngredient.items(DEAD_RAT), ctx::getEntry, .35f, 600);
            }).tag(DeadTags.Items.RAT_IGNORE, DeadTags.Items.OWL_TAME).model((ctx, provider) -> provider.generated(ctx::getEntry)).register();

    public static final RegistryEntry<Item> MUSKOX = REGISTRATE.item("muskox", Item::new).properties(prop -> prop.food(DeadFoods.MUSKOX))
            .model((ctx, provider) -> provider.generated(ctx::getEntry)).register();
    public static final RegistryEntry<Item> COOKED_MUSKOX = REGISTRATE.item("cooked_muskox", Item::new).properties(prop -> prop.food(DeadFoods.COOKED_MUSKOX))
            .recipe((ctx, provider) -> {
                provider.smelting(DataIngredient.items(MUSKOX), ctx::getEntry, .35f, 200);
                provider.smoking(DataIngredient.items(MUSKOX), ctx::getEntry, .35f, 100);
                provider.campfire(DataIngredient.items(MUSKOX), ctx::getEntry, .35f, 600);
            }).model((ctx, provider) -> provider.generated(ctx::getEntry)).register();

    public static final RegistryEntry<Item> ROTTON_SKIN = REGISTRATE.item("rotton_skin", Item::new).properties(prop -> prop.food(DeadFoods.ROTTON_SKIN))
            .tag(DeadTags.Items.RAT_IGNORE).model((ctx, provider) -> provider.generated(ctx::getEntry)).register();
    public static final RegistryEntry<Item> COOKED_SKIN = REGISTRATE.item("cooked_skin", Item::new).properties(prop -> prop.food(DeadFoods.COOKED_SKIN))
            .recipe((ctx, provider) -> {
                provider.smelting(DataIngredient.items(ROTTON_SKIN), ctx::getEntry, .35f, 200);
                provider.smoking(DataIngredient.items(ROTTON_SKIN), ctx::getEntry, .35f, 100);
                provider.campfire(DataIngredient.items(ROTTON_SKIN), ctx::getEntry, .35f, 600);
            }).tag(DeadTags.Items.RAT_IGNORE).model((ctx, provider) -> provider.generated(ctx::getEntry)).register();

    private static NonNullBiConsumer<DataGenContext<Item, PickaxeItem>, RegistrateRecipeProvider> pickaxeRecipe(ITag<Item> ingot)
    {
        return (ctx, provider) -> ShapedRecipeBuilder.shapedRecipe(ctx::getEntry).addCriterion("has_ingot", RegistrateRecipeProvider.hasItem(ingot))
                .key('s', Tags.Items.RODS_WOODEN).key('i', ingot)
                .patternLine("iii")
                .patternLine(" s ")
                .patternLine(" s ").build(provider);
    }

    private static NonNullBiConsumer<DataGenContext<Item, PickaxeItem>, RegistrateRecipeProvider> pickaxeRecipe(Supplier<? extends IItemProvider> ingot)
    {
        return (ctx, provider) -> ShapedRecipeBuilder.shapedRecipe(ctx::getEntry).addCriterion("has_ingot", RegistrateRecipeProvider.hasItem(ingot.get()))
                .key('s', Tags.Items.RODS_WOODEN).key('i', ingot.get())
                .patternLine("iii")
                .patternLine(" s ")
                .patternLine(" s ").build(provider);
    }

    private static NonNullBiConsumer<DataGenContext<Item, AxeItem>, RegistrateRecipeProvider> axeRecipe(ITag<Item> ingot)
    {
        return (ctx, provider) -> ShapedRecipeBuilder.shapedRecipe(ctx::getEntry).addCriterion("has_ingot", RegistrateRecipeProvider.hasItem(ingot))
                .key('s', Tags.Items.RODS_WOODEN).key('i', ingot)
                .patternLine("ii")
                .patternLine("is")
                .patternLine(" s").build(provider);
    }

    private static NonNullBiConsumer<DataGenContext<Item, AxeItem>, RegistrateRecipeProvider> axeRecipe(Supplier<? extends IItemProvider> ingot)
    {
        return (ctx, provider) -> ShapedRecipeBuilder.shapedRecipe(ctx::getEntry).addCriterion("has_ingot", RegistrateRecipeProvider.hasItem(ingot.get()))
                .key('s', Tags.Items.RODS_WOODEN).key('i', ingot.get())
                .patternLine("ii")
                .patternLine("is")
                .patternLine(" s").build(provider);
    }

    private static NonNullBiConsumer<DataGenContext<Item, HoeItem>, RegistrateRecipeProvider> hoeRecipe(ITag<Item> ingot)
    {
        return (ctx, provider) -> ShapedRecipeBuilder.shapedRecipe(ctx::getEntry).addCriterion("has_ingot", RegistrateRecipeProvider.hasItem(ingot))
                .key('s', Tags.Items.RODS_WOODEN).key('i', ingot)
                .patternLine("ii")
                .patternLine(" s")
                .patternLine(" s").build(provider);
    }

    private static NonNullBiConsumer<DataGenContext<Item, HoeItem>, RegistrateRecipeProvider> hoeRecipe(Supplier<? extends IItemProvider> ingot)
    {
        return (ctx, provider) -> ShapedRecipeBuilder.shapedRecipe(ctx::getEntry).addCriterion("has_ingot", RegistrateRecipeProvider.hasItem(ingot.get()))
                .key('s', Tags.Items.RODS_WOODEN).key('i', ingot.get())
                .patternLine("ii")
                .patternLine(" s")
                .patternLine(" s").build(provider);
    }

    private static NonNullBiConsumer<DataGenContext<Item, ShovelItem>, RegistrateRecipeProvider> shovelRecipe(ITag<Item> ingot)
    {
        return (ctx, provider) -> ShapedRecipeBuilder.shapedRecipe(ctx::getEntry).addCriterion("has_ingot", RegistrateRecipeProvider.hasItem(ingot))
                .key('s', Tags.Items.RODS_WOODEN).key('i', ingot)
                .patternLine("i")
                .patternLine("s")
                .patternLine("s").build(provider);
    }

    private static NonNullBiConsumer<DataGenContext<Item, ShovelItem>, RegistrateRecipeProvider> shovelRecipe(Supplier<? extends IItemProvider> ingot)
    {
        return (ctx, provider) -> ShapedRecipeBuilder.shapedRecipe(ctx::getEntry).addCriterion("has_ingot", RegistrateRecipeProvider.hasItem(ingot.get()))
                .key('s', Tags.Items.RODS_WOODEN).key('i', ingot.get())
                .patternLine("i")
                .patternLine("s")
                .patternLine("s").build(provider);
    }

    private static NonNullBiConsumer<DataGenContext<Item, SwordItem>, RegistrateRecipeProvider> swordRecipe(ITag<Item> ingot)
    {
        return (ctx, provider) -> ShapedRecipeBuilder.shapedRecipe(ctx::getEntry).addCriterion("has_ingot", RegistrateRecipeProvider.hasItem(ingot))
                .key('s', Tags.Items.RODS_WOODEN).key('i', ingot)
                .patternLine("i")
                .patternLine("i")
                .patternLine("s").build(provider);
    }

    private static NonNullBiConsumer<DataGenContext<Item, SwordItem>, RegistrateRecipeProvider> swordRecipe(Supplier<? extends IItemProvider> ingot)
    {
        return (ctx, provider) -> ShapedRecipeBuilder.shapedRecipe(ctx::getEntry).addCriterion("has_ingot", RegistrateRecipeProvider.hasItem(ingot.get()))
                .key('s', Tags.Items.RODS_WOODEN).key('i', ingot.get())
                .patternLine("i")
                .patternLine("i")
                .patternLine("s").build(provider);
    }

    public static void load()
    {
        LOGGER.info("Loaded");
    }
}
