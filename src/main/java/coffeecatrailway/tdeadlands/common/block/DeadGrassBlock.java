package coffeecatrailway.tdeadlands.common.block;

import coffeecatrailway.tdeadlands.registry.DeadBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.IGrowable;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.lighting.LightEngine;
import net.minecraft.world.server.ServerWorld;

import java.util.Random;

/**
 * @author CoffeeCatRailway
 * Created: 22/08/2020
 */
public class DeadGrassBlock extends Block implements IGrowable
{
    public DeadGrassBlock(Properties properties)
    {
        super(properties);
    }

    @Override
    public boolean canGrow(IBlockReader world, BlockPos pos, BlockState state, boolean isClient)
    {
        return world.getBlockState(pos.up()).isAir(world, pos);
    }

    @Override
    public boolean canUseBonemeal(World world, Random rand, BlockPos pos, BlockState state)
    {
        return true;
    }

    @Override
    public void grow(ServerWorld world, Random rand, BlockPos pos, BlockState state)
    {
        BlockPos blockpos = pos.up();
        BlockState blockstate = Blocks.GRASS.getDefaultState();

        label48:
        for (int i = 0; i < 128; ++i)
        {
            BlockPos blockpos1 = blockpos;

            for (int j = 0; j < i / 16; ++j)
            {
                blockpos1 = blockpos1.add(rand.nextInt(3) - 1, (rand.nextInt(3) - 1) * rand.nextInt(3) / 2, rand.nextInt(3) - 1);
                if (!world.getBlockState(blockpos1.down()).isIn(this) || world.getBlockState(blockpos1).hasOpaqueCollisionShape(world, blockpos1))
                    continue label48;
            }

            BlockState blockstate2 = world.getBlockState(blockpos1);
            if (blockstate2.isIn(blockstate.getBlock()) && rand.nextInt(10) == 0)
                ((IGrowable) blockstate.getBlock()).grow(world, rand, blockpos1, blockstate2);

            if (blockstate2.isAir())
            {
                BlockState blockstate1;
                if (rand.nextInt(8) == 0)
                {
//                    List<ConfiguredFeature<?, ?>> list = world.getBiome(blockpos1).func_242440_e().func_242496_b();
//                    if (list.isEmpty())
//                        continue;

//                    ConfiguredFeature<?, ?> configuredfeature = list.get(0);
//                    FlowersFeature flowersfeature = (FlowersFeature) configuredfeature.feature;
//                    blockstate1 = flowersfeature.getFlowerToPlace(rand, blockpos1, configuredfeature.func_242767_c());
                } else
                    blockstate1 = blockstate;

//                if (blockstate1.isValidPosition(world, blockpos1))
//                    world.setBlockState(blockpos1, blockstate1, 3);
            }
        }
    }

    private static boolean hasLight(BlockState state, IWorldReader world, BlockPos pos)
    {
        BlockPos blockpos = pos.up();
        BlockState blockstate = world.getBlockState(blockpos);
        int i = LightEngine.func_215613_a(world, state, pos, blockstate, blockpos, Direction.UP, blockstate.getOpacity(world, blockpos));
        return i < world.getMaxLightLevel();
    }

    private static boolean canSpread(BlockState state, IWorldReader world, BlockPos pos)
    {
        BlockPos blockpos = pos.up();
        return hasLight(state, world, pos) && !world.getFluidState(blockpos).isTagged(FluidTags.WATER);
    }

    @Override
    public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random random)
    {
        if (!worldIn.isRemote)
        {
            if (!worldIn.isAreaLoaded(pos, 3))
                return; // Forge: prevent loading unloaded chunks when checking neighbor's light and spreading
            if (!hasLight(state, worldIn, pos))
            {
                worldIn.setBlockState(pos, DeadBlocks.DIRT.get().getDefaultState());
            } else
            {
                if (worldIn.getLight(pos.up()) >= 9)
                {
                    BlockState blockstate = this.getDefaultState();

                    for (int i = 0; i < 4; ++i)
                    {
                        BlockPos blockpos = pos.add(random.nextInt(3) - 1, random.nextInt(5) - 3, random.nextInt(3) - 1);
                        if (worldIn.getBlockState(blockpos).getBlock() == DeadBlocks.DIRT.get() && canSpread(blockstate, worldIn, blockpos))
                            worldIn.setBlockState(blockpos, blockstate);
                    }
                }
            }
        }
    }
}
