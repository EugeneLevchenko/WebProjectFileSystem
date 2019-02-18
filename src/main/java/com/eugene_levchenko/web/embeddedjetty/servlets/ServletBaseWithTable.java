package com.eugene_levchenko.web.embeddedjetty.servlets;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

public abstract class ServletBaseWithTable extends ServletBase {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        super.doGet(req,resp);

        try {
            renderTable(resp);
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
    protected abstract void renderTable( HttpServletResponse resp) throws IOException, SQLException, IllegalAccessException, InvocationTargetException, InstantiationException;


}
