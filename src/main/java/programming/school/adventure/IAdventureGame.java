// Copyright (c) 2020 Silicon Labs. All rights reserved.

package programming.school.adventure;

import java.io.PrintStream;

public interface IAdventureGame {
  public void evaluateState(Player player, PrintStream out);
  public Place startingPlace();
  public String playerName();
}
