package programming.school.cell;

public interface ICellularRules {
  public String name();
  public int width();
  public int height();
  public int initialValue(int x, int y);
  public int newState(int oldState, int[] neigbors);
}
