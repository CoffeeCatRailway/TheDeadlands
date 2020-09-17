package coffeecatrailway.tdeadlands.client.entity.renderer;

import coffeecatrailway.tdeadlands.TheDeadlands;
import coffeecatrailway.tdeadlands.client.entity.model.MuskOxModel;
import coffeecatrailway.tdeadlands.client.entity.model.RatModel;
import coffeecatrailway.tdeadlands.common.entity.MuskOxEntity;
import coffeecatrailway.tdeadlands.common.entity.RatEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

/**
 * @author CoffeeCatRailway
 * Created: 27/08/2020
 */
@OnlyIn(Dist.CLIENT)
public class MuskOxRenderer extends MobRenderer<MuskOxEntity, MuskOxModel>
{
    private static final ResourceLocation TEXTURE = TheDeadlands.getLocation("textures/entity/musk_ox.png");

    public MuskOxRenderer(EntityRendererManager renderManager)
    {
        super(renderManager, new MuskOxModel(), 1f);
    }

    @Override
    public ResourceLocation getEntityTexture(MuskOxEntity entity)
    {
        return TEXTURE;
    }
}
