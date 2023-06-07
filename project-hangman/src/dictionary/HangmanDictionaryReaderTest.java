package dictionary;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

/**
 * a unit test class to test the critical method of HangmanDictionaryReaderTest class
 * @author Cong Cao
 * @author Qifan Chen
 */

class HangmanDictionaryReaderTest {
	HangmanDictionaryReader reader = new HangmanDictionaryReader("test_dictionary.txt");
	List<String> compare = new ArrayList<String>();
	
	@Test
	/**
	 * check for the word list update correctly according to the instructions
	 */
	void testaddwords() {
		// A digit returns false
		
		assertEquals(false, reader.addwords("2"));
		// Upper case letters return false
		assertEquals(false, reader.addwords("arM"));
		// A hyphen, An apostrophe, words with spaces, Upper case letters returns false
		assertEquals(false, reader.addwords("cat-like"));
	    assertEquals(false, reader.addwords("you're"));
		assertEquals(false, reader.addwords("govt."));
		assertEquals(false, reader.addwords("govt kid"));
		assertEquals(true, reader.addwords("govt"));
	}
	
	
	@Test
	/**
	 * check for the word list update correctly read to the dictionary. 
	 */	
	void testgetwordlist() {
		List<String> sample_list = reader.getwordlist();
		compare.add("fruits");
		compare.add("orange");
		compare.add("banana");
		compare.add("watermelon");
		compare.add("apple");
		assertEquals(compare,sample_list);
		compare.add("others");
		assertNotEquals(compare,sample_list);
		
	}
	

}
