package coffeecatrailway.tdeadlands.registry;

import coffeecatrailway.tdeadlands.TheDeadlands;
import coffeecatrailway.tdeadlands.common.world.gen.feature.DeadWoodTreeFeature;
import com.google.common.collect.ImmutableList;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.foliageplacer.MegaPineFoliagePlacer;
import net.minecraft.world.gen.foliageplacer.SpruceFoliagePlacer;
import net.minecraft.world.gen.treedecorator.AlterGroundTreeDecorator;
import net.minecraft.world.gen.trunkplacer.GiantTrunkPlacer;
import net.minecraft.world.gen.trunkplacer.StraightTrunkPlacer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import org.apache.logging.log4j.Logger;

import java.util.function.Supplier;

/**
 * @author CoffeeCatRailway
 * Created: 21/09/2020
 */
public class DeadFeatures
{
    private static final Supplier<SimpleBlockStateProvider> COLD_GRASS_BLOCK_STATE = () -> new SimpleBlockStateProvider(DeadBlocks.COLD_GRASS_BLOCK.get().getDefaultState());

    private static final Supplier<SimpleBlockStateProvider> DEAD_LEAVES_STATE = () -> new SimpleBlockStateProvider(DeadBlocks.DEAD_LEAVES.get().getDefaultState());
    private static final Supplier<SimpleBlockStateProvider> DEAD_LOGS_STATE = () -> new SimpleBlockStateProvider(DeadBlocks.DEAD_LOG.get().getDefaultState());

    public static final Supplier<ConfiguredFeature<BaseTreeFeatureConfig, ?>> DEAD_WOOD_TREE = () -> DeadWorldGen.TREE.get()
            .withConfiguration(new BaseTreeFeatureConfig.Builder(DEAD_LOGS_STATE.get(), DEAD_LEAVES_STATE.get(),
                    new SpruceFoliagePlacer(FeatureSpread.func_242253_a(3, 1), FeatureSpread.func_242252_a(0), FeatureSpread.func_242253_a(3, 1)),
                    new StraightTrunkPlacer(10, 3, 0), new TwoLayerFeature(1, 0, 1)).setIgnoreVines().build());
    public static final Supplier<ConfiguredFeature<BaseTreeFeatureConfig, ?>> MEGA_DEAD_WOOD_TREE = () -> DeadWorldGen.TREE.get()
            .withConfiguration(new BaseTreeFeatureConfig.Builder(DEAD_LOGS_STATE.get(), DEAD_LEAVES_STATE.get(),
                    new MegaPineFoliagePlacer(FeatureSpread.func_242252_a(0), FeatureSpread.func_242252_a(0), FeatureSpread.func_242253_a(15, 3)),
                    new GiantTrunkPlacer(20, 3, 0), new TwoLayerFeature(1, 1, 2))
                    .func_236703_a_(ImmutableList.of(new AlterGroundTreeDecorator(COLD_GRASS_BLOCK_STATE.get()))).setIgnoreVines().build());
}
