package programming.school.manca;

import java.awt.Graphics2D;

import programming.school.DrawingContainer;
import programming.school.IDrawingInstructions;
import programming.school.IKeyboardAction;

public class Lesson3Drawing implements IDrawingInstructions, IKeyboardAction {

    private int x = 500;
    private int y = 500;
    private int size = 10;

    private void plotDot(Graphics2D g) {
        g.drawOval(x-(size/2), y-(size/2), size, size);
    }

	@Override
	public void draw(Graphics2D g) {
        plotDot(g);
	}

    @Override
    public void keyPressed(Graphics2D g, char ch) {
        switch(ch) {
            case 'a': 
                x-=3;
                break;
            case 'd':
                x+=3;
                break;
            case 's':
                y+=3;
                break;
            case 'w':
                y-=3;
                break;
        }
        plotDot(g);
    }

	public static void main(String[] args) {
        Lesson3Drawing l = new Lesson3Drawing();
        new DrawingContainer(l,l).runContainer(args);
	}

}
