<%-- 
    Document   : index
    Created on : Mar 3, 2022, 11:17:03 AM
    Author     : Doan
--%>

<%@page import="sample.shopping.Vegetable"%>
<%@page import="java.util.List"%>
<%@page import="sample.shopping.VegetDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./css/index.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css" integrity="sha512-9usAa10IRO0HhonpyAIVpjrylPvoDwiPUiKdWk5t3PyolY1cOd4DSE0Ga+ri4AuTroPR5aQvXU9xC6qOPnzFeg==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <title>Cannabis Shop</title>
    <style>
        .login a{
            color: white;
            text-decoration: none;
        }
    </style>
</head>
<body>
    <header>

        <div class="login"><a href="login.jsp">Login</a></div>
        
        <div class="navbar-low">
            <div class="logo-item">
                <i class="fa-solid fa-cannabis"></i>
                <p class="shop-name">Cannabis</p>
            </div>
            <form class="seach" action="./login.jsp">
                <input type="search">
                <button type="submit"><i class="fa-solid fa-magnifying-glass"></i></button>
            </form>
            <div class="cart-item">
                <i class="fa-solid fa-cart-shopping"></i>
            </div>
        </div>
    </header>

    <div class="container">
        <div class="banner">
           
       Let's shopping !!! </div>
          
        <div class="shopping">
            
               <%VegetDAO dao =new VegetDAO();
           List<Vegetable> listVeget=dao.suggestList();
           if (listVeget.size() > 0) {              
                    int count = 1;
                    for (Vegetable veget : listVeget) {
                    count++;                  
                %>              
            <div class="product-card">
                <img src="<%=veget.getImg()%>" alt="">
                <div class="product-name"><%=veget.getProdName()%></div>
                <div class="price"><%=veget.getPrice()%>??</div>
                <form action="login.jsp">
                    <button>Buy now</button>
                </form>
            </div>
                <%
                    }
                    }
                %>
        </div>
    </div>
    
   <div class="footer">
       <p>--- C??ng ty TNHH MTV Cannabis --- </p>
       <p>?????a ch???: 69, Long Th???nh M???, Qu???n 9, Tp. H??? Ch?? Minh</p>
       <p>Hotline: 0393626592
           Gmail: huudoan.qna@gmail.com
       </p>
   </div>
</body>
</html>