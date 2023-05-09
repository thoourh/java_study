package dev.sw;

public interface CarInterface {
    void setDriver(Driver driver); //public abstract가 생략되어 있음, 인터페이스의 모든 메서드는 추상 메서드이기 때문.
    void accelerate();
    void brake();
}
