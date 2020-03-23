/*
 * What is this?
 */
package programming.school.dylan;

import java.awt.Color;
import java.awt.Graphics2D;

import programming.school.DrawingContainer;
import programming.school.IDrawingInstructions;
import programming.school.Utilities;

public class Lesson2Patterns implements IDrawingInstructions {

	private void setRandomColor(Graphics2D g) {
		g.setColor(new Color(Utilities.randomNumber(255), Utilities.randomNumber(255), Utilities.randomNumber(255)));
	}

	@Override
	public void draw(Graphics2D g) {
		for (int i = 0; i < 500; i++) {
			setRandomColor(g);
			g.drawOval(i, i, i, i);

		}
		for (int OMGWHATSTHAT = 0; OMGWHATSTHAT < 500; OMGWHATSTHAT++) {
			setRandomColor(g);
			g.drawOval(1000 - OMGWHATSTHAT, OMGWHATSTHAT, OMGWHATSTHAT, OMGWHATSTHAT);
		}
	}

	public static void main(String[] args) {
		new DrawingContainer(new Lesson2Patterns()).runContainer(args);
	}

}
