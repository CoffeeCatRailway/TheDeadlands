package coffeecatrailway.tdeadlands.registry;

import coffeecatrailway.tdeadlands.TheDeadlands;
import coffeecatrailway.tdeadlands.client.item.renderer.DeadWoodChestItemRenderer;
import coffeecatrailway.tdeadlands.common.block.*;
import coffeecatrailway.tdeadlands.integration.registrate.DeadBlockstates;
import coffeecatrailway.tdeadlands.integration.registrate.DeadTags;
import com.tterrag.registrate.providers.RegistrateRecipeProvider;
import com.tterrag.registrate.providers.loot.RegistrateBlockLootTables;
import com.tterrag.registrate.util.DataIngredient;
import com.tterrag.registrate.util.entry.RegistryEntry;
import com.tterrag.registrate.util.nullness.NonNullBiConsumer;
import com.tterrag.registrate.util.nullness.NonNullFunction;
import com.tterrag.registrate.util.nullness.NonNullSupplier;
import com.tterrag.registrate.util.nullness.NonNullUnaryOperator;
import net.minecraft.advancements.criterion.*;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.color.IBlockColor;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.data.ShapedRecipeBuilder;
import net.minecraft.data.ShapelessRecipeBuilder;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.*;
import net.minecraft.loot.*;
import net.minecraft.loot.conditions.*;
import net.minecraft.loot.functions.ApplyBonus;
import net.minecraft.loot.functions.CopyName;
import net.minecraft.loot.functions.ExplosionDecay;
import net.minecraft.loot.functions.SetCount;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.state.properties.AttachFace;
import net.minecraft.state.properties.DoubleBlockHalf;
import net.minecraft.state.properties.SlabType;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ITag;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.Direction;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.BiomeColors;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.client.model.generators.ModelProvider;
import net.minecraftforge.common.Tags;
import org.apache.logging.log4j.Logger;

import java.util.function.Supplier;

import static coffeecatrailway.tdeadlands.TheDeadlands.REGISTRATE;

/**
 * @author CoffeeCatRailway
 * Created: 21/08/2020
 */
public class DeadBlocks
{
    private static final Logger LOGGER = TheDeadlands.getLogger("Blocks");

    // Ores
    public static final RegistryEntry<Block> COPPER_ORE = REGISTRATE.object("copper_ore").block(Block::new).initialProperties(Material.ROCK, MaterialColor.BLACK)
            .properties(prop -> prop.setRequiresTool().hardnessAndResistance(3f, 3f)).defaultBlockstate().tag(DeadTags.Blocks.ORES_COPPER)
            .loot((tables, block) -> tables.registerDropping(block, DeadItems.COPPER_CLUMP.get())).item().tag(DeadTags.Items.ORES_COPPER).build().register();

    public static final RegistryEntry<Block> FROST_METAL_ORE = REGISTRATE.object("frost_metal_ore").block(Block::new).initialProperties(Material.ROCK, MaterialColor.BLACK)
            .properties(prop -> prop.setRequiresTool().hardnessAndResistance(3f, 3f)).defaultBlockstate().tag(Tags.Blocks.ORES)
            .loot((tables, block) -> tables.registerDropping(block, DeadItems.FROST_METAL_CLUMP.get())).item().tag(Tags.Items.ORES).build().register();

    public static final RegistryEntry<Block> HEATSTONE_ORE = REGISTRATE.object("heatstone_ore").block(Block::new).initialProperties(Material.ROCK, MaterialColor.BLACK)
            .properties(prop -> prop.setRequiresTool().hardnessAndResistance(3f, 3f)).defaultBlockstate().tag(Tags.Blocks.ORES)
            .loot((tables, block) -> tables.registerDropping(block, DeadItems.HEAT_STONE.get())).item().tag(Tags.Items.ORES).build().register();
    public static final RegistryEntry<Block> HEATSTONE_BLOCK = REGISTRATE.object("heatstone_block").block(Block::new).initialProperties(Material.ROCK, MaterialColor.RED)
            .properties(prop -> prop.setRequiresTool().hardnessAndResistance(1.5f, 6f).sound(SoundType.METAL)).defaultLoot().defaultBlockstate()
            .recipe((ctx, provider) -> provider.square(DataIngredient.items(DeadItems.HEAT_STONE), ctx::getEntry, false)).simpleItem().register();

    public static final RegistryEntry<Block> FROST_BRONZE_BLOCK = REGISTRATE.object("frost_bronze_block").block(Block::new).initialProperties(Material.IRON, MaterialColor.ORANGE_TERRACOTTA)
            .properties(prop -> prop.setRequiresTool().hardnessAndResistance(5f, 6f).sound(SoundType.METAL)).defaultLoot().defaultBlockstate().tag(Tags.Blocks.ORES)
            .recipe((ctx, provider) -> provider.square(DataIngredient.items(DeadItems.FROST_BRONZE_INGOT), ctx::getEntry, false)).item().tag(Tags.Items.ORES).build().register();

    // Coldstone
    public static final RegistryEntry<Block> COLDSTONE = REGISTRATE.object("coldstone").block(Block::new).initialProperties(Material.ROCK, MaterialColor.BLACK)
            .properties(prop -> prop.setRequiresTool().hardnessAndResistance(1.5f, 6f)).defaultLoot().defaultBlockstate().tag(DeadTags.Blocks.COLDSTONE)
            .item().tag(DeadTags.Items.COLDSTONE).build().register();
    public static final RegistryEntry<StairsBlock> COLDSTONE_STARIS = registerStairs("coldstone_stairs", COLDSTONE, "coldstone_stairs");
    public static final RegistryEntry<SlabBlock> COLDSTONE_SLAB = registerSlab("coldstone_slab", COLDSTONE, "coldstone_slab");
    public static final RegistryEntry<WallBlock> COLDSTONE_WALL = registerWall("coldstone_wall", COLDSTONE, "coldstone_wall");
    public static final RegistryEntry<PressurePlateBlock> COLDSTONE_PRESSURE_PLATE = registerPressurePlate("coldstone_pressure_plate", COLDSTONE, true, "coldstone_pressure_plate");
    public static final RegistryEntry<StoneButtonBlock> COLDSTONE_BUTTON = registerButton("coldstone_button", COLDSTONE, StoneButtonBlock::new, "coldstone_button");

