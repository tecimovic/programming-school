package programming.school.student.dylan;

import java.util.Random;

public class pyradice {
    public static void main(String[] args) {
        Random rnd = new Random();
        int[] dicecount = new int[19];
        int[] pyradicecount = new int[19];
        for ( int closet = 0; closet <=18; closet ++) {
            for(int c=0; c<100000; c++){ 
            int dice1 = rnd.nextInt(6) +1;
            int dice2 = rnd.nextInt(6) +1;
            int dice3 = rnd.nextInt(6) +1;

            int pyradice = 0;
            for (int i = 0; i < 18; i++) {
                pyradice += rnd.nextInt(2);
            }

            if(dice1 + dice2 + dice3 == closet){
                dicecount[closet]++;
            }

            if(pyradice == closet) {
                pyradicecount[closet]++;
            }
        }
        System.out.println("Number: " + closet + " Dice amount: " + dicecount[closet] + " Pyramid amount: " + pyradicecount[closet]);
        if(dicecount[closet] > pyradicecount[closet]) {
            System.out.println("sans sez: dice is better option");
        }
        if(pyradicecount[closet] > dicecount[closet]) {
            System.out.println("sans sez: pyramidz r much cooler");
        }

    }
    
}

}
