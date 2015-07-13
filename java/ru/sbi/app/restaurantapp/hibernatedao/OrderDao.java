/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.sbi.app.restaurantapp.hibernatedao;

import dao.DAOException;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import org.apache.log4j.Logger;
import ru.sbi.app.restaurantapp.model.Order;

/**
 *
 * @author Vladimir
 *
 */
public class OrderDao extends HibernateDao<Order> {

    private static final Logger log = Logger.getLogger(OrderDao.class.getName());

    @Override
    public void create(Order ord) throws DAOException {
        try {
            connect();
            session.save(ord);
            tx.commit();
        } catch (Exception ex) {
            log.error("Transaction failure", ex);
            tx.rollback();
            throw new DAOException(ex);
        } finally {
            disconnect();
        }
    }

    @Override
    public Order read(int id) throws DAOException {
        Order ord = new Order();
        try {
            connect();
            ord = (Order) session.get(Order.class, id);

        } catch (Exception ex) {
            log.error("Transaction failure", ex);
            tx.rollback();
            throw new DAOException(ex);
        } finally {
            disconnect();
        }
        return ord;
    }

    @Override
    public void update(Order ord) throws DAOException {
        try {
            connect();
            session.update(ord);
            tx.commit();
        } catch (Exception ex) {
            log.error("Transaction failure", ex);
            tx.rollback();
            throw new DAOException(ex);
        } finally {
            disconnect();
        }
    }

    @Override
    public void delete(int id) throws DAOException {
        Order ord = new Order();
        try {
            connect();
            ord.setId(id);
            session.delete(ord);
            tx.commit();
        } catch (Exception ex) {
            log.error("Transaction failure", ex);
            tx.rollback();
            throw new DAOException(ex);
        } finally {
            disconnect();
        }
    }

    @Override
    public void delete(Order ord) throws DAOException {
        try {
            connect();
            session.delete(ord);
            tx.commit();
        } catch (Exception ex) {
            log.error("Transaction failure", ex);
            tx.rollback();
            throw new DAOException(ex);
        } finally {
            disconnect();
        }
    }
    @Deprecated
    public void showAll() throws DAOException {
        try {
            connect();
            List<Order> contactList = session.createQuery("from Order").list();
            for (Order contact : contactList) {
                System.out.println("Id: " + contact.getId() + " | Date:" + Date.from(Instant.ofEpochSecond(contact.getDateTime())) + " | Contact:" + contact.getContact());
            }
            tx.commit();
        } catch (Exception ex) {
            log.error("Transaction failure", ex);
            tx.rollback();
            throw new DAOException(ex);
        } finally {
            disconnect();
        }
    }

}
