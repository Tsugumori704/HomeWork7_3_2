package by.itstep.vasilevskij.torch;

import by.itstep.vasilevskij.battery.Accumulator;
import by.itstep.vasilevskij.lamp.Lamp;

public class SimpleAccTorch extends SimpleTorch implements AccumulatorTorch {

    private Accumulator accumulator;

    public SimpleAccTorch(Accumulator accumulator, Lamp lamp) {
        super(accumulator, lamp);
        this.accumulator = accumulator;
    }

    @Override
    public Accumulator getAccumulator() {
        return accumulator;
    }

    @Override
    public int getAccCharge() {
        return accumulator.getCharges();
    }
}
