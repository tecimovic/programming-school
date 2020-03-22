/*
 * What is this?
 */
package programming.school.dylan;

import programming.school.DrawingContainer;
import programming.school.IDrawingInstructions;

import java.awt.Graphics;

public class Circles implements IDrawingInstructions {

	@Override
	public void draw(Graphics g) {
		g.drawOval(0, 0, 1000, 1000);
		g.drawLine(0, 0, 1000, 1000);
	}

	public static void main(String[] args) {
		new DrawingContainer(new Circles()).runContainer(args);
	}

}
