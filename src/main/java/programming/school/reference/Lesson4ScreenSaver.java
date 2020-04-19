package programming.school.reference;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Random;

import programming.school.DrawingContainer;
import programming.school.IDrawingInstructions;
import programming.school.IKeyboardAction;

public class Lesson4ScreenSaver implements IDrawingInstructions, IKeyboardAction {

    private static final int SPEED = 3;
    private Random rnd = new Random();

    private int x = rnd.nextInt(DrawingContainer.MAX_X);
    private int y = rnd.nextInt(DrawingContainer.MAX_Y);
    private int vx = SPEED;
    private int vy = SPEED;

    private void reset() {
        x += vx;
        y += vy;

        if ( x < 0 ) {
            x = 0;
            vx = SPEED;
        } else if ( x > DrawingContainer.MAX_X ) {
            x = DrawingContainer.MAX_X;
            vx = -SPEED;
        }
        if ( y < 0 ) {
            y = 0;
            vy = SPEED;
        } else if ( y > DrawingContainer.MAX_Y ) {
            y = DrawingContainer.MAX_Y;
            vy = -SPEED;
        }
    }

	@Override
	public void draw(Graphics2D g) {
        reset();
        switch(rnd.nextInt(3)) {
            case 0: g.setColor(Color.BLUE); break;
            case 1: g.setColor(Color.RED); break;
            case 2: g.setColor(Color.GREEN); break;
        }
        g.drawOval(x, y, 20, 20);
	}

    @Override
    public void keyPressed(Graphics2D g, char ch) {
        switch(ch) {
        }
    }

	public static void main(String[] args) {
        Lesson4ScreenSaver l = new Lesson4ScreenSaver();
        new DrawingContainer(l,l, true).runContainer(args);
	}

}