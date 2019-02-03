package by.itstep.vasilevskij;

import by.itstep.vasilevskij.TorchAndRadio.SimpleTorchAndRadio;
import by.itstep.vasilevskij.radio.SimpleRadio;
import by.itstep.vasilevskij.torch.SimpleAccTorch;
import by.itstep.vasilevskij.torch.SimpleTorch;
import by.itstep.vasilevskij.torch.SimpleTorchThreeAcc;
import by.itstep.vasilevskij.torch.SimpleTorchTwoBattery;

public interface TorchFactory {

    SimpleTorch createTorch(String lampType, String BatteryType);
    SimpleAccTorch createAccTorch(String lampType);
    SimpleRadio createRadio(String BatteryType);
    SimpleRadio createAccRadio();
    SimpleTorchTwoBattery createTorchVer2Battery(String lampType, String BatteryType);
    SimpleTorchTwoBattery createTorchVer2Acc(String lampType);
    SimpleTorchAndRadio createTorchAndRadio(String lampType);
    SimpleTorchThreeAcc createTorchThreeAcc(String lampType);
}
