package battleship;
import java.util.Scanner;

/**
 * BattleShipGame is the "main" class containing the main method
 * which starts by creating an instance of Ocean.
 * In this class you will set up the game
 *  <ul>
 *  <li>Accept play from the user
 *  <li>Display the results
 *  <li>Print final scores
 *  <li>Ask the user if he/she wants to play again
 *  </ul>
 *  <p>
 * @version 5th
 */
public class BattleshipGame {
    public Ocean ocean = new Ocean();

    public BattleshipGame() {
        this.ocean.placeAllShipsRandomly();
    }

    public static int[] StringConvert(String str) {
        String[] strList = str.split(",");
        int[] intList = new int[strList.length];

        for(int i = 0; i < strList.length; ++i) {
            intList[i] = Integer.parseInt(strList[i]);
        }

        return intList;
    }

    public static boolean errorChecking(String str) {
        return str.length() == 3 && str.charAt(1) == ',' && Character.isDigit(str.charAt(0)) && Character.isDigit(str.charAt(2));
    }

    public static void main(String[] args) {
 
    	boolean contChoice = true;

        while(contChoice) {
            BattleshipGame newgame = new BattleshipGame();
            Scanner scanner = new Scanner(System.in);
            System.out.println("The Location of Battleship!");
            newgame.ocean.printWithShips();
            System.out.println("Welcome to Battleship Game!");
            

            String strInput;
            for(boolean gameOver = false; !gameOver; gameOver = newgame.ocean.isGameOver()) {
                newgame.ocean.print();
                System.out.println("Total shots fired: " + newgame.ocean.getShotsFired());
                System.out.println("Hit count: " + newgame.ocean.getHitCount());
                System.out.println("Total sunk ships: " + newgame.ocean.getShipsSunk());
                System.out.println("Please make a move, enter row,column:");

                for(strInput = scanner.next(); !errorChecking(strInput); strInput = scanner.next()) {
                    System.out.println("Illegal input, please enter two integer\nfrom 0 to 9 separated by comma, eg '1,2' ");
                }

                int row = StringConvert(strInput)[0];
                int column = StringConvert(strInput)[1];
                newgame.ocean.shootAt(row, column);
                newgame.ocean.changeDisplay(row, column);
                
            }

            newgame.ocean.print();
            System.out.println("Game over!");
            System.out.println("Total shots fired: " + newgame.ocean.getShotsFired());
            System.out.println("Total hit: " + newgame.ocean.getHitCount());
            System.out.println("Would you like to play again? Enter 'n' to exit, otherwise to continue.");
            strInput = scanner.next();
            if (strInput.equals("n")) {
                contChoice = false;
            }
        }

        System.out.println("Thanks to play, Bye~");
    
    }
    
    
}
