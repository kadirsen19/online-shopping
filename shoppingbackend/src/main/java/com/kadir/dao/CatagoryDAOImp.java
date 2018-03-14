package com.kadir.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.kadir.model.Catagory;

@Repository
public class CatagoryDAOImp implements CatagoryDAO {

	 
	
	static List<Catagory> catagoryList = new ArrayList<>();
	
	static {
		Catagory catagory = new Catagory();
		
		catagory.setId(1);
		catagory.setName("Mobile");
		catagory.setDescription("Iphone 6s");
		catagory.setImageURL("CAT_phone_6");
		
	
		Catagory catagory2 = new Catagory();
		catagory2.setId(2);
		catagory2.setName("Television");
		catagory2.setDescription("Samsung");
		catagory2.setImageURL("CAT_tel_6");
		
		
		Catagory catagory3 = new Catagory();
		
		catagory3.setId(3);
		catagory3.setName("Laptop");
		catagory3.setDescription("Asus");
		catagory3.setImageURL("CAT_laptop_6");
		
		catagoryList.add(catagory);
		catagoryList.add(catagory2);
		catagoryList.add(catagory3);
	}
	
	@Override
	public List<Catagory> list() {
		
		return catagoryList;
	}

	@Override
	public Catagory getCatagoryById(int id) {
		for(Catagory catagory : catagoryList)
		{
			if(catagory.getId()==id)
				return catagory;
		}
		return null;
	}
	
}
