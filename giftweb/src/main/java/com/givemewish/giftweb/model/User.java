package com.givemewish.giftweb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="USER")
public class User {
	
    @Id
    @Column(name="id")
    @GeneratedValue
	private int id;
	
    @Column(name="name")
	private String name;
	
    @Column(name="email")
	private String email;
	
    @Column(name="phone")
	private String phone;
	
    @Column(name="address")
	private String address;
    
    @Column(name="passwd")
    private String passwd;
	
	//private Map<String, List<Item>> wishlists;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

//	public Map<String, List<Item>> getWishlists() {
//		return wishlists;
//	}
//
//	public void setWishlists(Map<String, List<Item>> wishlists) {
//		this.wishlists = wishlists;
//	}

}
