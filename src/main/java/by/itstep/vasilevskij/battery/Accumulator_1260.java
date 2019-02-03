package by.itstep.vasilevskij.battery;

public class Accumulator_1260 extends AbstractBattery implements Accumulator {

    private int capacity;


    public Accumulator_1260() {
        super(1260);
        this.capacity = getCharges();
    }

    @Override
    public void recharge() {
        setCharges(capacity);
    }
}
