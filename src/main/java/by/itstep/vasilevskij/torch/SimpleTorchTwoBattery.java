package by.itstep.vasilevskij.torch;

import by.itstep.vasilevskij.battery.Accumulator;
import by.itstep.vasilevskij.battery.Battery;
import by.itstep.vasilevskij.lamp.Lamp;

public class SimpleTorchTwoBattery implements Torch {
    private Battery batteryOne;
    private Battery batteryTwo;
    private Accumulator accumulatorOne;
    private Accumulator accumulatorTwo;

    private Lamp lamp;

    private boolean enabled;

    public SimpleTorchTwoBattery(Battery batteryOne, Battery batteryTwo, Lamp lamp) {
        this.batteryOne = batteryOne;
        this.batteryTwo = batteryTwo;
        this.lamp = lamp;
    }

    public SimpleTorchTwoBattery(Accumulator accumulatorOne, Accumulator accumulatorTwo, Lamp lamp) {
        this.batteryOne = accumulatorOne;
        this.batteryTwo = accumulatorTwo;
        this.accumulatorOne = accumulatorOne;
        this.accumulatorTwo = accumulatorTwo;
        this.lamp = lamp;
    }

    public boolean turnOn() {
        if (!enabled) {
            enabled = batteryOne.getChargeBool((lamp.chargesToTornOn() / 2));
            enabled = batteryTwo.getChargeBool((lamp.chargesToTornOn() / 2));
            return enabled;
        } else {
            return enabled;
        }
    }

    public Accumulator getAccumulatorOne() {
        return this.accumulatorOne;
    }

    public Accumulator getAccumulatorTwo() {
        return this.accumulatorTwo;
    }


    public void turnOff() {
        enabled = false;
    }
}
