package refueling;

public class GasStation implements Refuelable{
    private static int gasCarsRefueled = 0;

    @Override
    public void refuel(String carID){
        System.out.println("Gas cars refueled: " + carID);
        gasCarsRefueled++;
    }

    public static int getGasCarsRefueled(){
        return gasCarsRefueled;
    }
}