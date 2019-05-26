import java.util.Scanner;

public class Player {

    protected int matches_played, matches_won, bats_overs, bowl_overs, bats_runs=0, bowler_runs=0,x,y;
    public String name;
    Scanner sc = new Scanner(System.in);
    public Player(String name) {
        this.name = name;
        matches_played = 0;
        matches_won = 0;
    }

    public void updateMatch() {
        matches_played++;
    }

    public void update_bowl_overs() {
        bowl_overs++;
    }

    public void update_bats_overs() {
        bats_overs++;
    }

    public void bats_runs(int x){
        bats_runs+=x;
    }
    public void bowl_runs(int x){
        bowler_runs+=x;
    }


}
