package programming.school.adventure;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class Thing implements IExaminable {

    private final String name, description;
    private int cost = 0;
    private int energy = 0;
    private boolean autoConvertible = false; // If this is true, then picking this object results in increasing money.
    private boolean isFood = false;

    private URL picture = null;
    private URL sound = null;
    private Map<String, Object> properties = new HashMap<>();

    public Thing(final String name, final String description) {
        this.name = name;
        this.description = description;
    }

    public Thing(final String name) {
        this(name, null);
    }

    public String name() {
        return name;
    }

    public String description() {
        return description;
    }

    public void setCost(int value) {
        this.cost = value;
    }

    public void setFood(int energy) {
        this.isFood = true;
        this.energy = energy;
    }

    public int cost() {
        return cost;
    }

    public void setAutoConvertible(boolean flag) {
        this.autoConvertible = flag;
    }

    public boolean isAutoConvertible() {
        return autoConvertible;
    }

    public int energy() {
        return energy;
    }

    public boolean isFood() {
        return isFood;
    }

    @Override
    public boolean hasSound() {
        return sound != null;
    }

    @Override
    public URL sound() {
        return sound;
    }

    @Override
    public boolean hasPicture() {
        return picture != null;
    }

    @Override
    public URL picture() {
        return picture;
    }

    public void setSound(URL url) {
        this.sound = url;
    }

    public void setPicture(URL url) {
        this.picture = url;
    }

    public void setProperty(String name, Object value) {
        this.properties.put(name, value);
    }

    public Object getProperty(String name) {
        return this.properties.get(name);
    }

}
