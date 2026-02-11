package Locations;

import Exceptions.DelFromLocationException;
import Items.Item;

import java.util.ArrayList;
import java.util.Objects;

public class Wardrobe extends Location {
    private ArrayList<Item> items;

    public Wardrobe(String name) {
        super(name);
        this.items = new ArrayList<>();
    }

    @Override
    public void add(Object obj) {
        Item item = (Item) obj;
        items.add(item);
    }

    @Override
    public void del(Object obj) {
        Item item = (Item) obj;
        if (!items.remove(item)) {
            throw new DelFromLocationException("Такого предмета в кладовой нет");
        }
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {this.items = items;}

    @Override
    public boolean equals(Object obj) {
        if (obj.getClass() != getClass()) {return false;}
        Wardrobe that = (Wardrobe) obj;
        return Objects.equals(that.name, name) && Objects.equals(that.items, items);
    }

    @Override
    public int hashCode() {return Objects.hash(name, items);}

    @Override
    public String toString() {
        return String.format("Wardrobe{name='%s', items='%s'}", name, items.toString());
    }
}
