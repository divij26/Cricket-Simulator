public class Bowler extends Player {

    private int overs=0;
    Bowler(String name){
        super(name);
    }


   public void update_over(){
       overs++;
    }


}
