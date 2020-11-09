package programming.school.student.dylan.aroundtheworld;

import programming.school.adventure.Creature;
import programming.school.adventure.IAdventureGame;
import programming.school.adventure.IOutput;
import programming.school.adventure.Place;
import programming.school.adventure.Player;
import programming.school.adventure.Thing;
import programming.school.adventure.ui.GameUi;

public class AroundTheWorldIn80Cities implements IAdventureGame {

  // Create places
  private static Place startingPlace = new Place("nowhere");
  
  // Create Creatures
  public AroundTheWorldIn80Cities() {


  }

  @Override
  public String playerName() {
    return "nobody";
  }

  @Override
  public Place startingPlace() {
    return startingPlace;
  }

  @Override
  public String introductionText() {
    return "You need to get somewhere.";
  }

  @Override
  public String victoryText() {
    return "Yay!";
  }

  // Saddle bonus points ++
  @Override
  public void thingAdded(Player player, Thing t, IOutput out) {
  }

  // Saddle bonus points --
  @Override
  public void thingRemoved(Player player, Thing t, IOutput out) {
  }

  @Override
  public void creatureAction(Player player, Creature creature, Place place, IOutput out) {
  }

  // Be CAREFUL with my computer
  @Override
  public void evaluateState(final Player player, final IOutput out) {
  }

  public static void main(final String[] args) {
    new GameUi(new AroundTheWorldIn80Cities()).start();
  }

}
