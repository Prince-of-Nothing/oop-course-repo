package test;

import dining.PeopleDinner;
import dining.RobotDinner;
import refueling.ElectricStation;
import refueling.GasStation;
import station.CarServiceStation;

public class Test {
    public static void main(String[] args) {
        // Create service stations
        CarServiceStation electricService = new CarServiceStation(new PeopleDinner(), new ElectricStation());
        CarServiceStation gasService = new CarServiceStation(new RobotDinner(), new GasStation());

        // Serve some cars
        electricService.serveCar("1", "ELECTRIC", "PEOPLE");
        electricService.serveCar("2", "ELECTRIC", "PEOPLE");
        gasService.serveCar("3", "GAS", "ROBOTS");
        gasService.serveCar("4", "GAS", "ROBOTS");

        // Print statistics
        electricService.printStats();
        gasService.printStats();
    }
}