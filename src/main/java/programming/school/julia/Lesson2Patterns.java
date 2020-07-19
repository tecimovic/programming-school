/*
 * What is this?
 */
package programming.school.julia;

import java.awt.Color;
import java.awt.Graphics2D;

import programming.school.framework.DrawingContainer;
import programming.school.framework.IDrawingInstructions;
import programming.school.framework.Utilities;

public class Lesson2Patterns implements IDrawingInstructions {

	private void setrandomColor(Graphics2D g) {
		g.setColor(new Color(Utilities.randomNumber(255), Utilities.randomNumber(255), Utilities.randomNumber(255)));
	}

	@Override
	public void draw(Graphics2D g) {
		setrandomColor(g);
		for (int i = 0; i < 300; i++) {
			
			
			g.drawOval(i
			, i, 1000, 1000 - i);
		    
		}setrandomColor(g);
		for (int l = 1000; l > 0; l--){
			g.drawOval(l, l, 1000, 1000 );
		}
	}

	private void setColorblue(Graphics2D g) {
	}

	public static void main(String[] args) {
		new DrawingContainer(new Lesson2Patterns()).runContainer(args);
	}

}
