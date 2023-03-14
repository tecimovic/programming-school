package programming.school.student.timotej;

import java.util.Random;

public class DiceOrPyramid {

    public static void main(String[] args) {
        System.out.println("Game of dice and pyramids....");
        Random rnd = new Random();
        final int maxCount = 24;
        final int rollCount = 10000000;

        for (int box = 0; box <= maxCount; box++) {
            int c4 = 0, c6 = 0, c2 = 0;

            for (int roll = 0; roll < rollCount; roll++) {

                int total6DiceCount = 0;
                for (int i = 0; i < 4; i++) {
                    total6DiceCount += 1 + rnd.nextInt(6);
                }

                int total4DiceCount = 0;
                for (int i = 0; i < 6; i++) {
                    total4DiceCount += 1 + rnd.nextInt(4);
                }

                int totalPyramidCount = 0;
                for (int i = 0; i < 24; i++) {
                    totalPyramidCount += rnd.nextInt(2);
                }

                if (total6DiceCount == box)
                    c6++;

                if (total4DiceCount == box)
                    c4++;

                if (totalPyramidCount == box) {
                    c2++;
                }

            }

            String winner;
            if (c6 > c4 && c6 > c2)
                winner = "6-sided dice";
            else if (c4 > c6 && c4 > c2)
                winner = "4-sided dice";
            else if (c2 > c4 && c2 > c6)
                winner = "pyramid";
            else
                winner = "Huh? Weird...";

            System.out.println(
                    "Box " + box + ": 6-dice " + c6 + " / 4-dice " + c4 + " / pyramid " + c2 + " ==> " + winner);

        }
    }
}
