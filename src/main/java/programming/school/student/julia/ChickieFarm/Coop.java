package programming.school.student.julia.ChickieFarm;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import programming.school.student.julia.ChickieFarm.Chickie.Gender;

public class Coop {
    //private Chickie[] chickie;
    private List<Chickie> chickie = new ArrayList<Chickie>();

    private String name;

    public void printie(){
        System.out.println("--------------------"+name+"-----------------------");
        printstats();
        for (int i = 0; i<chickie.size(); i++){
            chickie.get(i).ID();
        }
    }

    public int counter(){
        return chickie.size();
    }

    public int gottacountemall(){
        double eggie=0;
        double egofage=0;
        int chicks=0;
        Random rnd = new Random();
        for (int i=0;i<chickie.size();i++){
            if (chickie.get(i).age() < 200){
                eggie+=chickie.get(i).eg();
            } else {
                egofage+=chickie.get(i).eg();
            }
            chickie.get(i).agebyaday();
        }
        //System.out.println(egofage+" = egofage");
        for (int i=0;i<egofage;i++){
            if (rnd.nextInt(75)==42){
                chicks++;
                chickie.add(new Chickie("bobross"));
                //System.out.println("yey new chicken born :D");
            }
        }
       // System.out.println(chicks+"is the number of bobrosses");
        return (int)Math.floor(eggie+egofage);
    }

    private void printstats(){
        int boys = 0;
        int grls = 0;
        int gays = 0;
        for (int i=0 ; i<chickie.size(); i++){
            if (chickie.get(i).gender() == Gender.Boy){
                boys++;
            }
            if (chickie.get(i).gender() == Gender.Girl){
                grls++;
            }
            if (chickie.get(i).isgay()==true){
                gays++;
            }
            
        }
        System.out.println("There are "+grls+" females in this coop");
        System.out.println("There are "+boys+" males in this coop");
        System.out.println("There are "+gays+" gays in this coop");
    } 

    public Coop(String name, int Chickiething){
      //  chickie = new Chickie[Chickiething];
        for (int i=0;i<Chickiething;i++){
            chickie.add(new Chickie(i+""));
        }
        this.name = name;
    }
}
