package Course2.HW2;

public class Hufflepuff extends Hogwarts {
    private int hardworking;
    private int loyalty;
    private int honesty;

    public Hufflepuff(String name, int magicPower, int transgressionDistance, int hardworking, int loyalty, int honesty) {
        super(name, magicPower, transgressionDistance);
        this.hardworking = hardworking;
        this.loyalty = loyalty;
        this.honesty = honesty;
    }

    public String toString() {
        return getName() + "'s stats: \n1) magic power - " + getMagicPower() +
                "\n2) transgression distance - " + getTransgressionDistance() +
                "\n3) hardworking - " + getHardworking() + "\n4) loyalty - " + getLoyalty() +
                "\n5) honesty - " + getHonesty() + "\n";
    }

    public String compareWithinFaculty(Hufflepuff student) {
        if (equals(student))
            throw new IllegalArgumentException("You're trying to compare student with oneself");

        int one = getHardworking() + getLoyalty() + getHonesty();
        int another = student.getHardworking() + student.getLoyalty() + student.getHonesty();

        if (one > another)
            return getName() + " is better than " + student.getName() + " in Hufflepuff";
        if (another > one)
            return student.getName() + " is better than " + getName() + " in Hufflepuff";

        return getName() + " and " + student.getName() + " are matching";
    }

    public int getHardworking() {
        return hardworking;
    }

    public int getLoyalty() {
        return loyalty;
    }

    public int getHonesty() {
        return honesty;
    }
}
