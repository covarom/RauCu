/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package sample.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sample.shopping.Cart;
import sample.shopping.Vegetable;
import sample.utils.ConvertDate;

/**
 *
 * @author Doan
 */
public class AddItemController extends HttpServlet {

    private static final String ERROR="error.jsp";
    private static final String SUCCESS="user.jsp";
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       String url=ERROR;
        ConvertDate cd= new ConvertDate();
       try {                   
            int productID =Integer.parseInt(request.getParameter("productID"));
            String prodName =request.getParameter("prodName");
            String img=request.getParameter("img");
            Double price =Double.parseDouble(request.getParameter("price"));            
            int catagoryID=Integer.parseInt(request.getParameter("catagoryID"));
            Date importDate =cd.StringtoDate(request.getParameter("importDate"));
            Date usingDate=cd.StringtoDate(request.getParameter("usingDate"));                            
            int quantity=Integer.parseInt(request.getParameter("cmbQuantity"));
            Vegetable veget=new Vegetable(productID, prodName, img, price, quantity, catagoryID, importDate, usingDate);
            HttpSession session =request.getSession();
            Cart cart=(Cart) session.getAttribute("CART");
            if(cart==null){
                cart=new Cart();
            }
            cart.add(veget);
            session.setAttribute("CART", cart);
            request.setAttribute("MESSAGE", "Added "+ +quantity+" - "+veget.getProdName()+" successfully");
            url=SUCCESS;
        } catch (Exception e) {
            log("Error at AddController: "+e.toString());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
