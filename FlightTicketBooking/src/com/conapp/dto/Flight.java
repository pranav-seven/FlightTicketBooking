package com.conapp.dto;

import java.util.Arrays;

public class Flight {
    private String number;
    private String source;
    private String destination;
    private int cost;
    private boolean[][] seats;

    public Flight(String num, String src, String dst, int row, int column, int cost)
    {
        number = num;
        source = src;
        destination = dst;
        this.cost = cost;
        seats = new boolean[row][column];
        for(int i=0; i<row; i++)
            Arrays.fill(seats[i], true);
    }

    
    public void setNumber(String number)
    {
        this.number = number;
    }
    public String getNumber()
    {
        return number;
    }
    
    public void setSource(String src)
    {
        source = src;
    }
    public String getSource()
    {
        return source;
    }
    public void setDestination(String dst)
    {
        destination = dst;
    }
    public String getDestination()
    {
        return  destination;
    }
    public void changeSeatState(int row, int column)
    {
        seats[row][column] = !seats[row][column];
    }
    public boolean[][] getSeats()
    {
        return seats;
    }
    public boolean getSeatState(int row, int column)
    {
        return seats[row][column];
    }
}
