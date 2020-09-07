package coffeecatrailway.tdeadlands.client.item.renderer;

import coffeecatrailway.tdeadlands.client.tileentity.renderer.DeadWoodChestTileEntityRenderer;
import coffeecatrailway.tdeadlands.common.tileentity.DeadWoodChestTileEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.model.ItemCameraTransforms;
import net.minecraft.client.renderer.tileentity.ItemStackTileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

/**
 * @author CoffeeCatRailway
 * Created: 6/09/2020
 */
@OnlyIn(Dist.CLIENT)
public class DeadWoodChestItemRenderer extends ItemStackTileEntityRenderer
{
    private DeadWoodChestTileEntity chestTile;

    @Override
    public void func_239207_a_(ItemStack stack, ItemCameraTransforms.TransformType transformType, MatrixStack matrixStack, IRenderTypeBuffer buffer, int combinedLight, int combinedOverlay)
    {
        if (this.chestTile == null)
            this.chestTile = new DeadWoodChestTileEntity();
        TileEntityRendererDispatcher.instance.renderItem(this.chestTile, matrixStack, buffer, combinedLight, combinedOverlay);
    }
}
