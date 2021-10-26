package programming.school.student.julia;

import java.awt.Color;
import java.awt.Graphics2D;

import programming.school.framework.DrawingContainer;
import programming.school.framework.IDrawingInstructions;

public class Lesson8Eratosthenes implements IDrawingInstructions {

  private void plotDot(int x, int y, Graphics2D g) {
    g.drawOval(x - 1, y - 1, 2, 2);
  }

  @Override
  public void draw(Graphics2D g) {
    int MAX_X = 500;
    int MAX_Y = 500;
    int i = 0;
    int EDGE_X = 50;
    int EDGE_Y = 50;
    g.setColor(Color.RED);
    
    for (int x = 0; x < MAX_X; x++) {
      for (int y = 0; y < MAX_Y; y++) {
        plotDot(EDGE_X + x, EDGE_Y + y, g);
      }
    }
  }

 
  public static void main(String[] args) {
    Lesson8Eratosthenes l = new Lesson8Eratosthenes();
    new DrawingContainer(l).runContainer(args);
  }

}
