/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernatedao;

import dao.DAO;
import dao.DAOException;

/**
 *
 * @author wsad
 */
public abstract class HibernateDao<T> implements DAO<T>{

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
