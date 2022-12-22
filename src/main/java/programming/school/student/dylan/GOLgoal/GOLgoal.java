package programming.school.student.dylan.GOLgoal;

import programming.school.cell.CellularAutomataUi;
import programming.school.cell.ICellularRules;

public class GOLgoal extends CellularAutomataUi {

  public GOLgoal(ICellularRules... cellularRules) {
    super(cellularRules);
  }

  public static void main(String[] args) {
    new GOLgoal(new golnormal (), new CWgolf(), new idk(), new checkrboards(), new newgol()).start();
  }

}
