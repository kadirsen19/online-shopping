package com.kadir.dao;

import java.util.List;

import com.kadir.model.Catagory;

public interface CatagoryDAO {

	
	
	public List<Catagory> list();

	public Catagory getCatagoryById(int id);
	
	public boolean addCategory(Catagory catagory);
	public boolean updateCategory(Catagory catagory);
	public boolean deleteCategory(Catagory catagory);
	
}
