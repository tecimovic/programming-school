package programming.school.student.dylan;

import java.util.Random;

public class pyradice {
    public static void main(String[] args) {
        Random rnd = new Random();
        int[] dicecount = new int[24];
        int[] pyradicecount = new int[24];
        int[] superdicecount = new int[24];
        for ( int closet = 0; closet <=23; closet ++) {
            for(int c=0; c<1000000; c++){ 
            int dice1 = rnd.nextInt(6) +1;
            int dice2 = rnd.nextInt(6) +1;
            int dice3 = rnd.nextInt(6) +1;
            int dice4 = rnd.nextInt(6) +1;

            int pyradice = 0;
            for (int i = 0; i < 24; i++) {
                pyradice += rnd.nextInt(2);
            }

            int superdice1 = rnd.nextInt(4) +1;
            int superdice2 = rnd.nextInt(4) +1;
            int superdice3 = rnd.nextInt(4) +1;
            int superdice4 = rnd.nextInt(4) +1;
            int superdice5 = rnd.nextInt(4) +1;
            int superdice6 = rnd.nextInt(4) +1;

            if(dice1 + dice2 + dice3 + dice4 == closet){
                dicecount[closet]++;
            }

            if(superdice1 + superdice2 + superdice3 + superdice4 + superdice5 +superdice6 == closet) {
                superdicecount[closet]++;
            }

            if(pyradice == closet) {
                pyradicecount[closet]++;
            }
        }
        System.out.println("Number: " + closet + " Dice amount: " + dicecount[closet] + " Pyramid amount: " + pyradicecount[closet] + " Superdice amount: " + superdicecount[closet]);

        String winner;
        if(dicecount[closet] > pyradicecount[closet] && dicecount[closet] > superdicecount[closet])
            winner = "dice";
        else if (pyradicecount[closet] > dicecount[closet] && pyradicecount[closet] > superdicecount[closet])
            winner = "pyramids";
        else if (superdicecount[closet] > dicecount[closet] && superdicecount[closet] > pyradicecount[closet])
            winner = "superdice";
        else
            winner = "none of them";
        System.out.println("sanz sez you should choose " + winner);

        }
    
    }

}
