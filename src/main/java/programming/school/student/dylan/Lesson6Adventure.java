package programming.school.student.dylan;

import java.util.Random;

import programming.school.adventure.Creature;
import programming.school.adventure.IAdventureGame;
import programming.school.adventure.IOutput;
import programming.school.adventure.Place;
import programming.school.adventure.Player;
import programming.school.adventure.PlayerState;
import programming.school.adventure.Store;
import programming.school.adventure.Thing;
import programming.school.adventure.ui.GameUi;

public class Lesson6Adventure implements IAdventureGame {

  // Create places
  private final Place forest = new Place("You are in a scary forest. There are creepy trees all around.");
  private final Place castle = new Place(
      "You are inside the walls of a medieval castle. It has a lot of tall towers and is very beautiful.");
  private final Place armory = new Place("Armory is where the weapons are. There is all kind of weapons here.");
  private final Place treasureRoom = new Place(
      "Treasure room is shining with treasures. There are treasures of sculptures made by kids in here.");
  private final Place cave = new Place(
      "You are in a dark dangerous cave. There is something dangerous lurking in the corner.");
  private final Place wildwest = new Place(
      "You are in the Wild West. Collect 3 saddles to get extra points at the end of the game. Don't get run over by a horse.");
  private final Place wildwestsaloon = new Place(
      "You are in the craziest place in Houston. Find a saddle on the floor. 1 saddle found.");
  private final Place wildwesthorseparkinglot = new Place("This is the city's largest parking lot.");
  private final Place wildwestpetstore = new Place("A pet store in the south of the city.");
  private final Place wildwesthorsegraveyard = new Place(
      "This city has a graveyard for horses. Find one saddle on the floor. 1 saddle found.");
  private final Place wildwestresearchbase = new Place("Research base.");
  private final Place wildwestharbour = new Place(
      "Boats, big big big big big huge big gigantic boats. And a saddle. 1 saddle found.");
  private final Place wildwestbathroom = new Place("Nothing here. Except it smells bad.");
  private final Place wildwestmuseum = new Place("Horse museum");
  private final Place wishing_well = new Place("You see a wishing well. Maybe drop a coin?");
  private final Place hiddenroom = new Place("So... you did not die in the Horse Parking lot. 1 bonus point 4 U");
  private final Place store = new Place("Welcome to the store. What would you like to buy?");

  // Create things
  private final Thing sword = new Thing("sword", "A decently good sword.");
  private final Thing key = new Thing("key", "Unlocks the treasure.");
  private final Thing treasure = new Thing("treasure", "Pretty large for a treasure chest...");
  private final Thing saloonsaddle = new Thing("saddle",
      "One of the three saddles that you are supposed to bring to the castle. Found in the saloon.");
  private final Thing horsegraveyardsaddle = new Thing("saddle",
      "One of the three saddles that you are supposed to bring to the castle. Found in the horse graveyard.");
  private final Thing harboursaddle = new Thing("saddle",
      "One of the three saddles that you are supposed to bring to the castle. Found in the harbour.");
  private final Thing coin = new Thing("coin", "A normal coin. Worth 25 cents.");
  Thing roman_coin = new Thing("roman coin", "Worth a lot...");
  Thing fruit = new Thing("fruit", "Supafruit. Kills the walking tree.");

  // Create Creatures
  private final Creature WalkingTree = new Creature("Walking Tree",
      "It's a huge, walking tree that chases you wherever you go. If you travel 5 rooms with the tree, he will kill you.");

  // Create Variables
  private int saddlebonuspoints = 0;

  private Random rnd = new Random();

