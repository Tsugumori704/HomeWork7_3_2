package by.itstep.vasilevskij.TorchAndRadio;

import by.itstep.vasilevskij.battery.Accumulator;

public interface TorchAndRadio{

    Accumulator getAccumulatorOne();

    Accumulator getAccumulatorTwo();

    boolean TorchTurnOn();

    void TorchTurnOff();

    boolean RadioTurnOn();

    void RadioTurnOff();
}
