package programming.school.adventure;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Player {

  private final IOutput out;
  private final Random rnd = new Random();
  
  private final String name;
  private Place place;
  private final List<Thing> inventory = new ArrayList<>();
  private PlayerState state = PlayerState.NORMAL;
  private List<String> attributes = new ArrayList<>();
  private IAdventureGame game;
  
  public Player(final IOutput out, IAdventureGame game) {
    this.out = out;
    this.name = game.playerName();
    this.place = game.startingPlace();
    this.game = game;
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

  public int random(int n) {
    return rnd.nextInt(n);
  }
  
  // Makes player go to a destination with a given name. Returns true if
  // succesful.
  public void go(final String name) {
    Place newPlace = place.findDirection(name);
    if (newPlace == null) {
      out.println("Unknown destination. Valid destinations are: " + place().directions());
    } else {
      if ( game.canPlayerMove(this, place, newPlace, out)) {
        this.place = newPlace;
      }
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

  private IExaminable findInInventoryOrRoom(final String name) {
    IExaminable t = place.findThing(name);
    if (t == null) {
      t = findInInventory(name);
    }
    if ( t == null ) {
      t = place.findCreature(name);
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

  public void drop(final String name) {
    Thing thing = findInInventory(name);
    if (thing == null) {
      out.println("You can't drop this.");
    } else {
      inventory.remove(thing);
      place.addThing(thing);
      game.thingRemoved(this, thing, out);
    }
  }

  // Takes an object from a room. Returns true if succesful.
  public void take(String name) {
    Thing thing = place.findThing(name);
    if (thing == null) {
      out.println("You can't take this. Valid things to take are: " + place().things());
    } else {
      inventory.add(thing);
      place.removeThing(thing);
      game.thingAdded(this, thing, out);
    }
  }

  public void die() {
    out.println("You kill yourself!");
    setState(PlayerState.DEAD);
  }

  public void inventory() {
    out.println("You carry: " + OutUtil.inventoryDescription(inventory));
  }

  public void examine(final String argument) {
    IExaminable t = findInInventoryOrRoom(argument);
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

  public void runCommand(final String cmd, final String argument) {
    switch (cmd) {
    case "go": go(argument); break;
    case "take": take(argument); break;
    case "examine": examine(argument); break;
    case "drop": drop(argument); break;
    case "die": die(); break;
    case "inventory": inventory(); break;
    default: help(); break;
    }
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
    runCommand(cmd, rest);
  }

  public void intro() {
    out.println("Welcome, " + name() + "!\n");
    out.println(game.introductionText());    
  }
  
  public void describeCurrentPlace() {
    OutUtil.separate(out);
    if ( out.supportsImages() && place.hasPicture() ) {
      URL resource = place.picture();
      out.image(resource);
    }
    if ( out.supportsSound() && place.hasSound() ) {
      URL resource = place.sound();
      out.sound(resource);
    }
    OutUtil.describePlace(out, place);
  }
  
  public boolean isGameOver() {
    return state != PlayerState.NORMAL;
  }
  
  public void gameOver() {
    if (state() == PlayerState.DEAD) {
      out.println("You are dead. Game over.");
    } else if (state() == PlayerState.WIN) {
      out.println(game.victoryText());
    }
  }
  
  public void newCommand(String text) {
    processText(game, text);
    game.evaluateState(this, out);
    List<Object[]> placeCreaturePairs = new ArrayList<>();
    for ( Place place: Place.allPlaces() ) {
      for  ( Creature c: place.creatures() ) {
        placeCreaturePairs.add(new Object[] {place, c});
      }
    }
    for ( Object[] o: placeCreaturePairs) {
      game.creatureAction(this, (Creature)o[1], (Place)o[0], out);
    }    
  }
  

}
