package com.kadir.validator;

import org.springframework.validation.Errors;

import com.kadir.model.Product;

public class ProductValidator implements org.springframework.validation.Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		
		return Product.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Product product =(Product)target;
		if(product.getFile()== null ||
				product.getFile().getOriginalFilename().equals("")) {
			
			errors.rejectValue("file", null, "Please Select a image file");
			return ;
		}
		/*if(!(
				product.getFile().getContentType().equals("images/jpeg")||
				product.getFile().getContentType().equals("images/png")||
				product.getFile().getContentType().equals("images/gif")
				)) 
		{
				errors.rejectValue("file", null, "Please use only jpeg png and gif");
				return;
		}*/
	}
}
