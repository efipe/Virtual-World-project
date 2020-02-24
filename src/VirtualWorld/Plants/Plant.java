package VirtualWorld.Plants;

import VirtualWorld.Organism;

import java.util.SplittableRandom;

public abstract class Plant extends Organism {


    protected Plant() {
    }

    @Override
    public void action() {
        int chanceToReproduce = 60;
        int ch = new SplittableRandom().nextInt(0, 101);
        if (ch > chanceToReproduce) {
            reproduction(positionXY);
        }
    }

    @Override
    public void colission(int[] collisionPos) {
        super.colission(collisionPos);
    }


    @Override
    public String toString() {
        return getSymbol();
    }
}
