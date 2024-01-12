package programming.school.reference;

import programming.school.tarok.TarokDeck;
import programming.school.tarok.TarokSet;

public class Lesson9Tarok {
  public static void main(String[] args) {
    TarokDeck t = new TarokDeck();
    System.out.println(t);

    TarokSet h = t.deal(12);
    System.out.println(h);
  }
}
