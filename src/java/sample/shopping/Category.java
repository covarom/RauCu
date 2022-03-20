/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sample.shopping;

/**
 *
 * @author Doan
 */
public class Category {
    private int catagoryID;
    private String catagoryName;

    public Category() {
        this.catagoryID=0;
        this.catagoryName="";
    }

    public Category(int catagoryID, String catagoryName) {
        this.catagoryID = catagoryID;
        this.catagoryName = catagoryName;
    }

    public int getCatagoryID() {
        return catagoryID;
    }

    public void setCatagoryID(int catagoryID) {
        this.catagoryID = catagoryID;
    }

    public String getCatagoryName() {
        return catagoryName;
    }

    public void setCatagoryName(String catagoryName) {
        this.catagoryName = catagoryName;
    }
    
    
}
