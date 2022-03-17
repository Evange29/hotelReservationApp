package model;

import java.util.Date;
import java.util.Objects;

public class Reservation {
    Customer customer;
    IRoom room;
    Date checkInDate;
    Date checkOutDate;

    public Reservation(Customer customer, IRoom room, Date checkInDate, Date checkOutDate) {
        this.customer = customer;
        this.room = room;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }
    public Customer getCustomer() {
        return customer;
    }

    public IRoom getRoom() {
        return room;
    }

    public Date getCheckInDate() {
        return checkInDate;
    }
    public Date getCheckOutDate() {
        return checkOutDate;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    public void setRoom(IRoom room) {
        this.room = room;
    }
    public void setCheckInDate(Date checkInDate) {
        this.checkInDate = checkInDate;
    }
    public void setCheckOutDate(Date checkOutDate) {
        this.checkOutDate = checkOutDate;
    }
    //system generated equals and hashcode methods and details from https://www.baeldung.com/java-equals-hashcode-contracts
    @Override
    public boolean equals(Object o) { //reference from https://knowledge.udacity.com/questions/703626
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reservation that = (Reservation) o;
        return Objects.equals(getCustomer(), that.getCustomer()) && Objects.equals(getRoom(), that.getRoom()) && Objects.equals(getCheckInDate(), that.getCheckInDate()) && Objects.equals(getCheckOutDate(), that.getCheckOutDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCustomer(), getRoom(), getCheckInDate(), getCheckOutDate());
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "customer details =" + customer +
                ", room number=" + room +
                ", check-in=" + checkInDate +
                ", check-out=" + checkOutDate +
                '}';
    }
}
