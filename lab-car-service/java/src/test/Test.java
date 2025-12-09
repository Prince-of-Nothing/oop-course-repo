package test;

import dining.*;
import refueling.*;
import station.*;
import model.Car;
import queue.*;
import station.Semaphore;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;


public class Test {

    @Test
    public void testGasCarsAreServedByGasStation() {
        CarStation electricStation = new CarStation(new ElectricStation(), new PeopleDinner(), new ArrayQueue<>());
        CarStation gasStation = new CarStation(new GasStation(), new RobotDinner(), new ArrayQueue<>());

        Semaphore semaphore = new Semaphore(electricStation, gasStation);

        // Simulate input from generator (gas cars only)
        Car gasCar1 = new Car("1", "GAS", "PEOPLE", true, 50);
        Car gasCar2 = new Car("2", "GAS", "ROBOTS", false, 43);

        semaphore.serveCars(Arrays.asList(gasCar1, gasCar2));

        // Test that cars are served correctly (GasStation serves Gas cars)
        assertEquals(0, electricStation.getQueue().size());  // Electric station should have no cars
        assertEquals(2, gasStation.getQueue().size());  // Gas station should have 2 cars

    }
    @Test
    public void testElectricCarsAreServedByElectricStation() {
        CarStation electricStation = new CarStation(new ElectricStation(), new PeopleDinner(), new ArrayQueue<>());
        CarStation gasStation = new CarStation(new GasStation(), new RobotDinner(), new ArrayQueue<>());

        Semaphore semaphore = new Semaphore(electricStation, gasStation);

        // Simulate input from generator (electric cars only)
        Car electricCar1 = new Car("1", "ELECTRIC", "PEOPLE", true, 32);
        Car electricCar2 = new Car("2", "ELECTRIC", "ROBOTS", false, 33);

        semaphore.serveCars(Arrays.asList(electricCar1, electricCar2));

        // Test that cars are served correctly (ElectricStation serves Electric cars)
        assertEquals(2, electricStation.getQueue().size());  // Electric station should have 2 cars
        assertEquals(0, gasStation.getQueue().size());  // Gas station should have no cars

    }

}