/*
 * What is this?
 */
package programming.school.julia;

import java.awt.Graphics2D;

import programming.school.DrawingContainer;
import programming.school.IDrawingInstructions;

public class Lesson1Circles implements IDrawingInstructions {

	@Override
	public void draw(Graphics2D g) {
		g.fillOval(480, 480, 40, 40);
		g.drawOval (400, 400, 30, 30);
		g.drawOval (500, 400, 30, 30);
		g.drawString("white herobrine badger",400, 800);
	}

	public static void main(String[] args) {
		new DrawingContainer(new Lesson1Circles()).runContainer(args);
	}

}
