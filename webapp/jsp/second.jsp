<%-- 
    Document   : second
    Created on : 15.07.2015, 19:29:12
    Author     : Vladimir
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Oh, noooo!</title>
    </head>
    <body>
        <h1>Goodbye World!</h1>
        <table>
            <tr>
                <td>Имя</td>
                <td>${c.name}</td>
            </tr>
            <tr>
                <td>E-mail</td>
                <td>${c.email}</td>
            </tr>
            <tr>
                <td>Телефон</td>
                <td>${c.phone}</td>
            </tr>
             <tr>
                <td>Адрес:</td>
                <td>${c.address}</td>
            </tr>
        </table>
    </body>
</html>
