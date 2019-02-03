package by.itstep.vasilevskij.TorchAndRadio;

import by.itstep.vasilevskij.battery.Accumulator;
import by.itstep.vasilevskij.lamp.Lamp;

public class SimpleTorchAndRadio implements TorchAndRadio {

    private Accumulator accumulatorOne;
    private Accumulator accumulatorTwo;

    private Lamp lamp;

    private boolean enabledRadio;
    private boolean enabledTorch;

    public SimpleTorchAndRadio(Accumulator batteryOne, Accumulator batteryTwo, Lamp lamp) {
        this.accumulatorOne = batteryOne;
        this.accumulatorTwo = batteryTwo;
        this.lamp = lamp;
    }

    @Override
    public Accumulator getAccumulatorOne() {
        return accumulatorOne;
    }

    @Override
    public Accumulator getAccumulatorTwo() {
        return accumulatorTwo;
    }

    @Override
    public boolean TorchTurnOn() {
        if (!enabledTorch) {
            enabledTorch = accumulatorOne.getChargeBool((lamp.chargesToTornOn() / 2));
            enabledTorch = accumulatorTwo.getChargeBool((lamp.chargesToTornOn() / 2));
            return enabledTorch;
        } else {
            return enabledTorch;
        }
    }

    @Override
    public void TorchTurnOff() {
        this.enabledTorch = false;
    }

    @Override
    public boolean RadioTurnOn() {
        if (!enabledRadio) {
            enabledRadio = accumulatorOne.getChargeBool((chargesToRadioTornOn() / 2));
            enabledRadio = accumulatorTwo.getChargeBool((chargesToRadioTornOn() / 2));
            return enabledRadio;
        } else {
            return enabledRadio;
        }
    }

    @Override
    public void RadioTurnOff() {
        this.enabledRadio = false;
    }

    private int chargesToRadioTornOn() {
        return 20;
    }
}
