package Course2.HW2;

public class Slytherin extends Hogwarts {
    private int cunning;
    private int ambition;
    private int determination;
    private int lustOfPower;
    private int inventiveness;

    public Slytherin(String name, int magicPower, int transgressionDistance, int cunning, int ambition,
                     int determination, int lustOfPower, int inventiveness) {
        super(name, magicPower, transgressionDistance);
        this.cunning = cunning;
        this.ambition = ambition;
        this.determination = determination;
        this.lustOfPower = lustOfPower;
        this.inventiveness = inventiveness;
    }

    public String toString() {
        return getName() + "'s stats: \n1) magic power - " + getMagicPower() +
                "\n2) transgression distance - " + getTransgressionDistance() +
                "\n3) cunning - " + getCunning() + "\n4) ambition - " + getAmbition() +
                "\n5) determination - " + getDetermination() + "\n6) lustOfPower - " + getLustOfPower() +
                "\n7) inventiveness - " + getInventiveness() + "\n";
    }

    public String compareWithinFaculty(Slytherin student) {
        if (equals(student))
            throw new IllegalArgumentException("You're trying to compare student with oneself");

        int one = getCunning() + getAmbition() + getDetermination() + getLustOfPower() + getInventiveness();
        int another = student.getCunning() + student.getAmbition() + student.getDetermination()
                + student.getLustOfPower() + student.getInventiveness();

        if (one > another)
            return getName() + " is better than " + student.getName() + " in Slytherin";
        else
            return student.getName() + " is better than " + getName() + " in Slytherin";

    }

    public int getCunning() {
        return cunning;
    }

    public int getAmbition() {
        return ambition;
    }

    public int getDetermination() {
        return determination;
    }

    public int getLustOfPower() {
        return lustOfPower;
    }

    public int getInventiveness() {
        return inventiveness;
    }
}
