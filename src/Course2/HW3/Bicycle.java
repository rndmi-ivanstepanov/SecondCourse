package Course2.HW3;

public class Bicycle extends WheeledTransport {

    public Bicycle(String modelName, int wheelsCount) {
        super(modelName, wheelsCount);
    }

    public void checkEngine() {
        System.out.println("У мотоцикла нет двигателя");
    }

    @Override
    public void checkTrailer() {
        System.out.println("У мотоцикла нет прицепа");
    }


}
