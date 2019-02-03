package by.itstep.vasilevskij.torch;

import by.itstep.vasilevskij.battery.Accumulator;
import by.itstep.vasilevskij.lamp.Lamp;

public class SimpleTorchThreeAcc implements Torch {

    private Accumulator accumulatorOne;
    private Accumulator accumulatorTwo;
    private Accumulator accumulatorThree;
    private Lamp lamp;

    private boolean enabled;

    public SimpleTorchThreeAcc(Accumulator accumulatorOne, Accumulator accumulatorTwo, Accumulator accumulatorThree, Lamp lamp) {
        this.accumulatorOne = accumulatorOne;
        this.accumulatorTwo = accumulatorTwo;
        this.accumulatorThree = accumulatorThree;
        this.lamp = lamp;
    }

    public Accumulator getAccumulatorOne() {
        return accumulatorOne;
    }

    public Accumulator getAccumulatorTwo() {
        return accumulatorTwo;
    }

    public Accumulator getAccumulatorThree() {
        return accumulatorThree;
    }

    public int getAccCharge() {
        int charges;
        charges = accumulatorOne.getCharges()+ accumulatorTwo.getCharges() + accumulatorThree.getCharges();
        return charges;
    }

    @Override
    public boolean turnOn() {
        if (!enabled) {
            enabled = accumulatorOne.getChargeBool(lamp.chargesToTornOn() / 3);
            enabled = accumulatorTwo.getChargeBool(lamp.chargesToTornOn()  / 3);
            enabled = accumulatorThree.getChargeBool(lamp.chargesToTornOn() / 3);
            return enabled;
        } else {
            return enabled;
        }
    }

    @Override
    public void turnOff() {
        enabled = false;
    }
}
