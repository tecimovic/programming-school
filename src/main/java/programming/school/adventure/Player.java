package programming.school.adventure;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Player {

  private final PrintStream out;
  private final Scanner in;

  private final String name;
  private Place place;
  private final List<Thing> inventory = new ArrayList<>();
  private PlayerState state = PlayerState.NORMAL;
  private List<String> attributes = new ArrayList<>();

  public Player(final PrintStream out, final Scanner in, final String name, final Place startingPlace) {
    this.out = out;
    this.in = in;
    this.name = name;
    this.place = startingPlace;
  }

  public PlayerState state() {
    return state;
  }

  public Place place() {
    return place;
  }

  public String name() {
    return name;
  }

  // Makes player go to a destination with a given name. Returns true if
  // succesful.
  public void go(final String name) {
    Place newPlace = place.findDirection(name);
    if (newPlace == null) {
      out.println("Unknown destination. Valid destinations are: " + place().directions());
    } else {
      this.place = newPlace;
    }
  }

  public void setAttribute(String att) {
    if ( !attributes.contains(att) )
      attributes.add(att);
  }

  public boolean hasAttribute(String att) {
    return attributes.contains(att);
  }

  public void clearAttribute(String att) {
    attributes.remove(att);
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

  private Thing findInInventoryOrRoom(final String name) {
    Thing t = place.findThing(name);
    if (t == null) {
      t = findInInventory(name);
    }
    return t;
  }

  private Thing findInInventory(final String name) {
    for (Thing t : inventory) {
      if (t.name().equals(name))
        return t;
    }
    return null;
  }

  public void drop(IAdventureGame game, final String name) {
    Thing thing = findInInventory(name);
    if (thing == null) {
      out.println("You can't drop this.");
    } else {
      inventory.remove(thing);
      place.addThing(thing);
      game.thingRemoved(this, thing);
    }
  }

  // Takes an object from a room. Returns true if succesful.
  public void take(IAdventureGame game, String name) {
    Thing thing = place.findThing(name);
    if (thing == null) {
      out.println("You can't take this. Valid things to take are: " + place().things());
    } else {
      inventory.add(thing);
      place.removeThing(thing);
      game.thingAdded(this, thing);
    }
  }

  public void die() {
    out.println("You kill yourself!");
    setState(PlayerState.DEAD);
  }

  public void inventory() {
    out.println("You carry: " + inventoryDescription(inventory));
  }

  public void examine(final String argument) {
    Thing t = findInInventoryOrRoom(argument);
    if (t == null) {
      out.println("I can't see " + argument + " here.");
    } else {
      String desc = t.description();
      if (desc == null) {
        out.println("There is nothing special about the " + argument);
      } else {
        out.println(desc);
      }
    }
  }

  public void help() {
    out.println("Valid commands are 'go', 'take', 'examine', 'drop', 'die', 'inventory'\n");
  }

  public void runCommand(IAdventureGame game, final String cmd, final String argument) {
    switch (cmd) {
    case "go": go(argument); break;
    case "take": take(game, argument); break;
    case "examine": examine(argument); break;
    case "drop": drop(game, argument); break;
    case "die": die(); break;
    case "inventory": inventory(); break;
    default: help(); break;
    }
  }

  public static String directionDescription(final Set<String> directions) {
    StringBuilder sb = new StringBuilder();
    String prefix = "";
    for (String d : directions) {
      sb.append(prefix).append(d);
      prefix = ", ";
    }
    return sb.toString();
  }

  private static String inventoryDescription(final List<Thing> list) {
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

  public void processText(IAdventureGame game, String line) {
    String l = line.trim();

    int space = l.indexOf(' ');
    String cmd;
    String rest;
    if (space == -1) {
      cmd = l;
      rest = "";
    } else {
      cmd = l.substring(0, space).trim();
      rest = l.substring(space + 1).trim();
    }
    runCommand(game, cmd, rest);
  }

  private void separate() {
    out.println("\n-----------------------------------------------------------------");
  }

  public void play(final IAdventureGame game) {
    out.println("Welcome, " + name() + "!\n");
    out.println(game.introductionText());

    while (state() == PlayerState.NORMAL) {
      separate();
      out.println(place().description());
      out.println();
      out.println("You see: " + inventoryDescription(place().inventory()));
      out.println("You can go: " + directionDescription(place().directions()));
      out.print("\nWhat would you like to do?\n> ");
      String text = in.nextLine();
      processText(game, text);
      game.evaluateState(this, out);
    }

    if (state() == PlayerState.DEAD) {
      out.println("You are dead. Game over.");
    } else if (state() == PlayerState.WIN) {
      out.println(game.victoryText());
    }
  }

  public static void start(final IAdventureGame game, final InputStream input, final PrintStream out) {
    try (Scanner in = new Scanner(input)) {
      Player player = new Player(out, in, game.playerName(), game.startingPlace());
      player.play(game);
    }
  }

}
