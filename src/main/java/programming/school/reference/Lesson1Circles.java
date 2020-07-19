/*
 * What is this?
 */
package programming.school.reference;

import java.awt.Color;
import java.awt.Graphics2D;

import programming.school.framework.DrawingContainer;
import programming.school.framework.IDrawingInstructions;

public class Lesson1Circles implements IDrawingInstructions {

	@Override
	public void draw(Graphics2D g) {
		g.drawOval(0, 0, 1000, 1000);
		g.setColor(Color.RED);
		g.drawLine(0, 0, 1000, 1000);
	}

	public static void main(String[] args) {
		new DrawingContainer(new Lesson1Circles()).runContainer(args);
	}

}
