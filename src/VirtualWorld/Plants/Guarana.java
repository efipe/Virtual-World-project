package VirtualWorld.Plants;

import VirtualWorld.World;

public class Guarana extends Plant{
    private int strength;
    private int initiative;
    private int[] positionXY;
    private int age;
    private boolean isAlive;
    private String symbol;
    private World world;

    public Guarana(int[] positionXY, World world) {
        this.strength = 0;
        this.initiative = 0;
        this.positionXY = positionXY;
        this.age = 0;
        this.isAlive = true;
        this.symbol = "gn";
        this.world = world;
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


}
