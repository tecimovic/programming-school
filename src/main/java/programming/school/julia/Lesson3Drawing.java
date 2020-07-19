package programming.school.julia;

import java.awt.*;

import programming.school.framework.DrawingContainer;
import programming.school.framework.IDrawingInstructions;
import programming.school.framework.IKeyboardAction;
import programming.school.framework.Utilities;

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
	private void setrandomColor(Graphics2D g) {
		g.setColor(new Color(Utilities.randomNumber(255), Utilities.randomNumber(255), Utilities.randomNumber(255)));
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
            case 'n'  :
                    size=10;
            break;  
            
            case 'c' :
            setrandomColor(g);

        }
        size++;
        plotDot(g);
    }

	public static void main(String[] args) {
        Lesson3Drawing l = new Lesson3Drawing();
        new DrawingContainer(l,l).runContainer(args);
	}

}
