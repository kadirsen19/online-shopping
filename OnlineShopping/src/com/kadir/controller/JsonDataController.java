package com.kadir.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kadir.dao.ProductDAO;
import com.kadir.model.Product;

@Controller
@RequestMapping("/json/data")
public class JsonDataController {

	
	@Autowired
	private ProductDAO productDAO;
	
	@RequestMapping("/all/products")
	@ResponseBody
	public List<Product> getAllProduct(){
		
		return productDAO.activeProductList();
		
	}
	
	@RequestMapping("/category/{id}/product")
	@ResponseBody
	public List<Product> getAllProductByCategryId(@PathVariable int id){
		
		return productDAO.activeProductsByCatagoryList(id);
		
	}
}
