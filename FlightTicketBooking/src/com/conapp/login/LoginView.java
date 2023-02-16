package com.conapp.login;

import java.util.Scanner;
import com.conapp.booking.BookingView;
import com.conapp.dto.User;

public class LoginView implements LoginControllerToViewCaller {
    private String name;
    private String username;
    private String password;
    private LoginViewToControllerCaller loginController;
    public static Scanner sc;

    LoginView()
    {
        System.out.println("==>== DECCAN AIR ==<==");
        sc = new Scanner(System.in);
        loginController = new LoginController(this);
    }

    public static void main(String[] args)
    {
        LoginView loginView = new LoginView();
        loginView.start();
    }
    
    private void start()
    {
        byte choice = 0;
        do{
            System.out.println("Enter ");
            System.out.println("1 - Login");
            System.out.println("2 - sign up");
            System.out.println("0 - exit");
            choice = sc.nextByte();
            switch(choice)
            {
                case 1: login();
                        break;
                case 2: signup();
                        break;
                case 0: System.out.println("Thanks for using our site!");
                        break;
                default: System.out.println("Invalid choice, try again.");
            }
        }while(choice!=0);
    }

    private void signup()
    {
        System.out.println("Give an username: ");
        username = sc.next();
        if(loginController.checkUsername(username))
        {
            System.out.println("Name: ");
            name = sc.next();
            do{
                System.out.println("Enter password: ");
                password = sc.next();
                System.out.println("Re-enter password: ");
                if(sc.next().equals(password))
                {
                    loginController.addUser(name, username, password);
                    break;
                }
                else
                    System.out.println("Passwords do not match");
            }while(true);
        }
        else
            System.out.println("Username already exists.");
    }

    public void signupSuccessful()
    {
        System.out.println("Added successfully!");
    }

    private void login()
    {
        System.out.print("Username: ");
        username = sc.next();
        System.out.print("Password: ");
        password = sc.next();
        loginController.checkLoginDetailsOnline(username, password);
    }

    public void loginSuccess(User user)
    {
            System.out.println("--- Welcome "+user.getName()+" ---");
            new BookingView(user, sc);
    }


    public void loginFailure()
    {
        System.out.println("Username or password invalid!\nTry again");
        login();
    }
}