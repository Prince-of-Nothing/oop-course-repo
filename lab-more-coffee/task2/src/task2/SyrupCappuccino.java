package task2;

public class SyrupCappuccino extends Cappuccino {
    
    private final String coffee = "SyrupCappuccino";
    private SyrupType syrup;
    

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
        System.out.println("Coffee type: " + getName());
        System.out.println("Intensity:"+getCoffeeIntensity()+"Ingredients: Milk "+super.getMlOfMilk()+"mL"+", "+syrup+" Syrup ");
        }  
}