package coffeecatrailway.tdeadlands.registry;

import coffeecatrailway.tdeadlands.TheDeadlands;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import org.apache.logging.log4j.Logger;

/**
 * @author CoffeeCatRailway
 * Created: 21/08/2020
 */
public class DeadItems {

    private static final Logger LOGGER = TheDeadlands.getLogger("Items");
    protected static final DeferredRegister<Item> REGISTER = DeferredRegister.create(ForgeRegistries.ITEMS, TheDeadlands.MOD_ID);

    public static void load(IEventBus bus) {
        LOGGER.info("Items loaded");
        REGISTER.register(bus);
    }
}
