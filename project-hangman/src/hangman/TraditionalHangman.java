package hangman;

import java.util.List;
/**
 * a traditionalhangman class to implement functions in traditional hangman model
 * @author Cong Cao
 * @author Qifan Chen
 */

public class TraditionalHangman extends Hangman {
	
	public TraditionalHangman(List<String> path){
		super(path);	
	}
	
	 /**
	 * This method to return the game type.
	 * @param null
	 * @return string
	 */
	String GameType() {
		return "Traditional Hangman";
	}
	
	 public void debugprint() {
		 
		 System.out.println("Current Word: "+this.word);
		 
	 }
	
	
	
	/**
	 * This method to return the game type.
	 * @param str
	 * @return true(if your guess is correct) / false
	 */
	public boolean isCorrect(String str) {
		boolean check =false;
		
		for(int i = 0; i<this.getlength();i++) {
			if(str.charAt(0) == this.word.charAt(i)) {
				check = true;
				this.correct[i] = true;
				this.lettersGuessed[i] = str;
			}
			
		}
		
		if(!check) {
			this.wrongguess= this.wrongguess+1;
		}
		//this.guess =this.guess+1;
		
		return check;
	}
	
	

}