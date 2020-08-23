package coffeecatrailway.tdeadlands.common.item;

import coffeecatrailway.tdeadlands.common.entity.DeadWoodArrowEntity;
import coffeecatrailway.tdeadlands.registry.DeadItems;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.item.ArrowItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShootableItem;
import net.minecraft.item.UseAction;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;

import java.util.function.Predicate;

/**
 * @author CoffeeCatRailway
 * Created: 23/08/2020
 */
public class DeadWoodBow extends ShootableItem {

    public static final Predicate<ItemStack> DEAD_ARROWS = (stack) -> {
        return stack.getItem() == DeadItems.DEAD_WOOD_ARROW.get(); // TODO: MAKE TAG
    };

    public DeadWoodBow(Properties properties) {
        super(properties);
    }

    @Override
    public void onPlayerStoppedUsing(ItemStack stack, World world, LivingEntity entity, int timeLeft) {
        if (entity instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) entity;
            boolean flag = player.abilities.isCreativeMode || EnchantmentHelper.getEnchantmentLevel(Enchantments.INFINITY, stack) > 0;
            ItemStack itemstack = player.findAmmo(stack);

            int i = this.getUseDuration(stack) - timeLeft;
            i = net.minecraftforge.event.ForgeEventFactory.onArrowLoose(stack, world, player, i, !itemstack.isEmpty() || flag);
            if (i < 0) return;

            if (!itemstack.isEmpty() || flag) {
                if (itemstack.isEmpty()) {
                    itemstack = new ItemStack(DeadItems.DEAD_WOOD_ARROW.get());
                }

                float f = getArrowVelocity(i);
                if (!((double) f < .1d)) {
                    boolean flag1 = player.abilities.isCreativeMode || (itemstack.getItem() instanceof ArrowItem && ((ArrowItem) itemstack.getItem()).isInfinite(itemstack, stack, player));
                    if (!world.isRemote) {
                        DeadWoodArrowEntity arrowEntity = new DeadWoodArrowEntity(world, player);
                        arrowEntity.func_234612_a_(player, player.rotationPitch, player.rotationYaw, 0f, f * 3f, 1f);
                        if (f == 1f)
                            arrowEntity.setIsCritical(true);

                        int j = EnchantmentHelper.getEnchantmentLevel(Enchantments.POWER, stack);
                        if (j > 0)
                            arrowEntity.setDamage(arrowEntity.getDamage() + (double) j * .5d + .5d);

                        int k = EnchantmentHelper.getEnchantmentLevel(Enchantments.PUNCH, stack);
                        if (k > 0)
                            arrowEntity.setKnockbackStrength(k);

                        if (EnchantmentHelper.getEnchantmentLevel(Enchantments.FLAME, stack) > 0)
                            arrowEntity.setFire(100);

                        stack.damageItem(1, player, (p_220009_1_) -> p_220009_1_.sendBreakAnimation(player.getActiveHand()));
                        if (flag1 || player.abilities.isCreativeMode)
                            arrowEntity.pickupStatus = AbstractArrowEntity.PickupStatus.CREATIVE_ONLY;

                        world.addEntity(arrowEntity);
                    }

                    world.playSound((PlayerEntity) null, player.getPosX(), player.getPosY(), player.getPosZ(), SoundEvents.ENTITY_ARROW_SHOOT, SoundCategory.PLAYERS, 1f, 1f / (random.nextFloat() * .4f + 1.2f) + f * .5f);
                    if (!flag1 && !player.abilities.isCreativeMode) {
                        itemstack.shrink(1);
                        if (itemstack.isEmpty())
                            player.inventory.deleteStack(itemstack);
                    }

                    player.addStat(Stats.ITEM_USED.get(this));
                }
            }
        }
    }

    public static float getArrowVelocity(int charge) {
        float f = (float) charge / 20.0F;
        f = (f * f + f * 2.0F) / 3.0F;
        if (f > 1.0F) {
            f = 1.0F;
        }

        return f;
    }

    @Override
    public int getUseDuration(ItemStack stack) {
        return 64800;
    }

    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.BOW;
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity player, Hand hand) {
        ItemStack itemstack = player.getHeldItem(hand);
        boolean flag = !player.findAmmo(itemstack).isEmpty();

        ActionResult<ItemStack> ret = net.minecraftforge.event.ForgeEventFactory.onArrowNock(itemstack, world, player, hand, flag);
        if (ret != null) return ret;

        if (!player.abilities.isCreativeMode && !flag) {
            return ActionResult.resultFail(itemstack);
        } else {
            player.setActiveHand(hand);
            return ActionResult.resultConsume(itemstack);
        }
    }

    @Override
    public Predicate<ItemStack> getInventoryAmmoPredicate() {
        return DEAD_ARROWS;
    }

    @Override
    public int func_230305_d_() {
        return 15;
    }
}
