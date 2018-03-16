package com.kadir.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.kadir.model.Catagory;

@Repository("catagoryDAO")
@Transactional
public class CatagoryDAOImp implements CatagoryDAO {

	@Autowired
	public SessionFactory sessionFactory;

	public static List<Catagory> catagoryList = new ArrayList<>();

	/*
	 * static { Catagory catagory = new Catagory();
	 * 
	 * catagory.setId(1); catagory.setName("Mobile");
	 * catagory.setDescription("Iphone 6s"); catagory.setImageURL("CAT_phone_6");
	 * 
	 * 
	 * 
	 * Catagory catagory2 = new Catagory(); catagory2.setId(2);
	 * catagory2.setName("Television"); catagory2.setDescription("Samsung");
	 * catagory2.setImageURL("CAT_tel_6");
	 * 
	 * 
	 * Catagory catagory3 = new Catagory();
	 * 
	 * catagory3.setId(3); catagory3.setName("Laptop");
	 * catagory3.setDescription("Asus"); catagory3.setImageURL("CAT_laptop_6");
	 * 
	 * catagoryList.add(catagory); catagoryList.add(catagory2);
	 * catagoryList.add(catagory3); }
	 */

	@Override
	public List<Catagory> list() {

		String selectActiveCategries = "From Catagory WHERE active =:active";

		TypedQuery<Catagory> query = sessionFactory.getCurrentSession().createQuery(selectActiveCategries,
				Catagory.class);

		query.setParameter("active", true);

		for (Catagory catagory : query.getResultList()) {
			System.out.println(catagory);
		}

		return query.getResultList();
		
	}

	@Override
	public Catagory getCatagoryById(int id) {

		return sessionFactory.getCurrentSession().get(Catagory.class, Integer.valueOf(id));
	}

	@Override
	public boolean addCategory(Catagory catagory) {

		try {
			sessionFactory.getCurrentSession().persist(catagory);
			return true;

		} catch (Exception e) {
			System.out.println("Eror adding while category" + e);
			return false;
		}
	}

	@Override
	public boolean updateCategory(Catagory catagory) {

		try {
			sessionFactory.getCurrentSession().update(catagory);
			return true;

		} catch (Exception e) {
			System.out.println("Eror adding while category" + e);
			return false;
		}
	}

	@Override
	public boolean deleteCategory(Catagory catagory) {
		catagory.setActive(false);

		try {
			sessionFactory.getCurrentSession().update(catagory);
			return true;

		} catch (Exception e) {
			System.out.println("Eror adding while category" + e);
			return false;
		}
	}

}
