package coffeecatrailway.tdeadlands;

import coffeecatrailway.tdeadlands.integration.registrate.DeadBlockstates;
import coffeecatrailway.tdeadlands.integration.registrate.DeadLangs;
import coffeecatrailway.tdeadlands.integration.registrate.DeadRegistrate;
import coffeecatrailway.tdeadlands.integration.registrate.DeadTags;
import coffeecatrailway.tdeadlands.registry.*;
import com.tterrag.registrate.providers.ProviderType;
import net.minecraft.block.ComposterBlock;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.commons.lang3.tuple.Pair;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(TheDeadlands.MOD_ID)
public class TheDeadlands
{
    public static final String MOD_ID = "tdeadlands";
    private static final Logger LOGGER = getLogger("");

    public static final ItemGroup GROUP_ALL = new ItemGroup(MOD_ID)
    {
        @Override
        public ItemStack createIcon()
        {
            return new ItemStack(DeadBlocks.COLD_GRASS_BLOCK.get());
        }
    };

    public static DeadConfig.Client CLIENT_CONFIG;
    public static DeadConfig.Server SERVER_CONFIG;

    public static DeadRegistrate REGISTRATE;

    public TheDeadlands()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::setupClient);
        modEventBus.addListener(this::setupCommon);

        final Pair<DeadConfig.Client, ForgeConfigSpec> client = new ForgeConfigSpec.Builder().configure(DeadConfig.Client::new);
        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, client.getRight());
        CLIENT_CONFIG = client.getLeft();

        final Pair<DeadConfig.Server, ForgeConfigSpec> server = new ForgeConfigSpec.Builder().configure(DeadConfig.Server::new);
        ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, server.getRight());
        SERVER_CONFIG = server.getLeft();
        LOGGER.info("Register configs");

        REGISTRATE = DeadRegistrate.create(MOD_ID).itemGroup(() -> GROUP_ALL, "The Deadlands")
                .addDataGenerator(ProviderType.BLOCK_TAGS, new DeadTags.Blocks())
                .addDataGenerator(ProviderType.ITEM_TAGS, new DeadTags.Items())
                .addDataGenerator(ProviderType.LANG, new DeadLangs())
                .addDataGenerator(ProviderType.BLOCKSTATE, new DeadBlockstates());

        MinecraftForge.EVENT_BUS.register(this);

        DeadBlocks.load();
        DeadItems.load();
        DeadContainers.load(modEventBus);
        DeadTileEntities.load();
        DeadEntities.load();
        DeadSounds.load();
        DeadWorldGen.load(modEventBus);
    }

    @OnlyIn(Dist.CLIENT)
    public void setupClient(FMLClientSetupEvent event)
    {
        ClientEvents.itemColors();
        ClientEvents.entityRenderers();

        DeadItemModelProperties.load();
    }

    public void setupCommon(FMLCommonSetupEvent event)
    {
        registerCompostable(.3f, DeadBlocks.DEAD_LEAVES.get());
        registerCompostable(.65f, DeadItems.COLD_GRASS_STRAND.get());
        DeadEntities.ATTRIBUTE_MAPS.forEach(Runnable::run);
    }

    private static void registerCompostable(float chance, IItemProvider itemProvider)
    {
        ComposterBlock.CHANCES.put(itemProvider.asItem(), chance);
    }

    public static ResourceLocation getLocation(String path)
    {
        return new ResourceLocation(MOD_ID, path);
    }

    public static Logger getLogger(String name)
    {
        return LogManager.getLogger(MOD_ID + name);
    }
}
