package course2.hw3;

public class Bicycle extends WheeledTransport {

    public Bicycle(String modelName, int wheelsCount) {
        super(modelName, wheelsCount);
    }

    public void check() {
        commonCheck();
    }
}
