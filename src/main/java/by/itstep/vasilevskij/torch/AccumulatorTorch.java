package by.itstep.vasilevskij.torch;

import by.itstep.vasilevskij.battery.Accumulator;

public interface AccumulatorTorch  extends Torch{

    Accumulator getAccumulator();

    int getAccCharge();
}
