package com.givemewish.giftweb.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="WISHLIST")
public class WishList implements Serializable{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="id")
	private int id;	
    
    @Id
    @Column(name="uid")
    private int uid;
    
    @Id
    @Column(name="itemid")
	private int itemid;
    
    @Column(name="wlname")
    private String name;
    
    public WishList() {
    }
			
	public int getItemid() {
        return itemid;
    }

    public void setItemid(int itemid) {
        this.itemid = itemid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
