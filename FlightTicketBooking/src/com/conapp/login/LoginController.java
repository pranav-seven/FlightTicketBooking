package com.conapp.login;

import com.conapp.dto.User;

public class LoginController implements LoginViewToControllerCaller, LoginModelToControllerCaller {
	private LoginControllerToViewCaller loginView;
	private LoginControllerToModelCaller loginModel;
	
	LoginController(LoginView view)
	{
		loginView = view;
		loginModel = new LoginModel(this);
	}
	
	// public boolean checkLoginDetails(String username, String password)
	// {
	// 	boolean validLogin = false;
	// 	if(username.equals("traveller") && password.equals("Bon Voyage"))
	// 		validLogin = true;
	// 	return validLogin;
	// }

	public void checkLoginDetailsOnline(String username, String password)
	{
		loginModel.checkCredentials(username, password);
	}

	public void loginSuccess(User user)
	{
		loginView.loginSuccess(user);
	}

	public void loginFailure()
	{
		loginView.loginFailure();
	}
}
