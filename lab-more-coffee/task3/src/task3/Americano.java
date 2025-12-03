package task3;

public class Americano extends Coffee {
   
    private  final String coffeeName= "Americano";
    private int mlOfWater;
    
    public Americano makeAmericano() {
        System.out.println("Preparing a Classic Americano");
        System.out.printf("Intensity set to %s%n", getCoffeeIntensity());
        System.out.println("Coffee is being grounded");
        System.out.println("Coffee Grounds are ready");
        System.out.println("Espresso Shot was brewed to perfection");
        System.out.printf("Using %d mls of water for the coffee", mlOfWater);
        System.out.println("Espresso Shot was brewed to perfection");
        System.out.println("Dilluting the shot with water");
        System.out.println("~Your Americano is now ready to enjoy!~");
        return this;
    }

    public Americano(Intensity intensityOfCoffee, int mlOfWater) {
        super(intensityOfCoffee);
        this.mlOfWater = mlOfWater;
    }

    @Override
    public String getName(){return coffeeName;}
    public void setMlOfWater(int mlOfWater) {this.mlOfWater = mlOfWater;}

    public int getMlOfWater() {return mlOfWater;}

    @Override
    public void printCoffeeDetails() {
        intensity();
        System.out.println(getName()+" water: "+mlOfWater+" mL");
    }  

}

