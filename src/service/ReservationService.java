package service;

import model.Customer;
import model.IRoom;
import model.Reservation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;

public class ReservationService {
    //Initialize singleton pattern to achieve static reference
    private static ReservationService reservationService = null;

    private ReservationService(){}

    public static ReservationService getInstance() {
        if (reservationService == null)
            reservationService = new ReservationService();
        return reservationService;
    }
    public Collection<IRoom> rooms = new ArrayList<>();
    //Adding rooms using ArrayList
    public void addRoom(IRoom room){
        rooms.add(room);
        System.out.println(rooms);
    }

    public IRoom getARoom(String roomNumber){
        for(IRoom room: rooms){
            if(rooms.contains(roomNumber)){
                return room;
            }
        }
        return null;
    }
    //method to list all rooms. This method is added to be used on Admin Resource class
    public Collection getAllRooms(){
        for(IRoom room: rooms);
        return rooms;
    }
    public Collection<Reservation> reservations = new HashSet<>();
    public Reservation reserveARoom(Customer customer, IRoom room, Date checkInDate, Date checkOutDate){
        Reservation reserveRoom = new Reservation(customer, room, checkInDate, checkOutDate);
        if(!reservations.contains(reserveRoom)){
            reservations.add(reserveRoom);
            return reserveRoom;
        }
        return null;
    }
    //The logic is to find rooms based on check-in date and check-out date.
    //If my check in date comes after your checkout date, rooms is available,or the reverse is the case
    public Collection<IRoom> findRooms(Date checkInDate, Date checkOutDate){
        for (IRoom room : rooms) {
            if(checkInDate.after(checkInDate) && checkOutDate.before(checkOutDate)){
                return rooms;
            }
        }
        return null;
    }
    //Method to get all customers reservations
    public Collection<Reservation> getCustomersReservation(Customer customer){
        for (Reservation custReservation : reservations) {
            if (customer == custReservation.getCustomer()) {
                return reservations;
            }
        }
        return null;
    }
    //print all reservations
    public void printAllReservations(){
        for(Reservation reservation: reservations){
            System.out.println(reservations);
        }
    }
}
