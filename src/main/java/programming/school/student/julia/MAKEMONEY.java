package programming.school.student.julia;

import java.util.Random;

public class MAKEMONEY {
    public static void main(String[] args) {
        System.out.println("GET A MILLLLLLLLION BUCKS WITH THIS GAME!!!!!!!!!!!!!!!!! (pay 1,000,001 bucks to play)");
        Random dice = new Random();
        int[] counters = new int[19];

        for (int c = 0; c < 200000; c++) {
            // System.out.println("THE DICE HAVE ROLLED! YOUR NUMBERS ARE: " + (1 +
            // dice.nextInt(6)) + " AND "
            // + (1 + dice.nextInt(6)) + "!!!!!!!!!");
            int die1 = dice.nextInt(6) + 1;
            int die2 = dice.nextInt(6) + 1;
            int die3 = dice.nextInt(6) + 1;
            counters[die1 + die2 + die3]++;

        }
        for (int c = 0; c < 19; c++) {
            System.out.println("PSST! HERE'S A CHEAT! THE NUMBER " + c + " WAS ROLLED " + counters[c] + " TIMES!!!");
        }
        System.out.println("YAY! YOU NOW OWE US 1000000 BUCKS FOR THAT CHEAT SHEET!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
    }
    // MOST COMMON:
    // 1 die: all the same
    // 2 dice:7
    // 3 dice:11

}
