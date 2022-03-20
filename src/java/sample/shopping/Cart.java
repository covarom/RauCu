/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sample.shopping;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Doan
 */
public class Cart {
    private Map<Integer, Vegetable>cart;

    public Cart() {
    }

    public Cart(Map<Integer, Vegetable> cart) {
        this.cart = cart;
    }

    public Map<Integer, Vegetable> getCart() {
        return cart;
    }

    public void setCart(Map<Integer, Vegetable> cart) {
        this.cart = cart;
    }
    
        public boolean add(Vegetable veget){
        boolean check=false;
        try {
             if(this.cart==null){
            this.cart =new HashMap<>();
            
        }
        if(this.cart.containsKey(veget.getProductID())){
            int currentQuantity =this.cart.get(veget.getProductID()).getQuantity();
            veget.setQuantity(currentQuantity+veget.getQuantity());
        }
        this.cart.put(veget.getProductID(), veget);
        check=true;
        } catch (Exception e) {
        }
        return check;
    }
    
     public boolean remove(int id){
        boolean check=false;
        try {
            if(this.cart!=null){
                if(this.cart.containsKey(id)){
                    this.cart.remove(id);
                    check=true;
                }
            }
        } catch (Exception e) {
        }
        return check;
    }
     
      public boolean update(int id, Vegetable veget){
        boolean check=false;
        try {
            if(this.cart!=null){
                if(this.cart.containsKey(id)){
                    this.cart.replace(id, veget);
                    check=true;
                }
            }
        } catch (Exception e) {
        }
        return check;
    }
}
