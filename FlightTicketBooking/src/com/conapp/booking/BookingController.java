package com.conapp.booking;

import com.conapp.login.LoginModel;
import java.util.List;
import com.conapp.dto.User;
import com.conapp.dto.Bookings;


public class BookingController implements BookingViewToControllerCaller, BookingModelToControllerCaller{

    private BookingControllerToViewCaller bookingView;
    private BookingControllerToModelCaller bookingModel;

    BookingController(BookingView view)
    {
        bookingView = view;
        bookingModel = new BookingModel(this);
    }

    public boolean checkFlights(String source, String destination)
    {
        return bookingModel.checkFlights(source, destination);
    }

    public boolean[][] getSeats()
    {
        return bookingModel.getSeats();
    }

    public boolean checkAvailability(int row, int column)
    {
        return bookingModel.getSeatAvailability(row, column);
    }

    public void bookSeat(int row, int column)
    {
        bookingModel.bookSeat(bookingView.getUser(), row, column);
    }

    public List<Bookings> getBookings(User user)
    {
        return bookingModel.getBookings(user);
    }
}
