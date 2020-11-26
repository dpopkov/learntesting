package learn.junitia.ch07stubs;

import java.net.URL;
import java.net.HttpURLConnection;
import java.io.InputStream;
import java.io.IOException;

public class WebClient {
    public String getContent(URL url) {
        StringBuilder buffer = new StringBuilder();
        try {
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            InputStream is = connection.getInputStream();
            byte[] bytes = new byte[2048];
            int count;
            while (-1 != (count = is.read(bytes))) {
                buffer.append(new String(bytes, 0, count));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return buffer.toString();
    }
}
