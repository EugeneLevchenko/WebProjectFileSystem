package com.eugene_levchenko.web.embeddedjetty;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;

public class EmbeddedJettyMain {
    public static void main(String[] args) throws Exception {
        Server server = new Server(8080);
        ServletContextHandler handler = new ServletContextHandler(server, "/");
        handler.addServlet(MainServlet.class, "/main");
        handler.addServlet(GlobalStatisticServlet.class,"/gs");
        handler.addServlet(LocalStatisticServlet.class,"/ls");
        handler.addServlet(LocalStatisticOfFileServlet.class,"/lsf");
        server.start();//
    }
}
