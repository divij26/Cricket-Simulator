import java.util.Scanner;

public class Team{
    public int matches_played, total_runs,i=0,x,y;
   public String t_name= new String();
   public String NAME;
    Scanner sc = new Scanner(System.in);
   private String[][] result= new String[5][2];


   public Player[] p = new Player[4];


    public void match_info(){
        matches_played++;

    }
    public void score(int x){
        total_runs+=x;
    }
    public void choose_player(){
        System.out.println("enter no of bowlers and batsman required");
        x=sc.nextInt();
        y=sc.nextInt();
        for(int i=0; i<x; i++) {
            System.out.println("Enter name");
            NAME=sc.next();
            p[i] = new Bowler(NAME);
        }
        for(i=x;i<4;i++){
            System.out.println("Enter name");
            NAME=sc.next();
        p[i]=new Batsman(NAME);

        }
    }





}
