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
  private final Place hospital = new Place("You see beds. It is the cruise hospital.");
  private final Place pool_room = new Place("You see a pool. About 10ft deep.");
  private final Place waterslides = new Place("You see 3 waterslides. They all lead into the pool. Number 1 is labled MILD. Number 2 is labled WILD. Number 3 is labled RIDICULOUS.");
  private final Place restaraunt = new Place("Welcome to the restaraunt. Buy food here.");
  private final Place pool = new Place("You are swimming in the pool. If you don't have a mask, you can't go more than 1ft deep.");
  private final Place mildenterance = new Place("You are in a normal waterslide. It is dark in here...");
  private final Place mildending = new Place("You are still in the slide. You can see some light...");
  private final Place wildenterance = new Place("You are in a VERY steep waterslide. Crazy, but fun.");
  private final Place wildmiddle = new Place("This is the steepest part of this Wild waterslide.");
  private final Place wildcontinued = new Place("This waterslide is not so steep anymore.");
  private final Place wildending = new Place("You can see light!");
  private final Place ridiculousenterance = new Place("You are in a EXTREMELY SCARY SLIDE.");
  private final Place ridiculousmiddle = new Place("It looks like there is... LIGHT! That was short.");
  private final Place ridiculousbearden = new Place("The light was not the end. It was a small lightbulb on the ceiling of the room that this slide ended in. (I thought it would end in the pool?) On both sides, there are... two bear dens? Choose wisely.");
  private final Place beardeneast = new Place("This bear den has no bears, and there is... A slide!");
  private final Place hospitalbed = new Place("You are in a bed in the cruise hospital. A nurse tells you that you were almost eaten by a bear.");
  private final Place ridiculousafterbearden = new Place("You are back in a super SCARY SLIDE. You don't see light.");
  private final Place ridiculousending = new Place("The slide is still crazy. You see light!");
  private final Place gym = new Place("There are very gym-y things at the gym.");
  private final Place tredmil = new Place("You are running the tredmil!");
  private final Place weights = new Place("You are lifting the weights!");

  public Lesson7NewAdventure() {
      //Link places
  your_room.addDirection("hallway", hallway);

  hallway.addDirection("Room 201", your_room);
  hallway.addDirection("north", pool_room);
  hallway.addDirection("south", restaraunt);
  hallway.addDirection("west", hospital);

  pool_room.addDirection("south", hallway);
  pool_room.addDirection("upstairs", waterslides);
  pool_room.addDirection("JUMP", pool);
  pool_room.setPicture(getClass().getResource("somenicename.jpg"));
  pool_room.addDirection("west", gym);

  hospitalbed.addDirection("out of bed", hospital);

  waterslides.addDirection("downstairs", pool_room);
  waterslides.addDirection("in mild slide", mildenterance);
  waterslides.addDirection("in wild slide", wildenterance);
  waterslides.addDirection("in ridiculous slide", ridiculousenterance);

  pool.setSound(getClass().getResource("splash.wav"));
  pool.addDirection("out", pool_room);

  hospital.addDirection("east", hallway);

  mildenterance.addDirection("continue slide", mildending);

  mildending.addDirection("continue", pool);

  wildenterance.addDirection("continue slide", wildmiddle);

  wildmiddle.addDirection("continue slide", wildcontinued);

  wildcontinued.addDirection("continue slide", wildending);

  wildending.addDirection("continue", pool);

  ridiculousenterance.addDirection("continue slide", ridiculousmiddle);

  ridiculousmiddle.addDirection("continue slide", ridiculousbearden);

  ridiculousbearden.addDirection("east bear den", beardeneast);
  ridiculousbearden.addDirection("west bear den", hospitalbed);

  beardeneast.addDirection("in slide", ridiculousafterbearden);

  ridiculousafterbearden.addDirection("continue slide", ridiculousending);

  ridiculousending.addDirection("continue", pool);

  gym.addDirection("tredmils", tredmil);
  gym.addDirection("weights", weights);
  gym.setPicture(getClass().getResource("cruiseshipgym.jpg"));

  tredmil.addDirection("gym", gym);

  weights.addDirection("gym", gym);




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
