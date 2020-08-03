package programming.school.student.dylan;

import programming.school.adventure.IAdventureGame;
import programming.school.adventure.IOutput;
import programming.school.adventure.Place;
import programming.school.adventure.Player;
import programming.school.adventure.ui.GameUi;

public class Lesson7NewAdventure implements IAdventureGame {

  // Create places
  private final Place your_room = new Place("You are in a cruise. You are in your room.");
  private final Place hallway = new Place("You are in the main hallway of the cruise.");
  private final Place pool = new Place("You see a pool. About 10ft deep.");
  private final Place waterslides = new Place("You see 3 waterslides. They all lead into the pool.");
  private final Place restaraunt = new Place("buy food here.");

  public Lesson7NewAdventure() {
      //Link places
  your_room.addDirection("hallway", hallway);

  hallway.addDirection("Room 201", your_room);
  hallway.addDirection("north", pool);
  hallway.addDirection("south", restaraunt);

  pool.addDirection("south", hallway);
  pool.addDirection("upstairs", waterslides);

  waterslides.addDirection("downstairs", pool);
  }

  @Override
  public String playerName() {
    return "qwertyhut";
  }

  @Override
  public Place startingPlace() {
    return your_room;
  }

  @Override
  public String introductionText() {
    return "Welcome to the survival game of Villabibadushi. I hope u enjoYYYYYYYYYYYg";
  }

  @Override
  public String victoryText() {
    return "You are happy!";
  }

  @Override
  public void evaluateState(final Player player, final IOutput out) {
  }

  public static void main(final String[] args) {
    new GameUi(new Lesson7NewAdventure()).start();
  }

}
