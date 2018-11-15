import static org.junit.Assert.assertEquals;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
/*
 * ==== Counter Test ====
 * List of JUnit tests for Counter class
 */
public class CounterTest {
	
	private Counter wordCount;
	private Map<String, Integer> testMap;
	private final String [] testSentence = {"test", "sentence", "for", "testing", "the", "word", "counter", "program"};
	// Called to set up before each test
	@BeforeEach
	public void setUp() {
		wordCount = new Counter();
		testMap = new HashMap<String, Integer>();
		for (String word : testSentence) {
			testMap.put(word, 1);
		}
	}
	// Tests if the counts are the same
	@Test
	public void testSentence() {
		String test = "test sentence for testing the word counter program";
		assertEquals(testMap, wordCount.countWords(test));
	}
	// Tests if it works with capitalisation
	@Test
	public void testCapitalisation() {
		String test = "TEST SENTENCE FOR TESTING THE WORD COUNTER PROGRAM";
		assertEquals(testMap, wordCount.countWords(test));
	}
	// Tests if it works with punctuation
	@Test
	public void testPunctuation() {
		String test = "Test, sentence' for! testing? the; word. counter& program:";
		assertEquals(testMap, wordCount.countWords(test));
	}
}