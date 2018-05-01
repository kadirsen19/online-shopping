package com.kadir.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kadir.dao.CatagoryDAO;
import com.kadir.dao.ProductDAO;
import com.kadir.exceptions.ProductExceptionHandler;
import com.kadir.model.Catagory;
import com.kadir.model.Product;

@Controller
public class PageController {

	@Autowired
	private CatagoryDAO catagorydao;
	@Autowired
	private ProductDAO productDAO;

	@RequestMapping(value = { "/", "/home", "/index" })
	public ModelAndView index() {
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

	@RequestMapping(value = "/show/catagory/{id}/products")
	public ModelAndView showCatagoryProductsById(@PathVariable("id") int id) {

		ModelAndView modelAndView = new ModelAndView("page");

		// catagoryDAO to fetch a single catagory

		Catagory catagory = catagorydao.getCatagoryById(id);

		modelAndView.addObject("title", catagory.getName());
		modelAndView.addObject("listCatagory", catagorydao.list());
		modelAndView.addObject("userClickCatagoryProducts", true);
		modelAndView.addObject("catagory", catagory);
		return modelAndView;
	}

	@RequestMapping("/show/{id}/product")
	public ModelAndView showProduct(@PathVariable int id) throws ProductExceptionHandler {

		ModelAndView modelAndView = new ModelAndView("page");

		Product product = productDAO.getProduct(id);

		if (product == null) {
			throw new ProductExceptionHandler();

		}

		// change the view's count of product
		product.setViews(product.getViews() + 1);
		productDAO.updateProduct(product);

		modelAndView.addObject("title", product.getName());
		modelAndView.addObject("product", product);
		modelAndView.addObject("userClickShowProduct", true);

		return modelAndView;
	}

	@RequestMapping("/register")
	public ModelAndView register() {

		ModelAndView model = new ModelAndView("page");

		model.addObject("title", "About Us");

		return model;
	}

	@RequestMapping("/login")
	public ModelAndView login(@RequestParam(name="error",required= false) String error,
			@RequestParam(name="logout",required= false) String logout) {

		ModelAndView model = new ModelAndView("login");

		if(error != null) {
			model.addObject("message", "Invalid Username and Password !");
		}
		
		if(logout != null) {
			model.addObject("logout", "User has successfully logged out!");
		}
		
		model.addObject("title", "Login");
		
		return model;
	}
	
	/* for access denied page*/
	@RequestMapping("/access-denied")
	public ModelAndView accessDenied() {

		ModelAndView model = new ModelAndView("error");
		model.addObject("pageNumber403",true);
		model.addObject("title","403- Access Denied");
		model.addObject("message", "you are not authorized");
		return model;
	}
	
	@RequestMapping("/logout")
	public String logoutHandler(HttpServletRequest request ,HttpServletResponse response) {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if(authentication != null) {
			new SecurityContextLogoutHandler().logout(request, response, authentication);
		}
		
		return "redirect:/login?logout";
	}
}
