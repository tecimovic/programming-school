package programming.school.adventure;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Place {

  private final String description;

  private final Map<String, Place> directionsMap = new LinkedHashMap<>();

  private final List<Thing> things = new ArrayList<>();

  public Place(final String longDescription) {
    this.description = longDescription;
  }

  public String things() {
    StringBuilder sb = new StringBuilder();
    String prefix = "";
    for ( Thing d: things ) {
      sb.append(prefix).append(d.name());
      prefix = ", ";
    }
    return sb.toString();
  }

  public String directions() {
    StringBuilder sb = new StringBuilder();
    String prefix = "";
    for ( String d: directionsMap.keySet() ) {
      sb.append(prefix).append(d);
      prefix = ", ";
    }
    return sb.toString();
  }

  public void addDirection(final String direction, final Place place) {
    directionsMap.put(direction,  place);
  }

  public void addThing(final Thing t) {
    things.add(t);
  }

  public Place findDirection(final String direction) {
    return directionsMap.get(direction);
  }

  public void removeThing(final Thing t) {
    things.remove(t);
  }

  public Thing findThing(final String thingName) {
    for ( Thing t: things ) {
      if ( t.name().equals(thingName) ) {
        return t;
      }
    }
    return null;
  }

  public String visit() {
    StringBuilder sb = new StringBuilder();
    sb.append(description);
    sb.append("\n");
    if ( things.size() == 0 ) {
      sb.append("You see nothing here.\n");
    } else {
      sb.append("You see: " + things() + "\n");
    }
    return sb.toString();
  }
}
