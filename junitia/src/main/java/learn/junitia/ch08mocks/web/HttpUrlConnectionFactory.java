package learn.junitia.ch08mocks.web;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

@SuppressWarnings("unused")
public class HttpUrlConnectionFactory implements ConnectionFactory {
    private final URL url;

    public HttpUrlConnectionFactory(URL url) {
        this.url = url;
    }

    @Override
    public InputStream getData() throws IOException {
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        return connection.getInputStream();
    }
}
