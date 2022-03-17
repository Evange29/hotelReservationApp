package api;

import model.Customer;
import model.IRoom;
import model.Reservation;
import service.CustomerService;
import service.ReservationService;

import java.util.Collection;
import java.util.Date;

public class HotelResource {
    private static CustomerService customerService = CustomerService.getInstance();
    private static ReservationService reservationService = ReservationService.getInstance();

    //Initialize singleton pattern to achieve static reference
    private static HotelResource hotelResource = null;

    //private constructor for the singleton class
    private HotelResource(){}

    //Adding the static instance reference
    public static HotelResource getInstance() {
        if (hotelResource == null)
            hotelResource = new HotelResource();
        return hotelResource;
    }
    //We shall be using the instance from service classes to implement the methods in resource classes.
    public Customer getCustomer(String email){
        return customerService.getCustomer(email);
    }

    public void createACustomer(String email, String firstName, String lastName){
        customerService.addCustomer(email, firstName, lastName);
    }

    public IRoom getRoom(String roomNumber){
        return reservationService.getARoom(roomNumber);
    }

    public Reservation bookARoom(String customerEmail, IRoom room, Date checkInDate, Date checkOutDate){
        Customer customer = CustomerService.getInstance().getCustomer(customerEmail);
        Reservation bookRoom = ReservationService.getInstance().reserveARoom(customer, room, checkInDate, checkOutDate);
        if(customer ==null){
            return null;
        }else return reservationService.reserveARoom(customer, room, checkInDate, checkOutDate);
    }

    public Collection<Reservation> getCustomersReservation(String customerEmail){
        return reservationService.getCustomersReservation(customerEmail);
    }
    public Collection<IRoom> findARoom(Date checkInDate, Date checkOutDate){
        return reservationService.findRooms(checkInDate, checkOutDate);
    }
}
