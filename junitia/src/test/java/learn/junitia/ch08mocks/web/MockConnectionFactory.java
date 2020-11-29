package learn.junitia.ch08mocks.web;

import java.io.InputStream;

public class MockConnectionFactory implements ConnectionFactory {
    private InputStream inputStream;

    public void setData(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    @Override
    public InputStream getData() {
        return inputStream;
    }
}
