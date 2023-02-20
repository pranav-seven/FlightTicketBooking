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

	public boolean checkUsername(String username)
	{
		return loginModel.checkUsername(username);
	}

    public void addUser(String name, String username, String password)
	{
		loginModel.addUser(name, username, password);
	}

	public void signupSuccessful()
	{
		loginView.signupSuccessful();
	}

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

	public boolean checkNewPassword(String password, String rePassword)
	{
		return password.equalsIgnoreCase(rePassword);
	}
}
