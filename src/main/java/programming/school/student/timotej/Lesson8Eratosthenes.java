package programming.school.student.timotej;

import java.awt.Color;
import java.awt.Graphics2D;

import programming.school.framework.DrawingContainer;
import programming.school.framework.IDrawingInstructions;

public class Lesson8Eratosthenes implements IDrawingInstructions {

    private void plotDot(int x, int y, Graphics2D g) {
        g.drawOval(x, y, 1, 1);
    }

    private int nextTry(int x) {
        if (x < 2)
            return x + 1;
        if (x == 2)
            return 3;
        return x + 2;
    }

    @Override
    public void draw(Graphics2D g) {
        int MAX_X = 500;
        int MAX_Y = 500;
        int EDGE_X = 10;
        int EDGE_Y = 10;

        // g.setColor(Color.BLACK);
        // g.drawRect(EDGE_X - 1, EDGE_Y - 1, MAX_X + 2, MAX_Y + 2);

        g.setColor(Color.BLUE);
        int prime = 1;

        while (prime <= (MAX_X * MAX_Y) / 2) {
            prime = nextTry(prime);
            for (int n = prime * 2; n < MAX_X * MAX_Y; n += prime) {
                int x = n % MAX_X;
                int y = n / MAX_Y;
                plotDot(EDGE_X + x, EDGE_Y + y, g);
            }
        }
    }

    public static void main(String[] args) {
        Lesson8Eratosthenes l = new Lesson8Eratosthenes();
        new DrawingContainer(l).runContainer(args);
    }

}
