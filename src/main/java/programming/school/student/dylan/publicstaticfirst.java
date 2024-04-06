package programming.school.student.dylan;

import java.util.Arrays;
import java.util.Random;

public class publicstaticfirst {
        private static double mbta_drail(double x, double y) {
        return x/y;
    }
    public static void main(String[]args) {
    System.out.println("ohdysseus");
    System.out.println("this is how strongeus! he e e i i is!:" +mbta_drail(2,7));
    System.out.println("True of false! I ain't telling you !" +  isNegative (987));
    System.out.println("Say this dadd day" + sign(10));
    System.out.println("Say this dadd day" + sign(5));
    System.out.println("Say this dadd day" + sign(0));
    System.out.println("Say this dadd day" + sign(-5));
    System.out.println("Say this dadd day" + sign(-50));
    System.out.println("Say this dadd day" + sign(42));

    flopsy(999);
    dicethrowgee(43);

    areYouDead(3);
    areYouDead(9);
    areYouDead(42);

    explode_others(0, 10, 7);
    explode_others(3, 4, 10);
    explode_others(5, 4, 8);
    explode_others(-6, 12, 5);

    explode_others(20000, 20000, 2);

    bouyilstunn();
    callmecallme();
    polyphemus();
    thedylanspecial();
    }
        public static boolean isNegative(double n) {

    if (n < 0) {
        System.out.println("True or false !? I ain't telling you!");
        return true;
        
    } else {
        System.out.println("True or false!? I ain't telling you!");
        return false;
    }
    }

    public static String sign(int n) {
        if (n>0 && n<10) {
            return "small summfink";
        }else if(n>41 && n<43) { return "the life and universe summfink or other";
        } else if(n<0 && n>-10) {
            return "taking my bites away";
        } else if(n>9) { return "big summfink";
        } else if(n<-9) { return "taking my meals away";
        } else {
            return "nuffink";
        }

    }
    public static void flopsy(int n) {
    int x=0;
    while (x<n) {
        System.out.println("the larch");
        x++;
    }
    }
    public static void dicethrowgee(int target) {
        int singasongoffilch;
        Random filch = new Random();
        while ((singasongoffilch = filch.nextInt(12)) > 1) {
            System.out.println(singasongoffilch);
        }
        System.out.println(filch);
    }

    public static void areYouDead(int x) {
        if (x % 2 == 1) {
        System.out.println("sometoimes oi think oim ded. coz oi can feel gostsangools rapping moi hed");
    } else {
        System.out.println("oi dont think oim ded, thank yoi veree moich.");
    }
    }

    public static boolean explode_others(int red, int blue, int orange) {
        if (red < 0 || blue < 0){
            System.out.println("We're sorry, due to our allience with Citizen's Bank (MAKING BANKING BETTER SINCE 1828 (TM)), we must cancel your charliecard purchasing due to you being in debt. Please buy a charliecard in our debt-only store in Roxbury. Thank you for your patronage, which to Citizen's Bank is false.");
            return false;
        }
        if (red + blue >= orange) {
            System.out.println("you can buy " + ((red + blue) / orange) + " charliecards. the mbta thanks you for your patronage, which is true.");
            return true;
        } else {
            System.out.println("please insert " + (orange - (red + blue)) +  " more dollars to purchase a charliecard, unfortunately your charliecard-purchasing ability is false.");
            return false;
        }
    }
    public static void bouyilstunn() {
        int dollarsanddays = 0;
    for (int x=0; x<=100; x++) {
        System.out.println("The MBTA pays you " + x + " dollars");
        for (int y=0; y<=100; y++) {
            System.out.println("YOU WAIT FOR " + y + " DAYS TO MAKE IT TO YOUR PROMOTION");
            dollarsanddays += x;
            dollarsanddays += y;
        }
    }
    System.out.println("Dollars & Days variable: " + dollarsanddays);

}
    public static void callmecallme() {
        for (int unmannerliness=0; unmannerliness<=1000; unmannerliness++) {
            System.out.print(unmannerliness + " ");
            if(unmannerliness % 100 == 0) {
                System.out.println("dat got da jakpot oh ya ayyayya ya ya ya FWEW FEWE FWEW FWEW OHHHHHHHH OHHHHHHHHHH DIVISIB-LE! MEGA DIVISIB-LE!!!!!! SUPER MEGA EXTREME DIVISIB-LE! FWEW FWEW FWWE");
            }
            else
            if(unmannerliness % 10 == 0) {
                System.out.println("dat was a lukke one DIVISIB-LE! GOOD DIVISIB-LE! WHOOOOOOOOOO! GOOD JOB!");
            }
            else
            if(unmannerliness % 2 == 0) {
                System.out.println("Divisib-le! Lucky!");
            }
            else {
                System.out.println("Unlucky Not Divisib-le. wahh wahhh wahhhhh.");
            }
        }
    }
    public static void polyphemus() {
        Random randoguyaresafe = new Random();
        int[] reando = new int[100];
        for (int i=0; i<reando.length; i++) {
            reando[i] = randoguyaresafe.nextInt(1000);
        }
        System.out.println("odysseus and the randoguys are in a cave odysseus and the randoguys are safe sheep meat sheep meat it didnt even make a bleat and it was dead odysseus thought he was safe it was like the sheep were laid out for him for him to come and take sheep meat is nice shelter is nice but ill tell you what isnt nice maybe though not now");
            randoguy12(reando);
    }
    public static void thedylanspecial() {
        System.out.println("And now, the filter!");
        Random velvetunderground = new Random();
        int[] ronweasley = new int[5];
        int[] hermionegranger = new int[5];
        for (int koolstoof = 0; koolstoof<ronweasley.length; koolstoof++) {
            ronweasley[koolstoof] = velvetunderground.nextInt(1000);
        }
        for (int ronsponsibility = 0; ronsponsibility<hermionegranger.length; ronsponsibility++) {
            hermionegranger[ronsponsibility] = velvetunderground.nextInt(1000);
        }
        randoguy12(ronweasley);
        randoguy12(hermionegranger);
        System.out.println("That was a wonderful filter, folks! But now... The apple!");
        int[] hairybutter = new int[10];
        for(int sansbattle = 0; sansbattle<ronweasley.length; sansbattle++) {
            hairybutter[sansbattle] = ronweasley[sansbattle];
        }
        for(int sansbattle = 0; sansbattle<hermionegranger.length; sansbattle++) {
            hairybutter[sansbattle + 5] = hermionegranger[sansbattle];
        }
        randoguy12(hairybutter);
        System.out.println(smallest(hairybutter));
        System.out.println(smallest(ronweasley));
        System.out.println(smallest(hermionegranger));
        System.out.println("And now: the sorting hat!");
        Arrays.sort(hairybutter);
        Arrays.sort(ronweasley);
        Arrays.sort(hermionegranger);
        randoguy12(hairybutter);
        randoguy12(ronweasley);
        randoguy12(hermionegranger);
    }
    public static int smallest(int[] myeh) {
        System.out.println("MYEH COLLECTING CO COLLECTED THIS:");
        int babymyeh = myeh[0];
        for(int myehcollector = 0; myehcollector<myeh.length; myehcollector++) {
            if (myeh[myehcollector] < babymyeh) {
                babymyeh = myeh[myehcollector];
            }
        }
        return babymyeh;
    }
    public static void randoguy12(int[] hairy) {
        for (int i=0; i<hairy.length; i++) {
            System.out.println(hairy[i]);
        }
    }
    }