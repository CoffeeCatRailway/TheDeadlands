package coffeecatrailway.tdeadlands.integration.registrate;

import com.tterrag.registrate.providers.RegistrateLangProvider;
import com.tterrag.registrate.util.nullness.NonNullConsumer;

/**
 * @author CoffeeCatRailway
 * Created: 10/09/2020
 */
public class DeadLangs implements NonNullConsumer<RegistrateLangProvider>
{
    @Override
    public void accept(RegistrateLangProvider provider)
    {
        provider.add("sound.tdeadlands.owl", "Owl Hoots");
        provider.add("sound.tdeadlands.owl.hurt", "Owl Hurts");
    }
}
