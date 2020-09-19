package coffeecatrailway.tdeadlands.integration;

import coffeecatrailway.tdeadlands.registry.DeadBlocks;
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
public class VanillaCompatability
{
    public static void register()
    {
        registerStrippable(DeadBlocks.DEAD_LOG.get(), DeadBlocks.STRIPPED_DEAD_LOG.get());
        registerStrippable(DeadBlocks.DEAD_WOOD.get(), DeadBlocks.STRIPPED_DEAD_WOOD.get());

        registerFlammable(DeadBlocks.DEAD_LEAVES.get(), 30, 60);
        registerFlammable(DeadBlocks.DEAD_LOG.get(), 5, 5);
        registerFlammable(DeadBlocks.STRIPPED_DEAD_LOG.get(), 5, 5);
        registerFlammable(DeadBlocks.DEAD_WOOD.get(), 5, 5);
        registerFlammable(DeadBlocks.STRIPPED_DEAD_WOOD.get(), 5, 5);
        registerFlammable(DeadBlocks.DEAD_PLANKS.get(), 5, 20);

        registerCompostable(0.3F, DeadBlocks.DEAD_LEAVES.get());
    }

    private static void registerStrippable(Block log, Block strippedLog)
    {
        AxeItem.BLOCK_STRIPPING_MAP = Maps.newHashMap(AxeItem.BLOCK_STRIPPING_MAP);
        AxeItem.BLOCK_STRIPPING_MAP.put(log, strippedLog);
    }

    private static void registerCompostable(float chance, IItemProvider itemProvider)
    {
        ComposterBlock.CHANCES.put(itemProvider.asItem(), chance);
    }

    private static void registerFlammable(Block block, int encouragement, int flammability)
    {
        FireBlock fireblock = (FireBlock) Blocks.FIRE;
        fireblock.setFireInfo(block, encouragement, flammability);
    }
}