    public static final RegistryEntry<Block> COLDSTONE_BRICKS = REGISTRATE.object("coldstone_bricks").block(Block::new).initialProperties(COLDSTONE)
            .recipe((ctx, provider) -> {
                ShapedRecipeBuilder.shapedRecipe(ctx.getEntry(), 4).key('c', COLDSTONE.get()).patternLine("cc").patternLine("cc")
                        .addCriterion("has_coldstone", RegistrateRecipeProvider.hasItem(COLDSTONE.get())).build(provider);
                provider.stonecutting(DataIngredient.items(COLDSTONE), ctx::getEntry);
            })
            .defaultLoot().defaultBlockstate().tag(DeadTags.Blocks.COLDSTONE).item().tag(DeadTags.Items.COLDSTONE).build().register();
    public static final RegistryEntry<StairsBlock> COLDSTONE_BRICKS_STARIS = registerStairs("coldstone_bricks_stairs", COLDSTONE_BRICKS, "coldstone_stairs");
    public static final RegistryEntry<SlabBlock> COLDSTONE_BRICKS_SLAB = registerSlab("coldstone_bricks_slab", COLDSTONE_BRICKS, "coldstone_slab");
    public static final RegistryEntry<WallBlock> COLDSTONE_BRICKS_WALL = registerWall("coldstone_bricks_wall", COLDSTONE_BRICKS, "coldstone_wall");
    public static final RegistryEntry<PressurePlateBlock> COLDSTONE_BRICKS_PRESSURE_PLATE = registerPressurePlate("coldstone_bricks_pressure_plate", COLDSTONE_BRICKS, true, "coldstone_pressure_plate");
    public static final RegistryEntry<StoneButtonBlock> COLDSTONE_BRICKS_BUTTON = registerButton("coldstone_bricks_button", COLDSTONE_BRICKS, StoneButtonBlock::new, "coldstone_button");

    public static final RegistryEntry<Block> CRACKED_COLDSTONE_BRICKS = REGISTRATE.object("cracked_coldstone_bricks").block(Block::new).initialProperties(COLDSTONE)
            .recipe((ctx, provider) -> provider.smelting(DataIngredient.items(COLDSTONE_BRICKS), ctx::getEntry, .1f))
            .defaultLoot().defaultBlockstate().tag(DeadTags.Blocks.COLDSTONE).item().tag(DeadTags.Items.COLDSTONE).build().register();
    public static final RegistryEntry<StairsBlock> CRACKED_COLDSTONE_STARIS = registerStairs("cracked_coldstone_stairs", CRACKED_COLDSTONE_BRICKS, "coldstone_stairs");
    public static final RegistryEntry<SlabBlock> CRACKED_COLDSTONE_SLAB = registerSlab("cracked_coldstone_slab", CRACKED_COLDSTONE_BRICKS, "coldstone_slab");
    public static final RegistryEntry<WallBlock> CRACKED_COLDSTONE_WALL = registerWall("cracked_coldstone_wall", CRACKED_COLDSTONE_BRICKS, "coldstone_wall");
    public static final RegistryEntry<PressurePlateBlock> CRACKED_COLDSTONE_PRESSURE_PLATE = registerPressurePlate("cracked_coldstone_pressure_plate", CRACKED_COLDSTONE_BRICKS, true, "coldstone_pressure_plate");
    public static final RegistryEntry<StoneButtonBlock> CRACKED_COLDSTONE_BUTTON = registerButton("cracked_coldstone_button", CRACKED_COLDSTONE_BRICKS, StoneButtonBlock::new, "coldstone_button");

    public static final RegistryEntry<Block> MOSSY_COLDSTONE_BRICKS = REGISTRATE.object("mossy_coldstone_bricks").block(Block::new).initialProperties(COLDSTONE)
            .recipe((ctx, provider) -> ShapelessRecipeBuilder.shapelessRecipe(ctx.getEntry()).addIngredient(COLDSTONE_BRICKS.get()).addIngredient(Blocks.VINE)
                    .addCriterion("has_coldstone", RegistrateRecipeProvider.hasItem(COLDSTONE_BRICKS.get())).build(provider))
            .defaultLoot().defaultBlockstate().tag(DeadTags.Blocks.COLDSTONE).item().tag(DeadTags.Items.COLDSTONE).build().register();
    public static final RegistryEntry<StairsBlock> MOSSY_COLDSTONE_STARIS = registerStairs("mossy_coldstone_stairs", MOSSY_COLDSTONE_BRICKS, "coldstone_stairs");
    public static final RegistryEntry<SlabBlock> MOSSY_COLDSTONE_SLAB = registerSlab("mossy_coldstone_slab", MOSSY_COLDSTONE_BRICKS, "coldstone_slab");
    public static final RegistryEntry<WallBlock> MOSSY_COLDSTONE_WALL = registerWall("mossy_coldstone_wall", MOSSY_COLDSTONE_BRICKS, "coldstone_wall");
    public static final RegistryEntry<PressurePlateBlock> MOSSY_COLDSTONE_PRESSURE_PLATE = registerPressurePlate("mossy_coldstone_pressure_plate", MOSSY_COLDSTONE_BRICKS, true, "coldstone_pressure_plate");
    public static final RegistryEntry<StoneButtonBlock> MOSSY_COLDSTONE_BUTTON = registerButton("mossy_coldstone_button", MOSSY_COLDSTONE_BRICKS, StoneButtonBlock::new, "coldstone_button");

    public static final RegistryEntry<Block> CHISELED_COLDSTONE_BRICKS = REGISTRATE.object("chiseled_coldstone_bricks").block(Block::new).initialProperties(COLDSTONE)
            .recipe((ctx, provider) -> provider.stonecutting(DataIngredient.items(COLDSTONE), ctx::getEntry))
            .defaultLoot().defaultBlockstate().tag(DeadTags.Blocks.COLDSTONE).item().tag(DeadTags.Items.COLDSTONE).build().register();

    // Dead Wood
    public static final RegistryEntry<RotatedPillarBlock> DEAD_LOG = registerLog("dead_wood_log", MaterialColor.GRAY);
    public static final RegistryEntry<RotatedPillarBlock> STRIPPED_DEAD_LOG = registerLog("stripped_dead_wood_log", MaterialColor.LIGHT_GRAY);
    public static final RegistryEntry<RotatedPillarBlock> DEAD_WOOD = registerLog("dead_wood", MaterialColor.GRAY, "dead_wood_log", DEAD_LOG);
    public static final RegistryEntry<RotatedPillarBlock> STRIPPED_DEAD_WOOD = registerLog("stripped_dead_wood", MaterialColor.LIGHT_GRAY, "dead_wood_log", STRIPPED_DEAD_LOG);
    public static final RegistryEntry<LeavesBlock> DEAD_LEAVES = registerLeaves("dead_leaves", MaterialColor.LIGHT_GRAY, () -> Blocks.ACACIA_SAPLING);

