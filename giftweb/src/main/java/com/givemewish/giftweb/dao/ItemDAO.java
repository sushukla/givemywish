package com.givemewish.giftweb.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.givemewish.giftweb.model.Item;

@Repository
@Transactional
public class ItemDAO {
    @Autowired
    private SessionFactory sessionFactory;
 
    public void addContact(Item item) {
        sessionFactory.getCurrentSession().save(item);
    }
 
    public List<Item> listItem() {
        return sessionFactory.getCurrentSession().createQuery("from Item")
                .list();
    }
    
    public Item getItemById(Integer id) {
        return (Item)sessionFactory.getCurrentSession().get(
                Item.class, id);
    }
 
    public void removeItem(Integer id) {
        Item item = (Item) sessionFactory.getCurrentSession().load(
                Item.class, id);
        if (null != item) {
            sessionFactory.getCurrentSession().delete(item);
        }
 
    }
}
