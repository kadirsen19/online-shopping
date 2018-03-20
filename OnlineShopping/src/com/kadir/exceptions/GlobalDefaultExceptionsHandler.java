package com.kadir.exceptions;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalDefaultExceptionsHandler {


	@ExceptionHandler(NoHandlerFoundException.class)
	public ModelAndView noHandlerFoundException() {
		ModelAndView modelAndView = new ModelAndView("error");
		
		modelAndView.addObject("errorTitle", "The page not found");
		
		modelAndView.addObject("errorTitle", "Page is not available !");
		
		modelAndView.addObject("title","404 Error Page");
		
		return modelAndView;
	}
}
