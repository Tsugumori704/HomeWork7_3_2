package by.itstep.vasilevskij.battery;

public abstract class AbstractBattery implements Battery {

    private int charges;

    public AbstractBattery(int charges) {
        this.charges = charges;
    }


    public boolean getChargeBool(int charges) {
        if (charges > 0 && charges <= this.charges) {
            this.charges -= charges;
            return true;
        }
        return false;
    }

    public int getCharges() {
        return charges;
    }

    protected void setCharges(int charges){
        this.charges = charges;
    }

}
