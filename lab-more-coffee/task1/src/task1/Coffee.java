package task1;





public class Coffee {


    private final Intensity intensity;


    private final String name = "Coffee";





    public Coffee(Intensity intensity) {


        this.intensity = intensity;


    }





    public Intensity getCoffeeIntensity() {


        return intensity;


    }





    public void setCoffeeIntensity(Intensity coffeeIntensity) {


        this.coffeeIntensity = coffeeIntensity;


    }





    public String getName() {


        return name;


    }


}

