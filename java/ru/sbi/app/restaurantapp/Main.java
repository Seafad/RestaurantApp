package ru.sbi.app.restaurantapp.main;



import java.util.List;
import model.Contact;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.service.ServiceRegistry;
import ru.sbi.app.restaurantapp.util.HibernateUtil;

public class Main {
 private static final Logger log = Logger.getLogger(Main.class.getName());
    private static SessionFactory sessionFactory = null;
    private static ServiceRegistry serviceRegistry = null;

//    private static SessionFactory configureSessionFactory() throws HibernateException {
//        Configuration configuration = new Configuration();
//        configuration.configure();
//        Properties properties = configuration.getProperties();
//
//        serviceRegistry = new ServiceRegistryBuilder().applySettings(properties).buildServiceRegistry();
//        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
//
//        return sessionFactory;
//    }

    public static void main(String[] args) {
        // Configure the session factory
       // configureSessionFactory();
        sessionFactory = HibernateUtil.getSessionFactory();
        Session session = null;
        Transaction tx = null;

        try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();

            // Creating Contact entity that will be save to the sqlite database
            Contact c = new Contact();
            c.setEmail("my_email@email.com");
            c.setName("name");
            c.setPhone("458748957");
            // Saving to the database
            session.save(c);
           // Contact c = new Contact();
          //  c.setId(2);
          //  session.delete(c);
            // Committing the change in the database.
            tx.commit();

            // Fetching saved data
            List<Contact> contactList = session.createQuery("from Contact").list();

            for (Contact contact : contactList) {
                System.out.println("Id: " + contact.getId() + " | Name:" + contact.getName() + " | Email:" + contact.getEmail());
            }

        } catch (Exception ex) {
            log.error("ERROR", ex);
            // Rolling back the changes to make the data consistent in case of any failure 
            // in between multiple database write operations.
            tx.rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
