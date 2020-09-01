package coffeecatrailway.tdeadlands.client.entity.renderer;

import coffeecatrailway.tdeadlands.TheDeadlands;
import coffeecatrailway.tdeadlands.client.entity.model.RatModel;
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
public class RatRenderer extends MobRenderer<RatEntity, RatModel> {

    private static final ResourceLocation TEXTURE = TheDeadlands.getLocation("textures/entity/rat.png");

    public RatRenderer(EntityRendererManager renderManager) {
        super(renderManager, new RatModel(), .5f);
    }

    @Override
    public ResourceLocation getEntityTexture(RatEntity entity) {
        return TEXTURE;
    }
}
