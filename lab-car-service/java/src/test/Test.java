package test;

import dining.Dineable;
import dining.PeopleDinner;
import dining.RobotDinner;
import model.Car;
import queue.ArrayQueue;
import queue.Queue;
import refueling.ElectricStation;
import refueling.GasStation;
import refueling.Refuelable;
import station.CarStation;

public class Test {
    public static void main(String[] args) {
        // Create a queue for storing cars
        Queue<Car> carQueue = new ArrayQueue<>();  // Explicitly specify that it's a Queue of Cars

        // Create service instances
        Dineable peopleDinner = new PeopleDinner();
        Dineable robotDinner = new RobotDinner();
        Refuelable electricStation = new ElectricStation();
        Refuelable gasStation = new GasStation();

        // Create a CarStation instance
        CarStation carStation = new CarStation(peopleDinner, electricStation, carQueue);

        // Add some cars to the queue (for testing purposes)
        carStation.addCar(new Car("1", "ELECTRIC", "PEOPLE", false, 30));  // Example Car 1
        carStation.addCar(new Car("2", "GAS", "ROBOTS", true, 40));  // Example Car 2

        // Serve the cars
        carStation.serveCars();
    }
}