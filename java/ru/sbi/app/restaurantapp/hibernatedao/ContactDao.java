/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.sbi.app.restaurantapp.hibernatedao;

import dao.DAOException;
import org.apache.log4j.Logger;
import ru.sbi.app.restaurantapp.model.Contact;

/**
 *
 * @author Vladimir
 *
 */
public class ContactDao extends HibernateDao<Contact> {

    private static final Logger log = Logger.getLogger(ContactDao.class.getName());

    @Override
    public void create(Contact cont) throws DAOException {
        try {
            connect();
            session.save(cont);
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
    public Contact read(int id) throws DAOException {
        Contact cont = new Contact();
        try {
            connect();
            cont = (Contact) session.get(Contact.class, id);

        } catch (Exception ex) {
            log.error("Transaction failure", ex);
            tx.rollback();
            throw new DAOException(ex);
        } finally {
            disconnect();
        }
        return cont;
    }

    @Override
    public void update(Contact cont) throws DAOException {
        try {
            connect();
            session.update(cont);
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
        Contact c = new Contact();
        try {
            connect();
            c.setId(id);
            session.delete(c);
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
    public void delete(Contact cont) throws DAOException {
        try {
            connect();
            session.delete(cont);
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
