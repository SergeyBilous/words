package cheater.home;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Dictionary {
    private ArrayList<SingleWord> words;
    private String lettersList;

    public String getLettersList() {
        return lettersList;
    }

    public void setLettersList(String lettersList) {
        this.lettersList = lettersList;
    }

    public Dictionary(List<String> wordsList) {
        words = new ArrayList<>();
        for (String word : wordsList) {
            addWord(word);
        }
    }

    public Dictionary() {
        words = new ArrayList<>();
    }

    public void addWord(String word) {
        words.add(new SingleWord(word));
    }

    public List<SingleWord> getByTemplate(String template) {
        List<SingleWord> wordsByTemplate =
                words.stream().filter(w -> w.compareWithTemplate(template))

                        .collect(Collectors.toList());
        return wordsByTemplate;
    }
}