  public Lesson6Adventure() {

    // Pictures are more important than words

    forest.setPicture(getClass().getResource("forest.jpg"));
    castle.setPicture(getClass().getResource("castle.jpg"));
    armory.setPicture(getClass().getResource("armory.jpg"));
    treasureRoom.setPicture(getClass().getResource("treasure.jpg"));
    cave.setPicture(getClass().getResource("cave.jpg"));
    wishing_well.setPicture(getClass().getResource("wishingwell.jpg"));
    wildwest.setPicture(getClass().getResource("wildwest.jpg"));
    forest.setSound(getClass().getResource("thunder.wav"));
    wildwest.setSound(getClass().getResource("western.wav"));
    wildwestsaloon.setPicture(getClass().getResource("saloon.jpg"));
    wildwesthorseparkinglot.setPicture(getClass().getResource("horseparkinglot.jpg"));
    wildwesthorsegraveyard.setPicture(getClass().getResource("horsegraveyard.jpg"));
    wildwestharbour.setPicture(getClass().getResource("harbour.jpg"));
    wildwestbathroom.setPicture(getClass().getResource("bathroom.jpg"));

    // Link places
    forest.addDirection("north", castle);
    forest.addDirection("south", cave);
    forest.addDirection("west", wildwest);
    forest.addDirection("east", wishing_well);

    cave.addDirection("out", forest);

    castle.addDirection("south", forest);
    castle.addDirection("upstairs", treasureRoom);
    castle.addDirection("downstairs", armory);

    treasureRoom.addDirection("downstairs", castle);

    armory.addDirection("upstairs", castle);

    wildwest.addDirection("east", forest);
    wildwest.addDirection("saloon", wildwestsaloon);
    wildwest.addDirection("pet_store", wildwestpetstore);
    wildwest.addDirection("horse_graveyard", wildwesthorsegraveyard);
    wildwest.addDirection("research_base", wildwestresearchbase);
    wildwest.addDirection("harbour", wildwestharbour);

    wildwestsaloon.addDirection("city_entrance", wildwest);
    wildwestsaloon.addDirection("horse_parking_lot", wildwesthorseparkinglot);

    wildwesthorsegraveyard.addDirection("city_entrance", wildwest);

    wildwestharbour.addDirection("city_entrance", wildwest);
    wildwestharbour.addDirection("bathroom", wildwestbathroom);
    wildwestbathroom.addDirection("harbour", wildwestharbour);
    wildwestbathroom.addDirection("museum", wildwestmuseum);

    wishing_well.addDirection("west", forest);

    wildwesthorseparkinglot.addDirection("saloon", wildwestsaloon);
    wildwesthorseparkinglot.addDirection("hidden_room", hiddenroom);

    wildwestpetstore.addDirection("city_entrance", wildwest);

    wildwestresearchbase.addDirection("city_entrance", wildwest);

    wildwestmuseum.addDirection("bathroom", wildwestbathroom);

    hiddenroom.addDirection("horse_parking_lot", wildwesthorseparkinglot);

    forest.addDirection("store", store);

    store.addDirection("forest", forest);

    // Add objects
    armory.addThing(sword);
    cave.addThing(key);
    treasureRoom.addThing(treasure);
    wildwestsaloon.addThing(saloonsaddle);
    wildwesthorsegraveyard.addThing(horsegraveyardsaddle);
    wildwestharbour.addThing(harboursaddle);
    forest.addThing(coin);

    Store storeExtension = new Store();
    fruit.setCost(50000);
    Thing dylan = new Thing("dylan", "It's an extremely rare Dylan Action Figure!");
    dylan.setCost(20000);
    roman_coin.setCost(20000);
    Thing map = new Thing("map", "Map of the world.");
    map.setCost(200000);
    Thing bread = new Thing("bread", "A loaf of bread.");
    bread.setCost(20000);
    storeExtension.addThing(fruit);
    storeExtension.addThing(dylan);
    storeExtension.addThing(roman_coin);
    storeExtension.addThing(map);
    storeExtension.addThing(bread);

    Thing dollar = new Thing("100 dollar bill", "worth... a hundred dollars.");

    store.addExtension(storeExtension);
    forest.addThing(dollar);

    forest.addCreature(WalkingTree);
    // Turn objects into money
    dollar.setAutoConvertible(true);
    dollar.setCost(100000);

  }

  @Override
  public String playerName() {
    return "knight Guy";
  }

  @Override
  public Place startingPlace() {
    return forest;
  }

  @Override
  public String introductionText() {
    return "You need to retrieve the treasure to win this game.";
  }

