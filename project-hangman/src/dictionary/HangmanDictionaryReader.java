package dictionary;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * a dictionary reader class to read the dictionary from txt file
 * @author Cong Cao
 * @author Qifan Chen
 */

public class HangmanDictionaryReader {
	
	String source;

	public HangmanDictionaryReader(String path){
		source = path;
	}
	
	
	/**
	 * This method reads the file and get the correct words.
	 * @param path
	 * @return words (list of correct words)
	 */
	public List<String> getwordlist(){
		List<String> words = new ArrayList<>();
	    try {
	    	BufferedReader br = new BufferedReader(new FileReader(source));
	    	String lst =br.readLine().strip();
	    	while(lst != null) {
	    		if(this.addwords(lst)==true) {
	    			words.add(lst);
	    			
	    		}
	    		lst = br.readLine();
	    	}
	    	br.close();
	    } catch(IOException ioe) {
	    	ioe.printStackTrace();
	    }
	return words;
	}

	
	
	/**
	 * This method to determine if the word is display correctly.
	 * @param str
	 * @return ture (if correct) / false
	 */	
	boolean addwords(String str) {
		  boolean add = true;
		  
		  for(int i=0; i<str.length();i++) {
			  if(Character.isDigit(str.charAt(i))) {
				  add =false;
				  
			  } 
			  if(Character.isUpperCase(str.charAt(i))) {
				  add = false;
			  }
			  
		  }
		  
		if(str.contains(".")||str.contains("'")||str.contains("-")||str.contains(" ")||str.contains("'")) {
			add =false;
		}
		//System.out.print(add);
		//System.out.print("\n");
		return add;
	  } 
	    
	
	
	
}
