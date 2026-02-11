package People;

import Enums.*;
import Exceptions.GettingItemException;
import Interfaces.Spreader;
import Items.Item;
import Locations.Location;
import Records.News;

import java.util.*;

public class CityGirl extends CityGuy implements Spreader {
    protected News news;

    public CityGirl(String name, int age, Location currentLocation) {
        super(name, age, currentLocation);
    }

    public News getNews() {return news;}
    public void setNews(News news) {
        this.news = news;
        if (news.isAlive()) {
            changeEmotion(getRandEmotion());
            return;
        }
        changeEmotion(Emotion.DEPRESSION);
    }
    private Emotion getRandEmotion() {
        List<Emotion> emotionList = List.of(Emotion.WORRY, Emotion.DISTRESS);
        Random rand = new Random();
        return emotionList.get(rand.nextInt(emotionList.size()));
    }

    @Override
    public void spread(ArrayList<MiniPEKKA> population) {
        for (MiniPEKKA citizen : population) {
            if (citizen.getClass() == getClass()) {
                ((CityGirl) citizen).setNews(getNews());
                System.out.println(citizen.name + " узнает о том, что великий путешественник " + getNews() + ", от " + name);
            }
        }
    }

    @Override
    public void getItem(Item item) {
        if (item.getType() != ItemType.CLOTHES && item.getType() != ItemType.CATALOG) {
            this.item = item;
            System.out.printf("'%s' взяла предмет для помощи'%n'", name);
        } else {
            throw new GettingItemException(name + " не может получать такие предметы");
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj.getClass() != getClass()) {
            return false;
        }
        CityGirl that = (CityGirl) obj;
        return super.equals(obj) && Objects.equals(that.news, news);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, currentLocation, currentEmotion, item, news);
    }

    @Override
    public String toString() {
        return String.format("CityGirl{name='%s', age='%d', currentLocation='%s', currentEmotion='%s', item='%s', news='%s'}",
                name, age, currentLocation.toString(), currentEmotion, item, news);
    }
}
