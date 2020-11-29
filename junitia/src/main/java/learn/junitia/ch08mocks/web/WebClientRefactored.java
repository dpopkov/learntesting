package learn.junitia.ch08mocks.web;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/** Version of web client after refactoring. */
public class WebClientRefactored {

    public String getContent(URL url) {
        StringBuilder content = new StringBuilder();
        try (InputStream is = openConnection(url)) {
            readContent(is, content);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return content.toString();
    }

    private InputStream openConnection(URL url) throws IOException {
        HttpURLConnection connection = createHttpURLConnection(url);
        connection.setDoInput(true);
        return connection.getInputStream();
    }

    /** This factory method must be overridden in a sub class that will be used in unit testing. */
    protected HttpURLConnection createHttpURLConnection(URL url) throws IOException {
        return (HttpURLConnection) url.openConnection();
    }

    private void readContent(InputStream inputStream, StringBuilder content) throws IOException {
        byte[] bytes = new byte[1024 * 4];
        int count;
        while (-1 != (count = inputStream.read(bytes))) {
            content.append(new String(bytes, 0, count));
        }
    }
}
