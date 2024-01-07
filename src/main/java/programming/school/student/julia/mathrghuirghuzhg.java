package programming.school.student.julia;

public class mathrghuirghuzhg {
    private static double radToDegrees(double rad) {
        return (180.0 * rad / Math.PI);
    }

    private static double degreeToRad(double degree) {
        return (Math.PI * degree / 180.0);
    }
    public static void main(String[] args) {
       int a;
        System.out.println("QWERTYUIOPASDFGHJKLZXCVBNM");
        System.out.println("WELCOME TO CVHEJRLAND");
        for (a=0;a<361;a+=10) {
            System.out.println("sine of "+a+" is "+Math.sin (degreeToRad(a))+", and the cosine is "+Math.cos (degreeToRad(a))+".");
        }
    }
}
