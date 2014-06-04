package com.givemewish.giftweb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CATEGORY")
public class Category {
	
    @Id
    @Column(name="id")
	private int id;
    
    @Column(name="pid")
    private Integer pid;
	
    @Column(name="name")    
	private String name;
    
    @Column(name="catimg")
    private String catimg;
	
    public String getCatimg() {
        if(catimg != null && !catimg.startsWith("/giftweb")) {
            return "/giftweb/resources/img/cat/"+catimg;
        } else {
            return catimg;
        }
    }

    public void setCaturl(String catimg) {
        this.catimg = catimg;
    }

    public Category() {
	}

	public Category(int id, int pid, String name) {
		super();
		this.id = id;
		this.pid = pid;
		this.name = name;
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
