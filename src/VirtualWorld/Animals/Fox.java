package VirtualWorld.Animals;

import VirtualWorld.Organism;
import VirtualWorld.World;

public class Fox extends Animal{
    private int strength;
    private int initiative;
    private int[] positionXY;
    private int age;
    private boolean isAlive;
    private String symbol;
    private World world;

    public Fox(int[] positionXY, World world) {
        this.strength = 3;
        this.initiative = 7;
        this.positionXY = positionXY;
        this.age = 0;
        this.isAlive = true;
        this.symbol = "F";
        this.world = world;
    }

    private void action() {

    }

    private void colission() {

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

    @Override
    public String toString() {
        return getSymbol();
    }

    @Override
    public int compareTo(Organism anotherOrganism) {
        return super.compareTo(anotherOrganism);
    }
}
