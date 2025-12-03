package task4.coffee;

public class Cappuccino extends Coffee {
    private  final String coffee = "Cappuccino";
    private int mlOfMilk;
   public Cappuccino makeCappucino() {
        System.out.println("Preparing a Classic Cappuccino");
        System.out.printf("Intensity set to %s%n", getCoffeeIntensity());
        System.out.println("Coffee is being grounded");
        System.out.println("Coffee Grounds are ready");
        System.out.println("Espresso Shot was brewed to perfection");
        System.out.printf("Adding %d mls of milk to the steamer", mlOfMilk);
        System.out.printf("Milk  was Steamed");
        System.out.println("Combining espresso with steamed milk and adding a layer of foam");
        System.out.println("~Your Cappuccino is now ready to enjoy!~");
        return this;
    }
    public Cappuccino(Intensity intensity, int mlOfMilk) {
        super(intensity);
        this.mlOfMilk = mlOfMilk;
    }
    public void setMlOfMilk(int mlOfMilk) {this.mlOfMilk = mlOfMilk;}
    public int getMlOfMilk() {return mlOfMilk;}

    @Override
    public String getName(){return coffee;}

        @Override
    public void printCoffeeDetails() {
        intensity();
        System.out.println(getName()+" milk: "+ mlOfMilk+" mL");
    }
}