    public static final RegistryEntry<Block> DEAD_PLANKS = registerPlanks("dead_wood_planks", MaterialColor.LIGHT_GRAY, DEAD_LOG, STRIPPED_DEAD_LOG, DEAD_WOOD, STRIPPED_DEAD_WOOD);
    public static final RegistryEntry<DoorBlock> DEAD_WOOD_DOOR = registerDoor("dead_wood_door", DEAD_PLANKS);
    // TODO dead_wood_trapdoor
    public static final RegistryEntry<StairsBlock> DEAD_WOOD_STARIS = registerStairs("dead_wood_stairs", DEAD_PLANKS, "wooden_stairs");
    public static final RegistryEntry<SlabBlock> DEAD_WOOD_SLAB = registerSlab("dead_wood_slab", DEAD_PLANKS, "wooden_slab");
    public static final RegistryEntry<WoodButtonBlock> DEAD_WOOD_BUTTON = registerButton("dead_wood_button", DEAD_PLANKS, WoodButtonBlock::new, "wooden_button");
    public static final RegistryEntry<PressurePlateBlock> DEAD_WOOD_PRESSURE_PLATE = registerPressurePlate("dead_wood_pressure_plate", DEAD_PLANKS, false, "wooden_pressure_plate");
    public static final RegistryEntry<FenceBlock> DEAD_WOOD_FENCE = REGISTRATE.object("dead_wood_fence").block(FenceBlock::new).initialProperties(DEAD_PLANKS)
            .defaultLoot().blockstate((ctx, provider) -> provider.fenceBlock(ctx.getEntry(), provider.blockTexture(DEAD_PLANKS.get())))
            .tag(BlockTags.FENCES, BlockTags.WOODEN_FENCES).recipe((ctx, provider) -> ShapedRecipeBuilder.shapedRecipe(ctx.getEntry(), 3).patternLine("wsw").patternLine("wsw")
                    .key('w', DEAD_PLANKS.get()).key('s', DeadItems.DEAD_WOOD_STICK.get()).setGroup("wooden_fence")
                    .addCriterion("has_wood", RegistrateRecipeProvider.hasItem(DEAD_PLANKS.get())).build(provider))
            .item().tag(ItemTags.FENCES, ItemTags.WOODEN_FENCES).model((ctx, provider) -> provider.fenceInventory(ctx.getName(), provider.modLoc("block/" + provider.name(DEAD_PLANKS)))).build().register();
    public static final RegistryEntry<FenceGateBlock> DEAD_WOOD_FENCE_GATE = REGISTRATE.object("dead_wood_fence_gate").block(FenceGateBlock::new).initialProperties(DEAD_PLANKS)
            .defaultLoot().blockstate((ctx, provider) -> provider.fenceGateBlock(ctx.getEntry(), provider.blockTexture(DEAD_PLANKS.get())))
            .tag(BlockTags.FENCE_GATES, Tags.Blocks.FENCE_GATES_WOODEN).recipe((ctx, provider) -> ShapedRecipeBuilder.shapedRecipe(ctx.getEntry()).patternLine("sws").patternLine("sws")
                    .key('w', DEAD_PLANKS.get()).key('s', DeadItems.DEAD_WOOD_STICK.get()).setGroup("wooden_fence_gate")
                    .addCriterion("has_wood", RegistrateRecipeProvider.hasItem(DEAD_PLANKS.get())).build(provider))
            .item().tag(Tags.Items.FENCE_GATES, Tags.Items.FENCE_GATES_WOODEN).build().register();
    public static final RegistryEntry<DeadWoodChestBlock> DEAD_WOOD_CHEST = REGISTRATE.object("dead_wood_chest").block(DeadWoodChestBlock::new).initialProperties(Material.WOOD, MaterialColor.WOOD)
            .properties(prop -> prop.hardnessAndResistance(2.5f).sound(SoundType.WOOD)).addLayer(() -> RenderType::getCutoutMipped)
            .blockstate((ctx, provider) -> provider.getVariantBuilder(ctx.getEntry()).partialState().modelForState().modelFile(provider.models().getBuilder(ctx.getName()).texture("particle", provider.blockTexture(DEAD_PLANKS.get()))).addModel())
            .loot((tables, block) -> tables.registerLootTable(block, LootTable.builder().addLootPool(LootPool.builder().rolls(new RandomValueRange(1))
                    .addEntry(ItemLootEntry.builder(block).acceptFunction(CopyName.builder(CopyName.Source.BLOCK_ENTITY))).acceptCondition(SurvivesExplosion.builder()))))
            .recipe((ctx, provider) -> ShapedRecipeBuilder.shapedRecipe(ctx.getEntry()).key('p', DEAD_PLANKS.get()).patternLine("ppp").patternLine("p p").patternLine("ppp")
                    .addCriterion("has_wood", RegistrateRecipeProvider.hasItem(DEAD_PLANKS.get())).build(provider))
            .tag(Tags.Blocks.CHESTS, Tags.Blocks.CHESTS_WOODEN)
            .item().model((ctx, provider) -> provider.withExistingParent(ctx.getName(), new ResourceLocation("item/chest")).texture("particle", "block/" + provider.name(DEAD_PLANKS)))
            .tag(Tags.Items.CHESTS, Tags.Items.CHESTS_WOODEN).properties(prop -> prop.setISTER(() -> DeadWoodChestItemRenderer::new)).build().register();

    public static final RegistryEntry<DeadWoodCraftingTableBlock> DEAD_WOOD_CRAFTING_TABLE = REGISTRATE.object("dead_wood_crafting_table").block(DeadWoodCraftingTableBlock::new)
            .initialProperties(Material.WOOD, DyeColor.GRAY).properties(prop -> prop.hardnessAndResistance(2.5F).sound(SoundType.WOOD))
            .blockstate(NonNullBiConsumer.noop()).recipe((ctx, provider) -> provider.square(DataIngredient.items(DEAD_PLANKS), ctx::getEntry, true))
            .addLayer(() -> RenderType::getCutoutMipped).defaultLoot().simpleItem().register();

