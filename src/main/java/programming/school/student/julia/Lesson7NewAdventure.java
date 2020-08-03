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

  public Lesson7NewAdventure() {
  }

  @Override
  public String playerName() {
    return "mr. qazwax";
  }

  @Override
  public Place startingPlace() {
    return train_station;
  }

  @Override
  public String introductionText() {
    return "welcome to train game. in this game you have to get .";
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
