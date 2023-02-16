package com.conapp.booking;

import com.conapp.dto.Flight;
public interface BookingViewToControllerCaller {
    boolean[][] getSeats();
    boolean checkAvailability(int row, int column);
    void bookSeat(int row, int column);
    Flight checkFlights(String source, String destination);
}
