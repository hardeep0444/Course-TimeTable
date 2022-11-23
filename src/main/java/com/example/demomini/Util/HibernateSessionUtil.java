package com.example.demomini.Util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateSessionUtil {
    private static final SessionFactory sessionFactory;
    static {
        try{
            Configuration configuration = new Configuration();
            configuration.configure();
            sessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            System.out.println("Unable to intialize session" +ex.getLocalizedMessage());
            throw new ExceptionInInitializerError();
        }
    }
    public static Session getSession() throws HibernateException {
        return sessionFactory.openSession();
    }
}