package com.conapp.dto;

public class Bookings {
    User user;
    Flight flight;
    int seatNo;
    Bookings(User user, Flight flight, int seat)
    {
        this.user = user;
        this.flight = flight;
        seatNo = seat;
    }
}
