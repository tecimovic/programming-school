package programming.school.student.julia.ChickieFarm;

import java.util.Scanner;

public class Farm {
    
    
    private Coop[] coops;

    public int oneday(){
        int eggsies = 0;
        for(int i=0;i<coops.length;i++){
            eggsies+=coops[i].gottacountemall();
        }
        return eggsies;
    }

    

    public void printie(){
        for (Coop i:coops){
            i.printie();
        }
    }

    public int printotal(){
        int chickaens=0;
        for(int i=0;i<coops.length;i++){
            chickaens+=coops[i].counter();
        }
        return chickaens;
    }
 
    public Farm(int coopCount){
        coops = new Coop[coopCount];
        for(int i = 0; i<coops.length;i++){
              coops[i]= new Coop("Coop-"+(i+1), 20);    
            
         //   if (i==1){
           //    coops[i]= new Coop("Coop-"+(i+1), 30);    
          //  }
           // if (i==2){
           //     coops[i]= new Coop("Coop-"+(i+1), 40);    
           // }
           // if (i==3){
           //     coops[i]= new Coop("The Chicken Mayor", 1);    
           // }
            
        }
       
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Chicken farm");
        System.out.println("How many coops would you like to create?");
        String inputString = scanner.nextLine();
        System.out.println("You chose "+ inputString );
        

        Farm farm = new Farm(Integer.parseInt(inputString));

        farm.printie();
        System.out.println("There are " +farm.printotal()+" chickens in the farm.");
        
        int e=0;

        int totaldeys=0;

        for(int i=0;i<1000;i++){
         e+=farm.oneday();
         totaldeys++;
        }

        System.out.println("The chickens layed "+e+" eggs in "+totaldeys+" days");

       System.out.println("There are " +farm.printotal()+" Chickens in the Farm."); 
    }
}
