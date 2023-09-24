/*
 * What is this?
 */
package programming.school.student.timotej;

import programming.school.framework.CoordinateSystem;
import programming.school.framework.IMathPlotter;

public class LessonCoordinates implements IMathPlotter {

    @Override
    public int maxX() {
        return 500;
    }

    @Override
    public int maxY() {
        return 500;
    }

    @Override
    public String windowTitle() {
        return "Simple plot";
    }

    @Override
    public void plot(CoordinateSystem cs) {
        cs.line(0.0, 0.0, 0.5, 0.5);
        cs.dot(0.25, 0.25);
    }

    public static void main(String[] args) {
        new CoordinateSystem(new LessonCoordinates()).runContainer();
    }

}
