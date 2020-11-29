package learn.junitia.ch08mocks.web;

import java.net.HttpURLConnection;
import java.net.URL;

public class TestableWebClient extends WebClientRefactored {
    private HttpURLConnection connection;

    public void setHttpURLConnection(HttpURLConnection connection) {
        this.connection = connection;
    }

    @Override
    protected HttpURLConnection createHttpURLConnection(URL url) {
        return connection;
    }
}
