package by.itstep.vasilevskij;

import by.itstep.vasilevskij.TorchAndRadio.SimpleTorchAndRadio;
import by.itstep.vasilevskij.battery.*;
import by.itstep.vasilevskij.lamp.FilamentLamp;
import by.itstep.vasilevskij.lamp.LEDLamp;
import by.itstep.vasilevskij.lamp.Lamp;
import by.itstep.vasilevskij.radio.SimpleRadio;
import by.itstep.vasilevskij.torch.SimpleAccTorch;
import by.itstep.vasilevskij.torch.SimpleTorch;
import by.itstep.vasilevskij.torch.SimpleTorchThreeAcc;
import by.itstep.vasilevskij.torch.SimpleTorchTwoBattery;

public class TorchFactoryEnabled implements TorchFactory {

    //battery
    public static final String CHINESE_BATTERY = "c_battery";
    public static final String DURACELL_BATTERY = "d_battery";

    //lamps
    public static final String FILAMENT_LAMP = "f_lamp";
    public static final String LEDLAMP = "LED_lamp";

    @Override
    public SimpleTorch createTorch(String lampType, String BatteryType) {
        Lamp lamp = getLamp(lampType);
        Battery battery = getBattery(BatteryType);
        if (lamp != null && battery != null) {
            return new SimpleTorch(battery, lamp);
        }
        return null;
    }

    public SimpleAccTorch createAccTorch(String lampType) {
        Lamp lamp = getLamp(lampType);
        if (lamp != null) {
            return new SimpleAccTorch(new Accumulator_1260(), lamp);
        }
        return null;
    }

    @Override
    public SimpleRadio createRadio(String BatteryType) {
        Battery battery = getBattery(BatteryType);
        if (battery != null) {
            return new SimpleRadio(battery);
        }
        return null;
    }

    @Override
    public SimpleRadio createAccRadio() {
        return new SimpleRadio(new Accumulator_1260());
    }

    @Override
    public SimpleTorchTwoBattery createTorchVer2Battery(String lampType, String BatteryType) {
        Lamp lamp = getLamp(lampType);
        Battery batteryOne = getBattery(BatteryType);
        Battery batteryTwo = getBattery(BatteryType);
        if (lamp != null && batteryOne != null && batteryTwo != null) {
            return new SimpleTorchTwoBattery(batteryOne, batteryTwo, lamp);
        }
        return null;
    }

    @Override
    public SimpleTorchTwoBattery createTorchVer2Acc(String lampType) {
        Lamp lamp = getLamp(lampType);
        if (lamp != null) {
            return new SimpleTorchTwoBattery(new Accumulator_1260(), new Accumulator_1260(), lamp);
        }
        return null;
    }

    @Override
    public SimpleTorchAndRadio createTorchAndRadio(String lampType) {
        Lamp lamp = getLamp(lampType);
        if (lamp != null) {
            return new SimpleTorchAndRadio(new Accumulator_1260(), new Accumulator_1260(), lamp);
        }
        return null;
    }

    @Override
    public SimpleTorchThreeAcc createTorchThreeAcc(String lampType) {
        Lamp lamp = getLamp(lampType);
        if (lamp != null) {
            return new SimpleTorchThreeAcc(new Accumulator_1260(), new Accumulator_1260(),new Accumulator_1260(), lamp);
        }return null;
    }


    private Battery getBattery(String batteryType) {
        switch (batteryType) {
            case CHINESE_BATTERY:
                return new ChineseBattery();
            case DURACELL_BATTERY:
                return new DuracellBattery();
            default:
                return null;
        }
    }

    private Lamp getLamp(String lightType) {
        switch (lightType) {
            case FILAMENT_LAMP:
                return new FilamentLamp();
            case LEDLAMP:
                return new LEDLamp();
            default:
                return null;
        }
    }
}
