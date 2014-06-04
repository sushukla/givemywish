package com.givemewish.giftweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.givemewish.giftweb.dao.ItemDAO;
import com.givemewish.giftweb.model.Item;
import com.givemewish.giftweb.model.ShoppingCart;
import com.givemewish.giftweb.util.GiftwebUtils;

@Controller
@Scope("request")
public class CartController {
	
    @Autowired
    private ShoppingCart cart;
    
    @Autowired
    ItemDAO itemDAO;
  
    @RequestMapping("/addtocart/{id}")
    public ModelAndView addToCart(@PathVariable("id") int id)
    {
        System.out.println("cart add"+id);
        Item item = itemDAO.getItemById(id);
        ModelAndView mv=new ModelAndView("cart");
        
        cart.addItem(item);
        System.out.println("cart "+cart.getCartItems());
        mv.addObject("cart", cart);
        mv.addObject("cartNum", cart.getTotalNum());
        mv.addObject("uid", GiftwebUtils.getCurrentLoggedInUserId());
       // now just use the cart
        
        return mv;
    } 
    
    @RequestMapping("/updatecart/{id}")
    public ModelAndView updateCart(@PathVariable("id") int id,
            @RequestParam("cqty") int quantity) {
        ModelAndView mv=new ModelAndView("cart");
        //Item item = itemDAO.getItemById(id);
        cart.updateItem(id, quantity);
        mv.addObject("cart", cart);
        mv.addObject("cartNum", cart.getTotalNum());
        mv.addObject("uid", GiftwebUtils.getCurrentLoggedInUserId());
        return mv;
    }
}
