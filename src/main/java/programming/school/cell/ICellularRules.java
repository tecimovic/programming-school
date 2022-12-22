package programming.school.cell;

public interface ICellularRules {
  public String name();
  public int width();
  public int height();
  public int initialValue(int x, int y);
  public int newState(int oldState, int[] neigbors);

  public static final int EMPTY = 0;
  public static final int RED = 1;
  public static final int BLUE = 2;
}
