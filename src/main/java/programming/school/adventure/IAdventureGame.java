// Copyright (c) 2020 Silicon Labs. All rights reserved.

package programming.school.adventure;

public interface IAdventureGame {
  
  public void evaluateState(Player player, IOutput out);
  public Place startingPlace();
  public String playerName();
  public String introductionText();
  public String victoryText();

  // Various possible callbacks.
  public default void thingAdded(Player player, Thing t, IOutput out) {}
  public default void thingRemoved(Player player, Thing t, IOutput out) {}
  public default void creatureAction(Player player, Creature creature, Place place, IOutput out) {}
  public default boolean canPlayerMove(Player player, Place from, Place to, IOutput out) {return true;}
}
