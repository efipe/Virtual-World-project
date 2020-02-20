package VirtualWorld.Animals;

import VirtualWorld.World;

public class Fox extends Animal {
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

    @Override
    public void action() {
        int[] newPos = calculateNewCoordinates();
        if (world.getWorldMap()[newPos[0]][newPos[1]] != null) {
            while (world.getWorldMap()[newPos[0]][newPos[1]].getInitiative() > initiative){
                newPos = calculateNewCoordinates();
            }
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
    public void reproduction(int[] collisionPos) {
        Fox newBorn = new Fox(super.calculateNewCoordinates(), world);
        world.getTempList().add(newBorn);
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
