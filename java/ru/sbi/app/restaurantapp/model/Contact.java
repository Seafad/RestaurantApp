package ru.sbi.app.restaurantapp.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Vladimir
 */
@Entity
@Table(name = "Contacts")
public class Contact implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "contact_id")
    private int id;

    @Column(name = "category_id")
    private Category category;

    @Column(name = "eMail")
    private String email;

    @Column(name = "name")
    private String name;

    @Column(name = "phone")
    private String phone;
    
    public Contact(){}
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
