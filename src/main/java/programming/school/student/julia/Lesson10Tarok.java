package programming.school.student.julia;

import programming.school.tarok.TarokDeck;
import programming.school.tarok.TarokSet;

public class Lesson10Tarok {
  public static void main(String[] args) {
    // Create a deck, fully sorted.
    TarokDeck t = new TarokDeck();

    // Print out the deck.
    System.out.println(t);

    // Deal 12 cards.
    TarokSet h = t.deal(12);

    // Print them out.
    System.out.println(h);

    // Swap the cards at index 0 and 6.
    h.swap(0, 6);

    // Print them out.
    System.out.println(h);
  }
}
