package VirtualWorld.Animals;

import VirtualWorld.Organism;
import VirtualWorld.World;

public abstract class Animal extends Organism implements Comparable<Organism> {

    private int strength;
    private int initiative;
    private int posX;
    private int posY;
    private int age;
    private boolean isAlive;
    private String symbol;
    private World world;


    private void action() {

    }

    private void colission() {

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

}
