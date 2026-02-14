package Items;

import Enums.ItemType;

public class Clothes extends Item {
    public Clothes(String name) {
        super(name);
        type = ItemType.CLOTHES;
    }

    @Override
    public String toString() {
        return String.format("ClothingItem{name='%s', type='%s'}",
                name, type.getType());
    }
}
