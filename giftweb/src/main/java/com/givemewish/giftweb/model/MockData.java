package com.givemewish.giftweb.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MockData {
	
	public static List<Category> getCategories(){
		Category cm1 = new Category(104, 100, "beverage");
        Category cm2 = new Category(104, 100, "beverage");
		List<Category> catList = new ArrayList<Category>();
		catList.add(cm1);
		catList.add(cm2);
		return catList;
	}
	
	public static List<Item> getItems() {
		Item item1 = new Item(1,"General Part",113,300.5,"","",2);
		Item item2 = new Item(1,"Electronics Part",114,200.0,"","",3);
		Item item3 = new Item(1,"Phone Part",114,100.9,"","",4);
		Item item4 = new Item(1,"BMW Part",115,2400.0,"","",2);
		Item item5 = new Item(1,"Cable Part",113,100.9,"","",4);
		Item item6 = new Item(1,"Laptor Part",114,400.0,"","",2);
		
		return Arrays.asList(new Item[]{item1,item2,item3,item4,item5,item6});
	}

}
