package programming.school.student.dylan;

import java.awt.*;

import programming.school.framework.DrawingContainer;
import programming.school.framework.IDrawingInstructions;
import programming.school.framework.IKeyboardAction;

public class Lesson5CircleRoom implements IDrawingInstructions, IKeyboardAction {

    private int size = 10;

    private int x = 100;

    private int y = 200;

    public void keyPressed(final Graphics2D g, final char ch) {
        switch (ch) {
            case 'w':
               g.setColor(Color.black); size++;
                break;
            case 's':
              g.setColor(Color.white);  size--;
                break;
            case 'a':
            g.setColor(Color.black); x--;
                break;
            case 'd':
            g.setColor(Color.black); x++;
                break;
            case 'o':
            g.setColor(Color.black); y++;
                break;
            case 'l':
            g.setColor(Color.black); y--;

        }
    }

    public void draw(final Graphics2D g) {
        g.drawOval(x, y, size, size);

    }

    public static void main(final String[] args) {
        Lesson5CircleRoom l = new Lesson5CircleRoom();
        new DrawingContainer(l, l, true).runContainer(args);
    }
}
