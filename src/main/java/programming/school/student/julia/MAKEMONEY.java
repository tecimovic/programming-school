package programming.school.student.julia;

import java.util.Random;

public class MAKEMONEY {
    public static void main(String[] args) {
        System.out.println("GET A MILLLLLLLLION BUCKS WITH THIS GAME!!!!!!!!!!!!!!!!! (pay 1,000,001 bucks to play)");
        Random dice = new Random();
        int[] counters = new int[13];

        for (int c = 0; c < 100000; c++) {
            // System.out.println("THE DICE HAVE ROLLED! YOUR NUMBERS ARE: " + (1 +
            // dice.nextInt(6)) + " AND "
            // + (1 + dice.nextInt(6)) + "!!!!!!!!!");
            int die1 = dice.nextInt(6) + 1;
            int die2 = dice.nextInt(6) + 1;
            counters[die1 + die2]++;

        }
        for (int c = 0; c < 13; c++) {
            System.out.println("PSST! HERE'S A CHEAT! THE NUMBER " + c + " WAS ROLLED " + counters[c] + " TIMES!!!");
        }
    }

}
