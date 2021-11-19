package programming.school.student.julia;

import programming.school.adventure.Creature;
import programming.school.adventure.IAdventureGame;
import programming.school.adventure.IOutput;
import programming.school.adventure.Place;
import programming.school.adventure.Player;
import programming.school.adventure.Store;
import programming.school.adventure.Thing;
import programming.school.adventure.ui.GameUi;

public class Lesson7NewAdventure implements IAdventureGame {
  // Create places
  private final Place train_station = new Place("You are in a train station. There is a dunkin' donuts.");
  private final Place train = new Place("it is a train from boston to ancorage");
  private final Place highway = new Place("it is a highway from hull to boston");
  private final Place vautrinot_avenue = new Place("the street you live on that has alot of potholes");
  private final Place home = new Place("the house you live in that is on vautriot ave");
  private final Place dunkin_donuts = new Place("a normal dunkin' donuts that is out of strawberry donuts");
  private final Place exit_27 = new Place("a normal highway exit");
  private final Place train_tracks = new Place("a normal train track");
  private final Place a_street_in_the_middle_of_nowhere = new Place("just what it sounds like...");
  private final Place cave = new Place("a dark and eerie cave a couple miles off the highway ");
  private final Place ticket_booth = new Place("you can buy your tickets here.");

  // CRRRRRRRREEEEEEEEEECCCCCCCCCCCCCCHHHHHHHHHHHHHHHHEEEEEEEEEEEEEERRRRRRRRRRRRRRRRRZZZZZZZZZZZZZZZZZ
  private final Creature puppy = new Creature("puppy","your pet golden retriever name: ruff age: 5 months");

  //Make Dem Tings
private final Thing train_ticket = new Thing("A Ticket For The Train");


  // link places
  public Lesson7NewAdventure()
  {
    train_station.addDirection("north", train);
    train_station.addDirection("south", highway);
    train_station.addDirection("east", dunkin_donuts);
    train_station.addDirection("somewhere dumb", train_tracks);
    train_station.addLockedDirection("into the train", train, train_ticket);
  
    highway.addDirection("north", train_station);
    highway.addDirection("south", vautrinot_avenue);
    highway.addDirection("west", exit_27);
    vautrinot_avenue.addDirection("southeast", home);
    vautrinot_avenue.addDirection("north", highway);
    dunkin_donuts.addDirection("west", train_station);
    home.addDirection("out", vautrinot_avenue);
    exit_27.addDirection("east", highway);
    exit_27.addDirection("west", a_street_in_the_middle_of_nowhere);
    a_street_in_the_middle_of_nowhere.addDirection("east", cave);
    Store storeExtension = new Store();

    // Add place extensions
    dunkin_donuts.addExtension(storeExtension);
    ticket_booth.addExtension(storeExtension);

    //storestuffadd
     ticket_booth.addThing(train_ticket);
  }

  // stuff
  @Override
  public String playerName() {
    return "proffesser. qwerty qazwax";
  }

  @Override
  public Place startingPlace() {
    return train_station;
  }

  @Override
  public String introductionText() {
    return "welcome to train game. in this game you are a professer at anchorage university and you have to get the train ticket to go on the train to anchorage.";
  }
  // more stuff

  @Override
  public String victoryText() {
    return "You are happy!";
  }

  @Override
  public void creatureAction(Player player, Creature creature, Place place, IOutput out) {
    if (creature == puppy) {
      place.removeCreature(puppy);
      player.place().addCreature(puppy);
    }
  }

  @Override
  public void evaluateState(final Player player, final IOutput out) {
    if (player.place() == train_tracks) {
      player.die();
      out.println("you jumped on the train tracks and got hit by a train and you died");
    }
  }

  public static void main(final String[] args) {
    new GameUi(new Lesson7NewAdventure()).start();
  }

}
