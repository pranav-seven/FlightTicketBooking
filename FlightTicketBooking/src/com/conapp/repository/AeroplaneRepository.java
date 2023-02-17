package com.conapp.repository;

import java.util.List;
import java.util.ArrayList;
import com.conapp.dto.*;
public class AeroplaneRepository {
    private static AeroplaneRepository repoInstance;
    private List<Admin> adminList = new ArrayList<>();
    private List<User> userList = new ArrayList<>();
    private List<Flight> flightList = new ArrayList<>();

    private AeroplaneRepository()
    {
        adminList.add(new Admin("Nedumaaran", "maaran", "flightkuowner"));
        userList.add(new User("Vikram", "vikram", "aarambikalangala!"));
        userList.add(new User("Amar", "amar", "blacksquad"));
        userList.add(new User("Sandhanam", "drsandhanam", "methdoctor"));
        userList.add(new User("Thor, son of Odin", "thor", "pointbreak"));
        flightList.add(new Flight("C283D", "Chennai", "Delhi", 9, 5, 9000));
        flightList.add(new Flight("C757M", "Chennai", "Mumbai", 9, 6, 5500));
        flightList.add(new Flight("M837C", "Mumbai", "Chennai", 9, 6, 5500));
        flightList.add(new Flight("M737D", "Mumbai", "Delhi", 8, 5, 6500));
        flightList.add(new Flight("D412C", "Delhi", "Chennai", 9, 5, 9000));
        flightList.add(new Flight("D517M", "Delhi", "Mumbai", 8, 5, 6500));
    }
 
    public static AeroplaneRepository getInstance()
    {
        if(repoInstance==null)
            repoInstance = new AeroplaneRepository();
        return repoInstance;
    }

    public List<User> getUsers()
    {
        return userList;
    }

    public List<Flight> getFlightList()
    {
        return flightList;
    }

}
