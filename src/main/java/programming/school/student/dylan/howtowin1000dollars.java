package programming.school.student.dylan;

import java.util.Random;

public class howtowin1000dollars {
// dicey                  dice
    public static void main(String[] args) {
        System.out.println("SPINSPIN SPINTHEDICE MAKE IT MAKE IT MAKE IT NICE YOU WILL WIN 1000 DOLLARS WELLMAYBE NOT NECICARILY BUT SPINIT SPINIT SPINIT 100000 TIMES!!!!!!!!!!!!!!!!!!!!!!!!!!");
        //TODDLER FUN
        Random rnd = new Random();
        //TODDLER FUN
        System.out.println("DICEY DICEY DICEY ROLLED, DICEY DICEY DICEY IS " + (1 + rnd.nextInt(6)) + " AND THE OTHER DICEY DICE DECIDED IT IS " + (1 + rnd.nextInt(6)));
        int[] counter = new int[13];
        for(int c=0; c<100000; c++){
            int die1= rnd.nextInt(6)+1;
            int die2= rnd.nextInt(6)+1;
            counter[die1+die2]++;


        }

        for(int c=0; c<13;c++) {
        System.out.println(
            "number " + c
            + " rolled " + counter[c]
        );

        }
    }
}
