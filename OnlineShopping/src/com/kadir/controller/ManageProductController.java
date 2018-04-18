package com.kadir.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.kadir.dao.CatagoryDAO;
import com.kadir.dao.ProductDAO;
import com.kadir.model.Catagory;
import com.kadir.model.Product;
import com.kadir.util.FileUploadUtility;
import com.kadir.validator.ProductValidator;

@Controller
@RequestMapping("/manage")
public class ManageProductController {

	
	@Autowired
	private CatagoryDAO categoryDAO;
	
	@Autowired
	private ProductDAO productDAO;
	
	/* fill the Form with product */
	@RequestMapping(value="/manageProduct",method=RequestMethod.GET)
	public ModelAndView manageProduct(@RequestParam(name="operation",required=false) String operation) {
		
		ModelAndView modelAndView = new ModelAndView("page");
		
		modelAndView.addObject("userClickManageProduct", true);
		
		modelAndView.addObject("title", "Manage Product");
		
		modelAndView.addObject("newProduct", true);
		
		Product product = new Product();
		
		product.setSupplierId(1);
		product.setActive(true);
		
		modelAndView.addObject("product", product);
		
		if(operation != null) {
			if(operation.equals("product")) {
				modelAndView.addObject("message", "Product Successfully Saved");
			}
			else if(operation.equals("category")) {
				modelAndView.addObject("message", "Category Successfully Saved");
			}
		}
		
		return modelAndView;
	}
	/*Change the product status*/
	@RequestMapping(value="/product/{id}/activation",method=RequestMethod.POST)
	@ResponseBody
	public String changeProductActivation(@PathVariable int id) {
		//fetch product from dataBase 
		Product product= productDAO.getProduct(id);
		
		boolean isActive=product.isActive();
		
		/*Product  status changed*/
		product.setActive(!product.isActive());
		
		productDAO.updateProduct(product);
		
		if(isActive) {
			return "You have successfully deactivated the product with id :"+" "+product.getId();
		}
		else {
			return "You have successfully activated the product with id :"+" "+product.getId();
		}
	}
	
	@ModelAttribute("categories")
	public List<Catagory> listCategory(){
		
		return categoryDAO.list();
		
	}
	/*Save a new product*/
	@RequestMapping(value="/saveProduct", method=RequestMethod.POST)
	public String  addProduct(@Valid @ModelAttribute("product") Product product ,BindingResult result,Model model,HttpServletRequest request ) {
		if(product.getId()==0) {
			new ProductValidator().validate(product, result);
		}
		else {
			if(!product.getFile().getOriginalFilename().equals("")) {
				
				FileUploadUtility.uploadFile(request,product.getFile(),product.getCode());
			}
		}
		
		if(result.hasErrors()) {
			model.addAttribute("userClickManageProduct", true);
			model.addAttribute("title", "Manage Product");
			model.addAttribute("message", "Validation failed for Product");
			model.addAttribute("newProduct", true);
			return "page";
		}
		
		if(product.getId()== 0) {
			//create new product
			productDAO.addProduct(product);
		}
		else {
			//update the product ,if is exist
			productDAO.updateProduct(product);
			
		}
		
		if(!product.getFile().getOriginalFilename().equals("")) {
			
			FileUploadUtility.uploadFile(request,product.getFile(),product.getCode());
		}
		
		return "redirect:/manage/manageProduct?operation=product";
		
	}
	/*Editing the product*/
	@RequestMapping(value="/{id}/product",method=RequestMethod.GET)
	public ModelAndView editProduct(@PathVariable int id) {
		
		ModelAndView modelAndView = new ModelAndView("page");
		
		modelAndView.addObject("userClickManageProduct", true);
		
		modelAndView.addObject("title", "Manage Product");
		
		modelAndView.addObject("editProduct", true);
		
		modelAndView.addObject("product", productDAO.getProduct(id));
		
		return modelAndView;
	}
	
	@ModelAttribute("category")
	public Catagory getCategory() {
		return new Catagory();
	}
	
	@RequestMapping(value="/category" ,method=RequestMethod.POST)
	public String  addCategory(@ModelAttribute("category")Catagory category) {
		
		categoryDAO.addCategory(category);
		
		return "redirect:/manage/manageProduct?operation=category";
		
	}
		
	
	
}
