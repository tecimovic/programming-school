package programming.school.student.dylan;

import java.util.Random;

import programming.school.tarok.TarokDeck;
import programming.school.tarok.TarokSet;

public class Lesson10Tarok {

  public static void main(String[] args) {

  // He is so strongeus!
      Random randoguys = new Random();
      randoguys.nextInt(6);

    // Create a deck, fully sorted.
    TarokDeck t = new TarokDeck();

              for (int i=0; i<1000; i++) {
  t.swap(randoguys.nextInt(54), randoguys.nextInt(54));
    }

    // Print out the deck.
    System.out.println(t);

    // Deal 12 cards.
    TarokSet h = t.deal(12);

    // Print them out.
    System.out.println(h);

    // Swap the cards at index 0 and 6.

    for (int i=0; i<1000; i++) {
  h.swap(randoguys.nextInt(12), randoguys.nextInt(12));
    }

    // Print them out.
    System.out.println(h);
  }
}
