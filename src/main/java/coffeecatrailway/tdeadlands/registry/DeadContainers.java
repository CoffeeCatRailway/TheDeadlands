package coffeecatrailway.tdeadlands.registry;

import coffeecatrailway.tdeadlands.TheDeadlands;
import coffeecatrailway.tdeadlands.common.inventory.container.DeadWoodWorkbenchContainer;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import org.apache.logging.log4j.Logger;

/**
 * @author CoffeeCatRailway
 * Created: 21/08/2020
 */
public class DeadContainers
{
    private static final Logger LOGGER = TheDeadlands.getLogger("Containers");
    protected static final DeferredRegister<ContainerType<?>> REGISTER = DeferredRegister.create(ForgeRegistries.CONTAINERS, TheDeadlands.MOD_ID);

    public static final RegistryObject<ContainerType<DeadWoodWorkbenchContainer>> DEAD_WOOD_WORKBENCH = register("dead_wood_workbench", DeadWoodWorkbenchContainer::new);

    private static <T extends Container> RegistryObject<ContainerType<T>> register(String id, ContainerType.IFactory<T> factory)
    {
        return REGISTER.register(id, () -> new ContainerType<>(factory));
    }

    public static void load(IEventBus bus)
    {
        LOGGER.info("Containers loaded");
        REGISTER.register(bus);
    }
}
