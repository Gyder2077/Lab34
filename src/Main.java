import Items.*;
import Locations.*;
import People.*;

import java.util.*;

public class Main {
    private static City cityCreation() {
        City city = new City("Хабаровск");
        ArrayList<String> names = new ArrayList<>(List.of("Синеглазка", "Белочка", "Галочка",
                "Ёлочка", "Заинька", "Кисонька", "Кубышка", "Маргаритка", "Пушинка", "Снежинка"));
        while (names.size() > 4) {
            Random rand = new Random();
            CityGirl citizen = new CityGirl(names.get(rand.nextInt(names.size())), 13, city);
            System.out.printf("'%s' живет в городе '%s''%n'", citizen.getName(), city.getName());
            names.remove(citizen.getName());
        }
        CityGuy citizen1 = new CityGuy("Тюбик", 14, city);
        System.out.printf("'%s' живет в городе '%s''%n'", citizen1.getName(), city.getName());
        CityGuy citizen2 = new CityGuy("Гусля", 14, city);
        System.out.printf("'%s' живет в городе '%s''%n'", citizen2.getName(), city.getName());
        return city;
    }

    public static void main(String[] args) {
        City city = cityCreation();
        Hospital hospital = new Hospital("Больничка");
        Wardrobe wardrobe = new Wardrobe("Подвал");
        Doctor doc = new Doctor("Медуница", 15, hospital);
        hospital.setDoctor(doc);
        Dunno dunno = new Dunno("Незнайка", 14, city);
    }
}