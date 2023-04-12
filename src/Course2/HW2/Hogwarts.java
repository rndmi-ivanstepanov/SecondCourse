package Course2.HW2;

import java.util.Objects;

public class Hogwarts {
    private String name;
    private int magicPower;
    private int transgressionDistance;

    public Hogwarts(String name, int magicPower, int transgressionDistance) {
        this.name = name;
        this.magicPower = magicPower;
        this.transgressionDistance = transgressionDistance;
    }

    public String compareWithAny(Hogwarts student) {
        int one = getMagicPower() + getTransgressionDistance();
        int another = student.getMagicPower() + student.getTransgressionDistance();

        if (one > another)
            return getName() + " is better than " + student.getName() + " in Hogwarts";
        else
            return student.getName() + " is better than " + getName() + " in Hogwarts";
    }

    public int getMagicPower() {
        return magicPower;
    }

    public int getTransgressionDistance() {
        return transgressionDistance;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hogwarts hogwarts = (Hogwarts) o;
        return Objects.equals(name, hogwarts.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
