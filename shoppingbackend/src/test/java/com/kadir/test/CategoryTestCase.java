package com.kadir.test;

import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.kadir.config.HibernateConfig;
import com.kadir.dao.CatagoryDAO;

public class CategoryTestCase {

	private static AnnotationConfigApplicationContext context;
	
	private static CatagoryDAO catagoryDAO;
	
	//private Catagory catagory4;
	
	@BeforeClass
	public static void init() {
		
		context= new AnnotationConfigApplicationContext(HibernateConfig.class);
		context.scan("com.kadir");
		catagoryDAO = context.getBean("catagoryDAO",CatagoryDAO.class);
	}
	/*@Test
	public void testAddCategory() {
		
		catagory4= new Catagory();
		catagory4.setName("Mobile");
		catagory4.setDescription("Apple");
		catagory4.setImageURL("CAT_tel_5");
		//catagory4.setActive(true);
		
		assertEquals("Successfully added a category to table ","true",catagoryDAO.addCategory(catagory4));
	}*/
	/*@Test
	public void testGetCategory() {
		
		catagory4 = catagoryDAO.getCatagoryById(7);
		
		assertEquals("Successfully getting a category from table", "Sony",catagory4.getDescription());
		
		System.out.println(catagory4);
	}*/
	
	/*@Test
	public void testUpdateCategory() {
		
		catagory4 = catagoryDAO.getCatagoryById(9);
		
		catagory4.setName("TV");
		
		assertEquals("Successfully update a category from table", true ,catagoryDAO.updateCategory(catagory4));
		
		System.out.println(catagory4);
	}*/
	
	/*@Test
	public void testDeleteCategory() {
		
		catagory4 = catagoryDAO.getCatagoryById(5);
		
		assertEquals("Successfully deleting a category from  table", true ,catagoryDAO.deleteCategory(catagory4));
		
		System.out.println(catagory4);
	}*/
	
	@Test
	public void testListCategory() {
		
		
		assertEquals("Successfully fetching the list of category from  table",5,catagoryDAO.list().size());
		 
		//System.out.println(catagory4);
	}
}
