package programming.school.adventure;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class Place {

  private Random rnd = new Random();
  
  private static List<Place> allPlaces = new ArrayList<>();

  private final String description;

  private final Map<String, Place> directionsMap = new LinkedHashMap<>();

  private final List<Thing> things = new ArrayList<>();
  private final List<Creature> creatures = new ArrayList<>();

  public Place(final String longDescription) {
    this.description = longDescription;
    allPlaces.add(this);
  }

  public String things() {
    StringBuilder sb = new StringBuilder();
    String prefix = "";
    for (Thing d : things) {
      sb.append(prefix).append(d.name());
      prefix = ", ";
    }
    return sb.toString();
  }

  public void moveCreatureRandomly(Creature c) {
    if  ( creatures.contains(c) ) {
      creatures.remove(c);
      String[] directions = directionsMap.keySet().toArray(new String[0]);
      String chosenDirection = directions[rnd.nextInt(directions.length)];
      Place newPlace = directionsMap.get(chosenDirection);
      newPlace.addCreature(c);
    }
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

  public Place findDirection(final String direction) {
    return directionsMap.get(direction);
  }

  public void removeThing(final Thing t) {
    things.remove(t);
  }

  public void addThing(final Thing t) {
    if (!things.contains(t))
      things.add(t);
  }

  public void removeCreature(final Creature c) {
    creatures.remove(c);
  }

  public Creature[] creatures() {
    return creatures.toArray(new Creature[creatures.size()]);
  }

  public boolean hasCreature(Creature c) {
    return creatures.contains(c);
  }

  public void addCreature(final Creature c) {
    if (!creatures.contains(c))
      creatures.add(c);
  }

  public Creature findCreature(String creatureName) {
    for (Creature c : creatures) {
      if (c.name().equals(creatureName))
        return c;
    }
    return null;
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
