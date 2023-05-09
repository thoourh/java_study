import java.util.ArrayList;

public class Road {
    private ArrayList<CarInterface> carsOnRoad;

    public Road() {
        this.carsOnRoad = new ArrayList<>();
    }

    public Road(ArrayList<CarInterface> carsOnRoad) {
        this.carsOnRoad = carsOnRoad;
    }

    public void addCar(CarInterface car) {
        this.carsOnRoad.add(car);
    }
}
