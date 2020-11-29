package learn.junitia.ch08mocks.web;

import java.io.IOException;
import java.io.InputStream;

public class WebClientRefactored2 {
    public String getContent(ConnectionFactory connectionFactory) {
        StringBuilder content = new StringBuilder();
        try (InputStream is = connectionFactory.getData()) {
            readContent(is, content);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return content.toString();
    }

    private void readContent(InputStream inputStream, StringBuilder content) throws IOException {
        byte[] bytes = new byte[1024 * 4];
        int count;
        while (-1 != (count = inputStream.read(bytes))) {
            content.append(new String(bytes, 0, count));
        }
    }
}
