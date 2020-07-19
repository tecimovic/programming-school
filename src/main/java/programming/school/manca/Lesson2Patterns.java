/*
 * What is this?
 */
package programming.school.manca;

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
		setRandomColor(g);
		for (int j = 0; j<5; j++) {
		for (int i = 0; i < 200; i++) {
			setRandomColor(g);
			
			g.drawOval(i+(j*100), i, 2*i, 2*i);
			g.drawOval(1000-(3*i+(j*100)), i, 2*i, 2*i);
		}
	}
	}

	public static void main(String[] args) {
		new DrawingContainer(new Lesson2Patterns()).runContainer(args);
	}

}
