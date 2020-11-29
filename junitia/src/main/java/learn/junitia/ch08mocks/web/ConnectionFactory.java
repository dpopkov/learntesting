package learn.junitia.ch08mocks.web;

import java.io.IOException;
import java.io.InputStream;

public interface ConnectionFactory {
    InputStream getData() throws IOException;
}
