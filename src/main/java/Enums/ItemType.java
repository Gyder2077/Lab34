package Enums;

public enum ItemType {
    SWEETS("Сладость", true),
    FOOD("Еда", true),
    CLOTHES("Одежда", false),
    CATALOG("Список", false);

    private final String type;
    private final boolean consumable;

    ItemType(String type, boolean consumable) {
        this.type = type;
        this.consumable = consumable;
    }

    public boolean getConsumable() {return consumable;}
    public String getType() {return type;}
}