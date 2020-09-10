package coffeecatrailway.tdeadlands.client.entity.renderer;

import coffeecatrailway.tdeadlands.TheDeadlands;
import coffeecatrailway.tdeadlands.client.entity.model.OwlModel;
import coffeecatrailway.tdeadlands.client.entity.model.RatModel;
import coffeecatrailway.tdeadlands.common.entity.OwlEntity;
import coffeecatrailway.tdeadlands.common.entity.RatEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

/**
 * @author CoffeeCatRailway
 * Created: 7/09/2020
 */
@OnlyIn(Dist.CLIENT)
public class OwlRenderer extends MobRenderer<OwlEntity, OwlModel>
{
    private static final ResourceLocation TEXTURE = TheDeadlands.getLocation("textures/entity/owl.png");

    public OwlRenderer(EntityRendererManager renderManager)
    {
        super(renderManager, new OwlModel(), .5f);
    }

    @Override
    public ResourceLocation getEntityTexture(OwlEntity entity)
    {
        return TEXTURE;
    }

    @Override
    protected float handleRotationFloat(OwlEntity owl, float partialTicks)
    {
        float wingFlap = MathHelper.lerp(partialTicks, owl.prevWingFlap, owl.wingFlap);
        float wingFlapSpeed = MathHelper.lerp(partialTicks, owl.prevWingFlapSpeed, owl.wingFlapSpeed);
        return MathHelper.sin(wingFlap * .75f) * wingFlapSpeed * .75f;
    }
}
