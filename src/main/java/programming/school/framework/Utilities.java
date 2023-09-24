package programming.school.framework;

import java.util.Random;

public class Utilities {

    private static Random rnd = new Random();

    /**
     * Helpful sleep so we don't have to deal with exeptions yet.
     */
    public static void sleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (Exception e) {
        }
    }

    /**
     * Helpful random method that returns random number from 0 to n.
     */
    public static int randomNumber(int n) {
        return rnd.nextInt(n);
    }
}