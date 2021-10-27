package programming.school.student.dylan;

import java.awt.Color;
import java.awt.Graphics2D;

import programming.school.framework.DrawingContainer;
import programming.school.framework.IDrawingInstructions;

public class Lesson8Eratosthenes implements IDrawingInstructions {

  private void plotDot(int x, int y, Graphics2D g) {
    g.drawOval(x, y, 1, 1);
  }

  @Override
  public void draw(Graphics2D g) {
    int MAX_X = 500;
    int MAX_Y = 500;
    int i = 0;
    int EDGE_X = 50;
    int EDGE_Y = 50;
    g.setColor(Color.RED);

    // if (y == 1 || x == 1 || x == 499 || y == 200)

    for (int n = 2 * 2; n <= 500 * 500; n+=2) {
      int x = n % 500;
      int y = n / 500;
        plotDot(EDGE_X + x, EDGE_Y + y, g);
    }
  }

  public static void main(String[] args) {
    Lesson8Eratosthenes l = new Lesson8Eratosthenes();
    new DrawingContainer(l).runContainer(args);
  }

}
