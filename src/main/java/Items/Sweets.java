package Items;

import Enums.ItemType;
import Exceptions.IllegalUsefullnessException;

import java.util.Objects;

public class Sweets extends Food {
    private final int sweetness;

    public Sweets(String name, int usefullness, int sweetness) throws IllegalUsefullnessException {
        super(name, usefullness - sweetness);
        type = ItemType.SWEETS;
        this.sweetness = sweetness;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj.getClass() != getClass()) {return false;}
        Sweets that = (Sweets) obj;
        return Objects.equals(that.name, name) && Objects.equals(that.type, type) && Objects.equals(that.usefulness, usefulness)
                && Objects.equals(that.sweetness, sweetness);
    }

    @Override
    public int hashCode() {return Objects.hash(name, type, usefulness, sweetness);}

    @Override
    public String toString() {
        return String.format("SweetItem{name='%s', type='%s', usefulness='%d', sweetness='%d'}",
                name, type.getType(), usefulness, sweetness);
    }
}