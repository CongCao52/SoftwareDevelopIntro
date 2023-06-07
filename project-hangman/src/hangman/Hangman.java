package hangman;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * a hangman class to implement functions in hangman model
 */
public abstract class Hangman {
	
	//the list after cleaning.Ex[apple, banana...]
	public List<String> wordlist = new ArrayList<>();
	
	//the word that is guessed and it is wrong. Ex [a,e,q,f]
	public List<String> wrongwords = new ArrayList<>();
	
	//total guesses
	public List<String> totalwords = new ArrayList<>();
	
	//true false string to judge whether the game is over
	public boolean[] correct;
	
	//number of guess in total
	public int guess;
	
	//number of guess that is wrong
	public int wrongguess;
	
	
	//the word that randomly select
	public String word; 
	
	//the word length
	public int length;
	
	//the letter that we guessed. ex."____" or "_a__b__"
	public String[] lettersGuessed;
	
	//read the inputs
	public Scanner myScanner;
	

	
	Hangman(List<String> dict){
		// initialized the word list (make sure the right word list is select)
		this.wordlist = dict;
		
		//randomly choose the word
		this.word = this.getword();
		
		//get the length of the word into length variable. 
		this.length = word.length();
		
		//True/False Arraylist that used to decide if the game is over
		this.correct = new boolean[this.length];
		
		//initialized guess, wrongguess and lettersGuessed
		this.guess = 0;
		this.wrongguess=0;
		this.lettersGuessed = new String[this.length];
		
		for(int i=0; i<this.getlength();i++) {
			this.lettersGuessed[i] = "_";	
			//System.out.print(this.lettersGuessed[i]+" ");
		}
	/*	for(int i=0; i<this.lettersGuessed.length; i++) {
			System.out.print(this.lettersGuessed[i]+" "); }
		*/
	}
	
	/**
	 * This method that return a word randomly.
	 * @param null
	 * @return w (a random word)
	 */
	String getword() {
		Random r = new Random();
		int num =r.nextInt(this.wordlist.size());
		String w = this.wordlist.get(num);
		return w;
	}
	
	/**
	 * This method get the word length.
	 * @param null
	 * @return the length of word
	 */
	 int getlength() {
		  return this.word.length();
	  }
	 /**
		 * This method to determine if the word is correct.
		 * @param str
		 * @return true (if correct) / false
		 */
	
	 abstract boolean isCorrect(String str);
	 
	 
	 /**
		 * This method to return the type of string.
		 * @param null
		 * @return the type of game(string)
		 */
	 abstract String GameType();
	 
	 /**
		 * print the result for the debug model.
		 * @param null
		 * @return null
		 */
	 
	 abstract void debugprint();
	 
	 
	 /**
		 * This method to get the input and see if the letter can be used.
		 * @param scan
		 * @return true (if correct) / false
		 */
	
	 public String guessLetter(Scanner scan){
	        //System.out.println("Guess a letter: ");
	        
	        
	        String n = scan.next();
	        //String letter = Character.toString(n.charAt(0));
	        while (this.checkguess(n)!=true){
	           n = scan.next();
	        }
	        this.guess = this.guess + 1;
	        this.totalwords.add(n);
	        //return letter;
	        return n;
	    }

	
	 /**
		 * This method check if the input can be used.
		 * @param scan
		 * @return true (if correct) / false
		 */
	 boolean checkguess(String str) {
		 boolean c = true;
		 if(str.contains(".")||str.contains("'")||str.contains("-")||str.contains(" ")||str.contains("'")||str.contains("!")||str.contains(";")||Character.isDigit(str.charAt(0))==true||Character.isLowerCase(str.charAt(0))!=true||str.length()!=1) {
			 c = false;
			 System.out.println("the input is invalid, please make another guess:");
		 }else {
			 //System.out.println("passed here");
		 for(int i=0; i<this.totalwords.size();i++) {
			 if(this.totalwords.contains(str)) {
				 c = false;
				 System.out.println("You already guessed that letter!, please make another guess:");
				 break;
			 }}			 
		 }
		 
		 return c;
	 }
	 
	 
	 /**
		 * This method to deal with incorrect guesses.I/O stream
		 * @param str
		 * @return null
		 */
	 public void wrongguesses(String str) {
		 this.wrongwords.add(str);
		 System.out.print("Incorrect Guesses: ");
		 for(int i = 0; i < this.wrongwords.size();i++) {
			 System.out.print(this.wrongwords.get(i)+" ");}
		 System.out.print("\n");	 
	 }
	 
	 
	 /**
		 * This method to print the current position and total number of guesses.I/O stream
		 * @param str
		 * @return null
		 */
	 public void printletterguessed() {
		    System.out.println("Guess a letter: ");
			for(int i=0; i<this.lettersGuessed.length; i++) {
				System.out.print(this.lettersGuessed[i]+" "); }
			System.out.print("\n");
			System.out.print("Total guesses: "+this.guess);
			System.out.print("\n");
			
		}

	 /**
		 * This method to check if the game is over
		 * @param null
		 * @return true(if the game is over) / false
		 */
	 public boolean GameOver() {
	 	 for(int i =0; i<this.correct.length; i++) {
	 		 if(!correct[i]) {
	 			 return false;
	 		 }
	 	 }
		 return true;
	 }
	 
	 
	 /**
		 * This method to print the final result.I/O stream
		 * @param null
		 * @return null
		 */
	 public void finalresult() {
	 System.out.println("The " + this.GameType() + " game is over.");
	 System.out.println("You guess " + this.guess + " times in total.");
	 System.out.println("You make " + this.wrongguess + " wrong guesses."); 
	 }
	  
		
	}
	
	
	
	
	
