package com.conapp.login;

public interface LoginViewToControllerCaller {
    void checkLoginDetailsOnline(String username, String password);
    boolean checkUsername(String username);
    void addUser(String name, String username, String password);
    boolean checkNewPassword(String password, String rePassword);
}
