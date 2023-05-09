package dev.ooae;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Road {
    private List<CarInterface> carsOnRoad;

    public Road() {
        this.carsOnRoad = new ArrayList<>();
    } //가능하면 List, 내부에서 사용할 구현체라면 상관없음

    public Road(List<CarInterface> carsOnRoad) {
        this.carsOnRoad = carsOnRoad;
    }//인자는 인터페이스 형태로 받아줌
    public void addCar(CarInterface car){
        this.carsOnRoad.add(car);
    }
}
