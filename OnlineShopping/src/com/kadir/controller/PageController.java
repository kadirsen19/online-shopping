package com.kadir.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {

	@RequestMapping(value= {"/","/home","/index"})
	public ModelAndView index()
	{
		ModelAndView modelAndView = new ModelAndView("page");
		modelAndView.addObject("title", "Home");
		modelAndView.addObject("userClickHome", true);
		return modelAndView;
	}
	
	@RequestMapping("/about")
	public ModelAndView aboutPage() {
		
		ModelAndView model = new ModelAndView("page");
		
		model.addObject("title", "About Us");
		model.addObject("userClickAbout", true);
		return model;
	}
	@RequestMapping("/contact")
	public ModelAndView contact() {
		
		ModelAndView model = new ModelAndView("page");
		
		model.addObject("title", "Contact");
		model.addObject("userClickContact", true);
		return model;
	}
}
