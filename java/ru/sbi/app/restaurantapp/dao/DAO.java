package ru.sbi.app.restaurantapp.dao;

import java.io.Serializable;

/**
 *
 * @author Vladimir
 * @param <T>
 * @param <PK>
 */
public interface Dao<T, PK extends Serializable> {

    public PK create(T entity) throws DaoException;

    public T read(PK id) throws DaoException;

    public void update(T entity) throws DaoException;
    
    public void delete(T entity) throws DaoException;
}
