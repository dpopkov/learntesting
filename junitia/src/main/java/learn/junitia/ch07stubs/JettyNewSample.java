package learn.junitia.ch07stubs;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.AbstractHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JettyNewSample extends AbstractHandler {
    public static final String DEFAULT_RESPONSE_CONTENT = "<h1>Jetty works!</h1>";

    private final String responseContent;

    public JettyNewSample() {
        this(DEFAULT_RESPONSE_CONTENT);
    }

    public JettyNewSample(String responseContent) {
        this.responseContent = responseContent;
    }

    public static void main(String[] args) throws Exception {
        int port = 8082;
        Server server = new Server(port);
        server.setHandler(new JettyNewSample());
        server.start();
        server.join();
    }

    @Override
    public void handle(String s, Request request, HttpServletRequest httpServletRequest,
                       HttpServletResponse response) throws IOException {
        response.setContentType("text/html; charset=utf-8");
        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().println(responseContent);
        // Inform jetty that this request has now been handled
        request.setHandled(true);
    }
}
