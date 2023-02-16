package com.conapp.login;

public interface LoginControllerToModelCaller {
    boolean checkUsername(String username);
    void addUser(String name, String username, String password);
	void checkCredentials(String username, String password);
}
