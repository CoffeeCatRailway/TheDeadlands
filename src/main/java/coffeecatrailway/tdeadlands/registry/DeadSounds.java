package coffeecatrailway.tdeadlands.registry;

import coffeecatrailway.tdeadlands.TheDeadlands;
import com.tterrag.registrate.util.entry.RegistryEntry;
import net.minecraft.util.SoundEvent;
import org.apache.logging.log4j.Logger;

import static coffeecatrailway.tdeadlands.TheDeadlands.REGISTRATE;

/**
 * @author CoffeeCatRailway
 * Created: 10/09/2020
 */
public class DeadSounds
{
    private static final Logger LOGGER = TheDeadlands.getLogger("Sounds");

    public static final RegistryEntry<SoundEvent> OWL = REGISTRATE.sound("owl").register();
    public static final RegistryEntry<SoundEvent> OWL_HURT = REGISTRATE.sound("owl_hurt").register();

    public static void load()
    {
        LOGGER.info("Loaded");
    }
}
