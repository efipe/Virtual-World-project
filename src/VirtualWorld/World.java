package VirtualWorld;

import VirtualWorld.Animals.*;

import java.util.*;

public class World {

    private int mapHeight = 2;
    private int mapWidth = 2;
    private List<Organism> organismList;
    private Organism[][] worldMap;


    public World() {
    }


    private void executeRound() {

    }


    public void drawWorld() {
        worldMap = new Organism[mapHeight][mapWidth];
        int i = 0;
        for (i = 0; i < mapWidth; i++) {
            System.out.print("-");
        }
        for (i = 0; i < mapHeight; i++) {
            System.out.println();
            for (int j = 0; j < mapWidth; j++) {
                if (worldMap[i][j] == null) {
                    System.out.print('*');
                } else {
                    System.out.print(worldMap[i][j].getSymbol());
                }
            }
        }
        System.out.println();
        for (i = 0; i < mapWidth; i++) {
            System.out.print("-");
        }
    }

    public void defineWorldSize() {
        System.out.println("Welcome to the Virtual World");
        System.out.println();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Define map height: ");
        this.mapHeight = scanner.nextInt();
        System.out.println("Define map width: ");
        this.mapWidth = scanner.nextInt();
    }

    public void populateWorld() {
        worldMap = new Organism[mapHeight][mapWidth];
        organismList = Arrays.asList(
                new Turtle(checkIfPositionIsAvailable(), this),
                new Fox(checkIfPositionIsAvailable(), this),
                new Antelope(checkIfPositionIsAvailable(), this),
                new Wolf(checkIfPositionIsAvailable(), this),
                new Sheep(checkIfPositionIsAvailable(), this)
        );





        System.out.println(organismList);
        System.out.println();

        Collections.sort(organismList);

        System.out.println(organismList);
    }

    public int[] checkIfPositionIsAvailable() {
        boolean condition = false;
        int[] newCoordinates = new int[2];
        while (!condition) {
            int posX = new SplittableRandom().nextInt(1, mapWidth);
            int posY = new SplittableRandom().nextInt(1, mapHeight);
            if (worldMap[posX][posY] == null) {
                condition = true;
                newCoordinates = new int[]{posX, posY};
            }
        }
        return newCoordinates;
    }


}


