package model;

/**
 *
 * @author Vladimir
 */
public class Order {
    private int id;
    private int dateTime;
    private Contact contact;
    
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
