package People;

import Exceptions.IllegalAgeException;
import Items.Item;
import Locations.Location;

import java.util.Objects;

public abstract class MiniPEKKA {
    protected final String name;
    protected int age;
    protected Location currentLocation;

    public MiniPEKKA(String name, int age, Location currentLocation) {
        this.name = name;
        checkAge(age);
        this.currentLocation = currentLocation;
        currentLocation.add(this);
    }

    private void checkAge(int age) {
        if (age <= 0) {
            throw new IllegalAgeException("Вы еще не родились");
        } else if (age > 60) {
            throw new IllegalAgeException("Старикам здесь не место");
        } else {this.age = age;}
    }

    public abstract void getItem(Item item);
    public String getName() {return name;}

    @Override
    public boolean equals(Object obj) {
        if (obj.getClass() != getClass()) {return false;}
        MiniPEKKA that = (MiniPEKKA) obj;
        return Objects.equals(that.name, name) && Objects.equals(that.age, age) && Objects.equals(that.currentLocation, currentLocation);
    }

    @Override
    public int hashCode() {return Objects.hash(name, age, currentLocation);}

    @Override
    public String toString() {
        return String.format("MiniPEKKA{name='%s', age='%d', currentLocation='%s'}", name, age, currentLocation.toString());
    }
}
