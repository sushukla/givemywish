package com.givemewish.giftweb.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.givemewish.giftweb.model.Category;
import com.givemewish.giftweb.model.Item;

@Repository
@Transactional
public class CategoryDAO {
    @Autowired
    private SessionFactory sessionFactory;
    
    @Autowired
    ItemDAO itemDAO;
 
    public void addCategory(Category category) {
        sessionFactory.getCurrentSession().save(category);
    }
    
    public Category getCategoryById(Integer id) {
        return (Category)sessionFactory.getCurrentSession().get(
                Category.class, id);
    }
    
    public List<Category> listCategories() {
        return sessionFactory.getCurrentSession().createQuery("from Category where pid=NULL")
                .list();
    }
    
    public List<Category> listChildCategories(Integer parentId) {
        return sessionFactory.getCurrentSession().createQuery("from Category where pid="+parentId)
                .list();
    }
    
    public List<Item> getItemsForCategory(Integer catId) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Item i "
                + "where i.catid="+catId);
        List<Item> result = query.list();
        return result;
    }
}
