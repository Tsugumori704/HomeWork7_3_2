package by.itstep.vasilevskij.radio;

import by.itstep.vasilevskij.battery.Accumulator;

public interface Radio {
    boolean turnOn();

    void turnOff();

    Accumulator getAccumulator();

}
