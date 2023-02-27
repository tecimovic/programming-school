package programming.school.student.julia;

import java.util.Random;

public class MAKEMONEY {
    public static void main(String[] args) {
        System.out.println("GET A MILLLLLLLLION BUCKS WITH THIS GAME!!!!!!!!!!!!!!!!! (pay 1,000,001 bucks to play)");
        Random dice = new Random();
        int[] counters = new int[25];

        for (int box = 1; box <= 24; box++) {
            for (int i = 0; i < 500000; i++) {
                int die4 = dice.nextInt(6) + 1;
                int die5 = dice.nextInt(6) + 1;
                int die6 = dice.nextInt(6) + 1;
                int die7 = dice.nextInt(6) + 1;
                int winning;
                if (die4 + die5 + die6 + die7 == box) {
                    winning = 1000;
                } else if (die4 == box || die5 == box || die6 == box || die7 == box) {
                    winning = 100;
                } else if ((die4 == box && die5 == box) || (die4 == box && die6 == box) || (die4 == box && die7 == box)
                        || (die5 == box && die6 == box) || die5 == box && die7 == box || (die6 == box && die7 == box)) {
                    winning = 500;
                } else if ((die4 == box && die5 == box && die6 == box) || (die4 == box && die5 == box && die7 == box)
                        || (die4 == box && die6 == box && die7 == box) || (die5 == box && die6 == box && die7 == box)) {
                    winning = 800;
                } else if ((die4 == box && die5 == box && die6 == box && die7 == box)) {
                    winning = 2000;
                } else {
                    winning = 0;
                }
                counters[box] += winning;

            }

        }
        for (int i = 0; i < 25; i++) {
            System.out.println("THE NUMBER " + i + " GOT YOU " + counters[i] + "$ !!!!!!!");
        }

        int highestbox = 0;
        int highestsum = 0;
        for (int i = 0; i < 25; i++) {
            if (counters[i] > highestsum) {
                highestbox = i;
                highestsum = counters[i];
            }

        }
        System.out.println("PSST! HERE'S A SECRET! THE BEST NUMBER TO GUESS IS " + highestbox
                + "!!! AND THE LUCKY PLAYERS WHO CHOSE IT GOT " + highestsum + " DOLLARS!!!!!!!!!");
        // for (int c = 0; c < 200000; c++) {
        // System.out.println("THE DICE HAVE ROLLED! YOUR NUMBERS ARE: " + (1 +
        // dice.nextInt(6)) + " AND "
        // + (1 + dice.nextInt(6)) + "!!!!!!!!!");
        // int die1 = dice.nextInt(6) + 1;
        // int die2 = dice.nextInt(6) + 1;
        // int die3 = dice.nextInt(6) + 1;
        // counters[die1 + die2 + die3]++;

        // fo (int c = 0; c < 19; c++) {
        //
        // /
        // / }
        //
        // System.out.println("YAY! YOU NOW OWE US 1000000 BUCKS FOR THAT CHEAT
        // SHEET!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
    }
    // MOST COMMON:
    // 1 die: all the same
    // 2 dice:7
    // 3 dice:11

}
