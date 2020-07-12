package programming.school.adventure;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Player {

  private final String name;
  private Place place;
  private final List<Thing> inventory = new ArrayList<>();
  private PlayerState state = PlayerState.NORMAL;

  public Player(final String name,
                final Place startingPlace) {
    this.name = name;
    this.place = startingPlace;
  }

  public PlayerState state() { return state; }

  public Place place() { return place; }

  public String name() { return name; }

  // Makes player go to a destination with a given name. Returns true if succesful.
  public boolean go(final String name) {
    Place newPlace = place.findDirection(name);
    if ( newPlace == null )
      return false;
    else {
      this.place = newPlace;
      return true;
    }
  }

  public boolean isIn(final Place p) {
    return place == p;
  }

  public boolean carries(final Thing t) {
    return inventory.contains(t);
  }

  public void setState(final PlayerState s) {
    this.state = s;
  }

  public void drop(final Thing t) {
    inventory.remove(t);
    place.addThing(t);
  }

  private Thing findInInventory(final String name) {
    for ( Thing t: inventory ) {
      if ( t.name().equals(name) )
        return t;
    }
    return null;
  }

  public boolean drop(final String name) {
    Thing thing = findInInventory(name);
    if ( thing == null ) return false;
    inventory.remove(thing);
    place.addThing(thing);
    return true;
  }

  // Takes an object from a room. Returns true if succesful.
  public boolean take(final String name) {
    Thing thing = place.findThing(name);
    if ( thing == null ) return false;
    inventory.add(thing);
    place.removeThing(thing);
    return true;
  }

  public void help(final PrintStream out) {
    out.println("Valid commands are 'go' and 'take'\n");
  }

  public void runCommand(final PrintStream out, final String cmd, final String rest) {
    switch(cmd) {

    case "go":
      if ( !go(rest) ) {
        out.println("Unknown destination. Valid destinations are: " + place().directions());
      }
      return;

    case "take":
      if ( !take(rest) ) {
        out.println("You can't take this. Valid things to take are: " + place().things());
      }
      return;

    case "die":
      out.println("You kill yourself!");
      setState(PlayerState.DEAD);
      return;

    case "inventory":
      out.println("You carry: " + inventoryDescription(inventory));
      return;

    case "drop":
      if (!drop(rest) ) {
        out.println("You can't drop this.");
      }
      return;
    default:
      help(out);
      return;
    }
  }

  public static String directionDescription(final Set<String> directions) {
    StringBuilder sb = new StringBuilder();
    String prefix = "";
    for ( String d: directions ) {
      sb.append(prefix).append(d);
      prefix = ", ";
    }
    return sb.toString();
  }


  private static String inventoryDescription(final List<Thing> list) {
    if ( list.size() == 0 )
      return "nothing.";

    StringBuilder sb = new StringBuilder();
    String prefix = "";
    for ( Thing t: list ) {
      sb.append(prefix).append(t.name());
      prefix = ", ";
    }
    sb.append(".");

    return sb.toString();
  }

  public void processText(final PrintStream out, final String line) {
    String l = line.trim();

    int space = l.indexOf(' ');
    String cmd;
    String rest;
    if ( space == -1 ) {
      cmd = l;
      rest = "";
    } else {
      cmd = l.substring(0, space).trim();
      rest = l.substring(space+1).trim();
    }
    runCommand(out, cmd, rest);
  }

  private void separate(final PrintStream out) {
    out.println("-----------------------------------------------------------------");
  }

  public void play(final IAdventureGame game, final Scanner in, final PrintStream out) {
    out.println("Welcome, " + name() + "! You need to retrieve the treasure to win this game.");
    while(state() == PlayerState.NORMAL) {
      separate(out);
      out.println(place().description());
      out.println();
      out.println("You see: " + inventoryDescription(place().inventory()));
      out.println("You can go to: " + directionDescription(place().directions()));
      out.print("\nWhat would you like to do?\n> ");
      String text = in.nextLine();
      processText(out, text);
      game.evaluateState(this, out);
    }

    if ( state() == PlayerState.DEAD ) {
      out.println("\nYou are dead. Game over.");
    } else if ( state() == PlayerState.WIN ) {
      out.println("\nYou win! You got the treasure! You live happily ever after!");
    }
  }

  public static void start(final IAdventureGame game, final InputStream input, final PrintStream out) {
    Player player = new Player(game.playerName(), game.startingPlace());
    try (Scanner in = new Scanner(input)) {
      player.play(game, in, out);
    }
  }


}
