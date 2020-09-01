package coffeecatrailway.tdeadlands.integration;

import coffeecatrailway.tdeadlands.TheDeadlands;
import com.tterrag.registrate.providers.RegistrateTagsProvider;
import com.tterrag.registrate.util.nullness.NonNullConsumer;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ITag;
import net.minecraft.tags.ItemTags;
import net.minecraftforge.common.Tags;

/**
 * @author CoffeeCatRailway
 * Created: 1/09/2020
 */
public class DeadTags {

    public static class Blocks implements NonNullConsumer<RegistrateTagsProvider<Block>> {

        public static final ITag.INamedTag<Block> RAT_SEARCH = BlockTags.createOptional(TheDeadlands.getLocation("rat_search"));

        @Override
        public void accept(RegistrateTagsProvider<Block> provider) {
            provider.getOrCreateBuilder(RAT_SEARCH);//.addTag(Tags.Blocks.CHESTS);
        }
    }

    public static class Items implements NonNullConsumer<RegistrateTagsProvider<Item>> {

        public static final ITag.INamedTag<Item> RAT_IGNORE = ItemTags.createOptional(TheDeadlands.getLocation("rat_ignore"));

        @Override
        public void accept(RegistrateTagsProvider<Item> provider) {
            provider.getOrCreateBuilder(RAT_IGNORE).add(net.minecraft.item.Items.ROTTEN_FLESH, net.minecraft.item.Items.SPIDER_EYE, net.minecraft.item.Items.PUFFERFISH);
        }
    }
}
