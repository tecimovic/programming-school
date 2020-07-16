// Copyright (c) 2020 Silicon Labs. All rights reserved.

package programming.school.adventure;

import java.io.PrintStream;

public interface IAdventureGame {
  public void evaluateState(Player player, PrintStream out);
  public default void thingAdded(Player player, Thing t) {}
  public default void thingRemoved(Player player, Thing t) {}
  public default void creatureAction(Player player, Creature creature, Place place, PrintStream out) {}
  public Place startingPlace();
  public String playerName();
  public String introductionText();
  public String victoryText();
}
