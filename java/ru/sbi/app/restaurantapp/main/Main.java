package ru.sbi.app.restaurantapp.main;

import dao.DAOException;
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
        ContactDao cd2 = new ContactDao();
        Contact con2 = new Contact();
        con2.setEmail("mymail");
        con2.setName("John");
        con2.setPhone("89057872728");
        cd2.create(con2);
        cd2.showAll();

    }
}
