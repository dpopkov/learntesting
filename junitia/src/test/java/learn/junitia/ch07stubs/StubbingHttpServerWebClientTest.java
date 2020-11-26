package learn.junitia.ch07stubs;

import org.eclipse.jetty.http.HttpHeader;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.AbstractHandler;
import org.eclipse.jetty.util.ByteArrayISO8859Writer;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.*;

class StubbingHttpServerWebClientTest {
    private static final int PORT = 8082;

    private final WebClient client = new WebClient();

    @BeforeAll
    static void setUp() throws Exception {
        Server server = new Server(PORT);
        server.setHandler(new TestGetContentOkHandler());
        server.setStopAtShutdown(true); // the server instance is explicitly stopped when the JVM is shut down.
        server.start();
    }

    @AfterAll
    static void tearDown() {
        // empty
    }

    @Test
    public void testGetContentOk() throws MalformedURLException {
        String workingContent = client.getContent(new URL("http://localhost:" + PORT));
        assertEquals("Jetty works!", workingContent);
    }

    private static class TestGetContentOkHandler extends AbstractHandler {
        @Override
        public void handle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response)
                throws IOException {
            OutputStream out = response.getOutputStream();
            ByteArrayISO8859Writer writer = new ByteArrayISO8859Writer();
            writer.write("Jetty works!");
            writer.flush();
            response.setIntHeader(HttpHeader.CONTENT_LENGTH.toString(), writer.size());
            writer.writeTo(out);
            out.flush();
        }
    }
}
