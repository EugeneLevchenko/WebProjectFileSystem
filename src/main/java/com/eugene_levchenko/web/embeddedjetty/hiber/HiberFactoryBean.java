package com.eugene_levchenko.web.embeddedjetty.hiber;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public  class HiberFactoryBean {
    @Bean
    public  SessionFactory createSessionfactory()
    {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();;
        return factory;
    }
}
