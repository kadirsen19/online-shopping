package com.kadir.dao;

import java.util.List;

import com.kadir.model.Catagory;

public interface CatagoryDAO {

	
	public List<Catagory> list();

	public Catagory getCatagoryById(int id);
	
}
