package programming.school.student.timotej;

import programming.school.tarok.TarokDeck;
import programming.school.tarok.TarokSet;

public class Lesson9Tarok {
  public static void main(String[] args) {
    TarokDeck t = new TarokDeck();
    System.out.println(t);

    TarokSet s = t.deal(12);
    System.out.println(s);

    s.swap(0, 6);
    System.out.println(s);
  }
}
