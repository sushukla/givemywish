package com.givemewish.giftweb.dao;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.givemewish.giftweb.model.User;

@Repository
@Transactional
public class UserDAO {
    @Autowired
    private SessionFactory sessionFactory;
 
    public void addUser(User item) {
        sessionFactory.getCurrentSession().save(item);
    }
 
    public List<User> listUsers() {
        return sessionFactory.getCurrentSession().createQuery("from User")
                .list();
    }
    
    public User getUser(Integer id) {
        User user = (User) sessionFactory.getCurrentSession().get(
                User.class, id);
        return user;
    }
 
    public void removeUser(Integer id) {
        User user = (User) sessionFactory.getCurrentSession().load(
                User.class, id);
        if (null != user) {
            sessionFactory.getCurrentSession().delete(user);
        }
 
    }
    
    public User getUserByName(String uname) {
        try {
            String decoded = URLDecoder.decode(uname, "UTF-8");
            uname = decoded;
        } catch (UnsupportedEncodingException e) {}
        Query query = sessionFactory.openStatelessSession().createQuery("from User u "
                + "where u.email='"+uname+"'");
        List<User> result = query.list();
        if(result.size() > 0) {
            return result.get(0);
        } else {
            return null;
        }
    }
}
