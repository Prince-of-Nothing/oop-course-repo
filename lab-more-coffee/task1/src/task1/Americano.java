package task1;

public class Americano extends Coffee {
    private int mlOfWater;
    private static final String name = "Americano";

    public Americano(Intensity intensity, int mlOfWater) {
        super(intensity);
        this.mlOfWater = mlOfWater;
    }
    public String getName(){


        return name;

    }
    public int getMlOfWater() {
        return mlOfWater;
    }

    public void setMlOfWater(int mlOfWater) {
        this.mlOfWater = mlOfWater;
    }
}
