package programming.school.dylan;

import java.io.PrintStream;

import programming.school.adventure.IAdventureGame;
import programming.school.adventure.Place;
import programming.school.adventure.Player;
import programming.school.adventure.PlayerState;
import programming.school.adventure.Thing;

public class Lesson6Adventure implements IAdventureGame {

  // Create places
  private final Place forest = new Place("You are in a beautiful forest. There are trees all around.");
  private final Place castle = new Place(
      "You are inside the walls of a medieval castle. It has a lot of tall towers and is very beautiful.");
  private final Place armory = new Place("Armory is where the weapons are. There is all kind of weapons here.");
  private final Place treasureRoom = new Place(
      "Treasure room is shining with treasures. There are treasures of sculptures made by kids in here.");
  private final Place cave = new Place(
      "You are in a dark dangerous cave. There is something dangerous lurking in the corner.");
  private final Place wildwest = new Place(
      "You are in the Wild West. Collect 5 saddles to get extra points at the end of the game. Don't get run over by a horse.");
  private final Place wildwestsaloon = new Place(
      "You are in the craziest place in Houston. Find a saddle on the floor. 1 saddle found.");
  private final Place wildwesthorseparkinglot = new Place("This is the city's largest parking lot.");
  private final Place wildwestpetstore = new Place("A pet store in the south of the city.");
  private final Place wildwesthorsegraveyard = new Place("This city has a graveyard for horses. Find one saddle on the floor. 1 saddle found.");
  private final Place wildwestresearchbase = new Place("Research base.");

  // Create things
  private final Thing sword = new Thing("sword");
  private final Thing key = new Thing("key");
  private final Thing treasure = new Thing("treasure");
  private final Thing saloonsaddle = new Thing("saddle");
  private final Thing horsegraveyardsaddle = new Thing("saddle");

  // Create Variables
  private int saddlebonuspoints = 0;

  public Lesson6Adventure() {

    // Link places
    forest.addDirection("north", castle);
    forest.addDirection("south", cave);
    forest.addDirection("west", wildwest);

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

    wildwestsaloon.addDirection("city_enterance", wildwest);
    wildwestsaloon.addDirection("horse_parking_lot", wildwesthorseparkinglot);

    wildwesthorsegraveyard.addDirection("city_enterance", wildwest);

    // Add objects
    armory.addThing(sword);
    cave.addThing(key);
    treasureRoom.addThing(treasure);
    wildwestsaloon.addThing(saloonsaddle);
    wildwesthorsegraveyard.addThing(horsegraveyardsaddle);
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
    return "You got the treasure! You live happily ever after! You have collected " + saddlebonuspoints + "/5 saddles.";
  }

  @Override
  public void thingAdded(Player player, Thing t) {
    if(t == saloonsaddle) saddlebonuspoints ++;
    if(t == horsegraveyardsaddle) saddlebonuspoints ++;
  }

  @Override
  public void thingRemoved(Player player, Thing t) {
    if(t == saloonsaddle) saddlebonuspoints --;
    if(t == horsegraveyardsaddle) saddlebonuspoints --;
  }


  @Override
  public void evaluateState(final Player player, final PrintStream out) {
    if (player.carries(treasure) && !player.carries(key)) {
      out.println("You don't have the key to open the treasure!");
      player.drop(treasure);
    } else if (player.carries(treasure) && player.carries(key)) {
      out.println("You got the treasure!!!");
      player.setState(PlayerState.WIN);
    } else if (player.isIn(cave) && !player.carries(sword)) {
      out.println("You got attacked by a dragon. You have no weapons. Dragon eats you....");
      player.setState(PlayerState.DEAD);
    } else if (player.isIn(cave) && player.carries(sword)) {
      out.println("You got attached by a dragon, but you have a sword, so you fight it off.");
    } else if (player.isIn(wildwesthorseparkinglot)) {
      out.println("You see a saddle... But then you get run over by a horse! You died.");
      player.setState(PlayerState.DEAD);
    } else if (player.isIn(wildwestpetstore)) {
      out.println("A horse in the pet store jumped on you. You died.");
      player.setState(PlayerState.DEAD);
    } else if (player.isIn(wildwestresearchbase)) {
      out.println("Who knew that the wild west had research bases? You see a beaker that says Horsevirus. The Horsevirus jumps on you. You die.");
      player.setState(PlayerState.DEAD);
    }
  }

  public static void main(final String[] args) {
    Player.start(new Lesson6Adventure(), System.in, System.out);
  }

}
