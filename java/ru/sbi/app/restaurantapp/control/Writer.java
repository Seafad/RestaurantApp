/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.sbi.app.restaurantapp.control;

import com.google.gson.Gson;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import ru.sbi.app.restaurantapp.util.HibernateUtil;


/**
 * Recieves the formatted request from Transmitter and writes it to the
 * web-page.
 *
 * @author Vladimir
 */
public class Writer extends HttpServlet {

    private static Logger log = Logger.getLogger(Writer.class);

    @Override
    public void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        process(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request, response);
    }

    private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        request.setAttribute("c", request.getAttribute("contact"));
        request.getRequestDispatcher("jsp/second.jsp").forward(request, response);      
    }

    @Override
    public void destroy() {
        // do nothing.
    }
}
