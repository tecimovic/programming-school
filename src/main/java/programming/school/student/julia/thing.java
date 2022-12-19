package programming.school.student.julia;

import programming.school.cell.CellularAutomataUi;
import programming.school.cell.ICellularRules;

public class thing extends CellularAutomataUi {

  public thing(ICellularRules... cellularRules) {
    super(cellularRules);
  }

  public static void main(String[] args) {
    new thing(new ConwayGameOfLife(),new gameoflife(),new funkerulechanges()).start();
  }

}
