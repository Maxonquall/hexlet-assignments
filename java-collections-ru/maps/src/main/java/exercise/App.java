package exercise;

import java.util.HashMap;
import java.util.Map;

class App {
    public static Map<String, Integer> getWordCount(String sentence) {
        var words = sentence.split(" ");
        var wordsFrequency = new HashMap<String, Integer>();
        if (sentence.isEmpty()) {
            return wordsFrequency;
        }
        for (var word : words) {
            var count = wordsFrequency.getOrDefault(word, 0);
            wordsFrequency.put(word, count + 1);
        }
        return wordsFrequency;
    }
    public static String toString(Map<String, Integer> wordsFrequency) {
        if (wordsFrequency.isEmpty()) {
            return "{}";
        }
        String result = "{\n";
        var words = wordsFrequency.keySet();
        for (var word : words) {
            result = result + "  " + word + ": " + wordsFrequency.get(word) + "\n";
        }
        result = result + "}";
        return result;
    }
}
