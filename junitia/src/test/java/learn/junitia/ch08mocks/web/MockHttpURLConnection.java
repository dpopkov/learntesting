package learn.junitia.ch08mocks.web;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * The mock implementation of the HttpURLConnection.
 */
public class MockHttpURLConnection extends HttpURLConnection {
    /** The input stream for the connection. */
    private InputStream stream;

    public MockHttpURLConnection() {
        super(null);
    }

    protected MockHttpURLConnection(URL url) {
        super(url);
    }

    /** Setup the input stream expectation. */
    public void setExpectedInputStream(InputStream expectationStream) {
        this.stream = expectationStream;
    }

    /** Return the input stream */
    @Override
    public InputStream getInputStream() {
        return this.stream;
    }

    @Override
    public void disconnect() {
    }

    @Override
    public void connect() {
    }

    /** Are we using a proxy? */
    @Override
    public boolean usingProxy() {
        return false;
    }
}