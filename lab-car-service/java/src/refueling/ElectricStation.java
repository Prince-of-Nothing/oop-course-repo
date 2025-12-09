package refueling;
public class ElectricStation implements Refuelable {
    @Override
    public void refuel(String carId) {
        System.out.println("Refueling electric car " + carId + ".");
    }
}