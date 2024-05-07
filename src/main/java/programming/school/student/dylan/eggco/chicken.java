package programming.school.student.dylan.eggco;

import java.util.Random;

public class chicken {
    private String name;
    private int requiredSeedsPerDay;
    private int requiredCupsofWater;
    private int eggsPerDay;
    private int ageinDays;
    private int chickenhappiness;
    private final int crazynumber;
    private final int racistnumber;
    private boolean isdead;
    private final boolean isenlightened;
    private final boolean isgay;
    private boolean ismarried;
    private Gender gender;
    private Illness illness;
    private final Color color;
    enum Gender {boy,girl,nonbinary,ultimategender}
    enum Color {white, beige, black, gray, brown, waffled}
    enum Illness {sick, plagued, suffering, ultimatumillness, healthy}

    public chicken () {
        Random rnd = new Random();
        this.ageinDays = 0;
        this.color = Color.values()[rnd.nextInt(Color.values().length)];
        this.crazynumber = 0;
        this.racistnumber = 0;
        this.isenlightened = (rnd.nextInt(500) == 0);
        this.isgay = (rnd.nextInt(30) == 0);
        this.name = namingoffice.cname();
        
        this.requiredSeedsPerDay = 10;
        this.requiredCupsofWater = 4;
        this.eggsPerDay = 3;
        this.ageinDays = 0;
        this.chickenhappiness = 10;
        this.isdead = false;
        int rndgender = rnd.nextInt(500);
        if (rndgender < 1) {
            this.gender = Gender.ultimategender;
        } else if (rndgender < 4) {
            this.gender = Gender.nonbinary;
        } else if (rndgender < 251) {
            this.gender = Gender.boy;
        } else {
            this.gender = Gender.girl;
        }
        int randosick = rnd.nextInt(10000);
        if (randosick < 1) {
            this.illness = Illness.ultimatumillness;
        }
        else if (randosick < 11) {
            this.illness = Illness.suffering;
        }
         else if (randosick < 31) {
            this.illness = Illness.plagued;
        } else if (randosick < 131) { // 131
            this.illness = Illness.sick;
        } else {
            this.illness = Illness.healthy;
        }
        if (isenlightened == true) {
            this.gender = Gender.ultimategender;
        }
        }

    public void print () {
        System.out.println("KFC'S NEWEST INVENTION: KNOW YOUR MEAL! LEARN ACCURATE INFORMATION ON THE FINGER LICKIN' GOOD CHICKEN YOU ARE EATING RIGHT NOW!");
        System.out.println("NAME:" + this.name);
        System.out.println("COLOR:" + color);
        System.out.println("GENDER:" + gender);
        if (isgay) {
            System.out.println("GAY: YES");
        }
        else {
            System.out.println("GAY: NO");
        }
        if (isenlightened) {
            System.out.println("ENLIGHTENED: YES");
        }
        else {
            System.out.println("ENLIGHTENED: NO");
        }
    }
    public void quikprintpng () {
        System.out.println("KFC'S KNOW YOUR MEAL! (TM) | NAME: " + this.name + " | COLOR: " + color + " | GENDER: " + gender + " | HEALTH: " + illness + " | GAY? " + (isgay? "YES" : "NO") + " | ENLIGHTENED? " + (isenlightened? "YES" : "NO"));
    }

    public boolean isgay() {
        return isgay;
    }
    public boolean issick() {
        return illness == Illness.sick;
    }
    public boolean isplagued() {
        return illness == Illness.plagued;
    }
}
