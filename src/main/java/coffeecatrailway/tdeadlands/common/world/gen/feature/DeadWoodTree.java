package coffeecatrailway.tdeadlands.common.world.gen.feature;

import coffeecatrailway.tdeadlands.registry.DeadFeatures;
import net.minecraft.block.trees.BigTree;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;

import javax.annotation.Nullable;
import java.util.Random;

/**
 * @author CoffeeCatRailway
 * Created: 15/10/2020
 */
public class DeadWoodTree extends BigTree
{
    @Nullable
    @Override
    protected ConfiguredFeature<BaseTreeFeatureConfig, ?> getTreeFeature(Random random, boolean largeHive)
    {
        return DeadFeatures.DEAD_WOOD_TREE.get();
    }

    @Nullable
    @Override
    protected ConfiguredFeature<BaseTreeFeatureConfig, ?> getHugeTreeFeature(Random rand)
    {
        return DeadFeatures.MEGA_DEAD_WOOD_TREE.get();
    }
}
