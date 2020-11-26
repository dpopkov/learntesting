package learn.junitia.ch07stubs;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.*;

@Disabled("Это лишь начальный шаблон для теста и не предназначен для запуска.")
class WebClientSkeletonTest {

    @BeforeAll
    static void startJetty() {
    }

    @AfterAll
    static void stopJetty() {
    }

    @Test
    void testGetContent() throws MalformedURLException {
        WebClient client = new WebClient();
        String actualContent = client.getContent(new URL("http://localhost:8082/"));
        assertEquals("Jetty works", actualContent);
    }
}