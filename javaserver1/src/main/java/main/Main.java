package main;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import servlets.MirrorServlet;

import java.util.logging.Logger;

/**
 * Created by woqpw on 16.12.15.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        Logger logger = Logger.getGlobal();
        MirrorServlet mirrorServlet = new MirrorServlet();
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.addServlet(new ServletHolder(mirrorServlet), "/mirror");
        Server server = new Server(8080);
        server.setHandler(context);
        logger.info("Server started");
        server.start();
        server.join();
    }
}
