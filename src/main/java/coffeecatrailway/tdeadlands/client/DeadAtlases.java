package coffeecatrailway.tdeadlands.client;

import coffeecatrailway.tdeadlands.TheDeadlands;
import net.minecraft.client.renderer.Atlases;
import net.minecraft.client.renderer.model.RenderMaterial;
import net.minecraft.state.properties.ChestType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

/**
 * @author CoffeeCatRailway
 * Created: 6/09/2020
 */
@OnlyIn(Dist.CLIENT)
@Mod.EventBusSubscriber(modid = TheDeadlands.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DeadAtlases
{
    private static final ResourceLocation DEAD_WOOD_CHEST_LOCATION = TheDeadlands.getLocation("entity/chest/dead_wood");
    private static final ResourceLocation DEAD_WOOD_CHEST_LEFT_LOCATION = TheDeadlands.getLocation("entity/chest/dead_wood_left");
    private static final ResourceLocation DEAD_WOOD_CHEST_RIGHT_LOCATION = TheDeadlands.getLocation("entity/chest/dead_wood_right");

    private static final RenderMaterial DEAD_WOOD_CHEST_MATERIAL = getChestMaterial(DEAD_WOOD_CHEST_LOCATION);
    private static final RenderMaterial DEAD_WOOD_CHEST_LEFT_MATERIAL = getChestMaterial(DEAD_WOOD_CHEST_LEFT_LOCATION);
    private static final RenderMaterial DEAD_WOOD_CHEST_RIGHT_MATERIAL = getChestMaterial(DEAD_WOOD_CHEST_RIGHT_LOCATION);

    public static final ChestMaterial CHEST_DEAD_WOOD = new ChestMaterial(DEAD_WOOD_CHEST_MATERIAL, DEAD_WOOD_CHEST_LEFT_MATERIAL, DEAD_WOOD_CHEST_RIGHT_MATERIAL);

    private static RenderMaterial getChestMaterial(ResourceLocation location)
    {
        return new RenderMaterial(Atlases.CHEST_ATLAS, location);
    }

    public static RenderMaterial getChestTypeMaterial(ChestMaterial chestMaterial, ChestType chestType)
    {
        switch (chestType)
        {
            case LEFT:
                return chestMaterial.left;
            case RIGHT:
                return chestMaterial.right;
            case SINGLE:
            default:
                return chestMaterial.single;
        }
    }

    @SubscribeEvent
    public static void onStitch(TextureStitchEvent.Pre event)
    {
        if (event.getMap().getTextureLocation().equals(Atlases.CHEST_ATLAS))
        {
            event.addSprite(DEAD_WOOD_CHEST_LOCATION);
            event.addSprite(DEAD_WOOD_CHEST_LEFT_LOCATION);
            event.addSprite(DEAD_WOOD_CHEST_RIGHT_LOCATION);
        }
    }

    public static class ChestMaterial
    {
        private RenderMaterial single, left, right;

        public ChestMaterial(RenderMaterial single, RenderMaterial left, RenderMaterial right)
        {
            this.single = single;
            this.left = left;
            this.right = right;
        }
    }
}
