package ru.sbi.app.restaurantapp.model;

import java.io.Serializable;
import java.util.List;
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
@Entity(name = "Requests")
@Table(name = "Requests")
public class Request implements Serializable {

    private int id;
    private long dateTime;
    private Contact contact;
    private List<Dish>dishes;
    
    public Request() {
    }

    @Id
    @GeneratedValue
    @Column(name = "request_id")
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
    @JoinTable(name="DishesOrders", joinColumns=@JoinColumn(name="request_id"), inverseJoinColumns=@JoinColumn(name="dish_id"))
    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }
   
    
}
