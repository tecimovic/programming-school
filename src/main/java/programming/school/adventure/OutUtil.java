package programming.school.adventure;

import java.util.List;
import java.util.Set;

public class OutUtil {
  public static void separate(IOutput out) {
    out.println("\n-----------------------------------------------------------------");
  }

  public static void describePlace(IOutput out, Place place) {
    out.println(place.description());
    out.println();
    out.println(creatureInventory(place));
    out.println();
    out.println("You see: " + inventoryDescription(place.inventory()));
    out.println("You can go: " + directionDescription(place.directions()));
  }

  private static String creatureInventory(Place place) {
    StringBuilder sb = new StringBuilder();
    Creature[] creaturesHere = place.creatures();
    if ( creaturesHere.length == 0 ) {
      sb.append("There is nobody else here.");
    } else if ( creaturesHere.length == 1 ) {
      sb.append("There is " + creaturesHere[0].name() + " here.");
    } else {
      sb.append("There are ");
      for ( int i=0; i<creaturesHere.length; i++ ) {
        if ( i == creaturesHere.length-1 ) {
          sb.append(" and ");
        } else if ( i > 0 ) {
          sb.append(", ");
        }
        sb.append(creaturesHere[i].name());
      }
      sb.append(" here.");
    }
    return sb.toString();
  }

  public static String inventoryDescription(final List<Thing> list) {
    if (list.size() == 0)
      return "nothing.";
  
    StringBuilder sb = new StringBuilder();
    String prefix = "";
    for (Thing t : list) {
      sb.append(prefix).append(t.name());
      prefix = ", ";
    }
    sb.append(".");
  
    return sb.toString();
  }

  private static String directionDescription(final Set<String> directions) {
    StringBuilder sb = new StringBuilder();
    String prefix = "";
    for (String d : directions) {
      sb.append(prefix).append(d);
      prefix = ", ";
    }
    return sb.toString();
  }

}
