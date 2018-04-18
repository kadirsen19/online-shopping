package com.kadir.exceptions;

import java.io.Serializable;

public class ProductExceptionHandler extends Exception implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String message;

	public ProductExceptionHandler() {
		this.message = System.currentTimeMillis()+ ":"+message;
	}

	public String getMessage() {
		return message;
	}
	
	

}
