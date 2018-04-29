package com.kadir.registerHandler;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.stereotype.Component;
import com.kadir.dao.UserDAO;
import com.kadir.model.Address;
import com.kadir.model.Cart;
import com.kadir.model.User;
import com.kadir.registerModel.RegisterModel;

@Component
public class RegisterHandler {

	@Autowired
	private UserDAO userDAO;
	
	public RegisterModel init() {
		return new RegisterModel();
	}
	
	public void addUser(RegisterModel registerModel,User user) {
		registerModel.setUser(user);
	}
	
	public void addBilling(RegisterModel registerModel,Address billing) {
		registerModel.setBilling(billing);
	}
	
	public String saveAll(RegisterModel model) {
		String transitionValue="success";
		
		//fetch the user
		User user = model.getUser();
		
		if(user.getRole().equals("USER")) {
			Cart cart = new Cart();
			cart.setUser(user);
			user.setCart(cart);
		}
		//save the user 
		userDAO.addUser(user);
		
		/*fetch the user */
		Address billing= model.getBilling();
		billing.setUser(user);
		billing.setBilling(true);
		
		//save the address
		userDAO.addAddress(billing);
		return transitionValue;
	}
	public String validateUser(User user, MessageContext  error	) {
		String transitionValue="success";
		 
		/*checking if password matches confirm password*/
		if(!(user.getPassword().equals(user.getConfirmPassword()))) {
			error.addMessage(new MessageBuilder()
					.error()
					.source("confirmPassword")
					.defaultText("Password does not match confirm password!")
					.build());
				transitionValue = "failure";
		 }
		/*checking the uniqueness of the email id*/
		
		
		
		if(userDAO.getUserByEmail(user.getEmail())!= null) {
			error.addMessage(new MessageBuilder()
					.error()
					.source("email")
					.defaultText("Email address is already taken!")
					.build());
				transitionValue = "failure";
		}
		return transitionValue;
	}
	
}
