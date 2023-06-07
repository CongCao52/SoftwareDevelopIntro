package hangman;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dictionary.HangmanDictionaryReader;

import java.util.ArrayList;
import java.util.List;


class TraditionalHangmanTest {
	HangmanDictionaryReader reader;
	TraditionalHangman hang;
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
	}

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
	}	

}
