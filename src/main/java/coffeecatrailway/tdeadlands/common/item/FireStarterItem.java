package coffeecatrailway.tdeadlands.common.item;

import coffeecatrailway.tdeadlands.TheDeadlands;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.block.AbstractFireBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.CampfireBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.util.Constants;

/**
 * @author CoffeeCatRailway
 * Created: 23/09/2020
 */
public class FireStarterItem extends Item
{
    public FireStarterItem(Properties properties)
    {
        super(properties);
    }

    @Override
    public ActionResultType onItemUse(ItemUseContext context)
    {
        PlayerEntity player = context.getPlayer();
        World world = context.getWorld();
        BlockPos pos = context.getPos();

        float chance = world.rand.nextFloat() * 100f;
        if (chance < TheDeadlands.SERVER_CONFIG.fireStarterChance.get().floatValue())
        {
            BlockState state = world.getBlockState(pos);
            if (CampfireBlock.canBeLit(state))
            {
                this.playSound(world, player, pos);
                world.setBlockState(pos, state.with(BlockStateProperties.LIT, true), Constants.BlockFlags.DEFAULT);
                if (player != null)
                {
                    this.damageItem(context, player);
                }

                return ActionResultType.func_233537_a_(world.isRemote());
            } else
            {
                BlockPos offset = pos.offset(context.getFace());
                if (AbstractFireBlock.canLightBlock(world, offset, context.getPlacementHorizontalFacing()))
                {
                    this.playSound(world, player, pos);
                    world.setBlockState(offset, AbstractFireBlock.getFireForPlacement(world, offset), Constants.BlockFlags.DEFAULT);
                    if (player instanceof ServerPlayerEntity)
                    {
                        CriteriaTriggers.PLACED_BLOCK.trigger((ServerPlayerEntity) player, offset, context.getItem());
                        this.damageItem(context, player);
                    }

                    return ActionResultType.func_233537_a_(world.isRemote());
                } else
                {
                    return ActionResultType.FAIL;
                }
            }
        } else
        {
            this.playSound(world, player, pos);
            this.damageItem(context, player);
            return ActionResultType.PASS;
        }
    }

    private void playSound(World world, PlayerEntity player, BlockPos pos)
    {
        world.playSound(player, pos, SoundEvents.ITEM_FLINTANDSTEEL_USE, SoundCategory.BLOCKS, 1f, random.nextFloat() * .4f + .8f);
    }

    private void damageItem(ItemUseContext context, PlayerEntity player)
    {
        context.getItem().damageItem(1, player, playerEntity -> playerEntity.sendBreakAnimation(context.getHand()));
    }
}
