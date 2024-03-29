package programming.school.adventure;

import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class Place {

    private Random rnd = new Random();

    private static List<Place> allPlaces = new ArrayList<>();

    private List<IPlaceExtension> extensions = new ArrayList<>();

    private final String description;

    private final Map<String, Place> directionsMap = new LinkedHashMap<>();
    private final Map<String, Thing> directionKeys = new LinkedHashMap<>();

    private final List<Thing> things = new ArrayList<>();
    private final List<Creature> creatures = new ArrayList<>();

    private URL picture = null;
    private URL sound = null;

    public Place(final String longDescription) {
        this.description = longDescription;
        allPlaces.add(this);
    }

    public List<Thing> things() {
        return things;
    }

    public void moveCreatureRandomly(Creature c) {
        if (creatures.contains(c)) {
            creatures.remove(c);
            String[] directions = directionsMap.keySet().toArray(new String[0]);
            String chosenDirection = directions[rnd.nextInt(directions.length)];
            Place newPlace = directionsMap.get(chosenDirection);
            newPlace.addCreature(c);
        }
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

    public static List<Place> allPlaces() {
        return allPlaces;
    }

    public Set<String> directions() {
        return directionsMap.keySet();
    }

    public void addDirection(final String direction, final Place place) {
        directionsMap.put(direction, place);
    }

    public void addLockedDirection(final String direction, final Place place, Thing keyThing) {
        directionsMap.put(direction, place);
        directionKeys.put(direction, keyThing);
    }

    public Thing findInExtensions(String name) {
        for (IPlaceExtension ext : extensions) {
            Thing t = ext.findThing(name);
            if (t != null)
                return t;
        }
        return null;
    }

    public List<String> extensionCommands() {
        List<String> cmds = new ArrayList<>();
        for (IPlaceExtension ext : extensions) {
            for (String s : ext.validCommands()) {
                cmds.add(s);
            }
        }
        return cmds;
    }

    public boolean runExtensionCommand(Player player, String cmd, String arg) {
        for (IPlaceExtension ext : extensions) {
            if (ext.runCommand(player, cmd, arg))
                return true;
        }
        return false;
    }

    public void describeExtensions(IOutput out) {
        for (IPlaceExtension ext : extensions) {
            out.println(ext.description());
        }
    }

    public Place findDirection(final String direction) {
        return directionsMap.get(direction);
    }

    public Thing findDirectionKey(final String direction) {
        return directionKeys.get(direction);
    }

    public void removeThing(final Thing t) {
        things.remove(t);
    }

    public void addThing(final Thing t) {
        if (!things.contains(t))
            things.add(t);
    }

    public void addExtension(IPlaceExtension ext) {
        if (!extensions.contains(ext))
            extensions.add(ext);
    }

    public void removeCreature(final Creature c) {
        creatures.remove(c);
        c.setPlace(null);
    }

    public Creature[] creatures() {
        return creatures.toArray(new Creature[creatures.size()]);
    }

    public boolean hasCreature(Creature c) {
        return creatures.contains(c);
    }

    public void addCreature(final Creature c) {
        if (!creatures.contains(c)) {
            creatures.add(c);
            c.setPlace(this);
        }
    }

    public Creature findCreature(String creatureName) {
        for (Creature c : creatures) {
            if (c.name().equals(creatureName))
                return c;
        }
        return null;
    }

    public boolean hasThings() {
        return !things.isEmpty();
    }

    public Thing findThing(final String thingName) {
        for (Thing t : things) {
            if (t.name().equals(thingName)) {
                return t;
            }
        }
        return null;
    }

    public String description() {
        return description;
    }

    public List<Thing> inventory() {
        return things;
    }

}
