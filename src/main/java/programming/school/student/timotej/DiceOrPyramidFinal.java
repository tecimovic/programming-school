package programming.school.student.timotej;

import java.util.Random;

public class DiceOrPyramidFinal {

    private static Random rnd;

    private static int calculateMoney(int matches) {
        switch (matches) {
            case 0:
                return 0;
            case 1:
                return 1000;
            case 2:
                return 1200;
            case 3:
                return 1400;
            case 4:
                return 1600;
            default:
                System.err.println("Weird...");
                return 0;
        }
    }

    private static int[] runTest(int[] p) {
        int totalMoneyPy = 0;
        int totalMoneyD4 = 0;
        int totalMoneyD6 = 0;
        for (int i = 0; i < 100; i++) {
            int py = 0;
            int d4 = 0;
            int d6 = 0;

            // Now throw the dice
            for (int j = 0; j < 24; j++)
                py += rnd.nextInt(2);
            for (int j = 0; j < 6; j++)
                d4 += (1 + rnd.nextInt(4));
            for (int j = 0; j < 4; j++)
                d6 += (1 + rnd.nextInt(6));

            // Now let's go match things.
            int matchedPy = 0;
            int matchedD4 = 0;
            int matchedD6 = 0;
            for (int j = 0; j < 4; j++) {
                if (py == p[j])
                    matchedPy++;
                if (d4 == p[j])
                    matchedD4++;
                if (d6 == p[j])
                    matchedD6++;
            }

            totalMoneyPy += calculateMoney(matchedPy);
            totalMoneyD4 += calculateMoney(matchedD4);
            totalMoneyD6 += calculateMoney(matchedD6);

        }

        return new int[] { totalMoneyPy, totalMoneyD4, totalMoneyD6 };
    }

    public static void main(String[] args) {
        System.out.println("Game of dice and pyramids final....");
        rnd = new Random();

        int p[] = new int[4];
        int r[];
        int best = 0;
        String bestText = "";

        for (p[0] = 0; p[0] <= 24; p[0]++) {
            System.out.println(" > First player in: " + p[0]);
            for (p[1] = 0; p[1] <= 24; p[1]++) {
                for (p[2] = 0; p[2] <= 24; p[2]++) {
                    for (p[3] = 0; p[3] <= 24; p[3]++) {
                        r = runTest(p);
                        if (r[0] > best) {
                            best = r[0];
                            bestText = "Pyramids, players are at: " + p[0] + ", " + p[1] + ", " + p[2] + " and " + p[3];
                        }
                        if (r[1] > best) {
                            best = r[0];
                            bestText = "4-dice, players are at: " + p[0] + ", " + p[1] + ", " + p[2] + " and " + p[3];

                        }
                        if (r[2] > best) {
                            best = r[0];
                            bestText = "6-dice, players are at: " + p[0] + ", " + p[1] + ", " + p[2] + " and " + p[3];

                        }
                    }
                }
            }
        }

        System.out.println(bestText);

    }
}
