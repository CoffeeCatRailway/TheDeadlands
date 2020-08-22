package coffeecatrailway.tdeadlands.registry;

import coffeecatrailway.tdeadlands.TheDeadlands;
import coffeecatrailway.tdeadlands.common.block.DeadWoodCraftingTableBlock;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
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

    public static final RegistryObject<Block> COLD_BRONZE_BLOCK = register("cold_bronze_block", () -> new Block(AbstractBlock.Properties.create(Material.IRON, MaterialColor.ORANGE_TERRACOTTA).setRequiresTool().hardnessAndResistance(5f, 6f).sound(SoundType.METAL)));

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
