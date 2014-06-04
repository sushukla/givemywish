package com.givemewish.giftweb.model;

import java.text.DecimalFormat;

public class LineItem extends Item{

    protected double contrib;

    public double getContrib() {
        return contrib;
    }

    public void setContrib(double contrib) {
        this.contrib = contrib;
    }
    
    public double getShortfall() {
        DecimalFormat df = new DecimalFormat("#.##"); 
        double shortFall = Double.valueOf(df.format(Math.max(price - contrib, 0)));
        return shortFall;
    }
}
