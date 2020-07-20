package programming.school.adventure.ui;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

import programming.school.adventure.IAdventureGame;
import programming.school.adventure.IOutput;
import programming.school.adventure.Player;

public class GameCli {

  private IAdventureGame game;
  public GameCli(IAdventureGame game) {
    this.game = game;
  }
  
  public void start(final InputStream input, final PrintStream out) {
    try (Scanner in = new Scanner(input)) {
      IOutput output = new CliOutput(out);
      Player player = new Player(output, game);
      player.intro();
      while (!player.isGameOver()) {
        player.describeCurrentPlace();
        out.print("\nWhat would you  like to do?\n>");
        player.newCommand(in.nextLine());
      }
      player.gameOver();
    }
  }

}
