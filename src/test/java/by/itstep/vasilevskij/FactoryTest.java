package by.itstep.vasilevskij;

import by.itstep.vasilevskij.TorchAndRadio.SimpleTorchAndRadio;
import by.itstep.vasilevskij.battery.Accumulator_1260;
import by.itstep.vasilevskij.lamp.LEDLamp;
import by.itstep.vasilevskij.radio.Radio;
import by.itstep.vasilevskij.torch.*;
import org.junit.Assert;
import org.junit.Test;

public class FactoryTest {

    private TorchFactory factory = new TorchFactoryEnabled();

    @Test
    public void TestTask00() throws Exception {
        Torch torch = factory.createTorch(TorchFactoryEnabled.FILAMENT_LAMP,
                TorchFactoryEnabled.CHINESE_BATTERY);

        for (int i = 0; i < 5; i++) {
            Assert.assertTrue(torch.turnOn());
            torch.turnOff();
        }
        Assert.assertFalse(torch.turnOn());
        torch.turnOff();
        Assert.assertFalse(torch.turnOn());
        torch.turnOff();

    }

    @Test
    public void TestTask01() throws Exception {
        Torch torch = factory.createTorch(TorchFactoryEnabled.FILAMENT_LAMP,
                TorchFactoryEnabled.DURACELL_BATTERY);

        for (int i = 0; i < 10; i++) {
            Assert.assertTrue(torch.turnOn());
            torch.turnOff();
        }
        Assert.assertFalse(torch.turnOn());
        torch.turnOff();
        Assert.assertFalse(torch.turnOn());
        torch.turnOff();
    }

    @Test
    public void TestTask02() throws Exception {
        AccumulatorTorch torch = factory.createAccTorch(TorchFactoryEnabled.FILAMENT_LAMP);

        for (int i = 0; i < 70; i++) {
            Assert.assertTrue(torch.turnOn());
            torch.turnOff();
        }
        Assert.assertFalse(torch.turnOn());
        torch.turnOff();
        Assert.assertFalse(torch.turnOn());
        torch.turnOff();

        Assert.assertNotNull(torch.getAccumulator());
        torch.getAccumulator().recharge();

        for (int i = 0; i < 70; i++) {
            Assert.assertTrue(torch.turnOn());
            torch.turnOff();
        }
        Assert.assertFalse(torch.turnOn());
        torch.turnOff();
        Assert.assertFalse(torch.turnOn());
        torch.turnOff();
    }

    //радио с батарейками
    @Test
    public void TestTask03_Battery() throws Exception {
        Radio radio = factory.createRadio(TorchFactoryEnabled.CHINESE_BATTERY);

        for (int i = 0; i < 7; i++) {
            Assert.assertTrue(radio.turnOn());
            radio.turnOff();
        }
        Assert.assertFalse(radio.turnOn());
        radio.turnOff();
        Assert.assertFalse(radio.turnOn());
        radio.turnOff();

    }

    //радио с аккумулятором
    @Test
    public void TestTask03_Accumulator() throws Exception {
        Radio radio = factory.createAccRadio();
        for (int i = 0; i < 105; i++) {
            Assert.assertTrue(radio.turnOn());
            radio.turnOff();
        }
        Assert.assertFalse(radio.turnOn());
        radio.turnOff();
        Assert.assertFalse(radio.turnOn());
        radio.turnOff();

        Assert.assertNotNull(radio.getAccumulator());
        radio.getAccumulator().recharge();

        for (int i = 0; i < 105; i++) {
            Assert.assertTrue(radio.turnOn());
            radio.turnOff();
        }
        Assert.assertFalse(radio.turnOn());
        radio.turnOff();
        Assert.assertFalse(radio.turnOn());
        radio.turnOff();
    }

    @Test
    public void TestTask04_Chinese_Battery() throws Exception {

        Torch torch = factory.createTorchVer2Battery(TorchFactoryEnabled.FILAMENT_LAMP, TorchFactoryEnabled.CHINESE_BATTERY);

        for (int i = 0; i < 10; i++) {
            Assert.assertTrue(torch.turnOn());
            torch.turnOff();
        }
        Assert.assertFalse(torch.turnOn());
        torch.turnOff();
        Assert.assertFalse(torch.turnOn());
        torch.turnOff();
    }

