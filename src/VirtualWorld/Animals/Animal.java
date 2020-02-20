package VirtualWorld.Animals;

import VirtualWorld.Organism;
import VirtualWorld.World;

public abstract class Animal extends Organism implements Comparable<Organism> {

    private int strength;
    private int initiative;
    private int[] positionXY;
    private int age;
    private boolean isAlive;
    private String symbol;
    private World world;

    @Override
    public void action() {
        int[] newPos = calculateNewCoordinates();
        if (world.getWorldMap()[newPos[0]][newPos[1]] != null) {
            colission(newPos);
        } else {
            setPositionXY(newPos);
        }
    }

    @Override
    public void colission(int[] collisionPos) {
        super.colission(collisionPos);
    }



    @Override
    public int[] calculateNewCoordinates() {
        return super.calculateNewCoordinates();
    }


    @Override
    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    @Override
    public int getInitiative() {
        return initiative;
    }

    public void setInitiative(int initiative) {
        this.initiative = initiative;
    }


    @Override
    public int getAge() {
        return age;
    }

    @Override
    public void setAge(int age) {
        this.age = age;
    }

    public boolean isAlive() {
        return isAlive;
    }

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

    public void setWorld(World world) {
        this.world = world;
    }

    @Override
    public String toString() {
        return getSymbol();
    }

    @Override
    public int[] getPositionXY() {
        return positionXY;
    }

    @Override
    public void setPositionXY(int[] positionXY) {
        this.positionXY = positionXY;
    }


}
