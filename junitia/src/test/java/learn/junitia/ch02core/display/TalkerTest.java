package learn.junitia.ch02core.display;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Talker должен")
class TalkerTest {
    private final Talker talker = new Talker();

    @Test
    @DisplayName("говорить Hello.")
    void testHello() {
        assertEquals("Hello", talker.hello());
    }

    @Test
    @DisplayName("спрашивать Как дела?")
    void testTalking() {
        assertEquals("How are you?", talker.talk());
    }

    @Disabled("Этот метод пока в процессе доработки")
    @Test
    @DisplayName("говорить Пока.")
    void testBye() {
        assertEquals("Bye", talker.bye());
    }
}
