<%-- 
    Document   : admin
    Created on : Mar 3, 2022, 11:17:44 AM
    Author     : Doan
--%>

<%@page import="sample.shopping.Category"%>
<%@page import="sample.shopping.CategoryDAO"%>
<%@page import="sample.shopping.Vegetable"%>
<%@page import="java.util.List"%>
<%@page import="sample.user.UserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="./css/admin.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css" integrity="sha512-9usAa10IRO0HhonpyAIVpjrylPvoDwiPUiKdWk5t3PyolY1cOd4DSE0Ga+ri4AuTroPR5aQvXU9xC6qOPnzFeg==" crossorigin="anonymous" referrerpolicy="no-referrer" />
        <title>Admin Page</title>
        <style>
           
            table thead tr th{
                color: black;
            }
            table td{
                color: black;
            }
            header{
                width: 100vw;
            }
            .navbar-low a{
                display: flex;
            }
            h2{
                color: white;
                position: absolute;
                top: 5px;
                left: 10px;
            }
            .warn{
                font-size: 24px;
                font-weight: 800;
            }
           
        </style>
    </head>
    <body>
        <header>
             <%
                    UserDTO loginUser = (UserDTO) session.getAttribute("LOGIN_USER");
                    if (loginUser == null || !loginUser.getRoleID().equals("AD")) {
                        response.sendRedirect("login.jsp");
                    }
                    String search = request.getParameter("search");
                    if (search == null) {
                        search = "";
                    }
                %>

            <div class="logout"><a href="MainController?action=Logout">Logout</a></div>
            <h2>Welcome: <%=loginUser.getFullName()%></h2>
            <div class="navbar-low">
                <a href="">
                    <div class="logo-item">
                        <i class="fa-solid fa-cannabis"></i>
                        <p class="shop-name">Cannabis</p>
                </a>
                
                </form>
               
               
                <form class="seach" action="MainController">
                    <input type="text" name="search">
                    <button type="submit" name="action" value="Search"><i class="fa-solid fa-magnifying-glass"></i></button>
                </form>
                 
        </header>

        <%
            List<Vegetable> listVeget = (List<Vegetable>) request.getAttribute("LIST_VEGET");
            if (listVeget != null) {
                if (listVeget.size() > 0) {
        %>
        <table border="1">
            <thead>
                <tr>
                    <th>No</th>
                    <th>ProductID</th>
                    <th>ProductName</th>
                    <th>Image-link</th>
                    <th>Price</th>
                    <th>Quantity</th>
                    <th>CatagoryID</th>
                    <th>importDate</th>
                    <th>usingDate</th>  
                    <th>Edit Product</th>
                    <th>Remove</th>
                </tr>
            </thead>
            <tbody>

                <%
                    int count = 1;
                    for (Vegetable veget : listVeget) {
                %>
            <form action="MainController">
                <tr>

                    <td>
                        <%= count++%></td>
                    <td>
                        <input type="text" name="productID" value="<%=veget.getProductID()%>" readonly=""/>    
                    </td>
                    <td>
                        <input type="text" name="prodName" value="<%= veget.getProdName()%>" required=""/>
                    </td>
                    <td>
                        <input type="text" name="img" value="<%= veget.getImg()%>" required=""/>
                    </td>
                    <td>
                        <input type="number" min="0" name="price" value="<%= veget.getPrice()%>" required=""/>
                    </td>
                    <td>
                        <input type="number" name="quantity" min="1" value="<%= veget.getQuantity()%>" required=""/>
                    </td>    
                    <td>
                        <input type="number" name="CatagoryID" min="1" value="<%= veget.getCatagoryID()%>" required=""/>
                    </td> 
                    <td>
                        <input type="text" name="importDate" value="<%= veget.getImportDate()%>" required=""/>
                    </td>
                    <td>
                        <input type="text" name="usingDate" value="<%= veget.getUsingDate()%>" required=""/>
                    </td>
                    <td>
                        <input type="submit" name="action" value="EditPro"/>
                    </td> 
                    <td>
                         <a href="MainController?action=RemovePro&productID=<%=veget.getProductID()%>">Remove</a>
                    </td>                   
                </tr>
                
            </form>
            
            <%
                }
            %>
            
        </tbody>
    </table>
             <a href="createProd.jsp">Create new Product</a>
    <%
            }
        }

    %>
       <!<!-- Code cua editPage qua day -->
        
         <%
        CategoryDAO dao = new CategoryDAO();
        List<Category> list = dao.getListCate();
        if (list.size() > 0) {
    %>
        <table border="1">
        <thead>
            <tr>
                <th>No</th>
                <th>Category ID</th>
                <th>Category Name</th>   
                <th>Edit</th>
                <th>Remove</th>    
                <th><a href="createCate.jsp">Create</a><th>
            </tr>
        </thead>
        <tbody>
            <%
                int count = 1;
                for (Category cate : list) {
            %>   
        <form action="MainController">
            <tr>
                <td><%=count++%></td>

                <td>
                    <input type="text" name="catagoryID" value="<%=cate.getCatagoryID()%>" readonly=""/>    
                </td>
                <td>
                    <input type="text" name="catagoryName" value="<%=cate.getCatagoryName()%>"/>    
                </td>
                <td><input type="submit" name="action" value="EditCate"/></td>
                <td><a href="MainController?action=DeleteCate&catagoryID=<%=cate.getCatagoryID()%>">Remove</a></td>
            </tr>
        </form>

    </tbody>
    <%
        }
    %>

    <%
        }
    %>
</table> 
 <div class="warn">If you want to change the category of product which doen't exist it the Category Table.
        Please confirm that in Category Table !
    </div>
</body>
</html>
