package com.kadir.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kadir.dao.CartLineDAO;
import com.kadir.dao.ProductDAO;
import com.kadir.model.Cart;
import com.kadir.model.CartLine;
import com.kadir.model.Product;
import com.kadir.model.User;
import com.kadir.registerModel.UserModel;
import com.kadir.service.CartService;

@Controller
@RequestMapping("/cart")
public class CartController {

	@Autowired
	private CartService cartService;
	
	@Autowired
	private HttpSession httpSession;
	
	
	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private CartLineDAO cartLineDAO;
	
	@RequestMapping("/show")
	public ModelAndView showCart(@RequestParam(name="result",required=false)String result) {
		
		ModelAndView modelAndView = new ModelAndView("page");
		
		if(result != null) {
			switch (result) 
			{
			case "updated":
				modelAndView.addObject("message", "CartLine updated successfully!");
				break;
			case "delete":
				modelAndView.addObject("message", "CartLine removed successfully!");
				break;
			/*case "added":
				modelAndView.addObject("message", "Product added successfully!");
				break;*/
			case "error":
				modelAndView.addObject("message", "Something went wrong!");
				break;
			}
		}
		modelAndView.addObject("title","User Cart");
		modelAndView.addObject("userClickShowCart",true);
		modelAndView.addObject("cartLines",cartService.getCartLines());
		return modelAndView;
	}
	@RequestMapping("/{cartLineId}/update")
	public String updateCart(@PathVariable int cartLineId , @RequestParam int count) {
		
		String response= cartService.updateCartLine(cartLineId,count);
		
		
		return "redirect:/cart/show?"+response;
	}
	
	@RequestMapping("/{cartLineId}/delete")
	public String updateCart(@PathVariable int cartLineId) {
		
		String response= cartService.deleteCartLine(cartLineId);
		
		
		return "redirect:/cart/show?"+response;
	}
	
	/*@RequestMapping("/add/{productId}/product")
	public String addCartLine(@PathVariable int productId) {
		
		Note :--->this method is not wroking :(
		
		String response = cartService.addProduct(productId);
		
		return "redirect:/cart/show?"+response;
	}*/
	
	@RequestMapping("/add/{id}/product")
	public ModelAndView addCartLine(@PathVariable int id) {
		
		ModelAndView modelAndView = new ModelAndView("page");
		
		UserModel user =  (UserModel)httpSession.getAttribute("userModel");
		//2.fetch the cart
		Cart cart =user.getCart();
		//3.get the product
		Product product= productDAO.getProduct(id);
		//4.create a new cartLine
		CartLine cartLine = new CartLine();
		
		cartLine.setBuyingPrice(product.getUnitPrice());
		cartLine.setProductCount(cartLine.getProductCount()+1);
		cartLine.setTotal(cartLine.getProductCount()* product.getUnitPrice());
		cartLine.setAvailable(true);
		cartLine.setCartId(cart.getId());
		cartLine.setProduct(product);
		cartLineDAO.addCartLine(cartLine);
		
		//update the cart
		cart.setGrandTotal(cart.getGrandTotal()+ cartLine.getTotal());
		cart.setCartLines(cart.getCartLines()+1);
		
		cartLineDAO.updateCart(cart);
		
		modelAndView.addObject("title","User Cart");
		modelAndView.addObject("userClickShowCart",true);
		modelAndView.addObject("cartLines",cartService.getCartLines());
		return modelAndView;
		
	}
	
}
