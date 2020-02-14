package VirtualWorld;

public abstract class Organism implements Comparable<Organism> {

    private int strength;
    private int initiative;
    private int[] positionXY;
    private String symbol;
    private int age;

    private World world;

    public Organism() {
    }

    public Organism(int strength, int initiative, int[] positionXY, World world) {
        this.strength = strength;
        this.initiative = initiative;
        this.positionXY = positionXY;
        this.world = world;
    }

    private void action() {

    }

    private void colission() {

    }

    private void draw() {
    }

    public int getAge() {
        return age;
    }

    public int getStrength() {
        return strength;
    }

    public int getInitiative() {
        return initiative;
    }

    public int[] getPositionXY() {
        return positionXY;
    }

    public void setPositionXY(int[] positionXY) {
        this.positionXY = positionXY;
    }

    public World getWorld() {
        return world;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int compareTo(Organism anotherOrganism) {
        int compareValue = 0;

        if (this.getInitiative() > anotherOrganism.getInitiative()) {
            compareValue = -1;
        } else if (this.getInitiative() < anotherOrganism.getInitiative()) {
            compareValue = 1;
        } else if (this.getInitiative() == anotherOrganism.getInitiative()) {
            if (this.getAge() > anotherOrganism.getAge()) {
                compareValue = -1;
            } else {
                compareValue = 1;
            }
        }
        return compareValue;
    }

    @Override
    public String toString() {
        return this.symbol;
    }
}

