package course2.hw3;

public class Car extends WheeledTransport implements EngineService {

    public Car(String modelName, int wheelsCount) {
        super(modelName, wheelsCount);
    }

    public void checkEngine() {
        System.out.println("Проверяем двигатель");
    }

    public void check() {
        commonCheck();
        checkEngine();
    }
}
