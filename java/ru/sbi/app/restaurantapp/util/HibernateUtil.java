package ru.sbi.app.restaurantapp.util;

import java.util.Properties;
import org.apache.log4j.Logger;
import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateUtil {

    private static final Logger log = Logger.getLogger(HibernateUtil.class.getName());
    private static final SessionFactory sessionFactory;

    static {
            Configuration configuration = new Configuration();
            configuration.configure();
            Properties properties = configuration.getProperties();
            ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(properties).buildServiceRegistry();
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    }
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
