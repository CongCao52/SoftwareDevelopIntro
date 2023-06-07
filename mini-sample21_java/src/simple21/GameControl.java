package simple21;


import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;

/**
 * This is a simplified version of a common card game, "21". 
 */
public class GameControl {
    
	/**
	 * Human player.
	 */
    HumanPlayer human;
    
    /**
     * Computer player.
     */
    ComputerPlayer player1;
    
    /**
     * Computer player.
     */
    ComputerPlayer player2;
    
    /**
     * Computer player.
     */
    ComputerPlayer player3;
    
    /** 
     * A random number generator to be used for returning random "cards" in a card deck.
     * */
    Random random = new Random();
    
    /**
     * The main method just creates a GameControl object and calls its run method.
     * @param args Not used.
     */
    public static void main(String args[]) {    
        new GameControl().run();
    }
    
    /**
     * Prints a welcome method, then calls methods to perform each of the following actions:
     * - Create the players (one of them a Human)
     * - Deal the initial two cards to each player
     * - Control the play of the game
     * - Print the final results
     */
    public void run() {
    	
        Scanner scanner = new Scanner(System.in);
        
        // Students: your code goes here.
        System.out.println("Welcome to the game of 21!");
        System.out.print("What is your name?  ");
        //human player enter the name
        String human_name = scanner.next();
        // create human player by name
        this.createPlayers(human_name);
        //roll first two cards for each player one hidden and one visible
        this.deal(); 
        
        while(this.checkAllPlayersHavePassed() !=true ) {
        	this.controlPlay(scanner); 	
        }
        printResults(); 
        scanner.close();
    }
    
    /**
     * Creates one human player with the given humansName, and three computer players with hard-coded names.
     * @param humansName for human player
     */
    public void createPlayers(String humansName) {
       // Students: your code goes here.
       //create human player, computer player one and two
    this.human = new HumanPlayer(humansName);
    this.player1 = new ComputerPlayer("player1");
    this.player2 = new ComputerPlayer("player2");
    this.player3 = new ComputerPlayer("player3"); 
    }
    
    /**
     * Deals two "cards" to each player, one hidden, so that only the player who gets it knows what it is, 
     * and one face up, so that everyone can see it. (Actually, what the other players see is the total 
     * of each other player's cards, not the individual cards.)
     */
    public void deal() { 
        // Students: your code goes here.
        //draw two cards for each player
    	this.human.takeHiddenCard(this.nextCard());
        this.human.takeVisibleCard(this.nextCard());
        
        this.player1.takeHiddenCard(this.nextCard());
        this.player1.takeVisibleCard(this.nextCard());
        
        this.player2.takeHiddenCard(this.nextCard());
        this.player2.takeVisibleCard(this.nextCard());
        
        this.player3.takeHiddenCard(this.nextCard());
        this.player3.takeVisibleCard(this.nextCard());
    }
    
    /**
     * Returns a random "card", represented by an integer between 1 and 10, inclusive. 
     * The odds of returning a 10 are four times as likely as any other value (because in an actual
     * deck of cards, 10, Jack, Queen, and King all count as 10).
     * 
     * Note: The java.util package contains a Random class, which is perfect for generating random numbers.
     * @return a random integer in the range 1 - 10.
     */
    public int nextCard() { 
    	// Students: your code goes here.
        //roll a random number from 1-13
    	int cardnumber = random.nextInt(12) + 1;
        // Jack Queen and King all count as 10 
    	if(cardnumber>10) {cardnumber = 10;}
    	
    	return cardnumber;
    		
    }

    /**
     * Gives each player in turn a chance to take a card, until all players have passed. Prints a message when 
     * a player passes. Once a player has passed, that player is not given another chance to take a card.
     * @param scanner to use for user input
     */
    public void controlPlay(Scanner scanner) { 
        // Students: your code goes here.
    	//get know each player's response by offerCard function. 
    	boolean[] player_response = {human.offerCard(human, player1,player2,player3,scanner), player1.offerCard(human, player1,player2,player3), player2.offerCard(human, player1,player2,player3), player3.offerCard(human, player1,player2,player3)}; 	
    	// for each player, get the next card if the response is true, pass o/w 
        if(player_response[0]==true) {human.takeVisibleCard(this.nextCard());}
    	else {System.out.println(human.name + " Pass");
    	human.passed = true;}
    	
        if(player_response[1]==true) {player1.takeVisibleCard(this.nextCard());}
    	else {System.out.println(player1.name + " Pass");
    	player1.passed = true;}
    	
        if(player_response[2]==true) {player2.takeVisibleCard(this.nextCard());}
    	else {System.out.println(player2.name + " Pass");
    	player2.passed = true;}
    	
        if(player_response[3]==true) {player3.takeVisibleCard(this.nextCard());}
    	else {System.out.println(player3.name + " Pass");
    	player3.passed = true;}
    }
     
    /**
     * Checks if all players have passed.
     * @return true if all players have passed
     */
    public boolean checkAllPlayersHavePassed() {
    	// Students: your code goes here.
        // will return true if all the players want to passed 
    	boolean p = human.passed && player1.passed && player2.passed && player3.passed;
    	return p;
    }
    
    /**
     * Prints a summary at the end of the game.
     * Displays how many points each player had, and if applicable, who won.
     */
    public void printResults() { 
        // Students: your code goes here.
        System.out.println("Game Over.");
        //print each player's result
    	System.out.println(human.name + " has " + human.getScore() + " points.");
    	System.out.println(player1.name + " has " + player1.getScore() + " points.");
    	System.out.println(player2.name + " has " + player2.getScore() + " points.");
    	System.out.println(player3.name + " has " + player3.getScore() + " points.");
    	
        //print the winner's result
        this.printWinner();
    	
    }

    /**
     * Determines who won the game, and prints the results.
     */
    public void printWinner() { 
        // Students: your code goes here.
        
        //put all score in a array
    	int[] point = {human.getScore(), player1.getScore(),player2.getScore(),player3.getScore()}; 
    	// get point 0 if the point exceed 21
    	for(int i = 0; i< point.length;i++) {
    		if(point[i]>21) { point[i] = 0;}
    	}
    	// sort array to get the largest point
    	int[] point_sort = point; 
    	Arrays.sort(point_sort);
        
        //print winner's information, no one win if the the two players' points are large and the same. 
    	if(point_sort[2] == point_sort[3]) {
    		System.out.println("No one wins!"); 
    	}else if(point_sort[3] == point[0]) {
    		 System.out.println("Human wins with " + point[0] + " points!");	
    	}else if(point_sort[3] == point[1]) {
    		 System.out.println("Player1 wins with " + point[1] + " points!");	
    	}else if(point_sort[3] == point[2]) {
    		 System.out.println("Player2 wins with " + point[2] + " points!");	
    	}else if(point_sort[3] == point[3]) {
    		 System.out.println("Player3 wins with " + point[3] + " points!");;	
    	}
    	
    	
    	
    	}  		  	
}

