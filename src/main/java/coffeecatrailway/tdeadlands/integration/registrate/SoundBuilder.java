package coffeecatrailway.tdeadlands.integration.registrate;

import com.tterrag.registrate.AbstractRegistrate;
import com.tterrag.registrate.builders.AbstractBuilder;
import com.tterrag.registrate.builders.BuilderCallback;
import com.tterrag.registrate.util.entry.RegistryEntry;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;

/**
 * @author CoffeeCatRailway
 * Created: 10/09/2020
 */
public class SoundBuilder<T extends SoundEvent, P> extends AbstractBuilder<SoundEvent, T, P, SoundBuilder<T, P>>
{
    public SoundBuilder(AbstractRegistrate<?> owner, P parent, String name, BuilderCallback callback)
    {
        super(owner, parent, name, callback, SoundEvent.class);
    }

    @Override
    protected T createEntry()
    {
        return (T) new SoundEvent(new ResourceLocation(this.getOwner().getModid(), this.getName()));
    }
}
