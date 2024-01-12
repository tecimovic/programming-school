package programming.school.tarok;

import programming.school.tarok.Tarok.Suit;
import programming.school.tarok.Tarok.SuitValue;
import programming.school.tarok.Tarok.TarockValue;

public class TarokDeck extends TarokSet {

  public TarokDeck() {
    for (Suit s : Suit.values()) {
      switch (s) {
        case Clubs:
        case Diamonds:
        case Hearts:
        case Spades:
          for (SuitValue v : SuitValue.values()) {
            cards.add(new TarokCard(s, v, null));
          }
          break;
        case Tarok:
          for (TarockValue t : TarockValue.values()) {
            cards.add(new TarokCard(s, null, t));
          }
      }
    }
  }

  /**
   * This method takes nCards cards out of the deck and deals them into a list.
   * The cards are removed from the deck.
   * 
   * @param nCards
   * @return
   */
  public TarokSet deal(int nCards) {
    if (cards.size() < nCards)
      throw new IllegalArgumentException(
          "Trying to deal " + nCards + " cards, but there are only " + cards.size() + " in the deck.");
    TarokSet hand = new TarokSet();
    for (int i = 0; i < nCards; i++) {
      hand.add(cards.remove(0));
    }
    return hand;
  }
}
