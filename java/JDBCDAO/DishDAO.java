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
import model.Contact;
import model.Dish;
import org.apache.log4j.Logger;
import ru.sbi.app.restaurantapp.Main;

/**
 *
 * @author Vladimir
 */
public class DishDAO extends JDBCDao<Dish>{
    private static final Logger log = Logger.getLogger(Main.class.getName());
 
    @Override
    public void create(Dish d) throws DAOException {
        try {
            connect();
            try (PreparedStatement create = 
                    c.prepareStatement("INSERT INTO Dishes (category_id, title, description, price) VALUES (?, ?, ?, ?)")) {
                create.setInt(1, d.getCategoryId());
                create.setString(2, d.getTitle());
                create.setString(3, d.getDescription());
                create.setFloat(4, d.getPrice());
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
    public Dish read(int id) throws DAOException {
        Dish d = new Dish();
        try {
            connect();
            try (PreparedStatement read = c.prepareStatement("SELECT category_id, title, description, price FROM Dishes WHERE dish_id=?")) {
                read.setInt(1, id);
                ResultSet rs = read.executeQuery();
                while (rs.next()) {
                    d.setCategoryId(rs.getInt("category_id"));
                    d.setTitle(rs.getString("title"));
                    d.setDescription(rs.getString("description"));
                    d.setPrice(rs.getInt("price"));
                }
            }
            return d;
        } catch (SQLException | ClassNotFoundException ex) {
            throw new DAOException(ex);
        } finally {
            log.debug("Read successfully");
            disconnect();
        }
    }
    
    @Override
    public void update(Dish d) throws DAOException {
        try {
            connect();
            try (PreparedStatement update = c.prepareStatement("UPDATE Dishes SET category_id = ?, title = ?, description = ?, price = ? WHERE dish_id = ?")) {
                update.setInt(1, d.getCategoryId());
                update.setString(2, d.getTitle());
                update.setString(3, d.getDescription());
                update.setFloat(4, d.getPrice());
                update.setInt(5, d.getId());
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
            try (PreparedStatement delete = c.prepareStatement("DELETE FROM Dishes WHERE dish_id=?")) {
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
    public void delete(Dish d) throws DAOException {
        try {
            connect();
            try (PreparedStatement delete = c.prepareStatement("DELETE FROM Dishes WHERE dish_id=?")) {
                delete.setInt(1, d.getId());
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
