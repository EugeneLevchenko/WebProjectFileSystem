package com.eugene_levchenko.web.embeddedjetty.servlets;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

public abstract class ServletBaseWithTableWithParam extends ServletBase {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
       super.doGet(req,resp);
        try {
            renderTable(resp,req);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    protected String getParam(HttpServletRequest req,String nameOfParam)
    {
        return  req.getParameter(nameOfParam);
    }

    protected abstract void renderTable( HttpServletResponse resp,HttpServletRequest req) throws IOException, SQLException, IllegalAccessException, InstantiationException, InvocationTargetException;

}
