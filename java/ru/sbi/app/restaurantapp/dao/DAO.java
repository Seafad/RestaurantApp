package ru.sbi.app.restaurantapp.dao;

/**
 *
 * @author Vladimir
 * @param <T>
 */
public interface DAO<T> {

    public void create(T entity) throws DAOException;

    public T read(int id) throws DAOException;

    public void update(T entity) throws DAOException;

    public void delete(int id) throws DAOException;
    
    public void delete(T entity) throws DAOException;
}
