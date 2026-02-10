package People;

import java.util.*;
import Enums.Emotion;
import Exceptions.LocationChangeException;
import Interfaces.Movable;
import Items.*;
import Locations.Location;

public class Dunno extends MiniPEKKA implements Movable {
    private boolean isAlive;
    private int satiety;
    private Emotion currentEmotion;

    public Dunno(String name, int age, Location currentLocation) {
        super(name, age, currentLocation);
        currentEmotion = Emotion.NEUTRAL;
        isAlive = true;
        satiety = -10;
    }

    public boolean ifAlive() {return isAlive;}
    private void setAlive() {isAlive = false;}

    @Override
    public void getItem(Item item) {
        if (item.getType().getConsumable()) {
            Food food = (Food) item;
            satiety += food.getUsefulness();
        }
    }

    @Override
    public void moveTo(Location loc) {
        if (currentLocation == loc) {
            throw new LocationChangeException(name + " уже находится в " + loc.getName());
        } else {
            currentLocation.del(this);
            loc.add(this);
            currentLocation = loc;
            double rand = new Random().nextDouble();
            if (rand <= 0.2) {
                setAlive();
            }
            if (ifAlive()) {
                currentEmotion = Emotion.FATIGUE;
                System.out.println(name + " из-за аварии попал в больницу Цветочного города");
            } else {
                System.out.println(name + " погиб в аварии (анлак)");
            }
        }
    }

    @Override
    public void changeEmotion(Emotion emotion) {
        currentEmotion = emotion;
        System.out.println(name + currentEmotion.getEmotion());
    }

    public int getSatiety() {return satiety;}

    @Override
    public boolean equals(Object obj) {
        if (obj.getClass() != getClass()) {return false;}
        Dunno that = (Dunno) obj;
        return super.equals(obj) && Objects.equals(that.isAlive, isAlive) &&
                Objects.equals(that.satiety, satiety) && Objects.equals(that.currentEmotion, currentEmotion);
    }

    @Override
    public int hashCode() {return Objects.hash(name, age, currentLocation, isAlive, satiety, currentEmotion);}

    @Override
    public String toString() {
        return String.format("Dunno{name='%s', age='%d', currentLocation='%s', isAlive='%s', satiety='%d', currentEmotion='%s'}",
                name, age, currentLocation.toString(), isAlive, satiety, currentEmotion);
    }
}

