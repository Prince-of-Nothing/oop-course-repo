package task2;

public class Americano extends Coffee {
   
    private  final String coffeeName= "Americano";
    private int mlOfWater;
    

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

