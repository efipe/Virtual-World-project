import VirtualWorld.World;

public class Main {

    public static void main(String[] args) {
        World world = new World();
        world.defineWorldSize();
        world.drawWorld();
        world.populateWorld();

    }
}
