package coffeecatrailway.tdeadlands.integration.registrate;

import com.tterrag.registrate.AbstractRegistrate;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

/**
 * @author CoffeeCatRailway
 * Created: 10/09/2020
 */
public class DeadRegistrate extends AbstractRegistrate<DeadRegistrate>
{
    public static DeadRegistrate create(String modid)
    {
        return new DeadRegistrate(modid).registerEventListeners(FMLJavaModLoadingContext.get().getModEventBus());
    }

    public DeadRegistrate(String modid)
    {
        super(modid);
    }

    public <T extends SoundEvent> SoundBuilder<T, DeadRegistrate> sound(String name) {
        return this.entry(name, callback -> new SoundBuilder<>(this, this.self(), name, callback));
    }
}
