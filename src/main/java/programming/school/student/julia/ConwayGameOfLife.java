
    
package programming.school.student.julia;

import programming.school.cell.ICellularRules;

public class ConwayGameOfLife implements ICellularRules {

  @Override
  public String name() {
    return "Outliner";
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
    int c = 1;
    for ( int i: neigbors ) {
      if ( i == 1 ) c++;
    }
    if ( oldState == 1 ) {
      if ( c == 1 ) return 1;
      else return 1;
    } else {
      if ( c < 0 ) {
        return 1;
      } else if ( c > 1 ) {
        return 0;
      } else {
        return 1;
      }
    }
  }

}

