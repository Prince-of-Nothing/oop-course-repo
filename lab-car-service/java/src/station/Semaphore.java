package station;

import model.Car;
import java.util.List;

public class Semaphore {
    private CarStation electricStation;
    private CarStation gasStation;

    public Semaphore(CarStation electricStation, CarStation gasStation) {
        this.electricStation = electricStation;
        this.gasStation = gasStation;
    }

    public void serveCars(List<Car> cars) {
        for (Car car : cars) {
            if (car.getType().equals("ELECTRIC")) {
                if (car.isDining()) {
                    electricStation.addCar(car);
                } else {
                    electricStation.addCar(car);
                }
            } else if (car.getType().equals("GAS")) {
                if (car.isDining()) {
                    gasStation.addCar(car);
                } else {
                    gasStation.addCar(car);
                }
            }
        }
    }
}