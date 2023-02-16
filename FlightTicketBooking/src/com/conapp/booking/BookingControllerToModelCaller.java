package com.conapp.booking;

import com.conapp.dto.Flight;

public interface BookingControllerToModelCaller {
    boolean[][] getSeats();
    boolean getSeatAvailability(int row, int column);
    int bookSeat(int row, int column);
    Flight checkFlights(String src, String dst);
}
