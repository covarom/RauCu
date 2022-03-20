/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sample.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Doan
 */
public class DBUtils {
     public static Connection getConnection() throws ClassNotFoundException, SQLException{
        try{
        Connection conn=null;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String url="jdbc:sqlserver://localhost:1433;databaseName=RauCuDB";
        conn= DriverManager.getConnection(url, "sa","admin");
        return conn;
        }catch(ClassNotFoundException |SQLException e){
            return null;
        }
    }
}
