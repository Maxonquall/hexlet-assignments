package exercise;


import java.util.ArrayList;
import java.util.List;

public class App {
    public static boolean scrabble(String symbols, String word) {
        char[] symbolsChar = symbols.toCharArray();
        char[] wordChar = word.toLowerCase().toCharArray();
        List<Character> checkList = new ArrayList<>();
        for (int j = 0; j < symbolsChar.length; j++) {
            checkList.add(symbolsChar[j]);
        }
        for (int i = 0; i < word.length(); i++) {
            if (checkList.contains(wordChar[i])) {
                checkList.remove((Character) wordChar[i]);
            } else {
                return false;
            }
        }
        return true;
    }
}


