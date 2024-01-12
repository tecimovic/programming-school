package programming.school.tarok;

import java.util.ArrayList;
import java.util.List;

public class TarokSet {
  List<TarokCard> cards = new ArrayList<>();

  public void add(TarokCard card) {
    this.cards.add(card);
  }

  public int count() {
    return cards.size();
  }

  public TarokCard get(int i) {
    return cards.get(i);
  }

  /**
   * Swap cards between index i and j
   * 
   * @param i
   * @param j
   */
  public void swap(int i, int j) {
    if (i < 0 || i >= cards.size() || j < 0 || j >= cards.size()) {
      throw new IllegalArgumentException(
          "Indexes out of range: " + i + ", " + j + ". Allowed: 0 - " + (cards.size() - 1));
    }
    TarokCard x = cards.get(i);
    cards.set(i, cards.get(j));
    cards.set(j, x);
  }

  /**
   * Prints out the string.
   */
  public String toString() {
    StringBuilder out = new StringBuilder("Set of " + cards.size() + " tarock cards:\n");
    for (TarokCard c : cards) {
      out.append("  " + c.toString() + "\n");
    }
    return out.toString();
  }
}
