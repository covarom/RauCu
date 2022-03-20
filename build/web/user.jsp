
<%@page import="sample.user.UserDTO"%>
<%@page import="sample.shopping.Vegetable"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="./css/user.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css" integrity="sha512-9usAa10IRO0HhonpyAIVpjrylPvoDwiPUiKdWk5t3PyolY1cOd4DSE0Ga+ri4AuTroPR5aQvXU9xC6qOPnzFeg==" crossorigin="anonymous" referrerpolicy="no-referrer" />
        <title>Shopping Page</title>
        <style>

            .logout a{
                color: white;
                text-decoration: none;
            }

            .footer{
                background-color: rgb(40, 163, 77);
                height: 100px;
                padding-top: 30px;
                text-align: center;
                padding-bottom: 40px;
            }
            h2{
                color: yellow;
                position: absolute;
                top: 5px;
                right: 70px;
            }

            .navbar-low a{
                color: white;
            }
            .infor input{
                visibility: hidden;
            }
            .seach {
                margin: 0 100px;
            }

            .seach input{
                width: 600px;
                height: 44px;
                border-radius: 5px;
                border: none;
                box-shadow: 2px 2px rgba(0,0,0,.4);
                font-size: 24px;
                padding-left: 5px;
                outline: none;
            }
            .product-card{
                height: 420px;
            }
            .sanpham input{
                width: 120px;
                height: 34px;
                font-size: 14px;
                background-color: orangered;
                cursor: pointer;
                margin: 5px 0;
            }
            .product-card:nth-child(9){
                margin-left: 150px;
            }



        </style>
    </head>
    <body>
        <header>
            <%
                UserDTO loginUser = (UserDTO) session.getAttribute("LOGIN_USER");
                if (loginUser == null || !loginUser.getRoleID().equals("US")) {
                    response.sendRedirect("login.jsp");
                }
            %>

            <h2>Welcome: <%=loginUser.getFullName()%></h2>
            <div class="logout"><a href="MainController?action=Logout">Logout</a></div>

            <div class="navbar-low">
                <div class="logo-item">
                    <i class="fa-solid fa-cannabis"></i>
                    <p class="shop-name">Cannabis</p>
                </div>
                <form class="seach" action="MainController">
                    <input type="text" name="search">
                    <button type="submit" name="action" value="SearchProd" ><i class="fa-solid fa-magnifying-glass"></i></button>
                </form>
                <a href="viewCart.jsp">
                    <div class="cart-item">
                        <i class="fa-solid fa-cart-shopping"></i>
                    </div>
                </a>

            </div>
        </header>

        <div class="container">

            <div class="shopping">
                <%
                    List<Vegetable> listVeget = (List<Vegetable>) request.getAttribute("LIST_VEGET");
                    if (listVeget != null) {
                        if (listVeget.size() > 0) {
                            int count = 1;
                            for (Vegetable veget : listVeget) {
                %>

                <div class="product-card">
                    <img src="<%=veget.getImg()%>" alt="">
                    <div class="product-name"><%=veget.getProdName()%></div>
                    <div class="price"><%=veget.getPrice()%>đ</div>
                    <form class="sanpham" action="MainController">
                        <div class="infor">
                            <input type="hidden" name="productID" value ="<%=veget.getProductID()%>">
                            <input type="hidden" name="prodName" value ="<%=veget.getProdName()%>">
                            <input type="hidden" name="img" value ="<%=veget.getImg()%>">
                            <input type="hidden" name="price" value ="<%=veget.getPrice()%>">
                            <input type="hidden" name="importDate" value ="<%=veget.getImportDate()%>">
                            <input type="hidden" name="catagoryID" value ="<%=veget.getCatagoryID()%>">
                            <input type="hidden" name="usingDate" value ="<%=veget.getUsingDate()%>">
                        </div> 



                        <span>Số lượng: </span>
                        <select name="cmbQuantity">
                            <option value="1">1</option>
                            <option value="2">2</option>
                            <option value="3">3</option>
                            <option value="4">4</option>
                            <option value="5">5</option>
                            <option value="10">10</option>
                        </select>
                        <input type="submit" name="action" value="addToCard"/>
                    </form>    
                </div>

                <%
                            }
                        }
                    }
                %>
            </div>

        </div>
        <div class="footer">
            <p>--- Công ty TNHH MTV Cannabis --- </p>
            <p>Địa chỉ: 69, Long Thạnh Mỹ, Quận 9, Tp. Hồ Chí Minh</p>
            <p>Hotline: 0393626592
                Gmail: huudoan.qna@gmail.com
            </p>
        </div>
        <%
            String message = (String) request.getAttribute("MESSAGE");
            if (message == null) {
                message = "";
            }
        %>
        <h1 style="color:black; margin: 40px 0 0 50px "> <%= message%> </h1>

        <%
            String success = (String) request.getAttribute("CHECKOUT");
            if (success == null) {
                success = "";
            }
        %>
        <h1 style="color: yellow; margin: 40px 0 0 50px"> <%= success%></h1>
    </body>
</html>