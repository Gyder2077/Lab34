import Items.*;
import Locations.*;
import People.*;
import Records.News;

import java.util.*;

public class Main {
    private static City cityCreation() {
        City city = new City("Хабаровск");
        ArrayList<String> names = new ArrayList<>(List.of("Синеглазка", "Белочка", "Галочка",
                "Ёлочка", "Заинька", "Кисонька", "Кубышка", "Маргаритка", "Пушинка", "Снежинка"));
        System.out.printf("В городе '%s' живут:'%n'", city.getName());
        while (names.size() > 4) {
            Random rand = new Random();
            CityGirl citizen = new CityGirl(names.get(rand.nextInt(names.size())), 13, city);
            System.out.println(citizen.getName());
            names.remove(citizen.getName());
        }
        CityGuy citizen1 = new CityGuy("Тюбик", 14, city);
        System.out.println(citizen1.getName());
        CityGuy citizen2 = new CityGuy("Гусля", 13, city);
        System.out.println(citizen2.getName());
        return city;
    }

    private static Wardrobe wardrobeCreation() {
        Wardrobe wardrobe = new Wardrobe("Подвал");
        ArrayList<String> clothesNames = new ArrayList<>(List.of("Халат домашний", "Топ", "Шаровары", "Комбинезон",
                "Костюм химзащ", "Шлем", "Скафандр", "Трусы", "Тапок (один)", "Галстук"));
        System.out.printf("В гардеробе есть: '%n'");
        while (clothesNames.size() > 4) {
            Random rand = new Random();
            Clothes clothes = new Clothes(clothesNames.get(rand.nextInt(clothesNames.size())));
            System.out.println(clothes.getName());
            clothesNames.remove(clothes.getName());
        }
        return wardrobe;
    }

    private static Hospital hospitalCreation(City city) {
        Hospital hospital = new Hospital("Больничка");
        Doctor doc = new Doctor("Медуница", 15, hospital);
        hospital.setDoctor(doc);
        ((CityGuy) city.getPopulation().get(-1)).moveTo(hospital);
        ((CityGuy) city.getPopulation().get(-1)).moveTo(hospital);
        return hospital;
    }

    public static void main(String[] args) {
        City city = cityCreation();
        Wardrobe wardrobe = wardrobeCreation();
        Hospital hospital = hospitalCreation(city);
        Dunno dunno = new Dunno("Незнайка", 14, city);
        dunno.moveTo(hospital);
        if (dunno.ifAlive()) {
            hospital.getDoctor().getItem(new Catalog("Список необходимых вещей",
                    "Я не придумал что сюда написать, не бейте пж (по канону тут список вещей 1 2 3...)"));

            News news = new News(dunno.getName() + " из-за аварии попал в больницу города", true);
            for (MiniPEKKA citizen : city.getPopulation()) {
                if (citizen.getClass() == CityGirl.class) {
                    ((CityGirl) citizen).setNews(news);
                }
            }
        } else {
            News news = new News(dunno.getName() + " погиб в аварии (анлак)", false);
            for (MiniPEKKA citizen : city.getPopulation()) {
                if (citizen.getClass() == CityGirl.class && ((CityGirl) citizen).getNews() != news) {
                    ((CityGirl) citizen).setNews(news);
                }
            }
            System.out.println("ГГ сдох, город в депрессии\n\nКонец!");
        }
    }
}