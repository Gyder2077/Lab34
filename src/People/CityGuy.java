package People;

import Enums.*;
import Exceptions.*;
import Interfaces.Movable;
import Items.Item;
import Locations.Location;

import java.util.Objects;

public class CityGuy extends MiniPEKKA implements Movable {
    protected Emotion currentEmotion;
    protected Item item;

    public CityGuy(String name, int age, Location currentLocation) {
        super(name, age, currentLocation);
        this.currentEmotion = Emotion.NEUTRAL;
        System.out.println(name + currentEmotion.getEmotion());
    }

    public Item help() {return item;}

    @Override
    public void getItem(Item item) {
        if (item.getType() == ItemType.CLOTHES) {
            this.item = item;
            System.out.printf("'%s' взял одежду из кладовой'%n'", name);
            changeEmotion(Emotion.JOY);
        } else {throw new GettingItemException(name + "может получать только одежду");}
    }

    @Override
    public void moveTo(Location loc) {
        if (currentLocation == loc) {
            throw new LocationChangeException(name + " уже находится в " + loc.getName());
        } else {
            currentLocation.del(this);
            System.out.printf("'%s' перемещается из '%s' в '%s''%n'", name, currentLocation.toString(), loc.toString());
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
    public int hashCode() {return Objects.hash(name, age, currentLocation, currentEmotion, item);}

    @Override
    public String toString() {
        return String.format("CityGuy{name='%s', age='%d', currentLocation='%s', currentEmotion='%s', item='%s'}",
                name, age, currentLocation.toString(), currentEmotion, item);
    }
}



