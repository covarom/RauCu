<%-- 
    Document   : createCate
    Created on : Mar 5, 2022, 1:41:56 PM
    Author     : Doan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Form Create Category</title>
    </head>
    <body>
        <form action="MainController" method="POST">
        <label for="CatagoryID">CatagoryID</label>
        <input type="number" name="CatagoryID">
    </br>
        <label for="CatagoryName">CatagoryName</label>
        <input type="text" name="CatagoryName">
    <input type="submit"  name ="action"value="createNewCate">
    </form>
    </body>
</html>
