package Course2.HW2;

public class Ravenclaw extends Hogwarts {
    private int intelligence;
    private int wit;
    private int wisdom;
    private int creativity;

    public Ravenclaw(String name, int magicPower, int transgressionDistance, int intelligence, int wit,
                     int wisdom, int creativity) {
        super(name, magicPower, transgressionDistance);
        this.intelligence = intelligence;
        this.wit = wit;
        this.wisdom = wisdom;
        this.creativity = creativity;
    }

    public String toString() {
        return getName() + "'s stats: \n1) magic power - " + getMagicPower() +
                "\n2) transgression distance - " + getTransgressionDistance() +
                "\n3) intelligence - " + getIntelligence() + "\n4) wit - " + getWit() +
                "\n5) wisdom - " + getWisdom() + "\n6) creativity - " + getCreativity() + "\n";
    }

    public String compareWithinFaculty(Ravenclaw student) {
        if (equals(student))
            throw new IllegalArgumentException("You're trying to compare student with oneself");

        int one = getIntelligence() + getWit() + getWisdom() + getCreativity();
        int another = student.getIntelligence() + student.getWit() + student.getWisdom()
                + student.getCreativity();

        if (one > another)
            return getName() + " is better than " + student.getName() + " in Ravenclaw";
        if (another > one)
            return student.getName() + " is better than " + getName() + " in Ravenclaw";

        return getName() + " and " + student.getName() + " are matching";
    }

    public int getIntelligence() {
        return intelligence;
    }

    public int getWit() {
        return wit;
    }

    public int getWisdom() {
        return wisdom;
    }

    public int getCreativity() {
        return creativity;
    }
}
