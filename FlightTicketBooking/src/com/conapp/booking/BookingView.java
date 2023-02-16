package com.conapp.booking;

import java.util.Scanner;
import java.util.List;
import com.conapp.dto.User;
import com.conapp.dto.Bookings;

public class BookingView implements BookingControllerToViewCaller{

    private BookingViewToControllerCaller bookingController;
    private User user;
    Scanner sc;
    
    public BookingView(User user, Scanner sc)
    {
        this.user = user;
        this.sc = sc;
        bookingController = new BookingController(this);
        start();
    }

    void start()
    {
        
        byte choice = 0;
        do{
            System.out.println("Enter ");
            System.out.println("1 - Book flight");
            System.out.println("2 - View bookings");
            System.out.println("0 - Log out");
            choice = sc.nextByte();
            switch(choice)
            {
                case 1: openBooking();
                        break;
                case 2: viewBookings();
                        break;
                case 0: break;
                default: System.out.println("Invalid choice, try again.");
            }
        }while(choice!=0);
    }

    private void openBooking()
    {
        char choice = 'Y';
        do{
            System.out.print("Enter boarding point: ");
            String source = sc.next();
            System.out.print("Enter destination: ");
            String destination = sc.next();
            if(bookingController.checkFlights(source, destination))
            {
                printSeats(bookingController.getSeats());
                System.out.println("Enter row and column: ");
                int row = sc.nextInt();
                int column = sc.nextInt();
                if(bookingController.checkAvailability(row-1, column-1))
                {
                    System.out.print("Confirm booking? (Y/N): ");
                    char confirmation = sc.next().charAt(0);
                    if(confirmation == 'Y')
                    {
                        bookingController.bookSeat(row, column);
                        System.out.println("Seat Confirmed!");
                        System.out.print("Want to book again? (Y/N): ");
                    }
                    else
                        System.out.print("Want to continue? (Y/N): ");
                }
                else
                {
                    System.out.println("Seat unavailable");
                    System.out.print("Want to continue? (Y/N): ");
                }
            }
            else{
                System.out.println("Flight unavailable");
                System.out.print("Want to continue? (Y/N): ");
            }
            choice = sc.next().charAt(0);
        }while(choice=='Y');
    }

    private void viewBookings()
    {
        List<Bookings> list = bookingController.getBookings(user);
        System.out.println("Flight no.\tDeparture\tArrival\t\tSeat no.");
        for(Bookings booking : list)
            System.out.println(booking);
    }

    private void printSeats(boolean[][] seats)
    {
        
        System.out.print("  ");
        for(int i=0; i<seats[0].length; i++)
        {
            System.out.print(" "+(i+1)+" ");
            if(i==2)
                System.out.print("  ");
        }
        System.out.println();
        for(int i=0; i<seats.length; i++)
        {
            System.out.print(i+1+" ");
            for(int j=0; j<seats[0].length; j++)
            {
                if(seats[i][j])
                    System.out.print(" O ");
                else
                    System.out.print(" x ");
                if(j==2)
                    System.out.print("  ");
            }
            System.out.println();
        }
        System.out.println("\nO - available\nx - booked");
    }

    public User getUser()
    {
        return user;
    }
}
