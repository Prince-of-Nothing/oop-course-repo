package task3;

public class PumpkinSpiceLatte extends Cappuccino {
    private final String name= "PumpkinSpiceLatte";
    private int mgOfPumpkinSpice;
    private int mlOfMilk;

    
    public PumpkinSpiceLatte makePumpkinSpiceLatte() {
        System.out.println("Preparing a Pumpkin Spice Latte");
        makeCoffee();
        System.out.printf("Adding %d mls of milk to the steamer", mlOfMilk);
        System.out.printf("Milk  was Steamed");
        System.out.println("Combining espresso with steamed milk"); 
        System.out.printf("Mixing in %d mg of Pumpkin Spice%n",mgOfPumpkinSpice); 
        System.out.println("Adding Cinamon"); 
        System.out.println("Adding a layer of foam"); 
        System.out.println("~Your Pumpkin Spice Latte is now ready to enjoy!~");
        return this;
    }

    public PumpkinSpiceLatte(Intensity intensityOfCoffee, int mlOfMilk, int mgOfPumpkinSpice) {
        super(intensityOfCoffee, mlOfMilk);
        this.mgOfPumpkinSpice = mgOfPumpkinSpice;
        this.mlOfMilk=mlOfMilk;
    }

    public int getMgOfPumpkinSpice() {return mgOfPumpkinSpice;}

    public void setMgOfPumpkinSpice(int mgOfPumpkinSpice) {this.mgOfPumpkinSpice = mgOfPumpkinSpice;}
    
    @Override
    public int getMlOfMilk() { return mlOfMilk; }

    @Override
    public void setMlOfMilk(int mlOfMilk) { this.mlOfMilk = mlOfMilk; }

    @Override
    public String getName() {return name;}
     
    @Override
    public void printCoffeeDetails() {
        intensity();
        System.out.println(getName()+" milk: "+super.getMlOfMilk()+"mL"+" pumpkin spice: "+mgOfPumpkinSpice+" mg");
        }  
}
