package hangman;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;


/**
 * a evilhangman class to implement functions in Evil hangman model
 * @author Cong Cao
 * @author Qifan Chen
 */

public class EvilHangman extends Hangman {
	
	public List<String> evilwordlist = new ArrayList<>();
	Map<String,List<String>> family = new HashMap<String,List<String>>();
	
	public EvilHangman(List<String> path){
		super(path);
		//initialized evilwordlist (make a copy)
        
		for(int i=0; i<this.wordlist.size(); i++) {
			// add the word if the length equals
			if(this.wordlist.get(i).length() == this.getlength())
				this.evilwordlist.add(this.wordlist.get(i));
		}
		
	}
	 
	/**
	 * This method to print the gametype
	 * @param null
	 * @return string
	 */
	String GameType() {
		return "Evil Hangman";
	}
	
	/**
	 * This method to return the game type.
	 * @param str
	 * @return true(if your guess is correct) / false
	 */
	
	 public boolean isCorrect(String str) {
			
			boolean c = false;
			
			for(int i=0; i<this.lettersGuessed.length; i++) {
				if(this.lettersGuessed[i].contains(str))
				{
					this.correct[i] = true;
					c = true;
					}
			}
			
			// update the mistakes
			if(!c) {
				this.wrongguess += 1;}
			
			return c;
		}
	
	
		/**
		 * This method to change the word group
		 * @param str
		 * @return null
		 */
	public void changewordfamily(String str) {

		this.family.clear();

		for(int i=0; i<this.evilwordlist.size(); i++) {
			// set the key
			String key = "";
			//get the copy of lettersGuessed. 
			String[] letterGuessedCopy = this.lettersGuessed.clone();
			
			String word = this.evilwordlist.get(i);
			
			List<String> value = new ArrayList<>();
			// check each char of the word
			for(int j=0; j<this.getlength(); j++) {
				// check whether the char has been guessed
				if(letterGuessedCopy[j].contains("_") &&(str.charAt(0) == word.charAt(j)) ) {	
						letterGuessedCopy[j] = str;
			}
			}
			
			// get the key
			for(int k=0; k<letterGuessedCopy.length; k++)
				{key += letterGuessedCopy[k];}
			
			if(!this.family.containsKey(key)) {
				value.add(word);
				this.family.put(key, value);
			}
			else {
				value = this.family.get(key);
				value.add(word);
				this.family.replace(key, value);
			}
		}
		
		// find the largest words family
		int len1 =0;
		int len2 = 0;
		String mykey = null;
		for(Entry<String, List<String>> entry: this.family.entrySet()) {
		len2 = entry.getValue().size();
		if (len2>len1) {
		len1 = len2;
		mykey = entry.getKey();}
		}
		
		List<String> newFamily = this.family.get(mykey);
		
		this.evilwordlist.clear();
		this.evilwordlist = newFamily;
		
		
		for(int l=0; l<this.lettersGuessed.length; l++) {
			this.lettersGuessed[l] = String.valueOf(mykey.charAt(l));}
	
		
	}
	
 public void debugprint() {
		 System.out.print("Current Word list Sample : ");
		 int length =this.evilwordlist.size();
		 if(length<10) {
		for(int i = 0; i < this.evilwordlist.size();i++) {
			System.out.print(this.evilwordlist.get(i)+" ");}
		 }else {
		for(int i = 0; i < 10;i++) {
			System.out.print(this.evilwordlist.get(i)+" ");}
		    System.out.print("...");
		 }
		 
		 System.out.print("\n");
		 
		 
	 }
	
	
	
}
	


