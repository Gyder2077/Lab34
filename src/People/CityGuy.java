package People;

import Enums.*;
import Exceptions.*;
import Interfaces.Movable;
import Items.Item;
import Locations.*;

import java.util.*;

public class CityGuy extends MiniPEKKA implements Movable {
    protected Emotion currentEmotion;
    protected Item item;

    public CityGuy(String name, int age, Location currentLocation) {
        super(name, age, currentLocation);
        this.currentEmotion = Emotion.NEUTRAL;
        System.out.println(name + currentEmotion.getEmotion());
    }

    @Override
    public void getItem(Item item) {
        if (item.getType() == ItemType.CLOTHES) {
            this.item = item;
            System.out.printf("%s получает из кладовой %s и возвращается обратно в %s%n",
                    name, item.getName(), currentLocation.getName());
            changeEmotion(Emotion.JOY);
        } else {throw new GettingItemException(name + "может получать только одежду");}
    }

    @Override
    public void moveTo(Location loc) {
        if (currentLocation == loc) {
            throw new LocationChangeException(name + " уже находится в " + loc.getName());
        } else if (loc.getClass() == Wardrobe.class) {
            Wardrobe wardrobe = (Wardrobe) loc;
            Random rand = new Random();
            ArrayList<Item> items = wardrobe.getItems();
            Item item = items.get(rand.nextInt(items.size()));
            wardrobe.del(item);
            getItem(item);
        }
        else {
            currentLocation.del(this);
            System.out.printf("'%s' перемещается из '%s' в '%s'%n", name, currentLocation.getName(), loc.getName());
            loc.add(this);
            currentLocation = loc;
        }
    }

    @Override
    public void changeEmotion(Emotion emotion) {
        currentEmotion = emotion;
        System.out.println(name + currentEmotion.getEmotion());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj.getClass() != getClass()) {return false;}
        CityGuy that = (CityGuy) obj;
        return super.equals(obj) && Objects.equals(that.currentEmotion, currentEmotion) && Objects.equals(that.item, item);
    }

    @Override
    public int hashCode() {return Objects.hash(name, age, currentEmotion, item);}

    @Override
    public String toString() {
        return String.format("CityGuy{name='%s', age='%d', currentEmotion='%s', item='%s'}",
                name, age, currentEmotion, item);
    }
}



