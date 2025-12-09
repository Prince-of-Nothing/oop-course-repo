package model;

public class Car {
    private String id;
    private String type;
    private String passengerType;
    private boolean isDining;
    private int consumption;

    // Constructor with the correct parameters
    public Car(String id, String type, String passengerType, boolean isDining, int consumption) {
        this.id = id;
        this.type = type;
        this.passengerType = passengerType;
        this.isDining = isDining;
        this.consumption = consumption;
    }

    // Getters for the Car properties
    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getPassengerType() {
        return passengerType;
    }

    public boolean isDining() {
        return isDining;
    }

    public int getConsumption() {
        return consumption;
    }
}