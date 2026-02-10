package Enums;

public enum Emotion {
    JOY("радость"),
    FATIGUE("усталость"),
    NEUTRAL("нейтральность"),
    WORRY("беспокойство"),
    DISTRESS("волнение");

    private final String name;

    Emotion(String name) {
        this.name = name;
    }

    public String getEmotion() {return " испытывает " + name;}
}
