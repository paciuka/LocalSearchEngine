import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class FileIndexer {
    public static void indexFile(String filePath, InvertedIndex invertedIndex) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                List<String> words = Tokenizer.extractWords(line);
                for (String word : words) {
                    invertedIndex.addWord(word, filePath);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + filePath);
        }
    }
}