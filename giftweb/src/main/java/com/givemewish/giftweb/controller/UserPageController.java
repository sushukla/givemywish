package com.givemewish.giftweb.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.givemewish.giftweb.dao.ItemDAO;
import com.givemewish.giftweb.dao.UserDAO;
import com.givemewish.giftweb.dao.UserWishListItemDAO;
import com.givemewish.giftweb.dao.WishListDAO;
import com.givemewish.giftweb.model.Item;
import com.givemewish.giftweb.model.LineItem;
import com.givemewish.giftweb.model.ShoppingCart;
import com.givemewish.giftweb.model.User;
import com.givemewish.giftweb.model.UserWishList;
import com.givemewish.giftweb.model.UserWishListItem;
import com.givemewish.giftweb.model.UserWishListTotals;
import com.givemewish.giftweb.util.GiftwebUtils;

@Controller
@Scope("request")
public class UserPageController {

    @Autowired
    UserDAO userDAO;

    @Autowired
    WishListDAO wishlistDAO;
    
    @Autowired
    ItemDAO itemDAO;
    
    @Autowired
    UserWishListItemDAO userWishlistItemDAO;
    
    @Autowired
    ShoppingCart cart;

    @RequestMapping("/user/{id}")
    public ModelAndView showUserController(@PathVariable String id) {
        if (!StringUtils.hasText(id)) {
            return new ModelAndView("home");
        }
        Integer idInt = null;
        try {
            idInt = Integer.parseInt(id);
        } catch (NumberFormatException e) {
            return null;
        }
        ModelAndView mv = new ModelAndView("user");
        User user = userDAO.getUser(idInt);

        List<UserWishList> wLists = wishlistDAO.getWishLists(idInt);
        mv.addObject("wlists", wLists);
        mv.addObject("user", user);
        mv.addObject("cartNum", cart.getTotalNum());
        mv.addObject("uid", id);
        
        return mv;
    }

    @RequestMapping("/user/{uid}/{wid}")
    public ModelAndView showWlistItemController(@PathVariable Integer uid,
            @PathVariable Integer wid) {
        ModelAndView mv = new ModelAndView("user");
        User user = userDAO.getUser(uid);
        List<UserWishList> wLists = wishlistDAO.getWishLists(uid);
        UserWishList uWlist = wishlistDAO.getWishlistById(wid);
        mv.addObject("wlists", wLists);
        mv.addObject("user", user);
        mv.addObject("currentList", wid);
        mv.addObject("ulist", uWlist);
        List<Item> items = wishlistDAO.getWishlistItems(wid);
        List<LineItem> lineItems = new ArrayList<LineItem>(items.size());
        for(Item itm: items) {
            LineItem lineItem = new LineItem();
            Double contrib = wishlistDAO.getOwnContrib(wid, itm.getId());
            lineItem.setContrib(contrib);
            lineItem.setId(itm.getId());
            lineItem.setCatid(itm.getCatid());
            lineItem.setDescription(itm.getDescription());
            lineItem.setPrice(itm.getPrice());
            lineItem.setTitle(itm.getTitle());
            lineItem.setImgurl(itm.getImgurl());
            lineItems.add(lineItem);
        }
        UserWishListTotals totals = wishlistDAO.getWishlistTotals(wid);
        mv.addObject("totals", totals);
        mv.addObject("itemList", lineItems);
        mv.addObject("cartNum", cart.getTotalNum());
        mv.addObject("uid", GiftwebUtils.getCurrentLoggedInUserId());
        return mv;
    }
    
    @RequestMapping("/user/{uid}/{wid}/{itemid}")
    public ModelAndView addToWishlistController(@PathVariable Integer uid,
            @PathVariable Integer wid, @PathVariable Integer itemid) {
        ModelAndView mv = new ModelAndView("home");
        
        UserWishListItem addedItem = new UserWishListItem();
        addedItem.setItemid(itemid);
        addedItem.setWid(wid);
        addedItem.setContrib(0.0);
        userWishlistItemDAO.addWishListItem(addedItem);
        mv.addObject("uid", GiftwebUtils.getCurrentLoggedInUserId());
        return mv;
    }
    
    @RequestMapping(value="/user/{uid}/addw", method = RequestMethod.POST)
    public ModelAndView addWishListController(@PathVariable Integer uid,
            @RequestParam("wname") String wname) {
        ModelAndView mv = new ModelAndView("user");
        UserWishList newWishList = new UserWishList();
        //newWishList.setId(fromw+2);
        newWishList.setName(wname);
        newWishList.setUid(uid);
        wishlistDAO.addWishList(newWishList);
        updateModelsForPage(uid, 0, mv);
        mv.addObject("cartNum", cart.getTotalNum());
        mv.addObject("uid", GiftwebUtils.getCurrentLoggedInUserId());
        return mv;
    } 
    
    @RequestMapping(value="/user/{uid}/delw", method = RequestMethod.POST)
    public ModelAndView deleteWishListController(@PathVariable Integer uid,
            @RequestParam("wid") int wid) {
        ModelAndView mv = new ModelAndView("user");
        if(wid != 0) {
            wishlistDAO.removeWishList(wid);
        }
        updateModelsForPage(uid, wid, mv);
        mv.addObject("cartNum", cart.getTotalNum());
        mv.addObject("uid", GiftwebUtils.getCurrentLoggedInUserId());
        return mv;
    }
    
    @RequestMapping(value="/user/{uid}/{wid}/{itemid}", method = RequestMethod.POST)
    public ModelAndView changeContribController(@PathVariable Integer uid,
            @PathVariable Integer wid, @PathVariable Integer itemid,
            @RequestParam("contrib") double contrib) {
        //ModelAndView mv = new ModelAndView("user");
        UserWishListItem wItem = userWishlistItemDAO.getWishlistItemByPk(wid, itemid);
        wItem.setContrib(contrib);
        userWishlistItemDAO.updateWishListItem(wItem);
        //updateModelsForPage(uid, mv);
        return showWlistItemController(uid, wid);
        //return mv;
    }
    
    private void updateModelsForPage(int uid, int wid, ModelAndView mv) {
        User user = userDAO.getUser(uid);
        List<UserWishList> wLists = wishlistDAO.getWishLists(uid);
        mv.addObject("wlists", wLists);
        mv.addObject("currentList", wid);
        mv.addObject("user", user);
        List<Item> items = Collections.<Item>emptyList();
        mv.addObject("itemList", items);        
    }

}
