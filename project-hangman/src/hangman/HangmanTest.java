package hangman;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dictionary.HangmanDictionaryReader;

import java.util.ArrayList;
import java.util.List;

/**
 * a unit test class to test the critical methods of abstract HangMan class
 * @author Cong Cao
 * @author Qifan Chen
 */
class HangmanTest {
	HangmanDictionaryReader reader;
	Hangman hang;
	Hangman hang2;
	public List<String> totalwords = new ArrayList<>();
	public List<String> wrongwords = new ArrayList<>();

	/**
	 * set up the test class
	 * parsing a real text file, use a txt as the original dictionary
	 * [apple, appoa, alpha, acces]
	 * fix the guessed length and test
	 * @throws Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		reader = new HangmanDictionaryReader("test_hangman.txt");
		List<String> dict_test =reader.getwordlist();
		hang = new TraditionalHangman(dict_test);
		hang2 = new EvilHangman(dict_test);
		hang.totalwords.add("a");
		this.wrongwords.add("f");
	}

	/**
	 * check for the computer randomly choose a word
	 */
	@Test
	void getword() {
		String a = hang.getword();
		//the text1 only contain word starts with a
		assertTrue(a.startsWith("a"));

		assertFalse(a.startsWith("A"));
	}

	/**
	 * check for input is correct according to instructions
	 */
	@Test
	void checkguess() {
		// A digit returns false
		assertEquals(false, hang.checkguess("2"));
		// Upper case letters return false
		assertEquals(false, hang.checkguess("arM"));
		// A hyphen, An apostrophe, words with spaces, Upper case letters returns false
		assertEquals(false, hang.checkguess("cat-like"));
		assertEquals(false, hang.checkguess("you're"));
		assertEquals(false, hang.checkguess("govt."));
		assertEquals(false, hang.checkguess("govt kid"));
		// cannot guess a same letter twice
		assertEquals(false, hang.checkguess("a"));
		assertEquals(true, hang.checkguess("b"));
	}

	/**
	 * check for the word's length is correctly got
	 */
	@Test
	void getlength() {
		//the word in test_hangman.txt has fixed length 5.
		assertEquals(5, hang.getlength());
		assertNotEquals(3, hang.getlength());
	}

	/**
	 * check for input is correctly according to word
	 */
	@Test
	void isCorrect() {
		//the word in test_hangman.txt has fixed beginning a.
		assertTrue(hang.isCorrect("a"));
		assertEquals(0,hang.wrongguess);

		//the word in test_hangman.txt doesn't contain v.
		assertFalse(hang.isCorrect("v"));
		assertEquals(1,hang.wrongguess);
	}

	/**
	 * check for type is correct according to instructions
	 */
	@Test
	void GameType() {
		assertEquals("Traditional Hangman", hang.GameType());
		assertEquals("Evil Hangman", hang2.GameType());
	}

	/**
	 * check for game over is correct according to instructions
	 */
	@Test
	void gameOver() {
		hang.getword();
		boolean[] booleans = {false,false,false,false,false};
		assertArrayEquals(hang.correct,booleans);
		assertArrayEquals(hang2.correct,booleans);

		assertFalse(hang.GameOver());
		assertFalse(hang2.GameOver());
	}

}