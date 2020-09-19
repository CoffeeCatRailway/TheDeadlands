package coffeecatrailway.tdeadlands.integration.registrate;

import coffeecatrailway.tdeadlands.TheDeadlands;
import com.tterrag.registrate.providers.RegistrateBlockstateProvider;
import com.tterrag.registrate.util.nullness.NonNullConsumer;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.generators.BlockModelBuilder;
import net.minecraftforge.client.model.generators.BlockModelProvider;

/**
 * @author CoffeeCatRailway
 * Created: 18/09/2020
 */
public class DeadBlockstates implements NonNullConsumer<RegistrateBlockstateProvider>
{
    @Override
    public void accept(RegistrateBlockstateProvider provider)
    {
        BlockModelProvider models = provider.models();

        models.getBuilder("tint_cross")
                .parent(models.getExistingFile(new ResourceLocation("block/block")))
                .ao(false).texture("particle", "#cross")
                .element().from(.8f, 0f, 8f).to(15.2f, 16f, 8f)
                .rotation().origin(8f, 8f, 8f).axis(Direction.Axis.Y).angle(45f).rescale(true).end()
                .shade(false).face(Direction.NORTH).uvs(0f, 0f, 16f, 16f).texture("#cross").tintindex(0).end()
                .shade(false).face(Direction.SOUTH).uvs(0f, 0f, 16f, 16f).texture("#cross").tintindex(0).end()
                .end().element().from(8f, 0f, .8f).to(8f, 16f, 15.2f)
                .rotation().origin(8f, 8f, 8f).axis(Direction.Axis.Y).angle(45f).rescale(true).end()
                .shade(false).face(Direction.WEST).uvs(0f, 0f, 16f, 16f).texture("#cross").tintindex(0).end()
                .shade(false).face(Direction.EAST).uvs(0f, 0f, 16f, 16f).texture("#cross").tintindex(0).end()
                .end().assertExistence();
    }

    public static BlockModelBuilder getTintCross(RegistrateBlockstateProvider provider, String name)
    {
        return provider.models().withExistingParent(name, TheDeadlands.getLocation("block/tint_cross")).texture("cross", "block/" + name);
    }
}
