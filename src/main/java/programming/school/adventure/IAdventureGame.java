// Copyright (c) 2020 Silicon Labs. All rights reserved.

package programming.school.adventure;

import java.io.PrintStream;

public interface IAdventureGame {
  public void evaluateState(Player player, PrintStream out);
  public default void thingAdded(Thing t) {}
  public default void thingRemoved(Thing t) {}
  public Place startingPlace();
  public String playerName();
  public String introductionText();
  public String victoryText();
}
