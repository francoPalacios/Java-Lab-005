public class Player {
    private String name;
    private int score;

    public Player(String name){
        this.name = name;
        this.score = 0;
    }

    public String getName(){
        return this.name;
    }

    public int getScore(){
        return this.score;

    }

    public void toss(Dice d1){
        d1.roll();
        this.score = d1.view();
    }
}
