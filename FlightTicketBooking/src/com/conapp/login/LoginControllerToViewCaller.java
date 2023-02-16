package com.conapp.login;

import com.conapp.dto.User;

public interface LoginControllerToViewCaller {
	void loginSuccess(User user);
	void loginFailure();
}
