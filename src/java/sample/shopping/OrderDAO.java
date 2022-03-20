/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sample.shopping;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import sample.utils.ConvertDate;
import sample.utils.DBUtils;

/**
 *
 * @author Doan
 */
public class OrderDAO {
    
    private static final String CREATE = "INSERT INTO tblOrder(orderID, orderDate,total,userID) VALUES(?,?,?,?)";
    private static final String UPDATE = "UPDATE tblOrder SET total=?  WHERE orderID=?";
    
    public boolean update(Order order) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        ConvertDate cd = new ConvertDate();
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(UPDATE);
                ptm.setString(1, Double.toString(order.getTotal()));
                ptm.setString(2, Integer.toString(order.getOrderID()));              
                check = ptm.executeUpdate() > 0 ? true : false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return check;
    }
    
    
    
    public boolean create(Order order) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        ConvertDate cd = new ConvertDate();
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(CREATE);
                ptm.setString(1, Integer.toString(order.getOrderID()));
                ptm.setString(2, cd.DateToString(order.getOrderDate()));
                ptm.setString(3, Double.toString(order.getTotal()));
                ptm.setString(4, order.getUserID()); 
                check = ptm.executeUpdate() > 0 ? true : false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return check;
    }
    
}
