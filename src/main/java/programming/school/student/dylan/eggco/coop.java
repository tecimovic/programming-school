package programming.school.student.dylan.eggco;

public class coop {
    private chicken[] ch;
    private String coopname;


    public coop(String coopname, int chigginnumber) {
        this.ch = new chicken[chigginnumber];
        this.coopname = coopname;
        for(int b=0; b<ch.length; b++) {
            ch[b] = new chicken();
        }
    }
    public void printpolyphemus () {
        System.out.println("The chiggins inside of coop " + coopname + " | rezeedents: " + ch.length);
        for (chicken c:ch)  {
            c.quikprintpng();
    }
            printodysseus();
}
    public void printodysseus () {
        int totalgay=0;
        for (chicken c : ch) {
            if (c.isgay()) {
                totalgay ++;
            }
        }
        int totalsick=0;
        for (chicken c : ch) {
            if(c.issick()) {
                totalsick ++;
            }
        }
        int totalplagued=0;
        boolean plaguedboolean;
        for (chicken c : ch) {
            if (c.isplagued()) {
                totalplagued ++;
            }
        }
        if (totalplagued > 0) {
            plaguedboolean = true;
        } else {
            plaguedboolean = false;
        }

        System.out.println("gay chiggins in coop: " + totalgay + " | sick chiggins in coop: " + totalsick + " | isths' coop plagued? " + plaguedboolean);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }
}