    public static final RegistryEntry<WallTorchBlock> WALL_DEAD_WOOD_TORCH = REGISTRATE.object("wall_dead_wood_torch").block(prop -> new WallTorchBlock(prop, ParticleTypes.FLAME))
            .initialProperties(Material.MISCELLANEOUS, MaterialColor.AIR).properties(prop -> prop.doesNotBlockMovement().zeroHardnessAndResistance().setLightLevel((state) -> 14).sound(SoundType.WOOD))
            .blockstate((ctx, provider) -> {
                ModelFile model = provider.models().withExistingParent(ctx.getName(), new ResourceLocation("block/template_torch_wall"))
                        .texture("torch", TheDeadlands.getLocation("block/dead_wood_torch"));
                provider.getVariantBuilder(ctx.getEntry())
                        .partialState().with(WallTorchBlock.HORIZONTAL_FACING, Direction.EAST).modelForState().modelFile(model).addModel()
                        .partialState().with(WallTorchBlock.HORIZONTAL_FACING, Direction.NORTH).modelForState().modelFile(model).rotationY(270).addModel()
                        .partialState().with(WallTorchBlock.HORIZONTAL_FACING, Direction.SOUTH).modelForState().modelFile(model).rotationY(90).addModel()
                        .partialState().with(WallTorchBlock.HORIZONTAL_FACING, Direction.WEST).modelForState().modelFile(model).rotationY(180).addModel();
            })
            .addLayer(() -> RenderType::getCutoutMipped).lang(block -> "block." + TheDeadlands.MOD_ID + ".wall_dead_wood_torch", "Dead Wood Torch").register();
    public static final RegistryEntry<TorchBlock> DEAD_WOOD_TORCH = REGISTRATE.object("dead_wood_torch").block(prop -> new TorchBlock(prop, ParticleTypes.FLAME))
            .initialProperties(Material.MISCELLANEOUS, MaterialColor.AIR).properties(prop -> prop.doesNotBlockMovement().zeroHardnessAndResistance().setLightLevel((state) -> 14).sound(SoundType.WOOD))
            .blockstate((ctx, provider) -> provider.simpleBlock(ctx.getEntry(), provider.models()
                    .withExistingParent(ctx.getName(), new ResourceLocation("block/template_torch")).texture("torch", TheDeadlands.getLocation("block/dead_wood_torch"))))
            .recipe((ctx, provider) -> ShapedRecipeBuilder.shapedRecipe(ctx.getEntry(), 4).patternLine("h").patternLine("s")
                    .key('h', DeadItems.HEAT_STONE.get()).key('s', DeadItems.DEAD_WOOD_STICK.get())
                    .addCriterion("has_stick", RegistrateRecipeProvider.hasItem(DeadItems.DEAD_WOOD_STICK.get())).build(provider))
            .addLayer(() -> RenderType::getCutoutMipped).item((block, prop) -> new WallOrFloorItem(block, WALL_DEAD_WOOD_TORCH.get(), prop))
            .model((ctx, provider) -> provider.generated(ctx::getEntry, TheDeadlands.getLocation("block/dead_wood_torch"))).build().register();

    // Nature
    private static NonNullUnaryOperator<Block.Properties> GRASS_PROPS = prop -> prop.sound(SoundType.PLANT).doesNotBlockMovement().hardnessAndResistance(0f).notSolid();

    private static final Supplier<IItemColor> GRASS_COLOR_ITEM = () -> (stack, index) -> 0x8fb8cf;// TODO: Check if the world is the right dimension
    private static final Supplier<IBlockColor> GRASS_COLOR_BLOCK = () -> (state, world, pos, index) -> world != null && pos != null ? BiomeColors.getGrassColor(world, pos) : GRASS_COLOR_ITEM.get().getColor(ItemStack.EMPTY, index);

    public static final RegistryEntry<DeadTallGrassBlock> COLD_GRASS = REGISTRATE.object("cold_grass").block(DeadTallGrassBlock::new)
            .blockstate((ctx, provider) -> provider.simpleBlock(ctx.getEntry(), DeadBlockstates.getTintCross(provider, ctx.getName())))
            .color(() -> GRASS_COLOR_BLOCK).loot((tables, block) -> tables.registerLootTable(block, LootTable.builder()
                    .addLootPool(LootPool.builder().rolls(new RandomValueRange(1))
                            .addEntry(AlternativesLootEntry.builder(ItemLootEntry.builder(block)
                                            .acceptCondition(MatchTool.builder(ItemPredicate.Builder.create().tag(Tags.Items.SHEARS))),
                                    ItemLootEntry.builder(DeadItems.COLD_GRASS_STRAND.get())
                                            .acceptCondition(RandomChance.builder(.125f))
                                            .acceptFunction(ApplyBonus.uniformBonusCount(Enchantments.FORTUNE, 2))
                                            .acceptFunction(ExplosionDecay.builder()))))))
            .defaultLang().initialProperties(Material.TALL_PLANTS, MaterialColor.LIGHT_BLUE).properties(GRASS_PROPS).addLayer(() -> RenderType::getCutoutMipped)
            .item().color(() -> GRASS_COLOR_ITEM).model((ctx, provider) -> provider.generated(ctx::getEntry, TheDeadlands.getLocation("block/cold_grass"))).build().register();

