package ru.sbi.app.restaurantapp.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Vladimir
 */

@Entity
@Table(name = "Dishes")
public class Dish implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "dish_id")
    private int id;
    
    @Column (name = "title")
    private String title;
    
    @Column (name = "description")
    private String description;
    
    @Column (name = "price")
    private float price;
    
    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    public Dish(){}
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

}
