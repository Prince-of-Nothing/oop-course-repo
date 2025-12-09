package station;

import dining.Dineable;
import refueling.Refuelable;

public class CarServiceStation {
    private Dineable dineable;
    private Refuelable refuelable;
    private int electricCarCount = 0;
    private int dieselCarCount = 0;
    private int gasCarCount = 0;
    private int peopleCount = 0;
    private int robotCount = 0;

    public CarServiceStation(Dineable dineable, Refuelable refuelable) {
        this.dineable = dineable;
        this.refuelable = refuelable;
    }

    public void serveCar(String carId, String carType, String passengerType) {
        if (carType.equals("ELECTRIC")) {
            refuelable.refuel(carId);
            electricCarCount++;
        } else if (carType.equals("GAS")) {
            refuelable.refuel(carId);
            gasCarCount++;
        } else if (carType.equals("DIESEL")) {
            refuelable.refuel(carId);
            gasCarCount++;
        }

        if (passengerType.equals("PEOPLE")) {
            dineable.serveDinner(carId);
            peopleCount++;
        } else if (passengerType.equals("ROBOTS")) {
            dineable.serveDinner(carId);
            robotCount++;
        }
    }

    public void printStats() {
        System.out.println("Electric Cars Served: " + electricCarCount);
        System.out.println("Gas Cars Served: " + gasCarCount);
        System.out.println("People Served: " + peopleCount);
        System.out.println("Robots Served: " + robotCount);
    }
}