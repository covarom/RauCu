<%-- 
    Document   : login
    Created on : Mar 3, 2022, 11:19:18 AM
    Author     : Doan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="./css/login.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css" integrity="sha512-9usAa10IRO0HhonpyAIVpjrylPvoDwiPUiKdWk5t3PyolY1cOd4DSE0Ga+ri4AuTroPR5aQvXU9xC6qOPnzFeg==" crossorigin="anonymous" referrerpolicy="no-referrer" />
        <title>Login Page</title>
        <script src="https://www.google.com/recaptcha/api.js" async defer></script>
        
    </head>
    <body>
        <div class="container">
            <a href="index.jsp">

                <div class="head">
                    <i class="fa-solid fa-cannabis"></i>
                    <p>Cannabis Shop</p>
                </div>

            </a>
            <div class="signin">

                <p class="title">Sign In</p>
                <p class="descr"></p>
                <form action="MainController" method="POST" onsubmit="return validateForm()">
                    <div class="userId">

                        <label for="id">User ID:</label>
                        <input type="text" name="userID" required=""/></br>
                    </div>
                    <div class="pass">

                        <label for="pass">Password:</label>
                        <input type="password" name="password" required=""/></br>
                    </div>
                    <div  " class="g-recaptcha" data-sitekey="6Lc0usseAAAAAE8hwFQZAKM2ZF7M44PZQv_JSKSY"></div>
                    <div class="btn">

                        <input type="submit" name="action" value="Login"/>
                        <input type="reset" value="Reset" />
                    </div>
                    <div class="regis">
                        <p>Don't have an account yet?</p>
                        <a href="">Register now</a>
                    </div>
                </form>
            </div>     
        </div>
        <script type="text/javascript">
            function validateForm(){
                if(grecaptcha.getResponse()){
                    return true;
                }else {
                    alert("Please prove that you're not robot!!!");
                    return false;
                }
            }     
        </script>
    </body>
</html>