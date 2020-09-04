package coffeecatrailway.tdeadlands.integration.jei;

import coffeecatrailway.tdeadlands.TheDeadlands;
import coffeecatrailway.tdeadlands.registry.DeadBlocks;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.VanillaRecipeCategoryUid;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

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
    public void registerRecipeCatalysts(IRecipeCatalystRegistration reg)
    {
        reg.addRecipeCatalyst(new ItemStack(DeadBlocks.DEAD_WOOD_CRAFTING_TABLE.get()), VanillaRecipeCategoryUid.CRAFTING);
    }
}
