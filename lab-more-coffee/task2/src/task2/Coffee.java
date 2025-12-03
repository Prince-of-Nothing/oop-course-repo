package task2;
public class Coffee {
    
    private Intensity coffeeIntensity;
    private final String name = "Coffee";

    public Coffee(Intensity coffeeIntensity) {this.coffeeIntensity = coffeeIntensity;}
    
    public Intensity getCoffeeIntensity() {return coffeeIntensity;}

    public void setCoffeeIntensity(Intensity coffeeIntensity) {this.coffeeIntensity = coffeeIntensity;}
    
    public String getName() {return name;}
    public void intensity(){System.out.println("Coffee intensity: " + getCoffeeIntensity());}
    public void printCoffeeDetails() {
        intensity();
    }

}

