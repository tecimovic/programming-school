package programming.school.reference;

import java.io.PrintStream;

import programming.school.adventure.IAdventureGame;
import programming.school.adventure.Place;
import programming.school.adventure.Player;
import programming.school.adventure.PlayerState;
import programming.school.adventure.Thing;

public class Lesson6Adventure implements IAdventureGame {

  // Create places
  private final Place forest = new Place("You are in a beautiful forest. There are trees all around.");
  private final Place castle = new Place("You are inside the walls of a medieval castle. It has a lot of tall towers and is very beautiful.");
  private final Place armory = new Place("Armory is where the weapons are. There is all kind of weapons here.");
  private final Place treasureRoom = new Place("Treasure room is shining with treasures. There are treasures of all kids in here.");
  private final Place cave = new Place("You are in a dark dangerous cave. There is something dangerous lurking in the corner.");

  // Create things
  private final Thing sword = new Thing("sword");
  private final Thing key = new Thing("key");
  private final Thing treasure = new Thing("treasure");

  public Lesson6Adventure() {

    // Link places
    forest.addDirection("north", castle);
    forest.addDirection("south", cave);

    cave.addDirection("out", forest);

    castle.addDirection("south", forest);
    castle.addDirection("upstairs", treasureRoom);
    castle.addDirection("downstairs", armory);

    treasureRoom.addDirection("downstairs", castle);

    armory.addDirection("upstairs", castle);

    // Add objects
    armory.addThing(sword);
    cave.addThing(key);
    treasureRoom.addThing(treasure);

  }

  @Override
  public String playerName() {
    return "knight Poldi";
  }

  @Override
  public Place startingPlace() {
    return forest;
  }

  @Override
  public void evaluateState(final Player player, final PrintStream out) {
    if ( player.carries(treasure) && !player.carries(key) ) {
      out.println("You don't have the key to open the treasure!");
      player.drop(treasure);
    } else if ( player.carries(treasure) && player.carries(key)) {
      out.println("You got the treasure!!!");
      player.setState(PlayerState.WIN);
    } else if ( player.isIn(cave) && !player.carries(sword) ) {
      out.println("You got attacked by a dragon. You have no weapons. Dragon eats you....");
      player.setState(PlayerState.DEAD);
    } else if ( player.isIn(cave) && player.carries(sword) ) {
      out.println("You got attached by a dragon, but you have a showrd, so you fight it off.");
    }
  }

  public static void main(final String[] args) {
    Player.start(new Lesson6Adventure(), System.in, System.out);
  }

}
