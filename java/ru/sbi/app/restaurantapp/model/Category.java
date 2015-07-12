package ru.sbi.app.restaurantapp.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Vladimir
 */
@Entity
@Table(name = "Categories")
public class Category implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "category_id")
    private int id;
    
    private Category parent;
    
    @OneToMany (mappedBy = "category")
    private Set<Dish> dishes = new HashSet<>();
    private String title;
    
    public Category(){}
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Category getParent() {
        return parent;
    }

    public void setParent(Category parent) {
        this.parent = parent;
    }

    public Set<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(Set<Dish> dishes) {
        this.dishes = dishes;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
