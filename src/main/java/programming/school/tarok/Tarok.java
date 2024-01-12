package programming.school.tarok;

public class Tarok {

  public static enum Suit {
    Clubs,
    Spades,
    Hearts,
    Diamonds,
    Tarok;

    public String symbol() {
      return this.name();
    }
  }

  public static enum SuitValue {
    Tiny(1),
    Small(1),
    Medium(1),
    High(1),
    Jack(2),
    Horseman(3),
    Queen(4),
    King(5);

    private int points;

    SuitValue(int points) {
      this.points = points;
    }

    public int points() {
      return points;
    }
  }

  public static enum TarockValue {
    Pagat(5),
    II,
    III,
    IIII,
    V,
    VI,
    VII,
    VIII,
    IX,
    X,
    XI,
    XII,
    XIII,
    XIV,
    XV,
    XVI,
    XVII,
    XVIII,
    XIX,
    XX,
    Mond(5),
    Skis(5);

    private int points;

    TarockValue() {
      this(1);
    }

    TarockValue(int points) {
      this.points = points;
    }

    public int points() {
      return points;
    }
  }
}
