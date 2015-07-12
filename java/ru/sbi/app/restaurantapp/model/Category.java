package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Vladimir
 */
public class Category {
    private int id;
    private Category parent;
    private List<Dish> dishes = new ArrayList<>();
    private String title;

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

    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
}
