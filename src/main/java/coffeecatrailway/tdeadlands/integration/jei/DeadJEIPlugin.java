package coffeecatrailway.tdeadlands.integration.jei;

import coffeecatrailway.tdeadlands.TheDeadlands;
import coffeecatrailway.tdeadlands.integration.registrate.DeadTags;
import coffeecatrailway.tdeadlands.registry.DeadBlocks;
import coffeecatrailway.tdeadlands.registry.DeadItems;
import com.google.common.collect.Lists;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.VanillaRecipeCategoryUid;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import java.util.List;

/**
 * @author CoffeeCatRailway
 * Created: 21/08/2020
 */
@JeiPlugin
public class DeadJEIPlugin implements IModPlugin
{
    private static final ResourceLocation UID = TheDeadlands.getLocation("plugin/main");

    @Override
    public ResourceLocation getPluginUid()
    {
        return UID;
    }

    @Override
    public void registerRecipes(IRecipeRegistration reg)
    {
        StringBuilder builder = new StringBuilder();
        List<Block> convertBlocks = DeadTags.Blocks.FROST_BRONZE_CONVERT.getAllElements();
        int count = convertBlocks.size() - 1;
        for (int i = 0; i < count; i++)
        {
            builder.append(convertBlocks.get(i).getTranslatedName().getString()).append(i < count - 1 ? ", " : "");
        }
        builder.append(" or ").append(convertBlocks.get(count).getTranslatedName().getString());
        List<ItemStack> ingotStacks = Lists.newArrayList(new ItemStack(DeadItems.FROST_COPPER_CLUMP.get()), new ItemStack(DeadItems.FROST_BRONZE_INGOT.get()));
        reg.addIngredientInfo(ingotStacks, VanillaTypes.ITEM,
                "A " + ingotStacks.get(1).getDisplayName().getString() + " can be made by throwing a " + ingotStacks.get(0).getDisplayName().getString() +
                        " into " + builder.toString() + ".",
                "You will get the same amount back that you through in.");
    }

    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration reg)
    {
        reg.addRecipeCatalyst(new ItemStack(DeadBlocks.DEAD_WOOD_CRAFTING_TABLE.get()), VanillaRecipeCategoryUid.CRAFTING);
        reg.addRecipeCatalyst(new ItemStack(DeadItems.FROST_BRONZE_INGOT.get()), VanillaRecipeCategoryUid.INFORMATION);
        reg.addRecipeCatalyst(new ItemStack(DeadItems.FROST_COPPER_CLUMP.get()), VanillaRecipeCategoryUid.INFORMATION);
    }
}
