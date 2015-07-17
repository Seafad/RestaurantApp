/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.sbi.app.restaurantapp.hibernatedao;

import ru.sbi.app.restaurantapp.dao.DaoException;
import java.io.Serializable;
import java.time.Instant;
import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import ru.sbi.app.restaurantapp.dao.Command;
import ru.sbi.app.restaurantapp.dao.Dao;
import ru.sbi.app.restaurantapp.model.Category;
import ru.sbi.app.restaurantapp.model.Contact;
import ru.sbi.app.restaurantapp.model.Dish;
import ru.sbi.app.restaurantapp.model.Request;
import ru.sbi.app.restaurantapp.util.HibernateUtil;

/**
 *
 * @author Vladimir
 * @param <T>
 * @param <PK>
 */ 
public class HibernateDao<T, PK extends Serializable> implements Dao<T, PK> {

    private static final Logger log = Logger.getLogger(HibernateDao.class);

    protected SessionFactory sessionFactory = null;
    public Session session = null;
    protected Transaction tx = null;
    private final Class<T> type;

    public HibernateDao(Class c) {
        type = c;
    }

    public void connect() {
        sessionFactory = HibernateUtil.getSessionFactory();
        session = sessionFactory.openSession();
        tx = session.beginTransaction();
    }

    protected void disconnect() {
        if (session != null) {
            session.close();
        }
    }

    public <K> K process(Command<K> command) throws DaoException {
        K result = null;
        try {
            connect();
            result = command.execute();
            tx.commit();
        } catch (Exception ex) {
            log.error("Transaction failure", ex);
            tx.rollback();
            throw new DaoException(ex);
        } finally {
            disconnect();
        }
        return result;
    }

    @Override
    public PK create(final T entity) throws DaoException {
        return process(() -> (PK) session.save(entity));
    }

    @Override
    public void update(final T entity) throws DaoException {
        process(() -> {
            session.update(entity);
            return null;
        });
    }

    @Override
    public T read(final PK id) throws DaoException {
        return process(() -> (T) session.get(type, id));
    }

    @Override
    public void delete(final T entity) throws DaoException {
        process(() -> {
            session.delete(entity);
            return null;
        });
    }

    @Deprecated
    public void showAllContacts() throws DaoException {
        try {
            connect();
            List<Contact> contactList = session.createQuery("from Contact").list();
            for (Contact contact : contactList) {
                System.out.println("Id: " + contact.getId() + " | Name:" + contact.getName() + " | Email:" + contact.getEmail()
                        + " | Phone:" + contact.getPhone() + "| Address: " + contact.getAddress());
            }
            tx.commit();
        } catch (Exception ex) {
            log.error("Transaction failure", ex);
            tx.rollback();
            throw new DaoException(ex);
        } finally {
            disconnect();
        }
    }

    @Deprecated
    public void showAllCategories() throws DaoException {
        try {
            connect();
            List<Category> contactList = session.createQuery("from Category").list();
            for (Category contact : contactList) {
                String parent = (contact.getParent() != null) ? contact.getParent().getTitle() : "NO_PARENT!FATAL!!!NO!@!@&*#@#&";
                System.out.println("Id: " + contact.getId() + " | Title: " + contact.getTitle() + " | Parent: " + parent);

            }
            tx.commit();
        } catch (Exception ex) {
            log.error("Transaction failure", ex);
            tx.rollback();
            throw new DaoException(ex);
        } finally {
            disconnect();
        }
    }

    @Deprecated
    public void showAllRequests() throws DaoException {
        try {
            connect();
            List<Request> orderList = session.createQuery("from Requests").list();
            for (Request order : orderList) {
                System.out.println("Id: " + order.getId() + " | DateTime: " + Instant.ofEpochSecond(order.getDateTime()));
                Contact contact = order.getContact();
                System.out.println("Contact Id: " + contact.getId() + " | Name:" + contact.getName() + " | Email:" + contact.getEmail()
                        + " | Phone:" + contact.getPhone()+ "| Address: " + contact.getAddress() + "\n | Dishes: ");
                List<Dish> dishList = order.getDishes();
                for (Dish d : dishList) {
                    printDishInfo(d);
                }

            }
            tx.commit();
        } catch (DaoException ex) {
            log.error("Transaction failure", ex);
            tx.rollback();
            throw new DaoException(ex);
        } finally {
            disconnect();
        }
    }

    @Deprecated
    public void printDishInfo(Dish d) throws DaoException {
        Category parent = d.getCategory();
        String parentStr = "";
        parentStr += parent.getTitle() + " <- ";
        while (parent.getParent() != null) {
            parent = parent.getParent();
            parentStr += parent.getTitle() + " <- ";
        }
        parentStr = parentStr.substring(0, parentStr.length() - 4);
        System.out.println("ID: " + d.getId() + " \"" + d.getTitle() + "\": " + d.getDescription() + " " + d.getPrice() + "$ from: " + parentStr);
    }

}
