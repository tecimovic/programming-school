package programming.school.student.dylan;

public class sommath{

    private static double radToDegrees(double rad) {
        return (180.0 * rad / Math.PI);
    }

    private static double degreeToRad(double degree) {
        return (Math.PI * degree / 180.0);
    }

    public static void main(String[]args) {
        double x;

        for (x = 0.0; x <= 360.0; x += 10.0) {
            System.out.println("sin(" + x + ") = " + Math.sin(degreeToRad(x)));
            System.out.println("cos(" + x + ") = " + Math.cos(degreeToRad(x)));
        }
    }
}