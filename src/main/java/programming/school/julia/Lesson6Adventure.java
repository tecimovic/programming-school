package programming.school.julia;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import programming.school.adventure.Place;
import programming.school.adventure.Player;
import programming.school.adventure.PlayerState;
import programming.school.adventure.Thing;

public class Lesson6Adventure {

  private final List<Place> places = new ArrayList<>();
  private final Player player;
  // Create places
  private final Place forest = new Place("You are in a beautiful forest. There are trees all around.");
  private final Place castle = new Place(
      "You are inside the walls of a medieval castle. It has a lot of tall towers and is very beautiful.");
  private final Place armory = new Place("Armory is where the weapons are. There is all kind of weapons here.");
  private final Place forehead = new Place(
      "daddys forhead is shining with treasures. There are treasures of all the 5 senses in here.");
  private final Place nosehole = new Place(
      "You are in a dark dangerous nosehole. There is something dangerous lurking in the corner.");
  private final Place eyeball = new Place("you are walking through daddys eyeball. eww.");

  // Create things
  private final Thing sword = new Thing("sword");
  private final Thing key = new Thing("key");
  private final Thing treasure = new Thing("treasure");
  private final Thing eyelash = new Thing("eyelash");

  public Lesson6Adventure() {

    // Add places
    places.add(forest);
    places.add(castle);
    places.add(forehead);
    places.add(nosehole);
    places.add(armory);

    // Link places
    forest.addDirection("north", castle);
    forest.addDirection("south", nosehole);
    forest.addDirection("east", eyeball);

    nosehole.addDirection("out", forest);

    castle.addDirection("south", forest);
    castle.addDirection("upstairs", forehead);
    castle.addDirection("downstairs", armory);

    forehead.addDirection("downstairs", castle);

    armory.addDirection("upstairs", castle);

    eyeball.addDirection("west", forest);

    // Add objects
    armory.addThing(sword);
    nosehole.addThing(key);
    forehead.addThing(treasure);
    eyeball.addThing(eyelash);

    // Initialize a player
    player = new Player("knight spitball", forest);
  }

  private void evaluateState(final PrintStream out) {
    if (player.carries(treasure) && !player.carries(key)) {
      out.println("You don't have the key to open the treasure!");
      player.drop(treasure);
    } else if (player.carries(treasure) && player.carries(key)) {
      if (player.carries(eyelash)) {
        out.println("You got the treasure!!!");
        player.setState(PlayerState.WIN);
      } else {

        out.println("the treasure turns into an eyeball and you die");
        player.setState(PlayerState.DEAD);
      }
    } else if (player.isIn(nosehole) && !player.carries(sword)) {
      out.println("You got attacked by a booger. You have no weapons. booger eats you....");
      player.setState(PlayerState.DEAD);
    } else if (player.isIn(nosehole) && player.carries(sword)) {
      out.println("You got attacked by a booger, but you have a sword, so you fight it off.");

    }
  }

  public void play(final Scanner in, final PrintStream out) {
    out.println("Welcome, " + player.name() + "! You need to retrieve the treasure to win this game.\n\n");
    while (player.state() == PlayerState.NORMAL) {
      out.println(player.place().visit());
      out.println("You carry: " + player.inventoryDescription());
      out.println("You can go to: " + player.place().directions());
      out.println("\nWhat would you like to do?\n>");
      String text = in.nextLine();

      String[] commands = text.split("\\s+");

      if (commands.length != 2) {
        player.help(out);
        continue;
      }

      player.runCommand(out, commands[0], commands[1]);
      evaluateState(out);
    }

    if (player.state() == PlayerState.DEAD) {
      out.println("\nYou died. Game over.");
    } else if (player.state() == PlayerState.WIN) {
      out.println("\nYou win! You got the treasure! You live happily ever after!");
    }
  }

  public static void main(final String[] args) {
    Lesson6Adventure g = new Lesson6Adventure();
    try (Scanner s = new Scanner(System.in)) {
      g.play(s, System.out);
    }
  }

}
