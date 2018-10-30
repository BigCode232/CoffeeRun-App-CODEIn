package bigcode232_es.cofferun;

import android.graphics.drawable.Drawable;

public class Coffee {
    private int price;
    private String name;
    private int icon;

    public Coffee(int price, String name, int icon) {
        this.price = price;
        this.name = name;
        this.icon = icon;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public int getIcon() {
        return icon;
    }
}
