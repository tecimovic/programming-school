package programming.school.student.julia;

import java.util.Arrays;
import java.util.Random;

public class first {

    public static void habiddybabiddy() {
        Random rnd=new Random();
        int[] x = new int[5];
        int[] y = new int[5];
        int[] xy = new int[10];
        for (int i=0; i<x.length; i++){
            x[i] = rnd.nextInt(0,21);
        }
        for (int i=0; i<y.length; i++){
            y[i] = rnd.nextInt(0,21);
        }
        for (int i=0; i<x.length; i++){
            xy[i] = x[i];
        }
        for (int i=0; i<y.length; i++){
           xy[i+5] = y[i];
        }
        ladiddydoo(xy);
        System.out.println("and now for something completely different:");
        Arrays.sort(xy);
        ladiddydoo(xy);
        System.out.println("smollboi = "+hoogiddyboo(xy));
    }

    public static int hoogiddyboo(int[] x) {
        int yey = x[0];
        for (int i=0; i<x.length; i++){
            if (x[i] < yey){
                yey = x[i];
            }
        }
        return yey;
    }

    public static void ladiddydoo(int[] x) {
        for(int i=0; i<x.length; i++){
            System.out.println(x[i]);
        }
    }

    public static void ladiddydah(){
        Random rnd=new Random();
        int[] x = new int[100];
        for (int i=0; i<x.length; i++){
            x[i] = rnd.nextInt(0,1001);
        }
        ladiddydoo(x);
    }

    public static void waggidybaggidy() {
        for(int x=0; x<=1000; x++){
            if(x%100==0){
                System.out.println(x+" is a vewwy rownd nummer");
            } else if(x%10==0){
                System.out.println(x+" is pwetty rownd ig");
            } else if(x%2==0){
                System.out.println(x+". okey well ig its even at least :/");
            } else {
                System.out.println(x+". waow. a stoopid odd nummer. pointless >:(");
            }
        }
    }

    public static void thigthatidontwannamake() {
       int stoopid=0;
        for(int x=0; x<=100; x++){
            for(int y=0; y<=100; y++){
              //  System.out.println(x+y);
                stoopid+=y;
                stoopid+=x;
            }
        }

        System.out.println(stoopid+" is suuuum");
    }

    public static void nummer() {
     for (int x=0; x<=100; x++){
          System.out.println("yey nummber "+x);
    }
    }
    
    public static boolean vallidywalldydatey(int x, int y, int z) {
      if ((x>=0)&&(y>=0)){
        if ((x+y)>z){
            return true;
        } else {
            return false;
        }
      } else{
        return false;
      }
    }

    public static void oovoobaloovoo(int e) {
        if(e%2==0){
            System.out.println("its eveeweeven");
        }else{
            System.out.println("its oddywoddy");
        }

    }

    public static void diceywiceyniceyslicey(int t) {
        int count=1;
        int randyrando;
        Random rnd = new Random();
        while ((randyrando=rnd.nextInt(13))!=t){
            System.out.println(randyrando+" was rolled");
            count++;
        }
        System.out.println("it took "+count+" times to get "+t);
    }

    public static void loopsiedoopsiedoo(int n) {
        int x=0;
        while(x<n+1){
            System.out.println(x+" missisippi");
            x++;
        }
    }

    public static String qwu(int a) {
        if (a<0){
            if(a>-10){
            return ("litol bebe negative");
         } else{
            return ("big boi negative");
         }
        } else if (a>0) {
            if(a>10){
                return("big boi number");
            }else{
                return("litol bebe number");
            }
        } else{
            return(" n o t h i n g   0-0   ");
        }
    }

    public static int pwq(int e) {
        if(e>0){
            return 1;
        }else if (e<0){
            return -1;
        }
        else{
            return 0;
        }
    }
    
    public static String owu(double a) {
        if (a<0){
            return ("well duh obvi >:)");
         } else{
            return ("lol nope :P");
        }
    }

    private static int qwo(){
        return (new Random().nextInt(-101,101));
       }

    private static int owo(){
     return (new Random().nextInt(10,1001));
    }
    
    private static double uwu(double x, double y){
       return x/y;
    }

    private static double TwT(double n){
        return (n*(n-1))/2;
    }
public static void main(String[]args){

    System.out.println("uwu");
    System.out.println("2/7="+uwu(2, 7)+" :)");
    System.out.println("the TwT of "+owo()+" is "+TwT(owo()));

    System.out.println("is "+owo()+" negatve? : "+owu(owo()));
    System.out.println("is -5 negatve? : "+pwq(-5));
    System.out.println("is 5 negatve? : "+pwq(5));
    System.out.println("is 0 negatve? : "+pwq(0));

    System.out.println("wat kinda nummer is "+qwo()+"???? its a "+qwu(qwo())+"!!!!");
    System.out.println("wat kinda nummer is 11 ???? its a "+qwu(11)+"!!!!");
    System.out.println("wat kinda nummer is 5 ???? its a "+qwu(5)+"!!!!");
    System.out.println("wat kinda nummer is -5 ???? its a "+qwu(-5)+"!!!!");
    System.out.println("wat kinda nummer is -11 ???? its a "+qwu(-11)+"!!!!");
    System.out.println("wat kinda nummer is 0???? its a "+qwu(0)+"!!!!");

   // loopsiedoopsiedoo(25);

   diceywiceyniceyslicey(7);

   oovoobaloovoo(3);
   oovoobaloovoo(9);
   oovoobaloovoo(42);
   oovoobaloovoo(owo());

   System.out.println("u hav 0$ an 10$, an u wanna buy 7$. can u?????? "+vallidywalldydatey(0, 10, 7));
   System.out.println("u hav 3$ an 4$, an u wanna buy 10$. can u?????? "+vallidywalldydatey(3, 4, 10));
   System.out.println("u hav 5$ an 4$, an u wanna buy 8$. can u?????? "+vallidywalldydatey(5, 4, 8));
   System.out.println("u hav -6$ an 12$, an u wanna buy 5$. can u?????? "+vallidywalldydatey(-6, 12, 5));
   //System.out.println("u hav "+owo()+"$ an "+owo()+"$, an u wanna buy "+owo()+"$. can u?????? "+vallidywalldydatey(0, 10, 7));

 //  nummer();

  // thigthatidontwannamake();

 // waggidybaggidy();

 //ladiddydah();

habiddybabiddy();




}

}
