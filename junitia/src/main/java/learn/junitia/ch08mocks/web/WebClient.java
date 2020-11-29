package learn.junitia.ch08mocks.web;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/** Source version of web client before refactoring. */
public class WebClient {
    public String getContent(URL url) {
        StringBuilder content = new StringBuilder();
        try (InputStream is = openConnection(url)) {
            readContent(content, is);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return content.toString();
    }

    private InputStream openConnection(URL url) throws IOException {
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setDoInput(true);
        return connection.getInputStream();
    }

    private void readContent(StringBuilder content, InputStream is) throws IOException {
        byte[] bytes = new byte[1024 * 4];
        int count;
        while (-1 != (count = is.read(bytes))) {
            content.append(new String(bytes, 0, count));
        }
    }
}
