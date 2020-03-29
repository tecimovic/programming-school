package programming.school.dylan;

import java.awt.*;

import programming.school.DrawingContainer;
import programming.school.IDrawingInstructions;
import programming.school.IKeyboardAction;
import programming.school.Utilities;

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
        g.drawString("Dylan's Donut Shop", 600, 800);
	}

    @Override
    public void keyPressed(Graphics2D g, char ch) {
        switch(ch) {
            case 'a': 
                x-=100;
                size++;
                break;
            case 'd':
                x+=100;
                size++;
                break;
            case 's':
                y+=100;
                size++;
                break;
            case 'w':
                y-=100;
                size++;
                break;
            case 'n':
                size = 10;
                break;
            case 'f':
                setRandomColor(g);
                    break;
                
        }
        plotDot(g);
    }
	private void setRandomColor(Graphics2D g) {
		g.setColor(new Color(Utilities.randomNumber(255), Utilities.randomNumber(255), Utilities.randomNumber(255)));
	}

	public static void main(String[] args) {
        Lesson3Drawing l = new Lesson3Drawing();
        new DrawingContainer(l,l).runContainer(args);
  
	}

}
