package com.givemewish.giftweb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ITEM")
public class Cart {
    
    @Id
    @Column(name="id")
    @GeneratedValue
    protected int id;
    
    protected int uid;
    
    protected int itemid;
    
    protected int qt;

}
