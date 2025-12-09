package station;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.Car;

import java.io.IOException;

/**
 * Semaphore implementation that matches the tests and Scheduler usage:
 * - Constructor: Semaphore(CarStation carStation)
 * - guideCar(String json) : parses a single car JSON, adds to CarStation queue and updates counters
 * - getCountGasCars(), getCountElectricCars(), getCarStation()
 */
public class Semaphore {
    private final CarStation carStation;
    private final ObjectMapper objectMapper = new ObjectMapper();
    private int countGasCars = 0;
    private int countElectricCars = 0;

    public Semaphore(CarStation carStation) {
        this.carStation = carStation;
    }

    /**
     * Parse the JSON describing a single Car, add it to the station queue and update counters.
     * This is the method used in SemaphoreTest.
     */
    public void guideCar(String carJson) {
        try {
            Car car = objectMapper.readValue(carJson, Car.class);
            carStation.addCar(car);

            if ("GAS".equalsIgnoreCase(car.getType())) {
                countGasCars++;
            } else if ("ELECTRIC".equalsIgnoreCase(car.getType())) {
                countElectricCars++;
            }
        } catch (IOException e) {
            // In tests and simple runs we prefer to print the error instead of throwing.
            System.err.println("Failed to parse car JSON in Semaphore.guideCar(): " + e.getMessage());
            e.printStackTrace();
        }
    }

    public int getCountGasCars() {
        return countGasCars;
    }

    public int getCountElectricCars() {
        return countElectricCars;
    }

    public CarStation getCarStation() {
        return carStation;
    }
}