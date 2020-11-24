package learn.junitia.ch02core.parametrized;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CsvSourceTest {
    private final WordCounter counter = new WordCounter();

    @ParameterizedTest
    @CsvSource({"2, Unit testing",
            "3, Spring in Action",
            "4, Write SOLID Java code"})
    void testWordsInSentence(int expected, String sentence) {
        assertEquals(expected, counter.countWords(sentence));
    }
}
