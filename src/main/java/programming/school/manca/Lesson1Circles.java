/*
 * What is this?
 */
package programming.school.manca;

import programming.school.DrawingContainer;
import programming.school.IDrawingInstructions;

import java.awt.Color;
import java.awt.Graphics;

public class Lesson1Circles implements IDrawingInstructions {

	@Override
	public void draw(Graphics g) {
		g.setColor(Color.ORANGE);
		g.drawLine(40, 40, 40, 640);
		g.drawLine(640, 40, 640, 640);
		g.drawLine(40, 40, 640, 40);
		g.drawLine(40, 640, 640, 640);
		g.setColor(Color.BLACK);
		g.drawOval(110, 110, 100, 100);
		g.drawOval(470, 110, 100, 100);
		g.fillOval(150, 170, 30, 30);
		g.fillOval(490, 170, 30, 30);
		g.setColor(Color.RED);
		g.fillOval(320, 320, 40, 40);
		g.drawLine(190, 480, 490, 480);
		g.setColor(Color.BLACK);
		g.drawString("GRUMPY", 580,600);
	}

	public static void main(String[] args) {
		new DrawingContainer(new Lesson1Circles()).runContainer(args);
	}

}
