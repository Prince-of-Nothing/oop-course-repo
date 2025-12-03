package task4.coffee;
public class Coffee {
    
    private Intensity coffeeIntensity;
    private final String name = "Coffee";

    public void makeCoffee() {
         System.out.printf("Intensity set to %s%n", getCoffeeIntensity());
        System.out.println("Coffee is being grounded");
        System.out.println("Coffee Grounds are ready");
        System.out.println("Espresso Shot was brewed to perfection");
        }

    public Coffee(Intensity coffeeIntensity) {this.coffeeIntensity = coffeeIntensity;}
    
    public Intensity getCoffeeIntensity() {return coffeeIntensity;}

    public void setCoffeeIntensity(Intensity coffeeIntensity) {this.coffeeIntensity = coffeeIntensity;}
    
    public String getName() {return name;}
    public void intensity(){System.out.println("Coffee intensity: " + getCoffeeIntensity());}
    public void printCoffeeDetails() {
        intensity();
        System.out.println("Cappucino milk: 50mg");
    }

}

