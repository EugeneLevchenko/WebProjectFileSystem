package com.eugene_levchenko.web.embeddedjetty;

import com.eugene_levchenko.web.embeddedjetty.servlets.*;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;

public class App {
    public static void main(String[] args) throws Exception {
        Server server = new Server(8081);
        ServletContextHandler handler = new ServletContextHandler(server, "/");
        handler.addServlet(ServletMainPage.class, "/main");
        handler.addServlet(ServletGlobalStatistic.class,"/gs");
        handler.addServlet(ServletAllFilesInDir.class,"/ls");
        handler.addServlet(ServletLocalStatistic.class,"/lsf");
        handler.addServlet(ServletWordInFileStatistic.class,"/wsf");
        server.start();
    }
}
