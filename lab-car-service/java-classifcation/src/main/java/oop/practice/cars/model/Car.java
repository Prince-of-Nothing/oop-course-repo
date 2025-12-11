package main.java.oop.practice.cars.model;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Car {
    private final String id;
    private final String type;
    private final String passengerType;
    private final boolean isDining;
    private final int consumption;

    @JsonCreator
    public Car(
            @JsonProperty("id") String id,
            @JsonProperty("type") String type,
            @JsonProperty("passengers") String passengerType,
            @JsonProperty("isDining") boolean isDining,
            @JsonProperty("consumption") int consumption
    ) {

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