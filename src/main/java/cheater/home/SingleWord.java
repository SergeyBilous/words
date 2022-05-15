package cheater.home;

public class SingleWord {
    private final String word;

    public String getWord() {
        return word;
    }

    public SingleWord(String word) {
        this.word = word.toLowerCase();
    }

    public boolean compareWithTemplate(String template) {
        if (template.length() != word.length()) {
            return false;
        }
        for (int i = 0; i < word.length(); i++) {
            if (template.charAt(i) == '-') {
                continue;
            }
            if (template.charAt(i) != word.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public boolean checkRestrictions(String letters) {
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