    @Test
    public void TestTask04_Duracell_Battery() throws Exception {

        Torch torch = factory.createTorchVer2Battery(TorchFactoryEnabled.FILAMENT_LAMP, TorchFactoryEnabled.DURACELL_BATTERY);

        for (int i = 0; i < 20; i++) {
            Assert.assertTrue(torch.turnOn());
            torch.turnOff();
        }
        Assert.assertFalse(torch.turnOn());
        torch.turnOff();
        Assert.assertFalse(torch.turnOn());
        torch.turnOff();
    }

    @Test
    public void TestTask04_Accumulator_Battery() throws Exception {

        Torch torch = factory.createTorchVer2Acc(TorchFactoryEnabled.FILAMENT_LAMP);

        for (int i = 0; i < 140; i++) {
            Assert.assertTrue(torch.turnOn());
            torch.turnOff();
        }
        Assert.assertFalse(torch.turnOn());
        torch.turnOff();
        Assert.assertFalse(torch.turnOn());
        torch.turnOff();

        Assert.assertNotNull(((SimpleTorchTwoBattery) torch).getAccumulatorOne());
        Assert.assertNotNull(((SimpleTorchTwoBattery) torch).getAccumulatorTwo());

        ((SimpleTorchTwoBattery) torch).getAccumulatorOne().recharge();
        ((SimpleTorchTwoBattery) torch).getAccumulatorTwo().recharge();

        for (int i = 0; i < 140; i++) {
            Assert.assertTrue(torch.turnOn());
            torch.turnOff();
        }
        Assert.assertFalse(torch.turnOn());
        torch.turnOff();
        Assert.assertFalse(torch.turnOn());
        torch.turnOff();
    }

    @Test
    public void TestTask05() throws Exception {
        SimpleTorchAndRadio produkt = factory.createTorchAndRadio(TorchFactoryEnabled.FILAMENT_LAMP);

        for (int i = 0; i < 140; i++) {
            Assert.assertTrue(produkt.TorchTurnOn());
            produkt.TorchTurnOff();
        }
        Assert.assertFalse(produkt.TorchTurnOn());
        produkt.TorchTurnOff();
        Assert.assertFalse(produkt.TorchTurnOn());
        produkt.TorchTurnOff();

        Assert.assertNotNull(produkt.getAccumulatorOne());
        produkt.getAccumulatorOne().recharge();
        Assert.assertNotNull(produkt.getAccumulatorTwo());
        produkt.getAccumulatorTwo().recharge();

        for (int i = 0; i < 140; i++) {
            Assert.assertTrue(produkt.TorchTurnOn());
            produkt.TorchTurnOff();
        }
        Assert.assertFalse(produkt.RadioTurnOn());
        produkt.RadioTurnOff();
        Assert.assertFalse(produkt.RadioTurnOn());
        produkt.RadioTurnOff();
    }

    @Test
    public void TestTusk06() throws Exception {
        SimpleTorchThreeAcc torch = factory.createTorchThreeAcc(TorchFactoryEnabled.LEDLAMP);

        for (int i = 0; i < 630; i++) {
            Assert.assertTrue(torch.turnOn());
            torch.turnOff();
        }
        Assert.assertFalse(torch.turnOn());
        torch.turnOff();
        Assert.assertFalse(torch.turnOn());
        torch.turnOff();

        Assert.assertNotNull(torch.getAccumulatorOne());
        Assert.assertNotNull(torch.getAccumulatorTwo());
        Assert.assertNotNull(torch.getAccumulatorThree());

        torch.getAccumulatorOne().recharge();
        torch.getAccumulatorTwo().recharge();
        torch.getAccumulatorThree().recharge();

        Assert.assertEquals(3780, torch.getAccCharge());

        for (int i = 0; i < 630; i++) {
            Assert.assertTrue(torch.turnOn());
            torch.turnOff();
        }
        Assert.assertFalse(torch.turnOn());
        torch.turnOff();
        Assert.assertFalse(torch.turnOn());
        torch.turnOff();
    }
}
