// Copyright (c) 2020 Silicon Labs. All rights reserved.

package programming.school.adventure;

public interface IAdventureGame {
  
  public void evaluateState(Player player, Output out);
  public Place startingPlace();
  public String playerName();
  public String introductionText();
  public String victoryText();

  // Various possible callbacks.
  public default void thingAdded(Player player, Thing t, Output out) {}
  public default void thingRemoved(Player player, Thing t, Output out) {}
  public default void creatureAction(Player player, Creature creature, Place place, Output out) {}
  public default boolean canPlayerMove(Player player, Place from, Place to, Output out) {return true;}
}
