package api;

import model.Customer;
import model.IRoom;
import service.CustomerService;
import service.ReservationService;

import java.util.Collection;
import java.util.List;

public class AdminResource {
    private static ReservationService reservationService = ReservationService.getInstance();
    private static CustomerService customerService = CustomerService.getInstance();

    //Lazy initialization of Singleton
    private static AdminResource adminResource;

    //private constructor
    private AdminResource() {}

    //Static reference for Admin Resource class
    public static AdminResource getInstance() {
        if (adminResource == null) {
            adminResource = new AdminResource();
        }
        return adminResource;
    }
    //Because of singleton, all methods in this class to
    //return instance of the CustomerService and ReservationService classes.
    public Customer getCustomer(String email){
        return customerService.getCustomer(email);
    }

    public void addRoom(List<IRoom> rooms){
        for(IRoom room: rooms){
            reservationService.addRoom(room);
            System.out.println(room);
        }
    }
    public Collection<IRoom> getAllRooms(){
        return reservationService.getAllRooms();
    }
    public Collection<Customer>getAllCustomers(){
        return customerService.getAllCustomers();
    }
}
