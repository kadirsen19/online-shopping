package com.kadir.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.kadir.model.Cart;
import com.kadir.model.CartLine;

@Repository("cartLineDAO")
@Transactional
public class CartLineDAOImp implements CartLineDAO {


	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public CartLine getCartLineById(int id) {
		
		 return sessionFactory.getCurrentSession().get(CartLine.class, Integer.valueOf(id));
	}

	@Override
	public boolean addCartLine(CartLine cartLine) {
		
		try {
			
			sessionFactory.getCurrentSession().persist(cartLine);
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		
	}

	@Override
	public boolean updateCartLine(CartLine cartLine) {
		
		try {
			
			sessionFactory.getCurrentSession().update(cartLine);
			return true;
			
		} catch (Exception e) {
		
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public boolean deleteCartLine(CartLine cartLine) {
		
		try {
			sessionFactory.getCurrentSession().delete(cartLine);
			return true;
		} catch (Exception e) {

			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public List<CartLine> listCartLine(int cartId) {
		String query="FROM CartLine WHERE cartId =:cartId";
		
		return sessionFactory.getCurrentSession().createQuery(query, CartLine.class)
												 .setParameter("cartId", cartId)
												 .getResultList();
	}

	@Override
	public List<CartLine> listAvailable(int cartId) {
		
		String query="FROM CartLine WHERE cartId =:cartId AND available =:available";
		
		return sessionFactory.getCurrentSession().createQuery(query, CartLine.class)
													.setParameter("cartId", cartId)
													.setParameter("available", true)
													.getResultList();
	}

	@Override
	public CartLine getByCartAndProduct(int cartId, int productId) {
		String query="FROM CartLine WHERE cartId =:cartId AND product.id =:productId";
		
		try {
			
			return sessionFactory.getCurrentSession().createQuery(query, CartLine.class)
													.setParameter("cartId", cartId)
													.setParameter("productId", productId)
													.getSingleResult();
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	//related to cart
	@Override
	public boolean updateCart(Cart cart) {
		try {
			sessionFactory.getCurrentSession().update(cart);
			return true;
			
		} catch (Exception e) {
			
			e.printStackTrace();
			return false;
		}
	}
	

}
