package ru.sbi.app.restaurantapp.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Vladimir
 */
@Entity
@Table(name = "Orders")
public class Order implements Serializable {

    private int id;
    private long dateTime;
    private Contact contact;
    private Set<Dish>dishes = new HashSet();
    
    public Order() {
    }

    @Id
    @GeneratedValue
    @Column(name = "order_id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "dateTime")
    public long getDateTime() {
        return dateTime;
    }

    public void setDateTime(long dateTime) {
        this.dateTime = dateTime;
    }

    @OneToOne
    @JoinColumn(name="contact_id", nullable=false)
    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }
    
    @ManyToMany(cascade=CascadeType.ALL) 
    @JoinTable(name="DishesOrders", joinColumns=@JoinColumn(name="order_id"), inverseJoinColumns=@JoinColumn(name="dish_id"))
    public Set<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(Set<Dish> dishes) {
        this.dishes = dishes;
    }
    
}
