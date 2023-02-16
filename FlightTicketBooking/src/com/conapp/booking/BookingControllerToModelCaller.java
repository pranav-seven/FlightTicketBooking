package com.conapp.booking;

import com.conapp.dto.User;
import java.util.List;
import com.conapp.dto.Bookings;

public interface BookingControllerToModelCaller {
    boolean[][] getSeats();
    boolean getSeatAvailability(int row, int column);
    void bookSeat(User user, int row, int column);
    boolean checkFlights(String src, String dst);
    public List<Bookings> getBookings(User user);
}
