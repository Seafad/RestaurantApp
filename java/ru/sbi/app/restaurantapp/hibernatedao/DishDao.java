/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.sbi.app.restaurantapp.hibernatedao;

import dao.DAOException;
import org.apache.log4j.Logger;
import ru.sbi.app.restaurantapp.model.Dish;


/**
 *
 * @author Vladimir
 */

public class DishDao extends HibernateDao<Dish> {

    private static final Logger log = Logger.getLogger(DishDao.class.getName());

    @Override
    public void create(Dish d) throws DAOException {
        try {
            connect();
            session.save(d);
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
    public Dish read(int id) throws DAOException {
        Dish d = new Dish();
        try {
            connect();
            d = (Dish) session.get(Dish.class, id);

        } catch (Exception ex) {
            log.error("Transaction failure", ex);
            tx.rollback();
            throw new DAOException(ex);
        } finally {
            disconnect();
        }
        return d;
    }

    @Override
    public void update(Dish d) throws DAOException {
        try {
            connect();
            session.update(d);

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
        Dish c = new Dish();
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
    public void delete(Dish cont) throws DAOException {
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
