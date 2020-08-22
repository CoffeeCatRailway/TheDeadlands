package coffeecatrailway.tdeadlands;

import coffeecatrailway.tdeadlands.integration.VanillaCompatability;
import coffeecatrailway.tdeadlands.registry.DeadBlocks;
import coffeecatrailway.tdeadlands.registry.DeadContainers;
import coffeecatrailway.tdeadlands.registry.DeadItems;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(TheDeadlands.MOD_ID)
public class TheDeadlands {

    public static final String MOD_ID = "tdeadlands";
    private static final Logger LOGGER = getLogger("");

    public static final ItemGroup GROUP_ALL = new ItemGroup(MOD_ID) {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(DeadBlocks.COLDSTONE.get());
        }
    };

//    public static DeadConfig.Client CLIENT_CONFIG;
//    public static DeadConfig.Server SERVER_CONFIG;

    public TheDeadlands() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::setupClient);
        modEventBus.addListener(this::setupCommon);

//        final Pair<DeadConfig.Client, ForgeConfigSpec> client = new ForgeConfigSpec.Builder().configure(DeadConfig.Client::new);
//        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, client.getRight());
//        CLIENT_CONFIG = client.getLeft();
//
//        final Pair<DeadConfig.Server, ForgeConfigSpec> server = new ForgeConfigSpec.Builder().configure(DeadConfig.Server::new);
//        ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, server.getRight());
//        SERVER_CONFIG = server.getLeft();
//        LOGGER.info("Register configs");

        MinecraftForge.EVENT_BUS.register(this);

        DeadBlocks.load(modEventBus);
        DeadItems.load(modEventBus);
        DeadContainers.load(modEventBus);
//        DeadFluids.load();
//        DeadTileEntities.load();
//        DeadEntities.load();
    }

    @OnlyIn(Dist.CLIENT)
//        DistExecutor.safeRunWhenOn(Dist.CLIENT, () -> ClientEvents::itemColors);
//        DistExecutor.safeRunWhenOn(Dist.CLIENT, () -> ClientEvents::renderLayers);
    public void setupClient(FMLClientSetupEvent event) {
        DistExecutor.safeRunWhenOn(Dist.CLIENT, () -> ClientEvents::renderLayers);
//        DistExecutor.safeRunWhenOn(Dist.CLIENT, () -> ClientEvents::containerScreens);
//        DistExecutor.safeRunWhenOn(Dist.CLIENT, () -> ClientEvents::particleFactories);
//        DistExecutor.safeRunWhenOn(Dist.CLIENT, () -> ClientEvents::entityRenderers);
//        DistExecutor.safeRunWhenOn(Dist.CLIENT, () -> ClientEvents::tileEntityRenderers);
        LOGGER.info("Client events");
    }

    public void setupCommon(FMLCommonSetupEvent event) {
        VanillaCompatability.register();
    }

    public static ResourceLocation getLocation(String path) {
        return new ResourceLocation(MOD_ID, path);
    }

    public static Logger getLogger(String name) {
        return LogManager.getLogger(MOD_ID + name);
    }
}
