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
import sample.utils.ConvertDate;
import java.util.Date;
import sample.shopping.VegetDAO;
import sample.shopping.Vegetable;

/**
 *
 * @author Doan
 */
public class EditProController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    private static final String ERROR="admin.jsp";
    private static final String SUCCESS="admin.jsp";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
         String url=ERROR;
         ConvertDate cd=new ConvertDate();
        try {
            int productID= Integer.parseInt(request.getParameter("productID"));
            String prodName=request.getParameter("prodName");
            String img =request.getParameter("img");
            Double price=Double.parseDouble(request.getParameter("price"));
            int quantity=Integer.parseInt(request.getParameter("quantity"));
            int CatagoryID=Integer.parseInt(request.getParameter("CatagoryID"));
            Date importDate= cd.StringtoDate(request.getParameter("importDate"));
            Date usingDate=cd.StringtoDate(request.getParameter("usingDate"));
            Vegetable veget=new Vegetable(productID, prodName, img, price, quantity, CatagoryID, importDate, usingDate);
             VegetDAO dao=new VegetDAO();
                
                boolean checkUpdate=dao.update(veget);
          
                if(checkUpdate){
         
                url=SUCCESS;
            }
        } catch (Exception e) {
            log("Error at UpdateCateController: "+e.toString());
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
