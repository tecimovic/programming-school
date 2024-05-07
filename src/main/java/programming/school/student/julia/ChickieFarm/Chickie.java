package programming.school.student.julia.ChickieFarm;

import java.util.Random;

public class Chickie {
    private final String Name;
    private final String LastName; // gets from father
    private Gender gender;
    private int Age; // in days
    private int DailySeeds;
    private int DailyWater; // in cups
    private double EggsPerDay;
    private boolean Sick; // dead after 5 days
    private boolean Dead;
    private final boolean RareEggs; // eggs worth more
    private final boolean Gay; //  G  A  Y
    private final Color color;
    enum Gender{Boy ,Girl}
    enum Color {white, brown, gray, black, yellow, waffled};
   // enum MaleFirstName{Bob, Jeff, Jerry, James, Jeremiah, Johannes, Poldi, Bart, Barry, Tony, Toby, Soil, Rocky, BIDET, rushbushbebe, Weed, Kyojuro, gyatt, jimothy}
   // enum FemaleFirstName{Gabby, Esther, Grass, Lavender, Snowflake, Sandy, Siri, Alexa, Gosistan, Kaz, ツ, Shinobu, Cactus, Thorn, Pot, Ashmyah}
    Random rnd=new Random();

    
    public Chickie(String LastName){
        this.gender =Gender.values()[rnd.nextInt(0, Gender.values().length)];
        this.Age=0;
        //this.Name=Name;
        this.EggsPerDay=rnd.nextDouble(0.0,2.1);
        this.LastName=LastName;
        this.color =Color.values()[rnd.nextInt(0, Color.values().length)];

        if (this.gender==Gender.Girl){
            this.Name =Naman.namefemale();
        }else{
            this.Name =Naman.namemale();
        }

        if (rnd.nextInt(5)==0){
            this.Gay=true;
        } else{
            this.Gay=false;
        }
        if (rnd.nextInt(20)==0){
            this.RareEggs=true;
        } else{
            this.RareEggs=false;
        }

       

    }

    public void agebyaday(){
        this.Age++;
    }

    public void ID(){
        System.out.println(Name+" "+LastName+" | "+gender+" | "+(Age/365)+"y/o | "+color+" | Homosexual: "+Gay);
    }
    public Gender gender(){
        return gender;
    }
    public boolean isgay(){
        return Gay;
    }
    public double eg(){
        return EggsPerDay;
    }
    public int age(){
        return Age;
    }
}
