package VirtualWorld.Animals;

import VirtualWorld.World;

import java.util.SplittableRandom;

public class Antelope extends Animal {

    private int strength;
    private int initiative;
    private int[] positionXY;
    private int age;
    private boolean isAlive;
    private String symbol;
    private World world;

    public Antelope(int[] positionXY, World world) {
        this.strength = 4;
        this.initiative = 4;
        this.positionXY = positionXY;
        this.age = 0;
        this.isAlive = true;
        this.symbol = "A";
        this.world = world;
    }

    private void action() {


    }

    private void colission() {

    }

    @Override
    public int[] calculateNewCoordinates() {
        int[] position = new int[2];
        if (getPositionXY()[0] == 0) {
            position[0] = new SplittableRandom().nextInt(getPositionXY()[0], getPositionXY()[0] + 2);
        } else if (getPositionXY()[0] == world.getColumns() - 1) {
            position[0] = new SplittableRandom().nextInt(getPositionXY()[0] - 2, getPositionXY()[0]);
        } else {
            position[0] = new SplittableRandom().nextInt(getPositionXY()[0] - 2, getPositionXY()[0] + 2);
        }

        if (getPositionXY()[1] == 0) {
            position[1] = new SplittableRandom().nextInt(getPositionXY()[1], getPositionXY()[1] + 2);
        } else if (getPositionXY()[0] == world.getRows() - 2) {
            position[1] = new SplittableRandom().nextInt(getPositionXY()[1] - 2, getPositionXY()[1]);
        } else {
            position[1] = new SplittableRandom().nextInt(getPositionXY()[1] - 2, getPositionXY()[1] + 2);
        }
        return position;
    }

    @Override
    public int getStrength() {
        return strength;
    }

    @Override
    public void setStrength(int strength) {
        this.strength = strength;
    }

    @Override
    public int getInitiative() {
        return initiative;
    }

    @Override
    public void setInitiative(int initiative) {
        this.initiative = initiative;
    }

    @Override
    public int[] getPositionXY() {
        return positionXY;
    }

    @Override
    public void setPositionXY(int[] positionXY) {
        this.positionXY = positionXY;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean isAlive() {
        return isAlive;
    }

    @Override
    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    @Override
    public String getSymbol() {
        return symbol;
    }

    @Override
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public World getWorld() {
        return world;
    }

    @Override
    public void setWorld(World world) {
        this.world = world;
    }

}
