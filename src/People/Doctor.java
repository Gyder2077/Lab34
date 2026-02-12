package People;

import Enums.ItemType;
import Exceptions.GettingItemException;
import Items.*;
import Locations.Location;

import java.util.Objects;

public class Doctor extends MiniPEKKA {
    private Catalog item;

    public Doctor(String name, int age, Location currentLocation) {
        super(name, age, currentLocation);
        System.out.println(name + " доктор в " + currentLocation.getName());
    }

    @Override
    public void getItem(Item item) {
        if (item.getType() == ItemType.CATALOG) {
            this.item = (Catalog) item;
            System.out.printf("'%s' получила список необходимых вещей'%n%s%n'", name, this.item.getText());
        } else {throw new GettingItemException("Доктор может получать только список");}
    }

    @Override
    public boolean equals(Object obj) {
        if (obj.getClass() != getClass()) {return false;}
        Doctor that = (Doctor) obj;
        return super.equals(obj) && Objects.equals(that.item, item);
    }

    @Override
    public int hashCode() {return Objects.hash(name, age, item);}

    @Override
    public String toString() {
        return String.format("Doctor{name='%s', age='%d', item='%s'}",
                name, age, item);
    }
}
