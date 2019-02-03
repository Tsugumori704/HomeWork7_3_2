package by.itstep.vasilevskij.torch;

import by.itstep.vasilevskij.battery.Battery;
import by.itstep.vasilevskij.lamp.Lamp;

public class SimpleTorch implements Torch {

    private Battery battery;
    private Lamp lamp;

    private boolean enabled;

    public SimpleTorch(Battery battery, Lamp lamp) {
        this.battery = battery;
        this.lamp = lamp;
    }

    public boolean turnOn() {
        if (!enabled) {
            enabled = battery.getChargeBool(lamp.chargesToTornOn());
            return enabled;
        } else {
            return enabled;
        }
    }

    public void turnOff() {
        enabled = false;
    }
}
