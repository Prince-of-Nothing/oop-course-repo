package station.src.station;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.Car;

import java.io.IOException;

public class Semaphore {
    private final CarStation carStation;
    private final ObjectMapper objectMapper = new ObjectMapper();
    private int countGasCars = 0;
    private int countElectricCars = 0;

    public Semaphore(CarStation carStation) {
        this.carStation = carStation;
    }
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