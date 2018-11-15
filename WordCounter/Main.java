import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
	/* Main method */
	public static void main(String[] args) {
		// Create counter object
		Counter wordCounter = new Counter();
		// Prints the word counts to the console. The file must be hard coded into this line
		System.out.println(Arrays.asList(wordCounter.countWords(loadText("wordcount-test-sample_war_of_the_worlds.txt"))));	
	}
	
	/* Static method which handles the file reading */
	public static String loadText(String fileName) {
		// String builder for append
		StringBuilder fileOutput = new StringBuilder();
		try {
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			String line = "";
			while ((line = br.readLine()) != null) {
				fileOutput.append(line);
			}
			br.close();
		}
		// If the path name of the file does not exist
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		// I/O exception
		catch (IOException e) {
			e.printStackTrace();
		}
		return fileOutput.toString();
	}
}
