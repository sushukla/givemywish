package com.givemewish.giftweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.givemewish.giftweb.dao.ItemDAO;
import com.givemewish.giftweb.model.ShoppingCart;

@Controller
@Scope("request")
public class ViewItemPageController {
	
	@Autowired
	ItemDAO itemDAO;
	
    @Autowired
    ShoppingCart cart;
	
	@RequestMapping("/item/{id}" )
	public ModelAndView goHomecontroller(@PathVariable Integer id) {

		ModelAndView mv=new ModelAndView("viewitem");
		mv.addObject("item", itemDAO.getItemById(id));
		mv.addObject("cartNum", cart.getTotalNum());
		return mv;
	}

}
