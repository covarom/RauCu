/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package sample.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sample.shopping.Cart;
import sample.shopping.Order;
import sample.shopping.OrderDAO;
import sample.shopping.OrderDetail;
import sample.shopping.OrderDetailDAO;
import sample.shopping.VegetDAO;
import sample.shopping.Vegetable;
import sample.user.UserDTO;
import sample.utils.ConvertDate;

/**
 *
 * @author Doan
 */
public class CheckOutController extends HttpServlet {

    private static final String ERROR = "error.jsp";
    private static final String SUCCESS = "user.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            HttpSession session = request.getSession();
            if (session != null) {
                Cart cart = (Cart) session.getAttribute("CART");
                UserDTO loginUser = (UserDTO) session.getAttribute("LOGIN_USER");
                if (cart != null) {
                    VegetDAO dao = new VegetDAO();
                    ConvertDate cd = new ConvertDate();
                    int idrd=cd.GetID();
                    Order order = new Order(idrd, cd.getDate(), 0,loginUser.getUserID());
                    OrderDAO daoOrder = new OrderDAO();
                    boolean test1=daoOrder.create(order);
                    double total = 0;
                    for (Vegetable veget : cart.getCart().values()) {
                        if (veget.getQuantity() < dao.checkQuantity(veget.getProductID())) {
                            OrderDetailDAO daoDetail = new OrderDetailDAO();
                            OrderDetail orderDetail = new OrderDetail(cd.GetID(), veget.getPrice(), veget.getQuantity(), idrd, veget.getProductID());
                            total += veget.getPrice() * veget.getQuantity();
                            order = new Order(order.getOrderID(), order.getOrderDate(), total, order.getUserID());
                            daoOrder.update(order);
                            dao.updateQuantity(veget.getProductID(), (dao.checkQuantity(veget.getProductID()) - veget.getQuantity()));
                            daoDetail.create(orderDetail);
                            
                        } else {
                            request.setAttribute("ERRORCHECKOUT", " PRODUCT IS SOLD OUT !!!");
                        }
                    }
                    request.setAttribute("CHECKOUT", "YOU HAVE MADE A SUCCESSFULLY PURCHASE !!!!");
                    session.setAttribute("CART", null);
                    url=SUCCESS;
                } else {
                    request.setAttribute("ERROR", "YOUR CART DOESN'T EXIST !!!");
                }
            }
        } catch (Exception e) {
            log("Error at CheckOutController: "+e.toString());
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
