package com.kadir.util;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

public class FileUploadUtility {

	private static final String ABS_PATH = "E:\\SpringMvcOnlineShopping\\online-shopping\\OnlineShopping\\WebContent\\resources\\images\\";
	private static String REAL_PATH = "";

	public static void uploadFile(HttpServletRequest request, MultipartFile file, String code) {

		// get real path
		REAL_PATH = request.getSession().getServletContext().getRealPath("/resources/images/");

		// check the all directory exists
		// create directory
		if (!new File(ABS_PATH).exists()) {

			new File(ABS_PATH).mkdirs();
		}
		if (!new File(REAL_PATH).exists()) {

			new File(REAL_PATH).mkdirs();
		}
		
		try {
			//server upload
			file.transferTo(new File(REAL_PATH + code +".jpg"));
			//project directory upload 
			file.transferTo(new File(ABS_PATH  + code + ".jpg"));
			
		} catch (IOException e) {
			 
			
		}
	}

}
