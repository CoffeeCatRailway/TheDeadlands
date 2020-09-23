package coffeecatrailway.tdeadlands;

import net.minecraftforge.client.model.animation.Animation;
import net.minecraftforge.common.ForgeConfigSpec;

import java.util.function.Supplier;

/**
 * @author CoffeeCatRailway
 * Created: 23/09/2020
 */
public class DeadConfig
{
    private static final String CONFIG = "config." + TheDeadlands.MOD_ID + ".";

    public static class Client
    {
        public ForgeConfigSpec.EnumValue<OwlDanceType> owlDanceType;

        public Client(ForgeConfigSpec.Builder builder)
        {
            builder.comment("Client Configurable Settings").push("entity");
            this.owlDanceType = builder.comment("The way an owl dances","- SMOOTH: Use particle ticks to smooth the animation", "- PARROT: Less smooth but, looks more like a parrot")
                    .translation(CONFIG + "entity.owlDanceType").defineEnum("owlDanceType", OwlDanceType.SMOOTH, OwlDanceType.values());
            builder.pop();
        }

        public enum OwlDanceType
        {
            SMOOTH(Animation::getPartialTickTime),
            PARROT(() -> 0f);

            private final Supplier<Float> offset;

            OwlDanceType(Supplier<Float> offset)
            {
                this.offset = offset;
            }

            public float getOffset()
            {
                return offset.get();
            }
        }
    }
}
