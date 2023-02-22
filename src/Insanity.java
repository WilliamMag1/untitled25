import java.util.ArrayList;
import java.util.Arrays;
import java. util. Scanner;

public class Insanity {
    Scanner scan = new Scanner(System.in);
    private boolean didWin;
    private ArrayList<Integer> board = new ArrayList<Integer>(Arrays.asList(1, 1, 1, 1, 0, 0, 2, 2, 2, 2));

    private ArrayList<Integer> complete = new ArrayList<Integer>(Arrays.asList(2, 2, 2, 2, 0, 0, 1, 1, 1, 1));
    private int moveCount;
    private boolean isGenius;
    private boolean quit;

    private int i;

    public Insanity() {
        didWin = false;
        moveCount = 0;
        isGenius = false;
        quit = false;
        i=0;
    }
    public void setI(int i){
        this.i=i;
    }

    public boolean canMove() {
        boolean m = false;
        if (board.get(i) == 1) {
            if (board.get(i + 1) == 0) {
                System.out.println("You can move one space");
                m = true;
            }

        } else if (board.get(i) == 2) {
            if (board.get(i - 1) == 0) {
                System.out.println("You can move one space");
                m = true;
            }

        } else if (board.get(i) == 0) {
            System.out.println("not a movable piece");
        }
        return m;
    }

    public boolean canJump(){
        boolean j = false;
        if (board.get(i) == 1) {
            if (board.get(i + 2) == 0 && board.get(i + 1) != 0) {
                System.out.println("You can jump 2 spaces");
                j = true;
            }

        } else if(i==1 && board.get(i) == 2){
            j=false;
        } else if (board.get(i) == 2){
            if (board.get(i - 2) == 0 && board.get(i - 1) != 0) {
                System.out.println("You can jump 2 spaces");
                j = true;
            }

        } else if (board.get(i) == 0) {
            System.out.println("not a movable piece");
        }
        return j;
    }

    public void movePiece(){
        if(canMove() && board.get(i)==1){
            System.out.println("(y)es?");
          String g = scan.nextLine();
          if (g.equals("y")){
              board.set(i + 1, board.get(i));
              board.set(i, 0);
              System.out.println(board);
          }
        } else if (canJump()&&board.get(i)==1) {
            System.out.println("(y)es?");
            String g = scan.nextLine();
            if (g.equals("y")) {
                board.set(i + 2, board.get(i));
                board.set(i, 0);
                System.out.println(board);
            }
        }
            else if(canMove() && board.get(i)==2){
                System.out.println("(y)es?");
            String g = scan.nextLine();
                if (g.equals("y")){
                    int x = board.get(i - 1);
                    board.set(i - 1, board.get(i));
                    board.set(i, 0);
                    System.out.println(board);
                }
            } else if (canJump()&&board.get(i)==2) {
                System.out.println("(y)es?");
                String g = scan.nextLine();
                if (g.equals("y")){
                    int x = board.get(i - 2);
                    board.set(i - 2, board.get(i));
                    board.set(i, 0);
                    System.out.println(board);
                }
        }
    }


    public boolean didWin(){
        if((board.equals(complete))){
            didWin=true;
        }
        return didWin;
    }

    public void printBoard(){
        System.out.println(board);
    }
    public ArrayList<Integer> getBoard(){
        return board;
    }
    public ArrayList<Integer> complete(){
        return complete;
    }

    public void setMoveCount(){
        moveCount++;
    }

    public int getMoveCount(){
        return moveCount;
    }

    public void isGenius(){
        if (moveCount<4){
            isGenius=true;
        }
    }

    public void winner() {
        if (quit ==true){
            System.out.println(" ");
        }
        else if (isGenius){
            System.out.println("Smarty pants, here's one million dollars!");
        } else{
            System.out.println("You won");
        }
    }
}


