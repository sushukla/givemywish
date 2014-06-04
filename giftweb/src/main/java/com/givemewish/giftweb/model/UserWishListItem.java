package com.givemewish.giftweb.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.givemewish.giftweb.model.UserWishListItem.UserWishListItemPK;

@Entity
@Table(name="USER_WISHLIST_ITEMS")
@IdClass(UserWishListItemPK.class)
public class UserWishListItem implements Serializable{
    
    public static class UserWishListItemPK implements Serializable{

        private static final long serialVersionUID = -2901922012743904375L;
        private int wid;    
        private int itemid;
        
        public UserWishListItemPK() {
            super();
        }
        public UserWishListItemPK(int wid, int itemid) {
            this.wid = wid;
            this.itemid = itemid;
        }
        public int getWid() {
            return wid;
        }
        public void setWid(int wid) {
            this.wid = wid;
        }
        public int getItemid() {
            return itemid;
        }
        public void setItemid(int itemid) {
            this.itemid = itemid;
        }
        
    }
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="wid")
	private int wid;	
    
    @Id
    @Column(name="itemid")
    private int itemid;
    
    @Column(name="contrib")
    private double contrib;

    
    public UserWishListItem() {
    }
			
	public int getItemid() {
        return itemid;
    }

    public void setItemid(int itemid) {
        this.itemid = itemid;
    }

    public int getWid() {
        return wid;
    }

    public void setWid(int wid) {
        this.wid = wid;
    }

    public double getContrib() {
        return contrib;
    }

    public void setContrib(double contrib) {
        this.contrib = contrib;
    }
}
