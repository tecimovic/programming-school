package programming.school.student.dylan.GOLgoal;

import programming.school.cell.ICellularRules;

public class CWgolf implements ICellularRules {

  @Override
  public String name() {
    return "Crazy Mazes";
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
  public int newState(int unitedState, int[] neigbors) {
    int c = 0;
    for ( int i: neigbors ) {
      if ( i == 1 ) c++;
    }
    if ( unitedState == 0 ) {
      if ( c == 3 ) return 1;
      else return 0;
    } else {
      if ( c < 2 ) {
        return 1;
      } else if ( c > 3 ) {
        return 0;
      } else {
        return 1;
      }
    }
  }

}
