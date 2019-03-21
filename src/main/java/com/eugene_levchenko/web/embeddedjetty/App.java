package com.eugene_levchenko.web.embeddedjetty;

import com.eugene_levchenko.web.embeddedjetty.dao.daoInterfaces.IDAOAllFilesInDirEntity;
import com.eugene_levchenko.web.embeddedjetty.servlets.*;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class App {
    public static void main(String[] args) throws Exception {

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        AppHelper appHelper = context.getBean(AppHelper.class);

        Server server = new Server(8081);
        ServletContextHandler handler = new ServletContextHandler(server, "/");

        handler.addServlet(new ServletHolder(appHelper.servletMainPage), "/main");
        handler.addServlet(new ServletHolder(appHelper.servletGlobalStatistic), "/gs");
        handler.addServlet(new ServletHolder(appHelper.servletAllFilesInDir), "/ls");
        handler.addServlet(new ServletHolder(appHelper.servletLocalStatistic), "/lsf");
        handler.addServlet(new ServletHolder(appHelper.servletWordInFileStatistic), "/wsf");
        server.start();

    }
}
//