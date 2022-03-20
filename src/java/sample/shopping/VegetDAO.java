/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sample.shopping;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import sample.utils.ConvertDate;
import sample.utils.DBUtils;

/**
 *
 * @author Doan
 */
public class VegetDAO {

    private static final String SEARCH = "SELECT productID, productName, image,price,quantity,catagoryID,importDate,usingDate FROM tblProduct WHERE productName like ?";
    private static final String SEARCH_PRO = "SELECT * FROM tblProduct WHERE usingDate>GETDATE() AND productName like ?";
    private static final String SUGGESS = "SELECT TOP(8) * FROM tblProduct WHERE  usingDate>getDate();";
    private static final String CHECK_QUANTITY = "SELECT quantity FROM tblProduct WHERE productID=?;";

    private static final String DELETE = "DELETE tblProduct WHERE productID=? ";
    private static final String UPDATE = "UPDATE tblProduct SET productName=? , [image]=? , price=? , quantity=? , catagoryID=? , importDate=? , usingDate=? WHERE productID=?";
    private static final String UPDATE_QUANTITY = "UPDATE tblProduct SET quantity=? WHERE productID=?";
    private static final String CHECK_DUPLICATE = "Select productName FROM tblProduct WHERE productID=?";
    private static final String CREATE = "INSERT INTO tblProduct(productID, productName,[image],price,quantity,catagoryID,[importDate],[usingDate]) VALUES(?,?,?,?,?,?,?,?)";
    
    
    public boolean updateQuantity(int productID, int quantity) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        ConvertDate cd = new ConvertDate();
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(UPDATE_QUANTITY);
                ptm.setString(1, Integer.toString(quantity));
                ptm.setString(2, Integer.toString(productID));               
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
    
    
    public int checkQuantity(int ID) throws SQLException{
        List<Vegetable> list = new ArrayList<Vegetable>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        int quantity=0;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(CHECK_QUANTITY);
                ptm.setString(1, Integer.toString(ID));
                rs = ptm.executeQuery();
                while (rs.next()) {
                    quantity = rs.getInt("quantity");                  
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return quantity;
    }
    
    public List<Vegetable> getListVegetPro(String search) throws SQLException {
        List<Vegetable> list = new ArrayList<Vegetable>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(SEARCH_PRO);
                ptm.setString(1, "%" + search + "%");
                rs = ptm.executeQuery();
                while (rs.next()) {
                    int productID = rs.getInt("productID");
                    String prodName = rs.getString("productName");
                    String img = rs.getString("image");
                    Double price = rs.getDouble("price");
                    int quantity = rs.getInt("quantity");
                    int catagoryID = rs.getInt("catagoryID");
                    Date importDate = rs.getDate("importDate");
                    Date usingDate = rs.getDate("usingDate");
                    list.add(new Vegetable(productID, prodName, img, price, quantity, catagoryID, importDate, usingDate));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return list;
    }

    public boolean create(Vegetable veget) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        ConvertDate cd = new ConvertDate();
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(CREATE);
                ptm.setString(1, Integer.toString(veget.getProductID()));
                ptm.setString(2, veget.getProdName());
                ptm.setString(3, veget.getImg());
                ptm.setString(4, Double.toString(veget.getPrice()));
                ptm.setString(5, Integer.toString(veget.getQuantity()));
                ptm.setString(6, Integer.toString(veget.getCatagoryID()));
                ptm.setString(7, cd.DateToString(veget.getImportDate()));
                ptm.setString(8, cd.DateToString(veget.getUsingDate()));
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

    public boolean checkDuplicate(int productID) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(CHECK_DUPLICATE);
                ptm.setString(1, Integer.toString(productID));
                rs = ptm.executeQuery();
                if (rs.next()) {
                    check = true;
                }
            }
        } catch (Exception e) {

        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return check;
    }

    public boolean update(Vegetable veget) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        ConvertDate cd = new ConvertDate();
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(UPDATE);
                ptm.setString(1, veget.getProdName());
                ptm.setString(2, veget.getImg());
                ptm.setString(3, Double.toString(veget.getPrice()));
                ptm.setString(4, Integer.toString(veget.getQuantity()));
                ptm.setString(5, Integer.toString(veget.getCatagoryID()));
                ptm.setString(6, cd.DateToString(veget.getImportDate()));
                ptm.setString(7, cd.DateToString(veget.getUsingDate()));
                ptm.setInt(8, veget.getProductID());
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

    public boolean delete(String productID) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(DELETE);
                ptm.setString(1, productID);
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

    public List<Vegetable> getListVeget(String search) throws SQLException {
        List<Vegetable> list = new ArrayList<Vegetable>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(SEARCH);
                ptm.setString(1, "%" + search + "%");
                rs = ptm.executeQuery();
                while (rs.next()) {
                    int productID = rs.getInt("productID");
                    String prodName = rs.getString("productName");
                    String img = rs.getString("image");
                    Double price = rs.getDouble("price");
                    int quantity = rs.getInt("quantity");
                    int catagoryID = rs.getInt("catagoryID");
                    Date importDate = rs.getDate("importDate");
                    Date usingDate = rs.getDate("usingDate");
                    list.add(new Vegetable(productID, prodName, img, price, quantity, catagoryID, importDate, usingDate));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return list;
    }

    public List<Vegetable> suggestList() throws SQLException {
        List<Vegetable> list = new ArrayList<Vegetable>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(SUGGESS);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    int productID = rs.getInt("productID");
                    String prodName = rs.getString("productName");
                    String img = rs.getString("image");
                    Double price = rs.getDouble("price");
                    int quantity = rs.getInt("quantity");
                    int catagoryID = rs.getInt("catagoryID");
                    Date importDate = rs.getDate("importDate");
                    Date usingDate = rs.getDate("usingDate");
                    list.add(new Vegetable(productID, prodName, img, price, quantity, catagoryID, importDate, usingDate));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return list;
    }

}
