package learn.junitia.ch07stubs;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.net.*;

import static org.junit.jupiter.api.Assertions.*;

class StubbingConnectionWebClientTest {

    public static final String TEST_CONTENT = "Jetty works";

    @BeforeAll
    static void setUp() {
        URL.setURLStreamHandlerFactory(new StubStreamHandlerFactory());
    }

    private static class StubStreamHandlerFactory implements URLStreamHandlerFactory {

        @Override
        public URLStreamHandler createURLStreamHandler(String protocol) {
            return new StubHttpUrlStreamHandler();
        }
    }

    private static class StubHttpUrlStreamHandler extends URLStreamHandler {
        @Override
        protected URLConnection openConnection(URL u) {
            return new StubHttpURLConnection(u, TEST_CONTENT);
        }
    }

    @Test
    void testGetContentOk() throws MalformedURLException {
        WebClient client = new WebClient();
        String actualContent = client.getContent(new URL("http://any-host:1234/"));
        assertEquals(TEST_CONTENT, actualContent);
    }
}
