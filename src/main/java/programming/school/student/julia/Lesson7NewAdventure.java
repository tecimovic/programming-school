package programming.school.student.julia;

import programming.school.adventure.IAdventureGame;
import programming.school.adventure.IOutput;
import programming.school.adventure.Place;
import programming.school.adventure.Player;
import programming.school.adventure.ui.GameUi;

public class Lesson7NewAdventure implements IAdventureGame {

  // Create places
  private final Place train_station = new Place("You are in a train station. There is a dunkin' donuts.");
  private final Place train = new Place("it is a train from boston to ancorage");
  private final Place highway = new Place("it is a highway from hull to boston");
  private final Place vautrinot_avenue = new Place("the street you live on that has alot of potholes");
  private final Place home = new Place("the house you live in that is on vautriot ave");
  private final Place dunkin_donuts = new Place("a normal dunkin' donuts that is out of strawberry donuts");

  public Lesson7NewAdventure() {
    train_station.addDirection("north", train);
    train_station.addDirection("south",  highway);
    train_station.addDirection("east",  dunkin_donuts);
    highway.addDirection("north", train_station);
    highway.addDirection("south",  vautrinot_avenue);
    vautrinot_avenue.addDirection("southeast",  home);
    vautrinot_avenue.addDirection("north",  highway);
  }

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
    return "welcome to train game. in this game you have to get the train ticket to go on the train to anchorage
    .";
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
