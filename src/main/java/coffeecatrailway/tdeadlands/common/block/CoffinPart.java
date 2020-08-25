package coffeecatrailway.tdeadlands.common.block;

import net.minecraft.util.IStringSerializable;

/**
 * @author CoffeeCatRailway
 * Created: 24/08/2020
 */
public enum CoffinPart implements IStringSerializable {
    FRONT("front"),
    BACK("back");

    private final String name;

    CoffinPart(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public String getString() {
        return this.name;
    }
}
