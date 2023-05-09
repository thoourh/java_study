package dev.sw;

public abstract class AbstractCar implements CarInterface{
    protected int velocity;

    @Override
    public void brake(){
        if(this.velocity < 0) this.velocity = 0;
    }
}
