package VirtualWorld;

import java.util.SplittableRandom;

public abstract class Organism implements Comparable<Organism> {

    protected int strength;
    protected int initiative;
    protected int[] positionXY;
    protected String symbol;
    protected int age;
    protected boolean isAlive;
    protected World world;

    public Organism(int[] positionXY, World world) {
        this.positionXY = positionXY;
        this.age = 0;
        this.isAlive = true;
        this.world = world;
    }

    protected Organism() {
    }

    public void action() {
        int[] newPos = calculateNewCoordinates();
        if (world.getWorldMap()[newPos[0]][newPos[1]] != null) {
            colission(newPos);
        } else {
            setPositionXY(newPos);
        }
    }


    public void colission(int[] collisionPos) {
        // Todo switches!!!
        Organism organism = world.getWorldMap()[collisionPos[0]][collisionPos[1]];

        if (organism.getSymbol().equals("T")) {
            if (strength > 5) {
                organism.setAlive(false);
            }
        } else if (organism.getSymbol().equals(symbol)) {
            reproduction(collisionPos);
        } else if (organism.getSymbol().equals("A")) {
            int chanceToDodge = 50;
            int check = new SplittableRandom().nextInt(0, 101);
            if (check > chanceToDodge) {
                organism.setPositionXY(calculateNewCoordinates());
            }
        } else {
            if (strength == organism.getStrength()) {
                if (age > organism.getAge()) {
                    organism.setAlive(false);
                    setPositionXY(collisionPos);
                } else {
                    setAlive(false);
                }
            } else if (strength > organism.getStrength()) {
                organism.setAlive(false);
                setPositionXY(collisionPos);
            } else {
                setAlive(false);
            }
        }

    }

    public void reproduction(int[] collisionPos) {
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

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void setInitiative(int initiative) {
        this.initiative = initiative;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public void setWorld(World world) {
        this.world = world;
    }

}

