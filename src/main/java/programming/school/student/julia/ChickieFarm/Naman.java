package programming.school.student.julia.ChickieFarm;

import java.util.Random;

public class Naman {
    enum MaleFirstName{Bob, Jeff, Jerry, James, Jeremiah, Johannes, Poldi, Bart, Barry, Tony, Toby, Soil, Rocky, BIDET, rushbushbebe, Weed, Kyojuro, gyatt, jimothy}
    enum FemaleFirstName{Gabby, Esther, Grass, Lavender, Snowflake, Sandy, Siri, Alexa, Gosistan, Kaz, ツ, Shinobu, Cactus, Thorn, Pot, Ashmyah}

    static String[] fmalenames=
    new String[]{"Gabby", "Esther", "Grass", "Lavender", "Snowflake", "Sandy", "Siri", "Alexa", "Gosistan", "Kaz", "ツ", "Shinobu", "Cactus", "Thorn", "Potetta", "Ashmyah", "Petra"};
    static String[] malenames=
    new String[]{"Bob", "Jeff", "Jerry", "James", "Jeremiah", "Johannes", "Poldi", "Bart", "Barry", "Tony", "Toby", "Soil", "Rocky", "BIDET", "rushbushbebe", "Weed", "Kyojuro", "gyatt", "jimothy"};
    private static Random rnd = new Random();

    public static String namemale(){
        return malenames[rnd.nextInt(malenames.length)];
    }  

    public static String namefemale(){
        return fmalenames[rnd.nextInt(fmalenames.length)];
    }  
    
}
