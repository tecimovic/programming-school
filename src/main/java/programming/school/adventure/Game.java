package programming.school.adventure;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {

  private final List<Place> places = new ArrayList<>();
  private final Player player;
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

  public Game() {

    // Add places
    places.add(forest);
    places.add(castle);
    places.add(treasureRoom);
    places.add(cave);
    places.add(armory);



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

    // Initialize a player
    player = new Player("knight Poldi", forest);
  }

  private void evaluateState(final PrintStream out) {
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

  public void play(final Scanner in, final PrintStream out) {
    out.println("Welcome, " + player.name() + "! You need to retrieve the treasure to win this game.\n\n");
    while(player.state() == PlayerState.NORMAL) {
      out.println(player.place().visit());
      out.println("You carry: " + player.inventoryDescription());
      out.println("You can go to: " + player.place().directions());
      out.println("\nWhat would you like to do?\n>");
      String text = in.nextLine();

      String[] commands = text.split("\\s+");

      if ( commands.length != 2 ) {
        player.help(out);
        continue;
      }

      player.runCommand(out, commands[0], commands[1]);
      evaluateState(out);
    }

    if ( player.state() == PlayerState.DEAD ) {
      out.println("\nYou died. Game over.");
    } else if ( player.state() == PlayerState.WIN ) {
      out.println("\nYou win! You got the treasure! You live happily ever after!");
    }
  }
}
