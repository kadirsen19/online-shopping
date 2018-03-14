package com.kadir.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.kadir.dao.CatagoryDAO;
import com.kadir.model.Catagory;

@Controller
public class PageController {

	@Autowired
	private CatagoryDAO catagorydao;
	
	@RequestMapping(value= {"/","/home","/index"})
	public ModelAndView index()
	{
		ModelAndView modelAndView = new ModelAndView("page");
		modelAndView.addObject("title", "Home");
		modelAndView.addObject("userClickHome", true);
		modelAndView.addObject("listCatagory", catagorydao.list());
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
	
	@RequestMapping("/showAllProducts")
	public ModelAndView showAllProducts() {
		
		
		ModelAndView modelAndView = new ModelAndView("page");
		modelAndView.addObject("title", "All Products");
		modelAndView.addObject("userClickAllProducts", true);
		modelAndView.addObject("listCatagory", catagorydao.list());
		return modelAndView;
	}
	@RequestMapping(value="/show/catagory/{id}/products")
	public ModelAndView showCatagoryProductsById(@PathVariable("id") int id) {
		
		ModelAndView modelAndView = new ModelAndView("page");
		
		//catagoryDAO to fetch a single catagory
		
		Catagory catagory = catagorydao.getCatagoryById(id);
		
		modelAndView.addObject("title",catagory.getName());
		modelAndView.addObject("listCatagory", catagorydao.list());
		modelAndView.addObject("userClickCatagoryProducts", true);
		modelAndView.addObject("catagory",catagory);
		return modelAndView;
	}
}
