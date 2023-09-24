package programming.school.adventure;

import java.net.URL;

public class Creature implements IExaminable {

    private String name, description;
    private Place place = null;

    private URL picture = null;
    private URL sound = null;

    public Creature(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String name() {
        return name;
    }

    public String description() {
        return description;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public Place place() {
        return place;
    }

    public void setPicture(URL url) {
        this.picture = url;
    }

    public boolean hasPicture() {
        return picture != null;
    }

    public URL picture() {
        return picture;
    }

    public void setSound(URL url) {
        this.sound = url;
    }

    public boolean hasSound() {
        return sound != null;
    }

    public URL sound() {
        return sound;
    }

}
