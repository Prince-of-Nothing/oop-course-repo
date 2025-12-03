package task4.coffee;

public class SyrupCappuccino extends Cappuccino {
    
    private final String coffee = "SyrupCappuccino";
    private SyrupType syrup;

    public SyrupCappuccino makeSyrupCappucino() {
        System.out.println("Preparing a Syrup Cappucino");
        System.out.printf("Intensity set to %s%n", getCoffeeIntensity());
        System.out.println("Coffee is being grounded");
        System.out.println("Coffee Grounds are ready");
        System.out.println("Espresso Shot was brewed to perfection");
        System.out.printf("Adding Syrup with %s flavor to the cup%n", syrup);
        System.out.printf("Adding %d mls of milk to the steamer", super.getMlOfMilk());
        System.out.printf("Milk  was Steamed");
        System.out.println("Combining espresso with steamed milk in syroped cup"); 
        System.out.printf("Topped with foam and a hint of %s syrup%n", syrup);
        System.out.println("~Your Syrup Cappucino is now ready to enjoy!~");
        return this;
    }
    public SyrupCappuccino(Intensity intensityCoffee, int mltrOfMilk, SyrupType syrup) {
        super(intensityCoffee, mltrOfMilk);
        this.syrup = syrup;
    }
    public void setSyrup(SyrupType syrup) {this.syrup = syrup;}

    public SyrupType getSyrup() {return syrup;}

    public String getCoffee() {return coffee;}

    @Override
    public String getName(){return coffee;}

    @Override
    public void printCoffeeDetails() {
        intensity();
        System.out.println(syrup+" "+getName()+" milk: "+super.getMlOfMilk()+" mL");
        }  
}