package learn.junitia.ch02core.parametrized;

public class WordCounter {
    public int countWords(String text) {
        return text.split("\\s").length;
    }
}
