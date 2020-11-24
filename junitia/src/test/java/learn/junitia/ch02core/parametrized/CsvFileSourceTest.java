package learn.junitia.ch02core.parametrized;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CsvFileSourceTest {
    private final WordCounter counter = new WordCounter();

    @ParameterizedTest
    @CsvFileSource(resources = "/for_csv_file_source.csv")
    void testWordsInSentence(int expected, String sentence) {
        assertEquals(expected, counter.countWords(sentence));
    }
}
