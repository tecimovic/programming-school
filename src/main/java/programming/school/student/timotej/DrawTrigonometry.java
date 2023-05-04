package programming.school.student.timotej;

import java.awt.Color;
import java.awt.Graphics2D;

import programming.school.framework.DrawingContainer;
import programming.school.framework.IDrawingInstructions;

public class DrawTrigonometry implements IDrawingInstructions {

    private static double degreeToRad(double degree) {
        return (Math.PI * degree / 180.0);
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(Color.BLUE);

        int x;

        for (x = 0; x < 1000; x++) {
            double sin = Math.sin(degreeToRad(x));
            int y = (int) Math.round(sin * 200.0) + 200;
            g.drawOval(x, y, 2, 2);
        }
    }

    public static void main(String[] args) {
        new DrawingContainer(new DrawTrigonometry()).runContainer(args, 100, 100);
    }

}
