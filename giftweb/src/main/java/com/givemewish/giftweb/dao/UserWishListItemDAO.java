package com.givemewish.giftweb.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.givemewish.giftweb.model.UserWishListItem;

@Repository
@Transactional
public class UserWishListItemDAO {
    @Autowired
    private SessionFactory sessionFactory;
 
    public void addWishListItem(UserWishListItem listItem) {
        sessionFactory.getCurrentSession().save(listItem);
    }
    
    public void updateWishListItem(UserWishListItem listItem) {
        sessionFactory.getCurrentSession().saveOrUpdate(listItem);
    }
    
    public UserWishListItem getWishlistItemByPk(Integer wid, Integer itemid) {
        return (UserWishListItem)sessionFactory.getCurrentSession().get(
                UserWishListItem.class, new UserWishListItem.UserWishListItemPK(wid, itemid));
    }

}
