import java.util.Scanner;

public class Game {
    Player p1;
    Player p2;
    Dice die;

    public Game(Player p1, Player p2, Dice die){
        this.p1 = p1;
        this.p2 = p2;
        this.die = die;

    }

    public void play() {
        Player current = this.p1;
        takeTurn(current);
        current = nextPlayer(current);
        takeTurn(current);
        System.out.println("and the winner is, " + announceWinner());

    }

    public Player nextPlayer(Player current) {
        if(current == this.p1){
            return this.p2;
        }else {
            return this.p1;
        }
    }

    public void takeTurn(Player player) {
        player.toss(this.die);
    }

    public String announceWinner() {
        System.out.printf("Player %s scored %d%nPlayer %s scored %d%n",
            p1.getName(), p1.getScore(), p2.getName(), p2.getScore());
        if(p1.getScore() > p2.getScore()){
            return p1.getName();
        } else if (p1.getScore() == p2.getScore()) {
            return "tie!";
        }else {
            return p2.getName();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter number of sides ");
        int sides = Integer.parseInt(sc.nextLine());
        System.out.print("enter player ones name ");
        String pName1 = sc.nextLine();
        System.out.print("enter player twos name ");
        String pName2 = sc.nextLine();

        Game g1 = new Game(
                new Player(pName1),
                new Player(pName2),
                new Dice(sides)
        );
        g1.play();
    }
}
