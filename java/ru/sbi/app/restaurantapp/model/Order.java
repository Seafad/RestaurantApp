package ru.sbi.app.restaurantapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Vladimir
 */

@Entity
@Table(name = "Orders")
public class Order {
    @Id
    @GeneratedValue
    @Column(name = "order_id")
    private int id;
    private int dateTime;
    private Contact contact;
    
    public Order(){}
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDateTime() {
        return dateTime;
    }

    public void setDateTime(int dateTime) {
        this.dateTime = dateTime;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }
}
