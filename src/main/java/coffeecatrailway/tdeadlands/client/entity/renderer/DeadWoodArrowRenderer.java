package coffeecatrailway.tdeadlands.client.entity.renderer;

import coffeecatrailway.tdeadlands.TheDeadlands;
import coffeecatrailway.tdeadlands.common.entity.DeadWoodArrowEntity;
import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

/**
 * @author CoffeeCatRailway
 * Created: 23/08/2020
 */
@OnlyIn(Dist.CLIENT)
public class DeadWoodArrowRenderer extends ArrowRenderer<DeadWoodArrowEntity>
{
    public static final ResourceLocation ARROW = TheDeadlands.getLocation("textures/entity/dead_wood_arrow.png");

    public DeadWoodArrowRenderer(EntityRendererManager manager)
    {
        super(manager);
    }

    @Override
    public ResourceLocation getEntityTexture(DeadWoodArrowEntity entity)
    {
        return ARROW;
    }
}
