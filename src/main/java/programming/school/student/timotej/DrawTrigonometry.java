package programming.school.student.timotej;

import java.awt.Color;
import java.awt.Graphics2D;

import programming.school.framework.DrawingContainer;
import programming.school.framework.IDrawingInstructions;

public class DrawTrigonometry implements IDrawingInstructions {

    @Override
    public void draw(Graphics2D g) {
        g.setColor(Color.BLUE);
        g.drawLine(0, 0, 1000, 1000);
    }

    public static void main(String[] args) {
        new DrawingContainer(new DrawTrigonometry()).runContainer(args);
    }

}
