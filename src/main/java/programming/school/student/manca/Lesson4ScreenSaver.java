package programming.school.student.manca;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Random;

import programming.school.framework.DrawingContainer;
import programming.school.framework.IDrawingInstructions;
import programming.school.framework.IKeyboardAction;

public class Lesson4ScreenSaver implements IDrawingInstructions, IKeyboardAction {

    private int speed = 3;
    private final Random rnd = new Random();

    private int x = rnd.nextInt(DrawingContainer.MAX_X);
    private int y = rnd.nextInt(DrawingContainer.MAX_Y);
    private int vx = speed;
    private int vy = speed;

    private void reset() {
        x += vx;
        y += vy;

        if ( x < 0 ) {
            x = 0;
            vx = speed;
        } else if ( x > DrawingContainer.MAX_X ) {
            x = DrawingContainer.MAX_X;
            vx = -speed;
        }

        if ( y < 0 ) {
            y = 0;
            vy = speed;
        } else if ( y > DrawingContainer.MAX_Y ) {
            y = DrawingContainer.MAX_Y;
            vy = -speed;
        }
    }

	@Override
	public void draw(final Graphics2D g) {
        reset();
        switch(rnd.nextInt(3)) {
            case 0: g.setColor(Color.BLUE); break;
            case 1: g.setColor(Color.RED); break;
            case 2: g.setColor(Color.GREEN); break;
        }
        g.drawOval(x, y, 20, 20);
	}

    @Override
    public void keyPressed(final Graphics2D g, final char ch) {
        switch(ch) {
        case '+':
        	speed++;
        	break;
        case '-':
        	speed--;
        	if ( speed < 1 ) speed = 1;
        	break;
        }
    }

	public static void main(final String[] args) {
        Lesson4ScreenSaver l = new Lesson4ScreenSaver();
        new DrawingContainer(l,l, true).runContainer(args);
	}

}