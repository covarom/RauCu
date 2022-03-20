<%-- 
    Document   : createProd
    Created on : Mar 5, 2022, 4:23:16 PM
    Author     : Doan
--%>

<%@page import="sample.user.UserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create New Product</title>
    </head>
    <body>
         <%
                    UserDTO loginUser = (UserDTO) session.getAttribute("LOGIN_USER");
                    if (loginUser == null || !loginUser.getRoleID().equals("AD")) {
                        response.sendRedirect("login.jsp");
                    }
                    %>
          <form action="MainController">
        <label for="productID">productID (number): </label>
        <input type="number" name="productID">
    </br>
        <label for="productName">productName: </label>
        <input type="text" name="productName">
    </br>
        <label for="image">image (folder link): </label>
        <input type="text" name="image">
    </br>
        <label for="price">price: </label>
        <input type="number" name="price">
    </br>
        <label for="quantity">quantity: </label>
        <input type="number" name="quantity">
    </br>
        <label for="catagoryID">catagoryID: </label>
        <input type="number" name="catagoryID">
    </br>
        <label for="importDate">importDate (yyyy-MM-dd): </label>
        <input type="text" name="importDate">
    </br>
        <label for="usingDate">usingDate (yyyy-MM-dd): </label>
        <input type="text" name="usingDate">
    </br>
        <input type="submit" name="action" value="CreateProd">
    </form>
    </body>
</html>
