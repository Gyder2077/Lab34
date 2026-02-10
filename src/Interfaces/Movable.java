package Interfaces;

import Enums.Emotion;
import Locations.Location;

public interface Movable {
    void moveTo(Location loc);
    void changeEmotion(Emotion emotion);
}
