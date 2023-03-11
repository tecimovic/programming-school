package programming.school.student.dylan;

import java.util.Random;

public class howtowin1000dollars {
// dicey                  dice                     throw the number twice
            //its snowing and the code is growing
    public static void main(String[] args) {
        System.out.println("SPINSPIN SPINTHEDICE MAKE IT MAKE IT MAKE IT NICE YOU WILL WIN 1000 DOLLARS WELLMAYBE NOT NECICARILY BUT SPINIT SPINIT SPINIT 400000 TIMES!!!!!!!!!!!!!!!!!!!!!!!!!!");
        //TODDLER FUN
        Random rnd = new Random();
        //TODDLER FUN
        System.out.println("DICEY DICEY DICEY ROLLED, DICEY DICEY DICEY IS " + (1 + rnd.nextInt(6)));
        int[] counter = new int[19];
        for(int box=1; box<=18;box++)
        for(int c=0; c<100000; c++){
            int die1= rnd.nextInt(6)+1;
            int die2= rnd.nextInt(6)+1;
            int die3= rnd.nextInt(6)+1;
            int die4= rnd.nextInt(6)+1;
            int winning = 0;
            int ironingot = 0;
            if (die1 == box){
                ironingot++;
            }
            if(die2 == box){
                ironingot++;
            }
            if(die3 == box){
                ironingot++;
            }
            if(die4 == box){
                ironingot++;
            }
            if(ironingot == 4){
                winning = 2000;
            } else if(ironingot == 3) {
                winning = 800;
            }
            if(ironingot == 2) {
                winning = 500;
            }
            if(ironingot == 1) {
                winning = 100;
            }
             if(die1 + die2+ die3+ die4 == box){
                winning = 1000;

            }
            counter[box] += winning;


        }

        for(int c=0; c<19;c++) {
        System.out.println(
            "THE GLORIOUS NUMBER " + c
            + " GAVE YOU THIS MUCH MONEY: " + counter[c]
        );

        }

        int highestBox = 0;
        int highestSum = 0;
        for(int i = 0; i < 19; i++) {
            if (counter[i] > highestSum) {
                highestBox = i;
                highestSum = counter[i];
            }
        }

        System.out.println("WHOEVER WENT ON THE NUMBER NUMBER NUMBER " + highestBox + " GETS " + highestSum + " DOLLLLLLLLLLLLLLAAAAAAAAAAAAARRRRRRRRRRRRSSSSSSSSS!!!!");
    }
}
