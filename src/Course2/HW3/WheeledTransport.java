package Course2.HW3;

public abstract class WheeledTransport implements Maintainable {
    private final String modelName;
    private final int wheelsCount;

    public WheeledTransport(String modelName, int wheelsCount) {
        this.modelName = modelName;
        this.wheelsCount = wheelsCount;
    }

    public String getModelName() {
        return modelName;
    }

    public int getWheelsCount() {
        return wheelsCount;
    }

    public void updateTyre() {
        System.out.println("Меняем резину");
    }

    public void check() {
        System.out.println("Обслуживаем " + getModelName());

        for (int i = 0; i < getWheelsCount(); i++)
            updateTyre();

        if (this instanceof Car || this instanceof Truck)
            checkEngine();

        if (this instanceof Truck)
            checkTrailer();
    }
}
