package task2;

public class Cappuccino extends Coffee {
    private  final String coffee = "Cappuccino";
    private int mlOfMilk;
   
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