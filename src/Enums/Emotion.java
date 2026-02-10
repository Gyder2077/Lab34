package Enums;

public enum Emotion {
    JOY(" сияет от радости"),
    FATIGUE(" находится в плохом состоянии"),
    NEUTRAL(" нейтрален к происходящему в городе"),
    WORRY(" начинает беспокоиться"),
    DISTRESS(" волнуется"),
    DEPRESSION(" впадает в депрессию");

    private final String name;

    Emotion(String name) {
        this.name = name;
    }

    public String getEmotion() {return name;}
}
