<%-- 
    Document   : viewCart
    Created on : Mar 9, 2022, 6:00:30 PM
    Author     : Doan
--%>

<%@page import="sample.user.UserDTO"%>
<%@page import="sample.shopping.Vegetable"%>
<%@page import="sample.shopping.Cart"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./css/viewCart.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css" integrity="sha512-9usAa10IRO0HhonpyAIVpjrylPvoDwiPUiKdWk5t3PyolY1cOd4DSE0Ga+ri4AuTroPR5aQvXU9xC6qOPnzFeg==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <title>Cart Shopping</title>
    <style>
        .buymore{
            margin: 1px 0 130px 150px;
            font-size: 24px;
            
        }
        .welcome{
            color: yellow;
        }
    </style>
</head>
<body>
     <%
                UserDTO loginUser = (UserDTO) session.getAttribute("LOGIN_USER");
                if (loginUser == null || !loginUser.getRoleID().equals("US")) {
                    response.sendRedirect("login.jsp");
                }
            %>
    <header>
        <div class="navbar-low">
            <a href="./index.jsp">
            <div class="logo-item">
                <i class="fa-solid fa-cannabis"></i>
                <p class="shop-name">Cannabis</p>
            </div>
            </a>
            <div class="welcome">Welcome: <%=loginUser.getFullName()%></div>           
           <div class="checkout"><a href="MainController?action=checkOut">Check out</a></div>
        </div>
   </header>
   <div class="container">    
       <div class="shopping">
           <%
            Cart cart = (Cart) session.getAttribute("CART");
            if (cart != null) {
                if (cart.getCart().size() > 0) {
        %>
         <%
                    int count = 1;
                    double total = 0;

                    for (Vegetable veget : cart.getCart().values()) {
                        total += veget.getPrice() * veget.getQuantity();
                %>
           <form action="MainController">
               <div class="product-card">
                   <div class="des-prod">
                       
                       <img src="<%=veget.getImg()%>" alt="">
                       <div class="product-name"><%=veget.getProdName()%></div>
                       <div class="price"><%=veget.getPrice()%></div>
                   </div>
                   <input type="hidden" name="id" value="<%=veget.getProductID()%>"/>
                   <div class="quantity">Số lượng: <input type="number" name="quantity" min="1" value="<%=veget.getQuantity()%>" require=""/></div>
                    <div class="tong">Total: $<%=veget.getPrice()*veget.getQuantity()%>đ</div>

                   <div class="button">
                       <input type="submit" name="action" value="EditCart">
                       <input type="submit" name="action" value="RemoveCart">
                   </div>
               </div>
                    
           </form>                      
       </div>
                     <%
                }
        
%>
<div class="total">Total: <%=total%>đ</div>
<%
}
}
%>

       
      
       <a class="buymore" href="user.jsp">Buy more</a>
   </div>
</body>
</html>