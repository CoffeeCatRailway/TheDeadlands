package coffeecatrailway.tdeadlands.integration;

import com.google.common.collect.Maps;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.ComposterBlock;
import net.minecraft.block.FireBlock;
import net.minecraft.item.AxeItem;
import net.minecraft.item.HoeItem;
import net.minecraft.util.IItemProvider;

/**
 * @author CoffeeCatRailway
 * Created: 20/08/2020
 */
public class VanillaCompatability {

    public static void register() {

    }

    private static void registerStrippable(Block log, Block strippedLog) {
        AxeItem.BLOCK_STRIPPING_MAP = Maps.newHashMap(AxeItem.BLOCK_STRIPPING_MAP);
        AxeItem.BLOCK_STRIPPING_MAP.put(log, strippedLog);
    }

    private static void registerHoeable(Block block) {
        HoeItem.HOE_LOOKUP = Maps.newHashMap(HoeItem.HOE_LOOKUP);
        HoeItem.HOE_LOOKUP.put(block, Blocks.FARMLAND.getDefaultState());
    }

    private static void registerHoeable(Block hoeable, Block hoed) {
        HoeItem.HOE_LOOKUP = Maps.newHashMap(HoeItem.HOE_LOOKUP);
        HoeItem.HOE_LOOKUP.put(hoeable, hoed.getDefaultState());
    }

    private static void registerCompostable(float chance, IItemProvider itemProvider) {
        ComposterBlock.CHANCES.put(itemProvider.asItem(), chance);
    }

    private static void registerFlammable(Block block, int encouragement, int flammability) {
        FireBlock fireblock = (FireBlock) Blocks.FIRE;
        fireblock.setFireInfo(block, encouragement, flammability);
    }
}
