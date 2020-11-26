package learn.junitia.ch07stubs;


/*import org.mortbay.jetty.Server;
import org.mortbay.jetty.handler.ResourceHandler;
import org.mortbay.jetty.servlet.Context;*/

public class JettySample {
    public static void main(String[] args) throws Exception {
        System.out.println("To run this example you need to");
        System.out.println("uncomment commented sections and uncomment jetty ver.7 in pom.xml");
//        startJettyMortbayVer7();
    }

    /*private static void startJettyMortbayVer7() throws Exception {
        Server server = new Server(8081);
        Context root = new Context(server, "/");
        root.setResourceBase("./pom.xml");
        root.setHandler(new ResourceHandler());
        server.start();
    }*/
}
