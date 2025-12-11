package main.java.oop.practice.station;

import main.java.oop.practice.cars.dining.*;
import main.java.oop.practice.cars.refueling.*;
import main.java.oop.practice.queue.*;
import main.java.oop.practice.cars.model.Car;


public class CarStation {
    private final Dineable peopleDiningService;
    private final Dineable robotDiningService;
    private final Refuelable electricRefuelingService;
    private final Refuelable gasRefuelingService;
    private final Queue<Car> queue;

    // Counters
    private int gasCars = 0;
    private int electricCars = 0;
    private int people = 0;
    private int robots = 0;
    private int dining = 0;
    private int notDining = 0;
    private int consumptionGas = 0;
    private int consumptionElectric = 0;

    public CarStation() {
        this.peopleDiningService = new PeopleDinner();
        this.robotDiningService = new RobotDinner();
        this.electricRefuelingService = new ElectricStation();
        this.gasRefuelingService = new GasStation();
        this.queue = new DynamicListQueue<>();
    }

    public void addCar(Car car) {
        queue.enqueue(car);
        System.out.println("Car with the ID " + car.getId() + " added to the queue.");
    }

    public void serveCars() {
        printSeparator();
        while (!queue.isEmpty()) {
            Car car = queue.dequeue();

            // Refuel the car based on its fuel type
            if ("GAS".equalsIgnoreCase(car.getType())) {
                gasCars++;
                consumptionGas += car.getConsumption();
                gasRefuelingService.refuel(car.getId());
            } else if ("ELECTRIC".equalsIgnoreCase(car.getType())) {
                electricCars++;
                consumptionElectric += car.getConsumption();
                electricRefuelingService.refuel(car.getId());
            }

            // Serve dinner if needed
            handleDining(car);
        }

        // Print summary after serving all cars
        printSummary();
        printSeparator();
    }

    public void handleDining(Car car) {
        if (car.isDining()) {
            dining++;
            if ("people".equalsIgnoreCase(car.getPassengerType())) {
                peopleDiningService.serveDinner(car.getId());
                people++;
            } else if ("robots".equalsIgnoreCase(car.getPassengerType())) {
                robotDiningService.serveDinner(car.getId());
                robots++;
            }
        } else {
            notDining++;
            if ("people".equalsIgnoreCase(car.getPassengerType())) {
                people++;
            } else if ("robots".equalsIgnoreCase(car.getPassengerType())) {
                robots++;
            }
        }
    }

    public void printSummary() {
        System.out.println("All cars have been served.\n" +
                "Gas cars: " + gasCars + "\n" +
                "Electric cars: " + electricCars + "\n" +
                "People served: " + people + "\n" +
                "Robots served: " + robots + "\n" +
                "Dining cars: " + dining + "\n" +
                "Not dining cars: " + notDining + "\n" +
                "Consumption (Gas): " + consumptionGas + "\n" +
                "Consumption (Electric): " + consumptionElectric);
    }

    public Queue<Car> getQueue() {
        return this.queue;
    }

    public int getGasCars() {
        return gasCars;
    }

    public int getElectricCars() {
        return electricCars;
    }



    private void printSeparator() {
        System.out.println("-----------------------------------------------------");
    }
}