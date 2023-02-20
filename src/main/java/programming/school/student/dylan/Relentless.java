package programming.school.student.dylan;

import programming.school.adventure.IAdventureGame;
import programming.school.adventure.Place;

public class Relentless implements IAdventureGame {
    private Place miami = new Place("You are in Miami. Will you go to the beach?");
}
public String playerName() {
    return "Lost soul";
  }

  @Override
  public Place startingPlace() {
    return startingPlace();
  }

  @Override
  public String introductionText() {
    return "R E L E N T L E S S";
  }

  @Override
  public String victoryText() {
    return "THE END";
  }

  @Override
  public void thingAdded(Player player, Thing t, IOutput out) {
  }

  @Override
  public void thingRemoved(Player player, Thing t, IOutput out) {
  }

  @Override
  public void creatureAction(Player player, Creature creature, Place place, IOutput out) {
  }