
import java. util. Scanner;
public class InsanityRunner {
    public static void main(String []ar){
        Scanner scan = new Scanner(System.in);
        System.out.println ("welcome to insanity");
        System.out.println("Separate The 8 pegs into two groups based on " +
                "color and place them on opposite ends. Leave the two center spots open. " +
                "You have to move the groups to their opposite sides. " +
                "If there is a space between two pegs you can move a peg forward. " +
                "If a peg is in front of another peg, you can jump over it (if there is a space open). " +
                "You can't move a peg backwards." +
                " If you accomplish this in 4 turns or less, you are a genius.");

        Insanity game =new Insanity();
        System.out.println("Do you want to play?");
        String r=scan.nextLine();
        if (r.equals("play")){
            game.printBoard();
            while (!(game.getBoard().equals(game.complete()))){
                System.out.println("What index do you want to move?");
                game.setI(scan.nextInt());
                game.movePiece();
                if (game.didWin()){
                    break;
                }
            }

        } else{
            System.out.println("k bye");

        }

        game.winner();

    }
}
