package programming.school.adventure;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Player {

  private final IOutput out;
  private final Random rnd = new Random();

  private int money = 0;
  private int energy = 100;
  private int energyDecrease =  1;
  
  private final String name;
  private Place place;
  private final List<Thing> inventory = new ArrayList<>();
  private PlayerState state = PlayerState.NORMAL;
  private List<String> attributes = new ArrayList<>();
  private Map<String, Integer> counters = new HashMap<>();
  
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
      out.println("Unknown destination. Valid destinations are: "
                  + place().directions());
    } else {
      if (game.canPlayerMove(this, place, newPlace, out)) {
        this.place = newPlace;
      }
    }
  }

  public void setAttribute(String att) {
    if (!attributes.contains(att))
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

  public String describeCost(int cost) {
    return game.currencyDescription(cost);
  }
  
  public boolean carries(final Thing t) {
    return inventory.contains(t);
  }

  public void die() { 
    setState(PlayerState.DEAD);
  }
  
  public void win() {
    setState(PlayerState.WIN);
  }
  
  void setState(final PlayerState s) {
    this.state = s;
  }

  public void pay(int cost) {
    money -= cost;
  }

  public void earn(int cost) {
    money += cost;
  }

  public int money() {
    return money;
  }

  public int energy() { 
    return energy;
  }
  
  public void changeEnergy(int diff) {
    energy += diff;
    if ( energy > 100 )
      energy = 100;
  }
  public void setCounter(String x, int value) {
    counters.put(x, value);
  }
  
  public void changeCounterBy(String x, int howMuch) {
    int currentValue = counter(x);
    setCounter(x, currentValue + howMuch);
  }
  
  public int counter(String x) {
    if ( counters.containsKey(x))
      return counters.get(x);
    else
      return 0;
  }
  
  public void drop(final Thing t) {
    inventory.remove(t);
    place.addThing(t);
  }

  private IExaminable findExaminable(final String name) {
    IExaminable t = place.findThing(name);
    if (t == null) {
      t = findInInventory(name);
    }
    if (t == null) {
      t = place.findCreature(name);
    }
    if (t == null) {
      t = place.findInExtensions(name);
    }
    return t;
  }

  public Thing findInInventory(final String name) {
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
      out.println("You dropped " + thing.name() + ".");
    }
  }

  public void eat(String name) {
    Thing thing = place.findThing(name);
    if ( thing == null )  {
      out.println("I can't see " + name + " here.");
    } else if ( !thing.isFood() ) {
      out.println("You can't eat " + name + ". It's not a food.");
    } else {
      place.removeThing(thing);
      changeEnergy(thing.energy());
      out.println("You ate " + name + ". Your energy level is " + energy + "%.");
    }
  }
  
  // Takes an object from a room. Returns true if succesful.
  public void take(String name) {
    Thing thing = place.findThing(name);
    if (thing == null) {
      out.println("You can't take this. Valid things to take are: "
                  + place().things());
    } else {
      inventory.add(thing);
      place.removeThing(thing);
      game.thingAdded(this, thing, out);
      out.println("You took " + thing.name() + ".");
    }
  }

  public void dieCommand() {
    out.println("You kill yourself!");
    die();
  }

  public void inventoryDescription() {
    out.println("You carry: " + OutUtil.inventoryDescription(inventory));
    out.println("You have " + game.currencyDescription(money));
    out.println("Your energy level is " + energy + "%.");
  }

  public void examine(final String argument) {
    IExaminable t = findExaminable(argument);
    if (t == null) {
      out.println("I can't see " + argument + " here.");
    } else {
      String desc = t.description();
      if (desc == null) {
        out.println("There is nothing special about the " + argument);
      } else {
        out.println(desc);
      }
      if (t instanceof Thing) {
        Thing tt = (Thing) t;
        if (tt.cost() > 0) {
          out.println("Its value is " + game.currencyDescription(tt.cost())
                      + ".");
        }
      }
    }
  }

  public void help() {
    out.println("Valid commands are 'go', 'take', 'examine', 'drop', 'die', 'eat', 'inventory'\n");
  }

  public void runCommand(final String cmd, final String argument) {
    switch (cmd) {
    case "go":
      go(argument);
      break;
    case "take":
      take(argument);
      break;
    case "examine":
      examine(argument);
      break;
    case "drop":
      drop(argument);
      break;
    case "die":
      dieCommand();
      break;
    case "inventory":
      inventoryDescription();
      break;
    case "eat":
      eat(argument);
      break;
    default:
      if (!place.runExtensionCommand(this, cmd, argument)) {
        help();
      }
      break;
    }
  }

  public IOutput out() {
    return out;
  }

  public void addThing(Thing t) {
    inventory.add(t);
  }

  public void removeThing(Thing t) {
    inventory.remove(t);
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
    game.initializePlayer(this);
    out.println("Welcome, " + name() + "!\n");
    out.println(game.introductionText());
  }

  private Place lastDescribedPlace = null;

  public void describeCurrentPlace() {
    boolean needsToRedescribePlace = (lastDescribedPlace != place);
    this.lastDescribedPlace = place;

    if (needsToRedescribePlace) {
      OutUtil.separate(out);
      if (out.supportsImages() && place.hasPicture()) {
        URL resource = place.picture();
        out.image(resource);
      }
      if (out.supportsSound() && place.hasSound()) {
        URL resource = place.sound();
        out.sound(resource);
      }
      place.describeExtensions(out);
      OutUtil.describePlace(out, place);
    }
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

  private void evaluateEngineState(IOutput out) {
    Iterator<Thing> it = inventory.iterator();
    while (it.hasNext()) {
      Thing t = it.next();
      if (t.isAutoConvertible()) {
        this.money += t.cost();
        it.remove();
      }
    }
    energy-=energyDecrease;
    if ( energy() <= 0 ) {
      out.println("You ran out of energy. You died.");
      die();
    }
  }

  public void setEnergyMechanics(int energyLevel, int energyDecrease) {
    this.energy = energyDecrease;
    this.energyDecrease = energyDecrease;
  }
  
  public void newCommand(String text) {
    processText(game, text);
    evaluateEngineState(out);
    if ( state() == PlayerState.DEAD )
      return;
    game.evaluateState(this, out);
    List<Object[]> placeCreaturePairs = new ArrayList<>();
    for (Place place : Place.allPlaces()) {
      for (Creature c : place.creatures()) {
        placeCreaturePairs.add(new Object[] { place, c });
      }
    }
    for (Object[] o : placeCreaturePairs) {
      game.creatureAction(this, (Creature) o[1], (Place) o[0], out);
    }
  }

}
