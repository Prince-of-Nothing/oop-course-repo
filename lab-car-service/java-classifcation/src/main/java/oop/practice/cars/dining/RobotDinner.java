package main.java.oop.practice.cars.dining;

public class RobotDinner implements Dineable{
    private static int robotsServedCount = 0;

    @Override
    public void serveDinner(String carID){
        System.out.println("Serving dinner to robots in car " + carID);
        robotsServedCount++;
    }

    public static int getRobotsServed(){
        return robotsServedCount;
    }
}