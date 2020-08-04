package programming.school.student.dylan;

import programming.school.adventure.IAdventureGame;
import programming.school.adventure.IOutput;
import programming.school.adventure.Place;
import programming.school.adventure.Player;
import programming.school.adventure.ui.GameUi;

public class Lesson7NewAdventure implements IAdventureGame {

  // Create places
  private final Place your_room = new Place("You are in a cruise, and you are in your room.");
  private final Place hallway = new Place("You are in the main hallway of the cruise.");
  private final Place pool_room = new Place("You see a pool. About 10ft deep.");
  private final Place waterslides = new Place("You see 3 waterslides. They all lead into the pool. Number 1 is labled MILD. Number 2 is labled WILD. Number 3 is labled RIDICULOUS.");
  private final Place restaraunt = new Place("Welcome to the restaraunt. Buy food here.");
  private final Place pool = new Place("You are swimming in the pool. If you don't have a mask, you can't go more than 1ft deep.");
  private final Place mildenterance = new Place("You are in a normal waterslide. It is dark in here...");
  private final Place mildending = new Place("You are still in the slide. You can see some light...");


  public Lesson7NewAdventure() {
      //Link places
  your_room.addDirection("hallway", hallway);

  hallway.addDirection("Room 201", your_room);
  hallway.addDirection("north", pool_room);
  hallway.addDirection("south", restaraunt);

  pool_room.addDirection("south", hallway);
  pool_room.addDirection("upstairs", waterslides);
  pool_room.addDirection("JUMP", pool);

  waterslides.addDirection("downstairs", pool_room);
  waterslides.addDirection("in mild slide", mildenterance);

  pool.setSound(getClass().getResource("splash.wav"));
  pool.addDirection("out", pool_room);

  mildenterance.addDirection("continue slide", mildending);

  mildending.addDirection("continue", pool);
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
    return "Welcome to the survival game of Inflatable. I hope u enjoYYYYYYYYYYYg";
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