    public static final RegistryEntry<DeadDoubleGrassBlock> COLD_TALL_GRASS = REGISTRATE.object("cold_tall_grass").block(DeadDoubleGrassBlock::new)
            .color(() -> GRASS_COLOR_BLOCK).blockstate((ctx, provider) -> provider.getVariantBuilder(ctx.getEntry())
                    .partialState().with(DeadDoubleGrassBlock.HALF, DoubleBlockHalf.LOWER)
                    .modelForState().modelFile(DeadBlockstates.getTintCross(provider, ctx.getName() + "_bottom")).addModel()
                    .partialState().with(DeadDoubleGrassBlock.HALF, DoubleBlockHalf.UPPER)
                    .modelForState().modelFile(DeadBlockstates.getTintCross(provider, ctx.getName() + "_top")).addModel())
            .loot((tables, block) -> tables.registerLootTable(block, LootTable.builder()
                    .addLootPool(LootPool.builder().rolls(new RandomValueRange(1))
                            .addEntry(AlternativesLootEntry.builder(ItemLootEntry.builder(COLD_GRASS.get())
                                            .acceptCondition(MatchTool.builder(ItemPredicate.Builder.create().tag(Tags.Items.SHEARS)))
                                            .acceptFunction(SetCount.builder(new RandomValueRange(2))),
                                    ItemLootEntry.builder(DeadItems.COLD_GRASS_STRAND.get())
                                            .acceptCondition(SurvivesExplosion.builder())
                                            .acceptCondition(RandomChance.builder(.125f))))
                            .acceptCondition(BlockStateProperty.builder(block).fromProperties(StatePropertiesPredicate.Builder.newBuilder().withProp(DeadDoubleGrassBlock.HALF, DoubleBlockHalf.LOWER)))
                            .acceptCondition(LocationCheck.func_241547_a_(LocationPredicate.Builder.builder().block(BlockPredicate.Builder.createBuilder().setBlock(block)
                                            .setStatePredicate(StatePropertiesPredicate.Builder.newBuilder().withProp(DeadDoubleGrassBlock.HALF, DoubleBlockHalf.UPPER).build()).build()),
                                    new BlockPos(0, 1, 0))))
                    .addLootPool(LootPool.builder().rolls(new RandomValueRange(1))
                            .addEntry(AlternativesLootEntry.builder(ItemLootEntry.builder(COLD_GRASS.get())
                                            .acceptCondition(MatchTool.builder(ItemPredicate.Builder.create().tag(Tags.Items.SHEARS)))
                                            .acceptFunction(SetCount.builder(new RandomValueRange(2))),
                                    ItemLootEntry.builder(DeadItems.COLD_GRASS_STRAND.get())
                                            .acceptCondition(SurvivesExplosion.builder())
                                            .acceptCondition(RandomChance.builder(.125f))))
                            .acceptCondition(BlockStateProperty.builder(block).fromProperties(StatePropertiesPredicate.Builder.newBuilder().withProp(DeadDoubleGrassBlock.HALF, DoubleBlockHalf.UPPER)))
                            .acceptCondition(LocationCheck.func_241547_a_(LocationPredicate.Builder.builder().block(BlockPredicate.Builder.createBuilder().setBlock(block)
                                            .setStatePredicate(StatePropertiesPredicate.Builder.newBuilder().withProp(DeadDoubleGrassBlock.HALF, DoubleBlockHalf.LOWER).build()).build()),
                                    new BlockPos(0, -1, 0))))))
            .defaultLang().initialProperties(Material.TALL_PLANTS, MaterialColor.LIGHT_BLUE).properties(GRASS_PROPS).addLayer(() -> RenderType::getCutoutMipped)
            .item().color(() -> GRASS_COLOR_ITEM).model((ctx, provider) -> provider.generated(ctx::getEntry, TheDeadlands.getLocation("block/cold_tall_grass_top"))).build().register();

    public static final RegistryEntry<Block> COLD_DIRT = REGISTRATE.object("cold_dirt").block(Block::new).initialProperties(Material.EARTH, MaterialColor.GRAY)
            .properties(prop -> prop.hardnessAndResistance(.5f).sound(SoundType.GROUND)).defaultBlockstate().defaultLoot().simpleItem().register();
    public static final RegistryEntry<DeadGrassBlock> COLD_GRASS_BLOCK = REGISTRATE.object("cold_grass_block").block(DeadGrassBlock::new).initialProperties(Material.ORGANIC, MaterialColor.LIGHT_BLUE)
            .properties(prop -> prop.sound(SoundType.PLANT).tickRandomly().hardnessAndResistance(0.6F).sound(SoundType.PLANT))
            .loot((tables, block) -> tables.registerLootTable(block, RegistrateBlockLootTables.droppingWithSilkTouch(block, COLD_DIRT.get())))
            .color(() -> GRASS_COLOR_BLOCK).addLayer(() -> RenderType::getCutoutMipped).blockstate(NonNullBiConsumer.noop())
            .item().color(() -> GRASS_COLOR_ITEM).build().register();

    // Misc
    public static final RegistryEntry<WarpRuneBlock> WARP_RUNE = REGISTRATE.object("warp_rune").block(WarpRuneBlock::new).initialProperties(COLDSTONE).properties(AbstractBlock.Properties::notSolid)
            .addLayer(() -> RenderType::getCutoutMipped).blockstate(NonNullBiConsumer.noop()).defaultLoot().item().model(NonNullBiConsumer.noop()).build().register();
    public static final RegistryEntry<CoffinBlock> COFFIN = REGISTRATE.object("coffin").block(CoffinBlock::new).initialProperties(COLDSTONE).properties(AbstractBlock.Properties::notSolid)
            .addLayer(() -> RenderType::getCutoutMipped).blockstate(NonNullBiConsumer.noop()).defaultLoot().item().model(NonNullBiConsumer.noop()).build().register();



    public static boolean isSoil(BlockState state)
    {
        return state.getBlock() == COLD_GRASS_BLOCK.get() || state.getBlock() == COLD_DIRT.get();
    }

    private static RegistryEntry<RotatedPillarBlock> registerLog(String id, MaterialColor color)
    {
        return registerLog(id, color, id, null);
    }

    private static RegistryEntry<RotatedPillarBlock> registerLog(String id, MaterialColor color, String texture, Supplier<RotatedPillarBlock> log)
    {
        boolean onlySideTexture = !id.equals(texture);
        return REGISTRATE.object(id).block(RotatedPillarBlock::new)
                .initialProperties(Material.WOOD, color).properties(prop -> prop.hardnessAndResistance(2.0f).sound(SoundType.WOOD)).defaultLoot()
                .tag(BlockTags.LOGS).blockstate((ctx, provider) -> {
                    ResourceLocation side = TheDeadlands.getLocation("block/" + texture + "_side");
                    ResourceLocation top = onlySideTexture ? side : TheDeadlands.getLocation("block/" + texture + "_top");
                    provider.axisBlock(ctx.getEntry(), side, top);
                })
                .recipe(onlySideTexture ? (ctx, provider) -> ShapedRecipeBuilder.shapedRecipe(ctx.getEntry(), 3).patternLine("ll").patternLine("ll").key('l', log.get())
                        .addCriterion("has_log", RegistrateRecipeProvider.hasItem(log.get())).build(provider) : NonNullBiConsumer.noop())
                .item().tag(ItemTags.LOGS).build().register();
    }

