package dev.sw;

public class GoCart extends AbstractCar implements CarInterface { // extends = 클래스가 클래스를 상속, 인터페이스가 인터페이스 상속
    //extends는 상속받은 부모의 메서드를 재 정의 안해도 됌, implements = 클래스가 인터페이스를 상속했을때, 대신 메서드의 재정의가 꼭 필요.
    private Driver driver;


    @Override
    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    @Override
    public void accelerate() {
        this.velocity += 5;
    }

    @Override
    public void brake() {
        this.velocity -= 5; // AbstractCar 클래스의 brake 메서드를 오버라이딩 중임,
        // 즉 if(this.velocity < 0) this.velocity = 0;의 값이 입력되어있는것이나 마찬가지라는 소리
        super.brake(); // 상속의 모호성이라는 특징때문에 상속받은 부모를 나타내는 참조변수 super을 사용했음.
        // 만일 자식이 부모의 프로퍼티과 같은 이름을 가지고 있다면 그 둘을 구분하기 위해 super.을 붙이면 부모, 안붙이면 자식
    }
}
