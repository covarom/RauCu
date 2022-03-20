/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sample.shopping;

import java.util.Date;

/**
 *
 * @author Doan
 */
public class Vegetable {
    private int productID;
    private String prodName;
    private String img;
    private double price;
    private int quantity;
    private int catagoryID;
    private Date importDate;
    private Date usingDate;

    public Vegetable(int productID, String prodName, String img, double price, int quantity, int catagoryID, Date importDate, Date usingDate) {
        this.productID = productID;
        this.prodName = prodName;
        this.img = img;
        this.price = price;
        this.quantity = quantity;
        this.catagoryID = catagoryID;
        this.importDate = importDate;
        this.usingDate = usingDate;
    }
    

    public Vegetable() {
        this.productID = 0;
        this.prodName = "";
        this.img = "";
        this.price = 0;
        this.quantity = 0;
        this.catagoryID = 0;
        this.importDate = null;
        this.usingDate = null;
    }
    
    
    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getCatagoryID() {
        return catagoryID;
    }

    public void setCatagoryID(int catagoryID) {
        this.catagoryID = catagoryID;
    }

    public Date getImportDate() {
        return importDate;
    }

    public void setImportDate(Date importDate) {
        this.importDate = importDate;
    }

    public Date getUsingDate() {
        return usingDate;
    }

    public void setUsingDate(Date usingDate) {
        this.usingDate = usingDate;
    }
    
}
