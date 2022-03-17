package model;

public class Room implements IRoom{
    public String roomNumber;
    public Double price;
    public RoomType roomType;

    public Room(String roomNumber, Double price, RoomType roomType) {
        super();
        this.roomNumber = roomNumber;
        this.price = price;
        this.roomType = roomType;
    }
    public String getRoomNumber() {
        return roomNumber;
    }
    public Double getRoomPrice() {
        return price;
    }
    public RoomType getRoomType() {
        return roomType;
    }
    public boolean isFree() {
        return false;
    }
    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    @Override
    public String toString() {
        return "Room{" +
                "room number = '" + roomNumber + '\'' +
                ", price = " + price +
                ", room type = " + roomType +
                '}';
    }
}
