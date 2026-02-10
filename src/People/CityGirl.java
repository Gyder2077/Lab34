package People;

import Enums.*;
import Exceptions.GettingItemException;
import Interfaces.Spreader;
import Items.Item;
import Locations.Location;

import java.util.ArrayList;

public class CityGirl extends CityGuy implements Spreader {
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

    @Override
    public void spread(ArrayList<MiniPEKKA> population) {}
}
