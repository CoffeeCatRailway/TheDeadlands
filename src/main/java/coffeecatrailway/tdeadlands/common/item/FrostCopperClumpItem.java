package coffeecatrailway.tdeadlands.common.item;

import coffeecatrailway.tdeadlands.integration.registrate.DeadTags;
import coffeecatrailway.tdeadlands.registry.DeadItems;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import java.util.Random;

/**
 * @author CoffeeCatRailway
 * Created: 6/09/2020
 */
public class FrostCopperClumpItem extends Item
{

    public FrostCopperClumpItem(Properties properties)
    {
        super(properties);
    }

    @Override
    public boolean onEntityItemUpdate(ItemStack stack, ItemEntity entity)
    {
        World world = entity.world;
        if (DeadTags.Blocks.FROST_BRONZE_CONVERT.contains(world.getBlockState(entity.getPosition()).getBlock()))
        {
            if (stack.getItem() == this)
            {
                entity.setItem(new ItemStack(DeadItems.FROST_BRONZE_INGOT.get(), stack.getCount()));
                if (!world.isRemote)
                {
                    Random rand = world.rand;
                    ServerWorld serverWorld = (ServerWorld) world;
                    float xs = rand.nextFloat() * .5f - .5f;
                    float ys = rand.nextFloat() * .5f - .5f;
                    float zs = rand.nextFloat() * .5f - .5f;
                    serverWorld.spawnParticle(ParticleTypes.SMOKE, entity.getPosX(), entity.getPosY(), entity.getPosZ(), 5, xs, ys, zs, 1);
                    serverWorld.playSound(entity.getPosX(), entity.getPosY(), entity.getPosZ(), SoundEvents.BLOCK_FIRE_EXTINGUISH, SoundCategory.AMBIENT, 1f, (1f + rand.nextFloat() * .2f) * .7f, false);
                }
            }
        }
        return false;
    }
}
