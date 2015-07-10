/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JDBCDAO;

import dao.DAOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Order;
import org.apache.log4j.Logger;
import ru.sbi.app.restaurantapp.Main;

/**
 *
 * @author Vladimir
 */
public class OrderDAO extends JDBCDao<Order>{
    private static final Logger log = Logger.getLogger(Main.class.getName());
    
    @Override
    public void create(Order ord) throws DAOException {
        try {
            connect();
            try (PreparedStatement create = c.prepareStatement("INSERT INTO Orders (time, contact_id) VALUES (?, ?)")) {
                create.setInt(1, ord.getDateTime());
                create.setInt(2, ord.getContact().getId());
                create.executeUpdate();
            }
        } catch (SQLException | ClassNotFoundException ex) {
            throw new DAOException(ex);
        } finally {
            log.debug("Created successfully");
            disconnect();
        }
    }
    
    @Override
    public Order read(int id) throws DAOException {
        Order ord = new Order();
        try {
            connect();
            try (PreparedStatement read = c.prepareStatement("SELECT time, contact_id FROM Orders WHERE order_id=?")) {
                read.setInt(1, id);
                ResultSet rs = read.executeQuery();
                while (rs.next()) {
                    ord.setDateTime(rs.getInt("time"));
                    ord.setContact(new ContactDAO().read(rs.getInt("contact_id")));
                }
            }
            return ord;
        } catch (SQLException | ClassNotFoundException ex) {
            throw new DAOException(ex);
        } finally {
            log.debug("Read successfully");
            disconnect();
        }
    }
    
    @Override
    public void update(Order ord) throws DAOException {
        try {
            connect();
            try (PreparedStatement update = c.prepareStatement("UPDATE Orders SET time = ?,contact_id = ? WHERE order_id = ?")) {
                update.setInt(1, ord.getDateTime());
                update.setInt(2, ord.getContact().getId());
                update.setInt(3, ord.getId());
                update.executeUpdate();
            }
        } catch (SQLException | ClassNotFoundException ex) {
            throw new DAOException(ex);
        } finally {
            log.debug("Updated successfully");
            disconnect();
        }
    }
    
    @Override
    public void delete(int id) throws DAOException {
        try {
            connect();
            try (PreparedStatement delete = c.prepareStatement("DELETE FROM Orders WHERE order_id = ?")) {
                delete.setInt(1, id);
                delete.executeUpdate();
            }
        } catch (SQLException | ClassNotFoundException ex) {
            throw new DAOException(ex);
        } finally {
            log.debug("Deleted successfully");
            disconnect();
        }
    }
    
    @Override
    public void delete(Order ord) throws DAOException {
        try {
            connect();
            try (PreparedStatement delete = c.prepareStatement("DELETE FROM Orders WHERE order_id = ?")) {
                delete.setInt(1, ord.getId());
                delete.executeUpdate();
            }
        } catch (SQLException | ClassNotFoundException ex) {
            throw new DAOException(ex);
        } finally {
            log.debug("Deleted successfully");
            disconnect();
        }
    }
}
