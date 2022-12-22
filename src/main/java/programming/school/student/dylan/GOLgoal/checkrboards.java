package programming.school.student.dylan.GOLgoal;

import programming.school.cell.ICellularRules;

public class checkrboards implements ICellularRules {

  @Override
  public String name() {
    return "CheckR-B0ard (By Julia)";
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
      if ( c == 3 ) return 1;
      else return 0;
    } else {
      if ( c < 2 ) {
        return 1;
      } else if ( c > 3 ) {
        return 0;
      } else {
        return 0;
      }
    }
  }

}
