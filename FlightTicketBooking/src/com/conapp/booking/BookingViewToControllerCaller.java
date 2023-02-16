package com.conapp.booking;

import java.util.List;
import com.conapp.dto.User;
import com.conapp.dto.Bookings;

public interface BookingViewToControllerCaller {
    boolean[][] getSeats();
    boolean checkAvailability(int row, int column);
    void bookSeat(int row, int column);
    boolean checkFlights(String source, String destination);

    public List<Bookings> getBookings(User user);
}