    private static RegistryEntry<LeavesBlock> registerLeaves(String id, MaterialColor color, Supplier<? extends IItemProvider> sapling)
    {
        return REGISTRATE.object(id).block(LeavesBlock::new).initialProperties(Material.LEAVES, color)
                .properties(prop -> prop.setRequiresTool().hardnessAndResistance(.2f).sound(SoundType.PLANT).notSolid().setAllowsSpawn(Blocks::allowsSpawnOnLeaves).setSuffocates((state, reader, pos) -> false).setBlocksVision((state, reader, pos) -> false))
                .addLayer(() -> RenderType::getCutoutMipped).defaultBlockstate().tag(BlockTags.LEAVES)
                .loot((lootTables, block) ->
                        lootTables.registerLootTable(block, LootTable.builder()
                                .addLootPool(LootPool.builder()
                                        .rolls(new RandomValueRange(1))
                                        .addEntry(AlternativesLootEntry.builder(ItemLootEntry.builder(block)
                                                .acceptCondition(Alternative.builder(MatchTool.builder(ItemPredicate.Builder.create().tag(Tags.Items.SHEARS)))
                                                        .alternative(MatchTool.builder(ItemPredicate.Builder.create().enchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, MinMaxBounds.IntBound.atLeast(1))))))))
                                        .addEntry(ItemLootEntry.builder(sapling.get())
                                                .acceptCondition(SurvivesExplosion.builder())
                                                .acceptCondition(TableBonus.builder(Enchantments.FORTUNE, 0.05f, 0.0625f, 0.083333336f, 0.1f)))
                                ).addLootPool(LootPool.builder()
                                        .rolls(new RandomValueRange(1))
                                        .addEntry(ItemLootEntry.builder(Items.STICK)
                                                .acceptCondition(TableBonus.builder(Enchantments.FORTUNE, 0.02f, 0.022222223f, 0.025f, 0.033333335f, 0.1f))
                                                .acceptFunction(SetCount.builder(new RandomValueRange(1.0f, 2.0f))).acceptFunction(ExplosionDecay.builder()))
                                        .acceptCondition(Inverted.builder(Alternative.builder(MatchTool.builder(ItemPredicate.Builder.create().tag(Tags.Items.SHEARS)))
                                                .alternative(MatchTool.builder(ItemPredicate.Builder.create().enchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, MinMaxBounds.IntBound.atLeast(1)))))))))
                ).item().tag(ItemTags.LEAVES).build().register();
    }

    @SafeVarargs
    private static RegistryEntry<Block> registerPlanks(String id, MaterialColor color, NonNullSupplier<RotatedPillarBlock> log, NonNullSupplier<RotatedPillarBlock>... others)
    {
        return REGISTRATE.object(id).block(Block::new).initialProperties(Material.WOOD, color).tag(BlockTags.PLANKS)
                .properties(prop -> prop.hardnessAndResistance(2.0f, 3.0f).sound(SoundType.WOOD)).defaultBlockstate().defaultLoot()
                .recipe((ctx, provider) -> provider.planks(DataIngredient.items(log, others), ctx::getEntry)).item().tag(ItemTags.PLANKS).build().register();
    }

    private static RegistryEntry<DoorBlock> registerDoor(String id, NonNullSupplier<Block> planks)
    {
        return REGISTRATE.object(id).block(DoorBlock::new).initialProperties(planks).properties(prop -> prop.hardnessAndResistance(3f).notSolid())
                .addLayer(() -> RenderType::getCutoutMipped).tag(BlockTags.WOODEN_DOORS, BlockTags.DOORS)
                .recipe((ctx, provider) -> provider.door(DataIngredient.items(planks), ctx::getEntry, "wooden_door"))
                .blockstate((ctx, provider) -> provider.doorBlock(ctx.getEntry(), TheDeadlands.getLocation("block/" + id + "_bottom"), TheDeadlands.getLocation("block/" + id + "_top")))
                .loot((tables, block) -> tables.registerLootTable(block, LootTable.builder()
                        .addLootPool(LootPool.builder().rolls(new RandomValueRange(1)).addEntry(ItemLootEntry.builder(block)
                                .acceptCondition(BlockStateProperty.builder(block).fromProperties(StatePropertiesPredicate.Builder.newBuilder().withProp(DoorBlock.HALF, DoubleBlockHalf.LOWER))))
                                .acceptCondition(SurvivesExplosion.builder()))))
                .item().tag(ItemTags.WOODEN_DOORS, ItemTags.DOORS).model((ctx, provider) -> provider.generated(ctx::getEntry)).build().register();
    }

