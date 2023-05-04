package programming.school.student.timotej;

import java.awt.Color;
import java.awt.Graphics2D;

import programming.school.framework.DrawingContainer;
import programming.school.framework.IDrawingInstructions;

public class DrawTrigonometry implements IDrawingInstructions {

    private static int SIZE_X = 1000;
    private static int SIZE_Y = 500;

    private static double degreeToRad(double degree) {
        return (Math.PI * degree / 180.0);
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(Color.BLUE);

        int x;

        for (x = 0; x < SIZE_X; x++) {
            double sin = Math.sin(degreeToRad(x));
            int y = (int) Math.round(sin * SIZE_Y / 2) + SIZE_Y / 2;
            g.drawOval(x, y, 2, 2);
        }
    }

    public static void main(String[] args) {
        new DrawingContainer(new DrawTrigonometry()).runContainer(args, SIZE_X, SIZE_Y);
    }

}
