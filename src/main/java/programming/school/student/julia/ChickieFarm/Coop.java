package programming.school.student.julia.ChickieFarm;

import programming.school.student.julia.ChickieFarm.Chickie.Gender;

public class Coop {
    private Chickie[] chickie;

    private String name;

    public void printie(){
        System.out.println("--------------------"+name+"-----------------------");
        printstats();
        for (int i = 0; i<chickie.length; i++){
            chickie[i].ID();
        }
    }

    private void printstats(){
        int boys = 0;
        int grls = 0;
        int gays = 0;
        for (int i=0 ; i<chickie.length; i++){
            if (chickie[i].gender() == Gender.Boy){
                boys++;
            }
            if (chickie[i].gender() == Gender.Girl){
                grls++;
            }
            if (chickie[i].isgay()==true){
                gays++;
            }
            
        }
        System.out.println("There are "+grls+" females in this coop");
        System.out.println("There are "+boys+" males in this coop");
        System.out.println("There are "+gays+" gays in this coop");
    } 

    public Coop(String name, int Chickiething){
        chickie = new Chickie[Chickiething];
        for (int i=0;i<chickie.length;i++){
            chickie[i]= new Chickie(i+"", "chickaen");
        }
        this.name = name;
    }
}
