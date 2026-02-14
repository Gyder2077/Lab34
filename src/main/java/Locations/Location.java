package Locations;

import java.util.Objects;

public abstract class Location {
    protected final String name;

    protected Location(String name) {
        this.name = name;
    }

    public abstract void add(Object obj);
    public abstract void del(Object obj);

    public String getName() {return name;}

    @Override
    public boolean equals(Object obj) {
        if (obj.getClass() != getClass()) {return false;}
        Location that = (Location) obj;
        return Objects.equals(that.name, name);
    }

    @Override
    public int hashCode() {return Objects.hash(name);}

    @Override
    public String toString() {
        return String.format("Location{name='%s'}", name);
    }
}
