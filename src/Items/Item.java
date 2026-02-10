package Items;

import Enums.ItemType;

import java.util.Objects;

public abstract class Item {
    protected final String name;
    protected ItemType type;

    protected Item(String name) {
        this.name = name;
    }

    public ItemType getType() {return type;}
    public String getName() {return name;}

    @Override
    public boolean equals(Object obj) {
        if (obj.getClass() != getClass()) {return false;}
        Item that = (Item) obj;
        return Objects.equals(that.name, name) && Objects.equals(that.type, type);
    }

    @Override
    public int hashCode() {return Objects.hash(name, type);}

    @Override
    public String toString() {
        return String.format("Item{name='%s', type='%s'}",
                name, type.getType());
    }
}
