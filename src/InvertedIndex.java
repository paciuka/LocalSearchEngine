import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class InvertedIndex {
    private Map<String, Set<String>> index;

    public InvertedIndex() {
        this.index = new HashMap<>();
    }

    public void addWord(String word, String filePath) {
        index.putIfAbsent(word, new HashSet<>());
        index.get(word).add(filePath);
    }

    public Set<String> search(String query) {
        List<String> queryWords = Tokenizer.extractWords(query);
        if (queryWords.isEmpty()) {
            return new HashSet<>();
        }
        String targetWord = queryWords.get(0);
        return index.getOrDefault(targetWord, new HashSet<>());
    }

    public Map<String, Set<String>> getIndex() {
        return index;
    }
}