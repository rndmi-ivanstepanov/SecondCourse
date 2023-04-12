package Course2.HW2;

public class Gryffindor extends Hogwarts {
    private int bravery;
    private int honor;
    private int nobility;

    public Gryffindor(String name, int magicPower, int transgressionDistance, int bravery, int honor, int nobility) {
        super(name, magicPower, transgressionDistance);
        this.bravery = bravery;
        this.honor = honor;
        this.nobility = nobility;
    }

    public String toString() {
        return getName() + "'s stats: \n1) magic power - " + getMagicPower() +
                "\n2) transgression distance - " + getTransgressionDistance() +
                "\n3) bravery - " + getBravery() + "\n4) honor - " + getHonor() +
                "\n5) nobility - " + getNobility() + "\n";
    }

    public String compareWithinFaculty(Gryffindor student) {
        if (equals(student))
            throw new IllegalArgumentException("You're trying to compare student with oneself");

        int one = getBravery() + getHonor() + getNobility();
        int another = student.getBravery() + student.getNobility() + student.getHonor();

        if (one > another)
            return getName() + " is better than " + student.getName() + " in Gryffindor";
        if (another > one)
            return student.getName() + " is better than " + getName() + " in Gryffindor";

        return getName() + " and " + student.getName() + " are matching";
    }

    public int getBravery() {
        return bravery;
    }

    public int getHonor() {
        return honor;
    }

    public int getNobility() {
        return nobility;
    }
}
