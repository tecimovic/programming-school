/*
 * What is this?
 */
package programming.school.timotej;

import java.awt.Color;
import java.awt.Graphics2D;

import programming.school.DrawingContainer;
import programming.school.IDrawingInstructions;

public class Lesson1Circles implements IDrawingInstructions {

	@Override
	public void draw(Graphics2D g) {
		g.drawOval(0, 0, 1000, 1000);
		g.setColor(Color.RED);
		g.drawLine(0, 0, 1000, 1000);
		g.drawString("long string", 300, 300);
	}

	public static void main(String[] args) {
		new DrawingContainer(new Lesson1Circles()).runContainer(args);
	}

}
