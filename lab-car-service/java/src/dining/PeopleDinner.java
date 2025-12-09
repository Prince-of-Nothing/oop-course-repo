package dining;

public class PeopleDinner implements Dineable {
    @Override
    public void serveDinner(String carId) {
        System.out.println("Serving dinner to people in car " + carId + ".");
    }
}