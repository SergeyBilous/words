package cheater.home;

import java.util.HashSet;
import java.util.Set;

public class SingleWord {
    private String word;


    public SingleWord(String word) {
        this.word = word.toLowerCase();
    }

    public boolean compareWithTemplate(String template) {
        if (template.length() != word.length()) {
            return false;
        }
        for (int i = 0; i < word.length(); i++) {
            if (template.charAt(i) == '_') {
                continue;
            }
            if (template.charAt(i) != word.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    private boolean checkRestrictions(String letters) {
        for (int i = 0; i < word.length(); i++) {
            if (numOfLetters(this.word, word.charAt(i)) > numOfLetters(letters, word.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private static int numOfLetters(String word, char letter) {
        int counter = 0;
        for (int i = 0; i < word.length(); i++) {
            if (letter == word.charAt(i)) {
                counter++;
            }
        }
        return counter;
    }
}
