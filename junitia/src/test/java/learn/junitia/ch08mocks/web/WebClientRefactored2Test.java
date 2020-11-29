package learn.junitia.ch08mocks.web;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.*;

class WebClientRefactored2Test {

    @Test
    void testGetContentOk() {
        MockConnectionFactory connectionFactory = new MockConnectionFactory();
        connectionFactory.setData(new ByteArrayInputStream("It works".getBytes()));

        WebClientRefactored2 client = new WebClientRefactored2();
        String actual = client.getContent(connectionFactory);
        assertEquals("It works", actual);
    }
}
