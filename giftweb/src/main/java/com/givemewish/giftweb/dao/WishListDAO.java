package com.givemewish.giftweb.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.givemewish.giftweb.model.Item;
import com.givemewish.giftweb.model.UserWishList;
import com.givemewish.giftweb.model.UserWishListItem;
import com.givemewish.giftweb.model.UserWishListTotals;

@Repository
@Transactional
public class WishListDAO {
    @Autowired
    private SessionFactory sessionFactory;
    
    @Autowired
    ItemDAO itemDAO;
 
    public void addWishList(UserWishList wList) {
        sessionFactory.getCurrentSession().save(wList);
    }
    
    public UserWishList getWishlistById(Integer wid) {
        return (UserWishList)sessionFactory.getCurrentSession().get(
                UserWishList.class, wid);
    }
    
    public UserWishListTotals getWishlistTotals(Integer wid) {
        Query query = sessionFactory.getCurrentSession().createQuery("select sum(i.price) from UserWishListItem w, "
                + "Item i where w.wid="+wid+" and w.itemid=i.id");
        Object result = query.list();
        System.out.println("qres "+result);
        UserWishListTotals totals = new UserWishListTotals();
        if(result != null) {
            Object dvalue = ((List)result).iterator().next();
            if(dvalue != null) {
                totals.setTotalPrice((Double)dvalue);
            }
        }

        query = sessionFactory.getCurrentSession().createQuery("select sum(w.contrib) from UserWishListItem w "
                + "where w.wid="+wid);
        result = query.list();
        if(result != null) {
            Object dvalue = ((List)result).iterator().next();
            if(dvalue != null) {
                totals.setTotalContrib((Double)dvalue);
            }
        }
        return totals;

    }
 
    public List<UserWishList> getWishLists(Integer uid) {
        return sessionFactory.getCurrentSession().createQuery("from UserWishList where uid="+uid)
                .list();
    }
    
    public List<Item> getWishlistItems(Integer wid) {
        Query query = sessionFactory.getCurrentSession().createQuery("from UserWishListItem where wid="+wid);
        List<UserWishListItem> wItemList = query.list();
        List<Item> theList = new ArrayList<Item>();
        for(UserWishListItem w: wItemList) {
            Integer id = w.getItemid();
            Item itm = itemDAO.getItemById(id);
            theList.add(itm);
        }
        return theList;
    }
    
    public Double getOwnContrib(Integer wid, Integer itemid) {
        Query query = sessionFactory.getCurrentSession().createQuery("from UserWishListItem where wid="+wid+ 
                "and itemid="+itemid);
        Object result = query.uniqueResult();
        if(result != null) {
            return ((UserWishListItem)result).getContrib();
        } else {
            return 0.00;
        }      
    }
 
    public void removeWishList(Integer id) {
        UserWishList wishList = (UserWishList) sessionFactory.getCurrentSession().load(
                UserWishList.class, id);
        if (null != wishList) {
            sessionFactory.getCurrentSession().delete(wishList);
        }
 
    }
}
