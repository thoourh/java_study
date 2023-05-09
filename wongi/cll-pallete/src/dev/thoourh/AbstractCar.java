package dev.thoourh;

public class AbstractCar implements CarInterface{
    protected int velocity = 0;


    @Override
    public void setDriver(Driver driver) {

    }

    @Override
    public void accelerate() {

    }

    @Override
    public void brake() {
        if (this.velocity < 0) this.velocity = 0;
    }
}
