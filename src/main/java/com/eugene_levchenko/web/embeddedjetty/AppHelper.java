package com.eugene_levchenko.web.embeddedjetty;

import com.eugene_levchenko.web.embeddedjetty.servlets.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AppHelper {
    public AppHelper() {
    }

    @Autowired
    public ServletMainPage servletMainPage;

    @Autowired
    ServletGlobalStatistic servletGlobalStatistic;
    @Autowired
    ServletAllFilesInDir servletAllFilesInDir;
    @Autowired
    ServletLocalStatistic servletLocalStatistic;
    @Autowired
    ServletWordInFileStatistic  servletWordInFileStatistic;

}
