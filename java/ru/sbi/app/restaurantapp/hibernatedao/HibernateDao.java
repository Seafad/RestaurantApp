/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.sbi.app.restaurantapp.hibernatedao;

import dao.DAO;
import dao.DAOException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import ru.sbi.app.restaurantapp.util.HibernateUtil;

/**
 *
 * @author Vladimir
 */                            // T extends model?
public abstract class HibernateDao<T> implements DAO<T> {

    protected static SessionFactory sessionFactory = null;
    public Session session = null;
    protected Transaction tx = null;

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
    
    @Override
    public abstract void delete(T entity) throws DAOException;

    @Override
    public abstract void delete(int id) throws DAOException;

    @Override
    public abstract void update(T entity) throws DAOException;

    @Override
    public abstract T read(int id) throws DAOException;

    @Override
    public abstract void create(T entity) throws DAOException;

}
