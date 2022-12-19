package programming.school.student.dylan;

import programming.school.cell.ICellularRules;

public class idk implements ICellularRules {

  @Override
  public String name() {
    return "Xpander";
  }

  @Override
  public int width() {
    return 100;
  }

  @Override
  public int height() {
    return 100;
  }

  @Override
  public int initialValue(int x, int y) {
    return 0;
  }

  @Override
  public int newState(int oldState, int[] neigbors) {
    int c = 0;
    for ( int i: neigbors ) {
      if ( i == 1 ) c++;
    }
    if ( oldState == 0 ) {
      if ( c == 2 ) return 1;
      else return 0;
    } else {
      if ( c < 2 ) {
        return 0;
      } else if ( c > 4 ) {
        return 0;
      } else {
        return 1;
      }
    }
  }

}
