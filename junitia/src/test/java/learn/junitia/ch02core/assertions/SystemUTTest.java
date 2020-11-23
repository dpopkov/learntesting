package learn.junitia.ch02core.assertions;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static java.time.Duration.ofMillis;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("SystemUT должен")
class SystemUTTest {

    private static final String NAME = "System under test";

    private final SystemUT sut = new SystemUT(NAME);

    @Test
    @DisplayName("по-умолчанию не быть верифицированным")
    void testSystemNotVerified() {
        assertAll("By default, SystemUT is not under current verification",
                () -> assertEquals(NAME, sut.getName()),
                () -> assertFalse(sut.isVerified())
        );
    }

    @Test
    @DisplayName("после верификации быть верифицированным")
    void testSystemVerified() {
        sut.verify();
        assertAll("SystemUT under current verification",
                () -> assertEquals(NAME, sut.getName()),
                () -> assertTrue(sut.isVerified())
        );
    }

    @Test
    @DisplayName("выполнять задание не дольше 500 мс")
    void testTimeout() throws InterruptedException {
        sut.addJob(new Job("Job 1"));
        assertTimeout(ofMillis(500), () -> sut.run(200));
    }

    @Test
    @DisplayName("выполнять задание не дольше 500 мс, иначе остановить задание")
    void testTimeoutPreemptively() throws InterruptedException {
        sut.addJob(new Job("Job 1"));
        assertTimeoutPreemptively(ofMillis(500), () -> sut.run(200));
    }

    @Test
    @DisplayName("бросать NoJobException если нет задания")
    void testExpectedException() {
        assertThrows(NoJobException.class, sut::run);
    }

    @Test
    @DisplayName("бросать NoJobException с корректным сообщением")
    void testCatchException() {
        Throwable throwable = assertThrows(NoJobException.class, () -> sut.run(1000));
        assertEquals("No jobs on the execution list!", throwable.getMessage());
    }
}
