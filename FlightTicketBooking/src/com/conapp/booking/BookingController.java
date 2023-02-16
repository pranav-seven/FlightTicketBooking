package com.conapp.booking;

import com.conapp.dto.Flight;

public class BookingController implements BookingViewToControllerCaller, BookingModelToControllerCaller{

    private BookingControllerToViewCaller bookingView;
    private BookingControllerToModelCaller bookingModel;

    BookingController(BookingView view)
    {
        bookingView = view;
        bookingModel = new BookingModel(this);
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
        int seat = bookingModel.bookSeat(row, column)
        bookingView.user.
    }

    public Flight checkFlights(String source, String destination)
    {
        return bookingModel.checkFlights(source, destination);
    }
}
