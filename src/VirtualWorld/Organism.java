package VirtualWorld;

import java.util.SplittableRandom;

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

    public void action() {

    }


    private void colission() {

    }

    private void draw() {
    }

    public int[] calculateNewCoordinates() {
        int[] position = new int[2];
        if (getPositionXY()[0] == 0) {
            position[0] = new SplittableRandom().nextInt(getPositionXY()[0], getPositionXY()[0] + 1);
        } else if (getPositionXY()[0] == world.getColumns() - 1) {
            position[0] = new SplittableRandom().nextInt(getPositionXY()[0] - 1, getPositionXY()[0]);
        } else {
            position[0] = new SplittableRandom().nextInt(getPositionXY()[0] - 1, getPositionXY()[0] + 1);
        }

        if (getPositionXY()[1] == 0) {
            position[1] = new SplittableRandom().nextInt(getPositionXY()[1], getPositionXY()[1] + 1);
        } else if (getPositionXY()[0] == world.getRows() - 1) {
            position[1] = new SplittableRandom().nextInt(getPositionXY()[1] - 1, getPositionXY()[1]);
        } else {
            position[1] = new SplittableRandom().nextInt(getPositionXY()[1] - 1, getPositionXY()[1] + 1);
        }
        return position;
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

