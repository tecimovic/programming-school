package programming.school.student.dylan.eggco;

import java.util.Random;

public class namingoffice {
    public static String[] chigginname = new String[]{"Dylan", "Julia", "Timotejrar", "Bob", "Bart", "Bag", "Factorysong", "Aaaaaiamasteve", "Dumbone", "Dummerone", "Verystupid", "KFC", "Thatone", "Fiona", "Olivia", "Stella", "Ashlyn", "Amayah", "Victoria", "Cosietan", "Couscous", "Charcoal", "Nutmeg", "Fluffy", "Hoodsie", "Cinnamon", "Soil", "Notgay", "Bidet", "Timotejisstaringathisphone", "Kazakhstan", "Astrangesymbolifyouwant", "The", "Velvet", "Underground", "Gerald", "Hart", "Wart", "Cloud", "Whisperers", "Rush", "Ambush", "Seek", "Figure", "Skibidi", "Loureed", "Trump", "Biden", "Commonwealthsuks"};
    public static String cname() {
        Random rando = new Random();
        return chigginname[rando.nextInt(chigginname.length)];
    }
}
