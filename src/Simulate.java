import java.util.Random;
import java.util.Scanner;


public class Simulate {
    // t[0].p[i]=
    static Scanner sc = new Scanner(System.in);
    private static Team[] t= new Team[2];
    private static int x,i=0,run, tosss,batORbowl;
    private static String y;
    private static Random rand= new Random();
    private static int n;

    public static int toss(int i){
        tosss=rand.nextInt(2);
        if(i==tosss){
            System.out.println("Team 1 won the toss. \n Press 1 to bowl 2 to Bat");
            batORbowl=sc.nextInt();
            if(batORbowl==1) {
                System.out.println("Team 1 chose to bowl");
                return 2;
            }
            else
                System.out.println("Team 1 chose to bat");
                return 1;
        }
        else {
            System.out.println("Team 2 won the toss. \n Press 1 to bowl 2 to Bat");
            batORbowl=sc.nextInt();
            if(batORbowl==1) {
                System.out.println("Team 2 chose to bowl");
                return 1;
            }
            else
                System.out.println("Team 2 chose to bat");
                return 2;
        }
    }
    public static void match_sim(int x){ //x is innings
        int over=0,i,batsman=0,bowler=0;
        //change player to bowler
        while(t[2-x].p[bowler] instanceof Batsman) {
            bowler++;
        }
        System.out.println("Bowler is: "+t[2-x].p[bowler].name);
        //change player to batsman
        while(t[x-1].p[batsman] instanceof Bowler) {
            batsman++;
        }
        //System.out.println("Batsman no. "+ batsman);
        System.out.println("Batsman is: "+t[x-1].p[batsman].name);
        //match starts, i is number of bowls bowled
        for (i=1;i<=30;i++) {
            run=rand.nextInt(7);
            System.out.print(run+" \t");
            //over ends
            if (i % 6 == 0) {
                over++;
                bowler++;
                while (t[2-x].p[bowler] instanceof Batsman) {
                    bowler++;
                    if(bowler>3){
                        bowler=0;
                    }
                }
                System.out.println("Bowler changes to: "+t[2-x].p[bowler].name);

            }
            if(run==0){
                batsman++;
                System.out.println(batsman);
                if(batsman>3) {
                    System.out.println("  All Out  ");
                    System.out.println("Team "+(x)+" scored "+t[x-1].total_runs+" runs ");
                    return;
                }
                while(t[x-1].p[batsman] instanceof Bowler) {
                    batsman++;
                }
                System.out.println("Next Batsman is: "+t[x-1].p[batsman].name);
            }
            t[x-1].p[bowler].bowl_runs(run);
            t[x-1].p[batsman].bats_runs(run);
            t[x-1].score(run);
            System.out.println("Score is "+t[x-1].total_runs);
            if(x==2){
                if(t[x-1].total_runs>t[0].total_runs)
                {
                    return;
                }
            }
        }
        System.out.println("Team"+(x-1)+"scored"+t[x-1].total_runs+"runs ");
        Thread.sleep(1000);

    }
    public static void main(String[] args) {

        int i;
        t[0]=new Team();
        t[1]=new Team();
        System.out.println("Enter team 1 name");
        t[0].choose_player();
        System.out.println("Enter team 2 name");
        t[1].choose_player();
        System.out.println("Toss::\t Team 1 choose:: 0. Heads 1. Tails");
        i=sc.nextInt();
        x=toss(i);
            if (x==1) {

                match_sim(1);
                System.out.println("Next Innings");
                match_sim(2);
            }
            else if (x==2){
                match_sim(2);
                System.out.println("Next Innings");
                match_sim(1);

            }

                System.out.println("Team 1 scored "+t[0].total_runs+" And Team 2 scored "+t[1].total_runs);
        if(t[0].total_runs<t[1].total_runs)
            System.out.println("Team 2 wins");
        else
            System.out.println("Team 1 wins");
        
        

    }
}
