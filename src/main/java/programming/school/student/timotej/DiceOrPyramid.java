package programming.school.student.timotej;

import java.util.Random;

public class DiceOrPyramid {

    public static void main(String[] args) {
        System.out.println("Game of dice and pyramids....");
        Random rnd = new Random();
        final int maxCount = 18;
        final int rollCount = 1000000;

        int[] pyramidCounts = new int[maxCount + 1];
        int[] diceCounts = new int[maxCount + 1];

        for (int box = 0; box <= maxCount; box++) {

            for (int roll = 0; roll < rollCount; roll++) {

                int totalDiceCount = 0;
                for (int i = 0; i < 3; i++) {
                    totalDiceCount += 1 + rnd.nextInt(6);
                }

                int totalPyramidCount = 0;
                for (int i = 0; i < 18; i++) {
                    totalPyramidCount += rnd.nextInt(2);
                }

                if (totalDiceCount == box)
                    diceCounts[box]++;

                if (totalPyramidCount == box) {
                    pyramidCounts[box]++;
                }

            }

            System.out.println("Box " + box + ": pyramids: " + pyramidCounts[box] + " / dice: " + diceCounts[box]
                    + ", best choice " + (pyramidCounts[box] > diceCounts[box] ? "pyramids" : "dice"));
        }
    }
}
