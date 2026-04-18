package programming.school.student.dylan.eggco;

import java.util.ArrayList;
import java.util.List;

public class coop {
    private List<chicken> ch = new ArrayList<chicken>();
    private String coopname;
    public int nummerofeggscoopruduced () {
        int summary=0;
        for(int annoying=0; annoying<ch.size(); annoying++) {
            summary += ch.get(annoying).myeh();
            
        }
        return summary;
    }

    public coop(String coopname, int chigginnumber) {
        this.coopname = coopname;
        for(int b=0; b<chigginnumber; b++) {
            ch.add(new chicken());
        }
    }
    public void printpolyphemus () {
        System.out.println("The chiggins inside of coop " + coopname + " | rezeedents: " + ch.size());
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
