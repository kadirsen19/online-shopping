package com.kadir.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/cart")
public class CartController {

	@RequestMapping("/show")
	public ModelAndView showCart() {
		ModelAndView modelAndView = new ModelAndView("page");
		modelAndView.addObject("title","User Cart");
		modelAndView.addObject("userClickShowCart",true);
		modelAndView.addObject("cartLines",null);
		return modelAndView;
	}
}
