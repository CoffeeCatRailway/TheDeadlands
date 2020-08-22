package coffeecatrailway.tdeadlands.registry;

import coffeecatrailway.tdeadlands.TheDeadlands;
import coffeecatrailway.tdeadlands.common.block.DeadWoodCraftingTableBlock;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.DyeColor;
import net.minecraft.item.Item;
import net.minecraft.util.Direction;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import org.apache.logging.log4j.Logger;

import java.util.function.Supplier;

/**
 * @author CoffeeCatRailway
 * Created: 21/08/2020
 */
public class DeadBlocks {

    private static final Logger LOGGER = TheDeadlands.getLogger("Blocks");
    protected static final DeferredRegister<Block> REGISTER = DeferredRegister.create(ForgeRegistries.BLOCKS, TheDeadlands.MOD_ID);

    public static final RegistryObject<Block> COPPER_ORE = register("copper_ore", () -> new Block(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.BLACK).setRequiresTool().hardnessAndResistance(3f, 3f)));

    public static final RegistryObject<Block> FROST_METAL_ORE = register("frost_metal_ore", () -> new Block(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.BLACK).setRequiresTool().hardnessAndResistance(3f, 3f)));

    public static final RegistryObject<Block> HEATSTONE_ORE = register("heatstone_ore", () -> new Block(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.BLACK).setRequiresTool().hardnessAndResistance(3f, 3f)));
    public static final RegistryObject<Block> HEATSTONE_BLOCK = register("heatstone_block", () -> new Block(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.RED).setRequiresTool().hardnessAndResistance(1.5f, 6f).sound(SoundType.METAL)));

    public static final RegistryObject<Block> COLD_BRONZE_BLOCK = register("cold_bronze_block", () -> new Block(AbstractBlock.Properties.create(Material.IRON, MaterialColor.ORANGE_TERRACOTTA).setRequiresTool().hardnessAndResistance(5f, 6f).sound(SoundType.METAL)));

    public static final RegistryObject<Block> COLDSTONE = register("coldstone", () -> new Block(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.BLACK).setRequiresTool().hardnessAndResistance(1.5f, 6f)));
    public static final RegistryObject<Block> COLDSTONE_BRICKS = register("coldstone_bricks", () -> new Block(AbstractBlock.Properties.from(COLDSTONE.get()).setRequiresTool().hardnessAndResistance(1.5f, 6f)));
    public static final RegistryObject<Block> CRACKED_COLDSTONE_BRICKS = register("cracked_coldstone_bricks", () -> new Block(AbstractBlock.Properties.from(COLDSTONE.get()).setRequiresTool().hardnessAndResistance(1.5f, 6f)));
    public static final RegistryObject<Block> MOSSY_COLDSTONE_BRICKS = register("mossy_coldstone_bricks", () -> new Block(AbstractBlock.Properties.from(COLDSTONE.get()).setRequiresTool().hardnessAndResistance(1.5f, 6f)));
    public static final RegistryObject<Block> CHISELED_COLDSTONE_BRICKS = register("chiseled_coldstone_bricks", () -> new Block(AbstractBlock.Properties.from(COLDSTONE.get()).setRequiresTool().hardnessAndResistance(1.5f, 6f)));

    public static final RegistryObject<RotatedPillarBlock> DEAD_LOG = register("dead_wood_log", () -> new RotatedPillarBlock(AbstractBlock.Properties.create(Material.WOOD, state -> state.get(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? MaterialColor.LIGHT_GRAY : MaterialColor.GRAY).setRequiresTool().hardnessAndResistance(2f).sound(SoundType.WOOD)));
    public static final RegistryObject<RotatedPillarBlock> STRIPPED_DEAD_LOG = register("stripped_dead_wood_log", () -> new RotatedPillarBlock(AbstractBlock.Properties.create(Material.WOOD, state -> state.get(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? MaterialColor.LIGHT_GRAY : MaterialColor.GRAY).setRequiresTool().hardnessAndResistance(2f).sound(SoundType.WOOD)));
    public static final RegistryObject<RotatedPillarBlock> DEAD_WOOD = register("dead_wood", () -> new RotatedPillarBlock(AbstractBlock.Properties.create(Material.WOOD, state -> state.get(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? MaterialColor.LIGHT_GRAY : MaterialColor.GRAY).setRequiresTool().hardnessAndResistance(2f).sound(SoundType.WOOD)));
    public static final RegistryObject<RotatedPillarBlock> STRIPPED_DEAD_WOOD = register("stripped_dead_wood", () -> new RotatedPillarBlock(AbstractBlock.Properties.create(Material.WOOD, state -> state.get(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? MaterialColor.LIGHT_GRAY : MaterialColor.GRAY).setRequiresTool().hardnessAndResistance(2f).sound(SoundType.WOOD)));
    public static final RegistryObject<LeavesBlock> DEAD_LEAVES = register("dead_leaves", () -> new LeavesBlock(AbstractBlock.Properties.create(Material.LEAVES).setRequiresTool().hardnessAndResistance(.2f).sound(SoundType.PLANT).notSolid().setAllowsSpawn(Blocks::allowsSpawnOnLeaves).setSuffocates((state, reader, pos) -> false).setBlocksVision((state, reader, pos) -> false)));
    public static final RegistryObject<Block> DEAD_PLANKS = register("dead_wood_planks", () -> new Block(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.LIGHT_GRAY).hardnessAndResistance(2f, 3f).sound(SoundType.WOOD)));

    // dead_wood_door
    // dead_wood_trapdoor
    // dead_wood_button
    // dead_wood_pressure_plate
    public static final RegistryObject<DeadWoodCraftingTableBlock> DEAD_WOOD_CRAFTING_TABLE = register("dead_wood_crafting_table", () -> new DeadWoodCraftingTableBlock(AbstractBlock.Properties.create(Material.WOOD, DyeColor.GRAY).hardnessAndResistance(2.5F).sound(SoundType.WOOD)));

    private static <B extends Block> RegistryObject<B> register(String id, Supplier<B> block) {
        return register(id, block, null);
    }

    private static <B extends Block> RegistryObject<B> register(String id, Supplier<B> block, BlockItem item) {
        RegistryObject<B> blockObj = REGISTER.register(id, block);
        DeadItems.REGISTER.register(id, () -> item == null ? new BlockItem(blockObj.get(), new Item.Properties().group(TheDeadlands.GROUP_ALL)) : item);
        return blockObj;
    }

    public static void load(IEventBus bus) {
        LOGGER.info("Blocks loaded");
        REGISTER.register(bus);
    }
}
