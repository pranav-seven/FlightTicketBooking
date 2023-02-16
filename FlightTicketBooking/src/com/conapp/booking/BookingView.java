package com.conapp.booking;

import java.util.Scanner;
import com.conapp.dto.User;
import com.conapp.dto.Flight;

public class BookingView implements BookingControllerToViewCaller{

    private BookingViewToControllerCaller bookingController;
    private User user;
    
    public BookingView(User user)
    {
        bookingController = new BookingController(this);
        this.user = user;
        openBooking();
    }

    // public static void main(String[] args) {
    //     BookingView bookingView = new BookingView();
    //     bookingView.openBooking();
    // }

    private void openBooking()
    {
        Scanner sc = new Scanner(System.in);
        char choice = 'Y';
        do{
            printSeats(bookingController.getSeats());
            System.out.print("Enter boarding point: ");
            String source = sc.nextLine();
            System.out.print("Enter destination: ");
            String destination = sc.nextLine();
            Flight flight = bookingController.checkFlights(source, destination);
            if(flight!=null)
            {
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
        sc.close();
        System.out.println("Thank you for using our site!");
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
}
