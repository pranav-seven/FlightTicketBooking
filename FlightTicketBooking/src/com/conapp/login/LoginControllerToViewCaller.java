package com.conapp.login;

import com.conapp.dto.User;

public interface LoginControllerToViewCaller {
	void signupSuccessful();
	void loginSuccess(User user);
	void loginFailure();
}
