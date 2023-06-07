import java.util.List;
import java.util.Random;
import java.util.Scanner;

import dictionary.HangmanDictionaryReader;
import hangman.EvilHangman;
import hangman.TraditionalHangman;

public class HangmanGame {
	
	/**
	 * This method that play the game.
	 * @param scan (get inputs), dict(dictionary), game(gamemode:evil or traditional), debug(either debugmode or not)
	 * @return null
	 */
	void TwoHangmanGames(Scanner scan, List<String> dict, boolean game, boolean debug) {
		String w;
		boolean correct;
		System.out.print("Welcome to Hangman! ");
		if(debug==true && game ==true) {
			System.out.print("[DEBUG MODEl: TRADITIONAL HANGMAN]");
		}else if (debug==true && game ==false){
			System.out.print("[DEBUG MODEl: EVIL HANGMAN]");
		}
		System.out.print("\n");
		
		if (game) {
			TraditionalHangman t = new TraditionalHangman(dict);
			while(true) {
				
				t.printletterguessed();
				if(debug) {
					t.debugprint();
				}
				w = t.guessLetter(scan);
				correct = t.isCorrect(w);
				if(!correct) {
					t.wrongguesses(w);
				}
				
				
				if(t.GameOver()) {
					break;
				}}
			t.finalresult();
		}else{
			EvilHangman e = new EvilHangman(dict);
			
			while(true) {
				
				
				e.printletterguessed();
				if(debug) {
					e.debugprint();
				}
				
				w = e.guessLetter(scan);
				e.changewordfamily(w);
				correct = e.isCorrect(w);
				if(!correct) {
					e.wrongguesses(w);}
				
				
				
				if(e.GameOver()) {
					break;}
				}
				e.finalresult();
			}
			
			
		}
	
	/**
	 * "gameMode": true means traditionalHangman, false means evilHangman.
	 */
	private boolean gameMode;
	/**
	 * "debugMode": true means debugmode, false means normal mode.
	 */
	private boolean debugMode;	
		
	
	
HangmanGame(){
	Random r = new Random();
	this.gameMode = r.nextBoolean();
	//debugMode = true;    //for debug model.  
	debugMode = false;  //the normal mode.
}
	
	




public static void main(String[] args) {
	    boolean play =true;
		String path = "words.txt";
		
		
		//creat a hangman dictionary
		HangmanDictionaryReader read = new HangmanDictionaryReader(path);
		// get the dictionary
		List<String> dict =read.getwordlist();
		Scanner scan = new Scanner(System.in);
		
		while (play==true) {
		HangmanGame game = new HangmanGame();
		game.TwoHangmanGames(scan, dict, game.gameMode, game.debugMode);
		
		System.out.println("Do you want to play again? y/n");
		boolean put = true;
		while(put) {
			String input = scan.next();
			
			if(input.contentEquals("y") || input.contentEquals("Y")) {
				play = true;
				break;
			}
			else if(input.contentEquals("n") || input.contentEquals("N")) {
				play =false;
				put= false;
			}else {
			System.out.println("Wrong Input, please try again!");
			}
		}
		}
		scan.close();
		System.out.println("Thanks for playing!");

}
		
	}
	
	
	
	
	
	
	
	
	
	

