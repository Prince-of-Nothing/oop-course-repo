package station;

import dining.Dineable;
import refueling.Refuelable;
import queue.Queue;
import model.Car;

public class CarStation {
    private Dineable diningService;
    private Refuelable refuelingService;
    private Queue<Car> queue;

    // Constructor to inject dependencies
    public CarStation(Dineable diningService, Refuelable refuelingService, Queue<Car> queue) {
        this.diningService = diningService;
        this.refuelingService = refuelingService;
        this.queue = queue;
    }

    // Method to serve cars
    public void serveCars() {
        while (!queue.isEmpty()) {
            Car car = queue.dequeue();
            System.out.println("Serving car " + car.getId());

            // Serve dinner if needed
            if (car.getPassengerType().equals("PEOPLE")) {
                diningService.serveDinner(car.getId());
            } else if (car.getPassengerType().equals("ROBOTS")) {
                diningService.serveDinner(car.getId());
            }

            // Refuel the car
            if (car.getType().equals("ELECTRIC")) {
                refuelingService.refuel(car.getId());
            } else if (car.getType().equals("GAS")) {
                refuelingService.refuel(car.getId());
            }
        }
    }

    // Method to add cars to the queue
    public void addCar(Car car) {
        queue.enqueue(car);
    }
}