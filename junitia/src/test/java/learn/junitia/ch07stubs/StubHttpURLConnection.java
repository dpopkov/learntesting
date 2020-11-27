package learn.junitia.ch07stubs;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Objects;

public class StubHttpURLConnection extends HttpURLConnection {

    private final String inputContent;

    public StubHttpURLConnection(URL u, String inputContent) {
        super(u);
        Objects.requireNonNull(inputContent);
        this.inputContent = inputContent;
        super.setDoInput(true);
    }

    @Override
    public InputStream getInputStream() throws IOException {
        if (!super.getDoInput()) {
            throw new ProtocolException("Cannot read from URLConnection "
                + " if doInput == false (call setDoInput(true))");
        }
        return new ByteArrayInputStream(inputContent.getBytes());
    }

    @Override
    public void disconnect() {
    }

    @Override
    public boolean usingProxy() {
        return false;
    }

    @Override
    public void connect() {
    }
}
