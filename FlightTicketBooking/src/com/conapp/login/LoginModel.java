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

	public boolean checkUsername(String username)
	{
		List<User> list = repo.getUsers();
		for(User user : list)
		{
			if(user.getUsername().equals(username))
				return false;
		}
		return true;
	}

    public void addUser(String name, String username, String password)
	{
		repo.getUsers().add(new User(name, username, password));
		loginController.signupSuccessful();
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
