package coffeecatrailway.tdeadlands.common.inventory.container;

import coffeecatrailway.tdeadlands.registry.DeadBlocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.WorkbenchContainer;
import net.minecraft.util.IWorldPosCallable;

/**
 * @author CoffeeCatRailway
 * Created: 21/08/2020
 */
public class DeadWoodWorkbenchContainer extends WorkbenchContainer {

    public DeadWoodWorkbenchContainer(int id, PlayerInventory playerInventory) {
        this(id, playerInventory, IWorldPosCallable.DUMMY);
    }

    public DeadWoodWorkbenchContainer(int id, PlayerInventory playerInventory, IWorldPosCallable callable) {
        super(id, playerInventory, callable);
    }

    @Override
    public boolean canInteractWith(PlayerEntity playerIn) {
        return isWithinUsableDistance(this.worldPosCallable, playerIn, DeadBlocks.DEAD_WOOD_CRAFTING_TABLE.get());
    }
}