//    private static RegistryEntry<TrapDoorBlock> registerTrapdoor(String id, NonNullSupplier<Block> planks) {
//        return REGISTRATE.object(id).block(TrapDoorBlock::new).initialProperties(planks)
//                .properties(prop -> prop.hardnessAndResistance(3f).notSolid())
//                .blockstate((ctx, provider) -> provider.trapdoorBlock(ctx.getEntry(), TheDeadlands.getLocation("block/" + id), true))
//                .defaultLoot().recipe((ctx, provider) -> provider.trapDoor(DataIngredient.items(planks), ctx::getEntry, "wooden_trapdoor"))
//                .item().model((ctx, provider) -> provider.withExistingParent(ctx.getName(), TheDeadlands.getLocation("block/" + id + "_bottom"))).build().register();
//    }

    public static RegistryEntry<StairsBlock> registerStairs(String id, RegistryEntry<Block> parent, String group)
    {
        return REGISTRATE.object(id).block(prop -> new StairsBlock(() -> parent.get().getDefaultState(), prop))
                .initialProperties(parent).defaultLoot().blockstate((ctx, provider) -> provider.stairsBlock(ctx.getEntry(), provider.blockTexture(parent.get()))).tag(BlockTags.STAIRS)
                .recipe((ctx, provider) -> provider.stairs(DataIngredient.items(parent), ctx::getEntry, group, true)).item().tag(ItemTags.STAIRS).build().register();
    }

    public static RegistryEntry<SlabBlock> registerSlab(String id, RegistryEntry<Block> parent, String group)
    {
        return REGISTRATE.object(id).block(SlabBlock::new).initialProperties(parent)
                .loot((tables, block) -> tables.registerLootTable(block, LootTable.builder().addLootPool(LootPool.builder().addEntry(ItemLootEntry.builder(block)
                        .acceptFunction(SetCount.builder(new RandomValueRange(2))
                                .acceptCondition(BlockStateProperty.builder(block).fromProperties(StatePropertiesPredicate.Builder.newBuilder().withProp(SlabBlock.TYPE, SlabType.DOUBLE))))
                        .acceptCondition(SurvivesExplosion.builder())))))
                .blockstate((ctx, provider) -> provider.slabBlock(ctx.getEntry(), TheDeadlands.getLocation("block/" + parent.get().getRegistryName().getPath()), provider.blockTexture(parent.get())))
                .tag(BlockTags.STAIRS).recipe((ctx, provider) -> provider.slab(DataIngredient.items(parent), ctx::getEntry, group, true))
                .item().tag(ItemTags.STAIRS).build().register();
    }

    private static final RegistryEntry<WallBlock> registerWall(String id, RegistryEntry<Block> parent, String group)
    {
        Supplier<ResourceLocation> texture = () -> {
            ResourceLocation name = parent.get().getRegistryName();
            return new ResourceLocation(name.getNamespace(), ModelProvider.BLOCK_FOLDER + "/" + name.getPath());
        };
        return REGISTRATE.object(id).block(WallBlock::new).initialProperties(parent).defaultLoot()
                .blockstate((ctx, provider) -> provider.wallBlock(ctx.getEntry(), texture.get())).tag(BlockTags.WALLS)
                .recipe((ctx, provider) -> {
                    ShapedRecipeBuilder.shapedRecipe(ctx.getEntry(), 6).patternLine("XXX").patternLine("XXX").key('X', parent.get()).setGroup(group)
                            .addCriterion("has_" + provider.safeName(parent.get()), RegistrateRecipeProvider.hasItem(parent.get())).build(provider);
                    provider.stonecutting(DataIngredient.items(parent), ctx::getEntry);
                })
                .item().model((ctx, provider) -> provider.wallInventory(ctx.getName(), texture.get())).tag(ItemTags.WALLS).build().register();
    }

    private static RegistryEntry<PressurePlateBlock> registerPressurePlate(String id, NonNullSupplier<Block> planks, boolean stone, String group)
    {
        ITag.INamedTag<Item>[] itemTag = stone ? new ITag.INamedTag[]{} : new ITag.INamedTag[]{ItemTags.WOODEN_PRESSURE_PLATES};
        return REGISTRATE.object(id).block(prop -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, prop)).initialProperties(planks)
                .properties(prop -> prop.doesNotBlockMovement().hardnessAndResistance(5f).notSolid()).tag(BlockTags.PRESSURE_PLATES, stone ? BlockTags.STONE_PRESSURE_PLATES : BlockTags.WOODEN_PRESSURE_PLATES)
                .recipe((ctx, provider) -> ShapedRecipeBuilder.shapedRecipe(ctx.getEntry()).key('p', planks.get()).patternLine("pp").setGroup(group)
                        .addCriterion("has_planks", RegistrateRecipeProvider.hasItem(planks.get())).build(provider))
                .blockstate((ctx, provider) -> provider.getVariantBuilder(ctx.getEntry()).partialState()
                        .with(PressurePlateBlock.POWERED, false).modelForState().modelFile(provider.models().withExistingParent(ctx.getName(), "block/pressure_plate_up").texture("texture", provider.blockTexture(planks.get()))).addModel()
                        .partialState()
                        .with(PressurePlateBlock.POWERED, true).modelForState().modelFile(provider.models().withExistingParent(ctx.getName() + "_down", "block/pressure_plate_down").texture("texture", provider.blockTexture(planks.get()))).addModel())
                .item().model((ctx, provider) -> provider.withExistingParent(ctx.getName(), TheDeadlands.getLocation("block/" + id)))
                .tag(itemTag).build().register();
    }

    private static <T extends AbstractButtonBlock> RegistryEntry<T> registerButton(String id, RegistryEntry<Block> parent, NonNullFunction<AbstractBlock.Properties, T> factory, String group)
    {
        Supplier<ResourceLocation> texture = () -> {
            ResourceLocation name = parent.get().getRegistryName();
            return new ResourceLocation(name.getNamespace(), ModelProvider.BLOCK_FOLDER + "/" + name.getPath());
        };
        return REGISTRATE.object(id).block(factory).initialProperties(parent).defaultLoot().properties(prop -> prop.doesNotBlockMovement().hardnessAndResistance(.5f))
                .blockstate((ctx, provider) -> {
                    ModelFile button = provider.models().withExistingParent(ctx.getName(), new ResourceLocation("block/button")).texture("texture", texture.get());
                    ModelFile buttonPressed = provider.models().withExistingParent(ctx.getName() + "_pressed", new ResourceLocation("block/button_pressed")).texture("texture", texture.get());

                    provider.getVariantBuilder(ctx.getEntry())
                            .partialState().with(AbstractButtonBlock.FACE, AttachFace.CEILING).with(AbstractButtonBlock.HORIZONTAL_FACING, Direction.EAST)
                            .with(AbstractButtonBlock.POWERED, false).modelForState().modelFile(button).rotationY(270).rotationX(180).addModel()
                            .partialState().with(AbstractButtonBlock.FACE, AttachFace.CEILING).with(AbstractButtonBlock.HORIZONTAL_FACING, Direction.EAST)
                            .with(AbstractButtonBlock.POWERED, true).modelForState().modelFile(buttonPressed).rotationY(270).rotationX(180).addModel()

                            .partialState().with(AbstractButtonBlock.FACE, AttachFace.CEILING).with(AbstractButtonBlock.HORIZONTAL_FACING, Direction.NORTH)
                            .with(AbstractButtonBlock.POWERED, false).modelForState().modelFile(button).rotationY(180).rotationX(180).addModel()
                            .partialState().with(AbstractButtonBlock.FACE, AttachFace.CEILING).with(AbstractButtonBlock.HORIZONTAL_FACING, Direction.NORTH)
                            .with(AbstractButtonBlock.POWERED, true).modelForState().modelFile(buttonPressed).rotationY(180).rotationX(180).addModel()

                            .partialState().with(AbstractButtonBlock.FACE, AttachFace.CEILING).with(AbstractButtonBlock.HORIZONTAL_FACING, Direction.SOUTH)
                            .with(AbstractButtonBlock.POWERED, false).modelForState().modelFile(button).rotationX(180).addModel()
                            .partialState().with(AbstractButtonBlock.FACE, AttachFace.CEILING).with(AbstractButtonBlock.HORIZONTAL_FACING, Direction.SOUTH)
                            .with(AbstractButtonBlock.POWERED, true).modelForState().modelFile(buttonPressed).rotationX(180).addModel()

                            .partialState().with(AbstractButtonBlock.FACE, AttachFace.CEILING).with(AbstractButtonBlock.HORIZONTAL_FACING, Direction.WEST)
                            .with(AbstractButtonBlock.POWERED, false).modelForState().modelFile(button).rotationY(90).rotationX(180).addModel()
                            .partialState().with(AbstractButtonBlock.FACE, AttachFace.CEILING).with(AbstractButtonBlock.HORIZONTAL_FACING, Direction.WEST)
                            .with(AbstractButtonBlock.POWERED, true).modelForState().modelFile(buttonPressed).rotationY(90).rotationX(180).addModel()

                            .partialState().with(AbstractButtonBlock.FACE, AttachFace.FLOOR).with(AbstractButtonBlock.HORIZONTAL_FACING, Direction.EAST)
                            .with(AbstractButtonBlock.POWERED, false).modelForState().modelFile(button).rotationY(90).addModel()
                            .partialState().with(AbstractButtonBlock.FACE, AttachFace.FLOOR).with(AbstractButtonBlock.HORIZONTAL_FACING, Direction.EAST)
                            .with(AbstractButtonBlock.POWERED, true).modelForState().modelFile(buttonPressed).rotationY(90).addModel()

                            .partialState().with(AbstractButtonBlock.FACE, AttachFace.FLOOR).with(AbstractButtonBlock.HORIZONTAL_FACING, Direction.NORTH)
                            .with(AbstractButtonBlock.POWERED, false).modelForState().modelFile(button).addModel()
                            .partialState().with(AbstractButtonBlock.FACE, AttachFace.FLOOR).with(AbstractButtonBlock.HORIZONTAL_FACING, Direction.NORTH)
                            .with(AbstractButtonBlock.POWERED, true).modelForState().modelFile(buttonPressed).addModel()

                            .partialState().with(AbstractButtonBlock.FACE, AttachFace.FLOOR).with(AbstractButtonBlock.HORIZONTAL_FACING, Direction.SOUTH)
                            .with(AbstractButtonBlock.POWERED, false).modelForState().modelFile(button).rotationY(180).addModel()
                            .partialState().with(AbstractButtonBlock.FACE, AttachFace.FLOOR).with(AbstractButtonBlock.HORIZONTAL_FACING, Direction.SOUTH)
                            .with(AbstractButtonBlock.POWERED, true).modelForState().modelFile(buttonPressed).rotationY(180).addModel()

                            .partialState().with(AbstractButtonBlock.FACE, AttachFace.FLOOR).with(AbstractButtonBlock.HORIZONTAL_FACING, Direction.WEST)
                            .with(AbstractButtonBlock.POWERED, false).modelForState().modelFile(button).rotationY(270).addModel()
                            .partialState().with(AbstractButtonBlock.FACE, AttachFace.FLOOR).with(AbstractButtonBlock.HORIZONTAL_FACING, Direction.WEST)
                            .with(AbstractButtonBlock.POWERED, true).modelForState().modelFile(buttonPressed).rotationY(270).addModel()

                            .partialState().with(AbstractButtonBlock.FACE, AttachFace.WALL).with(AbstractButtonBlock.HORIZONTAL_FACING, Direction.EAST)
                            .with(AbstractButtonBlock.POWERED, false).modelForState().modelFile(button).rotationY(90).rotationX(90).addModel()
                            .partialState().with(AbstractButtonBlock.FACE, AttachFace.WALL).with(AbstractButtonBlock.HORIZONTAL_FACING, Direction.EAST)
                            .with(AbstractButtonBlock.POWERED, true).modelForState().modelFile(buttonPressed).rotationY(90).rotationX(90).addModel()

                            .partialState().with(AbstractButtonBlock.FACE, AttachFace.WALL).with(AbstractButtonBlock.HORIZONTAL_FACING, Direction.NORTH)
                            .with(AbstractButtonBlock.POWERED, false).modelForState().modelFile(button).rotationX(90).addModel()
                            .partialState().with(AbstractButtonBlock.FACE, AttachFace.WALL).with(AbstractButtonBlock.HORIZONTAL_FACING, Direction.NORTH)
                            .with(AbstractButtonBlock.POWERED, true).modelForState().modelFile(buttonPressed).rotationX(90).addModel()

                            .partialState().with(AbstractButtonBlock.FACE, AttachFace.WALL).with(AbstractButtonBlock.HORIZONTAL_FACING, Direction.SOUTH)
                            .with(AbstractButtonBlock.POWERED, false).modelForState().modelFile(button).rotationY(180).rotationX(90).addModel()
                            .partialState().with(AbstractButtonBlock.FACE, AttachFace.WALL).with(AbstractButtonBlock.HORIZONTAL_FACING, Direction.SOUTH)
                            .with(AbstractButtonBlock.POWERED, true).modelForState().modelFile(buttonPressed).rotationY(180).rotationX(90).addModel()

                            .partialState().with(AbstractButtonBlock.FACE, AttachFace.WALL).with(AbstractButtonBlock.HORIZONTAL_FACING, Direction.WEST)
                            .with(AbstractButtonBlock.POWERED, false).modelForState().modelFile(button).rotationY(270).rotationX(90).addModel()
                            .partialState().with(AbstractButtonBlock.FACE, AttachFace.WALL).with(AbstractButtonBlock.HORIZONTAL_FACING, Direction.WEST)
                            .with(AbstractButtonBlock.POWERED, true).modelForState().modelFile(buttonPressed).rotationY(270).rotationX(90).addModel();
                }).tag(BlockTags.BUTTONS).recipe((ctx, provider) -> ShapelessRecipeBuilder.shapelessRecipe(ctx.getEntry()).addIngredient(parent.get()).setGroup(group)
                        .addCriterion("has_stone", RegistrateRecipeProvider.hasItem(parent.get())).build(provider))
                .item().tag(ItemTags.BUTTONS).model((ctx, provider) -> provider.withExistingParent(ctx.getName(), new ResourceLocation("block/button_inventory")).texture("texture", texture.get())).build().register();
    }

    public static void load()
    {
        LOGGER.info("Loaded");
    }
}
