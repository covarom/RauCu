/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package sample.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Doan
 */
public class MainController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private static final String ERROR = "error.jsp";
    
//  LOGIN, LOGOUT
    private static final String LOGIN = "Login";
    private static final String LOGIN_CONTROLLER = "LoginController";
    private static final String SEARCH = "Search";
    private static final String SEARCH_CONTROLLER = "SearchController";
    private static final String LOGOUT = "Logout";
    private static final String LOGOUT_CONTROLLER = "LogoutController";
// Category controller
    private static final String EDIT_CATE = "EditCate";
    private static final String EDIT_CATE_CONTROLLER = "EditCateProController";
    private static final String CREATE_CATE = "createNewCate";
    private static final String CREATE_CATE_CONTROLLER = "CreateCateController";
    private static final String DELETE_CATE = "DeleteCate";
    private static final String DELETE_CATE_CONTROLLER = "DeleteCateController";
// Product controller
    private static final String REMOVE_PRO = "RemovePro";
    private static final String REMOVE_PRO_CONTROLLER = "RemoveProController";
    private static final String EDIT_PRO = "EditPro";
    private static final String EDIT_PRO_CONTROLLER = "EditProController";
    private static final String CREATE_PROD ="CreateProd";
    private static final String CREATE_PROD_CONTROLLER = "CreateProdController";
 //    User Page Controller 
    private static final String SEARCH_PROD ="SearchProd";
    private static final String SEARCH_PROD_CONTROLLER = "SearchProdController";
    private static final String ADD_PROD ="addToCard";
    private static final String ADD_PROD_CONTROLLER = "AddItemController";
    private static final String EDIT_CART ="EditCart";
    private static final String EDIT_CART_CONTROLLER = "EditCartController";
    private static final String REMOVE_CART ="RemoveCart";
    private static final String REMOVE_CART_CONTROLLER = "RemoveCartController";
    
//    Check out
    private static final String CHECK_OUT ="checkOut";
    private static final String CHECK_OUT_CONTROLLER = "CheckOutController";
    
    
// Send mail
    private static final String SEND_MAIL ="sendMail";
    private static final String SEND_MAIL_CONTROLLER = "SendMailController";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            String action = request.getParameter("action");
            if (LOGIN.equals(action)) {
                url = LOGIN_CONTROLLER;
            } else if (SEARCH.equals(action)) {
                url = SEARCH_CONTROLLER;
            } else if (LOGOUT.equals(action)) {
                url = LOGOUT_CONTROLLER;
            } else if (REMOVE_PRO.equals(action)) {
                url = REMOVE_PRO_CONTROLLER;
            } else if (EDIT_CATE.equals(action)) {
                url = EDIT_CATE_CONTROLLER;
            } else if (CREATE_CATE.equals(action)) {
                url = CREATE_CATE_CONTROLLER;
            } else if (DELETE_CATE.equals(action)) {
                url = DELETE_CATE_CONTROLLER;
            } else if (EDIT_PRO.equals(action)) {
                url = EDIT_PRO_CONTROLLER;
            } else if (CREATE_PROD.equals(action)) {
                url = CREATE_PROD_CONTROLLER;
            } else if (SEARCH_PROD.equals(action)) {
                url = SEARCH_PROD_CONTROLLER;
            } else if (ADD_PROD.equals(action)) {
                url = ADD_PROD_CONTROLLER;
            } else if (EDIT_CART.equals(action)) {
                url = EDIT_CART_CONTROLLER;
            } else if (REMOVE_CART.equals(action)) {
                url = REMOVE_CART_CONTROLLER;
            }else if (CHECK_OUT.equals(action)) {
                url = CHECK_OUT_CONTROLLER;
            }else if (SEND_MAIL.equals(action)) {
                url = SEND_MAIL_CONTROLLER;
            }
        } catch (Exception e) {
            log("Error At Maincontroller:" + e.toString());
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
