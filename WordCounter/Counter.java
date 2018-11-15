import java.util.HashMap;
import java.util.Map;

/*
 * ==== Counter ====
 * Class the counts the word occurrences.
 * 
 */
public class Counter implements WordCountService {
	
	/* Constructor */
	public Counter() {}

	/* Method we need to implement from the interface */
	@Override
	public Map<String, Integer> countWords(String text) {
		// Create Hash Map which will store our Words and Counts
		Map<String, Integer> wordMap = new HashMap<String, Integer>();
		// Replaced all full stops with a space. This was added late to prevent errors between paragraphs
		text = text.replace(".", " ");
		/* Replace all removes all punctuation, replaces with nothing
		 * To lower case to make all the words lower case to avoid error
		 * Splits the string into separate words
		 */
		String [] words = text.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");
		// Iterate through array
		for (String word : words) {
			if (wordMap.containsKey(word)) {
				wordMap.put(word, (wordMap.get(word) + 1));
			}
			else {
				wordMap.put(word, 1);
			}
		}
		return wordMap;
	}
}