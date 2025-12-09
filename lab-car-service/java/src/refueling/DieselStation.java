package refueling;
public class DieselStation implements Refuelable {
    @Override
    public void refuel(String carId) {
        System.out.println("Refueling electric car " + carId + ".");
    }
}