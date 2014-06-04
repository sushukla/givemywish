package com.givemewish.giftweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginPageController {
	
	@RequestMapping("/login" )
	public ModelAndView goHomecontroller() {

		ModelAndView mv=new ModelAndView("login");

		return mv;
	}

}
