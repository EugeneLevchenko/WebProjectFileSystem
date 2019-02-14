package com.eugene_levchenko.web.embeddedjetty;

import com.eugene_levchenko.web.embeddedjetty.annotations.TestAnnotation;

import com.eugene_levchenko.web.embeddedjetty.entities.EntityAllFilesInDir;

import com.eugene_levchenko.web.embeddedjetty.entities.EntityGlobalStat;
import com.eugene_levchenko.web.embeddedjetty.ormController.InsertCustomHiber;
import com.eugene_levchenko.web.embeddedjetty.ormController.TableCustomHiber;
import com.eugene_levchenko.web.embeddedjetty.servlets.*;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;


@TestAnnotation(text = "someText")
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
        App app=new App();

        TestAnnotation anno = app.getClass().getAnnotation(TestAnnotation.class);
        System.out.println(anno.text());

        //  EntityGlobalStat gs=new EntityGlobalStat("",0);
        EntityAllFilesInDir fs=new EntityAllFilesInDir(3,"");
        EntityGlobalStat gs=new EntityGlobalStat("",3);
        TableCustomHiber t=new TableCustomHiber();
        InsertCustomHiber insert=new InsertCustomHiber();
       // insert.add("fileOne",a);
        t.createTableIfDoesNotExist(gs);
        System.out.println(app.getClass().getSimpleName());
    }
}