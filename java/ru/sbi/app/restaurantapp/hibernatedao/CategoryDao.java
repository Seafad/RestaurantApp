/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.sbi.app.restaurantapp.hibernatedao;

import dao.DAOException;
import org.apache.log4j.Logger;
import ru.sbi.app.restaurantapp.model.Category;

/**
 *
 * @author Vladimir
 */

public class CategoryDao extends HibernateDao<Category> {

    private static final Logger log = Logger.getLogger(CategoryDao.class.getName());

    @Override
    public void create(Category cat) throws DAOException {
        try {
            connect();
            session.save(cat);
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
    public Category read(int id) throws DAOException {
        Category cat = new Category();
        try {
            connect();
            cat = (Category) session.get(Category.class, id);

        } catch (Exception ex) {
            log.error("Transaction failure", ex);
            tx.rollback();
            throw new DAOException(ex);
        } finally {
            disconnect();
        }
        return cat;
    }

    @Override
    public void update(Category cat) throws DAOException {
        try {
            connect();
            session.update(cat);

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
        Category cat = new Category();
        try {
            connect();
            cat.setId(id);
            session.delete(cat);
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
    public void delete(Category cat) throws DAOException {
        try {
            connect();
            session.delete(cat);
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

