import java.util.ArrayList;
import java.util.List;

public class Tokenizer {
    public static List<String> extractWords(String text) {
        List<String> validWords = new ArrayList<>();
        if (text == null || text.trim().isEmpty()) {
            return validWords;
        }
        String lowerCaseText = text.toLowerCase();
        String cleanedText = lowerCaseText.replaceAll("[^a-zA-Z0-9]", " ");
        String[] rawWords = cleanedText.split("\\s+");
        for (String word : rawWords) {
            if (!word.isEmpty()) {
                validWords.add(word);
            }
        }
        return validWords;
    }
}