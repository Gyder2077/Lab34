package Items;

import Enums.ItemType;
import Exceptions.IllegalUsefullnessException;
import Interfaces.Usefull;

import java.util.Objects;

public class Food extends Item implements Usefull {
    protected int usefulness;

    public Food(String name, int usefulness) throws IllegalUsefullnessException {
        super(name);
        setUsefulness(usefulness);
        type = ItemType.FOOD;
    }

    @Override
    public void setUsefulness(int usefulness) throws IllegalUsefullnessException {
        if (usefulness >= 0 && usefulness <= 5) {
            this.usefulness = usefulness;
        } else {
            throw new IllegalUsefullnessException("Полезность должна быть от 0 до 5");
        }
    }

    @Override
    public int getUsefulness() {return usefulness;}

    @Override
    public boolean equals(Object obj) {
        if (obj.getClass() != getClass()) {return false;}
        Food that = (Food) obj;
        return Objects.equals(that.name, name) && Objects.equals(that.type, type) && Objects.equals(that.usefulness, usefulness);
    }

    @Override
    public int hashCode() {return Objects.hash(name, type, usefulness);}

    @Override
    public String toString() {
        return String.format("FoodItem{name='%s', type='%s', usefulness='%d'}",
                name, type.getType(), usefulness);
    }
}
