package Locations;

import Exceptions.DelFromLocationException;
import People.*;
import Records.NewsAboutDunno;

import java.util.*;

public final class City extends Location {
    private final ArrayList<MiniGuy> population;

    public City(String name) {
        super(name);
        this.population = new ArrayList<>();
        System.out.printf("Действия присходят в городе '%s'%n", name);
    }

    public static City cityCreation() {
        City city = new City("Хабаровск");
        ArrayList<String> names = new ArrayList<>(List.of("Синеглазка", "Белочка", "Галочка",
                "Ёлочка", "Заинька", "Кисонька", "Кубышка", "Маргаритка", "Пушинка", "Снежинка"));
        System.out.printf("В городе '%s' живут:%n", city.getName());
        while (names.size() > 4) {
            Random rand = new Random();
            CityGirl citizen = new CityGirl(names.get(rand.nextInt(names.size())), 13, city);
            names.remove(citizen.getName());
        }
        new CityGuy("Тюбик", 14, city);
        new CityGuy("Гусля", 13, city);
        System.out.println();
        return city;
    }

    public void newsSpread(NewsAboutDunno newsAboutDunno) {
        for (MiniGuy citizen : population) {
            if (citizen.getClass() == CityGirl.class && ((CityGirl) citizen).getNews() != newsAboutDunno) {
                ((CityGirl) citizen).setNews(newsAboutDunno);
                break;
            }
        }
    }

    public void populationMoving(Location location) {
        System.out.printf("%nВсе население двинулось к %s%n", location.getName());
        ArrayList<MiniGuy> oldPopulation = new ArrayList<>(population);
        for (MiniGuy citizen : oldPopulation) {
            if (citizen.getClass() == CityGirl.class) {
                ((CityGuy) citizen).moveTo(location);
            }
        }
    }

    @Override
    public void add(Object obj) {
        MiniGuy citizen = (MiniGuy) obj;
        population.add(citizen);
    }

    @Override
    public void del(Object obj) {
        MiniGuy citizen = (MiniGuy) obj;
        if (!population.remove(citizen)) {
            throw new DelFromLocationException("Такого жителя в городе нет");
        }
    }

    public ArrayList<MiniGuy> getPopulation() {return population;}

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
