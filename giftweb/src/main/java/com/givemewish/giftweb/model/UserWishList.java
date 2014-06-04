package com.givemewish.giftweb.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="USER_WISHLIST")
public class UserWishList implements Serializable{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="id")
	private int id;	
    
    //@Id
    @Column(name="uid")
    private int uid;
    
    @Column(name="name")
    private String name;
    
    @Column(name="description")
    private String description;
    
    public UserWishList() {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
