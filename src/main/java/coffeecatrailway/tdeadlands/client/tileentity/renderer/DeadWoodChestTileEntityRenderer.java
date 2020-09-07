package coffeecatrailway.tdeadlands.client.tileentity.renderer;

import coffeecatrailway.tdeadlands.client.DeadAtlases;
import coffeecatrailway.tdeadlands.common.tileentity.DeadWoodChestTileEntity;
import net.minecraft.client.renderer.model.RenderMaterial;
import net.minecraft.client.renderer.tileentity.ChestTileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.state.properties.ChestType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

/**
 * @author CoffeeCatRailway
 * Created: 6/09/2020
 */
@OnlyIn(Dist.CLIENT)
public class DeadWoodChestTileEntityRenderer extends ChestTileEntityRenderer<DeadWoodChestTileEntity>
{
    public DeadWoodChestTileEntityRenderer(TileEntityRendererDispatcher rendererDispatcherIn)
    {
        super(rendererDispatcherIn);
    }

    @Override
    protected RenderMaterial getMaterial(DeadWoodChestTileEntity tile, ChestType type)
    {
        return DeadAtlases.getChestTypeMaterial(DeadAtlases.CHEST_DEAD_WOOD, type);
    }
}
