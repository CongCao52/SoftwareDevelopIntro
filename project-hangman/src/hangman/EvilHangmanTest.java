package hangman;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dictionary.HangmanDictionaryReader;

import java.util.HashSet;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dictionary.HangmanDictionaryReader;

import java.util.ArrayList;
import java.util.List;

/**
 * a unit test class to test the critical method of EvilHangMan class
 * @author Cong Cao
 * @author Qifan Chen
 */
class EvilHangmanTest {
	HangmanDictionaryReader reader;
    EvilHangman evilHangman;

    /**
     * set up the test class
     * rather than parsing a real text file, use an ArrayList as the original dictionary
     * [ah, ally, cool, good, else, hope, double]
     * force the guessed length, number of guesses and see number of remaining words
     * @throws Exception
     */
    @BeforeEach
    void setUp() throws Exception {
    	reader = new HangmanDictionaryReader("test_evilhangman.txt");
    	List<String> dict_test =reader.getwordlist();
        evilHangman = new EvilHangman(dict_test);
        
    	int len = evilHangman.word.length();

    	while(len !=4) {
            evilHangman = new EvilHangman(dict_test);
            len = evilHangman.word.length();
    	}
    	
    
    
    }
    /**
     * check for the word list update correctly according to the guessed letter
     */
    @Test
    void changewordfamily() {
    	
    	
    	assertEquals(5, evilHangman.evilwordlist.size());
  
    	
        assertEquals(evilHangman.evilwordlist.get(0), "ally");
        assertEquals(evilHangman.evilwordlist.get(1), "cool");
        assertEquals(evilHangman.evilwordlist.get(2), "good");
        assertEquals(evilHangman.evilwordlist.get(3), "else");
        assertEquals(evilHangman.evilwordlist.get(4), "hope");

        // check for the word list update correctly according to the guessed letter
        // guess "e" first
        evilHangman.changewordfamily("e");
 //     two word list is given[ally, cool good] and [else, hope]. then choose the first list. 
        assertEquals(evilHangman.evilwordlist.size(), 3);
        assertEquals(evilHangman.evilwordlist.get(0), "ally");
        assertEquals(evilHangman.evilwordlist.get(1), "cool");
        assertEquals(evilHangman.evilwordlist.get(2), "good");

        // then guess "o"
        evilHangman.changewordfamily("o");
        assertEquals(evilHangman.evilwordlist.size(), 2);
        assertEquals(evilHangman.evilwordlist.get(0), "cool");
        assertEquals(evilHangman.evilwordlist.get(1), "good");

    } 
    /**
	 * check for input is correctly according to word
	 */
    @Test
    void isCorrect() {
    	assertFalse(evilHangman.isCorrect("z"));
    	assertEquals(1,evilHangman.wrongguess);
    	
    	assertFalse(evilHangman.isCorrect("v"));
    	assertEquals(2,evilHangman.wrongguess);
    	
    }
    /**
	 * check for type is correct according to instructions
	 */
    @Test
    void GameType() {
    	assertEquals("Evil Hangman", evilHangman.GameType());
    } 
    
    
}