  @Override
  public String victoryText() {
    return "You got the treasure! You live happily ever after! You have collected " + saddlebonuspoints + "/3 saddles.";
  }

  // Saddle bonus points ++
  @Override
  public void thingAdded(Player player, Thing t, IOutput out) {
    if (t == saloonsaddle)
      saddlebonuspoints++;
    if (t == horsegraveyardsaddle)
      saddlebonuspoints++;
    if (t == harboursaddle)
      saddlebonuspoints++;
  }

  // Saddle bonus points --
  @Override
  public void thingRemoved(Player player, Thing t, IOutput out) {
    if (t == saloonsaddle)
      saddlebonuspoints--;
    if (t == horsegraveyardsaddle)
      saddlebonuspoints--;
    if (t == harboursaddle)
      saddlebonuspoints--;
    if (t == coin && player.isIn(wishing_well)) {

      // Int x = rnd.nextInt(5);
      int x = rnd.nextInt(5);

      switch (x) {
        case 0:
          player.setAttribute("lucky");
          out.println("You have become the luckiest person in the world");
          break;
        case 1:
          player.setAttribute("nothing");
          out.println("Nothing happened. Better luck next time...");
          break;
        case 2:
          player.setAttribute("unlucky");
          out.println("YOU HAVE BECOME UNLUCKY. YOU MAY NOT ESCAPE...");
          break;
        case 3:
          player.setAttribute("lucky");
          out.println("You have become the luckiest person in the world");
          break;
        case 4:
          player.setAttribute("unlucky");
          out.println("YOU HAVE BECOME UNLUCKY. YOU MAY NOT ESCAPE...");
          break;
      }
    }
  }

  @Override
  public void creatureAction(Player player, Creature creature, Place place, IOutput out) {
    if (creature == WalkingTree) {
      place.removeCreature(WalkingTree);
      player.place().addCreature(WalkingTree);
      player.changeCounterBy("stuff", 1);
      if (player.counter("stuff") == 5) {
        player.setState(PlayerState.DEAD);
        out.println("The walking tree killed you. Game over.");
      } else if (player.place().hasCreature(WalkingTree) && player.carries(fruit)) {
        out.println("The walking tree tried to kill you, but he died because he ate the poisonous Supafruit.");
        player.place().removeCreature(WalkingTree);
      }
    }
  }

  // Be CAREFUL with my computer
  @Override
  public void evaluateState(final Player player, final IOutput out) {
    if (player.carries(treasure) && !player.carries(key)) {
      out.println("You don't have the key to open the treasure!");
      player.drop(treasure);
    } else if (player.carries(treasure) && player.carries(key)) {
      if (player.carries(roman_coin))
        out.println("You got the treasure!!!");
      player.setState(PlayerState.WIN);
    } else if (player.isIn(cave) && !player.carries(sword)) {
      out.println("You got attacked by a dragon. You have no weapons. Dragon eats you....");
      player.setState(PlayerState.DEAD);
    } else if (player.isIn(cave) && player.carries(sword)) {
      out.println("You got attacked by a dragon, but you have a sword, so you fight it off.");
    } else if (player.isIn(wildwesthorseparkinglot) && !player.hasAttribute("lucky")) {
      out.println("You see a saddle... But then you get run over by a horse! You died.");
      player.setState(PlayerState.DEAD);
    } else if (player.isIn(wildwestpetstore) && !player.hasAttribute("lucky")) {
      out.println("A horse in the pet store jumped on you. You died.");
      player.setState(PlayerState.DEAD);
    } else if (player.isIn(wildwestresearchbase) && !player.hasAttribute("lucky")) {
      out.println(
          "Who knew that the wild west had research bases? You see a beaker that says Horsevirus. The Horsevirus jumps on you. You die.");
      player.setState(PlayerState.DEAD);
    } else if (player.isIn(wildwestmuseum) && !player.hasAttribute("lucky")) {
      out.println("It turns out that it was a HORSE museum. A horse ran over you. You died.");
      player.setState(PlayerState.DEAD);
    }

  }

  public static void main(final String[] args) {
    new GameUi(new Lesson6Adventure()).start();
  }

}
