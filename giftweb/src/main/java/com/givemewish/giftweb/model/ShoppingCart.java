package com.givemewish.giftweb.model;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("session")
public class ShoppingCart {
    
    private Map<Item, Integer> cartItems;
    
    public ShoppingCart() {
        cartItems = new HashMap<Item, Integer>();
    }


    public Map<Item, Integer> getCartItems() {
        return cartItems;
    }


    public void setCartItems(Map<Item, Integer> cartItems) {
        this.cartItems = cartItems;
    }


    public void addItem(Item item) {
        //Integer inItm = cartItemIds.get(item.getId());
        //if(inItm != null) {
        if(item == null) {
            return;
        }
        boolean exists = false;
        for(Map.Entry<Item, Integer> entry : cartItems.entrySet()) {
            int existId = entry.getKey().getId();
            int existNum = entry.getValue();
            if(item.getId() == existId) {
                cartItems.put(entry.getKey(), existNum+1);
                exists = true;
                break;
            }
        }
        if(!exists) {
            cartItems.put(item, 1);
        }
    }
    
    public void updateItem(int id, int quantity) {
        Item item = getItemById(id);
        Integer currentCount = cartItems.get(item);
        if(currentCount != null) {
            if(quantity == 0) {
                cartItems.remove(item);
            } else {
                cartItems.put(item, quantity);
            }
        }
    }
    
    public Item getItemById(int id) {
        for(Map.Entry<Item, Integer> entry : cartItems.entrySet()) {
            int existId = entry.getKey().getId();
            if(existId == id) {
                return entry.getKey();
            }
        }
        return null;
    }
    
    public String getCartTotal() {
        double total = 0.0;
        for(Item item : cartItems.keySet()) {
            total += item.price*cartItems.get(item);
        }
        DecimalFormat df = new DecimalFormat("#.00");
        return df.format(total);
    }
    
    public int getTotalNum() {
        int nItems = 0;
        for(Item item : cartItems.keySet()) {
            nItems += cartItems.get(item);
        }
        return nItems;
    }

}
