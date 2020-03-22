/*
 * What is this?
 */
package programming.school.dylan;

import programming.school.DrawingContainer;
import programming.school.IDrawingInstructions;

import java.awt.Color;
import java.awt.Graphics;

public class Lesson1Circles implements IDrawingInstructions {

	@Override
	public void draw(Graphics g) {
		g.fillOval(480, 480, 40, 40);
		g.setColor(Color.MAGENTA);
		g.drawOval(280, 280, 100, 100);
		g.drawOval(600, 280, 100, 100);
		g.drawLine(200, 800, 600, 800);
	}

	public static void main(String[] args) {
		new DrawingContainer(new Lesson1Circles()).runContainer(args);
	}

}
