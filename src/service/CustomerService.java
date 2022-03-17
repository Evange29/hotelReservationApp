package service;

import model.Customer;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class CustomerService {
    //Initialize singleton pattern to achieve static reference
    private static CustomerService customerService;

    //Constructor for Customer Service singleton class
    private CustomerService(){
    }

    //Adding the instance reference
    public static CustomerService getInstance(){
        if(customerService == null)
            customerService = new CustomerService();
        return customerService;
    }
    private Map<String, Customer> customers = new HashMap<>();

    public void addCustomer(String email, String firstName, String lastName){
        Customer aCustomer = new Customer(email, firstName, lastName);
        customers.put(aCustomer.getEmail(), aCustomer);
    }
    public Customer getCustomer(String customerEmail) {
        return customers.get(customerEmail);
    }

    public Collection<Customer> getAllCustomers (){
        for (Map.Entry<String, Customer> entry : customers.entrySet()) {
            String email = entry.getKey();
            Customer customerValue =entry.getValue();
            System.out.println("All customers= " +email+ "," +customerValue);
        }
        return null;
    }
}
