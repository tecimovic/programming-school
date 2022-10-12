package programming.school.cell;

public class CellularField {

  private int w,h;
  private int [][] gen1;
  private int [][] gen2;
  private ICellularRules rules;
  private boolean first = true;

  public CellularField(ICellularRules rules) {
    this.rules = rules;
    this.w = rules.width();
    this.h = rules.height();
    // These are offset by 2, as we put sentinel lines around the edge, so neighbor calculation doesn't have to deal
    // with edge cases.
    gen1 = new int[w+2][h+2];
    gen2 = new int[w+2][h+2];
    for ( int i=1; i<=w; i++ ) {
      for ( int j=1; j<=h; j++ ) {
        gen1[i][j] = gen2[i][j] = rules.initialValue(i, j);
      }
    }
    for ( int i=0; i<w; i++ ) {
      gen1[i][0] = gen2[i][0] = -1;
      gen1[i][h+1] = gen2[i][h+1] = -1;
    }
    for ( int j=0; j<h; j++ ) {
      gen1[0][j] = gen2[0][j] = -1;
      gen1[w+1][0] = gen2[w+1][0] = -1;
    }
  }

  public int value(int x, int y ) {
    if ( first )  {
      return gen1[x+1][y+1];
    } else {
      return gen2[x+1][y+1];
    }
  }

  public void clear() {
    for ( int i=1; i<=w; i++ ) {
      for ( int j=1; j<=h; j++ ) {
        gen1[i][j] = gen2[i][j] = rules.initialValue(i, j);
      }
    }
  }

  public void setValue(int x, int y, int value) {
    if ( first )  {
      gen1[x+1][y+1] = value;
    } else {
      gen2[x+1][y+1] = value;
    }
  }

  public void oneStep() {
    int [][] source = first ? gen1 : gen2;
    int [][] dest = first ? gen2 : gen1;
    int[] neighbors = new int[8];
    for ( int i=1; i<=w; i++ ) {
      for ( int j=1; j<=h; j++ ) {
        neighbors[0] = source[i-1][j-1];
        neighbors[1] = source[i][j-1];
        neighbors[2] = source[i+1][j-1];
        neighbors[3] = source[i-1][j];
        neighbors[4] = source[i+1][j];
        neighbors[5] = source[i-1][j+1];
        neighbors[6] = source[i][j+1];
        neighbors[7] = source[i+1][j+1];
        dest[i][j] = rules.newState(source[i][j], neighbors);
      }
    }
    first = !first;
  }
}
