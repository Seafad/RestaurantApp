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
import model.Contact;
import org.apache.log4j.Logger;
import ru.sbi.app.restaurantapp.Main;

/**
 *
 * @author Vladimir
 */
public class ContactDAO extends JDBCDao<Contact> {
    
    private static final Logger log = Logger.getLogger(Main.class.getName());
    
    @Override
    public void create(Contact cont) throws DAOException {
        try {
            connect();
            try (PreparedStatement create = c.prepareStatement("INSERT INTO Contacts (eMail, name, phone) VALUES (?, ?, ?)")) {
                create.setString(1, cont.getEmail());
                create.setString(2, cont.getName());
                create.setString(3, cont.getPhone());
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
    public Contact read(int id) throws DAOException {
        Contact cont = new Contact();
        try {
            connect();
            try (PreparedStatement read = c.prepareStatement("SELECT eMail, name, phone FROM Contacts WHERE contact_id=?")) {
                read.setInt(1, id);
                ResultSet rs = read.executeQuery();
                while (rs.next()) {
                    cont.setEmail(rs.getString("eMail"));
                    cont.setName(rs.getString("name"));
                    cont.setPhone(rs.getString("phone"));
                }
            }
            return cont;
        } catch (SQLException | ClassNotFoundException ex) {
            throw new DAOException(ex);
        } finally {
            log.debug("Read successfully");
            disconnect();
        }
    }
    
    @Override
    public void update(Contact cont) throws DAOException {
        try {
            connect();
            try (PreparedStatement update = c.prepareStatement("UPDATE Contacts SET eMail = ?,name = ?, phone = ? WHERE contact_id = ?")) {
                update.setString(1, cont.getEmail());
                update.setString(2, cont.getName());
                update.setString(3, cont.getPhone());
                update.setInt(4, cont.getId());
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
            try (PreparedStatement delete = c.prepareStatement("DELETE FROM Contacts WHERE contact_id = ?")) {
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
    public void delete(Contact cont) throws DAOException {
        try {
            connect();
            try (PreparedStatement delete = c.prepareStatement("DELETE FROM Contacts WHERE contact_id = ?")) {
                delete.setInt(1, cont.getId());
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
