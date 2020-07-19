/*
 * What is this?
 */
package programming.school.reference;

import java.awt.Color;
import java.awt.Graphics2D;

import programming.school.framework.DrawingContainer;
import programming.school.framework.IDrawingInstructions;
import programming.school.framework.Utilities;

public class Lesson2Patterns implements IDrawingInstructions {

	private void setRandomColor(Graphics2D g) {
		g.setColor(new Color(Utilities.randomNumber(255), Utilities.randomNumber(255), Utilities.randomNumber(255)));
	}

	@Override
	public void draw(Graphics2D g) {
		for (int i = 0; i < 1000; i++) {
			setRandomColor(g);
			g.drawLine(i, 0, 1000 - i, 1000);
			g.drawLine(0, i, 1000, 1000 - i);
		}
	}

	public static void main(String[] args) {
		new DrawingContainer(new Lesson2Patterns()).runContainer(args);
	}

}
