/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JDBCDAO;

import dao.DAO;
import dao.DAOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.sqlite.SQLiteConfig;

public abstract class JDBCDao<T> implements DAO<T> {

    Connection c;

    protected void connect() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        SQLiteConfig config = new SQLiteConfig();
        config.enforceForeignKeys(true);
        c = DriverManager.getConnection(Properties.url, config.toProperties());
    }

    protected void disconnect() throws DAOException {
        try {
            c.close();
        } catch (SQLException ex) {
            throw new DAOException(ex);
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
