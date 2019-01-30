package com.eugene_levchenko.web.embeddedjetty.servlets;
import com.eugene_levchenko.web.embeddedjetty.enums.ENamesOfPages;

public class ServletMainPage extends ServletBase {

    @Override
    protected ENamesOfPages getExcludedMenuItem() {
        return ENamesOfPages.MAIN;
    }

    @Override
    protected String getCaptionPage() {
      return "Главная";
    }
}