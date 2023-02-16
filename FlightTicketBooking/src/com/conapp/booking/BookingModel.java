package com.conapp.booking;

import java.util.List;
import com.conapp.dto.Flight;
import com.conapp.repository.AeroplaneRepository;

public class BookingModel implements BookingControllerToModelCaller{

    private boolean[][] seats;
    private AeroplaneRepository repo;

    private BookingModelToControllerCaller bookingController;

    BookingModel(BookingController controller)
    {
        bookingController = controller;
        repo = AeroplaneRepository.getInstance();
        seats = new boolean[9][6];
        for(int i=0; i<seats.length; i++)
            for(int j=0; j<seats[0].length; j++)
                seats[i][j]  = true;
    }

    public boolean[][] getSeats()
    {
        return seats;
    }

    public boolean getSeatAvailability(int row, int column)
    {
        if(row>=seats.length || column>=seats[0].length)
            return false;
        return seats[row][column];
    }

    public int bookSeat(int row, int column)
    {
        seats[row-1][column-1] = false;
        return row*10+column;
    }

    public Flight checkFlights(String source, String destination)
    {
        List<Flight> flightList = repo.getFlightList();
        for(Flight flight : flightList)
            if(flight.getSource().equals(source) && flight.getDestination().equals(destination))
                return flight;
        return null;
    }
}
