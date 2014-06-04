package com.givemewish.giftweb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ITEM")
public class Item {
	
    @Id
    @Column(name="id")
    @GeneratedValue
	protected int id;
	
    @Column(name="title")
	protected String title;
	
    @Column(name="catid")
	protected int catid;
	
	
    @Column(name="imgurl")
	protected String imgurl;

	
    @Column(name="description")
	protected String description;

	
    @Column(name="reviews")
	protected int reviews;
    
    
    @Column(name="price")
	protected double price; 
    
    
    @Column(name="shipping")
	protected double shipping; 
    
    

	public int getCatid() {
		return catid;
	}


	public void setCatid(int catid) {
		this.catid = catid;
	}


	public String getImgurl() {
	    if(imgurl != null && !imgurl.startsWith("/giftweb")) {
	        return "/giftweb/resources/img/"+imgurl;
	    } else {
	        return imgurl;
	    }
	}


	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}


	public double getShipping() {
		return shipping;
	}


	public void setShipping(double shipping) {
		this.shipping = shipping;
	}


	public Item() {
		super();
	}


	public Item(int id, String title, int categoryId, 
			double price, String description, String shopUrl, int reviews) {
		super();
		this.id = id;
		this.title = title;
		this.catid = categoryId;
		this.price = price;
		this.description = description;
		this.imgurl = shopUrl;
		this.reviews = reviews;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getShopUrl() {
		return imgurl;
	}

	public void setShopUrl(String shopUrl) {
		this.imgurl = shopUrl;
	}

	public int getReviews() {
		return reviews;
	}

	public void setReviews(int reviews) {
		this.reviews = reviews;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getCategoryId() {
		return catid;
	}

	public void setCategoryId(int categoryId) {
		this.catid = categoryId;
	}

}
