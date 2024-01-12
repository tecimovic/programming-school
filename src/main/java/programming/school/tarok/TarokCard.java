package programming.school.tarok;

import programming.school.tarok.Tarok.Suit;
import programming.school.tarok.Tarok.SuitValue;
import programming.school.tarok.Tarok.TarockValue;

public class TarokCard {
  private Suit suit;
  private TarockValue tarockValue;
  private SuitValue suitValue;

  /**
   * Initializes the card, either suitValue or tarockValue is used, depending on
   * Suit.
   * 
   * @param suit
   * @param suitValue
   * @param tarockValue
   */
  public TarokCard(Suit suit, SuitValue suitValue, TarockValue tarockValue) {
    if (suit == null)
      throw new IllegalArgumentException("You must pass valid suit.");
    this.suit = suit;
    if (suit == Suit.Tarok) {
      if (tarockValue == null)
        throw new IllegalArgumentException("You must pass valid tarockValue for the tarock suit.");
      this.tarockValue = tarockValue;
    } else {
      if (suitValue == null)
        throw new IllegalArgumentException("You must pass valid suitValue for the non-tarock suit.");
      this.suitValue = suitValue;
    }
  }

  /**
   * How many points is this card worth at the final count.
   * 
   * @return
   */
  public int points() {
    if (suit == Suit.Tarok) {
      return tarockValue.points();
    } else {
      return suitValue.points();
    }
  }

  private String redName(SuitValue value) {
    switch (value) {
      case Tiny:
        return "4";
      case Small:
        return "3";
      case Medium:
        return "2";
      case High:
        return "1";
      default:
        return value.name();
    }
  }

  private String blackName(SuitValue value) {
    switch (value) {
      case Tiny:
        return "7";
      case Small:
        return "8";
      case Medium:
        return "9";
      case High:
        return "10";
      default:
        return value.name();
    }
  }

  public String toString() {
    switch (suit) {
      case Tarok:
        return tarockValue.name();
      case Hearts:
      case Diamonds:
        return suit.symbol() + " " + redName(suitValue);
      case Clubs:
      case Spades:
        return suit.symbol() + " " + blackName(suitValue);
      default:
        throw new IllegalStateException("Invalid suit: " + suit);
    }
  }
}
