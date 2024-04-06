package programming.school.student.julia.ChickieFarm;

public class Farm {
    private Coop[] coops = new Coop[4];

    public void printie(){
        for (Coop i:coops){
            i.printie();
        }
    }

    public Farm(){
        for(int i = 0; i<coops.length;i++){
            if (i==0){
              coops[i]= new Coop("Coop-"+(i+1), 20);    
            }
            if (i==1){
               coops[i]= new Coop("Coop-"+(i+1), 30);    
            }
            if (i==2){
                coops[i]= new Coop("Coop-"+(i+1), 40);    
            }
            if (i==3){
                coops[i]= new Coop("THE HOLY CHICKEN manamanamanamanamanamanamana", 1);    
            }
            
        }
       
    }

    public static void main(String[] args) {
        System.out.println("welcom 2 the chickiefarm!!!");

        Farm farm = new Farm();

        farm.printie();
    }
}
