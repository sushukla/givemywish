package com.givemewish.giftweb.model;


public class UserWishListTotals{
    /**
     * 
     */
    private double totalPrice;
    private double totalContrib;
    public double getTotalPrice() {
        return totalPrice;
    }
    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
    public double getTotalContrib() {
        return totalContrib;
    }
    public void setTotalContrib(double totalContrib) {
        this.totalContrib = totalContrib;
    }
    public double getTotalShortfall() {
        return totalPrice - totalContrib;
    }
    
}
