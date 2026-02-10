package People;

import Enums.*;
import Exceptions.GettingItemException;
import Items.Item;
import Locations.Location;

public class CityGirl extends CityGuy {
    public CityGirl(String name, int age, Location currentLocation, Emotion currentEmotion) {
        super(name, age, currentLocation, currentEmotion);
    }

    @Override
    public void getItem(Item item) {
        if (item.getType() != ItemType.CLOTHES && item.getType() != ItemType.CATALOG) {
            this.item = item;
            System.out.printf("'%s' взяла предмет для помощи'%n'", name);
        } else {throw new GettingItemException(name + "не может получать такие предметы");}
    }

    @Override
    public String toString() {
        return String.format("CityGirl{name='%s', age='%d', currentLocation='%s', currentEmotion='%s', item='%s'}",
                name, age, currentLocation.toString(), currentEmotion, item);
    }
}
