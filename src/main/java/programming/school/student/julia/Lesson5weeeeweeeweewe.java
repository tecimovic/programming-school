package programming.school.student.julia;

import java.awt.Color;
import java.awt.Graphics2D;

import programming.school.framework.DrawingContainer;
import programming.school.framework.IDrawingInstructions;
import programming.school.framework.IKeyboardAction;
import programming.school.framework.Utilities;

public class Lesson5weeeeweeeweewe
    implements IDrawingInstructions, IKeyboardAction {

  private int x = 500;
  private int y = 500;
  private int size = 10;

  private void plotDot(Graphics2D g) {
    g.drawOval(x - (size / 2), y - (size / 2), size, size);
  }

  @Override
  public void draw(Graphics2D g) {
    plotDot(g);
    g.drawString("Julia's Donut Shop", 600, 800);
  }

  @Override
  public void keyPressed(Graphics2D g, char ch) {
    switch (ch) {
    case 'a':
      x -= 100;
      break;
    case 'd':
      x += 100;

      break;
    case 's':
      size--;
      break;
    case 'w':
      size++;
      break;
    case 'n':
      y -= 100;
      break;
    case 'f':
      y += 100;
      break;
    case 'm':
      g.setColor(Color.RED);
      size++;
      break;
    case 'c':
      setRandomColor(g);
      break;
    }
    plotDot(g);
  }

  private void setRandomColor(Graphics2D g) {
    g.setColor(new Color(Utilities.randomNumber(255),
                         Utilities.randomNumber(255),
                         Utilities.randomNumber(255)));
  }

  public static void main(String[] args) {
    Lesson5weeeeweeeweewe l = new Lesson5weeeeweeeweewe();
    new DrawingContainer(l, l).runContainer(args);

  }

}
