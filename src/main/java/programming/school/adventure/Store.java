package programming.school.adventure;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Store implements IPlaceExtension {

  private List<Thing> storeInventory = new ArrayList<>();

  public void addThing(Thing t) {
    storeInventory.add(t);
  }
  
  @Override
  public String description() {
    StringBuilder desc = new StringBuilder();
    desc.append("Store is selling: ");
    String prefix = "";
    for ( Thing t: storeInventory ) {
      desc.append(prefix).append(t.name());
      prefix = ",  ";
    }
    return desc.toString();
  }
  
  @Override
  public Thing findThing(String name) {
    for ( Thing t: storeInventory ) {
      if ( t.name().equals(name) ) 
        return t;
    }
    return null;
  }
  
  @Override
  public boolean runCommand(Player player, String command, String argument) {
    switch (command) {
    case "buy":
      Iterator<Thing> it = storeInventory.iterator();
      boolean wasThere = false;
      while (it.hasNext()) {
        Thing t = it.next();
        if (t.name().equals(argument)) {
          wasThere = true;
          if (player.money() < t.cost()) {
            player.out().println("You do not have enough currency.");
          } else {
            player.pay(t.cost());
            player.addThing(t);
            it.remove();
            player.out().println("You bought " + t.name() + " for " + player.describeCost(t.cost()) + ".");
          }
        }
      }
      if (!wasThere)
        player.out().println("Store does not have " + argument);
      return true;

    case "sell":
      Thing t = player.findInInventory(argument);
      if (t == null)
        player.out().println("You don't have " + argument);
      else {
        player.removeThing(t);
        storeInventory.add(t);
        player.earn(t.cost());
        player.out().println("You sold " + t.name() + " for " + player.describeCost(t.cost()) + ".");
      }
      return true;
    default:
      return false;
    }
  }

}
