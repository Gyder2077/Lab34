package Items;

import Enums.ItemType;

import java.util.Objects;

public class Catalog extends Item {
    private final String text;

    public Catalog(String name, String text) {
        super(name);
        type = ItemType.CATALOG;
        this.text = text;

    }

    public String getText() {return text;}

    @Override
    public boolean equals(Object obj) {
        if (obj.getClass() != getClass()) {return false;}
        Catalog that = (Catalog) obj;
        return Objects.equals(that.name, name) && Objects.equals(that.type, type) && Objects.equals(that.text, text);
    }

    @Override
    public int hashCode() {return Objects.hash(name, type, text);}

    @Override
    public String toString() {
        return String.format("CatalogItem{name='%s', type='%s', text='%s'}",
                name, type.getType(), text);
    }
}
