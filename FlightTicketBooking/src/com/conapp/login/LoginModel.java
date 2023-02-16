package com.conapp.login;

import com.conapp.repository.AeroplaneRepository;
import com.conapp.dto.*;
import java.util.List;

public class LoginModel implements LoginControllerToModelCaller {
	private LoginModelToControllerCaller loginController;
	private AeroplaneRepository repo;
	private User user;

	LoginModel(LoginController controller)
	{
		loginController = controller;
		repo = AeroplaneRepository.getInstance();
	}

	public void checkCredentials(String username, String password)
	{
		List<User> users = repo.getUsers();
		boolean isValid = false;
		for(User user : users)
			if(user.getUsername().equals(username) && user.getPassword().equals(password))
			{
				this.user = user;
				isValid = true;
				break;
			}
		if(isValid)
			loginController.loginSuccess(user);
		else
			loginController.loginFailure();
	}
}
