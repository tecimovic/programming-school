package programming.school.student.dylan.eggco;

public class farm {
    private coop[] coops = new coop[4];
    public static void main(String[] args) {
        System.out.println("WELCOME TO GIDDY GIDEYOE'S RABBIDY CHIGGIN FARM! GUH GUH GUH!");
        System.out.println("GIDDY GIDEYOE: HELLO PAR'NER! I AM GOING ON A VAY-CAYSHUN, ANAH NEED YOU TO MANAG' MAH CHIGGIN VARM! YUPEE!");
        farm f = new farm();
        f.ah_ah_ha();
    }
    public farm () {
        for (int i=0; i<coops.length; i++) {
            if (i == 0) {
                coops[i] = new coop("thu kingly palas", 1);
            }
            else if (i == 1) {
                coops[i] = new coop("manshn hills", 10);
            }
            else if (i == 2) {
                coops [i] = new coop("hull masachewsets", 20);
            }
            else if (i == 3) {
                coops [i] = new coop("thu suuper puuper", 30);
            }
        }
    }
    public void ah_ah_ha () {
    for (coop d:coops) {
        d.printpolyphemus();
    }
    }
}
