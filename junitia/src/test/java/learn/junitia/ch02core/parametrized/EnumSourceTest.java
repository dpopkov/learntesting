package learn.junitia.ch02core.parametrized;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.EnumSource.Mode.EXCLUDE;

public class EnumSourceTest {
    private final WordCounter counter = new WordCounter();

    @ParameterizedTest
    @EnumSource(Sentences.class)
    void testWordsInSentence(Sentences sentence) {
        assertEquals(3, counter.countWords(sentence.value()));
    }

    @ParameterizedTest
    @EnumSource(value=Sentences.class, names = {"SPRING_IN_ACTION", "THREE_WORDS"})
    void testSelectedWordsInSentence(Sentences sentence) {
        assertEquals(3, counter.countWords(sentence.value()));
    }

    @ParameterizedTest
    @EnumSource(value=Sentences.class, mode = EXCLUDE, names = {"THREE_WORDS"})
    void testExcludedWordsInSentence(Sentences sentence) {
        assertEquals(3, counter.countWords(sentence.value()));
    }

    enum Sentences {
        SPRING_IN_ACTION("Spring in Action"),
        SOME_PARAMETERS("Check some parameters"),
        THREE_WORDS("Check three words");

        private final String sentence;

        Sentences(String sentence) {
            this.sentence = sentence;
        }

        public String value() {
            return sentence;
        }
    }
}
