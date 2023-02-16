package com.conapp.login;

import com.conapp.dto.User;
public interface LoginModelToControllerCaller {
    public void loginSuccess(User user);
    public void loginFailure();
}
