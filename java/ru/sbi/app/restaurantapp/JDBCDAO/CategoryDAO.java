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
import model.Category;
import org.apache.log4j.Logger;
import ru.sbi.app.restaurantapp.Main;

/**
 *
 * @author Vladimir
 */
public class CategoryDAO extends JDBCDao<Category>{
 private static final Logger log = Logger.getLogger(Main.class.getName());
 //null parent?
    @Override
    public void create(Category cat) throws DAOException {
        try {
            connect();
            try (PreparedStatement create = c.prepareStatement("INSERT INTO Categories (title, parent_id) VALUES (?, ?)")) {
                create.setString(1, cat.getTitle());
                create.setInt(2, cat.getParent().getId());
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
    public Category read(int id) throws DAOException {
        Category cat = new Category();
        try {
            connect();
            try (PreparedStatement read = c.prepareStatement("SELECT title, parent_id FROM Categories WHERE category_id=?")) {
                read.setInt(1, id);
                ResultSet rs = read.executeQuery();
                while (rs.next()) {
                    cat.setTitle(rs.getString("title"));
                    //Category parent = //rs.getInt("parent_id");
                   // cat.setParent();
                }
            }
            return cat;
        } catch (SQLException | ClassNotFoundException ex) {
            throw new DAOException(ex);
        } finally {
            log.debug("Read successfully");
            disconnect();
        }
    }
    
    @Override
    public void update(Category cat) throws DAOException {
        try {
            connect();
            try (PreparedStatement update = c.prepareStatement("UPDATE Contacts SET eMail = ?,name = ?, phone = ? WHERE contact_id = ?")) {
               // update.setString(1, cont.getEmail());
              //  update.setString(2, cont.getName());
              //  update.setString(3, cont.getPhone());
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
    public void delete(Category cat) throws DAOException {
        try {
            connect();
            try (PreparedStatement delete = c.prepareStatement("DELETE FROM Contacts WHERE contact_id = ?")) {
               // delete.setInt(1, cont.getId());
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
