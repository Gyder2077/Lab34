package Locations;

import Exceptions.DelFromLocationException;
import People.MiniPEKKA;

import java.util.ArrayList;
import java.util.Objects;

public final class City extends Location {
    private final ArrayList<MiniPEKKA> population;

    public City(String name) {
        super(name);
        this.population = new ArrayList<>();
        System.out.printf("Действия присходят в городе '%s''%n'", name);
    }

    @Override
    public void add(Object obj) {
        MiniPEKKA citizen = (MiniPEKKA) obj;
        population.add(citizen);
    }

    @Override
    public void del(Object obj) {
        System.out.println("OOOOOOOOOOOOOO");
        MiniPEKKA citizen = (MiniPEKKA) obj;
        System.out.println("OOOOOOOOOOOOOO");
        population.remove(citizen);
//        if (!population.remove(citizen)) {
//            throw new DelFromLocationException("Такого жителя в городе нет");
//        }
    }

    public ArrayList<MiniPEKKA> getPopulation() {return population;}

    @Override
    public boolean equals(Object obj) {
        if (obj.getClass() != getClass()) {return false;}
        City that = (City) obj;
        return Objects.equals(that.name, name) && Objects.equals(that.population, population);
    }

    @Override
    public int hashCode() {return Objects.hash(name, population);}

    @Override
    public String toString() {
        return String.format("City{name='%s', population='%s'}", name, population);
    }
}
