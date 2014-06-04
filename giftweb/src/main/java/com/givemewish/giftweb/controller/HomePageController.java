package com.givemewish.giftweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.givemewish.giftweb.dao.CategoryDAO;
import com.givemewish.giftweb.dao.ItemDAO;
import com.givemewish.giftweb.model.Category;
import com.givemewish.giftweb.model.Item;
import com.givemewish.giftweb.model.MockData;
import com.givemewish.giftweb.model.ShoppingCart;
import com.givemewish.giftweb.util.GiftwebUtils;

@Controller
@Scope("request")
public class HomePageController {
	
	@Autowired
	ItemDAO itemDAO;
	
	@Autowired
	CategoryDAO categoryDAO;
	
    @Autowired
    ShoppingCart cart;
    
	@RequestMapping("/gweb" )
	public ModelAndView goHomecontroller() {

		ModelAndView mv=new ModelAndView("home");
		mv.addObject("catList", MockData.getCategories());
		mv.addObject("itemList", MockData.getItems());
		return mv;
	}
	
	@RequestMapping("/home")
	public ModelAndView listItems() {
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("catList", categoryDAO.listCategories());
		List<Item> items = itemDAO.listItem();
        mv.addObject("carouselItems", items);
		mv.addObject("itemList", items);
        mv.addObject("cartNum", cart.getTotalNum());       
        mv.addObject("uid", GiftwebUtils.getCurrentLoggedInUserId());
		return mv;
	}
	
   @RequestMapping("/list/{cat}")
    public ModelAndView listItemsForCat(@PathVariable Integer cat) {
        ModelAndView mv = new ModelAndView("home");
        mv.addObject("catList", categoryDAO.listCategories());
        //List<Item> items = categoryDAO.getItemsForCategory(cat);
        List<Category> childCats = categoryDAO.listChildCategories(cat);
        List<Item> carouselItems = itemDAO.listItem();
        mv.addObject("carouselItems", carouselItems);
        mv.addObject("childCats", childCats);
        mv.addObject("cartNum", cart.getTotalNum());
        mv.addObject("uid", GiftwebUtils.getCurrentLoggedInUserId());
        return mv;
    }

}
