package Items;

import Enums.ItemType;
import java.util.Objects;

public class Sweets extends Food {
    private final int uselessness;

    public Sweets(String name, int usefullness, int uselessness) {
        super(name, usefullness - uselessness);
        type = ItemType.SWEETS;
        this.uselessness = uselessness;
    }

    public int getUselessness() {return uselessness;}

    @Override
    public boolean equals(Object obj) {
        if (obj.getClass() != getClass()) {return false;}
        Sweets that = (Sweets) obj;
        return Objects.equals(that.name, name) && Objects.equals(that.type, type) && Objects.equals(that.usefulness, usefulness)
                && Objects.equals(that.uselessness, uselessness);
    }

    @Override
    public int hashCode() {return Objects.hash(name, type, usefulness, uselessness);}

    @Override
    public String toString() {
        return String.format("SweetItem{name='%s', type='%s', usefulness='%d', uselessness='%d'}",
                name, type.getType(), usefulness, uselessness);
    }
}