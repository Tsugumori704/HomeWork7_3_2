package by.itstep.vasilevskij.radio;

import by.itstep.vasilevskij.battery.Accumulator;
import by.itstep.vasilevskij.battery.Battery;

public class SimpleRadio implements Radio {

    private Battery battery;
    private Accumulator accumulator;

    private boolean enabled;

    public SimpleRadio(Battery battery) {
        this.battery = battery;
    }

    public SimpleRadio(Accumulator accumulator) {
        this.battery = accumulator;
        this.accumulator = accumulator;
    }

    @Override
    public boolean turnOn() {
        if (!enabled) {
            enabled = battery.getChargeBool(chargesToTornOn());
            return enabled;
        } else {
            return enabled;
        }
    }

    @Override
    public void turnOff() {
        enabled = false;
    }

    @Override
    public Accumulator getAccumulator() {
        return this.accumulator;
    }

    /*
     * количество заряда для включения
     * но расход в два раза меньше по сравнению с лампой
     */
    private int chargesToTornOn() {
        return 12;
    }
}
