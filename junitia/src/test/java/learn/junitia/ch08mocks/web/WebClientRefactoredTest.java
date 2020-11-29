package learn.junitia.ch08mocks.web;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.*;

class WebClientRefactoredTest {

    @Test
    void testGetContentOk() throws MalformedURLException {
        MockHttpURLConnection mockConnection = new MockHttpURLConnection();
        mockConnection.setExpectedInputStream(new ByteArrayInputStream("It works".getBytes()));
        TestableWebClient clientWithTrapDoor = new TestableWebClient();
        clientWithTrapDoor.setHttpURLConnection(mockConnection);

        @SuppressWarnings("UnnecessaryLocalVariable")
        WebClientRefactored client = clientWithTrapDoor;
        String actualContent = client.getContent(new URL("http://any.url.at.all"));
        assertEquals("It works", actualContent);
    }
}
