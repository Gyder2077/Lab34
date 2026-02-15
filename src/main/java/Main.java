import Enums.Emotion;
import Items.*;
import Locations.*;
import People.*;
import Records.NewsAboutDunno;

import java.util.*;

public class Main {
    private static ArrayList<Item> itemsCreation() throws Exception {
        ArrayList<Item> items = new ArrayList<>();
        ArrayList<String> foodNames = new ArrayList<>(List.of("Соль", "Суп", "Масло", "Сода пищевая",
                "Сосиски", "Таблетки", "Кофейные зерна", "Котлетки", "Молоко", "Уксус яблочный", "Пельмени", "Омлет"));
        ArrayList<String> sweetNames = new ArrayList<>(List.of("Чокопай", "Пирог", "Варенье",
                "Кексики", "Сахар", "Зефирки"));
        while (foodNames.size() + sweetNames.size() > 12) {
            Random rand = new Random();
            if (foodNames.size() > 8) {
                Food food = new Food(foodNames.get(rand.nextInt(foodNames.size())), rand.nextInt(7));
                items.add(food);
                foodNames.remove(food.getName());
            } else {
                Sweets sweets = new Sweets(sweetNames.get(rand.nextInt(sweetNames.size())),
                        rand.nextInt(7 - 2) + 3, rand.nextInt(3));
                items.add(sweets);
                sweetNames.remove(sweets.getName());
            }
        }
        return items;
    }

    public static void main(String[] args) throws Exception {
        City city = City.cityCreation();
        Wardrobe wardrobe = Wardrobe.wardrobeCreation();
        Hospital hospital = Hospital.hospitalCreation(city);
        Dunno dunno = new Dunno("Незнайка", 14, city);
        dunno.moveTo(hospital);
        if (dunno.ifAlive()) {
            hospital.getDoctor().getItem(new Catalog("Список необходимых вещей",
                    "Я не придумал что сюда написать, не бейте пж (по канону тут список вещей 1 2 3...)\n"));
            for (MiniGuy citizen : hospital.getPopulation()) {
                if (citizen.getClass() == CityGuy.class) {
                    ((CityGuy) citizen).moveTo(wardrobe);
                }
            }
            NewsAboutDunno newsAboutDunno = new NewsAboutDunno(dunno.getName() +
                    " из-за аварии попал в больницу города", true);
            city.newsSpread(newsAboutDunno, itemsCreation());
            city.populationMoving(hospital);
            hospital.helpDunno(dunno);
            int satiety = dunno.getSatiety();
            if (satiety > 10) {
                dunno.changeEmotion(Emotion.JOY);
                System.out.println(dunno.getName() + " наелся и быстро вылечился\n\nКонец!");
            } else if (satiety > 0) {
                dunno.changeEmotion(Emotion.NEUTRAL);
                System.out.println(dunno.getName() + " идет на поправку благодаря помощи\n\nКонец!");
            } else {
                dunno.setAlive();
                for (MiniGuy citizen : hospital.getPopulation()) {
                    if (citizen.getClass() == CityGirl.class) {
                        ((CityGirl) citizen).changeEmotion(Emotion.DEPRESSION);
                    }
                }
                System.out.println("ГГ сдох, город в депрессии\n\nКонец!");
            }
        } else {
            NewsAboutDunno newsAboutDunno = new NewsAboutDunno(dunno.getName() +
                    " погиб в аварии (анлак)", false);
            city.newsSpread(newsAboutDunno);
            System.out.println("ГГ сдох, город в депрессии\n\nКонец!");
        }
    }
}