package task1;

public class PumpkinSpiceLatte extends Cappuccino {
    private int mgOfPumpkinSpice;
    private final String name= "PumpkinSpiceLatte";
    private int mlOfMilk;
    public PumpkinSpiceLatte(Intensity intensityOfCoffee, int mlOfMilk, int mgOfPumpkinSpice) {
        super(intensityOfCoffee, mlOfMilk);
        this.mgOfPumpkinSpice = mgOfPumpkinSpice;
        this.mlOfMilk=mlOfMilk;
    }

    public int getMgOfPumpkinSpice() {
        return mgOfPumpkinSpice;
    }

    public void setMgOfPumpkinSpice(int mgOfPumpkinSpice) {
        this.mgOfPumpkinSpice = mgOfPumpkinSpice;
    }
    @Override
public int getMlOfMilk() { return mlOfMilk; }
@Override
public void setMlOfMilk(int mlOfMilk) { this.mlOfMilk = mlOfMilk; }

    @Override
    public String getName() {
        return name;
    }
}
