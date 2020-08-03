package programming.school.reference;

import java.awt.Graphics2D;

import programming.school.framework.DrawingContainer;
import programming.school.framework.IDrawingInstructions;
import programming.school.framework.IKeyboardAction;

public class Lesson5Anything implements IDrawingInstructions, IKeyboardAction {

    public void keyPressed(final Graphics2D g, final char ch) {
    }

    public void draw(final Graphics2D g) {
    }

    public static void main(final String[] args) {
        Lesson5Anything l = new Lesson5Anything();
        new DrawingContainer(l, l, true).runContainer(args);
    }
}
