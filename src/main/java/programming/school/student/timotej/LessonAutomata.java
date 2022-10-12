package programming.school.student.timotej;

import programming.school.cell.CellularAutomataUi;
import programming.school.cell.ICellularRules;

public class LessonAutomata extends CellularAutomataUi {

  public LessonAutomata(ICellularRules... cellularRules) {
    super(cellularRules);
  }

  public static void main(String[] args) {
    new LessonAutomata(new ConwayGameOfLife()).start();
  }

}
