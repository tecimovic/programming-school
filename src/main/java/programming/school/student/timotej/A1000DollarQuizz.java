package programming.school.student.timotej;

import java.util.Random;

public class A1000DollarQuizz {
    public static void main(String[] args) {
        System.out.println("Starting...");
        int size = 19;
        Random rnd = new Random();

        int[] counters = new int[size];
        for (int box = 0; box <= 18; box++) {
            for (int i = 0; i < 100000; i++) {
                int die1 = 1 + rnd.nextInt(6);
                int die2 = 1 + rnd.nextInt(6);
                int die3 = 1 + rnd.nextInt(6);
                int winning;
                if (die1 + die2 + die3 == box) {
                    winning = 1000;
                } else if (die1 == box || die2 == box || die3 == box) {
                    winning = 250;
                } else {
                    winning = 0;
                }
                counters[box] += winning;
            }
        }

        for (int i = 0; i < size; i++) {
            System.out.println("Box " + i + " earned $" + counters[i]);
        }

        int highestBox = 0;
        int highestSum = 0;
        for (int i = 0; i < size; i++) {
            if (counters[i] > highestSum) {
                highestBox = i;
                highestSum = counters[i];
            }
        }

        System.out.println("The best position is " + highestBox + " and it earned you $" + highestSum);
    }
}
