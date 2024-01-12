package programming.school.tarok;

import programming.school.tarok.Tarok.Suit;
import programming.school.tarok.Tarok.SuitValue;
import programming.school.tarok.Tarok.TarockValue;

public class TarokCard {
  private Suit suit;
  private TarockValue tarockValue;
  private SuitValue suitValue;

  public TarokCard(Suit suit, SuitValue suitValue, TarockValue tarockValue) {
    this.suit = suit;
    if (suit == Suit.Tarok) {
      this.tarockValue = tarockValue;
    } else {
      this.suitValue = suitValue;
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
        return redName(suitValue) + " of " + suit.name();
      case Clubs:
      case Spades:
        return blackName(suitValue) + " of " + suit.name();
      default:
        throw new IllegalStateException("Invalid suit: " + suit);
    }
  }
}
