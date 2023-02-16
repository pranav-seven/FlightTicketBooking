package com.conapp.login;

import java.util.Scanner;
import com.conapp.booking.BookingView;
import com.conapp.dto.User;

public class LoginView implements LoginControllerToViewCaller {
    private String username;
    private String password;
    
    private LoginViewToControllerCaller loginController;

    LoginView()
    {
        System.out.println("DECCAN AIR");
        loginController = new LoginController(this);
    }

    public static void main(String[] args)
    {
        LoginView loginView = new LoginView();
        loginView.login();
    }
    

    private void login()
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Username: ");
        username = sc.nextLine();
        System.out.print("Password: ");
        password = sc.nextLine();
        loginController.checkLoginDetailsOnline(username, password);
        sc.close();
    }

    public void loginSuccess(User user)
    {
            System.out.println("--- Welcome "+user.getName()+" ---");
            new BookingView(user);
    }


    public void loginFailure()
    {
        System.out.println("Username or password invalid!\nTry again");
        login();
    }
}