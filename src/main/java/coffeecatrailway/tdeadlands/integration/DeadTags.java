package coffeecatrailway.tdeadlands.integration;

import coffeecatrailway.tdeadlands.TheDeadlands;
import com.tterrag.registrate.providers.RegistrateTagsProvider;
import com.tterrag.registrate.util.nullness.NonNullConsumer;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ITag;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.Tags;

/**
 * @author CoffeeCatRailway
 * Created: 1/09/2020
 */
public class DeadTags
{
    public static class Blocks implements NonNullConsumer<RegistrateTagsProvider<Block>>
    {
        public static final ITag.INamedTag<Block> RAT_SEARCH = tag("rat_search");

        public static final ITag.INamedTag<Block> COLDSTONE = tag("coldstone");

        public static final ITag.INamedTag<Block> ORES_COPPER = tagForge("ores/copper");

        @Override
        public void accept(RegistrateTagsProvider<Block> provider)
        {
            provider.getOrCreateBuilder(COLDSTONE);

            provider.getOrCreateBuilder(Tags.Blocks.ORES).addTag(ORES_COPPER);
        }

        private static ITag.INamedTag<Block> tag(String id)
        {
            return BlockTags.createOptional(TheDeadlands.getLocation(id));
        }

        private static ITag.INamedTag<Block> tagForge(String id)
        {
            return BlockTags.createOptional(new ResourceLocation("forge", id));
        }
    }

    public static class Items implements NonNullConsumer<RegistrateTagsProvider<Item>>
    {
        public static final ITag.INamedTag<Item> RAT_IGNORE = tag("rat_ignore");

        public static final ITag.INamedTag<Item> COLDSTONE = tag("coldstone");

        public static final ITag.INamedTag<Item> ORES_COPPER = tagForge("ores/copper");

        @Override
        public void accept(RegistrateTagsProvider<Item> provider)
        {
            provider.getOrCreateBuilder(RAT_IGNORE).add(net.minecraft.item.Items.ROTTEN_FLESH, net.minecraft.item.Items.SPIDER_EYE, net.minecraft.item.Items.PUFFERFISH);

            provider.getOrCreateBuilder(COLDSTONE);

            provider.getOrCreateBuilder(Tags.Items.ORES).addTag(ORES_COPPER);
        }

        private static ITag.INamedTag<Item> tag(String id)
        {
            return ItemTags.createOptional(TheDeadlands.getLocation(id));
        }

        private static ITag.INamedTag<Item> tagForge(String id)
        {
            return ItemTags.createOptional(new ResourceLocation("forge", id));
        }
    }
}
