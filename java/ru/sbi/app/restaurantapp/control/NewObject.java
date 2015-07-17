/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.sbi.app.restaurantapp.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ru.sbi.app.restaurantapp.hibernatedao.HibernateDao;
import ru.sbi.app.restaurantapp.model.Contact;

/**
 * Forwards the appropriate for HelloWorld request from the input request
 *
 * @author Vladimir
 */

public class NewObject extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        process(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        process(request, response);
    }

    private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HibernateDao<Contact, Integer>cd = new HibernateDao<>(Contact.class);
        Contact c = new Contact();
        c.setName(request.getParameter("name"));
        c.setPhone(request.getParameter("phone"));
        c.setEmail(request.getParameter("email"));
        c.setAddress(request.getParameter("address"));
        request.setAttribute("contact", c);
        request.getRequestDispatcher("/Writer").forward(request, response);
    }

}
