package com.educomser.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil 
{
    private static SessionFactory sessionFactory;
    private static ServiceRegistry serviceRegistry;
    
    //Funcion anonima
    static 
    {
        Configuration cfg=new Configuration();
        cfg.configure();
        serviceRegistry=new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();
        sessionFactory=cfg.buildSessionFactory(serviceRegistry);
    }
        
    public static SessionFactory getSessionFactory()
    {
        return sessionFactory;
    }
    
    //Para cerra el sessionFactory
    public static void closeSessionFactory()
    {
        if(sessionFactory!=null && !sessionFactory.isClosed())
        {
            sessionFactory.close();
            StandardServiceRegistryBuilder.destroy(serviceRegistry);
        }
    }
            
}
