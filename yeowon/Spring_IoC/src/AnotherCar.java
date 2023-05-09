public class AnotherCar {
    private CarDriver driver;
    private int gear;
    private int velocity;

    public AnotherCar (CarDriver driver) {
        this.driver = driver;
    }

    public void setDriver(CarDriver driver) {
        this.driver = driver;
    }

    public void setGear(int gear) {
        this.gear = gear;
    }

    public void setVelocity(int velocity) {
        this.velocity = velocity;
    }

    public void accelrate() {
        this.velocity += 10;
    }

    public boolean brake() {
        if (this.velocity > 100) {
            throw new RuntimeException("too fast to hit brakes");
        }

        this.velocity += 10;
        return true;
    }
}
