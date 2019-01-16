package com.eugene_levchenko.web.embeddedjetty;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;

public class App {
    public static void main(String[] args) throws Exception {
        Server server = new Server(8080);
        ServletContextHandler handler = new ServletContextHandler(server, "/");
        handler.addServlet(MainPageServlet.class, "/main");
        handler.addServlet(GlobalStatisticServlet.class,"/gs");
        handler.addServlet(AllFilesInDirServlet.class,"/ls");
        handler.addServlet(LocalStatisticWordsInFileServlet.class,"/lsf");
        handler.addServlet(WordInFileStatisticServlet.class,"/wsf");
        server.start();
        System.out.println(NamesOfPages.GLOBAL_STATISTIC.ordinal());
    }
}
