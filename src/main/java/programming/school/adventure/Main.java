// Copyright (c) 2020 Silicon Labs. All rights reserved.

package programming.school.adventure;

import java.util.Scanner;

public class Main {

  public static void main(final String[] args) {
    Game g = new Game();
    try (Scanner s = new Scanner(System.in)) {
      g.play(s, System.out);
    }
  }
}

