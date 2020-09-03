package coffeecatrailway.tdeadlands.registry;

import net.minecraft.item.Food;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

/**
 * @author CoffeeCatRailway
 * Created: 1/09/2020
 */
public class DeadFoods {

    public static final Food RAT_DROPPINGS_FOOD = new Food.Builder().hunger(3).saturation(4f).effect(() -> new EffectInstance(Effects.HUNGER, 600, 0), 0.8f).build();

    public static final Food DEAD_RAT = new Food.Builder().hunger(2).saturation(.3f).effect(() -> new EffectInstance(Effects.HUNGER, 600, 0), .3f).meat().build();
    public static final Food COOKED_RAT = new Food.Builder().hunger(4).saturation(.6f).meat().build();

    public static final Food MUSKOX = new Food.Builder().hunger(3).saturation(.3f).meat().build();
    public static final Food COOKED_MUSKOX = new Food.Builder().hunger(6).saturation(.7f).meat().build();

    public static final Food ROTTON_SKIN = new Food.Builder().hunger(4).saturation(0.1F).effect(new EffectInstance(Effects.HUNGER, 600, 0), .8f).build();
    public static final Food COOKED_SKIN = new Food.Builder().hunger(6).saturation(.5f).build();
}
