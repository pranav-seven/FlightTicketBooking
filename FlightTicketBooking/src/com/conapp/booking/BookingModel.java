package com.conapp.booking;

import java.util.List;
import com.conapp.dto.User;
import com.conapp.dto.Flight;
import com.conapp.dto.Bookings;
import com.conapp.repository.AeroplaneRepository;

public class BookingModel implements BookingControllerToModelCaller{

    private boolean[][] seats;
    private AeroplaneRepository repo;
    private Flight flight;

    private BookingModelToControllerCaller bookingController;

    BookingModel(BookingController controller)
    {
        bookingController = controller;
        repo = AeroplaneRepository.getInstance();
    }

    public boolean checkFlights(String source, String destination)
    {
        flight = null;
        List<Flight> flightList = repo.getFlightList();
        for(Flight flight : flightList)
            if(flight.getSource().equals(source) && flight.getDestination().equals(destination))
                this.flight = flight;
        return flight==null?false:true;
    }

    public boolean[][] getSeats()
    {
        seats = flight.getSeats();
        return seats;
    }

    public boolean getSeatAvailability(int row, int column)
    {
        if(row>=seats.length || column>=seats[0].length || row<0 || column<0)
            return false;
        return seats[row][column];
    }

    public void bookSeat(User user, int row, int column)
    {
        int seat = row*10+column;
        List<Bookings> bookingList = user.getBookings();
        bookingList.add(new Bookings(user, flight, seat));
        seats[row-1][column-1] = false;
        String message = "Seat confirmed!\n";
        message = message + "Flight no.\tDeparture\tArrival\t\tSeat no.\n";
        message = message + flight.getNumber()+"\t"+flight.getSource()+"\t"+flight.getDestination()+"\t"+seat;
        bookingController.sendMessage("Seat confirmed!");
    }

    public void cancelBooking(User user, int booking)
    {
        Bookings current = user.getBookings().get(booking-1);
        flight = current.getFlight();
        int seat = current.getSeat();
        seats = flight.getSeats();
        seats[seat/10-1][seat%10-1] = true;
        user.getBookings().remove(booking-1);
        bookingController.sendMessage("Booking cancelled!");

    }

    public List<Bookings> getBookings(User user)
    {
        return user.getBookings();
    }
}
