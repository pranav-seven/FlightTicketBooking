package com.conapp.dto;

public class Bookings {
    User user;
    Flight flight;
    int seatNo;
    public Bookings(User user, Flight flight, int seat)
    {
        this.user = user;
        this.flight = flight;
        seatNo = seat;
    }
     public String toString()
     {
        return ""+flight.getNumber()+"\t\t"+flight.getSource()+"\t\t"
                        +flight.getDestination()+"\t\t"+seatNo;
     }

     public Flight getFlight()
     {
        return flight;
     }
      public int getSeat()
      {
        return seatNo;
      }
}
