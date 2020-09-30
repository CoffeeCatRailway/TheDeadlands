package coffeecatrailway.tdeadlands.client.tileentity.renderer;

import coffeecatrailway.tdeadlands.common.tileentity.RunicTableTileEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;

/**
 * @author CoffeeCatRailway
 * Created: 20/09/2020
 */
public class RunicTableTileEntityRenderer extends TileEntityRenderer<RunicTableTileEntity>
{
    public RunicTableTileEntityRenderer(TileEntityRendererDispatcher dispatcher)
    {
        super(dispatcher);
    }

    @Override
    public void render(RunicTableTileEntity tileEntity, float partialTicks, MatrixStack matrixStack, IRenderTypeBuffer buffer, int combinedLight, int combinedOverlay)
    {

    }
}
