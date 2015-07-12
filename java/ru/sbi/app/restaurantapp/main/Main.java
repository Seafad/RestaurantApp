package ru.sbi.app.restaurantapp.main;

import dao.DAOException;
import java.util.List;
import ru.sbi.app.restaurantapp.hibernatedao.ContactDao;
import ru.sbi.app.restaurantapp.model.Contact;

public class Main {

    public static void main(String[] args) throws DAOException {
        ContactDao cd = new ContactDao();
        Contact con = new Contact();
        con.setEmail("mymail");
        con.setName("John");
        con.setPhone("89057872728");
        cd.create(con);
        cd.connect();
        List<Contact> contactList = cd.session.createQuery("from Contact").list();
        for (Contact contact : contactList) {
            System.out.println("Id: " + contact.getId() + " | Name:" + contact.getName() + " | Email:" + contact.getEmail());
        }
    }
}
