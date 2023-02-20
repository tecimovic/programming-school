package programming.school.student.julia;

import programming.school.cell.CellularAutomataUi;
import programming.school.cell.ICellularRules;

public class AUTOMATAFUN extends CellularAutomataUi {

  public AUTOMATAFUN(ICellularRules... cellularRules) {
    super(cellularRules);
  }

  public static void main(String[] args) {
    new AUTOMATAFUN(new ConwayGameOfLife(), new gameoflife(), new funkerulechanges(), new THEVOTINGAME()).start();
  }

}
