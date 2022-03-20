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
public class OrderDetailDAO {
    
    private static final String CREATE = "INSERT INTO tblOrderDetail(detailID, price,quantity,orderID,productID) VALUES(?,?,?,?,?)";
    
    public boolean create(OrderDetail dd) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        ConvertDate cd = new ConvertDate();
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(CREATE);
                ptm.setString(1, Integer.toString(dd.getDetailID()));
                ptm.setString(2, Double.toString(dd.getMoney()));
                ptm.setString(3, Integer.toString(dd.getQuantity()));
                ptm.setString(4, Integer.toString(dd.getOrderID()));
                ptm.setString(5, Integer.toString(dd.getProductID()));             
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
